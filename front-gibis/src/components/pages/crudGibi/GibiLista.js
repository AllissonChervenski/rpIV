import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import moment from 'moment';
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'

axios.defaults.headers.put['Access-Control-Allow-Origin'] = '*';

export default function Gibi() {
  const [gibis, setGibis] = useState([]);
  const [query, setQuery] = useState("");
  useEffect(() => {
    getGibis(query);
  }, [query]);
  

  const getGibis = async () => {
    await api.get("/gibis/all").then((response) => {
      setGibis(response.data);
      console.log(response.data)
    });
  };

    // deleteDesenhista(desenhistaId)

const delGibi = (gibiId)=>{  
 axios.delete(`http://localhost:8080/gibis/deleteGibi/${gibiId}`, 
 alert("Gibi deletado com sucesso!!"),
 window.location.reload(false)
  )
  
 
}

    // updateGibi(gibi) 
async function updateGibi(gibi){
  localStorage.setItem('gibi', JSON.stringify(gibi));
}
  return (   
   
    <table className="records" border="1" >
      <caption className="caption-title">Gibis Cadastrados</caption>
      <thead>
      <tr >
              <th className="conteudo">Id</th>                      
              <th className="conteudo">Título</th>
              <th className="conteudo">Data da Publicação</th>
              <th className="conteudo">Data de Encerramento</th>
              <th className="acoes">Ações</th>
            </tr>

      </thead>
     
      {gibis.map((gibi) => (
        
           
            <tr >
              <td className="conteudo" >{gibi.gibi_id}</td>
              <td className="conteudo">{gibi.tituloGibi}</td>
              <td className="conteudo">{moment(gibi.inicioData).format('DD/MM/YYYY')}</td>
              <td className="conteudo">{moment(gibi.encData).format('DD/MM/YYYY')}</td>
            
              <td>
                <a id="btnUpdateGibi" className="acoes button blue" type="button " onClick={() =>updateGibi(gibi)} href="/updategibi"> Editar</a>
                <button className="acoes" type="button" class="button red" onClick={() =>delGibi(gibi.gibi_id)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
}
    
  



