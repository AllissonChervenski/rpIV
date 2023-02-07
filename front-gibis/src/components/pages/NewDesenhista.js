import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'
import { React, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.module.css'


function NewDesenhista() {
  const [nomeDesenhista, setNomeDesenhista] = useState('');
  const [paisNascimento, setPaisNascimento] = useState('');
  const [dataNascimento, setDataNascimento] = useState('');
  const [dataFalecimento, setDataFalecimento] = useState('');
  const [enderecoDesenhista, setEnderecoDesenhista] = useState('');
  const [dataContratacao, setDataContratacao] = useState('');
  const [dataDemissao, setDataDemissao] = useState('');


  async function postDesenhista(event) {
    event.preventDefault();

    const response = await api.post("/desenhistas/create", {
      nomeDesenhista,
      paisNascimento,
      dataNascimento,
      dataFalecimento,
      enderecoDesenhista,
      dataContratacao,
      dataDemissao,

    })
    console.log(nomeDesenhista)
    alert("Cadastrado com sucesso!!");

  }

return (
  <section className={styles.container_form}>
      <h1>
          Desenhistas
      </h1>
      <form className={styles.container} onSubmit={postDesenhista}>
            <Input type="text" text="Nome de Desenhista"  placeholder="Insira o nome do desenhista"  required value={nomeDesenhista} handleOnChange={(event) => setNomeDesenhista(event.target.value)} />

            <Input type="text" text="Pais de Nascimento" name="paisNascimento" placeholder="Insira o Pais de Nascimento do Desenhista" required value={paisNascimento} handleOnChange={(event) => setPaisNascimento(event.target.value)}  />

            <Input type="text" text="Endereço Desenhista" name="ederecoDesenhista" placeholder="Insira o Endereco do Desenhista"  required value={enderecoDesenhista} handleOnChange={(event) => setEnderecoDesenhista(event.target.value)}/>

            <Input type="date" text="Data de Nascimento" name="dataNascimento" placeholder="Data de Nascimento"  required value={dataNascimento} handleOnChange={(event) => setDataNascimento(event.target.value)}/>

            <Input type="date" text="Data de Falecimento" name="dataDalecimento" placeholder="Data de Falecimento"  value={dataFalecimento} handleOnChange={(event) => setDataFalecimento(event.target.value)} />

            <Input type="date" text="Data de Contratação" name="dataContratação" placeholder="Data de Contratação" required value={dataContratacao} handleOnChange={(event) => setDataContratacao(event.target.value)}/>

            <Input type="date" text="Data de Demissão" name="dataDemissão" placeholder="Data de Demissão"  value={dataDemissao} handleOnChange={(event) => setDataDemissao(event.target.value)}/>

            <SubmitButtom text= "Cadastrar Desenhista"/>
        </form>
  </section>
)
}
export default NewDesenhista;