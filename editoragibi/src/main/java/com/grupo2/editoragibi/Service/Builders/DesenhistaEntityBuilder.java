package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseDesenhistaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("desenhistaEntityBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DesenhistaEntityBuilder implements IBaseDesenhistaBuilder {

    private DesenhistaEntity desenhista;

    @Autowired
    EdicoesGibiRepository edicoesGibiRepository;


    public DesenhistaEntityBuilder() {
        reset();
    }

    private void reset() {
        desenhista = new DesenhistaEntity();
    }

    @Override
    public void setDesenhistaId(int id) {
        desenhista.setDesenhistaId(id);
    }

    @Override
    public void setNomeDesenhista(String nomeDesenhista) {
        desenhista.setNomeDesenhista(nomeDesenhista);
    }

    @Override
    public void setEnderecoDesenhista(String enderecoDesenhista) {
        desenhista.setEnderecoDesenhista(enderecoDesenhista);
    }

    @Override
    public void setPaisNascimento(String paisNascimento) {
        desenhista.setPaisNascimento(paisNascimento);
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        desenhista.setDataNascimento(dataNascimento);
    }

    @Override
    public void setDataFalecimento(LocalDate dataFalecimento) {
        desenhista.setDataFalecimento(dataFalecimento);
    }

    @Override
    public void setDataContratacao(LocalDate dataContratacao) {
        desenhista.setDataContratacao(dataContratacao);
    }

    @Override
    public void setDataDemissao(LocalDate dataDemissao) {
        desenhista.setDataDemissao(dataDemissao);
    }

    @Override
    public BaseDesenhista getResult() {
        DesenhistaEntity toReturn = desenhista;
        reset();
        return toReturn;
    }

  

  
}


