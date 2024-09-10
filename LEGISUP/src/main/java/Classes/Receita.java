/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author marcio.moda
 */
public class Receita {
    public int receita_id;
    public int orcamento_id;
    public double valor;
    public String descricao;
    public String data;	

    public Receita(int receita_id, int orcamento_id, double valor, String descricao, String data) {
        this.receita_id = receita_id;
        this.orcamento_id = orcamento_id;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }

    public int getReceita_id() {
        return receita_id;
    }

    public void setReceita_id(int receita_id) {
        this.receita_id = receita_id;
    }

    public int getOrcamento_id() {
        return orcamento_id;
    }

    public void setOrcamento_id(int orcamento_id) {
        this.orcamento_id = orcamento_id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
