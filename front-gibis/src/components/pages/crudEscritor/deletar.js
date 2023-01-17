import axios from 'axios';
import { baseUrl } from './baseUrl';

const deleteEscritor = async(escritorId)=>{
    console.log(escritorId)
    // return await axios.delete(`${baseUrl}/delete/${escritorId}`);    
    const response = await axios.delete(`${baseUrl}/delete/${escritorId}`);  
    console.log(response)
}

export {
    deleteEscritor
}