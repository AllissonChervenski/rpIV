package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Service.Directors.EscritorDirector;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EscritorService {

    @Qualifier("escritorDirector")
    @Autowired
    EscritorDirector escritorDirector;

    @Qualifier("escritorEntityDirector")
    @Autowired
    EscritorDirector escritorEntityDirector;

    @Autowired
    EscritorRepository escritorRepository;

    public Escritor getEscritorById(int id) throws EscritorInvalidoException, PersonagemInvalidoException {
        return (Escritor) escritorDirector.buildFromEscritorEntity(escritorRepository.getEscritorById(id));
    }

    public List<Escritor> getEscritores() throws PersonagemInvalidoException, EscritorInvalidoException {
        List<EscritorEntity> escritorEntities = escritorRepository.getEscritores();
        List<Escritor> escritores = new ArrayList<>();
        for (EscritorEntity escritor : escritorEntities) {
            escritores.add((Escritor) escritorDirector.buildFromEscritorEntity(escritor));
        }
        return escritores;
    }

    public Escritor addEscritor(EscritorRequest escritorRequest) throws EscritorInvalidoException, PersonagemInvalidoException {
        Escritor escritor = (Escritor) escritorDirector.buildFromEscritorRequest(escritorRequest);
        EscritorEntity escritorEntity = (EscritorEntity) escritorEntityDirector.buildFromEscritor(escritor);
        return (Escritor) escritorDirector.buildFromEscritorEntity(escritorRepository.addEscritor(escritorEntity));
    }

    public void deleteEscritor(int id) throws EscritorInvalidoException {
        if (!escritorRepository.deleteEscritor(id))
            throw new EscritorInvalidoException("Escritor não está no sistema");
    }

    public Escritor updateEscritor(int id, EscritorRequest escritorRequest) throws EscritorInvalidoException, PersonagemInvalidoException {
        Escritor escritor = (Escritor) escritorDirector.buildFromEscritorRequest(escritorRequest);
        EscritorEntity escritorEntity = (EscritorEntity) escritorEntityDirector.buildFromEscritor(escritor);
        return (Escritor) escritorDirector.buildFromEscritorEntity(escritorRepository.updateEscritor(id, escritorEntity));
    }
}
