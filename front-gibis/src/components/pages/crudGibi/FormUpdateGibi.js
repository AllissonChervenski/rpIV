import React, {useEffect,  useState } from 'react';
import { useHistory } from 'react-router-dom';
import api from '../../../../src/services/api';

export default function UpdateGibi() {
    
    const objectData = JSON.parse(localStorage.getItem('gibi'))
    const [tituloGibi, setTituloGibi] = useState(objectData.tituloGibi);
    const [inicioData, setDataInicio] = useState(objectData.inicioData);
    const [encData, setDataEncerramento] = useState(objectData.encData);   
    const history = useHistory();
  
async function putGibi(event){

    const objectData = JSON.parse(localStorage.getItem('gibi'));

alert(tituloGibi);
  event.preventDefault();
 try{
  const response = await api.put(`/gibis/update/${objectData.gibi_id}`, 
   {

    tituloGibi : tituloGibi,
    inicioData : inicioData,
    encData : encData,

   
  })
  alert("Cadastro Editado com sucesso!!");
  //alert(response.data);
   history.push("/gibi")

}catch(err){
    alert(err);
  }

  window.location.reload(false)

}

useEffect(() => {
    const objectData = JSON.parse(localStorage.getItem('gibi'));

    alert(objectData.gibi_id)

  }, []);

   
  return (
    <div class="container_form">
    <h1>Formulário de Editar</h1>
    <form class="form" action="#" method="post">
      <div class="form_grupo">
        <label for="tituloGibi" class="form_label"><b>Título Gibi:</b></label>
        <input type="text" name="tituloGibi" class="form_input" id="tituloGibi" placeholder={objectData.tituloGibi} required value={tituloGibi} onChange={(event) => setTituloGibi(event.target.value)} />
      </div>
      <div class="form_grupo">
        <label for="inicioData" class="form_label"><b>Data de Publicação:</b></label>
        <input type="date" name="inicioData" class="form_input" id="inicioData" placeholder={objectData.inicioData} required value={inicioData} onChange={(event) => setDataInicio(event.target.value)} />
      </div>
      <div class="form_grupo">
        <label for="encData" class="form_label"><b>Data de encerramento da Publicação:</b></label>
        <input type="date" name="encData" class="form_input" id="encData" placeholder={objectData.encData} value={encData} onChange={(event) => setDataEncerramento(event.target.value)} />
      </div>

        <div class="submit">
          <input type="hidden" name="acao" value="enviar" />
          <button onClick={putGibi} type="submit" name="Submit" className="submit_btn green" >Atualizar</button>

        </div>
      </form>
    </div>
  )
}
