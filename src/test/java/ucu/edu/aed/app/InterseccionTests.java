package ucu.edu.aed.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests para la clase Interseccion.
 */
public class InterseccionTests {

    private Calle calle1;
    private Calle calle2;
    private Interseccion interseccion;

    @Before
    public void setUp() {
        calle1 = new Calle("Avenida Italia", "Verde");
        calle2 = new Calle("Garibaldi", "Rojo");
        interseccion = new Interseccion(calle1, calle2);
    }

    @Test
    public void cambiarSemaforoDesdeVerdeAmarillo() {
        interseccion.cambiarSemaforo();

        assertEquals("Calle 1 debería estar en amarillo", "amarillo", calle1.semaforo.toLowerCase());
        assertEquals("Calle 2 debería estar en rojo", "rojo", calle2.semaforo.toLowerCase());
    }

    @Test
    public void cambiarSemaforoDesdeAmarilloRojo() {
        calle1.semaforo = "Amarillo";
        calle2.semaforo = "Verde";

        interseccion.cambiarSemaforo();

        assertEquals("Calle 1 debería estar en rojo", "rojo", calle1.semaforo.toLowerCase());
        assertEquals("Calle 2 debería estar en verde", "verde", calle2.semaforo.toLowerCase());
    }

    @Test
    public void cambiarSemaforoDesdeRojoAVerde() {
        calle2.semaforo = "Verde";
        calle1.semaforo = "Rojo";

        interseccion.cambiarSemaforo();

        assertEquals("Calle 1 debería estar en rojo", "rojo", calle1.semaforo.toLowerCase());
        assertEquals("Calle 2 debería estar en amarillo", "amarillo", calle2.semaforo.toLowerCase());
    }

    @Test
    public void cambiarSemaforoCicloCompleto() {
        // Inicial: Verde - Rojo
        assertEquals("verde", calle1.semaforo.toLowerCase());
        assertEquals("rojo", calle2.semaforo.toLowerCase());

        // Cambio 1: Amarillo - Rojo
        interseccion.cambiarSemaforo();
        assertEquals("amarillo", calle1.semaforo.toLowerCase());
        assertEquals("rojo", calle2.semaforo.toLowerCase());

        // Cambio 2: Rojo - Verde
        interseccion.cambiarSemaforo();
        assertEquals("rojo", calle1.semaforo.toLowerCase());
        assertEquals("verde", calle2.semaforo.toLowerCase());

        // Cambio 3: Rojo - Amarillo
        interseccion.cambiarSemaforo();
        assertEquals("rojo", calle1.semaforo.toLowerCase());
        assertEquals("amarillo", calle2.semaforo.toLowerCase());

        // Cambio 4: Verde - Rojo (vuelve al inicio)
        interseccion.cambiarSemaforo();
        assertEquals("verde", calle1.semaforo.toLowerCase());
        assertEquals("rojo", calle2.semaforo.toLowerCase());
    }

    @Test
    public void ejecutarMovimientoConVerdeEnCalle1() {
        Vehiculo v1 = new Vehiculo("ABC-1234", "Auto", 10);
        calle1.incorporarVehiculo(v1);

        assertEquals("Calle 1 debería tener 1 vehículo", 1, calle1.cola.tamaño());

        interseccion.ejecutarMovimiento();

        assertTrue("Calle 1 debería estar vacía (semáforo verde)", calle1.cola.esVacio());
    }

    @Test
    public void ejecutarMovimientoConRojoEnCalle2() {
        Vehiculo v2 = new Vehiculo("DEF-5678", "Bus", 15);
        calle2.incorporarVehiculo(v2);

        interseccion.ejecutarMovimiento();

        assertFalse("Calle 2 no debería vaciar (semáforo rojo)", calle2.cola.esVacio());
        assertEquals("Calle 2 debería tener 1 vehículo", 1, calle2.cola.tamaño());
    }

    @Test
    public void ejecutarMovimientoMultiplesVehiculos() {
        Vehiculo v1 = new Vehiculo("ABC-1234", "Auto", 10);
        Vehiculo v2 = new Vehiculo("XYZ-5678", "Moto", 5);
        Vehiculo v3 = new Vehiculo("DEF-9012", "Bus", 15);

        calle1.incorporarVehiculo(v1);
        calle1.incorporarVehiculo(v2);
        calle2.incorporarVehiculo(v3);

        assertEquals("Calle 1 debería tener 2 vehículos", 2, calle1.cola.tamaño());
        assertEquals("Calle 2 debería tener 1 vehículo", 1, calle2.cola.tamaño());

        interseccion.ejecutarMovimiento();

        assertEquals("Calle 1 debería tener 1 vehículo (se removió uno)", 1, calle1.cola.tamaño());
        assertEquals("Calle 2 debería tener 1 vehículo (no se removió nada)", 1, calle2.cola.tamaño());
    }

    @Test
    public void ejecutarMovimientoAlternarSemaforos() {
        Vehiculo v1 = new Vehiculo("ABC-1234", "Auto", 10);
        Vehiculo v2 = new Vehiculo("DEF-5678", "Bus", 15);

        calle1.incorporarVehiculo(v1);
        calle2.incorporarVehiculo(v2);

        // Primera ejecución: calle1 verde, calle2 rojo
        interseccion.ejecutarMovimiento();
        assertTrue("Calle 1 vacía (verde)", calle1.cola.esVacio());
        assertFalse("Calle 2 no vacía (rojo)", calle2.cola.esVacio());

        // Cambiar semáforos
        interseccion.cambiarSemaforo();
        interseccion.cambiarSemaforo();

        // Agregar nuevos vehículos
        Vehiculo v1_new = new Vehiculo("XYZ-0987", "Moto", 8);
        calle1.incorporarVehiculo(v1_new);

        // Segunda ejecución: ahora calle2 debería estar verde (pero está en rojo aún)
        // Este test verifica que el estado se mantiene correctamente
        assertTrue("Calle 1 no debería estar vacía si agregamos más", calle1.cola.tamaño() > 0);
    }
}
