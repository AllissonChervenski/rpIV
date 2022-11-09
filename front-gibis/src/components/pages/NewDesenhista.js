import { React, useState } from 'react';
import api from "../../services/api";


function NewDesenhista() {
  const [nomeDesenhista, setNomeDesenhista] = useState('OI');
  const [paisNascimento, setPaisNascimento] = useState('');
  const [dataNascimento, setDataNascimento] = useState('');
  const [dataFalecimento, setDataFalecimento] = useState('');
  const [enderecoDesenhista, setEnderecoDesenhista] = useState('');
  const [dataContratacao, setDataContratacao] = useState('');
  const [dataDemissao, setDataDemissao] = useState('');



  async function postDesenhista(event) {
    event.preventDefault();


   alert("iniciando a requisição")
      const response = await api.post("/desenhistas/create", {
        nomeDesenhista ,
        paisNascimento ,
        dataNascimento , 
        dataFalecimento , 
        enderecoDesenhista ,
        dataContratacao ,
        dataDemissao , 
       
      })

     alert(enderecoDesenhista)
   alert(response.data);

  }

 
  return (
    <form>
      <span>Nome desenhista</span>
      <input type="text" value={nomeDesenhista} onChange={(event) => setNomeDesenhista(event.target.value)}/>
      <span>Pais nascimento</span>
      <input type="text" value={paisNascimento} onChange={(event) => setPaisNascimento(event.target.value)}/>
      <span>Data Nascimento</span>
      <input type="date" value={dataNascimento} onChange={(event) => setDataNascimento(event.target.value)}/>
      <span>Data Falecimento</span>
      <input type="date" value={dataFalecimento} onChange={(event) => setDataFalecimento(event.target.value)}/>
      <span>Endereço</span>
      <input type="text" value={enderecoDesenhista} onChange={(event) => setEnderecoDesenhista(event.target.value)}/>
      <span>Data Contratação</span>
      <input type="date" value={dataContratacao} onChange={(event) => setDataContratacao(event.target.value)}/>
      <span>Data Demissão</span>
      <input type="date" value={dataDemissao} onChange={(event) => setDataDemissao(event.target.value)}/>
    
    

{
/* 
      <Input type="text" text="Nome Desenhista" onChange={(event) => setNomeDesenhista(event.target.value)} placeholder="Insira o nome completo do Desenhista" />

  
      <Input type="text" text="Pais de Nascimento" onChange={(event) => setPaisNascimento(event.target.value)} placeholder="País de nascimento do Desenhista" />

      <Input type="date" text="Data de Nascimento" onChange={(event) => setDataNascimento(event.target.value)} placeholder="Insira a data de Nascimento" />

      <Input type="date" text="Data de Falecimento" onChange={(event) => setDataFalecimento(event.target.value)} placeholder="Insira a data de Falecimento" />

      <Input type="text" text="Endereço" onChange={(event) => setEnderecoDesenhista(event.target.value)} placeholder="Insira o endereço do desenhista" />

      <Input type="date" text="Data do Contrato" onChange={(event) => setDataContratacao(event.target.value)} placeholder="Insira a data de contratação" />

      <Input type="date" text="Data de Demissao" onChange={(event) => setDataDemissao(event.target.value)} placeholder="Insira a data de demissão (se houver)" /> */}

      <button onClick={postDesenhista}/>
    </form>
  )
}







export default NewDesenhista;
