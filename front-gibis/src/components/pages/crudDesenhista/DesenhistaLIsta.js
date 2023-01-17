import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'

import '../../../css/main.css'
/*import {deleteDesenhista} from  './deletar'
import { NavigateBefore } from "@material-ui/icons";
import {actionDesenSelecionado} from "./actionDesenSelecionado"
import { isPropertyName } from "typescript";
import { useHistory } from 'react-router-dom';
import NewDesenhista from "../NewDesenhista";
*/

axios.defaults.headers.put['Access-Control-Allow-Origin'] = '*';


export default function Desenhista() {
  const [desenhistas, setDesenhistas] = useState([]);

  useEffect(() => {
    getDesenhistas();
  }, []);


function navigateEdit(id){
localStorage.setItem('idDesenhista', id);

}

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
  
// updateDesenhista(desenhistaId) 

async function updaDesenhista(desenlhistaId) {
  console.log(desenlhistaId);
      try{

       const response = await axios.put(`http://localhost:8080/desenhistas/update/${desenlhistaId}`, 
            
    ) 
   

    console.log(response);

        } catch(err){
          console.log(err)
        }

      
  }
  // <button id="btnUpdateDesenhista" className="acoes" type="button" class="button green" onClick={() =>updaDesenhista(desenhista.desenhistaId)}>Editar</button>




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
                
                <a id="btnUpdateDesenhista" className="acoes button green" type="button" onClick={() =>updaDesenhista(desenhista.desenhistaId)} href="/newdesenhista"> Editar</a>
              <button className="acoes button red" type="button" onClick={() =>delDesenhista(desenhista.desenhistaId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
    }
  
