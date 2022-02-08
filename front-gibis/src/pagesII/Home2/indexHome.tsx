import Icon from '@ailibs/feather-react-ts';
import React from 'react';
import { Link } from 'react-router-dom';
import styles from './Home.module.css'

export default function Home() {
  return (
    <div className={styles.pageWrapper}>
      <h3>Gibis</h3>
      <div className={styles.cardWrapper}>
        <Link to="/escritor2/new">
          <button className={styles.cardItem}>
            <div>
              <Icon name="plus-circle" />
              <p>Adicionar escritor</p>
            </div>
          </button>
        </Link>
        <Link to="/amostra/new">
          <button className={styles.cardItem}>
            <div>
              <Icon name="file-plus" />
              <p>Enviar arquivo</p>
            </div>
          </button>
        </Link>
      </div>
    </div>
  );
}