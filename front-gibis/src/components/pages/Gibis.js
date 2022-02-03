import GibisForm from '../project/GibisForm'
import styles from './Gibis.module.css'

function Gibis() {
    return (
        <div className={styles.gibis_container}>
            <h1>Cadastrar novo Gibi</h1>
            <p>Insira no formulário abaixo as informações solicitadas:</p>
            <GibisForm btnText="Cadastrar Gibi" />
        </div>
    )
}
export default Gibis