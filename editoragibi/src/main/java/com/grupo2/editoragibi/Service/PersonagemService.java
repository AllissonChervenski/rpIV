package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
<<<<<<< HEAD
<<<<<<< HEAD
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
=======
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    EscritorRepository escritorRepository;

<<<<<<< HEAD
<<<<<<< HEAD
    public Personagem getPersonagemById(int id) throws PersonagemInvalidoException {

        Optional<Personagem> personagem = personagemRepository.getPersonagemById(id);

=======
    public Personagem getPersonagemById(int id) {

        Optional<Personagem> personagem = personagemRepository.getPersonagemById(id);

        if (personagem.isEmpty())
            return null;

>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public Personagem getPersonagemById(int id) throws PersonagemInvalidoException {

        Optional<Personagem> personagem = personagemRepository.getPersonagemById(id);

>>>>>>> 0e6e52f (tratamento de exceções apropriado)
        return personagem.get();
    }

    public List<Personagem> getPersonagens() {

        return personagemRepository.getPersonagens();
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public Personagem addPersonagem(Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException {
=======
    public Personagem addPersonagem(Personagem personagem, List<Integer> escritoresIds) throws Exception {
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public Personagem addPersonagem(Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        addEscritor(personagem, escritoresIds);

        return personagemRepository.addPersonagem(personagem);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public void deletePersonagem(int id) throws PersonagemInvalidoException {

        if (!personagemRepository.deletePersonagem(id))
            throw new PersonagemInvalidoException("Personagem não está no sistema");
    }

    public Personagem updatePersonagem(int id, Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException, PersonagemInvalidoException {
=======
    public boolean deletePersonagem(int id) {
=======
    public void deletePersonagem(int id) throws PersonagemInvalidoException {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        if (!personagemRepository.deletePersonagem(id))
            throw new PersonagemInvalidoException("Personagem não está no sistema");
    }

<<<<<<< HEAD
    public Personagem updatePersonagem(int id, Personagem personagem, List<Integer> escritoresIds) throws Exception {
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public Personagem updatePersonagem(int id, Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException, PersonagemInvalidoException {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        addEscritor(personagem, escritoresIds);

        return personagemRepository.updatePersonagem(id, personagem);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    private void addEscritor(Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException {

        if (escritoresIds == null || escritoresIds.isEmpty())
            throw new EscritorInvalidoException("Personagem sem escritor associado");
=======
    private void addEscritor(Personagem personagem, List<Integer> escritoresIds) throws Exception {

        if (escritoresIds == null || escritoresIds.isEmpty())
            throw new Exception("Sem escritor");
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    private void addEscritor(Personagem personagem, List<Integer> escritoresIds) throws EscritorInvalidoException {

        if (escritoresIds == null || escritoresIds.isEmpty())
            throw new EscritorInvalidoException("Personagem sem escritor associado");
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        for (int id : escritoresIds) {

            Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

            if (escritor.isEmpty())
<<<<<<< HEAD
<<<<<<< HEAD
                throw new EscritorInvalidoException("Escritor não está no sistema");
=======
                throw new Exception("Escritor invalido");
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
                throw new EscritorInvalidoException("Escritor não está no sistema");
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

            personagem.addEscritor(escritor.get());
        }
    }
}
