package com.editoragibi.editoragibi.Service;

import com.editoragibi.editoragibi.Api.Requests.DesenhistaRequest;
import com.editoragibi.editoragibi.Data.DesenhistaRepository;
import com.editoragibi.editoragibi.Data.Entity.DesenhistaEntity;
import com.editoragibi.editoragibi.Service.Directors.DesenhistaDirector;
import com.editoragibi.editoragibi.Service.Domain.Desenhista;
import com.editoragibi.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesenhistaService {

    @Qualifier("desenhistaDirector")
    @Autowired
    DesenhistaDirector desenhistaDirector;

    @Qualifier("desenhistaEntityDirector")
    @Autowired
    DesenhistaDirector desenhistaEntityDirector;

    @Autowired
    DesenhistaRepository desenhistaRepository;

    public Desenhista getDesenhistaById(int id) throws DesenhistaInvalidoException {
        return (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaRepository.getDesenhistaById(id));
    }

    public List<Desenhista> getDesenhistas() throws DesenhistaInvalidoException {
        List<DesenhistaEntity> desenhistaEntities = desenhistaRepository.getDesenhistas();
        List<Desenhista> desenhistas = new ArrayList<>();
        for (DesenhistaEntity desenhista : desenhistaEntities) {
            desenhistas.add((Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhista));
        }
        return desenhistas;
    }

    public Desenhista addDesenhista(DesenhistaRequest desenhistaRequest) throws DesenhistaInvalidoException {
        Desenhista desenhista = (Desenhista) desenhistaDirector.buildFromDesenhistaRequest(desenhistaRequest);
        DesenhistaEntity desenhistaEntity = (DesenhistaEntity) desenhistaEntityDirector.buildFromDesenhista(desenhista);
        return (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaRepository.addDesenhista(desenhistaEntity));
    }


    public void deleteDesenhista(Integer id) throws DesenhistaInvalidoException {
        if (desenhistaRepository.deleteDesenhista(id))
            throw new DesenhistaInvalidoException("O desenhista já está no sistema");
    }

    public Desenhista updateDesenhista(int id, DesenhistaRequest desenhistaRequest) throws DesenhistaInvalidoException {
        Desenhista desenhista = (Desenhista) desenhistaDirector.buildFromDesenhistaRequest(desenhistaRequest);
        DesenhistaEntity desenhistaEntity = (DesenhistaEntity) desenhistaEntityDirector.buildFromDesenhista(desenhista);
        return (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaRepository.updateDesenhista(id, desenhistaEntity));
    }

}
