package org.transporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Interfaz funcional que define la capacidad de un objeto para rodar.
 */
interface Rodante {
    /**
     * Método que simula la acción de conducir.
     */
    void conducir();
}

/**
 * Interfaz funcional que define la capacidad de un Vehiculo para volar.
 */
interface Volador {
    /**
     * Método que simula la acción de volar.
     */
    void volar();
}

/**
 * Interfaz funcional que define la capacidad de un Vehiculo para nadar o navegar.
 */
interface Nadador {
    /**
     * Método que simula la acción de navegar.
     */
    void navegar();
}

/**
 * Interfaz funcional que define la capacidad de un Vehiculo para recargar su batería.
 */
interface Electrico {
    /**
     * Método que simula la acción de recargar la batería.
     */
    void recargarBateria();
}

/**
 * Interfaz funcional que define la capacidad de un Vehiculo para repostar combustible.
 */
interface Combustion {
    /**
     * Método que simula la acción de repostar combustible.
     */
    void recargarCombustible();
}

/**
 * Clase principal que encapsula toda la simulación del sistema de transporte autónomo.
 * <br/>
 * <b>
 * Este sistema modela un entorno logístico con diferentes tipos de vehículos autónomos
 * (terrestres, aéreos y acuáticos) que realizan misiones de transporte en un entorno
 * con obstáculos y condiciones variables, utilizando exclusivamente clases anidadas estáticas.
 * </b>
 *
 * @author [Cristofer Amador Hernandez y Jonathan Garcia Amador]
 * @version 1.0
 */
public class Simulador {
    /**
     * Clase abstracta que representa un vehículo autónomo genérico.
     * Proporciona una base para diferentes tipos de vehículos con atributos y comportamientos comunes.
     */
    public static abstract class Vehiculo {
        private String id;
        private double capacidad;
        private String ubicacion;

        /**
         * Constructor para la clase abstracta {@code Vehiculo}.
         *
         * @param id        Identificador único del vehículo.
         * @param capacidad Capacidad de carga del vehículo.
         * @param ubicacion Ubicación actual del vehículo.
         */
        public Vehiculo(String id, double capacidad, String ubicacion) {
            this.id = id;
            this.capacidad = capacidad;
            this.ubicacion = ubicacion;
        }

        /**
         * Método abstracto que define el comportamiento de movimiento del vehículo.
         * Cada subclase concreta debe implementar este método para especificar cómo se mueve.
         */
        public abstract void moverse();

        /**
         * Método abstracto que define la acción de cargar elementos en el vehículo.
         * La implementación específica dependerá del tipo de vehículo.
         */
        public abstract void cargar();

        /**
         * Método abstracto que define la acción de descargar elementos del vehículo.
         * La implementación específica dependerá del tipo de vehículo.
         */
        public abstract void descargar();

        /**
         * Obtiene el identificador único del vehículo.
         *
         * @return El ID del vehículo.
         */
        public String getId() {
            return id;
        }

        /**
         * Establece el identificador único del vehículo.
         *
         * @param id El nuevo ID del vehículo.
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * Obtiene la capacidad de carga del vehículo.
         *
         * @return La capacidad del vehículo.
         */
        public double getCapacidad() {
            return capacidad;
        }

        /**
         * Establece la capacidad de carga del vehículo.
         *
         * @param capacidad La nueva capacidad del vehículo.
         */
        public void setCapacidad(double capacidad) {
            this.capacidad = capacidad;
        }

        /**
         * Obtiene la ubicación actual del vehículo.
         *
         * @return La ubicación del vehículo.
         */
        public String getUbicacion() {
            return ubicacion;
        }

        /**
         * Establece la ubicación actual del vehículo.
         *
         * @param ubicacion La nueva ubicación del vehículo.
         */
        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        /**
         * Vehículo terrestre que implementa capacidades de rodar y usar combustible.
         */
        public static class Auto extends Vehiculo implements Rodante, Combustion {

