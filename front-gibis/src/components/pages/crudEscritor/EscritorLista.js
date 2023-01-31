import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import moment from 'moment';
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'
import {deleteEscritor} from  './deletar'
<script>

</script>
export default function Escritor() {
  const [escritores, setEscritores] = useState([]);

  useEffect(() => {
    getEscritores();
  }, []);

  const getEscritores = async () => {
    await api.get("/escritores/all").then((response) => {
      setEscritores(response.data);
      console.log(response.data)
    });
  };


const delEscritor = (escritorId)=>{
  // deleteDesenhista(desenhistaId)
  
 axios.delete(`http://localhost:8080/escritores/delete/${escritorId}`, 
  )
  
}
  return (   
   
    <table className="records" border="1" >
      <caption className="caption-title">Escritor Cadastrado</caption>
      <thead>
      <div className="content-table">
      <tr >
              <th className="conteudo">id</th>                      
              <th className="conteudo">Nome</th>
              <th className="conteudo">Pais</th>
              <th className="conteudo">Data de Nascimento</th>
              <th className="conteudo">Data Falecimento</th>
              <th className="conteudo">Data Contratação</th>
              <th className="conteudo">Endereço</th>
              <th className="conteudo">Telefone</th>
              <th className="conteudo">Email</th>
              <th className="conteudo">Data Demissão</th>
              <th className="acoes">Ações</th>
            </tr>
     
     
      {escritores.map((escritor) => (
        
           
            <tr >
              <td className="conteudo" >{escritor.escritorId}</td>
              <td className="conteudo">{escritor.nomeEscritor}</td>
              <td className="conteudo">{escritor.paisNascimentoEs}</td>
              <td className="conteudo">{moment(escritor.dataNascimentoEs).format('DD/MM/YYYY')}</td>
              <td className="conteudo">{moment(escritor.dataFalecimentoEs).format('DD/MM/YYYY')}</td>
              <td className="conteudo">{moment(escritor.dataContratacao).format('DD/MM/YYYY')}</td>
              <td className="conteudo">{escritor.enderecoEscritor}</td>
              <td className="conteudo">{escritor.telefoneEscritor}</td>
              <td className="conteudo">{escritor.emailEscritor}</td>
              <td className="conteudo">{moment(escritor.dataDemissao).format('DD/MM/YYYY')}</td>
              <td>
                <button  className="acoes" type="button" class="button green" id="edit-${escritorId}" >Editar</button>
                <button className="acoes" type="button" class="button red" onClick={() =>delEscritor(escritor.escritorId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
         </div>
      </thead>
        </table>
       
    )
    }
    
  



