import { useState, useEffect } from "react";
import api from "../../../services/api";
import moment from 'moment';
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'

<script>

</script>
export default function Personagem() {
  const [personagens, setPersonagens] = useState([]);

  useEffect(() => {
    getPersonagens();
  }, []);

  const getPersonagens = async () => {
    await api.get("/personagens/all").then((response) => {
      setPersonagens(response.data);
      console.log(response.data)
    });
  };


const delPersonagem = (personagemId)=>{
  // deleteDesenhista(desenhistaId)
  
 axios.delete(`http://localhost:8080/personagens/delete/${personagemId}`, 
 alert("Personagem deletado com sucesso!!"),
  window.location.reload(false)
  )
  
  
}
  return (   
   
    <table className="records" border="1" >
      <caption className="caption-title">Personagens Cadastrados</caption>
      <thead>
      <div className="content-table">
      <tr >
              <th className="conteudo">Id</th>                      
              <th className="conteudo">Nome</th>
              <th className="conteudo">Data Criação</th>
              <th className="conteudo">Histórico</th>
              <th className="conteudo">Patente</th>
              <th className="acoes">Ações</th>
            </tr>
   
     
      {personagens.map((personagem) => (
        
           
            <tr >
              <td className="conteudo" >{personagem.personagemId}</td>
              <td className="conteudo">{personagem.nomePersonagem}</td>
              <td className="conteudo">{moment(personagem.dataCriacao).format('DD/MM/YYYY')}</td>
              <td className="conteudo">{personagem.historicoPersonagem}</td>
              <td className="conteudo">{personagem.patentePersonagem}</td>
            
              <td>
                <button  className="acoes" type="button" class="button green" id="edit-${personagemId}" >Editar</button>
                <button className="acoes" type="button" class="button red" onClick={() =>delPersonagem(personagem.personagemId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
         </div>
      </thead>
        </table>
       
    )
}
    
  



