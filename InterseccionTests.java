public class InterseccionTests 
{
    @Test
    public void cambiarSemaforoDeberiaCambiarCorrectamente()
    {
        Calle c1 = new Calle("Avenida Italia", "Verde");
        Calle c2 = new Calle("Garibaldi", "Rojo");
        Interseccion interseccion = new Interseccion(c1, c2);

        interseccion.cambiarSemaforo();

        assertEquals("amarillo", c1.semaforo.toLowerCase());
        assertEquals("rojo", c2.semaforo.toLowerCase());
    }

    @Test 
    public void ejecutarMovimientoDeberiaEjecutarCorrectamente()
    {
        Calle c1 = new Calle("Avenida Italia", "Verde");
        Calle c2 = new Calle("Garibaldi", "Rojo");
        Vehiculo v1 = new Vehiculo("ABC-1234", "Auto", 10);
        Vehiculo v2 = new Vehiculo("CBC-4214", "Bus", 7);
        
        Interseccion interseccion = new Interseccion(c1, c2);

        c1.incorporarVehiculo(v1); 
        c2.incorporarVehiculo(v2);

        interseccion.ejecutarMovimiento(); // Como la calle 1 está en verde, hace poll y la cola queda vacía. La cola 2 no va a estar vacía porque está en rojo.

        assertTrue(c1.cola.isEmpty());
        assertFalse(c2.cola.isEmpty());
    }
}