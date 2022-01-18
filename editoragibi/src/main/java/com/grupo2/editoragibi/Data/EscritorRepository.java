package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.Builders.EscritorBuilder;
import com.grupo2.editoragibi.Service.Builders.EscritorEntityBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseEscritorBuilder;
import com.grupo2.editoragibi.Service.Directors.Director;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EscritorRepository {

    private IBaseEscritorBuilder escritorBuilder = new EscritorBuilder();
    private IBaseEscritorBuilder escritorEntity = new EscritorEntityBuilder();
    private Director escritorDirector = new Director(escritorBuilder);
    private Director escritorEntityDirector = new Director(escritorEntity);

    @Autowired
    IEscritorRepository escritorRepository;

    public Escritor getEscritorById(int id) throws EscritorInvalidoException, PersonagemInvalidoException {

        Optional<EscritorEntity> escritorEntity = escritorRepository.findById(id);
        if (!escritorEntity.isPresent())
            throw new EscritorInvalidoException("Escritor não está no sistema");
        BaseEscritor escritor = escritorDirector.buildFromEscritorEntity(escritorEntity.get());
        return (Escritor) escritor;
    }

    public List<Escritor> getEscritores() throws PersonagemInvalidoException, EscritorInvalidoException {

        List<EscritorEntity> escritorEntity = escritorRepository.findAll();

        List<Escritor> escritores = new ArrayList<>();
        for (EscritorEntity escritor : escritorEntity) {
            escritores.add((Escritor) escritorDirector.buildFromEscritorEntity(escritor));
        }
        return escritores;
    }

    public Escritor addEscritor(Escritor escritor) throws EscritorInvalidoException, PersonagemInvalidoException {

        EscritorEntity escritorEntity = (EscritorEntity) escritorEntityDirector.buildFromEscritor(escritor);

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return (Escritor) escritorDirector.buildFromEscritorEntity(escritorToReturn);
    }

    public boolean deleteEscritor(int id) {

        if (escritorRepository.findById(id).isEmpty())
            return false;

        escritorRepository.deleteById(id);
        return true;
    }

    public Escritor updateEscritor(int id, Escritor escritor) throws EscritorInvalidoException, PersonagemInvalidoException {

        if (escritorRepository.findById(id).isEmpty())
            throw new EscritorInvalidoException("Escritor não está no sistema");

        escritor.setEscritorId(id);

        EscritorEntity escritorEntity = (EscritorEntity) escritorEntityDirector.buildFromEscritor(escritor);

        EscritorEntity escritorToReturn = escritorRepository.save(escritorEntity);

        return (Escritor) escritorDirector.buildFromEscritorEntity(escritorToReturn);
    }
}
