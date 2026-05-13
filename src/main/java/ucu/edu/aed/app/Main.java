package ucu.edu.aed.app;

import java.util.Scanner; 

public class Main 
{
    public static void main(String args[])
    {

        Calle calle1 = new Calle("Avenida Italia", "Verde");
        Calle calle2 = new Calle("Garibaldi", "Rojo");

        Interseccion interseccion = new Interseccion(calle1, calle2);

        Scanner sc = new Scanner(System.in); 

        int opcion = -1; 
        
        while (opcion != 0)
        {
            System.out.println("\n--- GESTIÓN DE VEHÍCULOS ---");
            System.out.println("estado semaforos: " + calle1.nombre + " - " + calle1.semaforo + " | " + calle2.nombre + " - " + calle2.semaforo);
            System.out.println("1. Agregar vehículo al final de la cola (el último en llegar)");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Elimina el próximo vehículo en cruzar (el que llegó primero)");
            System.out.println("4. Cambiar semáforo");
            System.out.println("5. Ejecutar movimiento");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); 

            if (opcion == 1)
            {
                System.out.println("Ingrese id (matrícula): ");
                String id = sc.next(); 

                System.out.println("Ingrese tipo (auto/bus/moto): ");
                String tipo = sc.next(); 

                System.out.println("Ingrese tiempo de llegada (segundos): ");
                int tiempoLlegada = sc.nextInt();

                Vehiculo vehiculo = new Vehiculo(id, tipo, tiempoLlegada); 
                
                System.out.println("¿Qué calle? (1: Avenida Italia / 2: Garibaldi)");
                int seleccionCalle = sc.nextInt(); 

                if (seleccionCalle == 1)
                {
                    calle1.incorporarVehiculo(vehiculo); 
                }
                else
                {
                    calle2.incorporarVehiculo(vehiculo);
                }
            }
            
            else if (opcion == 2)
            {
                System.out.println("¿Qué calle? (1: Avenida Italia / 2: Garibaldi)");
                int seleccionCalle = sc.nextInt(); 

                if (seleccionCalle == 1)
                {
                    for (int i = 0; i < calle1.cola.tamaño(); i++)
                    {
                      Vehiculo v = calle1.cola.obtener(i);
                      System.out.println(v.id + " - " + v.tipo + " - " + v.tiempoLlegada);
                    }
                }

                else if (seleccionCalle == 2)
                {
                    for (int i = 0; i < calle2.cola.tamaño(); i++)
                    {
                      Vehiculo v = calle2.cola.obtener(i);
                      System.out.println(v.id + " - " + v.tipo + " - " + v.tiempoLlegada);
                    }
                }
            }


            else if (opcion == 3)
            {
                System.out.println("¿Qué calle? (1: Avenida Italia / 2: Garibaldi)");
                int seleccionCalle = sc.nextInt();

                if (seleccionCalle == 1)
                {
                    if (!calle1.cola.esVacio())
                    {
                        calle1.cola.quitaDeCola();
                    }
                }

                else if (seleccionCalle == 2)
                {
                    if (!calle2.cola.esVacio())
                    {
                        calle2.cola.quitaDeCola();
                    }
                }
            }

            else if (opcion == 4)
            {
                interseccion.cambiarSemaforo();
            }

            else if (opcion == 5)
            {
                interseccion.ejecutarMovimiento(); 
            }

        }

        sc.close();
        
    } 

}
