package com.editoragibi.editoragibi.Data.Entity;

import com.editoragibi.editoragibi.Service.BaseObjects.BaseTransportadora;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transportadora")
public class TransportadoraEntity extends BaseTransportadora {

    @Id
    @Column(name = "transportadora_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transportadora_transportadora_id_seq")
    private int transportadoraId;

    @Column(name = "nome_transportadora")
    private String nomeTransportadora;

    @Column(name = "endereco_transportadora")
    private String enderecoTransportadora;

    @Column(name = "telefoneTransportadora")
    private String telefoneTransportadora;
}
