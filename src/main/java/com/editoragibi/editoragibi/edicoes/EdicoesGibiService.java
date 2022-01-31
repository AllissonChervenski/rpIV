package com.editoragibi.editoragibi.edicoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EdicoesGibiService {
    private final EdicoesGibiRepository edicoesGibiRepository;

    @Autowired
    public EdicoesGibiService(EdicoesGibiRepository edicoesGibiRepository) {
        this.edicoesGibiRepository = edicoesGibiRepository;
    }

    public List<EdicoesGibi> getEdicoesGibis() {
        return edicoesGibiRepository.findAll();
    }

    public EdicoesGibi getGibisById(Long id) {
        boolean exists = edicoesGibiRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Edicao do id " + id + " não existe");
        }
        return edicoesGibiRepository.getById(id);
    }

    public List<EdicoesGibi> getEdicoesGibiByEdicao(Integer edicao) {
        if (edicoesGibiRepository.findEdicoesGibiByEdicao(edicao).isPresent()) {
            return List.of(edicoesGibiRepository.findEdicoesGibiByEdicao(edicao).get());
        }
        else{
            throw new IllegalStateException("Edicao nao encontrada");
        }

    }
}





