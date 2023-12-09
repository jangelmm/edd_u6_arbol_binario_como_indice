/*
 * Alumno: Jesús Ángel Martínez Mendoza | 22161152
 * Asignatura: Estructura de Datos
 * Docente: Dalia Silva Martínez
 * Grupo: 3SC | 13:00 - 14:00
 * Semestre: 3ro | AGO - DIC 2023
 */

import java.io.*;

public class ObtencionDatos {
    public static ArbolBalanceado procesarDatos() throws IOException {

        //Creo el Árbol Balanceado
        ArbolBalanceado arbol = new ArbolBalanceado();

        String str;
        // Configura el archivo CSV y el flujo
        File archivoEntrada = new File("conjunto_de_datos_iter_20CSV20.csv");
        FileReader lectorArchivo;
        BufferedReader lectorBuf;

        try {
            lectorArchivo = new FileReader(archivoEntrada);
            lectorBuf = new BufferedReader(lectorArchivo);
        } catch (FileNotFoundException e) {
            // Manejo de la excepción cuando el archivo no se encuentra
            System.out.println("\n\tERROR: No se encontró el archivo de la Base de datos");
            throw e; // Relanzar la excepción para indicar el problema al código que llama
        }

        // Configura el archivo binario y el flujo
        File archivoSalida = new File("Datos.dat");
        RandomAccessFile raf = new RandomAccessFile(archivoSalida, "rw");

        try {
            // Leemos los datos en forma de String y escribimos en el archivo binario
            for (int i = 0; i < 11857; i++) { //11857
                str = lectorBuf.readLine();

                String[] palabras = str.split(",");
                String nombre_localidad = palabras[5];
                String nombre_municipio = palabras[3];

                int poblacion_fem = tryParseInt(palabras[10]);
                int poblacion_mas = tryParseInt(palabras[11]);

                String latitud = palabras[7];
                String longitud = palabras[6];

                // Crear la clave combinando algunos valores
                String claveString = nombre_municipio.charAt(0)  + "" + nombre_localidad.charAt(0) + "" + obtenerUltimoDigito(poblacion_mas + poblacion_fem) + "" + obtenerUltimoCaracter(latitud, 6) + "" + obtenerUltimoCaracter(longitud, 6);
                //System.out.println(claveString);
                // Convertir la clave a un número entero
                int claveInt = claveString.hashCode();
                //System.out.println(claveInt);

                Dato d = new Dato(nombre_localidad, nombre_municipio, poblacion_fem, poblacion_mas, latitud, longitud);

                long pos = raf.getFilePointer();

                arbol.insertar(claveInt, (int) pos);


                // Escribe en el archivo binario
                raf.writeUTF(d.getNombre_localidad());
                raf.writeUTF(d.getNombre_municipio());
                raf.writeInt(d.getPoblacion_fem());
                raf.writeInt(d.getPoblacion_mas());
                raf.writeUTF(d.getLatitud());
                raf.writeUTF(d.getLongitud());
                
            }
        } catch (IOException e) {
            // Manejo de excepciones de E/S
            System.out.println("\n\tERROR: Error de entrada/salida durante el procesamiento de datos");
            raf.close();
            throw e;
        } finally {
            // Cerrar los flujos en el bloque finally para garantizar que se cierren incluso si ocurre una excepción
            try {
                lectorBuf.close();
            } catch (IOException e) {
                // Manejar cualquier error al cerrar los flujos, si ocurre
                e.printStackTrace();
            }
        }

        raf.close();

        return arbol;
    }

    // Método de utilidad para intentar parsear un entero desde una cadena
    private static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Manejo de la excepción si la conversión no es posible
            return 0; // Otra opción podría ser lanzar una excepción aquí si lo prefieres
        }
    }
    public static Dato consultar(int posicion) throws IOException {
        // Configura el archivo binario y el flujo
        File archivo = new File("Datos.dat");
        RandomAccessFile raf = new RandomAccessFile(archivo, "r");
    
        try {
            // Mueve el puntero a la posición especificada
            raf.seek(posicion);
    
            // Lee los datos y crea un objeto Dato
            String nombre_localidad = raf.readUTF();
            String nombre_municipio = raf.readUTF();
            int poblacion_fem = raf.readInt();
            int poblacion_mas = raf.readInt();
    
            // No es necesario ajustar el puntero aquí
    
            String latitud = raf.readUTF();
            String longitud = raf.readUTF();
    
            return new Dato(nombre_localidad, nombre_municipio, poblacion_fem, poblacion_mas, latitud, longitud);
        } finally {
            // Cierra el flujo
            raf.close();
        }
    }
    private static int obtenerUltimoDigito(int numero) {
        // Convierte el número a una cadena y obtiene el último carácter como valor numérico
        try {
            String numeroComoString = Integer.toString(numero);
            char ultimoDigitoChar = numeroComoString.charAt(numeroComoString.length() - 1);
            return Character.getNumericValue(ultimoDigitoChar);
        } catch (Exception e) {
            // En caso de error, por ejemplo, si el número es 0, retorna 0
            return 7;
        }
    }    
    private static char obtenerUltimoCaracter(String dato, int pos){
        try{
            return dato.charAt(dato.length() - pos);
        }
        catch(Exception e){
            return 'x';
        }
    }
}