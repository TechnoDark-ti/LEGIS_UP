/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author marcio.moda
 */
public class Orcamento {
   public int orcamento_id;
   public int ano;
   public double valor_total;

    public Orcamento(int orcamento_id, int ano, double valor_total) {
        this.orcamento_id = orcamento_id;
        this.ano = ano;
        this.valor_total = valor_total;
    }

    public int getOrcamento_id() {
        return orcamento_id;
    }

    public void setOrcamento_id(int orcamento_id) {
        this.orcamento_id = orcamento_id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

}
