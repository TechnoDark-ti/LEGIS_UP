/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Protocolo {
   public int protocolo_id;
   public int cpf_fk;
   public String data_abertura;
   public String descricao;
   public String status;

    public Protocolo(int protocolo_id, int cpf_fk, String data_abertura, String descricao, String status) {
        this.protocolo_id = protocolo_id;
        this.cpf_fk = cpf_fk;
        this.data_abertura = data_abertura;
        this.descricao = descricao;
        this.status = status;
    }

    public int getProtocolo_id() {
        return protocolo_id;
    }

    public void setProtocolo_id(int protocolo_id) {
        this.protocolo_id = protocolo_id;
    }

    public int getCpf_fk() {
        return cpf_fk;
    }

    public void setCpf_fk(int cpf_fk) {
        this.cpf_fk = cpf_fk;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 
}
