import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'
import React, {useState} from 'react'

import styles from './DesenhistaForm.module.css'



function DesenhistaForm({btnText}) {
    const [value, setValue] = useState('');

    const handleChange = (event) => {
       setValue(event.target.value);
    }

        return (
        <form className={styles.container}>
            <Input type="text" text="Nome de Desenhista" value={value} className={styles.form_input} placeholder="Insira o nome do desenhista"  handleOnChange={handleChange()} />

            <Input type="text" text="Pais de Nascimento" name="paisNascimento" placeholder="Insira o Pais de Nascimento do Desenhista"   />

            <Input type="text" text="Endereço Desenhista" name="ederecoDesenhista" placeholder="Insira o Endereco do Desenhista"  />

            <Input type="date" text="Data de Nascimento" name="dataNascimento" placeholder="Data de Nascimento" />

            <Input type="date" text="Data de Falecimento" name="dataDalecimento" placeholder="Data de Falecimento"  />

            <Input type="date" text="Data de Contratação" name="dataContratação" placeholder="Data de Contratação" />

            <Input type="date" text="Data de Demissão" name="dataDemissão" placeholder="Data de Demissão" />

            <SubmitButtom text={btnText} />
        </form>
    )
}

export default DesenhistaForm