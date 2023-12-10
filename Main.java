/*
 * Alumno: Jesús Ángel Martínez Mendoza | 22161152
 * Asignatura: Estructura de Datos
 * Docente: Dalia Silva Martínez
 * Grupo: 3SC | 13:00 - 14:00
 * Semestre: 3ro | AGO - DIC 2023
 */


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        //Obtener el Árbol Binario
        ArbolBalanceado arbol = ObtencionDatos.procesarDatos();
        char opc = 'Y';

        System.out.println("===========================================================================");
        System.out.println("ACCEDER A UN OBJETO USANDO UN ÁRBOL BINARIO...");

        //Buscar el Elementos
        do{
            System.out.println("-----------------------------------------------------");
            System.out.print("\tDigite la clave del elemento a buscar: "); String  claveString = entrada.nextLine();
                int ind = claveString.hashCode();  //Convertir la entrada a int
            try{
                NodoAvl nodo = arbol.buscar(ind);  //Buscar el Nodo
                int maxIntentos = 10;  
                //En caso de alguna colisión provocada buscarla
                for (int contador = 0; nodo == null && contador < maxIntentos; contador++) {
                    nodo = arbol.buscar(ind++);
                }

                if (nodo != null) {
                    imprimirDato(ObtencionDatos.consultar(nodo.getPosicion()));
                } else {
                    System.out.println("\tEl elemento no ha sido encontrado");
                }

            }
            catch(Exception e){
                System.out.println("\tError al buscar el dato");
            }

            System.out.print("Realizar otra busqueda (Y/n): "); opc = entrada.next().charAt(0);
            entrada.nextLine();
        }while(opc != 'N' && opc != 'n');
        
        System.out.println("===========================================================================");
        entrada.close();
    }
    public static void imprimirDato(Dato d) {
        System.out.println("Información del Dato:");
        System.out.printf("%-20s: %-20s%n", "Nombre Municipio", d.getNombre_municipio());
        System.out.printf("%-20s: %-20s%n", "Nombre Localidad", d.getNombre_localidad());
        System.out.printf("%-20s: %-10d%n", "Población Masculina", d.getPoblacion_mas());
        System.out.printf("%-20s: %-10d%n", "Población Femenina", d.getPoblacion_fem());
        System.out.printf("%-20s: %-20s%n", "Latitud", d.getLatitud());
        System.out.printf("%-20s: %-20s%n", "Longitud", d.getLongitud());
        System.out.println("-----------------------------------------------------");
    }    
}
