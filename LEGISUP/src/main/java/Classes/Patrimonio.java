/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author marcio.moda
 */
public class Patrimonio {
    public int patrimonio_id;
    public String nome;
    public String descricao;
    public double valor;
    public float data_aquisicao;

    public Patrimonio(int patrimonio_id, String nome, String descricao, double valor, float data_aquisicao) {
        this.patrimonio_id = patrimonio_id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data_aquisicao = data_aquisicao;
    }

    public int getPatrimonio_id() {
        return patrimonio_id;
    }

    public void setPatrimonio_id(int patrimonio_id) {
        this.patrimonio_id = patrimonio_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public float getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(float data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

}
