package com.grupo2.editoragibi.Service.Builders;

import com.grupo2.editoragibi.Data.DesenhistaRepository;
import com.grupo2.editoragibi.Data.Entity.DesenhistaEntity;
import com.grupo2.editoragibi.Data.Entity.EscritorEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.IDesenhistaRepository;
import com.grupo2.editoragibi.Data.IEscritorRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseHistoria;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

public class HistoriaEntityBuilder implements IBaseHistoriaBuilder {

    private IDesenhistaRepository iDesenhistaRepository;
    private IEscritorRepository iEscritorRepository;
    private HistoriaEntity historiaEntity;

    public HistoriaEntityBuilder(IDesenhistaRepository iDesenhistaRepository, IEscritorRepository iEscritorRepository) {
        this.iDesenhistaRepository = iDesenhistaRepository;
        this.iEscritorRepository = iEscritorRepository;
        reset();
    }

    private void reset() {
        historiaEntity = new HistoriaEntity();
    }

    @Override
    public void setHistoriaId(int historiaId) {
        historiaEntity.setHistoriaId(historiaId);
    }

    @Override
    public void setTituloHistoria(String tituloHistoria) {
        historiaEntity.setTituloHistoria(tituloHistoria);
    }

    @Override
    public void setTotalPaginas(int totalPaginas) {
        historiaEntity.setTotalPaginas(totalPaginas);
    }

    @Override
    public void setDataProducao(LocalDate dataProducao) {
        historiaEntity.setDataProducao(dataProducao);
    }

    @Override
    public void setArtefinalizador(int artefinalizadorId) throws DesenhistaInvalidoException, HistoriaInvalidaException {
        Optional<DesenhistaEntity> desenhistaEntity = iDesenhistaRepository.findById(artefinalizadorId);
        historiaEntity.setArtefinalizador(desenhistaEntity.get());
    }

    @Override
    public void setDesenhista(int desenhistaId) throws DesenhistaInvalidoException {
        Optional<DesenhistaEntity> desenhistaEntity = iDesenhistaRepository.findById(desenhistaId);
        historiaEntity.setDesenhista(desenhistaEntity.get());
    }

    @Override
    public void setEscritor(int escritorId) throws PersonagemInvalidoException, EscritorInvalidoException {
        Optional<EscritorEntity> escritorEntity = iEscritorRepository.findById(escritorId);
        historiaEntity.setEscritor(escritorEntity.get());
    }

    @Override
    public BaseHistoria getResult() {
        HistoriaEntity toReturn = historiaEntity;
        reset();
        return toReturn;
    }
}
