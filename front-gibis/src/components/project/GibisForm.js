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

            <div>
            <input type="submit" value="Cadastrar Gibi" />
            </div>
            <Select name="descontinuado_op" text="O Gibi foi descontinuado?" />
            
            <SubmitButtom text={btnText} />
        </form>
    )
}

export default GibisForm