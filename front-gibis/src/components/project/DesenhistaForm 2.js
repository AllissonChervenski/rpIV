import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'

import styles from './DesenhistaForm.module.css'


function DesenhistaForm({ btnText }) {
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome do Desenhista" name="nomeDesenhista" placeholder="Insira o nome completo do Desenhista" />

            <Input type="text" text="Endereço" name="enderecoDesenhista" placeholder="Insira o endereço do desenhista" />

            <Input type="date" text="Data contratação" name="contratacaoDesenhista" placeholder="Insira a data de contratação" />

            <Input type="date" text="Data demissão" name="demissaoDesenhista" placeholder="Insira a data de demissão (se houver)" />

            <SubmitButtom text={btnText} />
        </form>
    )
}

export default DesenhistaForm