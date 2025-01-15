public class Principal {

    int[][] int2d = new int[5][10];


    public int[][] multi(int[][] bid) {
        for (int i = 0; i < bid.length; i++) {
            for (int j = 0; j < int2d[i].length; j++) {
                bid[i][j] *= 2;
            }
        }
        return bid;
    }


    public String imprimir(int[][] bid) {

        StringBuilder imprimir = new StringBuilder();

        for (int i = 0; i < bid.length; i++) {
            if (bid[i] == null || bid[i].length == 0) {
                imprimir.append("Fila ").append(i).append(": vacia\n");
            } else {
                imprimir.append("Fila ").append(i).append(": ");
                for (int j = 0; j < int2d[i].length; j++) {
                    imprimir.append(bid[i][j]).append(" ");
                }
                imprimir.append(" ");
            }
        }

        return imprimir.toString();
    }


}
