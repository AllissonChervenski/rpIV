import { Link } from 'react-router-dom';
import Container from './Container';

import styles from './Navbar.module.css';
import logo from '../../img/LOGO (3).png';

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
<<<<<<< HEAD
<<<<<<< HEAD
            <Link to="/cadastros">Cadastros</Link>
=======
=======
>>>>>>> db51e1b (Organização do site)
<<<<<<< HEAD
            <Link to="/desenhistap">Desenhistas</Link>
=======
            <Link to="/desenhistas">Desenhistas</Link>
=======
            <Link to="/desenhistap">Desenhistas</Link>
>>>>>>> 800e520 (Organização do site)
          </li>
          <li className={styles.item}>
            <Link to="/escritorp">Escritores</Link>
          </li>
          <li className={styles.item}>
<<<<<<< HEAD
            <Link to="/gibis">Gibis</Link>
>>>>>>> 2b4ac12 (ajustes)
<<<<<<< HEAD
>>>>>>> 3fae582 (ajustes)
=======
=======
            <Link to="/gibisp">Gibis</Link>
>>>>>>> 800e520 (Organização do site)
>>>>>>> db51e1b (Organização do site)
          </li>
          <li className={styles.item}>
<<<<<<< HEAD
            <Link to="/gibis">Gibis</Link>
=======
<<<<<<< HEAD
            <Link to="/escritorp">Escritores</Link>
          </li>
          <li className={styles.item}>
            <Link to="/gibisp">Gibis</Link>
>>>>>>> d1db7a3 (Formulário Escritor - Cadastro)
          </li>
          <li className={styles.item}>
=======
>>>>>>> 1fe8be3 (Formulário Escritor - Cadastro)
            <Link to="/financeiro">Financeiro</Link>
          </li>
        </ul>
      </Container>
    </div>
  );
}

export default Navbar;
