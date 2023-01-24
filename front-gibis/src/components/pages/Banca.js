import BancaForm from '../project/BancaForm'
import styles from './Desenhista.module.css'

function Desenhista() {
  return (
    
    <div className={styles.gibis_container}>

      <h1>Cadastrar nova Banca</h1>
      <p>Insira no formulário abaixo as informações solicitadas:</p>
      <BancaForm btnText="Cadastrar Banca" />
    </div>
  )
}
export default Desenhista