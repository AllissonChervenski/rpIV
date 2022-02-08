package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.TransportadoraEntity;
import com.grupo2.editoragibi.Service.Exceptions.TransportadoraInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransportadoraRepository {

    @Autowired
    ITrasnportadoraRepository transportadoraRepository;

    public TransportadoraEntity getTransportadoraById(int id) throws TransportadoraInvalidaException {
        Optional<TransportadoraEntity> transportadoraEntity = transportadoraRepository.findById(id);
        if (transportadoraEntity.isEmpty())
            throw new TransportadoraInvalidaException("A transportadora não está no sistema");
        return transportadoraEntity.get();
    }

    public List<TransportadoraEntity> getTransportadoras() {
        return transportadoraRepository.findAll();
    }

    public TransportadoraEntity addTransportadora(TransportadoraEntity transportadoraEntity) {
        return transportadoraRepository.save(transportadoraEntity);
    }

    public boolean deleteTransportadora(int id) {
        if (transportadoraRepository.findById(id).isEmpty())
            return false;
        transportadoraRepository.deleteById(id);
        return true;
    }

    public TransportadoraEntity updateTransportadora(int id, TransportadoraEntity transportadoraEntity) throws TransportadoraInvalidaException {
        if (transportadoraRepository.findById(id).isEmpty())
            throw new TransportadoraInvalidaException("Essa transportadora não está no sistema");
        transportadoraEntity.setTransportadoraId(id);
        return transportadoraRepository.save(transportadoraEntity);
    }
}
