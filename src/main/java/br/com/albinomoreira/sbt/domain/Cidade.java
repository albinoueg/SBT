package br.com.albinomoreira.sbt.domain;

import javax.persistence.*;

@Entity
@Table(name = "CIDADE")
public class Cidade extends AbstractEntity<Long>{

    @Column(name = "NOME", nullable = false, unique = true, length = 60)
    private String nomeCidade;

    @Column(name = "IBGE")
    private Integer codigoIbge;

    @ManyToOne
    @JoinColumn(name = "UF")
    private Estado ufCidade;

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Estado getUfCidade() {
        return ufCidade;
    }

    public void setUfCidade(Estado ufCidade) {
        this.ufCidade = ufCidade;
    }
}
