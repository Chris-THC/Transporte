package transporte;

import java.util.ArrayList;
import java.util.List;

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
     * Interfaz funcional que define la capacidad de un objeto para rodar.
     */
    public interface Rodante {
        /**
         * Método que simula la acción de conducir.
         */
        void conducir();
    }

    /**
     * Interfaz funcional que define la capacidad de un Vehiculo para volar.
     */
    public interface Volador {
        /**
         * Método que simula la acción de volar.
         */
        void volar();
    }

    /**
     * Interfaz funcional que define la capacidad de un Vehiculo para nadar o navegar.
     */
    public interface Nadador {
        /**
         * Método que simula la acción de navegar.
         */
        void navegar();
    }

    /**
     * Interfaz funcional que define la capacidad de un Vehiculo para recargar su batería.
     */
    public interface Electrico {
        /**
         * Método que simula la acción de recargar la batería.
         */
        void recargarBateria();
    }

    /**
     * Interfaz funcional que define la capacidad de un Vehiculo para repostar combustible.
     */
    public interface Combustion {
        /**
         * Método que simula la acción de repostar combustible.
         */
        void repostarCombustible();
    }

    /**
     * Interfaz funcional que define la capacidad de un Vehiculo para activar el modo autónomo.
     */
    public interface Autonomo {
        /**
         * Método que simula la acción de activar el modo autónomo.
         */
        void activarModoAutonomo();
    }


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
            public void repostarCombustible() {
                System.out.println("Auto repostando gasolina.");
            }
        }


        /**
         * Vehículo aéreo autónomo con capacidades eléctricas.
         */
        public static class Dron extends Vehiculo implements Volador, Electrico, Autonomo {
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

            /**
             * Implementación del método de la interfaz {@code Autonomo}.
             * Simula la activación de la navegación por GPS del dron.
             */
            @Override
            public void activarModoAutonomo() {
                System.out.println("Dron activando navegación por GPS.");
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
     * Clase abstracta que representa una carga genérica.
     * Define propiedades y comportamientos comunes para diferentes tipos de carga.
     */
    public static abstract class Carga {
        private double peso;

        /**
         * Método abstracto que define la acción de verificar la seguridad de la carga.
         * Cada subclase concreta debe implementar este método para especificar cómo se verifica la seguridad.
         */
        public abstract void verificarSeguridad();

        /**
         * Obtiene el peso de la carga.
         *
         * @return El peso de la carga.
         */
        public double getPeso() {
            return peso;
        }

        /**
         * Establece el peso de la carga.
         *
         * @param peso El nuevo peso de la carga.
         */
        public void setPeso(double peso) {
            this.peso = peso;
        }
    }

    /**
     * Carga especializada para materiales frágiles.
     */
    public static class CargaFragil extends Carga {
        /**
         * Implementación del método abstracto {@code verificarSeguridad()} para la clase {@code CargaFragil}.
         * Simula la aplicación de protocolos anti-vibración para asegurar la carga frágil.
         */
        @Override
        public void verificarSeguridad() {
            System.out.println("Aplicando protocolos anti-vibración.");
        }

        /**
         * Sobreescribe el método {@code toString()} para proporcionar una representación en cadena de la carga frágil.
         *
         * @return Una cadena que describe la carga como "Carga Frágil".
         */
        @Override
        public String toString() {
            return "Carga Frágil";
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
        }
    }

    /**
     * Misión especializada para entregas urgentes.
     * Extiende la clase {@code Mision} añadiendo un tiempo límite para la entrega.
     */
    public static class EntregaUrgente extends Mision {
        private double tiempoLimite;

        /**
         * Constructor para la clase {@code EntregaUrgente}.
         *
         * @param origen       El punto de origen de la entrega urgente.
         * @param destino      El punto de destino de la entrega urgente.
         * @param vehiculo     El vehículo asignado para la entrega urgente.
         * @param tiempoLimite El tiempo límite en horas para completar la entrega.
         */
        public EntregaUrgente(String origen, String destino, Vehiculo vehiculo, double tiempoLimite) {
            super(origen, destino, vehiculo);
            this.tiempoLimite = tiempoLimite;
        }

        /**
         * Sobreescribe el método {@code iniciar()} para mostrar un mensaje específico para entregas urgentes.
         */
        @Override
        public void iniciar() {
            System.out.printf("INICIO URGENTE: " + origen + " a " + destino + " (" +vehiculoAsignado.getId()+")");
            vehiculoAsignado.moverse();
        }

        /**
         * Sobreescribe el método {@code completar()} para indicar que la entrega se completó dentro del tiempo límite.
         */
        @Override
        public void completar() {
            System.out.println("Entrega completada en " + tiempoLimite + " horas.");
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
        public void simularCiclo() {
            System.out.println("\n--- INICIO DE CICLO DE SIMULACIÓN ---");
            misiones.forEach(m -> {
                m.iniciar();
                m.completar();
            });
            System.out.println("--- FIN DE CICLO ---\n");
        }
    }

    /**
     * Método principal que sirve como punto de entrada para la simulación.
     * Crea instancias de diferentes vehículos, realiza operaciones de polimorfismo y demuestra el funcionamiento del entorno de simulación y las misiones.
     */
    public static void main(String[] args) {
        // Creación de vehículos concretos (Tipificación)
        Vehiculo.Auto auto1 = new Vehiculo.Auto("A1");
        Vehiculo.Dron dron1 = new Vehiculo.Dron("D1");
        Vehiculo.Anfibio anfibio1 = new Vehiculo.Anfibio("AN1");
        Vehiculo.Submarino submarino1 = new Vehiculo.Submarino("S1");

        System.out.println("--- Demostración de Tipificación ---");
        System.out.println("Tipo de auto1: " + auto1.getClass().getSimpleName());
        System.out.println("Tipo de dron1: " + dron1.getClass().getSimpleName());

        // Upcasting (Polimorfismo)
        Vehiculo vehiculoGenerico1 = auto1; // Un Auto es un Vehiculo
        Vehiculo vehiculoGenerico2 = dron1; // Un Dron es un Vehiculo
        Rodante vehiculoRodante = anfibio1; // Un Anfibio es Rodante
        Nadador vehiculoNadador = submarino1; // Un Submarino es Nadador

        System.out.println("\n--- Demostración de Upcasting y Polimorfismo ---");
        vehiculoGenerico1.moverse(); // Llama a la implementación de moverse de Auto
        vehiculoGenerico2.moverse(); // Llama a la implementación de moverse de Dron
        vehiculoRodante.conducir(); // Llama a la implementación de conducir de Anfibio
        vehiculoNadador.navegar(); // Llama a la implementación de navegar de Submarino

        // Polimorfismo a través de una lista
        List<Vehiculo> flota = new ArrayList<>();
        flota.add(auto1);
        flota.add(dron1);
        flota.add(anfibio1);
        flota.add(submarino1);

        System.out.println("\n--- Polimorfismo en una lista ---");
        for (Vehiculo vehiculo : flota) {
            System.out.print(vehiculo.getId() + ": ");
            vehiculo.moverse(); // Comportamiento polimórfico: cada vehículo se mueve de forma diferente
        }

        // Downcasting (requiere precaución y verificación con instanceof)
        System.out.println("\n--- Demostración de Downcasting ---");
        if (vehiculoGenerico1 instanceof Vehiculo.Auto) {
            Vehiculo.Auto autoRecuperado = (Vehiculo.Auto) vehiculoGenerico1;
            autoRecuperado.repostarCombustible();
        }

        if (vehiculoGenerico2 instanceof Vehiculo.Dron) {
            Vehiculo.Dron dronRecuperado = (Vehiculo.Dron) vehiculoGenerico2;
            dronRecuperado.volar();
            dronRecuperado.activarModoAutonomo();
        }

        // Uso de interfaces (Polimorfismo)
        System.out.println("\n--- Polimorfismo con Interfaces ---");
        List<Rodante> vehiculosTerrestres = new ArrayList<>();
        vehiculosTerrestres.add(auto1);
        vehiculosTerrestres.add(anfibio1);
        for (Rodante rodante : vehiculosTerrestres) {
            rodante.conducir();
        }

        List<Volador> vehiculosAereos = new ArrayList<>();
        vehiculosAereos.add(dron1);
        for (Volador volador : vehiculosAereos) {
            volador.volar();
        }

        List<Nadador> vehiculosAcuaticos = new ArrayList<>();
        vehiculosAcuaticos.add(submarino1);
        vehiculosAcuaticos.add(anfibio1);
        for (Nadador nadador : vehiculosAcuaticos) {
            nadador.navegar();
        }

        // Demostración de la clase Entorno y Misiones
        System.out.println("\n--- Demostración de Entorno y Misiones ---");
        Entorno entornoSimulacion = new Entorno();
        entornoSimulacion.agregarVehiculo(auto1);
        entornoSimulacion.agregarVehiculo(dron1);
        entornoSimulacion.agregarVehiculo(anfibio1);
        entornoSimulacion.agregarVehiculo(submarino1);

        CargaFragil carga1 = new CargaFragil();
        carga1.setPeso(2.5);
        carga1.verificarSeguridad();

        Mision mision1 = new Mision("Orizaba", "CDMX", auto1);
        EntregaUrgente mision2 = new EntregaUrgente("USA", "Inglaterra", submarino1, 10.0);

        entornoSimulacion.agregarMision(mision1);
        entornoSimulacion.agregarMision(mision2);

        entornoSimulacion.simularCiclo();
    }
}