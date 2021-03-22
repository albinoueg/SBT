package br.com.albinomoreira.sbt.domain;

import br.com.albinomoreira.sbt.enums.EnumFormaPagamento;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "LANCAMENTO")
public class Lancamento extends AbstractEntity<Long>{

    @NotNull
    @PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_lancamento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataLancamento;

    @NotNull
    @PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_compra", nullable = false, columnDefinition = "DATE")
    private LocalDate dataCompra;

    @Digits(integer = 5, fraction = 0)
    @Column(name = "quant_parcelas", nullable = false, length = 5)
    private Integer quantParcelas;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "valor_total", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal valorTotal;

    @NotNull(message = "{NotNull.forma.pagamento}")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumFormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "GRUPO_LANCAMENTO")
    private GrupoLancamento grupo;

    @ManyToOne
    @JoinColumn(name = "DESCRICAO_LANCAMENTO")
    private DescricaoLancamento descricao;

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getQuantParcelas() {
        return quantParcelas;
    }

    public void setQuantParcelas(Integer quantParcelas) {
        this.quantParcelas = quantParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public GrupoLancamento getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoLancamento grupo) {
        this.grupo = grupo;
    }

    public DescricaoLancamento getDescricao() {
        return descricao;
    }

    public void setDescricao(DescricaoLancamento descricao) {
        this.descricao = descricao;
    }
}
