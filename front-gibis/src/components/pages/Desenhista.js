import styles from './Desenhista.module.css'


function Desenhista() {
  async function getContent() {

    try{
      const response = await fetch('http://localhost:8080/desenhistas/all',{
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
      if(!document.querySelector('.gibis_container').innerHTML.includes(element.nomeDesenhista)){
        output += `<h3> Nome:  ${element.nomeDesenhista} </h3>` + `<h4> Pais de Nascimento:  ${element.paisNascimento} </h4>`
        + `<h4> Data de Nascimento:  ${element.dataNascimento} </h4>`  + `<h4> Endereço:  ${element.enderecoDesenhista} </h4>`
        + `<h4> Data de Contratacao:  ${element.dataContratacao} </h4>`  + `<h4> Data de Demissao:  ${element.dataDemissao} </h4>`; 
        if(element.dataFalecimento != null  ){
         output += `<h4> Data de Falecimento: ${element.dataFalecimento}`
        }
        document.querySelector('.gibis_container').innerHTML += `<div className=desenhistas_info style="border: 1px solid">${output}</div>`;
     }
    
    })
  
  
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

export default Desenhista