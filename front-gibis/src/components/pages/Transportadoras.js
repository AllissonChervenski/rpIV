import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'
import TransportadoraForm from '../project/TransportadoraForm'

function Transportadoras() {
    return (
        <section className={styles.home_container}>
            <h1>
                <span>Transportadoras</span>
            </h1>


            <LinkButton to="/transportadoraForm" text="Cadastrar Transportadora" />
            <p>Consultar</p>
            <p>Alterar</p>
            <p>Excluir</p>


        </section>
    )
}
export default Transportadoras

