import { Link } from 'react-router-dom';
import Container from './Container';

import styles from './Navbar.module.css';
import logo from '../../img/LOGO.png';

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
            <Link to="/cadastros">Cadastros</Link>
          </li>
          <li className={styles.item}>
            <Link to="/financeiro">Financeiro</Link>
          </li>
        </ul>
      </Container>
    </div>
  );
}

export default Navbar;
