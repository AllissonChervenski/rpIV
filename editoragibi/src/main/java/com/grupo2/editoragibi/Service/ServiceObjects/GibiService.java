package com.grupo2.editoragibi.Service.ServiceObjects;

import com.grupo2.editoragibi.Api.Requests.GibiRequest;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Repositories.GibiRepository;
import com.grupo2.editoragibi.Service.Directors.GibiDirector;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GibiService {

    @Autowired
    GibiRepository gibiRepository;

    @Qualifier("gibiDirector")
    @Autowired
    GibiDirector gibiDirector;

    @Qualifier("gibiEntityDirector")
    @Autowired
    GibiDirector gibiEntityDirector;

    public Gibi getGibiById(int id) throws GibiInvalidoException {
        return (Gibi) gibiDirector.buildFromGibiEntity(gibiRepository.getGibiById(id));
    }


    public List<Gibi> getGibis() throws GibiInvalidoException {
        List<GibiEntity> gibiEntities = gibiRepository.getGibis();
        List<Gibi> gibis = new ArrayList<>();
        for (GibiEntity gibi : gibiEntities) {
            gibis.add((Gibi) gibiDirector.buildFromGibiEntity(gibi));
        }
        return gibis;
    }

    public Gibi addGibi(GibiRequest gibiRequest) throws GibiInvalidoException {
        Gibi gibi = (Gibi) gibiDirector.buildFromGibiRequest(gibiRequest);
        GibiEntity gibiEntity = (GibiEntity) gibiEntityDirector.buildFromGibi(gibi);
        return (Gibi) gibiDirector.buildFromGibiEntity(gibiRepository.addGibi(gibiEntity));
    }

    public void deleteGibi(Integer id) throws GibiInvalidoException {
        if (gibiRepository.deleteGibi(id))
            throw new GibiInvalidoException("O desenhista já está no sistema");
    }

    public Gibi updateGibi(int id, GibiRequest gibiRequest) throws GibiInvalidoException {
        Gibi gibi = (Gibi) gibiDirector.buildFromGibiRequest(gibiRequest);
        GibiEntity gibiEntity = (GibiEntity) gibiEntityDirector.buildFromGibi(gibi);
        return (Gibi) gibiDirector.buildFromGibiEntity(gibiRepository.updateGibi(id, gibiEntity));
    }

  /*   public void addEdicaoGibi(Long gibiId, Long edicaoGibiId) {
        Optional<EdicoesGibiEntity> edicoesGibiOptional = gibiRepository.findEdicaoGibiById(edicaoGibiId);
        GibiEntity gibi = gibiRepository.getById(gibiId);
        if (edicoesGibiOptional.isPresent()) {
            if (gibi.getEdicoesGibis() != null) {
                gibi.getEdicoesGibis().add(edicoesGibiOptional.get());
            }
            else{
                gibi.setEdicoesGibis(new ArrayList<>());
                gibi.getEdicoesGibis().add(edicoesGibiOptional.get());
            }
        } else {
            throw new IllegalStateException("Edicao nao encontrada");
        }
        gibiRepository.save(gibi);
    }
     */
}
