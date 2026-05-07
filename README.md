# Proyecto grupoB-TraficSim

Simulación de una intersección de tráfico con semáforos usando Tipos de Datos Abstractos (TDAs) vistos en clase.

## Estructura del Proyecto

```
Proyecto grupoB-TraficSim/
├── src/
│   ├── main/java/ucu/edu/aed/
│   │   ├── tda/                      # Tipos de Datos Abstractos
│   │   │   ├── TDANodo.java
│   │   │   ├── TDALista.java
│   │   │   ├── TDACola.java
│   │   │   ├── ListaEnlazada.java
│   │   │   └── ColaEnlazada.java
│   │   └── app/                      # Aplicación principal
│   │       ├── Vehiculo.java
│   │       ├── Calle.java
│   │       ├── Interseccion.java
│   │       └── Main.java
│   └── test/java/ucu/edu/aed/app/
│       ├── CalleTests.java
│       └── InterseccionTests.java
├── pom.xml
└── README.md
```

## TDAs Incluidos

- **TDANodo<T>** - Nodo genérico para listas enlazadas
- **TDALista<T>** - Interfaz de lista genérica
- **TDACola<T>** - Interfaz de cola FIFO
- **ListaEnlazada<T>** - Implementación de lista enlazada simple

## Requisitos

- Java 11+
- Maven 3.6+

## Cómo Ejecutar

### Compilar el proyecto
```bash
mvn clean compile
```

### Ejecutar los tests
```bash
mvn test
```

### Ejecutar la aplicación interactiva
```bash
mvn exec:java -Dexec.mainClass="ucu.edu.aed.app.Main"
```


## Uso de la Aplicación

La aplicación presenta un menú interactivo con las siguientes opciones:

1. **Agregar vehículo** - Agrega un nuevo vehículo a la cola de una calle
2. **Listar Vehículos** - Muestra todos los vehículos en la cola de una calle
3. **Eliminar vehículo** - Remueve el primer vehículo (que va a cruzar)
4. **Cambiar semáforo** - Alterna los semáforos entre las calles
5. **Ejecutar movimiento** - Ejecuta un ciclo de movimiento de vehículos
0. **Salir** - Cierra la aplicación

## Tests

Se incluyen 14 tests automáticos:
- **CalleTests** (6 tests): Prueba las operaciones de agregar vehículos y movimiento
- **InterseccionTests** (8 tests): Prueba los cambios de semáforos y movimientos coordinados

Ejecutar todos los tests:
```bash
mvn clean test
```

Ver reporte de tests:
```bash
mvn surefire-report:report
```

## Notas

- La cola usa implementación con lista enlazada
- Los semáforos alternan entre Verde, Amarillo y Rojo
- Solo se permite movimiento cuando el semáforo está en Verde
