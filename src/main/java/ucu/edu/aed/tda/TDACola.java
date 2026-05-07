package ucu.edu.aed.tda;

/**
 * Define un Tipo de Dato Abstracto (TDA) Cola genérica.
 *
 * <p>Una cola es una estructura de datos lineal que sigue la política
 * FIFO ({@code First In, First Out}), es decir, el primer elemento en ingresar
 * es el primero en salir.</p>
 *
 * @param <T> el tipo de los elementos almacenados en la cola
 */
public interface TDACola<T> extends TDALista<T> {

    /**
     * Retorna el elemento ubicado al frente de la cola, sin removerlo.
     *
     * @return el elemento al frente de la cola
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    T frente();

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param dato el elemento a agregar
     * @return {@code true} si se agregó correctamente
     */
    boolean poneEnCola(T dato);

    /**
     * Remueve y retorna el elemento al frente de la cola.
     *
     * @return el elemento removido
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    T quitaDeCola();
}
