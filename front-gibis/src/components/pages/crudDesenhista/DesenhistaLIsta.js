import { React, useState, useEffect } from "react";
import api from "../../../services/api";
import '../../../css/button.css'
import '../../../css/style.css'
import '../../../css/main.css'
import moment from 'moment'

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


    const delDesenhista = async(desenhistaId) => {
        // deleteDesenhista(desenhistaId)
        await api.delete(`/desenhistas/delete/${desenhistaId}`).then(response => {
            console.log(response);
            getDesenhistas();
        })
            .catch(error => {
                console.log(error)

            });

    }
    return (

        <table className="records" border="1" >
            <caption className="caption-title">Desenhistas Cadastrados</caption>
            <thead>
            <div className="content-table">
                <tr>
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


                {desenhistas.map((desenhista) => (


                    <tr >
                        <td className="conteudo" >{desenhista.desenhistaId}</td>
                        <td className="conteudo">{desenhista.nomeDesenhista}</td>
                        <td className="conteudo">{desenhista.paisNascimento}</td>
                        <td className="conteudo">{moment(desenhista.dataNascimento).format('DD/MM/YYYY')}</td>
                        <td className="conteudo">{moment(desenhista.dataFalecimento).format('DD/MM/YYYY')}</td>
                        <td className="conteudo">{moment(desenhista.dataContratacao).format('DD/MM/YYYY')}</td>
                        <td className="conteudo">{desenhista.enderecoDesenhista}</td>
                        <td className="conteudo">{moment(desenhista.dataDemissao).format('DD/MM/YYYY')}</td>
                        <td>
                            <button  className="acoes" type="button" class="button green" id="edit-${desenhistaId}" >Editar</button>
                            <button className="acoes" type="button" class="button red" onClick={() => delDesenhista(desenhista.desenhistaId)}>Delete</button>
                        </td>
                    </tr>


                ))}
            </div>
            </thead>
        </table>

    )
}



