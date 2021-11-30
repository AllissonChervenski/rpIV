<<<<<<< HEAD
import Input from '../form/Input'
import Select from '../form/Select'
import SubmitButtom from '../form/SubmitButton'

import styles from './GibisForm.module.css'


function GibisForm({btnText}){
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome do Gibi" name="nomeGibi" placeholder="Insira o nome completo do Gibi" />

            <Input type="date" text="Início das publicações" name="inicioP" placeholder="Insira a data de início das publicações" />
            
            <Input type="date" text="Fim das publicações" name="fimP" placeholder="Não preencher caso as publicações estejam ativas" />

            <Select name="descontinuado_op" text="O Gibi foi descontinuado?" />
            
            <SubmitButtom text={btnText} />
=======
function GibisForm(){
    return (
        <form>
            <div>
            <input type="text" placeholder="Título do Gibi" />
            </div>

            <div>
            <input type="number" placeholder="Ano de início da publicação" />
            </div>

            <div>
            <input type="number" placeholder="Ano de fim da publicação. Caso ainda esteja sendo publicado, deixar campo em branco" />
            </div>
            
            <div> 
            <select name="descontinuado_id">
                <option disabled>O Gibi foi descontinuado?</option>
            </select>
            </div>

            <div>
            <input type="submit" placeholder="Cadastrar Gibi" />
            </div>
>>>>>>> c1653e8 (Campos de cadastro de gibis)
        </form>
    )
}

export default GibisForm