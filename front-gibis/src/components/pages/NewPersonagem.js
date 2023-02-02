import { React, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.module.css'
import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'

function NewPersonagem() {
  const [nomePersonagem, setNomePersonagem] = useState('');
  const [dataCriacao, setDataCriacao] = useState('');
  const [historicoPersonagem, setHistoricoPersonagem] = useState('');
  const [patentePersonagem, setPatentePersonagem] = useState('');


    async function postPersonagem(event) {
        event.preventDefault();

        await api.post("/personagens/create", {
          nomePersonagem,
          dataCriacao,
          historicoPersonagem,
          patentePersonagem,
        })
        alert("Cadastrado com sucesso!!");

    }

    return (
        <section className={styles.container_form}>
            <h1>
                Personagem
            </h1>
            <form className={styles.container} onSubmit={postPersonagem}>
              <Input type="text" text="Nome do Personagem" name="nomePersonagem" placeholder="Insira o nome do personagem"  required value={nomePersonagem} handleOnChange={(event) => setNomePersonagem(event.target.value)} />

              <Input type="date" text="Data de Criação" name="dataCriacao" placeholder="Data de Criação"  value={dataCriacao} handleOnChange={(event) => setDataCriacao(event.target.value)} />

              <Input type="text" text="Histórico Personagem" name="historicoPersonagem" placeholder="Histórico do Personagem" required value={historicoPersonagem} handleOnChange={(event) => setHistoricoPersonagem(event.target.value)}/>

              <Input type="text" text="Patente do Personagem" name="patentePersonagem" placeholder="Patente do Personagem"  value={patentePersonagem} handleOnChange={(event) => setPatentePersonagem(event.target.value)}/>

              <SubmitButtom text= "Cadastrar Personagem"/>
            </form>
        </section>
    )
}
export default NewPersonagem;