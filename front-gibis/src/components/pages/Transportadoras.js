import LinkButton from '../layout/LinkButton'
import styles from './Home.module.css'
import TransportadoraForm from '../project/TransportadoraForm'

function Transportadoras() {
    return (
        <section className={styles.home_container}>
            <h1>
<<<<<<< HEAD
                Transportadoras
            </h1>

            <TransportadoraForm btnText="Cadastrar Transportadora" />
            
=======
                <span>Transportadoras</span>
            </h1>


            <LinkButton to="/transportadoraForm" text="Cadastrar Transportadora" />
            <p>Consultar</p>
            <p>Alterar</p>
            <p>Excluir</p>
>>>>>>> e31c498 (Updates)


        </section>
    )
}
export default Transportadoras

