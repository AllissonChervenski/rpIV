import { React, useState, useEffect } from "react";
import api from "../../../src/services/api.js";
import axios from 'axios';
import '../../../src/css/records.css'
import '../../../src/css/button.css'
import '../../../src/css/style.css'
import '../../../src/css/main.css'

<script>

</script>
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
  axios.delete(`http://localhost:8080/desenhistas/${desenlhistaId}`)
  
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
        
           
            <tr >
              <td className="conteudo" >{desenhista.desenhistaId}</td>
              <td className="conteudo">{desenhista.nomeDesenhista}</td>
              <td className="conteudo">{desenhista.paisNascimento}</td>
              <td className="conteudo">{desenhista.dataNascimento}</td>
              <td className="conteudo">{desenhista.dataContratacao}</td>
              <td className="conteudo">{desenhista.dataFalecimento}</td>
              <td className="conteudo">{desenhista.enderecoDesenhista}</td>
              <td className="conteudo" >{desenhista.dataDemissao}</td>
              <td>
                <button  className="acoes" type="button" class="button green" id="edit-${desenhistaId}" >Editar</button>
                <button className="acoes" type="button" class="button red" onClick={() =>delDesenhista(desenhista.desenhistaId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
    }
  