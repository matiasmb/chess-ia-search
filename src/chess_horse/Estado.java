package chess_horse;

import static chess_horse.Programa.piezasamatar;
import java.util.ArrayList;

public class Estado implements Comparable<Estado> {
    public ArrayList<Integer> recorrido;
    public int peso;
    
    public Estado(ArrayList<Integer> recorrido) {
        this.recorrido = recorrido;
        this.peso = calcularPeso(recorrido);
    }
    
    private int calcularPeso(ArrayList<Integer> recorrido) {
        int peso = piezasamatar.size();
        
        for (Integer casilla : recorrido) {
            if (piezasamatar.contains(casilla))
                peso--;
        }
        
        peso = peso + recorrido.size() - 1;
        
        return peso;
    }

    @Override
    public int compareTo(Estado e) {
        return this.peso - e.peso;
    }
}
