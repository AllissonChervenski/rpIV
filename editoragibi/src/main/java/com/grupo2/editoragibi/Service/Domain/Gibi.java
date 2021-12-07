package com.grupo2.editoragibi.Service.Domain;

import java.time.LocalDate;

/*gibi_id serial,
titulo_gibi varchar(20) not null,
data_inicio_publi date not null,
data_encerramento date,
primary key(gibi_id)*/

public class Gibi {
    private int id;
    private String titulo;
    private LocalDate inicioData;
    private LocalDate encData;
    private int edicoes = 0;

    public Gibi(){

    }

    public Gibi(String titulo){
        this.titulo = titulo;
        this.inicioData = LocalDate.now();
    }

    public void setEdicoes(Integer edicoes){
        this.edicoes = edicoes;
    }

    public int getEdicoes(){
        return this.edicoes;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getInicioData() {
        return inicioData;
    }
    public void setInicioData(LocalDate inicioData) {
        this.inicioData = inicioData;
    }
    public LocalDate getEncData() {
        return encData;
    }
    public void setEncData(LocalDate encData) {
        this.encData = encData;
    }
  


}
