/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fl_va
 */
public class Elevador {
    public Character elevador = null;
    public Integer contagem = 0;
    
    public Elevador(Character elevador) {
        this.elevador = elevador;
    }
    
    public void incContagem() {
        this.contagem++;
    }
    
}
