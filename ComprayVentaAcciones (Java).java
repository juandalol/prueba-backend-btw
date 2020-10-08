import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {

//        El costo de las acciones en cada día se da en una matriz A [] de tamaño N . Encuentre todos los días en los que compra y vende las acciones para que entre esos días
//        su beneficio sea máximo.
//
//        Entrada:
//        La primera línea contiene el número de casos de prueba T . La primera línea de cada caso de prueba contiene un valor entero N que indica el número de días,
//        seguido de una matriz de precios de acciones de N días.
//
//        Salida:
//        Para cada caso de prueba, genere todos los días con ganancias en una sola línea. Y si no hay ganancias, imprima "No Profit".
//
//        Ejemplo de entrada:
//        3
//        7
//        100 180 260 310 40 535 695
//        4
//        100 50 30 20
//        10
//        23 13 25 29 33 19 34 45 65 67

        //  https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        for (int j = 0; j < casos; j++) {

            int dias = sc.nextInt();
            int precioAccion[];
            precioAccion = new int[dias];
            for (int i = 0; i < dias; i++) {

                precioAccion[i] = sc.nextInt();
            }

            List<Integer> preciosBajos = new ArrayList<Integer>();

            List<Integer> preciosAltos = new ArrayList<Integer>();
            for (int i = 0; i < dias; i++) {
                if (i == 0) {
                    if (precioAccion[i] < precioAccion[i + 1]) {
                        preciosBajos.add(i);
                    }
                } else if (i < dias - 1) {
                    if (precioAccion[i] > precioAccion[i - 1] && precioAccion[i] > precioAccion[i + 1]) {
                        preciosAltos.add(i);
                    } else if (precioAccion[i] < precioAccion[i - 1] && precioAccion[i] < precioAccion[i + 1]) {
                        preciosBajos.add(i);
                    }
                } else {
                    if (precioAccion[i] > precioAccion[i - 1]) {
                        preciosAltos.add(i);
                    }
                }
            }

            if (preciosAltos.size() > 0) {
                for (int i = 0; i < preciosAltos.size(); i++) {

                    System.out.print("(" + preciosBajos.get(i) + " " + preciosAltos.get(i) + ") ");
                }
            } else {
                System.out.println("No Profit");
            }

        }
    }
}
