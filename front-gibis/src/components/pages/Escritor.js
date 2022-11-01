
import EscritorForm from '../project/EscritorForm'
import styles from './Gibis.module.css'

function Escritor(){
    return(
        <div className={styles.escritor_container}>
            <h1>Cadastrar novo Escritor</h1>
            <p>Insira no formulário abaixo as informações solicitadas:</p>
            <EscritorForm btnText="Cadastrar Escritor"/>
        </div>
    )
}
export default Escritor