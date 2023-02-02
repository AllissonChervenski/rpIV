import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function PersonagensP(){
    return (


        <section className={styles.home_container}>
        <h1>
          Opções disponíveis
        </h1>


        <LinkButton to="/newpersonagem" text="Cadastrar novo personagem" />
        <LinkButton to="/personagem" text="Ver personagens cadastrados" />

       
      </section>
 
    )
}
export default PersonagensP