            /**
             * Constructor para la clase {@code Auto}.
             * Inicializa un nuevo auto con un ID específico y valores predeterminados para capacidad y ubicación.
             *
             * @param id El identificador único del auto.
             */
            public Auto(String id) {
                super(id, 1000.0, "Almacén Principal");
            }

            /**
             * Implementación del método abstracto {@code moverse()} para la clase {@code Auto}.
             * Simula el movimiento del auto por carretera.
             */
            @Override
            public void moverse() {
                System.out.println("Auto moviéndose por carretera.");
            }


            /**
             * Implementación del método abstracto {@code cargar()} para la clase {@code Auto}.
             * Simula la acción de cargar el auto.
             */
            @Override
            public void cargar() {
                System.out.println("Auto cargando");
            }


            /**
             * Implementación del método abstracto {@code descargar()} para la clase {@code Auto}.
             * Simula la acción de descargar el auto en un punto de entrega.
             */
            @Override
            public void descargar() {
                System.out.println("Auto descargando en punto de entrega.");
            }

            /**
             * Implementación del método de la interfaz {@code Rodante}.
             * Simula la acción de conducir el auto en modo manual.
             */
            @Override
            public void conducir() {
                System.out.println("Auto en modo conducción manual.");
            }

            /**
             * Implementación del método de la interfaz {@code Combustion}.
             * Simula la acción de repostar gasolina en el auto.
             */
            @Override
            public void recargarCombustible() {
                System.out.println("Auto repostando gasolina.");
            }
        }


        /**
         * Vehículo aéreo autónomo con capacidades eléctricas.
         */
        public static class Dron extends Vehiculo implements Volador, Electrico {
            /**
             * Constructor para la clase {@code Dron}.
             * Inicializa un nuevo dron con un ID específico y valores predeterminados para capacidad y ubicación.
             *
             * @param id El identificador único del dron.
             */
            public Dron(String id) {
                super(id, 5.0, "Base de Drones");
            }

            /**
             * Implementación del método abstracto {@code moverse()} para la clase {@code Dron}.
             * Simula el desplazamiento del dron en el aire.
             */
            @Override
            public void moverse() {
                System.out.println("Dron desplazándose en el aire.");
            }

            /**
             * Implementación del método abstracto {@code cargar()} para la clase {@code Dron}.
             * Simula la acción de cargar un paquete ligero en el dron.
             */
            @Override
            public void cargar() {
                System.out.println("Dron cargando paquete ligero.");
            }

            /**
             * Implementación del método abstracto {@code descargar()} para la clase {@code Dron}.
             * Simula la acción de descargar el dron mediante un sistema de cables.
             */
            @Override
            public void descargar() {
                System.out.println("Dron descargando mediante sistema de cables.");
            }

            /**
             * Implementación del método de la interfaz {@code Volador}.
             * Simula la acción de ascender del dron a una altura de 100 metros.
             */
            @Override
            public void volar() {
                System.out.println("Dron ascendiendo a 100 metros.");
            }

            /**
             * Implementación del método de la interfaz {@code Electrico}.
             * Simula la acción de recargar la batería de ion-litio del dron.
             */
            @Override
            public void recargarBateria() {
                System.out.println("Batería de ion-litio recargándose.");
            }

        }


        /**
         * Vehículo anfibio con capacidades terrestres y acuáticas.
         */
        public static class Anfibio extends Vehiculo implements Rodante, Nadador {
            /**
             * Constructor para la clase {@code Anfibio}.
             * Inicializa un nuevo anfibio con un ID específico y valores predeterminados para capacidad y ubicación.
             *
             * @param id El identificador único del anfibio.
             */
            public Anfibio(String id) {
                super(id, 500.0, "Muelle de Carga");
            }

            /**
             * Implementación del método abstracto {@code moverse()} para la clase {@code Anfibio}.
             * Simula el cambio entre el movimiento terrestre y acuático del anfibio.
             */
            @Override
            public void moverse() {
                System.out.println("Anfibio cambiando entre tierra y agua.");
            }

