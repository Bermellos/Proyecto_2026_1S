public class Interseccion 
{
    public Calle calle1; 
    public Calle calle2; 

    public Interseccion(Calle calle1, Calle calle2)
    {
        this.calle1 = calle1; 
        this.calle2 = calle2; 
    }

    public void cambiarSemaforo()
    {
        if (calle1.semaforo.toLowerCase().equals("verde"))
        {
            calle2.semaforo = "rojo";
            calle1.semaforo = "amarillo";  // cambio el semaforo de la calle 1 
        }

        else if (calle1.semaforo.toLowerCase().equals("amarillo"))
        {
            calle2.semaforo = "verde";
            calle1.semaforo = "rojo";
        }

        else if (calle2.semaforo.toLowerCase().equals("verde"))
        {
            calle1.semaforo = "rojo";
            calle2.semaforo = "amarillo";
        }

        else if (calle2.semaforo.toLowerCase().equals("amarillo"))
        {
            calle1.semaforo = "verde";
            calle2.semaforo = "rojo";
        }

    }

    public void ejecutarMovimiento()
    {
        calle1.movimiento();
        calle2.movimiento(); 
    }
    
}