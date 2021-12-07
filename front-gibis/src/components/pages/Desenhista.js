<<<<<<< HEAD
<<<<<<< HEAD
import DesenhistaForm from '../project/DesenhistaForm'
import styles from './Desenhista.module.css'
import LinkButton from '../layout/LinkButton'

function Desenhista() {
  return (
    
    <div className={styles.gibis_container}>

      <h1>Cadastrar novo Desenhista</h1>
      <p>Insira no formulário abaixo as informações solicitadas:</p>
      <DesenhistaForm btnText="Cadastrar Desenhista" />
    </div>
  )
=======
import styles from './Home.module.css'
import LinkButton from '../layout/LinkButton'

function Desenhista(){
    return (
        <section className={styles.home_container}>
        <h1>
          Cadastrar novo  <span>Desenhista</span>
        </h1>
        <p>Cadastrar novo Desenhista</p>
        <LinkButton to="/desenhista" text="Salvar" />
       
      </section>
    )
>>>>>>> b85bdeb (Cadastro e Desenhista)
=======
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
>>>>>>> 5253f45 (Desenhista Forms)
}
export default Desenhista