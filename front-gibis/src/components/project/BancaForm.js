import Input from '../form/Input'
import Select from '../form/Select'
import SubmitButtom from '../form/SubmitButton'

import styles from './DesenhistaForm.module.css'


function BancaForm({ btnText }) {
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome do proprietário" name="nomeProp" placeholder="Insira o nome completo do Proprietário" />

            <Input type="number" text="CNPJ" name="CNPJBanca" placeholder="Insira o CNPJ do Proprietário" />
            
            <Input type="text" text="Nome da Banca" name="nomeBanca" placeholder="Insira o nome da Banca" />

            <Input type="text" text="Endereço da Banca" name="enderecoBanca" placeholder="Insira o endereço da Banca (Rua, Número)" />

            <Input type="number" text="CEP" name="CEPBanca" placeholder="Insira o CEP da Banca" />
            
            <Select name="estado_banca_op" text="Selecione o estado da Banca" />

            <SubmitButtom text={btnText} />
        </form>
    )
}

export default BancaForm