import Input from '../form/Input'
import SubmitButtom from '../form/SubmitButton'

import styles from './DesenhistaForm.module.css'


function TransportadoraForm({ btnText }) {
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome da Transportadora" name="nomeTransportadora" placeholder="Insira o nome da transportadora" />

            <Input type="number" text="CNPJ" name="cnpjTransportadora" placeholder="Insira o CNPJ da Transportadora" />
            <p>Rota de Traballho</p> 
            <Input type="text" text="De" name="rotaTransportadora" placeholder="Insira o local de partida" />
            <Input type="text" text="Para" name="rotaTransportadora" placeholder="Insira o destino final" />
            <Input type="text" text="Rota de Trabalho" name="rotaTransportadora" placeholder="Insira a rota da Transportadora" />
            <p>Rota de Traballho</p> 
            <Input type="text" text="De" name="rotaTransportadora" placeholder="Insira o local de partida" />
            <Input type="text" text="Para" name="rotaTransportadora" placeholder="Insira o destino final" />
            <SubmitButtom text={btnText} />
        </form>
    )
}

export default TransportadoraForm