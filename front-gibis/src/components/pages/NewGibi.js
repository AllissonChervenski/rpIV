import GibisForm from '../project/GibisForm'
import { React, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.css'


function NewGibi(){
      const [tituloGibi, setTituloGibi] = useState('');
      const [inicioP, setInicioP] = useState('');    
      const [fimP, setFimP] = useState('');
      const [ descontinuado_op, setDescontinuado_op] = useState('');
    
    
    
      async function postGibi(event) {
        event.preventDefault();
    
        const response = await api.post("/gibi/create", {
          tituloGibi,
          inicioP,
          fimP,
          descontinuado_op,

    
        })
        alert("Gibi cadastrado!");
    
      }
    
    
      return (
        <div class="container_form">
          <h1>Formulário de Cadastro de Gibi</h1>
          <form class="form" action="#" method="post">
            <div class="form_grupo">
              <label for="tituloGibi" class="form_label"><b>Titulo do Gibi:</b></label>
              <input type="text" name="tituloGibi" class="form_input" id="tituloGibi" placeholder="Titulo Gibi" required value={tituloGibi} onChange={(event) => setTituloGibi(event.target.value)} />
            </div>          
            <div class="form_grupo">
              <label for="inicioP" class="form_label"><b>Data de início da publicação</b></label>
              <input type="date" name="inicioP" class="form_input" id="inicioP" placeholder="Data de publicação" required value={inicioP} onChange={(event) => setInicioP(event.target.value)} />
            </div>
            <div class="form_grupo">
              <label for="fimP" class="form_label"><b>Data do Fim da publicação:</b></label>
              <input type="date" name="fimP" class="form_input" id="fimP" placeholder="Não preencher caso as publicações estejam ativas" value={fimP} onChange={(event) => setFimP(event.target.value)} />
            </div>
            <select name="descontinuado_op"   >
                <option value="" selected>O Gibi foi descontinuado?</option>
                <option value='sim'>Sim</option>
                <option value='não'>Não</option>
                </select>      
    
            <div class="submit">
              <input type="hidden" name="acao" value="enviar" />
              <button onClick={postGibi} type="submit" name="Submit" class="submit_btn" >Cadastrar</button>
    
            </div>
          </form>
        </div>
    
    
    )
}

export default NewGibi;