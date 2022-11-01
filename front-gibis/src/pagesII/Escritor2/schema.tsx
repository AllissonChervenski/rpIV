import * as yup from 'yup';

export const validationSchema = yup.object({
  escNome: yup.string().required('Nome do escritor é obrigatório.'),
  escTel: yup.string().required('Telefone do escritor é obrigatório.'),
  escEndr: yup.string().required('Endereço do escritor é obrigatório.'),
  escEmail: yup.string().required('Email do escritor é obrigatório.'),
  escDtN: yup.number().positive('Data de nascimento deve ser positiva').required('Data de nascimento é obrigatória.'),
  escDtF: yup.number().positive('Data de falescimento deve ser positiva'),
  escDtContr: yup.number().positive('Data de contratação deve ser positiva').required('Data de contratação é obrigatória.'),
  escDtDimiss: yup.number().positive('Data de admissão deve ser positiva'),
  escPaisNasc: yup.string().required('País de nascimento é obrigatório'),
});