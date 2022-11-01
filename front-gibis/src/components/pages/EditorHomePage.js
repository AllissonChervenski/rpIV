import styles from './EditorHomePage.module.css'
import savings from '../../img/savings.png'



import LinkButton from '../layout/LinkButton'

function EditorHomePage() {
  return (
    <section className={styles.EditorHomePage_container}>


      <home>  </home>
      <olaEditor>  <p>Olá, editor!</p> </olaEditor>

      <rectangleOne> </rectangleOne>
      <gerirGibisText> <p>Gerir Gibis</p> </gerirGibisText>


      <rectangleTwo></rectangleTwo>
      <gerirPersonagensText> <p>Gerir Personagens</p> </gerirPersonagensText>

      <rectangleThree></rectangleThree>
      <gerirEscritoresText> <p> Gerir Escritores </p> </gerirEscritoresText>



      <grayRectangle></grayRectangle>


    </section>
  )
}

export default EditorHomePage