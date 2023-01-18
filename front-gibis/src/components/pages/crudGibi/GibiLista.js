import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import moment from 'moment';
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'
import {deleteGibi} from  './deletar'
<script>

</script>
export default function Gibi() {
  const [gibis, setGibis] = useState([]);

  useEffect(() => {
    getGibis();
  }, []);

  const getGibis = async () => {
    await api.get("/gibis/all").then((response) => {
      setGibis(response.data);
      console.log(response.data)
    });
  };


const delGibi = (gibiId)=>{
  // deleteDesenhista(desenhistaId)
  
 axios.delete(`http://localhost:8080/gibis/delete/${gibiId}`, 
  )
  
}
  return (   
   
    <table className="records" border="1" >
      <caption className="caption-title">Gibis Cadastrados</caption>
      <thead>
      <div className="content-table">
      <tr >
              <th className="conteudo">Id</th>                      
              <th className="conteudo">Título</th>
              <th className="conteudo">Data da Publicação</th>
              <th className="conteudo">Data de Encerramento</th>
              <th className="acoes">Ações</th>
            </tr>
    </div>
      </thead>
     
      {gibis.map((gibi) => (
        
           
            <tr >
              <td className="conteudo" >{gibi.gibiId}</td>
              <td className="conteudo">{gibi.tituloGibi}</td>
              <td className="conteudo">{moment(gibi.inicioData).format('DD/MM/YYYY')}</td>
              <td className="conteudo">{moment(gibi.encData).format('DD/MM/YYYY')}</td>
            
              <td>
                <button  className="acoes" type="button" class="button green" id="edit-${gibiId}" >Editar</button>
                <button className="acoes" type="button" class="button red" onClick={() =>delGibi(gibi.gibiId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
    }
    
  



