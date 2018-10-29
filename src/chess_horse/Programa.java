package  chess_horse;
import java.util.*;

public class Programa {
    static Casilla[][] tablero = new Casilla[8][8];
    public static ArrayList<Integer> piezasamatar = new ArrayList();
    public static int corte = 0;
    
    public static void  resetear() {
        piezasamatar.clear();
        corte = 0;
    }
    
    public static void cargarpiezasamatar(ArrayList p) {
        piezasamatar.clear();
        piezasamatar = p;
    }
    
//*******************************************************************   A*  **************************+*****+
    
    public static ArrayList<Integer> aStar(int posicionInicial) {
        ArrayList<Integer> recorridoInicial = new ArrayList();
        recorridoInicial.add(posicionInicial);
        
        if (Programa.isFinished(recorridoInicial))
            return recorridoInicial;
        
        Estado estadoInicial = new Estado(recorridoInicial);
        
        PriorityQueue<Estado> estados = new PriorityQueue();
        estados.add(estadoInicial);
        
        while (!estados.isEmpty()) {
            Estado estado = estados.poll();
            int movimientos[] = obtenerMovimientos(estado.recorrido);
            for (int movimiento : movimientos) {
                ArrayList<Integer> recorrido = new ArrayList();
                recorrido.addAll(estado.recorrido);
                recorrido.add(movimiento);
                    
                if (Programa.isFinished(recorrido))
                    return recorrido;
                    
                Estado nuevoEstado = new Estado(recorrido);
                estados.add(nuevoEstado);
            }
        }
        return null;
    }
    
//*******************************************************************   Amplitud  **************************+
    
    public static ArrayList<Integer> amplitud(int posicionInicial) {
        ArrayList<ArrayList<Integer>> recorridos = new ArrayList();
        ArrayList<Integer> recorrido = new ArrayList();
        recorrido.add(posicionInicial);
        
        if (Programa.isFinished(recorrido))
            return recorrido;
        
        recorridos.add(recorrido);
        return Programa.buscarAmplitud(recorridos);
    }
    
    public static ArrayList<Integer> buscarAmplitud(ArrayList<ArrayList<Integer>> recorridos) {
        ArrayList<ArrayList<Integer>> nuevosRecorridos = new ArrayList();
        for (ArrayList<Integer> recorrido : recorridos) {
            int movimientos[] = obtenerMovimientos(recorrido);
            for (int movimiento : movimientos) {
                ArrayList<Integer> nuevoRecorrido = new ArrayList();
                nuevoRecorrido.addAll(recorrido);
                nuevoRecorrido.add(movimiento);
                    
                if (Programa.isFinished(nuevoRecorrido))
                    return nuevoRecorrido;
                    
                nuevosRecorridos.add(nuevoRecorrido);
            }
        }

        return Programa.buscarAmplitud(nuevosRecorridos);
    }

    static int[] obtenerMovimientos(ArrayList<Integer> recorrido) {
        int i = recorrido.get(recorrido.size()-1)/8;
        int j = recorrido.get(recorrido.size()-1) - recorrido.get(recorrido.size()-1)/8*8;
        return tablero[i][j].posibilidades();
    }

    static boolean isFinished(ArrayList<Integer> recorrido) {
        for (Integer pieza : piezasamatar) {
            if (!recorrido.contains(pieza))
                return false;
        }
        return true;
    }
    
    //*******************************************************************   Profundidad  **************************+
    
    static void cargacorte(int u) {
        corte=u;
    }
    
    static ArrayList<Integer> profundidad(int posicionInicial) {
        ArrayList<Integer> recorrido = new ArrayList();
        recorrido.add(posicionInicial);

        if (Programa.isFinished(recorrido))
            return recorrido;
        
        return Programa.buscarProfundidad(recorrido, 1);
    }

    public static ArrayList<Integer> buscarProfundidad(ArrayList<Integer> recorrido, int nivel) {
        if (nivel > corte)
            return null;

        int movimientos[] = obtenerMovimientos(recorrido);
        for (int movimiento : movimientos) {
            ArrayList<Integer> nuevoRecorrido = new ArrayList();
            nuevoRecorrido.addAll(recorrido);
            nuevoRecorrido.add(movimiento);
                
            if (Programa.isFinished(nuevoRecorrido))
                return nuevoRecorrido;
        
            ArrayList<Integer> resultado = Programa.buscarProfundidad(nuevoRecorrido, nivel+1);
            if (resultado != null)
                return resultado;
        }

        return null;
    }
    
