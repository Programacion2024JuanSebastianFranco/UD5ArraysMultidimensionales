import java.io.DataInput;

public class VentasSemanales {
    public enum diaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    private int numSemanas;
    private int[][] seguimiento;


    public VentasSemanales(int numSemanas) {
        this.numSemanas = numSemanas;
        this.seguimiento = new int[0][7];
    }

    public void guardarVenta(int semana, diaSemana dia, int valor) {

        if (semana < 0 || semana >= numSemanas) {
            System.out.println("Semana fuera de rango.");
        } else {
            int indiceDia = dia.ordinal();
            seguimiento[semana][indiceDia] = valor;
        }
    }


    public void inicializarVentas(){
        this.seguimiento = new int[0][7];
    }

    @Override
    public String toString() {

        String salida= String.format("%-11s", "Semana" + "Lunes" + "Martes" + "Miercoles" + "Jueves" + "Viernes");

        for(int i = 0; i < numSemanas; i++){
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

    public int totalDiaSemana(diaSemana dia){

        int suma = 0;

        for (int i = 0; i < numSemanas; i++){
            int indiceDia = dia.ordinal();
            suma += seguimiento[i][indiceDia];
        }
        return suma;
    }

    public int mediaDiaSemana(diaSemana dia){

        int suma = 0;
        int media;

        for(int i = 0; i < numSemanas; i++){
            int indiceDia = dia.ordinal();
            suma += seguimiento[i][indiceDia];
        }

        media = suma / numSemanas;

        return media;
    }

    public String totalSemana(){
        StringBuilder salida= new StringBuilder();

        int suma = 0;

        for (int i = 0; i < numSemanas; i++){
            suma += seguimiento[i][i];
            salida.append(String.format("%-11s", seguimiento[numSemanas][suma]));
        }

        return salida.toString();

    }


}
