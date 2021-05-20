/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete7;

/**
 *
 * @author Usuario
 */
public class Ejecutor {
    public static void main(String[] args) {
         String fileName = "hospital.txt";
        
        paquete6.Hospital hospital1 = new paquete6.Hospital("Caritas", 10, 300.55);
        paquete6.Hospital hospital2 = new paquete6.Hospital("Clínica Abendaño", 50, 1900.66);
        paquete6.Hospital hospital3 = new paquete6.Hospital("Solca", 30, 660.20);

        paquete6.Hospital[] listaHospitales = {hospital1, hospital2, hospital3};

        paquete6.ArchivoEscritura archivo = new paquete6.ArchivoEscritura(fileName);

        for (int i = 0; i < listaHospitales.length; i++) {      
            archivo.establecerRegistro(listaHospitales[i]);       
            archivo.establecerSalida();
        }
        archivo.cerrarArchivo();
        
        paquete6.ArchivoLectura lectura = new paquete6.ArchivoLectura(fileName);
        lectura.establecerLista();
        System.out.println(lectura);
        lectura.cerrarArchivo();
    }
}
