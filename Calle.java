import java.util.LinkedList; 
import java.util.Queue; 

public class Calle 
{
    public String nombre; // nombre de la calle 
    public Queue<Vehiculo> cola; // cola de vehiculos 
    public String semaforo; // verde, amarillo o rojo

    public Calle(String nombre, String semaforo)
    {
        this.nombre = nombre; 
        this.semaforo = semaforo; 
        this.cola = new LinkedList<>(); 
    }

    public void incorporarVehiculo(Vehiculo vehiculo)
    {
        cola.offer(vehiculo); // offer agrega el vehiculo al inicio de la cola
    }

    public void movimiento()
    {
        if (this.semaforo.toLowerCase().equals("verde"))
        {
            cola.poll(); // poll saca el vehiculo del final de la cola 
        }
    }
    
}