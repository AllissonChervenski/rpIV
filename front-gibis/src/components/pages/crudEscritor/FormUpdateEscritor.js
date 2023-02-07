import React, {useEffect,  useState } from 'react';
import { useHistory } from 'react-router-dom';
import api from '../../../../src/services/api';

export default function UpdateDesenhista() {
    
    const objectData = JSON.parse(localStorage.getItem('escritor'))
    const [nomeEscritor, setNomeEscritor] = useState(objectData.nomeEscritor);
    const [paisNascimentoEs, setPaisNascimento] = useState(objectData.paisNascimentoEs);
    const [dataNascimentoEs, setDataNascimento] = useState(objectData.dataNascimentoEs);
    const [dataFalecimentoEs, setDataFalecimento] = useState(objectData.dataFalecimentoEs);
    const [enderecoEscritor, setEnderecoEscritor] = useState(objectData.enderecoEscritor);
    const [telefoneEscritor, setTelefoneEscritor] = useState(objectData.telefoneEscritor);
    const [emailEscritor, setEmailEscritor] = useState(objectData.emailEscritor);
    const [dataContratacao, setDataContratacao] = useState(objectData.dataContratacao);
    const [dataDemissao, setDataDemissao] = useState(objectData.dataDemissao);
    const history = useHistory();
  
async function putEscritor(event){

    const objectData = JSON.parse(localStorage.getItem('escritor'));

  event.preventDefault();
 try{
  const response = await api.put(`escritores/update/${objectData.escritorId}`, {

    nomeEscritor : nomeEscritor,
    paisNascimentoEs : paisNascimentoEs ,
    dataNascimentoEs : dataNascimentoEs,
    dataFalecimentoEs : dataFalecimentoEs,
    enderecoEscritor : enderecoEscritor,
    telefoneEscritor : telefoneEscritor,
    emailEscritor : emailEscritor,
    dataContratacao : dataContratacao,
    dataDemissao : dataDemissao,
   
  })
  alert("Cadastro Editado com sucesso!!");
  //alert(response.data);
  history.push("/escritor")

}catch(err){
    alert(err);
  }

  window.location.reload(false)

}

useEffect(() => {
    const objectData = JSON.parse(localStorage.getItem('escritor'));

  }, []);

   
  return (
    <div class="container_form">
    <h1>Formulário de Editar</h1>
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
        <input type="date"  name="dataFalecimentoEs" class="form_input" id="dataFalecimentoEs" placeholder="Data de Falecimento" value={dataFalecimentoEs} onChange={(event) => setDataFalecimento(event.target.value)} />
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
        <input type="date"  name="dataDemissao" class="form_input" id="dataDemissao" placeholder="Data Demissao" value={dataDemissao} onChange={(event) => setDataDemissao(event.target.value)} />
      </div>

        <div class="submit">
          <input type="hidden" name="acao" value="enviar" />
          <button onClick={putEscritor} type="submit" name="Submit" className="submit_btn green" >Atualizar</button>

        </div>
      </form>
    </div>
  )
}
