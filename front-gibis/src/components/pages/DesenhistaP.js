import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function DesenhistaP(){
    return (


        <section className={styles.home_container}>
        <h1>
          Opções disponíveis
        </h1>


        <LinkButton to="/newdesenhista" text="Cadastrar novo desenhista" />
        <LinkButton to="/desenhista" text="Ver desenhistas cadastrados" />

       
      </section>
 
    )
}
export default DesenhistaP