package ucu.edu.aed.tda;

/**
 * Nodo para listas enlazadas simples.
 * Contiene un dato y una referencia al siguiente nodo.
 */
public class TDANodo<T> {
    private T dato;
    private TDANodo<T> siguiente;

    /**
     * Constructor que inicializa el nodo con un dato.
     *
     * @param dato el elemento a almacenar
     */
    public TDANodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Obtiene el dato del nodo.
     *
     * @return el dato almacenado
     */
    public T getDato() {
        return this.dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return el siguiente nodo o null
     */
    public TDANodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     * Establece el dato del nodo.
     *
     * @param dato el nuevo dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Establece la referencia al siguiente nodo.
     *
     * @param siguiente el siguiente nodo
     */
    public void setSiguiente(TDANodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
