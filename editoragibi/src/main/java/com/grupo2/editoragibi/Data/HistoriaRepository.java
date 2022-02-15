package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.Support.VisitorToEntity;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HistoriaRepository {

    @Autowired
    IHistoriaRepository historiaRepository;

    @Autowired
    VisitorToEntity visitorToEntity;

    @Autowired
    ModelMapper modelMapper;

    public Optional<Historia> getHistoriaById(int id) throws HistoriaInvalidaException {

        Optional<HistoriaEntity> historiaEntity = historiaRepository.findById(id);

        if (historiaEntity.isEmpty())
            throw new HistoriaInvalidaException("Historia não está no sistema");

        return Optional.of(mapHistoria(historiaEntity.get()));
    }

    public List<Historia> getHistorias() {

        List<HistoriaEntity> historiasEntity = historiaRepository.findAll();

        return historiasEntity.stream().map(historia -> {
            return mapHistoria(historia);
        }).collect(Collectors.toList());
    }

    public Historia addHistoria(Historia historia) {

        HistoriaEntity historiaEntity = visitorToEntity.historiaToEntity(historia);

        HistoriaEntity historiaToReturn = historiaRepository.save(historiaEntity);

        return mapHistoria(historiaToReturn);
    }

    public boolean deleteHistoria(int id) {

        if (historiaRepository.findById(id).isEmpty())
            return false;

        historiaRepository.deleteById(id);
        return true;
    }

    public Historia updateHistoria(int id, Historia historia) throws HistoriaInvalidaException {

        if (historiaRepository.findById(id).isEmpty())
            throw new HistoriaInvalidaException("História não está no sistema");

        historia.setHistoriaId(id);

        HistoriaEntity historiaEntity = visitorToEntity.historiaToEntity(historia);

        HistoriaEntity historiaToReturn = historiaRepository.save(historiaEntity);

        return mapHistoria(historiaToReturn);
    }

    private Historia mapHistoria(HistoriaEntity historiaEntity) {

        Historia historia = modelMapper.map(historiaEntity, Historia.class);

        historia.setArtefinalizador(modelMapper.map(historiaEntity.getArtefinalizador(), Desenhista.class));
        historia.setDesenhista(modelMapper.map(historiaEntity.getDesenhista(), Desenhista.class));
        historia.setEscritor(modelMapper.map(historiaEntity.getEscritor(), Escritor.class));

        historia.setPersonagens(historiaEntity.getPersonagens().stream().map(personagem -> {
            return modelMapper.map(personagem, Personagem.class);
        }).collect(Collectors.toList()));

        return historia;
    }
}
