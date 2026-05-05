public class CalleTests 
{
    @Test 
    public void incorporarVehiculoDeberiaIncorporarCorrectamente()
    {
        Calle calle = new Calle("Avenida italia", "Rojo");
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Auto", 10);

        calle.incorporarVehiculo(vehiculo);

        assertFalse(calle.cola.isEmpty());  // La cola no debería estar vacía
        assertEquals(1, calle.cola.size()); // El tamaño de la cola debería ser 1, tras haber agregado un vehículo
    }
    
    @Test 
    public void movimientoDeberiaMoverCorrectamente()
    {
        Calle calle = new Calle("Avenida italia", "Rojo");
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Auto", 10);

        calle.incorporarVehiculo(vehiculo);
        calle.movimiento();

        assertFalse(calle.cola.isEmpty()); // La cola no debería estar vacía
        assertEquals(1, calle.cola.size()); // El tamaño de la cola debería ser 1, tras haber agregado un vehículo
    }
}