            /**
             * Implementación del método abstracto {@code cargar()} para la clase {@code Anfibio}.
             * Simula la acción de cargar carga sellada en el anfibio.
             */
            @Override
            public void cargar() {
                System.out.println("Anfibio cargando carga sellada.");
            }

            /**
             * Implementación del método abstracto {@code descargar()} para la clase {@code Anfibio}.
             * Simula la acción de descargar el anfibio usando una rampa hidráulica.
             */
            @Override
            public void descargar() {
                System.out.println("Anfibio usando rampa hidráulica.");
            }

            /**
             * Implementación del método de la interfaz {@code Rodante}.
             * Simula la acción de conducir el anfibio en modo 4x4.
             */
            @Override
            public void conducir() {
                System.out.println("Anfibio en modo 4x4.");
            }

            /**
             * Implementación del método de la interfaz {@code Nadador}.
             * Simula la acción de navegar del anfibio a una velocidad de 5 nudos.
             */
            @Override
            public void navegar() {
                System.out.println("Anfibio navegando a 5 nudos.");
            }
        }

        /**
         * Vehículo submarino especializado.
         */
        public static class Submarino extends Vehiculo implements Nadador {
            /**
             * Constructor para la clase {@code Submarino}.
             * Inicializa un nuevo submarino con un ID específico y valores predeterminados para capacidad y ubicación.
             *
             * @param id El identificador único del submarino.
             */
            public Submarino(String id) {
                super(id, 2000.0, "Base Submarina");
            }
            /**
             * Implementación del método abstracto {@code moverse()} para la clase {@code Submarino}.
             * Simula la acción de sumergirse del submarino a una profundidad de 200 metros.
             */
            @Override
            public void moverse() {
                System.out.println("Submarino sumergiéndose a 200 metros.");
            }

            /**
             * Implementación del método abstracto {@code cargar()} para la clase {@code Submarino}.
             * Simula la acción de cargar equipo submarino en el submarino.
             */
            @Override
            public void cargar() {
                System.out.println("Submarino cargando equipo submarino.");
            }
            /**
             * Implementación del método abstracto {@code descargar()} para la clase {@code Submarino}.
             * Simula la acción de liberar carga del submarino con una grúa.
             */
            @Override
            public void descargar() {
                System.out.println("Submarino liberando carga con grúa.");
            }

            /**
             * Implementación del método de la interfaz {@code Nadador}.
             * Simula la acción de navegar del submarino utilizando sonar.
             */
            @Override
            public void navegar() {
                System.out.println("Submarino usando sonar para navegar.");
            }
        }
    }

    /**
     * Clase abstracta que representa una misión logística.
     * Define los atributos y comportamientos básicos de una misión de transporte.
     */
    public static class Mision {
        protected String origen;
        protected String destino;
        protected Vehiculo vehiculoAsignado;
        protected double pesoCarga; // Peso de la carga
        protected boolean completada;

        /**
         * Constructor para la clase {@code Mision}.
         *
         * @param origen           El punto de origen de la misión.
         * @param destino          El punto de destino de la misión.
         * @param vehiculoAsignado El vehículo asignado para realizar la misión.
         */
        public Mision(String origen, String destino, Vehiculo vehiculoAsignado) {
            this.origen = origen;
            this.destino = destino;
            this.vehiculoAsignado = vehiculoAsignado;
            this.pesoCarga = pesoCarga;
            this.completada = false;

        }

        /**
         * Inicia la misión, mostrando un mensaje y haciendo que el vehículo asignado se mueva.
         */
        public void iniciar() {
            System.out.println("Misión iniciada desde " + origen + " hacia " + destino);
            vehiculoAsignado.moverse();
        }

        /**
         * Marca la misión como completada, mostrando un mensaje con el destino.
         */
        public void completar() {
            System.out.println("Misión completada en " + destino);
            completada = true;
        }
        public boolean isCompletada() {
            return completada;
        }

    }

