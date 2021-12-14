<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 75195b7 (Conclusão formulário gibis)
import Input from '../form/Input'
import Select from '../form/Select'
import SubmitButtom from '../form/SubmitButton'

import styles from './GibisForm.module.css'


function GibisForm({btnText}){
<<<<<<< HEAD
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome do Gibi" name="nomeGibi" placeholder="Insira o nome completo do Gibi" />

            <Input type="date" text="Início das publicações" name="inicioP" placeholder="Insira a data de início das publicações" />
            
            <Input type="date" text="Fim das publicações" name="fimP" placeholder="Não preencher caso as publicações estejam ativas" />

            <Select name="descontinuado_op" text="O Gibi foi descontinuado?" />
            
            <SubmitButtom text={btnText} />
=======
=======
import styles from './GibisForm.module.css'

>>>>>>> 9329383 (Ajustes formulários)
function GibisForm(){
=======
>>>>>>> 75195b7 (Conclusão formulário gibis)
    return (
        <form className={styles.form}>
            <Input type="text" text="Nome do Gibi" name="nomeGibi" placeholder="Insira o nome completo do Gibi" />

            <Input type="date" text="Início das publicações" name="inicioP" placeholder="Insira a data de início das publicações" />
            
            <Input type="date" text="Fim das publicações" name="fimP" placeholder="Não preencher caso as publicações estejam ativas" />

<<<<<<< HEAD
            <div>
            <input type="submit" value="Cadastrar Gibi" />
            </div>
>>>>>>> c1653e8 (Campos de cadastro de gibis)
=======
            <Select name="descontinuado_op" text="O Gibi foi descontinuado?" />
            
            <SubmitButtom text={btnText} />
>>>>>>> 75195b7 (Conclusão formulário gibis)
        </form>
    )
}

export default GibisForm