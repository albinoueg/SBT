package br.com.albinomoreira.sbt.enums;

public enum EnumFormaPagamento {

    DINHEIRO("Dinheiro"),
    DEBITO("Débito"),
    CREDITO_A_VISTA("Crédito à vista"),
    CREDITO_PARCELADO("Crédito parcelado");

    private String descricao;

    EnumFormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
