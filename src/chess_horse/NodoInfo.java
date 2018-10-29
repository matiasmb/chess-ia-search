/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_horse;

import java.util.ArrayList;

/**
 *
 * @author mmartinezbla
 */
public class NodoInfo {
    
    private ArrayList<Integer> blackHorseRecorrido = new ArrayList<Integer>();
    private int heuristica;
    private int weight;

    public ArrayList<Integer> getBlackHorseRecorrido() {
        return blackHorseRecorrido;
    }

    public void addBlackHorsePosition(int blackHorsePosition) {
        this.blackHorseRecorrido.add(blackHorsePosition);
    }

    public void setBlackHorseRecorrido(ArrayList<Integer> blackHorseRecorrido) {
        this.blackHorseRecorrido = blackHorseRecorrido;
    }
    
    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
