/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fl_va
 */
public class Andar {
    public Integer andar = 0;
    public Integer contagem = 0;
    
    public Andar(int andar) {
        this.andar = andar;
    }
    public void incContagem() {
        this.contagem++;
    }
}
