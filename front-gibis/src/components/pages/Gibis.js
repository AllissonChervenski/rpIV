import styles from './Gibis.module.css'
function Gibis() {

  async function getContent() {

    try{
      const response = await fetch('http://localhost:8080/',{
          method: 'GET',
          mode: 'cors',
          cache: 'no-cache'
      })
      let data = await response.json()
      show(data)
    }
    catch(error){
      console.log(error)
    }
    
  }
  
  getContent()

function show(atr) {
  atr.forEach(element =>{
    let output = ''
    if(!document.querySelector('.gibis_container').innerHTML.includes(element.titulo)){
      output += `<h3> Título:  ${element.titulo} </h3>` + `<h4> Data de inicio:  ${element.inicioData} </h4>`; 
      if(element.encData != null  ){
       output += `<h4> Data do fim: ${element.encData}`
      }
      document.querySelector('.gibis_container').innerHTML += `<div className=gibis_info style="border: 1px solid">${output}</div>`;
   }
   
    }
  
    );


    
  }

  return(
  <div className={styles.gibis_container}>
      <div className = "gibis_container" style={{"textAlign":"center"}}>
      </div>

    
</div>
  )

}
export default Gibis