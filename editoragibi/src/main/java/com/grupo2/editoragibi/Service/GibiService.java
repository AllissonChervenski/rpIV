package com.grupo2.editoragibi.Service;


import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.GibiRepository;
import com.grupo2.editoragibi.Data.IGibiRepository;
import com.grupo2.editoragibi.Service.Directors.GibiDirector;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GibiService {

    @Autowired
    private GibiRepository gibiRepository;

    @Autowired
    GibiDirector gibiDirector;

    @Autowired
    GibiDirector gibiEntityDirector;

    public List<Gibi> getGibis() throws GibiInvalidoException {
        List<GibiEntity> gibiEntities = gibiRepository.getGibis();
        List<Gibi> gibis = new ArrayList<>();
        for (GibiEntity gibiEntity : gibiEntities) {
            gibis.add((Gibi) gibiDirector.buildFromGibiEntity(gibiEntity));
        }
        return gibis;
    }

    public Gibi addGibi(GibiEntity gibi) throws GibiInvalidoException {
        //TODO por enquanto está entity em vez de request
        GibiEntity gibiEntity = gibiRepository.addGibi(gibi);
        return (Gibi) gibiDirector.buildFromGibiEntity(gibiEntity);
    }

    @Transactional
    public void deleteGibi(int gibiId) throws GibiInvalidoException {
        if (!gibiRepository.deleteGibi(gibiId))
            throw new GibiInvalidoException("O gibi não está no sistema");
    }

    @Transactional
    public Gibi updateGibi(int id, GibiEntity gibi) throws GibiInvalidoException {
        GibiEntity gibiEntity = gibiRepository.updateGibi(id, gibi);
        return (Gibi) gibiDirector.buildFromGibiEntity(gibiEntity);
    }

    /*
    public void addEdicaoGibi(Long gibiId, Long edicaoGibiId) {
        Optional<EdicoesGibi> edicoesGibiOptional = gibiRepository.findEdicaoGibiById(edicaoGibiId);
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
