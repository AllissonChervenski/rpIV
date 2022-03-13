import { useState, useEffect} from 'react'
import styles from './Message.module.css'

function Message({ type, msg }){
    const [visible, setVisible] = useState(false)

    useEffect(() => {
        //se não há mensagem, não exibe nada
        if(!msg){
            setVisible(false)
            return 
        }

        //se há mensagem, visibilidade true, inicia o timer 
        setVisible(true)

        const timer = setTimeout(() => {
            setVisible(false)
        }, 3000);
        
        //finaliza o timer 
        return () => clearTimeout(timer)

    }, [msg])

    return (<>
        {visible && (
            <div className={`${styles.message} ${styles[type]}`}>{msg}</div>
        )}
    </>
    )
}

export default Message