package com.grupo2.editoragibi.Service.Builders;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IGibiRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.BaseObjects.BaseGibi;
import com.grupo2.editoragibi.Service.Builders.Interfaces.IBaseGibiBuilder;
import com.grupo2.editoragibi.Service.Directors.EdicoesGibiDirector;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;

@Component("gibiBuilder")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GibiBuilder  implements IBaseGibiBuilder{

    private Gibi gibi;

    @Autowired
    private EdicoesGibiRepository edicoesGibi;

    @Autowired
    private EdicoesGibiDirector edicoesGibiDirector;

    public GibiBuilder(){
        reset();
    }
    
    @Override
    public void setEncData(LocalDate encData) {
        gibi.setEncData(encData);
    }

    @Override
    public void setGibi_id(Integer gibi_id) {
        gibi.setGibi_id(gibi_id);
    }

    @Override
    public void setInicioData(LocalDate inicioData) {
        gibi.setInicioData(inicioData);
    }

    @Override
    public void setTituloGibi(String tituloGibi) throws GibiInvalidoException {
       gibi.setTituloGibi(tituloGibi);
    }

    @Override
    public void setEdicoesGibi(List<Integer> edicoesGibi) throws EdicoesGibiInvalidoException, GibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
       List<EdicoesGibi> gibiEdicoes =  gibi.getEdicoesGibi();
       if(edicoesGibi != null){
        for(Integer id : edicoesGibi){
            gibiEdicoes.add((EdicoesGibi) edicoesGibiDirector.buildFromEdicoesGibiEntity(this.edicoesGibi.getEdicaoGibiById(id).get()));
        }
       }
    }

    @Override
    public void setEdicaoGibi(BaseEdicoesGibi edicaoGibi) {
        gibi.setEdicaoGibi(edicaoGibi);
        
    }

    @Override
    public void setEdicaoGibi(Integer edicaoGibi) {
        // TODO Auto-generated method stub
        gibi.setEdicaoGibi(edicoesGibi.getEdicaoGibiById(edicaoGibi).get());
    }

    @Override
    public BaseGibi getResult() {
       Gibi toReturn = gibi;
       reset();
       return toReturn;
    }

    private void reset() {
        gibi = new Gibi();
    }
    
}
