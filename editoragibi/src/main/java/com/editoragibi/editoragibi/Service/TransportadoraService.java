package com.editoragibi.editoragibi.Service;

import com.editoragibi.editoragibi.Api.Requests.TransportadoraRequest;
import com.editoragibi.editoragibi.Data.Entity.TransportadoraEntity;
import com.editoragibi.editoragibi.Data.TransportadoraRepository;
import com.editoragibi.editoragibi.Service.Directors.TransportadoraDirector;
import com.editoragibi.editoragibi.Service.Domain.Transportadora;
import com.editoragibi.editoragibi.Service.Exceptions.TransportadoraInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransportadoraService {

    @Qualifier("transportadoraDirector")
    @Autowired
    TransportadoraDirector transportadoraDirector;

    @Qualifier("transportadoraEntityDirector")
    @Autowired
    TransportadoraDirector transportadoraEntityDirector;

    @Autowired
    TransportadoraRepository transportadoraRepository;

    public Transportadora getTransportadoraById(int id) throws TransportadoraInvalidaException {
        return (Transportadora) transportadoraDirector.buildFromTransportadoraEntity(transportadoraRepository.getTransportadoraById(id));
    }

    public List<Transportadora> getTransportadoras() throws TransportadoraInvalidaException {
        List<TransportadoraEntity> transportadorasEntities = transportadoraRepository.getTransportadoras();
        List<Transportadora> transportadoras = new ArrayList<>();
        for (TransportadoraEntity transportadora : transportadorasEntities) {
            transportadoras.add((Transportadora) transportadoraDirector.buildFromTransportadoraEntity(transportadora));
        }
        return transportadoras;
    }

    public Transportadora addTransportadora(TransportadoraRequest transportadoraRequest) throws TransportadoraInvalidaException {
        Transportadora transportadora = (Transportadora) transportadoraDirector.buildFromTransportadoraRequest(transportadoraRequest);
        TransportadoraEntity transportadoraEntity = (TransportadoraEntity) transportadoraEntityDirector.buildFromTransportadora(transportadora);
        return (Transportadora) transportadoraDirector.buildFromTransportadoraEntity(transportadoraRepository.addTransportadora(transportadoraEntity));
    }

    public void deleteTransportadora(int id) throws TransportadoraInvalidaException {
        if (!transportadoraRepository.deleteTransportadora(id))
            throw new TransportadoraInvalidaException("Transportadora não está no sistema");
    }

    public Transportadora updateTransportadora(int id, TransportadoraRequest transportadoraRequest) throws TransportadoraInvalidaException {
        Transportadora transportadora = (Transportadora) transportadoraDirector.buildFromTransportadoraRequest(transportadoraRequest);
        TransportadoraEntity transportadoraEntity = (TransportadoraEntity) transportadoraEntityDirector.buildFromTransportadora(transportadora);
        return (Transportadora) transportadoraDirector.buildFromTransportadoraEntity(transportadoraRepository.updateTransportadora(id, transportadoraEntity));
    }
}