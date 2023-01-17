import axios from 'axios';
import { baseUrl } from './baseUrl';

const deleteGibi = async(gibiId)=>{
    console.log(gibiId)  
    const response = await axios.delete(`${baseUrl}/deleteGibi/${gibiId}`);  
    console.log(response)
}

export {
    deleteGibi
}