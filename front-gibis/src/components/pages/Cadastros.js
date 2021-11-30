import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function Cadastros(){
    return (
        <section className={styles.home_container}>
        <h1>
          Página de  <span>cadastros</span>
        </h1>
        <LinkButton to="/desenhista" text="Cadastrar novo desenhista" />
        <p>Cadastrar novo Gibi</p>
        <p>Cadastrar Escritor</p>
       
      </section>
    )
}
export default Cadastros