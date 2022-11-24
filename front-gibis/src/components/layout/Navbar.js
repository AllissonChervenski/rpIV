import { Link } from 'react-router-dom';
import Container from './Container';

import styles from './Navbar.module.css';
import logo from '../../img/LOGOHEADER.png';


function Navbar() {
  return (
    <div className={styles.navbar}>
      <Container>
        <Link to="/">
          <img src={logo} alt="Hero Gibis" />
        </Link>
        <ul className={styles.list}>
          <li className={styles.item}>
            <Link to="/">Home</Link>
          </li>
          <li className={styles.item}>
            <Link to="/desenhistap">Desenhistas</Link>
          </li>
          <li className={styles.item}>
            <Link to="/escritorp">Escritores</Link>
          </li>
          <li className={styles.item}>
            <Link to="/gibisp">Gibis</Link>
          </li>
          <li className={styles.item}>
            <Link to="/financeiro">Financeiro</Link>
          </li>
          <li className={styles.item}>
            <Link to="/transportadoras">Transportadoras</Link>
          </li>
          <li className={styles.item}>
            <Link to="/Login">Login</Link>
          </li>
        </ul>      
      </Container>
    </div>
  );
}

export default Navbar;