    /**
     * Entorno que gestiona una colección de vehículos y misiones activas.
     * Permite agregar vehículos y misiones, y simular un ciclo de operaciones.
     */
    public static class Entorno {
        private List<Vehiculo> vehiculos = new ArrayList<>();
        private List<Mision> misiones = new ArrayList<>();

        /**
         * Agrega un vehículo al entorno de simulación.
         *
         * @param v El vehículo a agregar.
         */
        public void agregarVehiculo(Vehiculo v) {
            vehiculos.add(v);
        }

        /**
         * Agrega una misión al entorno de simulación.
         *
         * @param m La misión a agregar.
         */
        public void agregarMision(Mision m) {
            misiones.add(m);
        }

        /**
         * Simula un ciclo de operaciones, iniciando y completando todas las misiones activas.
         */
        public void simularCiclo(Simulador.Mision misionSeleccionada) {
                if (misionSeleccionada != null) {
                    // Simular solo la misión específica seleccionada
                    System.out.println("\n--- INICIO DE SIMULACIÓN DE MISIÓN ---");
                    System.out.println("Detalles de la misión:");
                    System.out.println("Origen: " + misionSeleccionada.origen + ", Destino: " + misionSeleccionada.destino);
                    System.out.println("Vehículo asignado: " + misionSeleccionada.vehiculoAsignado.getClass().getSimpleName());
                    System.out.println("Capacidad de carga: " + misionSeleccionada.vehiculoAsignado.getCapacidad());
                    simularObstaculos(misionSeleccionada.vehiculoAsignado); // Obstáculos específicos
                    misionSeleccionada.iniciar();
                    misionSeleccionada.completar(); // Marcar la misión como completada
                    System.out.println("--- FIN DE SIMULACIÓN DE MISIÓN ---\n");
                } else {
                    // Simular todas las misiones activas
                    System.out.println("\n--- INICIO DE CICLO DE SIMULACIÓN ---");
                    misiones.stream()
                            .filter(m -> !m.isCompletada()) // Solo simular misiones no completadas
                            .forEach(m -> {
                                System.out.println("Detalles de la misión:");
                                System.out.println("Origen: " + m.origen + ", Destino: " + m.destino);
                                System.out.println("Vehículo asignado: " + m.vehiculoAsignado.getClass().getSimpleName());
                                System.out.println("Capacidad de carga: " + m.vehiculoAsignado.getCapacidad());
                                simularObstaculos(m.vehiculoAsignado); // Simular obstáculos
                                m.iniciar();
                                m.completar(); // Marcar como completada
                            });
                    System.out.println("--- FIN DE CICLO ---\n");
                }
        }
        public static void simularObstaculos(Vehiculo vehiculo) {
            Random random = new Random();

            if (vehiculo instanceof Vehiculo.Auto || vehiculo instanceof Vehiculo.Anfibio) {
                System.out.println("Obstáculos terrestres:");
                String[] obstaculosTerrestres = {"Tráfico intenso", "Carretera en mal estado", "Accidente en la ruta"};
                System.out.println("- " + obstaculosTerrestres[random.nextInt(obstaculosTerrestres.length)]);
            } else if (vehiculo instanceof Vehiculo.Dron) {
                System.out.println("Obstáculos aéreos:");
                String[] obstaculosAereos = {"Viento fuerte", "Baja visibilidad", "Interferencia con señal"};
                System.out.println("- " + obstaculosAereos[random.nextInt(obstaculosAereos.length)]);
            } else if (vehiculo instanceof Vehiculo.Submarino || vehiculo instanceof Vehiculo.Anfibio) {
                System.out.println("Obstáculos acuáticos:");
                String[] obstaculosAcuaticos = {"Corrientes fuertes", "Baja visibilidad submarina", "Obstrucción por rocas"};
                System.out.println("- " + obstaculosAcuaticos[random.nextInt(obstaculosAcuaticos.length)]);
            }
        }

    }

