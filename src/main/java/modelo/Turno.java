/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author fl_va
 */
public class Turno {
    public Character turno;
    public Integer contagem = 0;
    private Elevador[] elevadores = new Elevador[5];
    
    public Turno(Character turno) {
        this.turno = turno;
        this.elevadores[0] = new Elevador('A');
        this.elevadores[1] = new Elevador('B');
        this.elevadores[2] = new Elevador('C');
        this.elevadores[3] = new Elevador('D');
        this.elevadores[4] = new Elevador('E');
    }
    public void incContagem() {
        this.contagem++;
    }
    
    public void incContagemElevador(Character el) {
        for(Elevador elevador: this.elevadores) {
            if(elevador.elevador == el) {
                elevador.incContagem();
                break;
            }
        }
    }
    
    public Elevador elevadorMaisUtilizado() {
        this.ordernarElevadores();
        return this.elevadores[4];
    }
    
    public Elevador elevadorMenosUtilizado() {
        this.ordernarElevadores();
        return this.elevadores[0];
    }
    
    private void ordernarElevadores() {
        Arrays.sort(this.elevadores, new Comparator<Elevador>(){
            public int compare(Elevador el1, Elevador el2){
                return el1.contagem.compareTo(el2.contagem);
            }
        });
    }
    
}
