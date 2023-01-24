import styles from './Home.module.css'
import gibis from '../../img/gibis.png'

function Home() {
  return (
    <section className={styles.home_container}>
      <h1>
        Bem-vindo a <span>Hero Gibis!</span>
      </h1>

      <img src={gibis} alt="Savings" />
    </section>
  )
}

export default Home