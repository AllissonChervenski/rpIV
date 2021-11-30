import styles from './Home.module.css'
import savings from '../../img/savings.png'

import LinkButton from '../layout/LinkButton'

function Home() {
  return (
    <section className={styles.home_container}>
      <h1>
        Bem-vindo à <span>Hero Gibis!</span>
      </h1>
      <p>Site em construção</p>
      <LinkButton to="/cadastros" text="Teste Botão Cadastros" />
      <img src={savings} alt="Savings" />
    </section>
  )
}

export default Home