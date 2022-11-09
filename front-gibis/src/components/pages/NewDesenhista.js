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


window.onload = function() {
  const form = document.querySelector('#formulario');
  form.addEventListener('submit', async function novoDesenhista(){
    const nomeElement = document.getElementById('nomeDesenhista')
    const paisNascimentoElement = document.getElementById('paisNascimentoDe')
    const dataNascimentoElement = document.getElementById(' dataNascimentoDe')
    const dataFalecimentoElement = document.getElementById('dataFalecimentoDe')
    const enderecoElement = document.getElementById('enderecoDesenhista')
    const dataContratacaoElement = document.getElementById('contratacaoDesenhista')
    const dataDemissaoElement = document.getElementById('demissaoDesenhista')
    
    try{
      const rawResponse = await fetch('http://localhost:8080/desenhistas/create', {
        method: 'POST',
        headers:
          { 'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
        body: JSON.stringify ({
                nomeDesenhista: nomeElement.value,
                paisNascimento: paisNascimentoElement.value,
                dataNascimento: dataNascimentoElement.value,
                dataFalecimento: dataFalecimentoElement.value,
                enderecoDesenhista: enderecoElement.value,
                dataContratacao: dataContratacaoElement.value,
                dataDemissao: dataDemissaoElement.value,
      
              }),
      })
      
      alert(rawResponse.json())
    
      }catch(err){
        alert('erro', err)
      }

  })
    
};
