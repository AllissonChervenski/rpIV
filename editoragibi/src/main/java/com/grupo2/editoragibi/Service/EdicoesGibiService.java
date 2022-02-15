package com.grupo2.editoragibi.Service;


import com.grupo2.editoragibi.Data.EdicoesGibiRepository;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.IHistoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EdicoesGibiService {
    private final EdicoesGibiRepository edicoesGibiRepository;

    @Autowired
    private final IHistoriaRepository iHistoriaRepository;

    @Autowired
    public EdicoesGibiService(EdicoesGibiRepository edicoesGibiRepository, IHistoriaRepository iHistoriaRepository) {
        this.edicoesGibiRepository = edicoesGibiRepository;
        this.iHistoriaRepository = iHistoriaRepository;
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
    public void updateEdicoesGibi(Long edicoesGibiId, Integer nroEdicao, LocalDate dataPub, HistoriaEntity historiaEntity) {
        EdicoesGibi edicoesGibi = edicoesGibiRepository.findById(edicoesGibiId).orElseThrow(
                () -> new IllegalStateException("Edicao com id " + edicoesGibiId + " não existe")
        );

        if(nroEdicao != null){
            edicoesGibi.setNroEdicao(nroEdicao);
        }

        if(dataPub != null){
            edicoesGibi.setDataPub(dataPub);
        }

        if(historiaEntity != null){
            edicoesGibi.setHistoriaEntity(historiaEntity);
        }

        edicoesGibiRepository.save(edicoesGibi);
    }

    public void addHistoriaEdicao(Integer historiaId, Long edicaoGibiId) {
        EdicoesGibi edicoesGibi = edicoesGibiRepository.findById(edicaoGibiId).orElseThrow(
                () -> new IllegalStateException( "Edicao com id " + edicaoGibiId + "não existe")
        );
        Optional<HistoriaEntity> historiaEntityOptional = iHistoriaRepository.findById(historiaId);

        historiaEntityOptional.ifPresent(edicoesGibi::setHistoriaEntity);

        edicoesGibiRepository.save(edicoesGibi);
    }

    public void deleteHistoriaEdicao(Long edicaoGibiId) {
        EdicoesGibi edicoesGibi = edicoesGibiRepository.findById(edicaoGibiId).orElseThrow(
                () -> new IllegalStateException( "Edicao com id " + edicaoGibiId + "não existe")
        );

        edicoesGibi.setHistoriaEntity(null);

        edicoesGibiRepository.save(edicoesGibi);

    }
}






