package com.grupo2.editoragibi.Service.ServiceObjects;


import com.grupo2.editoragibi.Api.Requests.GibiRequest;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Data.Repositories.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Repositories.GibiRepository;
import com.grupo2.editoragibi.Data.Repositories.Interfaces.IGibiRepository;
import com.grupo2.editoragibi.Service.Directors.GibiDirector;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    GibiRepository gibiRepository;

    @Qualifier("gibiDirector")
    @Autowired
    GibiDirector gibiDirector;

    @Qualifier("GibiEntityDirector")
    @Autowired
    GibiDirector gibiEntityDirector;

    @Autowired
    EdicoesGibiRepository edicoesGibiRepository;

    public List<GibiEntity> getGibis() throws GibiInvalidoException, PersonagemInvalidoException, DesenhistaInvalidoException, EscritorInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException {
        List<GibiEntity> gibiEntity = gibiRepository.getGibis();
        //List<Gibi> gibi = new ArrayList<>();
        //for(GibiEntity g : gibiEntity){
        //    gibi.add((Gibi) gibiDirector.buildFromGibiEntity(g));
        //}

        return gibiEntity;
    }

    public Gibi addGibi(GibiRequest gibiRequest) throws GibiInvalidoException, PersonagemInvalidoException, DesenhistaInvalidoException, EscritorInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException {
        Optional<GibiEntity> gibiOptional = gibiRepository.getGibiByTitulo(gibiRequest.getTituloGibi());
        if (gibiOptional.isPresent()) {
            throw new IllegalStateException("Titulo já existente");
        }
        Gibi gibi = (Gibi) gibiEntityDirector.buildFromGibiRequest(gibiRequest);
        GibiEntity gibiEntity = (GibiEntity) gibiEntityDirector.buildFromGibi(gibi);
        return gibiRepository.addGibi(gibiEntity);

    }


    @Transactional
    public void deleteGibi(Integer gibiId) throws GibiInvalidoException {
        boolean exists = gibiRepository.getGibiById(gibiId).isPresent();
        if (!exists) {
            throw new IllegalStateException(
                    "GibiEntity com id " + gibiId + " não existe"
            );
        } else {
            if (gibiRepository.getGibiById(gibiId).isPresent() && gibiRepository.getGibiById(gibiId).get().getEdicoesGibis().size() == 0) {
                gibiRepository.deleteGibi(gibiId);
            } else {
                throw new IllegalStateException(
                        "GibiEntity possui uma ou mais edições, portanto não pode ser deletado."
                );
            }
        }

    } 



       public Gibi updateGibi(int gibiId, String titulo, LocalDate inicio, LocalDate enc, EdicoesGibiEntity edicoes) throws IllegalStateException, GibiInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException, PersonagemInvalidoException, EscritorInvalidoException, DesenhistaInvalidoException {
        GibiEntity gibi = gibiRepository.getGibiById(gibiId).orElseThrow(
                () -> new IllegalStateException("GibiEntity com id: " + gibiId + " não existe"));

        if (titulo != null &&
                titulo.trim().length() > 0 &&
                !gibi.getTituloGibi().equals(titulo)) {
            gibi.setTituloGibi(titulo);
        }

        if (inicio != null) {
            if (gibi.getEncData() == null || inicio.isBefore(gibi.getEncData())) {
                gibi.setInicioData(inicio);
            } else {
                throw new IllegalStateException("Data de inicio não pode ser após data de encerramento");
            }
        }
        if (enc != null && gibi.getInicioData() != null) {
            if (enc.isAfter(gibi.getInicioData())) {
                gibi.setEncData(enc);
            } else {
                throw new IllegalStateException("Data de encerramento não pode ser antes da data de inicio");
            }
        }
        if(edicoes != null){
            gibi.setEdicaoGibi(edicoes);
        }
       // return gibiRepository.updateGibi(gibiId,gibi);
       return (Gibi) gibiDirector.buildFromGibiEntity(gibiRepository.updateGibi(gibiId, gibi));
   
    }



    
/* */

    public void addEdicaoGibi(Integer gibiId, Integer edicaoGibiId) throws GibiInvalidoException, EdicoesGibiInvalidoException, PersonagemInvalidoException, DesenhistaInvalidoException, EscritorInvalidoException, HistoriaInvalidaException {
        Optional<EdicoesGibiEntity> edicoesGibiOptional = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
        Optional<GibiEntity> gibi = gibiRepository.getGibiById(gibiId);

        if (edicoesGibiOptional.isPresent() && gibi.isPresent()) {
            if (gibi.get().getEdicoesGibi() != null) {
                gibi.get().getEdicoesGibi().add(edicoesGibiOptional.get());
            }
            else {
                gibi.get().setEdicoesGibi(new ArrayList<>());
                gibi.get().getEdicoesGibi().add(edicoesGibiOptional.get());
            }

        } else {
            throw new EdicoesGibiInvalidoException("Edicao nao encontrada");
        }
        gibiRepository.addGibi((GibiEntity) gibiDirector.buildFromGibi(gibi.get()));
    }

    public Gibi getGibiById(int gibiId) {
        return null;
    }

}