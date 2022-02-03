<<<<<<< HEAD
import GibisForm from '../project/GibisForm'
import styles from './Gibis.module.css'

function Gibis() {
    return (
        <div className={styles.gibis_container}>
            <h1>Cadastrar novo Gibi</h1>
            <p>Insira no formulário abaixo as informações solicitadas:</p>
            <GibisForm btnText="Cadastrar Gibi" />
=======
function Gibis(){
    return(
        <div>
            <h1>Cadastrar novo Gibi</h1>
            <p>Insira no formulário abaixo as informações solicitadas:</p>
>>>>>>> be1709f (Cadastros de gibis (construção))
        </div>
    )
}
export default Gibis