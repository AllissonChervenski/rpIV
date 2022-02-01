package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.Gibi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void addEdicoesGibi(EdicoesGibi edicoesGibi) {
        Optional<EdicoesGibi> edicoesGibiOptional = edicoesGibiRepository.findEdicoesGibiByEdicao(edicoesGibi.getNroEdicao());
        if (edicoesGibiOptional.isPresent()) {
                throw new IllegalStateException("Edicao :" + edicoesGibi.getNroEdicao() + "Data: " + " já existente");
            }
        else {
                edicoesGibiRepository.save(edicoesGibi);
            }
        }

        @Transactional
    public void addGibiEdicoesGibi(Gibi gibi, Long edicaoId) {
        Optional<EdicoesGibi> edicoesGibiOptional = edicoesGibiRepository.findById(edicaoId);
        if(edicoesGibiOptional.isPresent()) {
            if (gibi.getEdicoesGibis() != null) {
                if (!gibi.getEdicoesGibis().contains(edicoesGibiOptional.get())) {
                    gibi.getEdicoesGibis().add(edicoesGibiOptional.get());
                } else {
                    throw new IllegalStateException("Esta edição de gibi ja está atribuida ao gibi " + gibi.getTitulo());
                }
            }
            else{
                gibi.setEdicoesGibis(new ArrayList<>());
                gibi.getEdicoesGibis().add(edicoesGibiOptional.get());
            }
        }
        else{
            throw new IllegalStateException("Esta edição não existe");
        }
    }
}






