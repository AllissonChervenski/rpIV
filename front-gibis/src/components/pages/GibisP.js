import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function GibisP(){
    return (
        <section className={styles.home_container}>
        <h1>
          Opções disponíveis
        </h1>


        <LinkButton to="/newgibi" text="Cadastrar novo gibi" />
        <LinkButton to="/gibis" text="Ver gibis cadastrados" />

       
      </section>
    )
}
export default GibisP