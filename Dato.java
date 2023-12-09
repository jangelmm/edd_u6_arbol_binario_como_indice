/*
 * Alumno: Jesús Ángel Martínez Mendoza | 22161152
 * Asignatura: Estructura de Datos
 * Docente: Dalia Silva Martínez
 * Grupo: 3SC | 13:00 - 14:00
 * Semestre: 3ro | AGO - DIC 2023
 */

public class Dato{
    private String nombre_localidad;
    private String nombre_municipio;
    private int poblacion_fem;
    private int poblacion_mas;
    private String latitud;
    private String longitud;

    public Dato(String nombre_localidad, String nombre_municipio, int poblacion_fem, int poblacion_mas, String latitud, String longitud) {
        this.nombre_localidad = nombre_localidad;
        this.nombre_municipio = nombre_municipio;
        this.poblacion_fem = poblacion_fem;
        this.poblacion_mas = poblacion_mas;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre_localidad() {
        return nombre_localidad;
    }

    public void setNombre_localidad(String nombre_localidad) {
        this.nombre_localidad = nombre_localidad;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public int getPoblacion_fem() {
        return poblacion_fem;
    }

    public void setPoblacion_fem(int poblacion_fem) {
        this.poblacion_fem = poblacion_fem;
    }

    public int getPoblacion_mas() {
        return poblacion_mas;
    }

    public void setPoblacion_mas(int poblacion_mas) {
        this.poblacion_mas = poblacion_mas;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}