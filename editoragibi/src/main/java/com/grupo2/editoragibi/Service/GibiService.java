package com.grupo2.editoragibi.Service;


import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Data.Entity.Gibi;
import com.grupo2.editoragibi.Data.GibiRepository;
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

    private final GibiRepository gibiRepository;

    @Autowired
    public GibiService(GibiRepository gibiRepository) {
        this.gibiRepository = gibiRepository;
    }

    public List<Gibi> getGibis() {
        return gibiRepository.findAll();
    }

    public void addGibi(Gibi gibi) {
        Optional<Gibi> gibiOptional = gibiRepository.findGibiByTitulo(gibi.getTitulo());
        if (gibiOptional.isPresent()) {
            throw new IllegalStateException("Titulo já existente");
        }
        gibiRepository.save(gibi);
    }

    @Transactional
    public void deleteGibi(Long gibiId) {
        boolean exists = gibiRepository.existsById(gibiId);
        if (!exists) {
            throw new IllegalStateException(
                    "Gibi com id " + gibiId + " não existe"
            );
        } else {
            if (gibiRepository.findById(gibiId).isPresent() && gibiRepository.findById(gibiId).get().getEdicoesGibis().size() == 0) {
                gibiRepository.deleteById(gibiId);
            } else {
                throw new IllegalStateException(
                        "Gibi possui uma ou mais edições, portanto não pode ser deletado."
                );
            }
        }

    }

    @Transactional
    public void updateGibi(Long gibiId, String titulo, LocalDate inicio, LocalDate enc, EdicoesGibi edicoes) {
        Gibi gibi = gibiRepository.findById(gibiId).orElseThrow(
                () -> new IllegalStateException("Gibi com id" + gibiId + " não existe"));

        if (titulo != null &&
                titulo.length() > 0 &&
                !Objects.equals(gibi.getTitulo(), titulo)) {
            gibi.setTitulo(titulo);
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
        gibiRepository.save(gibi);
    }

    public void addEdicaoGibi(Long gibiId, Long edicaoGibiId) {
        Optional<EdicoesGibi> edicoesGibiOptional = gibiRepository.findEdicaoGibiById(edicaoGibiId);
        Gibi gibi = gibiRepository.getById(gibiId);
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
}
