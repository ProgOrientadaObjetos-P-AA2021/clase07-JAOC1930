/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete6;

/**
 *
 * @author Usuario
 */
public class Ejecutar {
    public static void main(String[] args) {
         String fileName = "hospital.txt";
        
        Hospital hospital1 = new Hospital("Caritas", 10, 300.55);
        Hospital hospital2 = new Hospital("Clínica Abendaño", 50, 1900.66);
        Hospital hospital3 = new Hospital("Solca", 30, 660.20);

        Hospital[] listaHospitales = {hospital1, hospital2, hospital3};

        ArchivoEscritura archivo = new ArchivoEscritura(fileName);

        for (int i = 0; i < listaHospitales.length; i++) {      
            archivo.establecerRegistro(listaHospitales[i]);       
            archivo.establecerSalida();
        }
        archivo.cerrarArchivo();
        
        ArchivoLectura lectura = new ArchivoLectura(fileName);
        lectura.establecerLista();
        System.out.println(lectura);
        lectura.cerrarArchivo();
    }
}
