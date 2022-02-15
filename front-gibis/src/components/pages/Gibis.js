import styles from './Gibis.module.css'
import GibisForm from '../project/GibisForm'
function Gibis() {

  async function getContent() {

    try{
      const response = await fetch('http://localhost:8080/api/gibis/view')
      let data = await response.json()
      show(data)
    }
    catch(error){
      console.log(error)
    }
    
  }
  
  getContent()

function show(atr) {
  let output = ''

  for(let gibi in atr){
   output += `<li>${atr[gibi].titulo}</li>`
  }
  document.querySelector('.gibis_container').innerHTML = output
  

  }

  return(
  <div className={styles.gibis_container}>
  <div className = "gibis_container"></div>
    
</div>
  )

}
export default Gibis