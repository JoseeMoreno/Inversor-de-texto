
public class Pila {
    public Nodo inicio;
    public Nodo fin;

    public Pila() {
        inicio = null;
    }

    public void insertar(String nombre) {
        Nodo aux = new Nodo();
        Nodo nuevo = new Nodo();
        nuevo.elemento = nombre;
        nuevo.sig = null;
        if (inicio == null) { // Primer elemento. Como acabamos de crear la lista el inicio es null
            inicio = nuevo; // Ahora iniciio tendra la direccion de memoria del primer nodo
            fin = nuevo;
        } else // Metodo facil, a partir del segundo elemento
        {
            // fin.sig=nuevo;
            // fin = nuevo;
            aux = inicio;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
            fin = nuevo;
        }
    }// Cuando salimos del metodo, la variable nuevo desaparece

    public void mostrar() {
        if (!vacia()) {
            Nodo aux = new Nodo();
            aux = inicio;
            while (aux != null) {
                System.out.print(aux.elemento);
                aux = aux.sig; // Avanzar en la lista para imprimirla
            }
        }
    }

    // SE ELIMINA LA COLA (ULTIMO ELEMENTO)
    public void elimiar() {
        if (!vacia()) {
            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                Nodo aux = new Nodo();
                aux = inicio;
                while (aux.sig != fin) {
                    aux = aux.sig;
                }
                fin = aux;
                aux = aux.sig;
                fin.sig = null;
            }
        } else {
            System.out.println("La fila esta vacia!");
        }
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }
}
