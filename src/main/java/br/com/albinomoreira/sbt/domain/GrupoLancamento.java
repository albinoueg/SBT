package br.com.albinomoreira.sbt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "GRUPO_LANCAMENTO")
public class GrupoLancamento extends AbstractEntity<Long>{

    @NotBlank
    @Size(max = 100, min = 3)
    @Column(name = "NOME", nullable = false, unique = true, length = 100)
    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Lancamento> lancamentos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
