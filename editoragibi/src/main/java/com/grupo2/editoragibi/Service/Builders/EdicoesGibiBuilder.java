package com.grupo2.editoragibi.Service.Builders;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.grupo2.editoragibi.Data.Repositories.DesenhistaRepository;
import com.grupo2.editoragibi.Data.Repositories.EscritorRepository;
import com.grupo2.editoragibi.Data.Repositories.GibiRepository;
import com.grupo2.editoragibi.Data.Repositories.HistoriaRepository;
import com.grupo2.editoragibi.Data.Repositories.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseDesenhista;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.BaseObjects.BasePersonagem;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseEdicoesGibiBuilder;
import com.grupo2.editoragibi.Service.Directors.DesenhistaDirector;
import com.grupo2.editoragibi.Service.Directors.EscritorDirector;
import com.grupo2.editoragibi.Service.Directors.HistoriaDirector;
import com.grupo2.editoragibi.Service.Directors.PersonagemDirector;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

@Component("edicoesGibiBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EdicoesGibiBuilder implements IBaseEdicoesGibiBuilder {

    private EdicoesGibi edicoesGibi;

    @Autowired
    private GibiRepository gibi;

    //@Autowired
    //private GibiDirector gibiDirector;

    @Autowired
    private HistoriaRepository historia;


    @Autowired
    private HistoriaDirector historiaDirector;

    @Autowired
    private EscritorRepository escritor;

    @Autowired
    private EscritorDirector escritorDirector;



    @Autowired
    private PersonagemRepository personagem;

    @Autowired
    private PersonagemDirector personagemDirector;

    @Autowired
    private DesenhistaRepository desenhista;

    @Autowired
    private DesenhistaDirector desenhistaDirector;


    public EdicoesGibiBuilder(){

        reset();
    }

    public void reset(){
        edicoesGibi = new EdicoesGibi();
    }


    public void setEdicoesGibi(EdicoesGibi edicoesGibi) {
        this.edicoesGibi = edicoesGibi;
    }

    @Override
    public void setDataPub(LocalDate dataPub) throws EdicoesGibiInvalidoException{
        edicoesGibi.setDataPub(dataPub);
    }

    @Override
    public void setEdicaoGibiId(int id) {
        edicoesGibi.setEdicaoGibi_id(id);
    }

    @Override
    public void setEditor(Integer editorId) {
        //
    }

    @Override
    public void setGibi(Integer gibiId) throws GibiInvalidoException, EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
        edicoesGibi.setGibi(gibi.getGibiById(gibiId));
    }

    public void setGibi(BaseGibi gibi) throws GibiInvalidoException, EdicoesGibiInvalidoException{
        if(gibi instanceof Gibi){
            edicoesGibi.setGibi(gibi);
        }
    }

    @Override
    public void setHistoria(Integer historiaId) throws HistoriaInvalidaException {
        edicoesGibi.setHistoria(historia.getHistoriaById(historiaId));
    }

    @Override
    public void setHistoria(BaseHistoria historia) throws HistoriaInvalidaException{
        if(historia instanceof Historia){
            edicoesGibi.setHistoria(historia);
        }
    }
    @Override
    public void setPersonagens(List<Integer> personagensId) throws PersonagemInvalidoException, EscritorInvalidoException {
        List<Personagem> personagensEdicao = edicoesGibi.getPersonagem();
        if(personagensId != null){
            for (Integer id : personagensId) {
                personagensEdicao.add((Personagem) personagemDirector.buildFromPersonagemEntity(personagem.getPersonagemById(id), edicoesGibi));
            }
        }
    }

    @Override
    public void setDesenhistas(List<Integer> desenhistaId) throws DesenhistaInvalidoException {
        List<Desenhista> desenhistaEdicao = edicoesGibi.getDesenhista();
        if(desenhistaId != null){
            for (Integer id : desenhistaId) {
                desenhistaEdicao.add((Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhista.getDesenhistaById(id)));
            }
        }

    }

    @Override
    public void setEscritores(List<Integer> escritorId) {
        // TODO Auto-generated method stub
        List<Escritor> escritorEdicao = edicoesGibi.getEscritor();
        if(escritorId != null){
            for (Integer id : escritorId) {
                try {
                    escritorEdicao.add((Escritor) escritorDirector.buildFromEscritorEntity(escritor.getEscritorById(id)));
                } catch (EscritorInvalidoException | PersonagemInvalidoException e) {
                    // TODO Auto-generated catch block
                    e.getCause();
                }
            }
        }
    }

    @Override
    public void setNroEdicao(int nroEdicao) throws EdicoesGibiInvalidoException {
        // TODO Auto-generated method stub
        edicoesGibi.setNroEdicao(nroEdicao);

    }

    @Override
    public void setNumeroExemplaresImpressas(int numeroExemplaresImpressas) {
        // TODO Auto-generated method stub
        edicoesGibi.setNumeroExemplaresImpressas(numeroExemplaresImpressas);
    }

    @Override
    public void setPublicada(boolean publicada) {
        // TODO Auto-generated method stub
        edicoesGibi.setPublicada(publicada);
    }

    @Override
    public BaseEdicoesGibi getResult() {
        // TODO Auto-generated method stub
        EdicoesGibi toReturn = edicoesGibi;
        reset();
        return toReturn;
    }

    @Override
    public void setPersonagem(BasePersonagem personagem) {
        // TODO Auto-generated method stub
        edicoesGibi.setPersonagem(personagem);
    }

    @Override
    public void setPersonagem(Integer personagemId) throws PersonagemInvalidoException, EscritorInvalidoException {
        // TODO Auto-generated method stub
        edicoesGibi.setPersonagem(personagem.getPersonagemById(personagemId));
    }

    @Override
    public void setDesenhista(BaseDesenhista desenhista) {
        // TODO Auto-generated method stub
        edicoesGibi.setDesenhista(desenhista);
    }

    @Override
    public void setDesenhista(Integer desenhistaId) throws DesenhistaInvalidoException {
        // TODO Auto-generated method stub
        edicoesGibi.setDesenhista(desenhista.getDesenhistaById(desenhistaId));
    }

    @Override
    public void setEscritor(BaseEscritor escritor) {
        // TODO Auto-generated method stub
        edicoesGibi.setEscritor(escritor);
    }

    @Override
    public void setEscritor(Integer escritorId) throws EscritorInvalidoException, PersonagemInvalidoException {
        // TODO Auto-generated method stub
        edicoesGibi.setEditor(escritor.getEscritorById(escritorId));

    }




}