    /**
     * Método principal que sirve como punto de entrada para la simulación.
     * Crea instancias de diferentes vehículos, realiza operaciones de polimorfismo y demuestra el funcionamiento del entorno de simulación y las misiones.
     */
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
                Simulador.Entorno entorno = new Simulador.Entorno();
                int opcion;

                do {
                    System.out.println("========= MENÚ PRINCIPAL =========");
                    System.out.println("1. Registrar un nuevo vehículo");
                    System.out.println("2. Listar todos los vehículos registrados");
                    System.out.println("3. Crear una nueva misión");
                    System.out.println("4. Listar todas las misiones activas");
                    System.out.println("5. Iniciar ciclo de simulación");
                    System.out.println("6. Ver detalles de un vehículo específico");
                    System.out.println("7. Salir");
                    System.out.println("==================================");
                    System.out.print("Selecciona una opción: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Registrar vehículo - Selecciona tipo:");
                            System.out.println("1. Auto");
                            System.out.println("2. Dron");
                            System.out.println("3. Anfibio");
                            System.out.println("4. Submarino");
                            System.out.print("Opción: ");
                            int tipoVehiculo = scanner.nextInt();
                            System.out.print("ID del vehículo: ");
                            String id = scanner.next();
                            // Verificar si el ID ya está en uso
                            boolean idEnUso = entorno.vehiculos.stream().anyMatch(v -> v.getId().equals(id));
                            if (idEnUso) {
                                System.out.println("Error: El ID '" + id + "' ya está en uso. Por favor, selecciona otro ID.");
                            } else {
                                // Registrar el vehículo si el ID no está en uso
                                if (tipoVehiculo == 1) {
                                    entorno.agregarVehiculo(new Simulador.Vehiculo.Auto(id));
                                    System.out.println("Auto registrado exitosamente.");
                                } else if (tipoVehiculo == 2) {
                                    entorno.agregarVehiculo(new Simulador.Vehiculo.Dron(id));
                                    System.out.println("Dron registrado exitosamente.");
                                } else if (tipoVehiculo == 3) {
                                    entorno.agregarVehiculo(new Simulador.Vehiculo.Anfibio(id));
                                    System.out.println("Anfibio registrado exitosamente.");
                                } else if (tipoVehiculo == 4) {
                                    entorno.agregarVehiculo(new Simulador.Vehiculo.Submarino(id));
                                    System.out.println("Submarino registrado exitosamente.");
                                } else {
                                    System.out.println("Opción inválida. No se ha registrado ningún vehículo.");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Vehículos registrados:");
                            entorno.vehiculos.forEach(v -> System.out.println(v.getId() + " (" + v.getClass().getSimpleName() + ")"));
                            break;
                        case 3:
                            System.out.print("Origen de la misión: ");
                            String origen = scanner.next();
                            System.out.print("Destino de la misión: ");
                            String destino = scanner.next();
                            System.out.println("Selecciona el tipo de misión:");
                            System.out.println("1. Terrestre");
                            System.out.println("2. Aérea");
                            System.out.println("3. Acuática");
                            System.out.print("Opción: ");
                            int tipoMision = scanner.nextInt();
                            System.out.print("ID del vehículo asignado: ");
                            String idVehiculo = scanner.next();

                            // Buscar el vehículo asignado
                            Simulador.Vehiculo vehiculoAsignado = entorno.vehiculos.stream()
                                    .filter(v -> v.getId().equals(idVehiculo))
                                    .findFirst()
                                    .orElse(null);
                            if (vehiculoAsignado == null) {
                                System.out.println("Vehículo no encontrado.");
                                break;
                            }
                            // Verificar la compatibilidad del vehículo con el tipo de misión
                            boolean compatible = false;
                            if (tipoMision == 1 && (vehiculoAsignado instanceof Simulador.Vehiculo.Auto || vehiculoAsignado instanceof Simulador.Vehiculo.Anfibio)) {
                                compatible = true;
                            } else if (tipoMision == 2 && vehiculoAsignado instanceof Simulador.Vehiculo.Dron) {
                                compatible = true;
                            } else if (tipoMision == 3 && (vehiculoAsignado instanceof Simulador.Vehiculo.Submarino || vehiculoAsignado instanceof Simulador.Vehiculo.Anfibio)) {
                                compatible = true;
                            }

                            if (!compatible) {
                                System.out.println("Error: El vehículo seleccionado no es compatible con el tipo de misión.");
                            } else {
                                // Registrar la misión si el vehículo es compatible
                                Simulador.Mision nuevaMision = new Simulador.Mision(origen, destino, vehiculoAsignado);
                                entorno.agregarMision(nuevaMision);
                                System.out.println("Misión registrada exitosamente.");
                            }

                            break;
                        case 4:
                            System.out.println("Misiones activas:");
                            entorno.misiones.stream()
                                    .filter(m -> !m.isCompletada()) // Filtrar solo misiones no completadas
                                    .forEach(m -> System.out.println(m.origen + " -> " + m.destino + " (Vehículo: " + m.vehiculoAsignado.getId() + ")"));
                            break;
                        case 5:
                            // Filtrar las misiones activas
                            System.out.println("¿Qué deseas hacer?");
                            System.out.println("1. Simular todas las misiones activas");
                            System.out.println("2. Simular una misión específica");
                            System.out.print("Opción: ");
                            int opcionSimulacion = scanner.nextInt();

                            if (opcionSimulacion == 1) {
                                // Simular todas las misiones activas
                                entorno.simularCiclo(null); // Pasamos null para que simule todas
                            } else if (opcionSimulacion == 2) {
                                // Filtrar misiones activas
                                List<Simulador.Mision> misionesActivas = entorno.misiones.stream()
                                        .filter(m -> !m.isCompletada()) // Solo misiones no completadas
                                        .collect(Collectors.toList());

                                if (misionesActivas.isEmpty()) {
                                    System.out.println("No hay misiones activas para simular.");
                                    break;
                                }
                                System.out.println("Misiones activas disponibles:");
                                for (int i = 0; i < misionesActivas.size(); i++) {
                                    Simulador.Mision mision = misionesActivas.get(i);
                                    System.out.println((i + 1) + ". Origen: " + mision.origen + ", Destino: " + mision.destino +
                                            " (Vehículo: " + mision.vehiculoAsignado.getId() + ")");
                                }
                                // Solicitar al usuario que seleccione una misión
                                System.out.print("Selecciona el número de la misión que deseas simular: ");
                                int seleccion = scanner.nextInt();

                                if (seleccion < 1 || seleccion > misionesActivas.size()) {
                                    System.out.println("Selección inválida. Regresando al menú principal.");
                                    break;
                                }
                                // Obtener la misión seleccionada y simularla
                                Simulador.Mision misionSeleccionada = misionesActivas.get(seleccion - 1);
                                entorno.simularCiclo(misionSeleccionada); // Pasamos la misión seleccionada
                            } else {
                                System.out.println("Opción inválida.");
                            }
                            break;
                        case 6:
                            System.out.print("ID del vehículo a consultar: ");
                            String idConsulta = scanner.next();
                            Simulador.Vehiculo vehiculoConsultado = entorno.vehiculos.stream()
                                    .filter(v -> v.getId().equals(idConsulta))
                                    .findFirst().orElse(null);
                            if (vehiculoConsultado != null) {
                                System.out.println("Detalles del vehículo:");
                                System.out.println("ID: " + vehiculoConsultado.getId());
                                System.out.println("Capacidad: " + vehiculoConsultado.getCapacidad());
                                System.out.println("Ubicación: " + vehiculoConsultado.getUbicacion());
                            } else {
                                System.out.println("Vehículo no encontrado.");
                            }
                            break;
                        case 7:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 7);

                scanner.close();
            }
        }
