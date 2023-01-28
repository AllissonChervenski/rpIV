import { React, useState } from 'react';
import api from "../../../services/api"

function NewEscritor() {
  const [nomeEscritor, setNomeEscritor] = useState('');
  const [paisNascimentoEs, setPaisNascimento] = useState('');
  const [dataNascimentoEs, setDataNascimento] = useState('');
  const [dataFalecimentoEs, setDataFalecimento] = useState('');
  const [enderecoEscritor, setEnderecoEscritor] = useState('');
  const [telefoneEscritor, setTelefoneEscritor] = useState('');
  const [emailEscritor, setEmailEscritor] = useState('');
  const [dataContratacao, setDataContratacao] = useState('');
  const [dataDemissao, setDataDemissao] = useState('');



  async function postEscritor(event) {
    event.preventDefault();

    await api.post("/escritores/create", {
      nomeEscritor,
      paisNascimentoEs,
      dataNascimentoEs,
      dataFalecimentoEs,
      enderecoEscritor,
      telefoneEscritor,
      emailEscritor,
      dataContratacao,
      dataDemissao,

    })
    alert("Cadastrado com sucesso!!");
    window.location.reload(false)

  }


  return (
    <div class="container_form">
      <h1>Formulário de Cadastro</h1>
      <form class="form" action="#" method="post">
        <div class="form_grupo">
          <label for="nomeEscritor" class="form_label"><b>Nome Escritor:</b></label>
          <input type="text" name="nomeEscritor" class="form_input" id="nomeEscritor" placeholder="Nome Escritor" required value={nomeEscritor} onChange={(event) => setNomeEscritor(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="paisNascimentoEs" class="form_label"><b>Pais Nascimento:</b></label>
          <input type="text" name="paisNascimentoEs" class="form_input" id="paisNascimentoEs" placeholder="Pais Nascimento" required value={paisNascimentoEs} onChange={(event) => setPaisNascimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataNascimentoEs" class="form_label"><b>Data de Nascimento:</b></label>
          <input type="date" name="dataNascimentoEs" class="form_input" id="dataNascimentoEs" placeholder="Data de Nascimento" required value={dataNascimentoEs} onChange={(event) => setDataNascimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataFalecimentoEs" class="form_label"><b>Data de Falecimento:</b></label>
          <input type="date" disabled name="dataFalecimentoEs" class="form_input" id="dataFalecimentoEs" placeholder="Data de Falecimento" value={dataFalecimentoEs} onChange={(event) => setDataFalecimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="enderecoEscritor" class="form_label"><b>Endereço:</b></label>
          <input type="text" name="enderecoEscritor" class="form_input" id="enderecoEscritor" placeholder="Endereço" required value={enderecoEscritor} onChange={(event) => setEnderecoEscritor(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="telefoneEscritor" class="form_label"><b>Telefone:</b></label>
          <input type="text" name="telefoneEscritor" class="form_input" id="telefoneEscritor" placeholder="Telefone" required value={telefoneEscritor} onChange={(event) => setTelefoneEscritor(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="emailEscritor" class="form_label"><b>Email:</b></label>
          <input type="text" name="emailEscritor" class="form_input" id="emailEscritor" placeholder="Email" required value={emailEscritor} onChange={(event) => setEmailEscritor(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataContratacao" class="form_label"><b>Data Contratacao:</b></label>
          <input type="date" name="dataContratacao" class="form_input" id="dataContratacao" placeholder="Data Contratação" required value={dataContratacao} onChange={(event) => setDataContratacao(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataDemissao" class="form_label"><b>Data Demissão:</b></label>
          <input type="date" disabled name="dataDemissao" class="form_input" id="dataDemissao" placeholder="Data Demissao" value={dataDemissao} onChange={(event) => setDataDemissao(event.target.value)} />
        </div>

        <div class="submit">
          <input type="hidden" name="acao" value="enviar" />
          <button onClick={postEscritor} type="submit" name="Submit" class="submit_btn" >Cadastrar</button>

        </div>
      </form>
    </div>
  )
}

export default NewEscritor;