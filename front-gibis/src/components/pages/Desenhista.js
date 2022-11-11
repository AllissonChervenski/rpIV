import { React, useState, useEffect } from "react";
import api from "../../services/api";

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
          <h1>{desenhista.dataNascimento}</h1>
        </li>
      ))}
    </ul>
  );
}
