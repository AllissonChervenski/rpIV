import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function Cadastros(){
    return (
        <section className={styles.home_container}>
        <h1>
          Opções de Cadastros
        </h1>


        <LinkButton to="/desenhista" text="Cadastrar novo desenhista" />
        <LinkButton to="/escritor" text="Cadastrar novo escritor" />
        <LinkButton to="/gibis" text="Cadastrar novo gibi" />
        <LinkButton to="/transportadoras" text="Cadastrar nova transportadora" />

       
      </section>
    )
}
export default Cadastros