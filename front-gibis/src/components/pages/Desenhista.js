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
}
export default Desenhista