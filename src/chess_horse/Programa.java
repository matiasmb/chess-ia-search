package  chess_horse;
import java.util.*;

public class Programa {
    static posicionesposiblesxpiezas posiciones[][]=new posicionesposiblesxpiezas[8][8]; //el primer subindice es el de los renglones!
    /* ak tengo que cargar las posiciones de los caballos que tengo que matar*/static int[]piezaspormatar=new int[1];   /**
     * @param args the command line arguments
     */
    public static ArrayList <Integer> piezasamatar = new  ArrayList();
    public static ArrayList <NodoInfo> abiertos = new ArrayList();  //ver pero creo q esta bien
    public static ArrayList <Integer> resultadoff=new ArrayList();
    public static int anterior=234;
    public static int control=0;   //variable global
    public static int corte=0;
    public static int totalWhiteHorses;
    
    public static void  resetear() {
        piezasamatar.clear();
        abiertos.clear();
        resultadoff.clear();
        anterior=234;
        totalWhiteHorses=0;
        corte=0;
        control=0;
    }
    
    public static boolean checkAllDead(int p) {
        boolean isAllKilled = true;
        for (int i=0; i<piezaspormatar.length; i++){  //cuando mata hay q poner un high value
            if (piezaspormatar[i] < 64) {
                isAllKilled = false;
            }
            if(piezaspormatar[i]==p) {
                piezaspormatar[i]=999;
            }
            
        }
        return (isAllKilled);
    }
    
    public static boolean matar1pieza(int p){
        boolean isKilled=false;
        for (int y=0; y<piezaspormatar.length; y++){
            if (piezaspormatar[y] == p ){
                piezaspormatar[y] = 999; //le mando un high value ak si mate una pieza, ya que 0 tambien es una posicion!
                isKilled=true;
            }
        }
        return (isKilled);
    }
    
    public static void  cargarpiezasamatar(ArrayList p) {
        piezasamatar.clear();
        piezasamatar=p;
        
    };
    
    public static ArrayList <Integer> lasquequedanpormatar() {
        return (piezasamatar);
    }
    
//  *********************************************   A*  *************************************
    //devuelve nodo donde esta el menor valor de la funcion euristica y le agrega como ultimo elemento la posicion de ese nodo en el arraylist abiertos
    public static NodoInfo getNodoByMinHeuristica() {
        if (abiertos.size() > 1) {
            Programa.deleteDuplicated();
        }

        int costoTotalMin = 0;
        int positionNextNode = 0;
        
        for (int j=0; j<abiertos.size() ; j++){
            int costoTotal = abiertos.get(j).getWeight() + abiertos.get(j).getHeuristica();
            if(costoTotalMin != 0 && costoTotalMin > costoTotal) {
                costoTotalMin = costoTotal;
                positionNextNode = j;
            } else {
                costoTotalMin = costoTotal;
            }
        }

        NodoInfo bestNextNodo = abiertos.get(positionNextNode);
        bestNextNodo.addBlackHorsePosition(positionNextNode);
        return bestNextNodo;
    }

    public static boolean killAllAStar(NodoInfo nextNodo){

        int countDeadPieces = 1;

        //ahora tengo q recorrer las cada una de las piezas a matar y preguntar si se encuentra en h, si todas estan es porque en la secuencia de movimientos mate todas!
        for (int j=0;j<piezasamatar.size();j++){
            if(nextNodo.getBlackHorseRecorrido().contains(piezasamatar.get(j))) {
                countDeadPieces ++;
            }
        }
        
        if (countDeadPieces == totalWhiteHorses){
            resultadoff = nextNodo.getBlackHorseRecorrido();
        }
        
        return countDeadPieces == totalWhiteHorses;
    }

