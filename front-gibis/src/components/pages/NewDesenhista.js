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

const criarDesenhistaElement = (item) => {
  const template = document.getElementById('desenhista-template')
  const desenhistaElement = document.importNode(template.content, true)
  const itens_desenhista =  desenhistaElement.querySelectorAll('span')

  itens_desenhista[0].innerText = item.nomeDesenhista
  itens_desenhista[1].innerText = item.paisNascimento
  itens_desenhista[2].innerText = item.dataNascimento
  itens_desenhista[3].innerText = item.dataFalecimento
  itens_desenhista[4].innerText = item.enderero
  itens_desenhista[5].innerText = item.dataContratacao
  itens_desenhista[5].innerText = item.dataDemissao

  return desenhistaElement

}


const novoDesenhista = async () => {
  const nomeElement = document.getElementById('nome')
  const paisNascimentoElement = document.getElementById('paisNascimento')
  const dataNascimentoElement = document.getElementById(' dataNascimento')
  const dataFalecimentoElement = document.getElementById('dataFalecimento')
  const enderecoElement = document.getElementById('enderero')
  const dataContratacaoElement = document.getElementById('dataContratacao')
  const dataDemissaoElement = document.getElementById('dataDemissao')

  const desenhista = {
    nome_desenhista: nomeElement.value,
    pais_Nascimento: paisNascimentoElement.value,
    data_nascimento_desenhista: dataNascimentoElement.value,
    data_falecimento_desenhista: dataFalecimentoElement.value,
    endereco_desenhista: enderecoElement.value,
    data_contratacao: dataContratacaoElement.value,
    data_demissao: dataDemissaoElement.value,
  }

  const response = await fetch('http://localhost:8080/desenhistas/create', {
    method: 'POST',
    haeders: {
      "Content-Type": 'application/json'
    },
    body: JSON.stringify(desenhista)
  })
  const dados = await response.json()

  const containerDesenhistasElement = document.getElementById('container-desenhistas')

  const desenhistaElement = criarDesenhistaElement(dados)

  containerDesenhistasElement.append(desenhistaElement)
    
  }

window.onload = function() {
    const addDesenhista = document.getElementById('addDesenhista')
    addDesenhista.onclick = novoDesenhista
        console.log('ok')
};

