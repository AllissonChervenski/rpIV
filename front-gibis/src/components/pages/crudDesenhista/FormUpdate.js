import React, {useEffect,  useState } from 'react';
import { useHistory } from 'react-router-dom';
import api from '../../../../src/services/api';

export default function  UpdateEscritor() {
 
  const objectData = JSON.parse(localStorage.getItem('desenhista'));
  const [nomeDesenhista, setNomeDesenhista] = useState(objectData.nomeDesenhista);
  const [paisNascimento, setPaisNascimento] = useState(objectData.paisNascimento);
  const [dataNascimento, setDataNascimento] = useState(objectData.dataNascimento);
  const [dataFalecimento, setDataFalecimento] = useState(objectData.dataFalecimento);
  const [enderecoDesenhista, setEnderecoDesenhista] = useState(objectData.enderecoDesenhista);
  const [dataContratacao, setDataContratacao] = useState(objectData.dataContratacao);
  const [dataDemissao, setDataDemissao] = useState(objectData.dataDemissao);
  const history = useHistory();
  
async function putDesenhista(event){

    const objectData = JSON.parse(localStorage.getItem('desenhista'));

  event.preventDefault();
 try{
  const response = await api.put(`desenhistas/update/${objectData.desenhistaId}`, {
    nomeDesenhista : nomeDesenhista,
    paisNascimento: paisNascimento ,
    dataNascimento: dataNascimento,
    dataFalecimento: dataFalecimento,
    enderecoDesenhista: enderecoDesenhista,
    dataContratacao: dataContratacao,
    dataDemissao: dataDemissao,

  })
  alert("Cadastro Editado com sucesso!!");
  //alert(response.data);
  history.push("/desenhista")

}catch(err){
    alert(err);
  }

  window.location.reload(false)

}

useEffect(() => {
    const objectData = JSON.parse(localStorage.getItem('desenhista'));


  }, []);

   
  return (
    <div class="container_form" id='tableDesenhista'>
      <h1>Formulário de Editar</h1>
      <form class="form" action="#" id='formDesenhista' method="post">
        <div class="form_grupo">
          <label for="nomeDesenhista" class="form_label"><b>Nome Desenhista:</b></label>
          <input type="text" class="form_input" id="nomeDesenhista" required value={nomeDesenhista} onChange={(event) => setNomeDesenhista(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="paisNascimento" class="form_label"><b>Pais Nascimento:</b></label>
          <input type="text" name="paisNascimento" class="form_input" id="paisNascimento"  required value={paisNascimento} onChange={(event) => setPaisNascimento(event.target.value)} />
        </div>    


        <div class="form_grupo">
          <label for="dataNascimento" class="form_label"><b>Data de Nascimento:</b></label>
          <input type="date" name="dataNascimento" class="form_input" id="dataNascimento" placeholder={objectData.dataNascimento} required value={dataNascimento} onChange={(event) => setDataNascimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataFalecimento" class="form_label"><b>Data de Falecimento:</b></label>
          <input type="date" name="dataFalecimento" class="form_input" id="dataFalecimento" placeholder={objectData.dataFalecimento} value={dataFalecimento} onChange={(event) => setDataFalecimento(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="enderecoDesenhista" class="form_label"><b>Endereço:</b></label>
          <input type="text" name="enderecoDesenhista" class="form_input" id="enderecoDesenhista" placeholder={objectData.enderecoDesenhista} required value={enderecoDesenhista} onChange={(event) => setEnderecoDesenhista(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataContratacao" class="form_label"><b>Data Contratacao:</b></label>
          <input type="date" name="dataContratacao" class="form_input" id="dataContratacao" placeholder={objectData.dataContratacao} required value={dataContratacao} onChange={(event) => setDataContratacao(event.target.value)} />
        </div>
        <div class="form_grupo">
          <label for="dataDemissao" class="form_label"><b>Data Demissão: </b></label>
          <input type="date" name="dataDemissao" class="form_input" id="dataDemissao" placeholder={objectData.dataDemissao} value={dataDemissao} onChange={(event) => setDataDemissao(event.target.value)} />
        </div>

        <div class="submit">
          <input type="hidden" name="acao" value="enviar" />
          <button onClick={putDesenhista} type="submit" name="Submit" className="submit_btn green" >Atualizar</button>

        </div>
      </form>
    </div>
  )
}