    public static void generateNodoAndInsert (NodoInfo nextNodo) {
        
        int positionInOpenList = nextNodo.getBlackHorseRecorrido().get(nextNodo.getBlackHorseRecorrido().size() - 1);   //posicion del nodo en abiertos
        int lastPositionInNodo = nextNodo.getBlackHorseRecorrido().get(nextNodo.getBlackHorseRecorrido().size() - 2);  //ultima posicion de la secuencia de movimientos del nodo

        int movimientosPosibles[] = new int[8];
        movimientosPosibles=(posiciones[(lastPositionInNodo/8)][(lastPositionInNodo-(8*(lastPositionInNodo/8)))]).posibilidades();

        ArrayList <Integer> whiteHorsesAlive=new ArrayList();

        for (int iterator=0; iterator<piezasamatar.size(); iterator++){
            if (!nextNodo.getBlackHorseRecorrido().contains(piezasamatar.get(iterator)))
                whiteHorsesAlive.add(piezasamatar.get(iterator));
        }
        
        for (int j=0; j<movimientosPosibles.length; j++){   //itero por todas las posiciones posibles
            if (movimientosPosibles[j]<65){
                NodoInfo nextNodoToInsert = new NodoInfo();
                nextNodoToInsert.setHeuristica(nextNodo.getHeuristica());
                nextNodoToInsert.setWeight(nextNodo.getWeight());
                nextNodoToInsert.setBlackHorseRecorrido(nextNodo.getBlackHorseRecorrido());
                
                nextNodoToInsert.getBlackHorseRecorrido().remove(nextNodoToInsert.getBlackHorseRecorrido().size()-1);  //borramos el ultimo elemento ya que era el de la posicion en abiertos
                
                nextNodoToInsert.getBlackHorseRecorrido().add(movimientosPosibles[j]);
                nextNodoToInsert.setWeight(nextNodoToInsert.getWeight()+1);
                nextNodoToInsert.setHeuristica(Programa.heuristica(whiteHorsesAlive));
                
                abiertos.add(positionInOpenList,nextNodoToInsert);
                for(int iterator=0; iterator<abiertos.get(positionInOpenList).getBlackHorseRecorrido().size();iterator++) {
                    System.out.println(abiertos.get(positionInOpenList).getBlackHorseRecorrido().get(iterator)+" stepInNode: "+iterator);
                }
                if(j==0) {
                    abiertos.remove(positionInOpenList+1);
                }
                positionInOpenList++;
            }
        }
    }
    
    public static int heuristica(ArrayList<Integer> whiteHorsesAlive) {
        return (1000-(totalWhiteHorses-(whiteHorsesAlive.size()))*6);
    }
    
    public static ArrayList <Integer> aStar(int positionBlackHorses){
        totalWhiteHorses = piezasamatar.size();
        
        NodoInfo nodoInfo = new NodoInfo();
        
        nodoInfo.setWeight(0);
        nodoInfo.setHeuristica(Programa.heuristica(piezasamatar));
        nodoInfo.addBlackHorsePosition(positionBlackHorses);

        abiertos.add(nodoInfo);

        boolean isAllDead = true;
        while(isAllDead){
            NodoInfo nextNodo = Programa.getNodoByMinHeuristica();   //la ultima posicion de u es la posicion dentro de abiertos donde esta el menor
            if (!Programa.killAllAStar(nextNodo)){
                Programa.generateNodoAndInsert(nextNodo);
            } else {
                isAllDead=false;
                for (int y=0;y<abiertos.size();y++) {
                    for (int c=0;c<abiertos.get(y).getBlackHorseRecorrido().size();c++){
                        System.out.println(abiertos.get(y).getBlackHorseRecorrido().get(c));
                    }
                }
            }
        }
        
        for (int l=0;l<resultadoff.size();l++) {
            System.out.println(resultadoff.get(l));
        }

        return (resultadoff);
    }
    
    public static void deleteDuplicated()
    {
        ArrayList <Integer> posicionesaborrar=new ArrayList() ;
        int ultimaPosicionNodoActual;
        
        for (int iterator=0; iterator < abiertos.size();iterator++){
            ultimaPosicionNodoActual = abiertos.get(iterator).getBlackHorseRecorrido().get(abiertos.get(iterator).getBlackHorseRecorrido().size()-1); //ultimo elemento de la secuencia de movimientos del nodo
            for (int secondIterator=0; secondIterator < abiertos.size(); secondIterator++){
                if ((ultimaPosicionNodoActual == abiertos.get(secondIterator).getBlackHorseRecorrido().get(abiertos.get(secondIterator).getBlackHorseRecorrido().size()-1))
                        &&((abiertos.get(secondIterator).getWeight()+abiertos.get(secondIterator).getHeuristica())
                        >(abiertos.get(iterator).getWeight() + abiertos.get(iterator).getHeuristica()))) {
                    if (!posicionesaborrar.contains(secondIterator)) {
                        posicionesaborrar.add(secondIterator);}}
            }
            
        }
        
        int h;
        Collections.sort(posicionesaborrar);
        while (!posicionesaborrar.isEmpty()){//ak va el codigo para eliminar posiciones repetidas de posiciones a borrar!!
            h=posicionesaborrar.get(0);
            abiertos.remove(h);
            posicionesaborrar.remove(0);
            if (!posicionesaborrar.isEmpty()){
                for (int i=0;i<posicionesaborrar.size();i++) {   //actualizo todos los indices cuando borro un nodoo
                    int k =posicionesaborrar.get(i); k--;
                    posicionesaborrar.set(i,k);
                }}
            
        }
        
    }
    
//*******************************************************************   Amplitud  **************************+
    
