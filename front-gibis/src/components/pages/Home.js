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
        <LinkButton to="/cadastros" text="Cadastros Gerais" />
        <LinkButton to="/login" text="Página Login" />
        <LinkButton to="/editorHomePage" text="Editor Home Page" />
        

      </div>

      <img src={savings} alt="Savings" />
    </section>
  )
}

export default Home