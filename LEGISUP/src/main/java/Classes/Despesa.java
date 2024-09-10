/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author marcio.moda
 */
public class Despesa {
    public int despesa_id;
    public int orcamento_id;
    public float Valor;
    public String Descricao;
    public String Data;

    public int getDespesa_id() {
        return despesa_id;
    }

    public void setDespesa_id(int despesa_id) {
        this.despesa_id = despesa_id;
    }

    public int getOrcamento_id() {
        return orcamento_id;
    }

    public void setOrcamento_id(int orcamento_id) {
        this.orcamento_id = orcamento_id;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public Despesa(int despesa_id, int orcamento_id, float Valor, String Descricao, String Data) {
        this.despesa_id = despesa_id;
        this.orcamento_id = orcamento_id;
        this.Valor = Valor;
        this.Descricao = Descricao;
        this.Data = Data;
    }
}
