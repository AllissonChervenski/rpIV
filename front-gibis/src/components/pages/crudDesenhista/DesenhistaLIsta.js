import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'
import {deleteDesenhista} from  './deletar'
import { NavigateBefore } from "@material-ui/icons";
import {actionDesenSelecionado} from "./actionDesenSelecionado"
import { isPropertyName } from "typescript";
import { useHistory } from 'react-router-dom';
import NewDesenhista from "../NewDesenhista";


axios.defaults.headers.put['Access-Control-Allow-Origin'] = '*';


export default function Desenhista() {
  const [desenhistas, setDesenhistas] = useState([]);

  useEffect(() => {
    getDesenhistas();
  }, []);

  const getDesenhistas = async () => {
    await api.get("/desenhistas/all").then((response) => {
      setDesenhistas(response.data);
      console.log(response.data)
    });
  };


const delDesenhista = (desenlhistaId)=>{
  // deleteDesenhista(desenhistaId)
  
 axios.delete(`http://localhost:8080/desenhistas/delete/${desenlhistaId}`, 
 alert("Desenhista deletado com sucesso!!"),
 window.location.reload(false)
 
  ) 
   
}
 
async function updaDesenhista(desenlhistaId) {
  console.log(desenlhistaId);
      // updateDesenhista(desenhistaId) 
      try{

       const response = await axios.put(`http://localhost:8080/desenhistas/update/${desenlhistaId}`, 
            
    ) 
   

    console.log(response);

        } catch(err){
          console.log(err)
        }

   
  }

 /* const updateD = (props) => {
    async function updaDesenhista(e){
        const options = {
            method: 'PUT',
            baseUrl: 'http://localhost:3000/desenhista/update'
        }
    }
}*/

  /// teste novo update
  /*var selectedRow=null

  function formDesenhista(){
    var formData =  readformDesenhistaData();
    resertForm()

  }
  function readformDesenhistaData(){
    var formData = {};
    formData["nomeDesenhista"] = document.getElementById("nomeDesenhista").value;
    formData["paisNascimento"] = document.getElementById("paisNascimento").value;
    formData["dataNascimento"] = document.getElementById("dataNascimento").value;
    formData["dataFalecimento"] = document.getElementById("dataFalecimento").value;
    formData["enderecoDesenhista"] = document.getElementById("enderecoDesenhista").value;
    formData["dataContratacao"] = document.getElementById("dataContratacao").value;
    formData["dataDemissao"] = document.getElementById("dataDemissao").value;

    return formData;

  }
    function resertForm(){
      document.getElementById("nomeDesenhista").value = " ";
      document.getElementById("paisNascimento").value=" ";
      document.getElementById("dataNascimento").value = "";
      document.getElementById("dataFalecimento").value = " ";
      document.getElementById("enderecoDesenhista").value =" ";
      document.getElementById("dataContratacao").value =" ";
      document.getElementById("dataDemissao").value= " ";
    }
function updaDesenhista(td){
  selectedRow = td.parentElement.parentElement;
  doc

   
}*/

/*btnUpdateDesenhista.onClick = () =>{
  const id = parseInt(desenhistaId.value || 0);

  if(id){
    tableDesenhista.products.update(id, {
      nomeDesenhista: nomeDesenhista.value,
      paisNascimento: paisNascimento.value,
      dataNascimento: dataNascimento.value



    }).then((updated) => {
      let get = updated ? true : false;
      
      nomeDesenhista.value = paisNascimento.value = dataNascimento.value= " ";
      
    })

  }else{
    console.log(`Please Select id: ${id}`);
  }

}*/

/*const btnUpdateDesenhista = (event) =>{
  let id = parseInt(event.target.dataset.id);
  tableDesenhista.products.get(id, function (postDesenhista{
    let NewDesenhistaUp = 
  })
}
*/


  ///

   return (   
   
    <table className="records" border="1" >
      <caption className="caption-title">Desenhista Cadastrado</caption>
      <thead>
      <tr >
              <th className="conteudo">id</th>                      
              <th className="conteudo">Nome</th>
              <th className="conteudo">Pais</th>
              <th className="conteudo">Data de Nascimento</th>
              <th className="conteudo">Data contratação</th>
              <th className="conteudo">Data Falecimento</th>
              <th className="conteudo">Endereço</th>
              <th className="conteudo">Data demissão</th>
              <th className="acoes">Ações</th>
            </tr>

      </thead>
     
      {desenhistas.map((desenhista) => (              
           
            <tr id="tableData">
              <td className="conteudo" id="Id">{desenhista.desenhistaId}</td>
              <td className="conteudo"id="nome">{desenhista.nomeDesenhista}</td>
              <td className="conteudo" id="pais">{desenhista.paisNascimento}</td>
              <td className="conteudo" id="dataNasc">{desenhista.dataNascimento}</td>
              <td className="conteudo" id="dataCont">{desenhista.dataContratacao}</td>
              <td className="conteudo" id="dataFal">{desenhista.dataFalecimento}</td>
              <td className="conteudo" id="endDes">{desenhista.enderecoDesenhista}</td>
              <td className="conteudo" id="dataDem">{desenhista.dataDemissao}</td>
              <td>                
                <button id="btnUpdateDesenhista" className="acoes" type="button" class="button green" onClick={() =>updaDesenhista(desenhista.desenhistaId)}>Editar</button>                
                <button className="acoes" type="button" class="button red" onClick={() =>delDesenhista(desenhista.desenhistaId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
    }
  
