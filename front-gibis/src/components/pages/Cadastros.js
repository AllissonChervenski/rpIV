import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function Cadastros(){
    return (
        <section className={styles.home_container}>
        <h1>
<<<<<<< HEAD
          Opções de Cadastros
        </h1>


        <LinkButton to="/desenhista" text="Cadastrar novo desenhista" />
        <LinkButton to="/escritor" text="Cadastrar novo escritor" />
        <LinkButton to="/gibis" text="Cadastrar novo gibi" />
        <LinkButton to="/transportadoras" text="Cadastrar nova transportadora" />

=======
          Página de  <span>cadastros</span>
        </h1>
        <LinkButton to="/desenhista" text="Cadastrar novo desenhista" />
        <p>Cadastrar novo Gibi</p>
        <p>Cadastrar Escritor</p>
>>>>>>> b85bdeb (Cadastro e Desenhista)
       
      </section>
    )
}
export default Cadastros