/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import interfaces.IElevadorService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import modelo.Andar;
import modelo.Elevador;
import modelo.Turno;
import modelo.Uso;

/**
 *
 * @author fl_va
 */
public class ElevadorService implements IElevadorService{
    
    Uso[] usos = null;
    Andar[] andares = new Andar[16];
    Elevador[] elevadores = new Elevador[5];
    Turno[] turnos = new Turno[3];
    
    public ElevadorService(Uso[] usos) {
        this.usos = usos;
        
        this.contarUsoAndar();
        this.contarElvador();
        this.contarTurnos();
    }

    @Override
    public List<Integer> andarMenosUtilizado() {
        Arrays.sort(this.andares, new Comparator<Andar>(){
            public int compare(Andar a1, Andar a2){
                return a1.contagem.compareTo(a2.contagem);
            }
        });
        
        return Arrays.asList(this.andares[0].andar);
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {

        Arrays.sort(this.elevadores, new Comparator<Elevador>(){
            public int compare(Elevador el1, Elevador el2){
                return el2.contagem.compareTo(el1.contagem);
            }
        });
        
        return Arrays.asList(this.elevadores[0].elevador);
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
       return Arrays.asList(this.turnos[2].elevadorMaisUtilizado().elevador);
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        
        Arrays.sort(this.elevadores, new Comparator<Elevador>(){
            public int compare(Elevador el1, Elevador el2){
                return el1.contagem.compareTo(el2.contagem);
            }
        });
        
        return Arrays.asList(this.elevadores[0].elevador);
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
       return Arrays.asList(this.turnos[0].elevadorMenosUtilizado().elevador);
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        return Arrays.asList(this.turnos[2].turno);
    }

    @Override
    public float percentualDeUsoElevadorA() {
        return this.percentualDeUsoElevador('A');
    }

    @Override
    public float percentualDeUsoElevadorB() {
        return this.percentualDeUsoElevador('B');
    }

    @Override
    public float percentualDeUsoElevadorC() {
         return this.percentualDeUsoElevador('C');
    }

    @Override
    public float percentualDeUsoElevadorD() {
         return this.percentualDeUsoElevador('D');
    }

    @Override
    public float percentualDeUsoElevadorE() {
         return this.percentualDeUsoElevador('E');
    }
    
    
    private void contarUsoAndar() {
        for(int i = 0; i < 16; i++) {
            this.andares[i] = new Andar(i);
        }
        for (Uso uso : this.usos) {
            for(Andar andar: this.andares) {
                if(andar.andar == uso.andar) {
                    andar.incContagem();
                    break;
                }
            }
        }
    }
    private void contarElvador() {
        this.elevadores[0] = new Elevador('A');
        this.elevadores[1] = new Elevador('B');
        this.elevadores[2] = new Elevador('C');
        this.elevadores[3] = new Elevador('D');
        this.elevadores[4] = new Elevador('E');
        
        for (Uso uso : this.usos) {
            for(Elevador elevador: this.elevadores) {
                if(elevador.elevador == uso.elevador) {
                    elevador.incContagem();
                    break;
                }
            }
        }
    }
    
    private float percentualDeUsoElevador(Character el) {
        int total = 0;
        int cont = 0;
        for(Elevador elevador: this.elevadores) {
            total += elevador.contagem;
            if(elevador.elevador == el) {
                cont = elevador.contagem;
            }
        }
        
        float percentual = (cont *100) / total;
        return percentual;
    }
    
    private void contarTurnos() {
        this.turnos[0] = new Turno('M');
        this.turnos[1] = new Turno('V');
        this.turnos[2] = new Turno('N');
        
        for (Uso uso : this.usos) {
            for(Turno turno: this.turnos) {
                if(turno.turno == uso.turno) {
                    turno.incContagem();
                    turno.incContagemElevador(uso.elevador);
                    break;
                }
            }
        }
        
         Arrays.sort(this.turnos, new Comparator<Turno>(){
            public int compare(Turno t1, Turno t2){
                return t1.contagem.compareTo(t2.contagem);
            }
        });
        
    }
    
}
