/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete7;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



/**
 *
 * @author Usuario
 */
public class ArchivoEscritura {

    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Hospital registroHospital;
    private ArrayList<Hospital> listaHsopital;

    public ArchivoEscritura(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaProfesores(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaProfesores().size() > 0) {
                for (int i = 0; i < obtenerListaProfesores().size(); i++) {
                    establecerRegistroProfesor(obtenerListaProfesores().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }

    public void establecerRegistroProfesor(Profesor p) {
        registroProfesor = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroProfesor); // envía el registro como 
                                                  // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // en el atributo listaProfesores obtenemos los registros 
    // del archivo
    public void establecerListaProfesores() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerProfesores();
        listaProfesores = l.obtenerProfesores();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Profesor> obtenerListaProfesores() {
        return listaProfesores;
    }

    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } // fin de catch
}
}
