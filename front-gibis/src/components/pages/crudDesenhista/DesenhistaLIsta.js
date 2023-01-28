import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import axios from 'axios';
import moment from 'moment'
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

async function updaDesenhista(desenhista) {

      localStorage.setItem('desenhista', JSON.stringify(desenhista) );
  }

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
              <td className="conteudo" id="dataNasc">{moment(desenhista.dataNascimento).format('DD/MM/YYYY')}</td>
              <td className="conteudo" id="dataCont">{moment(desenhista.dataContratacao).format('DD/MM/YYYY')}</td>
              <td className="conteudo" id="dataFal">{moment(desenhista.dataFalecimento).format('DD/MM/YYYY')}</td>
              <td className="conteudo" id="endDes">{desenhista.enderecoDesenhista}</td>
              <td className="conteudo" id="dataDem">{moment(desenhista.dataDemissao).format('DD/MM/YYYY')}</td>
              <td>                  
                <a id="btnUpdateDesenhista" className="acoes button blue" type="button " onClick={() =>updaDesenhista(desenhista)} href="/updatedesenhista"> Editar</a>
              <button className="acoes button red" type="button" onClick={() =>delDesenhista(desenhista.desenhistaId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
    }
  
