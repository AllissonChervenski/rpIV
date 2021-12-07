import Input from '../form/Input'
import Select from '../form/Select'
import SubmitButtom from '../form/SubmitButton'

import styles from './GibisForm.module.css'


function EscritorForm({btnText}){
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome do Escritor" name="nomeEsc" placeholder="Insira o nome completo" />

            <Input type="number" text="Telefone" name="telEsc" placeholder="Insira um telefone para contato" />

            <Input type="text" text="Endereço" name="EnderecoEsc" placeholder="Cidade, Estado, Rua, Número e Cep" />

            <Input type="text" text="Email" name="EmailEsc" placeholder="Insiera um email para contato" />

            <Input type="number" text="Ano de Nascimento" name="nascEsc" placeholder="Inserir ano de nascimento do escritor" />

            <Input type="number" text="Ano de Falecimento" name="falecEsc" placeholder="Não preencher caso escritor esteja vivo" />
            
            <Input type="number" text="Ano de Contratação" name="contratEsc" placeholder="Inserir ano de contratação do escritor" />

            <Input type="number" text="Ano de Demissão" name="DemissEsc" placeholder="Não preencher caso escritor esteja ativo" />

            <Select name="pais_nasc_op" text="Selecione o país de nascimento do autor" />
            
            <SubmitButtom text={btnText} />
        </form>
    )
}

export default EscritorForm