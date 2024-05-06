/*
 * JOSE HUMBERTO MORENO MEJIA
 * 1298798
 * ESTRUCTURAS DE DATOS 
 * EXAMEN PARCIAL II
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MAIN {
    public static void main(String[] args) throws Exception {

        Pila fila = new Pila();

        // CAMBIAR RUTA A LA DE SU DISPOSITIVO
        String ruta = "C:/Users/bonny/Desktop//S4/Estructuras de datos/EX2MMJ/src/Texto.txt";

        System.out.println("    ESTRUCTURAS DE DATOS\n         EXAMEN II\n");

        try {

            // Lectores de archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter("Invertido.txt"));
            FileReader archivo = new FileReader(ruta);
            FileReader invertido = new FileReader("Invertido.txt");
            BufferedReader lector = new BufferedReader(archivo);
            BufferedReader lector2 = new BufferedReader(invertido);

            // Cadena para guardar los caracteres del archivo
            String palabra = "";
            // caracter numerico para guardar los valores de los caracteres del archivo
            int caracter;

            System.out.println("Archivo de texto sin modificar:\n");

            // Si no existen problemas al leer el caracter entramos en el while
            while ((caracter = lector.read()) != -1) {
                System.out.print((char) caracter);

                // Filtro para tabuladores, espacios en blanco, modificaciones de puntero

                if ((char) caracter != ' ' && (char) caracter != '\t'
                        && (char) caracter != '\r') {

                    // Filtro para salto de linea, se agregan a la pila como un elemento mas

                    if ((char) caracter == '\n') {
                        fila.insertar("\n");
                    } else {

                        // filtro para signos de puntuacion
                        // (aunque el modulo del examen dice que no se añadan, en el ejemplo sí aparecen
                        // signos)

                        if ((char) caracter == '.' || (char) caracter == ',' || (char) caracter == ';'
                                || (char) caracter == ':') {

                            palabra = (char) caracter + palabra;

                        } else {
                            palabra += (char) caracter;
                        }
                    }

                    // Si ha exisitido un salto de linea o espacio en blanco se guarda la palabra y
                    // se reincia el string
                } else {
                    fila.insertar(palabra + " ");
                    palabra = "";

                }
            }

            // ASEGURAMOS QUE SE AGREGUE LA ULTIMA PALABRA
            if (caracter == -1) {
                fila.insertar(palabra + " ");
            }

            // AQUI SE COMIENZA A GRABAR EN INVERTIDO
            System.out.println("\n\nArchivo de texto invertido: \n");
            // Imprimimos y grabamos a la vez el contenido en Invertido.txt

            // mientras la fila no este vacia
            while (!fila.vacia()) {

                // si es el ultimo elemento añadir su punto y final
                if (fila.fin == fila.inicio) {
                    System.out.print(fila.fin.elemento + " ");
                } else {
                    System.out.print(fila.fin.elemento);
                }

                // Escribimos en el archivo de texto
                writer.write(fila.fin.elemento);
                // Eliminamos la cola
                fila.elimiar();
            }

            // Cerramos lectores y escritores
            writer.close();
            lector.close();
            lector2.close();
        } catch (IOException e) {
            // Mensaje de error
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();

        }

    }
}
