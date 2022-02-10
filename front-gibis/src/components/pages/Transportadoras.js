import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'
import TransportadoraForm from '../project/TransportadoraForm'

function Transportadoras() {
    return (
        <section className={styles.home_container}>
            <h1>
                Transportadoras
            </h1>

            <TransportadoraForm btnText="Cadastrar Transportadora" />



        </section>
    )
}
export default Transportadoras

