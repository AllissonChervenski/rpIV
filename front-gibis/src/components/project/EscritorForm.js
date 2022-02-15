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


            <Input type="date" text="Data de Nascimento" name="nascEsc" placeholder="Inserir data de nascimento do escritor" />

            <Input type="date" text="Data de Falecimento" name="falecEsc" placeholder="Não preencher caso escritor esteja vivo" />
            
            <Input type="date" text="Data de Contratação" name="contratEsc" placeholder="Inserir data de contratação do escritor" />

            <Input type="date" text="Data de Demissão" name="DemissEsc" placeholder="Não preencher caso escritor esteja ativo" />

            <Input type="date" text="Data de Nascimento" name="nascEsc" placeholder="Inserir data de nascimento do escritor" />


            <Input type="date" text="Data de Falecimento" name="falecEsc" placeholder="Não preencher caso escritor esteja vivo" />
            
            <Input type="date" text="Data de Contratação" name="contratEsc" placeholder="Inserir data de contratação do escritor" />


            <Input type="date" text="Data de Demissão" name="DemissEsc" placeholder="Não preencher caso escritor esteja ativo" />


            <Select name="pais_nasc_op" text="Selecione o país de nascimento do autor" />
            
            <SubmitButtom text={btnText} />
        </form>
    )
}

export default EscritorForm