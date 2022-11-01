package com.grupo2.editoragibi.Data.Repositories;

import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HistoriaRepository {

    @Autowired
    IHistoriaRepository historiaRepository;

    public HistoriaEntity getHistoriaById(int id) throws HistoriaInvalidaException {
        Optional<HistoriaEntity> historiaEntity = historiaRepository.findById(id);
        if (historiaEntity.isEmpty())
            throw new HistoriaInvalidaException("Historia não está no sistema");
        return historiaEntity.get();
    }

    public List<HistoriaEntity> getHistorias() {
        return historiaRepository.findAll();
    }

    public HistoriaEntity addHistoria(HistoriaEntity historiaEntity) {
        return historiaRepository.save(historiaEntity);
    }

    public boolean deleteHistoria(int id) {

        if (historiaRepository.findById(id).isEmpty())
            return false;

        historiaRepository.deleteById(id);
        return true;
    }

    public HistoriaEntity updateHistoria(int id, HistoriaEntity historiaEntity) throws HistoriaInvalidaException {
        if (historiaRepository.findById(id).isEmpty())
            throw new HistoriaInvalidaException("História não está no sistema");
        historiaEntity.setHistoriaId(id);
        return historiaRepository.save(historiaEntity);
    }
}
