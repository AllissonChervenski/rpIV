package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Api.Requests.HistoriaRequest;
import com.grupo2.editoragibi.Data.DesenhistaRepository;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.HistoriaRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Builders.HistoriaBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseHistoriaBuilder;
import com.grupo2.editoragibi.Service.Directors.HistoriaDirector;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
