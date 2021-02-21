package br.com.albinomoreira.sbt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PAIS")
public class Pais extends AbstractEntity<Long>{

    @Column(name = "NOME", nullable = false, unique = true, length = 60)
    private String nomePais;

    @Column(name = "NOME_PT")
    private String nomeEmPortuguesPais;

    @Column(name = "SIGLA", length = 2)
    private String siglaPais;

    @Column(name = "BACEN")
    private Integer codigoBacen;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estado;

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNomeEmPortuguesPais() {
        return nomeEmPortuguesPais;
    }

    public void setNomeEmPortuguesPais(String nomeEmPortuguesPais) {
        this.nomeEmPortuguesPais = nomeEmPortuguesPais;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }

    public Integer getCodigoBacen() {
        return codigoBacen;
    }

    public void setCodigoBacen(Integer codigoBacen) {
        this.codigoBacen = codigoBacen;
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }
}