    public static void main() {
        // Inicializo el tablero
        int[] t00 = {17,10};
        tablero[0][0] = new Casilla(t00);
        int[] t01 = {16,18,11};
        tablero [0][1] = new Casilla(t01);
        int[] t02 = {8,17,19,12};
        tablero [0][2] = new Casilla(t02);
        int[] t03 = {18,20,9,13};
        tablero [0][3] = new Casilla(t03);
        int[] t04 = {19,21,10,14};
        tablero [0][4] = new Casilla(t04);
        int[] t05 = {20,22,11,15};
        tablero [0][5] = new Casilla(t05);
        int[] t06 = {21,23,12};
        tablero [0][6] = new Casilla(t06);
        int[] t07 = {13,22};
        tablero [0][7] = new Casilla(t07);
        //termine de cargar la primer fila.
        int[] t08 = {25,18,2};
        tablero [1][0] = new Casilla(t08);
        int[] t09 = {24,26,19,3};
        tablero [1][1] = new Casilla(t09);
        int[] t10 = {16,25,27,20,4,0};
        tablero [1][2] = new Casilla(t10);
        int[] t11 = {1,17,26,28,21,5};
        tablero [1][3] = new Casilla(t11);
        int[] t12 = {2,18,27,29,22,6};
        tablero [1][4] = new Casilla(t12);
        int[] t13 = {3,19,28,30,23,7};
        tablero [1][5] = new Casilla(t13);
        int[] t14 = {4,20,29,31};
        tablero [1][6] = new Casilla(t14);
        int[] t15 = {5,21,30};
        tablero [1][7] = new Casilla(t15);
        //termine de cargar la 2da fila
        int[] t16 = {1,10,26,33};
        tablero [2][0] = new Casilla(t16);
        int[] t17 = {0,2,11,27,34,32};
        tablero [2][1] = new Casilla(t17);
        int[] t18 = {1,3,12,28,35,33,24,8};
        tablero [2][2] = new Casilla(t18);
        int[] t19 = {2,4,13,29,36,34,25,9};
        tablero [2][3] = new Casilla(t19);
        int[] t20 = {3,5,14,30,37,35,26,10};
        tablero [2][4] = new Casilla(t20);
        int[] t21 = {4,6,15,31,38,36,27,11};
        tablero [2][5] = new Casilla(t21);
        int[] t22 = {5,7,37,39,28,12};
        tablero [2][6] = new Casilla(t22);
        int[] t23 = {6,13,29,38};
        tablero [2][7] = new Casilla(t23);
        //termine de cargar la 3era fila
        int[] t24 = {9,18,34,41};
        tablero [3][0] = new Casilla(t24);
        int[] t25 = {8,10,19,35,40,42};
        tablero [3][1] = new Casilla(t25);
        int[] t26 = {9,11,20,36,43,41,32,16};
        tablero [3][2] = new Casilla(t26);
        int[] t27 = {10,12,21,37,44,42,33,17};
        tablero [3][3] = new Casilla(t27);
        int[] t28 = {11,13,22,38,45,43,34,18};
        tablero [3][4] = new Casilla(t28);
        int[] t29 = {12,14,23,39,46,44,19,35};
        tablero [3][5] = new Casilla(t29);
        int[] t30 = {13,15,45,47,36,20};
        tablero [3][6] = new Casilla(t30);
        int[] t31 = {14,21,37,46};
        tablero [3][7] = new Casilla(t31);
        //cargada la 4ta fila
        int[] t32 = {17,26,42,49};
        tablero [4][0] = new Casilla(t32);
        int[] t33 = {16,18,27,43,50,48};
        tablero [4][1] = new Casilla(t33);
        int[] t34 = {17,19,28,44,51,49,40,24};
        tablero [4][2] = new Casilla(t34);
        int[] t35 = {18,20,29,45,52,50,41,25};
        tablero [4][3] = new Casilla(t35);
        int[] t36 = {19,21,30,46,53,51,42,26};
        tablero [4][4] = new Casilla(t36);
        int[] t37 = {20,22,31,47,54,52,43,27};
        tablero [4][5] = new Casilla(t37);
        int[] t38 = {21,23,28,44,53,55};
        tablero [4][6] = new Casilla(t38);
        int[] t39 = {22,29,45,54};
        tablero [4][7] = new Casilla(t39);
        //fila 5 cargada
        int[] t40 = {25,34,50,57};
        tablero [5][0] = new Casilla(t40);
        int[] t41 = {24,26,35,51,58,56};
        tablero [5][1] = new Casilla(t41);
        int[] t42 = {25,27,36,52,59,57,48,32};
        tablero [5][2] = new Casilla(t42);
        int[] t43 = {26,28,37,53,60,58,49,33};
        tablero [5][3] = new Casilla(t43);
        int[] t44 = {27,29,38,54,61,59,50,34};
        tablero [5][4] = new Casilla(t44);
        int[] t45 = {28,30,39,55,62,60,51,35};
        tablero [5][5] = new Casilla(t45);
        int[] t46 = {29,31,36,52,61,63};
        tablero [5][6] = new Casilla(t46);
        int[] t47 = {30,37,53,62};
        tablero [5][7] = new Casilla(t47);
        //terminada fila 6
        int[] t48 = {33,42,58};
        tablero [6][0] = new Casilla(t48);
        int[] t49 = {32,34,43,59};
        tablero [6][1] = new Casilla(t49);
        int[] t50 = {33,35,44,60,40,56};
        tablero [6][2] = new Casilla(t50);
        int[] t51 = {34,36,45,61,57,41};
        tablero [6][3] = new Casilla(t51);
        int[] t52 = {35,37,46,62,58,42};
        tablero [6][4] = new Casilla(t52);
        int[] t53 = {36,38,47,63,59,43};
        tablero [6][5] = new Casilla(t53);
        int[] t54 = {37,39,44,60};
        tablero [6][6] = new Casilla(t54);
        int[] t55 = {38,45,61};
        tablero [6][7] = new Casilla(t55);
        //cargada fila 7
        int[] t56 = {41,50};
        tablero [7][0] = new Casilla(t56);
        int[] t57 = {40,42,51};
        tablero [7][1] = new Casilla(t57);
        int[] t58 = {41,43,48,52};
        tablero [7][2] = new Casilla(t58);
        int[] t59 = {42,44,49,53};
        tablero [7][3] = new Casilla(t59);
        int[] t60 = {43,45,50,54};
        tablero [7][4] = new Casilla(t60);
        int[] t61 = {44,46,51,55};
        tablero [7][5] = new Casilla(t61);
        int[] t62 = {45,47,52};
        tablero [7][6] = new Casilla(t62);
        int[] t63 = {46,53};
        tablero [7][7] = new Casilla(t63);
        //cargada fila 8
    } 
}



