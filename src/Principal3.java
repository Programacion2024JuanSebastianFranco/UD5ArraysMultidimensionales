import java.util.Scanner;

public class Principal3 {
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VentasSemanales ventas = null;

        int opc;

        do {
            opc = menu();

            switch (opc) {
                case 1 -> {
                    // Crear instancia de VentasSemanales
                    System.out.println("Introduce el numero de semanas:");
                    int numSemanas = scanner.nextInt();
                    ventas = new VentasSemanales(numSemanas);
                    System.out.println("Instancia creada con " + numSemanas + " semanas.");
                }

                case 2 -> {
                    // Guardar venta
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }
                    System.out.println("Introduce la semana");
                    int semana = scanner.nextInt();
                    System.out.println("Introduce el dia (0 = LUNES ... 6 = DOMINGO):");
                    int dia = scanner.nextInt();
                    System.out.println("Introduce el valor de la venta:");
                    int valor = scanner.nextInt();

                    ventas.guardarVenta(semana, dia, valor);
                    System.out.println("Venta registrada");
                }

                case 3 -> {
                    // Mostrar ventas totales por semana
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }
                    System.out.println("Introduce la semana");
                    int semana = scanner.nextInt();

                    System.out.println("Ventas de la semana " + semana + ": " + ventas.totalSemana(semana));
                }

                case 4 -> {
                    // Mostrar total de ventas por día de la semana
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }
                    System.out.println("Introduce el día (0 = LUNES ... 6 = DOMINGO):");
                    int dia = scanner.nextInt();

                    int totalDia = ventas.totalDiaSemana(dia);
                    System.out.println("Total ventas del día: " + totalDia);
                }

                case 5 -> {
                    // Mostrar media de ventas por día de la semana
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }
                    System.out.println("Introduce el día (0 = LUNES ... 6 = DOMINGO):");
                    int dia = scanner.nextInt();

                    int mediaDia = ventas.mediaDiaSemana(dia);
                    System.out.println("Media de ventas del dia: " + mediaDia);
                }

                case 6 -> {
                    // Mostrar tabla completa
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }
                    System.out.println("Ventas Semanales:");
                    System.out.println(ventas);
                }

                case 7 -> {
                    // Inicializar ventas
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }
                    ventas.inicializarVentas();
                    System.out.println("Ventas inicializadas");
                }

                case 8 -> {
                    // Suma total
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }

                    String totalSemana = ventas.totalSemana();
                    System.out.println("Suma de ventas total de las semanas: " + "\n" + totalSemana);
                }

                case 9 -> {
                    // Media total
                    if (ventas == null) {
                        System.out.println("Primero debes crear una instancia");
                    }

                    String mediaDia = ventas.mediaSemana();
                    System.out.println("Media de ventas de las semanas: " + "\n" + mediaDia);
                }

                case 10 -> {
                    // Salir
                    System.out.println("Adios");
                }

                default -> System.out.println("Opcion no valida");
            }
        } while (opc != 10);
    }

    public static int menu() {
        int opc;
        do {
            System.out.print("""
                    MENU
                    1. Crear instancia de VentasSemanales
                    2. Guardar venta
                    3. Mostrar ventas de la semana
                    4. Mostrar total de ventas por dia de la semana
                    5. Mostrar media de ventas por dia de la semana
                    6. Mostrar tabla completa de ventas
                    7. Inicializar ventas
                    8. Suma total de todas las ventas
                    9. Media total de todas las ventas
                    10. Salir
                    """);
            opc = scan.nextInt();
        } while (opc < 1 || opc > 10);

        return opc;
    }
}