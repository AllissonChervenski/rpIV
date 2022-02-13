package com.editoragibi.editoragibi.Service;

import com.editoragibi.editoragibi.Api.Requests.PersonagemRequest;
import com.editoragibi.editoragibi.Data.Entity.PersonagemEntity;
import com.editoragibi.editoragibi.Data.PersonagemRepository;
import com.editoragibi.editoragibi.Service.Directors.PersonagemDirector;
import com.editoragibi.editoragibi.Service.Domain.Personagem;
import com.editoragibi.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.editoragibi.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemService {

    @Qualifier("personagemDirector")
    @Autowired
    PersonagemDirector personagemDirector;

    @Qualifier("personagemEntityDirector")
    @Autowired
    PersonagemDirector personagemEntityDirector;

    @Autowired
    PersonagemRepository personagemRepository;

    public Personagem getPersonagemById(int id) throws PersonagemInvalidoException, EscritorInvalidoException {
        return (Personagem) personagemDirector.buildFromPersonagemEntity(personagemRepository.getPersonagemById(id));
    }

    public List<Personagem> getPersonagens() throws PersonagemInvalidoException, EscritorInvalidoException {
        List<PersonagemEntity> personagemEntities = personagemRepository.getPersonagens();
        List<Personagem> personagens = new ArrayList<>();
        for (PersonagemEntity personagem : personagemEntities) {
            personagens.add((Personagem) personagemDirector.buildFromPersonagemEntity(personagem));
        }
        return personagens;
    }

    public Personagem addPersonagem(PersonagemRequest personagemRequest) throws EscritorInvalidoException, PersonagemInvalidoException {
        Personagem personagem = (Personagem) personagemDirector.buildFromPersonagemRequest(personagemRequest);
        PersonagemEntity personagemEntity = (PersonagemEntity) personagemEntityDirector.buildFromPersonagem(personagem);
        return (Personagem) personagemDirector.buildFromPersonagemEntity(personagemRepository.addPersonagem(personagemEntity));
    }

    public void deletePersonagem(int id) throws PersonagemInvalidoException {

        if (!personagemRepository.deletePersonagem(id))
            throw new PersonagemInvalidoException("Personagem não está no sistema");
    }

    public Personagem updatePersonagem(int id, PersonagemRequest personagemRequest) throws EscritorInvalidoException, PersonagemInvalidoException {
        Personagem personagem = (Personagem) personagemDirector.buildFromPersonagemRequest(personagemRequest);
        PersonagemEntity personagemEntity = (PersonagemEntity) personagemEntityDirector.buildFromPersonagem(personagem);
        return (Personagem) personagemDirector.buildFromPersonagemEntity(personagemRepository.updatePersonagem(id, personagemEntity));
    }
}
