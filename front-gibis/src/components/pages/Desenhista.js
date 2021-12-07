import DesenhistaForm from '../project/DesenhistaForm'
import styles from './Desenhista.module.css'

function Desenhista() {
  return (
    <div className={styles.gibis_container}>
      <h1>Cadastrar novo Desenhista</h1>
      <p>Insira no formulário abaixo as informações solicitadas:</p>
      <DesenhistaForm btnText="Cadastrar Desenhista" />
    </div>
  )
}
export default Desenhista