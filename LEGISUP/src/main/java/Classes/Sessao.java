/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author marcio.moda
 */
public class Sessao {
    public int sessao_id;
    public String data;
    public String pauta;
    public String ata;
    public String status;

    public Sessao(int sessao_id, String data, String pauta, String ata, String status) {
        this.sessao_id = sessao_id;
        this.data = data;
        this.pauta = pauta;
        this.ata = ata;
        this.status = status;
    }

    public int getSessao_id() {
        return sessao_id;
    }

    public void setSessao_id(int sessao_id) {
        this.sessao_id = sessao_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getAta() {
        return ata;
    }

    public void setAta(String ata) {
        this.ata = ata;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
