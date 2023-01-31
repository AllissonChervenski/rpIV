import styles from './Home.module.css'
import LinkButton from '../layout/LinkButton'

function EscritorP(){
    return (
        <section className={styles.home_container}>
        <h1>
          Opções disponíveis
        </h1>


        <LinkButton to="/newescritor" text="Cadastrar novo escritor" />
        <LinkButton to="/escritor" text="Ver escritores cadastrados" />

       
      </section>
    )
}
export default EscritorP