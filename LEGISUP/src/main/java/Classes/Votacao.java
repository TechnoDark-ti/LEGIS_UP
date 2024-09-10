/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author marcio.moda
 */
public class Votacao {
    public int votacao_id;
    public int sessao_id;
    public int cpf_fk;
    public String voto;
    public String justificativa;

    public Votacao(int votacao_id, int sessao_id, int cpf_fk, String voto, String justificativa) {
        this.votacao_id = votacao_id;
        this.sessao_id = sessao_id;
        this.cpf_fk = cpf_fk;
        this.voto = voto;
        this.justificativa = justificativa;
    }

    public int getVotacao_id() {
        return votacao_id;
    }

    public void setVotacao_id(int votacao_id) {
        this.votacao_id = votacao_id;
    }

    public int getSessao_id() {
        return sessao_id;
    }

    public void setSessao_id(int sessao_id) {
        this.sessao_id = sessao_id;
    }

    public int getCpf_fk() {
        return cpf_fk;
    }

    public void setCpf_fk(int cpf_fk) {
        this.cpf_fk = cpf_fk;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
    
}
