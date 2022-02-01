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
<<<<<<< HEAD
<<<<<<< HEAD
      <LinkButton to="/cadastros" text="Teste Botão Cadastros" />
      <LinkButton to="/gibis" text="Teste Botão Gibis" />
      </div> 
=======
=======
>>>>>>> db51e1b (Organização do site)
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 4d91f1b (Início da página do Editor)
>>>>>>> a8f998c (Início da página do Editor)
        <LinkButton to="/cadastros" text="Cadastros Gerais" />
        <LinkButton to="/login" text="Página Login" />
        <LinkButton to="/editorHomePage" text="Editor Home Page" />
        
<<<<<<< HEAD

      </div>
=======
      <LinkButton to="/cadastros" text="Teste Botão Cadastros" />
      <LinkButton to="/gibis" text="Teste Botão Gibis" />
      <LinkButton to="/login" text="Teste Página Login" />
=======
      <LinkButton to="/cadastros" text="Cadastros Gerais" />
      <LinkButton to="/login" text="Página Login" />
>>>>>>> 800e520 (Organização do site)

      </div> 
>>>>>>> e31c498 (Updates)
<<<<<<< HEAD
>>>>>>> df79e55 (Updates)
=======
=======

      </div>
>>>>>>> 4d91f1b (Início da página do Editor)
>>>>>>> a8f998c (Início da página do Editor)

      <img src={savings} alt="Savings" />
    </section>
  )
}

export default Home