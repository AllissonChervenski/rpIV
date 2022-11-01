package com.grupo2.editoragibi.Data.Repositories;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DesenhistaRepository {

    @Autowired
    IDesenhistaRepository desenhistaRepository;

    public DesenhistaEntity getDesenhistaById(int id) throws DesenhistaInvalidoException {
        Optional<DesenhistaEntity> desenhistaEntity = desenhistaRepository.findById(id);
        if (!desenhistaEntity.isPresent())
            throw new DesenhistaInvalidoException("Desenhista não está no sistema");
        return desenhistaEntity.get();
    }

    public List<DesenhistaEntity> getDesenhistas() throws DesenhistaInvalidoException {
        return desenhistaRepository.findAll();
    }

    public DesenhistaEntity addDesenhista(DesenhistaEntity desenhistaEntity) {
        return desenhistaRepository.save(desenhistaEntity);
    }

    public boolean deleteDesenhista(Integer id) {

        if (desenhistaRepository.findById(id).isEmpty())
            return false;

        desenhistaRepository.deleteById(id);
        return true;
    }

    public DesenhistaEntity updateDesenhista(int id, DesenhistaEntity desenhistaEntity) throws DesenhistaInvalidoException {
        if (desenhistaRepository.findById(id).isEmpty())
            throw new DesenhistaInvalidoException("Desenhista não está no sistema");
        desenhistaEntity.setDesenhistaId(id);
        return desenhistaRepository.save(desenhistaEntity);
    }
}
