package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Service.Builders.DesenhistaBuilder;
import com.grupo2.editoragibi.Service.Builders.DesenhistaEntityBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseDesenhistaBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseEscritorBuilder;
import com.grupo2.editoragibi.Service.Directors.DesenhistaDirector;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DesenhistaRepository {

    private IBaseDesenhistaBuilder desenhistaBuilder = new DesenhistaBuilder();
    private IBaseDesenhistaBuilder desenhistaEntityBuilder = new DesenhistaEntityBuilder();
    private DesenhistaDirector desenhistaDirector = new DesenhistaDirector(desenhistaBuilder);
    private DesenhistaDirector desenhistaEntityDirector = new DesenhistaDirector(desenhistaEntityBuilder);

    @Autowired
    IDesenhistaRepository desenhistaRepository;

    public Desenhista getDesenhistaById(int id) throws DesenhistaInvalidoException {

        Optional<DesenhistaEntity> desenhistaEntity = desenhistaRepository.findById(id);

        if (!desenhistaEntity.isPresent())
            throw new DesenhistaInvalidoException("Desenhista não está no sistema");

        return (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaEntity.get());
    }

    public List<Desenhista> getDesenhistas() throws DesenhistaInvalidoException {

        List<DesenhistaEntity> desenhistasEntity = desenhistaRepository.findAll();

        List<Desenhista> desenhistas = new ArrayList<>();
        for (DesenhistaEntity desenhistaEntity : desenhistasEntity) {
            desenhistas.add((Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaEntity));
        }
        return desenhistas;
    }

    public Desenhista addDesenhista(Desenhista desenhista) throws DesenhistaInvalidoException {

        DesenhistaEntity desenhistaEntity = (DesenhistaEntity) desenhistaEntityDirector.buildFromDesenhista(desenhista);

        DesenhistaEntity desenhistaToReturn = desenhistaRepository.save(desenhistaEntity);

        return (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaToReturn);
    }

    public boolean deleteDesenhista(Integer id) {

        if (desenhistaRepository.findById(id).isEmpty())
            return false;

        desenhistaRepository.deleteById(id);
        return true;
    }

    public Desenhista updateDesenhista(int id, Desenhista desenhista) throws DesenhistaInvalidoException {

        if (desenhistaRepository.findById(id).isEmpty())
            throw new DesenhistaInvalidoException("Desenhista não está no sistema");

        desenhista.setDesenhistaId(id);

        DesenhistaEntity desenhistaEntity = (DesenhistaEntity) desenhistaEntityDirector.buildFromDesenhista(desenhista);

        DesenhistaEntity desenhistaToReturn = desenhistaRepository.save(desenhistaEntity);

        return (Desenhista) desenhistaDirector.buildFromDesenhistaEntity(desenhistaToReturn);
    }
}
