import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'

import styles from './DesenhistaForm.module.css'


function DesenhistaForm({ btnText }) {
    return (
        <form className={styles.form}>
            <Input type="text" id="nome" text="Nome do Desenhista" name="nomeDesenhista" placeholder="Insira o nome completo do Desenhista" />

            <Input type="text" id="paisNascimento" text="Pais Nacimento" name="paisNascimentoDe" placeholder="País de nascimento do Desenhista" />

            <Input type="date" id="dataNascimento" text="Data de Nascimento" name="dataNascimentoDe" placeholder="Insira a data de Nascimento" />

            <Input type="date" id="dataFalecimento" text="Data de Falecimento" name="dataFalecimentoDe" placeholder="Insira a data de Falecimento" />

            <Input type="text" id="endereco" text="Endereço" name="enderecoDesenhista" placeholder="Insira o endereço do desenhista" />

            <Input type="date" id="dataContratacao" text="Data contratação" name="contratacaoDesenhista" placeholder="Insira a data de contratação" />

            <Input type="date" id="dataDemissao" text="Data demissão" name="demissaoDesenhista" placeholder="Insira a data de demissão (se houver)" />

            <SubmitButtom text={btnText} name="addDesenhista" id="addDesenhista"/>
        </form>
    )
}


export default DesenhistaForm