package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
<<<<<<< HEAD
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
=======
>>>>>>> f2e5813 (crud de escritor e personagem)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscritorService {

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

<<<<<<< HEAD
    public Escritor getEscritorById(int id) throws EscritorInvalidoException {

        Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

=======
    public Escritor getEscritorById(int id) {

        Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

        if (escritor.isEmpty())
            return null;

>>>>>>> f2e5813 (crud de escritor e personagem)
        return escritor.get();
    }

    public List<Escritor> getEscritores() {

        return escritorRepository.getEscritores();
    }

    public Escritor addEscritor(Escritor escritor) {

        return escritorRepository.addEscritor(escritor);
    }

<<<<<<< HEAD
    public void deleteEscritor(int id) throws EscritorInvalidoException {

        if (!escritorRepository.deleteEscritor(id))
            throw new EscritorInvalidoException("Escritor não está no sistema");
    }

    public Escritor updateEscritor(int id, Escritor escritor) throws EscritorInvalidoException {
=======
    public boolean deleteEscritor(int id) {

        escritorRepository.deleteEscritor(id);

        return true;
    }

    public Escritor updateEscritor(int id, Escritor escritor) {
>>>>>>> f2e5813 (crud de escritor e personagem)

        return escritorRepository.updateEscritor(id, escritor);
    }
}
