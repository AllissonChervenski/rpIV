import { React, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.module.css'
import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'

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

  }

/*
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
          <input type="date" name="dataFalecimentoEs" class="form_input" id="dataFalecimentoEs" placeholder="Data de Falecimento" value={dataFalecimentoEs} onChange={(event) => setDataFalecimento(event.target.value)} />
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
          <input type="date" name="dataDemissao" class="form_input" id="dataDemissao" placeholder="Data Demissao" value={dataDemissao} onChange={(event) => setDataDemissao(event.target.value)} />
        </div>

        <div class="submit">
          <input type="hidden" name="acao" value="enviar" />
          <button onClick={postEscritor} type="submit" name="Submit" class="submit_btn" >Cadastrar</button>

        </div>
      </form>
    </div>
  )
}
*/


return (
  <section className={styles.container_form}>
      <h1>
          Escritor
      </h1>
      <form className={styles.container} onSubmit={postEscritor}>
            <Input type="text" text="Nome do Escritor"  placeholder="Insira o nome do escritor"  required value={nomeEscritor} handleOnChange={(event) => setNomeEscritor(event.target.value)} />

            <Input type="text" text="Pais de Nascimento" name="paisNascimento" placeholder="Insira o Pais de Nascimento do Escritor" required value={paisNascimentoEs} handleOnChange={(event) => setPaisNascimento(event.target.value)}  />

            <Input type="text" text="Endereço Escritor" name="ederecoDesenhista" placeholder="Insira o Endereco do Escritor"  required value={enderecoEscritor} handleOnChange={(event) => setEnderecoEscritor(event.target.value)}/>

            <Input type="date" text="Data de Nascimento" name="dataNascimento" placeholder="Data de Nascimento"  required value={dataNascimentoEs} handleOnChange={(event) => setDataNascimento(event.target.value)}/>

            <Input type="date" text="Data de Falecimento" name="dataDalecimento" placeholder="Data de Falecimento"  value={dataFalecimentoEs} handleOnChange={(event) => setDataFalecimento(event.target.value)} />

            <Input type="date" text="Data de Contratação" name="dataContratação" placeholder="Data de Contratação" required value={dataContratacao} handleOnChange={(event) => setDataContratacao(event.target.value)}/>

            <Input type="date" text="Data de Demissão" name="dataDemissão" placeholder="Data de Demissão"  value={dataDemissao} handleOnChange={(event) => setDataDemissao(event.target.value)}/>

            <Input type="tel" text="Telefone do Escritor" name="telefone" placeholder="Telefone"  value={telefoneEscritor} handleOnChange={(event) => setTelefoneEscritor(event.target.value)}/>

            <Input type="email" text="Email do Escritor" name="email" placeholder="Email do Escritor"  value={emailEscritor} handleOnChange={(event) => setEmailEscritor(event.target.value)}/>

            <SubmitButtom text= "Cadastrar Escritor"/>
        </form>
  </section>
)
}
export default NewEscritor;