import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import axios from 'axios';
import '../../../css/records.css'
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'
import {deleteEscritor} from  './deletar'

/*
let data_americana = "2022-12-30"
let data_brasil =  data_americana.split("-").reverse().join('/');*/

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
 alert("Escritor deletado com sucesso!!"),
 window.location.reload(false)
  )
  
}
  return (   
   
    <table className="records" border="1" >
      <caption className="caption-title">Escritor Cadastrado</caption>
      <thead>
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

      </thead>
     
      {escritores.map((escritor) => (
        
           
            <tr >
              <td className="conteudo" >{escritor.escritorId}</td>
              <td className="conteudo">{escritor.nomeEscritor}</td>
              <td className="conteudo">{escritor.paisNascimentoEs}</td>
              <td className="conteudo">{escritor.dataNascimentoEs}</td>
              <td className="conteudo">{escritor.dataFalecimentoEs}</td>
              <td className="conteudo">{escritor.dataContratacao}</td>
              <td className="conteudo">{escritor.enderecoEscritor}</td>
              <td className="conteudo">{escritor.telefoneEscritor}</td>
              <td className="conteudo">{escritor.emailEscritor}</td>
              <td className="conteudo">{escritor.dataDemissao}</td>
              <td>
                <button  className="acoes" type="button" class="button green" id="edit-${escritorId}" >Editar</button>
                <button className="acoes" type="button" class="button red" onClick={() =>delEscritor(escritor.escritorId)}>Delete</button>
            </td>
            </tr>
            
        
        ))}
        </table>
       
    )
    }
    
  



