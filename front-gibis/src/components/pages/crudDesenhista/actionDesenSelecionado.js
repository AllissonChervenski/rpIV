import Desenhista from "./DesenhistaLIsta";

export const actionDesenSelecionado = (desenhista)=>{
    return{
        type:"actionDesenSelecionado",
        payload: desenhista,
    }
}