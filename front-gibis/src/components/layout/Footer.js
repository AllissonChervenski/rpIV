import { FaFacebook, FaInstagram, FaLinkedin, FaGithub } from 'react-icons/fa'
import styles from './Footer.module.css'

function Footer() {
  return (
    <footer className={styles.footer}>
      <ul className={styles.social_list}>
        <li>
          <FaFacebook />
        </li>
        <li>
          <FaInstagram />
        </li>
        <li>
          <FaLinkedin />
        </li>       
        <li > 
          <FaGithub/>               
        </li>
        <li className='styles.footer'><a   className='styles.footer' href='https://github.com/AllissonChervenski/rpIV'>         
            <FaGithub /></a> 
        </li>
       
      </ul>
      <p className={styles.copy_right}>
        <span>Hero Gibis</span> &copy; 2022
      </p>
    </footer>
  )
}

export default Footer