    public static ArrayList<Integer> amplitud(int posicionInicial){
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
                if (movimiento < 65) {
                    ArrayList<Integer> nuevoRecorrido = new ArrayList();
                    nuevoRecorrido.addAll(recorrido);
                    nuevoRecorrido.add(movimiento);
                    
                    if (Programa.isFinished(nuevoRecorrido))
                        return nuevoRecorrido;
                    
                    nuevosRecorridos.add(nuevoRecorrido);
                }
            }
        }

        return Programa.buscarAmplitud(nuevosRecorridos);
    }

    static int[] obtenerMovimientos(ArrayList<Integer> recorrido) {
        int i = recorrido.get(recorrido.size()-1)/8;
        int j = recorrido.get(recorrido.size()-1) - recorrido.get(recorrido.size()-1)/8*8;
        return posiciones[i][j].posibilidades();
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
            if (movimiento < 65) {
                ArrayList<Integer> nuevoRecorrido = new ArrayList();
                nuevoRecorrido.addAll(recorrido);
                nuevoRecorrido.add(movimiento);

                if (Programa.isFinished(nuevoRecorrido))
                    return nuevoRecorrido;

                ArrayList<Integer> resultado = Programa.buscarProfundidad(nuevoRecorrido, nivel+1);
                if (resultado != null)
                    return resultado;
            }
        }

        return null;
    }
    
    public static void main() {
        //arreglo bidimensional que va a contener todos los posibles movimientos del caballo de acuerdo al lugar donde este
        posicionesposiblesxpiezas t00=new posicionesposiblesxpiezas(17,10,9999,9999,9999,9999,999,999);
        posiciones[0][0]=t00;
        posicionesposiblesxpiezas t01=new posicionesposiblesxpiezas(16,18,11,999,999,9999,9999,999);
        posiciones [0][1]=t01;
        posicionesposiblesxpiezas t02=new posicionesposiblesxpiezas(8,17,19,12,999,999,999,9999);
        posiciones [0][2]=t02;
        posicionesposiblesxpiezas t03=new posicionesposiblesxpiezas(18,20,9,13,999,999,9999,9999);
        posiciones [0][3]=t03;
        posicionesposiblesxpiezas t04=new posicionesposiblesxpiezas(19,21,10,14,999,9999,999,999);
        posiciones [0][4]=t04;
        posicionesposiblesxpiezas t05=new posicionesposiblesxpiezas(20,22,11,15,999,999,999,999);
        posiciones [0][5]=t05;
        posicionesposiblesxpiezas t06=new posicionesposiblesxpiezas(21,23,12,999,999,9999,9999,999);
        posiciones [0][6]=t06;
        posicionesposiblesxpiezas t07=new posicionesposiblesxpiezas(13,22,999,999,999,999,999,999);
        posiciones [0][7]=t07;
        //termine de cargar la primer fila.
        posicionesposiblesxpiezas t08=new posicionesposiblesxpiezas(25,18,2,999,999,999,999,999);
        posiciones [1][0]=t08;
        posicionesposiblesxpiezas t09=new posicionesposiblesxpiezas(24,26,19,3,999,999,999,999);
        posiciones [1][1]=t09;
        posicionesposiblesxpiezas t10=new posicionesposiblesxpiezas(16,25,27,20,4,0,999,999);
        posiciones [1][2]=t10;
        posicionesposiblesxpiezas t11=new posicionesposiblesxpiezas(1,17,26,28,21,5,999,999);
        posiciones [1][3]=t11;
        posicionesposiblesxpiezas t12=new posicionesposiblesxpiezas(2,18,27,29,22,6,999,999);
        posiciones [1][4]=t12;
        posicionesposiblesxpiezas t13=new posicionesposiblesxpiezas(3,19,28,30,23,7,999,999);
        posiciones [1][5]=t13;
        posicionesposiblesxpiezas t14=new posicionesposiblesxpiezas(4,20,29,31,999,999,999,999);
        posiciones [1][6]=t14;
        posicionesposiblesxpiezas t15=new posicionesposiblesxpiezas(5,21,30,999,999,999,999,999);
        posiciones [1][7]=t15;
        //termine de cargar la 2da fila
        posicionesposiblesxpiezas t16=new posicionesposiblesxpiezas(1,10,26,33,999,999,999,999);
        posiciones [2][0]=t16;
        posicionesposiblesxpiezas t17=new posicionesposiblesxpiezas(0,2,11,27,34,32,999,999);
        posiciones [2][1]=t17;
        posicionesposiblesxpiezas t18=new posicionesposiblesxpiezas(1,3,12,28,35,33,24,8);
        posiciones [2][2]=t18;
        posicionesposiblesxpiezas t19=new posicionesposiblesxpiezas(2,4,13,29,36,34,25,9);
        posiciones [2][3]=t19;
        posicionesposiblesxpiezas t20=new posicionesposiblesxpiezas(3,5,14,30,37,35,26,10);
        posiciones [2][4]=t20;
        posicionesposiblesxpiezas t21=new posicionesposiblesxpiezas(4,6,15,31,38,36,27,11);
        posiciones [2][5]=t21;
        posicionesposiblesxpiezas t22=new posicionesposiblesxpiezas(5,7,37,39,28,12,999,999);
        posiciones [2][6]=t22;
        posicionesposiblesxpiezas t23=new posicionesposiblesxpiezas(6,13,29,38,999,999,999,999);
        posiciones [2][7]=t23;
        //termine de cargar la 3era fila
        posicionesposiblesxpiezas t24=new posicionesposiblesxpiezas(9,18,34,41,999,999,999,999);
        posiciones [3][0]=t24;
        posicionesposiblesxpiezas t25=new posicionesposiblesxpiezas(8,10,19,35,40,42,999,999);
        posiciones [3][1]=t25;
        posicionesposiblesxpiezas t26=new posicionesposiblesxpiezas(9,11,20,36,43,41,32,16);
        posiciones [3][2]=t26;
        posicionesposiblesxpiezas t27=new posicionesposiblesxpiezas(10,12,21,37,44,42,33,17);
        posiciones [3][3]=t27;
        posicionesposiblesxpiezas t28=new posicionesposiblesxpiezas(11,13,22,38,45,43,34,18);
        posiciones [3][4]=t28;
        posicionesposiblesxpiezas t29=new posicionesposiblesxpiezas(12,14,23,39,46,44,19,35);
        posiciones [3][5]=t29;
        posicionesposiblesxpiezas t30=new posicionesposiblesxpiezas(13,15,45,47,36,20,999,999);
        posiciones [3][6]=t30;
        posicionesposiblesxpiezas t31=new posicionesposiblesxpiezas(14,21,37,46,999,999,999,999);
        posiciones [3][7]=t31;
        //cargada la 4ta fila
        posicionesposiblesxpiezas t32=new posicionesposiblesxpiezas(17,26,42,49,999,999,999,999);
        posiciones [4][0]=t32;
        posicionesposiblesxpiezas t33=new posicionesposiblesxpiezas(16,18,27,43,50,48,999,999);
        posiciones [4][1]=t33;
        posicionesposiblesxpiezas t34=new posicionesposiblesxpiezas(17,19,28,44,51,49,40,24);
        posiciones [4][2]=t34;
        posicionesposiblesxpiezas t35=new posicionesposiblesxpiezas(18,20,29,45,52,50,41,25);
        posiciones [4][3]=t35;
        posicionesposiblesxpiezas t36=new posicionesposiblesxpiezas(19,21,30,46,53,51,42,26);
        posiciones [4][4]=t36;
        posicionesposiblesxpiezas t37=new posicionesposiblesxpiezas(20,22,31,47,54,52,43,27);
        posiciones [4][5]=t37;
        posicionesposiblesxpiezas t38=new posicionesposiblesxpiezas(21,23,28,44,53,55,999,999);
        posiciones [4][6]=t38;
        posicionesposiblesxpiezas t39=new posicionesposiblesxpiezas(22,29,45,54,999,999,999,999);
        posiciones [4][7]=t39;
        //fila 5 cargada
        posicionesposiblesxpiezas t40=new posicionesposiblesxpiezas(25,34,50,57,999,999,999,999);
        posiciones [5][0]=t40;
        posicionesposiblesxpiezas t41=new posicionesposiblesxpiezas(24,26,35,51,58,56,999,999);
        posiciones [5][1]=t41;
        posicionesposiblesxpiezas t42=new posicionesposiblesxpiezas(25,27,36,52,59,57,48,32);
        posiciones [5][2]=t42;
        posicionesposiblesxpiezas t43=new posicionesposiblesxpiezas(26,28,37,53,60,58,49,33);
        posiciones [5][3]=t43;
        posicionesposiblesxpiezas t44=new posicionesposiblesxpiezas(27,29,38,54,61,59,50,34);
        posiciones [5][4]=t44;
        posicionesposiblesxpiezas t45=new posicionesposiblesxpiezas(28,30,39,55,62,60,51,35);
        posiciones [5][5]=t45;
        posicionesposiblesxpiezas t46=new posicionesposiblesxpiezas(29,31,36,52,61,63,999,999);
        posiciones [5][6]=t46;
        posicionesposiblesxpiezas t47=new posicionesposiblesxpiezas(30,37,53,62,999,999,999,999);
        posiciones [5][7]=t47;
        //terminada fila 6
        posicionesposiblesxpiezas t48=new posicionesposiblesxpiezas(33,42,58,999,999,999,999,999);
        posiciones [6][0]=t48;
        posicionesposiblesxpiezas t49=new posicionesposiblesxpiezas(32,34,43,59,999,999,999,999);
        posiciones [6][1]=t49;
        posicionesposiblesxpiezas t50=new posicionesposiblesxpiezas(33,35,44,60,40,56,999,999);
        posiciones [6][2]=t50;
        posicionesposiblesxpiezas t51=new posicionesposiblesxpiezas(34,36,45,61,57,41,999,999);
        posiciones [6][3]=t51;
        posicionesposiblesxpiezas t52=new posicionesposiblesxpiezas(35,37,46,62,58,42,999,999);
        posiciones [6][4]=t52;
        posicionesposiblesxpiezas t53=new posicionesposiblesxpiezas(36,38,47,63,59,43,999,999);
        posiciones [6][5]=t53;
        posicionesposiblesxpiezas t54=new posicionesposiblesxpiezas(37,39,44,60,999,999,999,999);
        posiciones [6][6]=t54;
        posicionesposiblesxpiezas t55=new posicionesposiblesxpiezas(38,45,61,999,999,999,999,999);
        posiciones [6][7]=t55;
        //cargada fila 7
        posicionesposiblesxpiezas t56=new posicionesposiblesxpiezas(41,50,999,999,999,999,999,999);
        posiciones [7][0]=t56;
        posicionesposiblesxpiezas t57=new posicionesposiblesxpiezas(40,42,51,999,999,999,999,999);
        posiciones [7][1]=t57;
        posicionesposiblesxpiezas t58=new posicionesposiblesxpiezas(41,43,48,52,999,999,999,999);
        posiciones [7][2]=t58;
        posicionesposiblesxpiezas t59=new posicionesposiblesxpiezas(42,44,49,53,999,999,999,999);
        posiciones [7][3]=t59;
        posicionesposiblesxpiezas t60=new posicionesposiblesxpiezas(43,45,50,54,999,999,999,999);
        posiciones [7][4]=t60;
        posicionesposiblesxpiezas t61=new posicionesposiblesxpiezas(44,46,51,55,999,999,999,999);
        posiciones [7][5]=t61;
        posicionesposiblesxpiezas t62=new posicionesposiblesxpiezas(45,47,52,999,999,999,999,999);
        posiciones [7][6]=t62;
        posicionesposiblesxpiezas t63=new posicionesposiblesxpiezas(46,53,999,999,999,999,999,999);
        posiciones [7][7]=t63;
        //cargada fila 8
        
    } 
}



