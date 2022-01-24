package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Builders.HistoriaBuilder;
import com.grupo2.editoragibi.Service.Builders.HistoriaEntityBuilder;
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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HistoriaRepository {

    @Autowired
    IHistoriaRepository historiaRepository;

    @Autowired
    IEscritorRepository escritorRepository;

    @Autowired
    IDesenhistaRepository desenhistaRepository;

    private IBaseHistoriaBuilder historiaBuilder = new HistoriaBuilder();
    private IBaseHistoriaBuilder historiaEntityBuilder = new HistoriaEntityBuilder(desenhistaRepository, escritorRepository);
    private HistoriaDirector historiaDirector = new HistoriaDirector(historiaBuilder);
    private HistoriaDirector historiaEntityDirector = new HistoriaDirector(historiaEntityBuilder);

    public Historia getHistoriaById(int id) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        Optional<HistoriaEntity> historiaEntity = historiaRepository.findById(id);
        if (historiaEntity.isEmpty())
            throw new HistoriaInvalidaException("Historia não está no sistema");
        BaseHistoria historia = historiaDirector.buildFromHistoriaEntity(historiaEntity.get());
        return (Historia) historia;
    }

    public List<Historia> getHistorias() throws DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException, HistoriaInvalidaException {

        List<HistoriaEntity> historiasEntity = historiaRepository.findAll();

        List<Historia> historias = new ArrayList<>();
        for (HistoriaEntity historia : historiasEntity) {
            historias.add((Historia) historiaDirector.buildFromHistoriaEntity(historia));
        }
        return historias;
    }

    //TODO
    public Historia addHistoria(Historia historia) throws DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException, HistoriaInvalidaException {

        HistoriaEntity historiaEntity = (HistoriaEntity) historiaEntityDirector.buildFromHistoria(historia);
        HistoriaEntity historiaToReturn = historiaRepository.save(historiaEntity);
        return (Historia) historiaDirector.buildFromHistoriaEntity(historiaToReturn);
    }

    public boolean deleteHistoria(int id) {

        if (historiaRepository.findById(id).isEmpty())
            return false;

        historiaRepository.deleteById(id);
        return true;
    }

    //TODO
    public Historia updateHistoria(int id, Historia historia) throws HistoriaInvalidaException, DesenhistaInvalidoException, PersonagemInvalidoException, EscritorInvalidoException {

        if (historiaRepository.findById(id).isEmpty())
            throw new HistoriaInvalidaException("História não está no sistema");

        historia.setHistoriaId(id);
        HistoriaEntity historiaEntity = (HistoriaEntity) historiaEntityDirector.buildFromHistoria(historia);
        HistoriaEntity historiaToReturn = historiaRepository.save(historiaEntity);
        return (Historia) historiaDirector.buildFromHistoriaEntity(historiaToReturn);
    }
}
