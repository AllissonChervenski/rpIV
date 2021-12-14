<<<<<<< HEAD
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
=======
function FinanceiroP(){
    return <h1>Financeiro</h1>
>>>>>>> 800e520 (Organização do site)
}
export default FinanceiroP