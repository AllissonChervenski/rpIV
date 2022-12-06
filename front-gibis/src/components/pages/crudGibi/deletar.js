import axios from 'axios';
import { baseUrl } from './baseUrl';

const deleteGibi = async(gibiId)=>{
    console.log(gibiId)
    // return await axios.delete(`${baseUrl}/delete/${gibiId}`);    
    const response = await axios.delete(`${baseUrl}/delete/${gibiId}`);  
    console.log(response)
}

export {
    deleteGibi
}