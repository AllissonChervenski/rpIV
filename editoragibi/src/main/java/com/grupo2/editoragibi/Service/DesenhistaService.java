package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Api.Requests.DesenhistaRequest;
import com.grupo2.editoragibi.Data.DesenhistaRepository;
import com.grupo2.editoragibi.Data.IDesenhistaRepository;
import com.grupo2.editoragibi.Service.Builders.DesenhistaBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseDesenhistaBuilder;
import com.grupo2.editoragibi.Service.Directors.DesenhistaDirector;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DesenhistaService {

    private IBaseDesenhistaBuilder desenhistaBuilder = new DesenhistaBuilder();
    private DesenhistaDirector desenhistaDirector = new DesenhistaDirector(desenhistaBuilder);

    @Autowired
    DesenhistaRepository desenhistaRepository;

    public Desenhista getDesenhistaById(int id) throws DesenhistaInvalidoException {

        return desenhistaRepository.getDesenhistaById(id);
    }

    public List<Desenhista> getDesenhistas() throws DesenhistaInvalidoException {

        return desenhistaRepository.getDesenhistas();
    }

    public Desenhista addDesenhista(DesenhistaRequest desenhistaRequest) throws DesenhistaInvalidoException {

        Desenhista desenhista = (Desenhista) desenhistaDirector.buildFromDesenhistaRequest(desenhistaRequest);
        return desenhistaRepository.addDesenhista(desenhista);
    }


    public void deleteDesenhista(Integer id) throws DesenhistaInvalidoException {

        if (desenhistaRepository.deleteDesenhista(id))
            throw new DesenhistaInvalidoException("O desenhista já está no sistema");
    }

    public Desenhista updateDesenhista(int id, DesenhistaRequest desenhistaRequest) throws DesenhistaInvalidoException {
        Desenhista desenhista = (Desenhista) desenhistaDirector.buildFromDesenhistaRequest(desenhistaRequest);
        return desenhistaRepository.updateDesenhista(id, desenhista);
    }

}
