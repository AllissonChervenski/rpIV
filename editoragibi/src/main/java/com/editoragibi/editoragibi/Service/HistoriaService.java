package com.editoragibi.editoragibi.Service;

import com.editoragibi.editoragibi.Api.Requests.HistoriaRequest;
import com.editoragibi.editoragibi.Data.Entity.HistoriaEntity;
import com.editoragibi.editoragibi.Data.HistoriaRepository;
import com.editoragibi.editoragibi.Service.Directors.HistoriaDirector;
import com.editoragibi.editoragibi.Service.Domain.Historia;
import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoriaService {

    @Qualifier("historiaDirector")
    @Autowired
    HistoriaDirector historiaDirector;

    @Qualifier("historiaEntityDirector")
    @Autowired
    HistoriaDirector historiaEntityDirector;

    @Autowired
    HistoriaRepository historiaRepository;

    public Historia getHistoriaById(int id) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {
        return (Historia) historiaDirector.buildFromHistoriaEntity(historiaRepository.getHistoriaById(id));
    }

    public List<Historia> getHsitorias() throws DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException, HistoriaInvalidaException {
        List<HistoriaEntity> historiasEntities = historiaRepository.getHistorias();
        List<Historia> historias = new ArrayList<>();
        for (HistoriaEntity historia : historiasEntities) {
            historias.add((Historia) historiaDirector.buildFromHistoriaEntity(historia));
        }
        return historias;
    }

    public Historia addHistoria(HistoriaRequest historiaRequest) throws Exception {
        Historia historia = (Historia) historiaDirector.buildFromHistoriaRequest(historiaRequest);
        HistoriaEntity historiaEntity = (HistoriaEntity) historiaEntityDirector.buildFromHistoria(historia);
        return (Historia) historiaDirector.buildFromHistoriaEntity(historiaRepository.addHistoria(historiaEntity));
    }

    public void deleteHistoria(int id) throws HistoriaInvalidaException {
        if (!historiaRepository.deleteHistoria(id))
            throw new HistoriaInvalidaException("Historia não está no sistema");
    }

    public Historia updateHistoria(int id, HistoriaRequest historiaRequest) throws Exception {
        Historia historia = (Historia) historiaDirector.buildFromHistoriaRequest(historiaRequest);
        HistoriaEntity historiaEntity = (HistoriaEntity) historiaEntityDirector.buildFromHistoria(historia);
        return (Historia) historiaDirector.buildFromHistoriaEntity(historiaRepository.updateHistoria(id, historiaEntity));
    }
}
