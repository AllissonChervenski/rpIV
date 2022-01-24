package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Api.Requests.PersonagemRequest;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Builders.IBasePersonagemBuilder;
import com.grupo2.editoragibi.Service.Builders.PersonagemBuilder;
import com.grupo2.editoragibi.Service.Directors.PersonagemDirector;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    private IBasePersonagemBuilder personagemBuilder = new PersonagemBuilder();
    private PersonagemDirector personagemDirector = new PersonagemDirector(personagemBuilder);

    @Autowired
    PersonagemRepository personagemRepository;

    @Autowired
    EscritorRepository escritorRepository;

    public Personagem getPersonagemById(int id) throws PersonagemInvalidoException, EscritorInvalidoException {

        return personagemRepository.getPersonagemById(id);
    }

    public List<Personagem> getPersonagens() throws PersonagemInvalidoException, EscritorInvalidoException {

        return personagemRepository.getPersonagens();
    }

    public Personagem addPersonagem(PersonagemRequest personagemRequest) throws EscritorInvalidoException, PersonagemInvalidoException {

        Personagem personagem = (Personagem) personagemDirector.buildFromPersonagemRequest(personagemRequest);
        return personagemRepository.addPersonagem(personagem);
    }

    public void deletePersonagem(int id) throws PersonagemInvalidoException {

        if (!personagemRepository.deletePersonagem(id))
            throw new PersonagemInvalidoException("Personagem não está no sistema");
    }

    public Personagem updatePersonagem(int id, PersonagemRequest personagemRequest) throws EscritorInvalidoException, PersonagemInvalidoException {

        Personagem personagem = (Personagem) personagemDirector.buildFromPersonagemRequest(personagemRequest);
        return personagemRepository.updatePersonagem(id, personagem);
    }
}
