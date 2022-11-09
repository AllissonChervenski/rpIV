import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'

import styles from './DesenhistaForm.module.css'


function DesenhistaForm() {
    return (
        <form className={styles.form} id="formulario" method='POST'>
            <Input type="text" id="nomeDesenhista" text="Nome do Desenhista" name="nomeDesenhista" placeholder="Insira o nome completo do Desenhista" />

            <Input type="text" id="paisNascimentoDe" text="Pais Nacimento" name="paisNascimentoDe" placeholder="País de nascimento do Desenhista" />

            <Input type="date" id="dataNascimentoDe" text="Data de Nascimento" name="dataNascimentoDe" placeholder="Insira a data de Nascimento" />

            <Input type="date" id="dataFalecimentoDe" text="Data de Falecimento" name="dataFalecimentoDe" placeholder="Insira a data de Falecimento" />

            <Input type="text" id="enderecoDesenhista" text="Endereço" name="enderecoDesenhista" placeholder="Insira o endereço do desenhista" />

            <Input type="date" id="contratacaoDesenhista" text="Data contratação" name="contratacaoDesenhista" placeholder="Insira a data de contratação" />

            <Input type="date" id="demissaoDesenhista" text="Data demissão" name="demissaoDesenhista" placeholder="Insira a data de demissão (se houver)" />

            <button type="submit" id="addDesenhista"/>
        </form>
    )
    }





export default DesenhistaForm