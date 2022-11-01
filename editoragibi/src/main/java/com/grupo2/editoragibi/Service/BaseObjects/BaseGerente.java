package com.grupo2.editoragibi.Service.BaseObjects;

public abstract class BaseGerente { 

    protected String nomeGerente;
    protected long idGerente;
    protected BaseEditora baseEditora;

    public String getNomeGerente() {
        return nomeGerente;
    }
    public abstract void setNomeGerente(String nomeGerente);
    
    public long getIdGerente() {
        return idGerente;
    }
    public  void setIdGerente(long idGerente){
        this.idGerente = idGerente;
    }

    public BaseEditora getBaseEditora() {
        return baseEditora;
    }
    public abstract void setBaseEditora(BaseEditora baseEditora);


    
}