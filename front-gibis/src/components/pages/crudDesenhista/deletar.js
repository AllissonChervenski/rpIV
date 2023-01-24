import axios from 'axios';
import { baseUrl } from './baseUrl';

const deleteDesenhista = async(desenhistaId)=>{
    console.log(desenhistaId)
    // return await axios.delete(`${baseUrl}/delete/${desenhistaId}`);    
    const response = await axios.delete(`${baseUrl}/delete/${desenhistaId}`);  
    console.log(response)
    return response;
}

export {
    deleteDesenhista
}