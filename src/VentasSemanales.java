public class VentasSemanales {

    private int numSemanas;
    private int[][] seguimiento;


    public VentasSemanales(int numSemanas) {
        this.numSemanas = numSemanas;
        this.seguimiento = new int[numSemanas][7];
    }

    public void guardarVenta(int semana, int dia, int valor) {
        if (semana >= 6) {
            System.out.println("Fuera de rango");
        } else if (dia >= 6) {
            System.out.println("Fuera de rango");
        } else {
            seguimiento[semana][dia] = valor;
        }
    }


    public void inicializarVentas(){
        for (int[] semana : seguimiento) {
            for (int dia : semana) {
                semana[dia] = 0;
            }
        }
    }

    @Override
    public String toString() {

        String salida= String.format("%-11s%-11s%-11s%-11s%-11s%-11s%-11s%-11s", "Semana","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo");

        for(int i = 0; i < numSemanas; i++){
            salida += String.format("\n");
            salida += String.format("%-11s", "S" + (i+1));
            for (int j = 0; j < 7; j++){
                salida += String.format("%-11s", seguimiento[i][j]);
            }

        }


        return salida;
    }

    public String totalSemana(int semana){
        StringBuilder salida= new StringBuilder();
        for (int i = 0; i < 7; i++){
            salida.append(String.format("%-11s", seguimiento[semana][i]));
        }
        return salida.toString();
    }

    public int totalDiaSemana(int dia){
        int suma = 0;
        if (dia < 0 || dia >= 7) {
            suma = -1;
        } else {
            for (int i = 0; i < numSemanas; i++) {
                suma += seguimiento[i][dia];
            }
        }
        return suma;
    }

    public int mediaDiaSemana(int dia){

        int suma = 0;
        int media;

        for(int i = 0; i < numSemanas; i++){
            suma += seguimiento[i][dia];
        }

        media = suma / numSemanas;

        return media;
    }

    public String totalSemana(){
        StringBuilder salida= new StringBuilder(String.format("%-11s%-11s%-11s%-11s%-11s%-11s%-11s","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"));

        salida.append("\n");
        for (int i = 0; i < 7; i++){
            salida.append(String.format("%-11s", totalDiaSemana(i)));
        }

        return salida.toString();

    }

    public String mediaSemana(){
        StringBuilder salida= new StringBuilder(String.format("%-11s%-11s%-11s%-11s%-11s%-11s%-11s","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"));

        salida.append("\n");
        for (int i = 0; i < 7; i++){
            salida.append(String.format("%-11s", mediaDiaSemana(i)));
        }

        return salida.toString();

    }


}
