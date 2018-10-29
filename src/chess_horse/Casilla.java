package chess_horse;

public class Casilla {
    int[] movimientos;

    Casilla(int[] movimientos) {
        this.movimientos = movimientos;
    }
    
    int[] posibilidades() {
        return movimientos;
    }
}