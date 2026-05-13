package ucu.edu.aed.app;

import ucu.edu.aed.tda.ColaCircular;
import ucu.edu.aed.tda.TDACola;

public class Calle 
{
    public String nombre;
    public TDACola<Vehiculo> cola;
    public String semaforo;

    public Calle(String nombre, String semaforo)
    {
        this.nombre = nombre; 
        this.semaforo = semaforo; 
        this.cola = new ColaCircular<>();
    }

    public void incorporarVehiculo(Vehiculo vehiculo)
    {
        cola.poneEnCola(vehiculo);
    }

    public void movimiento()
    {
        if (this.semaforo.toLowerCase().equals("verde"))
        {
            if (!cola.esVacio())
            {
                cola.quitaDeCola();
            }
        }
    }
    
}
