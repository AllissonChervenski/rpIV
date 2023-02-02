import axios from 'axios';
import { baseUrl } from './baseUrl';

const deletePersonagem = async(personagemId)=>{
    console.log(personagemId)  
    const response = await axios.delete(`${baseUrl}/delete/${personagemId}`);  
    console.log(response)
}

export {
    deletePersonagem
}