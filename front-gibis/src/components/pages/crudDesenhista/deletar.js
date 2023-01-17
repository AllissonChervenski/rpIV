import axios from 'axios';
import { baseUrl } from './baseUrl';

const deleteDesenhista = async(desenhistaId)=>{
    
return await axios.delete(`${baseUrl}/delete/${desenhistaId}`); 

}

export {
    deleteDesenhista
}