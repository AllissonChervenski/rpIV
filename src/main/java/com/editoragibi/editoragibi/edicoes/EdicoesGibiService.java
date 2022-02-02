package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.Gibi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    public void deleteEdicoesGibi(Long edicoesGibiId) {
        Optional<EdicoesGibi> edicoesGibiOptional = edicoesGibiRepository.findById(edicoesGibiId);
        if(edicoesGibiOptional.isPresent()){
        edicoesGibiRepository.deleteById(edicoesGibiId);
        }
        else{
            throw new IllegalStateException("A edição não existe");
        }
    }

    @Transactional
    public void updateEdicoesGibi(Long edicoesGibiId, Integer nroEdicao, LocalDate dataPub) {
        EdicoesGibi edicoesGibi = edicoesGibiRepository.findById(edicoesGibiId).orElseThrow(
                () -> new IllegalStateException("Edicao com id " + edicoesGibiId + " não existe")
        );

        if(nroEdicao != null){
            edicoesGibi.setNroEdicao(nroEdicao);
        }

        if(dataPub != null){
            edicoesGibi.setDataPub(dataPub);
        }

        edicoesGibiRepository.save(edicoesGibi);
    }
}






