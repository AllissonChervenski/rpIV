import { useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.module.css'
import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'


function NewGibi() {
    const [tituloGibi, setTituloGibi] = useState('');
    const [inicioData, setDataInicio] = useState('');
    const [encData, setDataEncerramento] = useState('');



    async function postGibi(event) {
        event.preventDefault();

        const response = await api.post("/gibis/create", {
            tituloGibi,
            inicioData,
            encData,

        })
        alert("Cadastrado com sucesso!!");

    }

    /*
      return (
          <div class="container_form">
            <h1>Formulário de Cadastro</h1>
            <form class="form" action="#" method="post">
              <div class="form_grupo">
                <label for="tituloGibi" class="form_label"><b>Título Gibi:</b></label>
                <input type="text" name="tituloGibi" class="form_input" id="tituloGibi" placeholder="Título Gibi" required value={tituloGibi} onChange={(event) => setTituloGibi(event.target.value)} />
              </div>
              <div class="form_grupo">
                <label for="inicioData" class="form_label"><b>Data de Publicação:</b></label>
                <input type="date" name="inicioData" class="form_input" id="inicioData" placeholder="Data de Publicação" required value={inicioData} onChange={(event) => setDataInicio(event.target.value)} />
              </div>
              <div class="form_grupo">
                <label for="encData" class="form_label"><b>Data de encerramento da Publicação:</b></label>
                <input type="date" name="encData" class="form_input" id="encData" placeholder="Data de encerramento da publicação" value={encData} onChange={(event) => setDataEncerramento(event.target.value)} />
              </div>
              <div class="submit">
                <input type="hidden" name="acao" value="enviar" />
                <button onClick={postGibi} type="submit" name="Submit" class="submit_btn" >Cadastrar</button>
            </div>
          </form>
        </div>
      )
    }*/

    return(
        <section className={styles.container_form}>
            <h1>
                Gibi
            </h1>
            <form className={styles.container} onSubmit={postGibi}>
                <Input type="text" text="Titulo do Gibi"  placeholder="Insira o titulo do Gibi"  required value={tituloGibi} handleOnChange={(event) => setTituloGibi(event.target.value)} />

                <Input type="date" text="Data de inicio" name="dataDeInicio" placeholder="Data de Inicio"  value={inicioData} handleOnChange={(event) => setDataInicio(event.target.value)} />

                <Input type="date" text="Data de Encerramento" name="dataEncerramento" placeholder="Data de Encerramento" required value={encData} handleOnChange={(event) => setDataEncerramento(event.target.value)}/>

                <Input type="date" text="Data de Encerramento" name="dataEncerramento" placeholder="Data de Encerramento" required value={encData} handleOnChange={(event) => setDataEncerramento(event.target.value)}/>
                <SubmitButtom text= "Cadastrar Gibi"/>
            </form>
        </section>
    )
}

export default NewGibi;