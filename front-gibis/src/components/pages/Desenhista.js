import { React, useState, useEffect } from "react";
import api from "../../services/api";
import moment from 'moment';

export default function Desenhista() {
  const [desenhistas, setDesenhistas] = useState([]);

  useEffect(() => {
    getDesenhistas();
  }, []);

  const getDesenhistas = async () => {
    await api.get("/desenhistas/all").then((response) => {
      setDesenhistas(response.data);
    });
  };

  return (
    <ul>
      {desenhistas.map((desenhista, index) => (
        <li key={index}>
          <h1>{desenhista.nomeDesenhista}</h1>
          <h1>{desenhista.paisNascimento}</h1>
          <h1>{moment(desenhista.dataNascimento).format('DD/MM/YYYY')}</h1>
          <h1>{moment(desenhista.dataFalecimento).format('DD/MM/YYYY')}</h1>
          <h1>{desenhista.enderecoDesenhista}</h1>
          <h1>{moment(desenhista.dataContratacao).format('DD/MM/YYYY')}</h1>
          <h1>{moment(desenhista.dataDemissao).format('DD/MM/YYYY')}</h1>
          
          
        </li>
      ))}
    </ul>
  );

}
