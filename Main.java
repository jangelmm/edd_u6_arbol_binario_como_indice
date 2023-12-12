import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {

    private ArbolBalanceado arbol;

    public Main() {
        super("Árbol Binario - Búsqueda de Elementos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Crear el Árbol Binario al iniciar la aplicación
        try {
            arbol = ObtencionDatos.procesarDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel claveLabel = new JLabel("Clave del elemento:");
        JTextField claveTextField = new JTextField(15);
        JButton buscarButton = new JButton("Buscar");
        JTextArea resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setEditable(false);

        // Agregar componentes al panel usando GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(claveLabel, gbc);

        gbc.gridx = 1;
        panel.add(claveTextField, gbc);

        gbc.gridx = 2;
        panel.add(buscarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        panel.add(new JScrollPane(resultadoTextArea), gbc);

        // Configurar el botón para realizar la búsqueda
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String claveString = claveTextField.getText();
                int ind = claveString.hashCode();

                try {
                    NodoAvl nodo = arbol.buscar(ind);

                    // En caso de alguna colisión provocada, buscarla
                    int maxIntentos = 10;
                    for (int contador = 0; nodo == null && contador < maxIntentos; contador++) {
                        nodo = arbol.buscar(ind++);
                    }

                    if (nodo != null) {
                        Dato dato = ObtencionDatos.consultar(nodo.getPosicion());
                        imprimirDato(resultadoTextArea, dato);
                    } else {
                        resultadoTextArea.setText("El elemento no ha sido encontrado");
                    }
                } catch (Exception ex) {
                    resultadoTextArea.setText("Error al buscar el dato");
                }
            }
        });

        // Agregar el panel al JFrame
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    public static void imprimirDato(JTextArea textArea, Dato d) {
        textArea.setText("Información del Dato:\n");
        textArea.append(String.format("%-20s: %-20s%n", "Nombre Municipio", d.getNombre_municipio()));
        textArea.append(String.format("%-20s: %-20s%n", "Nombre Localidad", d.getNombre_localidad()));
        textArea.append(String.format("%-20s: %-10d%n", "Población Masculina", d.getPoblacion_mas()));
        textArea.append(String.format("%-20s: %-10d%n", "Población Femenina", d.getPoblacion_fem()));
        textArea.append(String.format("%-20s: %-20s%n", "Latitud", d.getLatitud()));
        textArea.append(String.format("%-20s: %-20s%n", "Longitud", d.getLongitud()));
    }
}
