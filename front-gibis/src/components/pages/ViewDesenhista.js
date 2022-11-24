import { React, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.css'


function ViewDesenhista() {
  const [nomeDesenhista, setNomeDesenhista] = useState('');
  const [paisNascimento, setPaisNascimento] = useState('');
  const [dataNascimento, setDataNascimento] = useState('');
  const [dataFalecimento, setDataFalecimento] = useState('');
  const [enderecoDesenhista, setEnderecoDesenhista] = useState('');
  const [dataContratacao, setDataContratacao] = useState('');
  const [dataDemissao, setDataDemissao] = useState('');



  async function postDesenhista(event) {
    event.preventDefault();

    const response = await api.post("/update/{id}", {
      nomeDesenhista,
      paisNascimento,
      dataNascimento,
      dataFalecimento,
      enderecoDesenhista,
      dataContratacao,
      dataDemissao,

    })
    alert("Cadastrado com sucesso!!");

  }


  return (
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

export default ViewDesenhista;