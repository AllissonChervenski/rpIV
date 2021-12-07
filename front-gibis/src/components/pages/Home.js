import styles from './Home.module.css'
import savings from '../../img/savings.png'

import LinkButton from '../layout/LinkButton'

function Home() {
  return (
    <section className={styles.home_container}>
      <h1>
        Bem-vindo a <span>Hero Gibis!</span>
      </h1>
      <p>Site em construção</p>

      <div class="btn-toolbar">
<<<<<<< HEAD
      <LinkButton to="/cadastros" text="Teste Botão Cadastros" />
      <LinkButton to="/gibis" text="Teste Botão Gibis" />
      </div> 
=======
<<<<<<< HEAD
        <LinkButton to="/cadastros" text="Cadastros Gerais" />
        <LinkButton to="/login" text="Página Login" />
        <LinkButton to="/editorHomePage" text="Editor Home Page" />
        

      </div>
=======
      <LinkButton to="/cadastros" text="Teste Botão Cadastros" />
      <LinkButton to="/gibis" text="Teste Botão Gibis" />
      <LinkButton to="/transportadoras" text="Transportadoras" />
      <LinkButton to="/singin" text="Login" />
      </div> 
>>>>>>> e31c498 (Updates)
>>>>>>> df79e55 (Updates)

      <img src={savings} alt="Savings" />
    </section>
  )
}

export default Home