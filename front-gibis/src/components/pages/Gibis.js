import styles from './Gibis.module.css'
import GibisForm from '../project/GibisForm'
function Gibis() {

  async function getContent() {

    try{
      const response = await fetch('http://localhost:8080/gibis/view',{
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


   //document.querySelector('.gibis_container').appendChild(`<div className= "gibis_info" style={{"border": "1px solid"}}></div>`);
      
  /*  if(output.childNodes.length === 0){
          document.querySelector(".gibis_info").innerHTML +=`<h3> Título:  ${atr[gibi].titulo} </h3>` + `<h4> Data de inicio:  ${atr[gibi].inicioData} </h4>`; 
          if(atr[gibi].encData != null  ){
            document.querySelector(".gibis_info").innerHTML += `<h4> Data do fim: ${atr[gibi].encData}`
          }
        }
        else{
          document.querySelector(".gibis_container").innerHTML += `<div><div className= "gibis_info" style={{"border": "1px solid"}}></div></div>`
        }
      
    */    
  }

  return(
  <div className={styles.gibis_container}>
      <div className = "gibis_container" style={{"textAlign":"center"}}>
      </div>

    
</div>
  )

}
export default Gibis