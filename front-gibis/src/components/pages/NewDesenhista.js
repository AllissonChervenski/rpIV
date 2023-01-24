import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'
import { React, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.module.css'
import DesenhistasForm from '../../components/project/DesenhistaForm'


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


  /*return (
    <div class="container_form">
      <h1>Formulário de Cadastro</h1>
      <form class="form" action="#" method="post">
        <div class="form_grupo">
          <label for="nomeDesenhista" class="form_label"><b>Nome Desenhista:</b></label>
          <input type="text" name="nomeDesenhista" class="form_input" id="nomeDesenhista" placeholder="Nome Desenhista" required value={nomeDesenhista} onChange={(event) => setNomeDesenhista(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="paisNascimento" class="form_label"><b>Pais Nascimento:</b></label>
          <input type="text" name="paisNascimento" class="form_input" id="paisNascimento" placeholder="Pais Nascimento" required value={paisNascimento} onChange={(event) => setPaisNascimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataNascimento" class="form_label"><b>Data de Nascimento:</b></label>
          <input type="date" name="dataNascimento" class="form_input" id="dataNascimento" placeholder="Data de Nascimento" required value={dataNascimento} onChange={(event) => setDataNascimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataFalecimento" class="form_label"><b>Data de Falecimento:</b></label>
          <input type="date" name="dataFalecimento" class="form_input" id="dataFalecimento" placeholder="Data de Falecimento" value={dataFalecimento} onChange={(event) => setDataFalecimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="enderecoDesenhista" class="form_label"><b>Endereço:</b></label>
          <input type="text" name="enderecoDesenhista" class="form_input" id="enderecoDesenhista" placeholder="Endereço" required value={enderecoDesenhista} onChange={(event) => setEnderecoDesenhista(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataContratacao" class="form_label"><b>Data Contratacao:</b></label>
          <input type="date" name="dataContratacao" class="form_input" id="dataContratacao" placeholder="Data Contratação" required value={dataContratacao} onChange={(event) => setDataContratacao(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataDemissao" class="form_label"><b>Data Demissão:</b></label>
          <input type="date" name="dataDemissao" class="form_input" id="dataDemissao" placeholder="Data Demissao" value={dataDemissao} onChange={(event) => setDataDemissao(event.target.value)} />
        </div>

        <div class="submit">
          <input type="hidden" name="acao" value="enviar" />
          <button onClick={postDesenhista} type="submit" name="Submit" class="submit_btn" >Cadastrar</button>

        </div>
      </form>
    </div>
  )
}
*/



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