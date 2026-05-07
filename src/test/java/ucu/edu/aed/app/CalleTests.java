package ucu.edu.aed.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests para la clase Calle.
 */
public class CalleTests {

    private Calle calle;

    @Before
    public void setUp() {
        calle = new Calle("Avenida Italia", "Rojo");
    }

    @Test
    public void incorporarVehiculoDeberiaIncorporarCorrectamente() {
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Auto", 10);

        calle.incorporarVehiculo(vehiculo);

        assertFalse("La cola no debería estar vacía", calle.cola.esVacio());
        assertEquals("El tamaño de la cola debería ser 1", 1, calle.cola.tamaño());
    }

    @Test
    public void incorporarMultiplesVehiculosDeberia() {
        Vehiculo v1 = new Vehiculo("ABC-1234", "Auto", 10);
        Vehiculo v2 = new Vehiculo("XYZ-5678", "Bus", 15);
        Vehiculo v3 = new Vehiculo("DEF-9012", "Moto", 5);

        calle.incorporarVehiculo(v1);
        calle.incorporarVehiculo(v2);
        calle.incorporarVehiculo(v3);

        assertFalse("La cola no debería estar vacía", calle.cola.esVacio());
        assertEquals("El tamaño de la cola debería ser 3", 3, calle.cola.tamaño());
    }

    @Test
    public void movimientoEnRojoNoDeberemover() {
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Auto", 10);
        calle.semaforo = "Rojo";

        calle.incorporarVehiculo(vehiculo);
        int sizeAntes = calle.cola.tamaño();
        calle.movimiento();
        int sizeDespues = calle.cola.tamaño();

        assertEquals("El tamaño no debería cambiar con semáforo en rojo", sizeAntes, sizeDespues);
    }

    @Test
    public void movimientoEnVerdeDeberemover() {
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Auto", 10);
        calle.semaforo = "Verde";

        calle.incorporarVehiculo(vehiculo);
        assertEquals("La cola debería tener 1 vehículo", 1, calle.cola.tamaño());

        calle.movimiento();
        assertTrue("La cola debería estar vacía después del movimiento", calle.cola.esVacio());
    }

    @Test
    public void movimientoEnAmarilloNoDeberemover() {
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Auto", 10);
        calle.semaforo = "Amarillo";

        calle.incorporarVehiculo(vehiculo);
        calle.movimiento();

        assertFalse("La cola no debería estar vacía con semáforo en amarillo", calle.cola.esVacio());
        assertEquals("El tamaño debería seguir siendo 1", 1, calle.cola.tamaño());
    }

    @Test
    public void movimientoEnColaVaciaNoLanzaExcepcion() {
        calle.semaforo = "Verde";
        // No debería lanzar excepción
        calle.movimiento();
        assertTrue("La cola debería estar vacía", calle.cola.esVacio());
    }
}
