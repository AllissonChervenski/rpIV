import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'

function FinanceiroP(){
    return (
        <section className={styles.home_container}>
        <h1>
          Opções disponíveis
        </h1>


        <LinkButton to="/banca" text="Cadastrar nova banca" />
        <LinkButton to="/banca" text="Negociações" />

       
      </section>
    )
}
export default FinanceiroP