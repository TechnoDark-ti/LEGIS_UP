/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
/**
 *
 * @author marcio.moda
 */
public class FolhaPagamento {
    public int folha_id;
    public int cpf_fk;
    public String mes;
    public int ano;
    public double valor_bruto;
    public double valor_liquido;
    public double desconto;

    public int getFolha_id() {
        return folha_id;
    }

    public void setFolha_id(int folha_id) {
        this.folha_id = folha_id;
    }

    public int getCpf_fk() {
        return cpf_fk;
    }

    public void setCpf_fk(int cpf_fk) {
        this.cpf_fk = cpf_fk;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(double valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

    public double getValor_liquido() {
        return valor_liquido;
    }

    public void setValor_liquido(double valor_liquido) {
        this.valor_liquido = valor_liquido;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public FolhaPagamento(int folha_id, int cpf_fk, String mes, int ano, double valor_bruto, double valor_liquido, double desconto) {
        this.folha_id = folha_id;
        this.cpf_fk = cpf_fk;
        this.mes = mes;
        this.ano = ano;
        this.valor_bruto = valor_bruto;
        this.valor_liquido = valor_liquido;
        this.desconto = desconto;
    }


}
