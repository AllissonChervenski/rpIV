package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.DesenhistaRepository;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.HistoriaRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaService {

    @Autowired
    HistoriaRepository historiaRepository;

    @Autowired
    DesenhistaRepository desenhistaRepository;

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

    public Historia getHistoriaById(int id) throws HistoriaInvalidaException {

        return historiaRepository.getHistoriaById(id);
    }

    public List<Historia> getHsitorias() {

        return historiaRepository.getHistorias();
    }

    public Historia addHistoria(Historia historia, int artefinalizadorId, int desenhistaId, int escritorId, List<Integer> personagensIds) throws Exception {

        addAttributes(historia, artefinalizadorId, desenhistaId, escritorId, personagensIds);

        return historiaRepository.addHistoria(historia);
    }

    public void deleteHistoria(int id) throws HistoriaInvalidaException {

        if (!historiaRepository.deleteHistoria(id))
            throw new HistoriaInvalidaException("Historia não está no sistema");
    }

    private void addAttributes(Historia historia, int artefinalizadorId, int desenhistaId, int escritorId, List<Integer> personagensIds) throws Exception {

        Optional<Desenhista> artefinalizador = desenhistaRepository.getDesenhistaById(artefinalizadorId);
        if (artefinalizador.isEmpty())
            throw new Exception("Artefinalizador Inválido");
        historia.setArtefinalizador(artefinalizador.get());

        Optional<Desenhista> desenhista = desenhistaRepository.getDesenhistaById(desenhistaId);
        if (desenhista.isEmpty())
            throw new Exception("Desenhista Inválido");
        historia.setDesenhista(desenhista.get());

        historia.setEscritor( escritorRepository.getEscritorById(escritorId));

        if (personagensIds.isEmpty())
            throw new Exception("Não tem personagens relacionador à essa historia");

        for (int id : personagensIds) {

            Personagem personagem = personagemRepository.getPersonagemById(id);

            historia.addPersonagem(personagem);
        }
    }

    public Historia updateHistoria(int id, Historia historia, int artefinalizadorId, int desenhistaId, int escritorId, List<Integer> personagensIds) throws Exception {

        addAttributes(historia, artefinalizadorId, desenhistaId, escritorId, personagensIds);

        return historiaRepository.updateHistoria(id, historia);
    }
}
