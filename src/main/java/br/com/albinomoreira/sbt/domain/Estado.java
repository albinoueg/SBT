package br.com.albinomoreira.sbt.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ESTADO")
public class Estado extends AbstractEntity<Long>{

    @Column(name = "NOME", nullable = false, unique = true, length = 60)
    private String nomeEstado;

    @Column(name = "UF", length = 2)
    private String ufEstado;

    @Column(name = "IBGE")
    private Integer codigoIbge;

    @Column(name = "DDD", length = 2)
    private String ddd;

    @ManyToOne
    @JoinColumn(name = "PAIS")
    private Pais pais;

    @OneToMany(mappedBy = "ufCidade")
    private List<Cidade> cidade;

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUfEstado() {
        return ufEstado;
    }

    public void setUfEstado(String ufEstado) {
        this.ufEstado = ufEstado;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }
}
