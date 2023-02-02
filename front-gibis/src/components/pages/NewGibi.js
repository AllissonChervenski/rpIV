import { useEffect, useState } from 'react';
import api from "../../services/api";
import styles from './NewDesenhista.module.css'
import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'
import {saveAs} from 'file-saver'
import {baseURL} from "../../services/api"

function NewGibi() {
    const [tituloGibi, setTituloGibi] = useState('');
    const [inicioData, setDataInicio] = useState('');
    const [encData, setDataEncerramento] = useState('');
    const [edicaoGibi, setEdicaoGibi] = useState([]);


    const [nroEdicao, setNroEdicao] = useState('');
    const [dataPub, setDataPub] = useState('');
    const [publicada, setPublicada] = useState('');
    const [numeroExemplaresImpressas, setNumeroExemplaresImpressas] = useState('');
    const [gibi, setGibi] = useState('');
    const [historia, setHistoria] = useState('');
    const [editora, setEditora] = useState('');
    const [personagem, setPersonagem] = useState('');
    const [desenhista, setDesenhista] = useState('');
    const [escritor, setEscritor] = useState('');


    let newLog = '';
    function writeLog(log) {
        var blob = new Blob([log], { type: "text/plain"});
        saveAs(blob, 'log.txt');
    }

    const postGibi =  async (event) =>  {
        event.preventDefault();

        await api.post("/gibis/create",{
            tituloGibi,
            inicioData,
            encData,
        })

        alert("Cadastrado com sucesso!!");
    };







    const postEdicao = async (event) => {
        event.preventDefault();



        await api.post("/gibis/edicoesgibi/create", {
            nroEdicao,
            dataPub,
            publicada,
            numeroExemplaresImpressas,
        }, );
    }

    const handleSubmit = (event) => {
        postEdicao(event);
        postGibi(event);
    }

    useEffect( ()=>{
        //writeLog("EdicaoGIBI" + edicaoGibi)
    })

    /* const getEdicoes = async () => {
       await api.get("gibis/edicoesgibi/all").then(response =>
         setEdicaoGibi(response.data));
       };
     */

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
      <Input type="num" text="Edicoes do Gibi" name="edicaoGibi" placeholder="Edicao do Gibi"  value={edicaoGibi} handleOnChange={(event) => setEdicaoGibi(event.target.value)}/>
    <select value={selectedOption} onChange={e => setSelectedOption(e.target.value)}>
                  {edicaoGibi.map(item => (
                  <option key={item.edicaoGibi_id} value={item.edicaoGibi_id}>{item.nroEdicao}</option>
                  ))}
                </select>
    }*/

    return(
        <section className={styles.container_form}>
            <h1>
                Gibi
            </h1>
            <form className={styles.container} onSubmit={(event) => handleSubmit(event)}>
                <Input type="text" text="Titulo do Gibi"  placeholder="Insira o titulo do Gibi"  required value={tituloGibi} handleOnChange={(event ) => setTituloGibi(event.target.value)} />

                <Input type="date" text="Data de inicio" name="dataDeInicio" placeholder="Data de Inicio"  value={inicioData} handleOnChange={(event) => setDataInicio(event.target.value)} />

                <Input type="date" text="Data de Encerramento" name="dataEncerramento" placeholder="Data de Encerramento" required value={encData} handleOnChange={(event) => setDataEncerramento(event.target.value)}/>

                <Input type="number" text="Numero de Edição" name="nroEdicao" placeholder="Numero da Edição" value={nroEdicao} handleOnChange={(event) => setNroEdicao(event.target.value)}/>

                <Input type="date" text="Data da Publicação" name="dataPub" placeholder="Data da Publicação" value={dataPub} handleOnChange={(event) => setDataPub(event.target.value)}/>

                <Input type="radio" text="Publicado" name="publicada" placeholder="Foi publicada" value={publicada} handleOnChange={(event) => setPublicada(event.target.value)}/>

                <Input type="number" text="Numero de exemplars publicados" name="numeroExemplaresPublicada" placeholder="Numero de exemplares publicados" value={numeroExemplaresImpressas} handleOnChange={(event) => setNumeroExemplaresImpressas(event.target.value)}/>


                <SubmitButtom text= "Cadastrar Gibi"/>
            </form>
        </section>
    )
}
export default NewGibi;