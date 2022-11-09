import DesenhistaForm from '../project/DesenhistaForm'
import styles from './Desenhista.module.css'

function NewDesenhista() {
  return (
    <div className={styles.gibis_container}>
      <h1>Cadastrar novo Desenhista</h1>
      <p>Insira no formulário abaixo as informações solicitadas:</p>
      <DesenhistaForm btnText="Cadastrar Desenhista" />
    </div>
  )
}
export default NewDesenhista;


const novoDesenhista = async () => {
  const nomeElement = document.getElementById('nomeDesenhista')
  const paisNascimentoElement = document.getElementById('paisNascimentoDe')
  const dataNascimentoElement = document.getElementById(' dataNascimentoDe')
  const dataFalecimentoElement = document.getElementById('dataFalecimentoDe')
  const enderecoElement = document.getElementById('enderecoDesenhista')
  const dataContratacaoElement = document.getElementById('contratacaoDesenhista')
  const dataDemissaoElement = document.getElementById('demissaoDesenhista')

  const desenhista = {
    nomeDesenhista: nomeElement.value,
    paisNascimento: paisNascimentoElement.value,
    dataNascimento: dataNascimentoElement.value,
    dataFalecimento: dataFalecimentoElement.value,
    enderecoDesenhista: enderecoElement.value,
    dataContratacao: dataContratacaoElement.value,
    dataDemissao: dataDemissaoElement.value,
  }

  const adicionar = async () => {
    try{
      const headers ={
          'Content-Type' : 'appplication/json',
      };
      const init = {
        method: 'POST',
        headers: headers,
        body: JSON.stringify({
          nomeDesenhista: nomeElement.value,
          paisNascimento: paisNascimentoElement.value,
        })
      };
      const response = await fetch('http://localhost:8080/desenhistas/create', init);
      const jsonData = await response.json();
      console.log(jsonData);
    } catch (e){
      console.log('Deu erro', e);
    }
  }

  }


  
window.onload = function() {
    const addDesenhista = document.getElementById('addDesenhista')
    addDesenhista.onclick = novoDesenhista
    console.log('ok')
  
};
