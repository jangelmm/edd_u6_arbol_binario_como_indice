/*
 * Alumno: Jesús Ángel Martínez Mendoza | 22161152
 * Asignatura: Estructura de Datos
 * Docente: Dalia Silva Martínez
 * Grupo: 3SC | 13:00 - 14:00
 * Semestre: 3ro | AGO - DIC 2023
 */

public class NodoAvl{
    private int posicion;
    private int identifi;
    private NodoAvl izquierda;
    private NodoAvl derecha;
    private int fe;

    public NodoAvl(){

    }
    public NodoAvl(int identifi, int posicion) {
        this.identifi = identifi;
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public int getIdentifi() {
        return identifi;
    }
    public void setIdentifi(int identifi) {
        this.identifi = identifi;
    }
    public NodoAvl getIzquierda() {
        return izquierda;
    }
    public void setIzquierda(NodoAvl izquierda) {
        this.izquierda = izquierda;
    }
    public NodoAvl getDerecha() {
        return derecha;
    }
    public void setDerecha(NodoAvl derecha) {
        this.derecha = derecha;
    }
    public int getFe() {
        return fe;
    }
    public void setFe(int fe) {
        this.fe = fe;
    }
}