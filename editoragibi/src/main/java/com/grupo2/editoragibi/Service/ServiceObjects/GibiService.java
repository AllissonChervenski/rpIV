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

    public GibiEntity getGibiById(Integer id) throws GibiInvalidoException {
        return gibiRepository.getGibiById(id)
                .orElseThrow(() -> new GibiInvalidoException("Gibi com id " + id + " não encontrado."));
    }


    public GibiEntity addGibi(GibiRequest gibiRequest) throws GibiInvalidoException, PersonagemInvalidoException, DesenhistaInvalidoException, EscritorInvalidoException, EdicoesGibiInvalidoException, HistoriaInvalidaException {
        Optional<GibiEntity> gibiOptional = Optional.ofNullable(gibiRepository.getGibiByTitulo(gibiRequest.getTituloGibi()));
        if (gibiOptional.isPresent()) {
            throw new IllegalStateException("Titulo já existente");
        }
        Gibi gibi = (Gibi) gibiDirector.buildFromGibiRequest(gibiRequest);
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

    @Transactional
    public void updateGibi(Integer gibiId, String titulo, LocalDate inicio, LocalDate enc, EdicoesGibiEntity edicoes) throws IllegalStateException, GibiInvalidoException {
        GibiEntity gibi = gibiRepository.getGibiById(gibiId).orElseThrow(
                () -> new IllegalStateException("GibiEntity com id" + gibiId + " não existe"));

        if (titulo != null &&
                titulo.length() > 0 &&
                !Objects.equals(gibi.getTituloGibi(), titulo)) {
            gibi.setTituloGibi(titulo);
        }

        if (inicio != null) {
            if (inicio.isBefore(gibi.getEncData())) {
                gibi.setInicioData(inicio);
            } else if (gibi.getEncData() == null) {
                gibi.setInicioData(inicio);
            } else {
                throw new IllegalArgumentException("Data de inicio não pode ser após data de encerramento");
            }
        }
        if (gibi.getInicioData() != null) {
            if (enc != null) {
                if (enc.isAfter(gibi.getInicioData())) {
                    gibi.setEncData(enc);
                } else {
                    throw new IllegalArgumentException("Data de encerramento não pode ser antes da data de inicio");
                }
            }
        }
        if(edicoes != null){
            gibi.setEdicaoGibi(edicoes);
        }
        gibiRepository.addGibi(gibi);
    }

    public void addEdicaoGibi(Integer gibiId, Integer edicaoGibiId) throws GibiInvalidoException, EdicoesGibiInvalidoException, PersonagemInvalidoException, DesenhistaInvalidoException, EscritorInvalidoException, HistoriaInvalidaException {
        Optional<EdicoesGibiEntity> edicoesGibiOptional = edicoesGibiRepository.getEdicaoGibiById(edicaoGibiId);
        Optional<GibiEntity> gibi = gibiRepository.getGibiById(gibiId);

        if (edicoesGibiOptional.isPresent() && gibi.isPresent()) {
            gibi.get().getEdicoesGibis().add(edicoesGibiOptional.get());
        } else {
            throw new EdicoesGibiInvalidoException("Edicao nao encontrada");
        }
        gibiRepository.addGibi((GibiEntity) gibiDirector.buildFromGibiEntity(gibi.get()));
    }

}