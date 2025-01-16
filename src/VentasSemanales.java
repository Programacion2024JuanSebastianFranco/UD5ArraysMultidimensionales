/**
 * Clase VentasSemanales que permite realizar un seguimiento de las ventas semanales organizadas por días.
 */
public class VentasSemanales {

    /**
     * Número de semanas a seguir.
     */
    private int numSemanas;

    /**
     * Matriz que almacena las ventas por semana y por día.
     */
    private int[][] seguimiento;

    /**
     * Constructor que inicializa la cantidad de semanas y la matriz de seguimiento.
     *
     * @param numSemanas Número de semanas a seguir.
     */
    public VentasSemanales(int numSemanas) {
        this.numSemanas = numSemanas;
        this.seguimiento = new int[numSemanas][7];
    }

    /**
     * Guarda el valor de una venta en la matriz de seguimiento.
     *
     * @param semana Índice de la semana (0 a numSemanas-1).
     * @param dia    Índice del día (0 a 6).
     * @param valor  Valor de la venta.
     */
    public void guardarVenta(int semana, int dia, int valor) {
        if (semana >= 6) { // Verifica que la semana esté dentro del rango permitido
            System.out.println("Fuera de rango");
        } else if (dia >= 6) { // Verifica que el día esté dentro del rango permitido
            System.out.println("Fuera de rango");
        } else {
            seguimiento[semana][dia] = valor; // Asigna el valor a la posición correspondiente
        }
    }

    /**
     * Inicializa todas las ventas en la matriz de seguimiento a 0.
     */
    public void inicializarVentas() {
        for (int[] semana : seguimiento) {
            for (int dia : semana) {
                semana[dia] = 0; // Reinicia las ventas a 0
            }
        }
    }

    /**
     * Representa las ventas semanales en formato de tabla.
     *
     * @return Una cadena que representa la tabla de ventas.
     */
    @Override
    public String toString() {
        String salida = String.format("%-11s%-11s%-11s%-11s%-11s%-11s%-11s%-11s", "Semana", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");

        for (int i = 0; i < numSemanas; i++) {
            salida += String.format("\n");
            salida += String.format("%-11s", "S" + (i + 1)); // Agrega el número de semana
            for (int j = 0; j < 7; j++) {
                salida += String.format("%-11s", seguimiento[i][j]); // Agrega los valores de ventas diarios
            }
        }

        return salida;
    }

    /**
     * Devuelve las ventas de una semana específica.
     *
     * @param semana Índice de la semana (0 a numSemanas-1).
     * @return Una cadena con las ventas de esa semana.
     */
    public String totalSemana(int semana) {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            salida.append(String.format("%-11s", seguimiento[semana][i])); // Concatena las ventas diarias
        }
        return salida.toString();
    }

    /**
     * Calcula el total de ventas en un día específico de todas las semanas.
     *
     * @param dia Índice del día (0 a 6).
     * @return La suma total de ventas de ese día.
     */
    public int totalDiaSemana(int dia) {
        int suma = 0;
        if (dia < 0 || dia >= 7) { // Valida que el día esté en el rango permitido
            suma = -1;
        } else {
            for (int i = 0; i < numSemanas; i++) {
                suma += seguimiento[i][dia]; // Suma las ventas del día en todas las semanas
            }
        }
        return suma;
    }

    /**
     * Calcula la media de ventas en un día específico de todas las semanas.
     *
     * @param dia Índice del día (0 a 6).
     * @return La media de ventas de ese día.
     */
    public int mediaDiaSemana(int dia) {
        int suma = 0;
        int media;

        for (int i = 0; i < numSemanas; i++) {
            suma += seguimiento[i][dia]; // Suma las ventas del día en todas las semanas
        }

        media = suma / numSemanas; // Calcula la media

        return media;
    }

    /**
     * Devuelve una tabla con el total de ventas por día de la semana.
     *
     * @return Una cadena que representa la tabla de totales por día.
     */
    public String totalSemana() {
        StringBuilder salida = new StringBuilder(String.format("%-11s%-11s%-11s%-11s%-11s%-11s%-11s", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));

        salida.append("\n");
        for (int i = 0; i < 7; i++) {
            salida.append(String.format("%-11s", totalDiaSemana(i))); // Agrega el total de ventas por día
        }

        return salida.toString();
    }

    /**
     * Devuelve una tabla con la media de ventas por día de la semana.
     *
     * @return Una cadena que representa la tabla de medias por día.
     */
    public String mediaSemana() {
        StringBuilder salida = new StringBuilder(String.format("%-11s%-11s%-11s%-11s%-11s%-11s%-11s", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));

        salida.append("\n");
        for (int i = 0; i < 7; i++) {
            salida.append(String.format("%-11s", mediaDiaSemana(i))); // Agrega la media de ventas por día
        }

        return salida.toString();
    }
}

