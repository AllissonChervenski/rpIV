import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
import Gibis from './components/pages/Gibis'
import Financeiro from './components/pages/Financeiro'
import Container from './components/layout/Container'
import Footer from './components/layout/Footer'
import Navbar from './components/layout/Navbar'
<<<<<<< HEAD
=======
import Desenhista from './components/pages/Desenhista'
<<<<<<< HEAD
<<<<<<< HEAD
import Transportadoras from './components/pages/Transportadoras'
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 175ab58 (Ajuste após substituição do SingIn por Login)
import Acervo from './components/pages/Acervo'
import Login from './components/pages/Login'
import DesenhistaP from './components/pages/DesenhistaP'
import EscritorP from './components/pages/EscritorP'
import GibisP from './components/pages/GibisP'
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 66ca9bb (Banca e financeiro)
import Banca from './components/pages/Banca'
import EditorHomePage from './components/pages/EditorHomePage'


=======
>>>>>>> 5253f45 (Desenhista Forms)
=======
import Transportadoras from './components/pages/Transportadoras'
>>>>>>> e31c498 (Updates)
=======
import SingIn from './components/pages/SingIn'
<<<<<<< HEAD
>>>>>>> ef88676 (Login page)
=======
import Acervo from './components/pages/Acervo'
import Login from './components/pages/Login'
>>>>>>> 7c60ee0 (Login Update (add image))
=======
>>>>>>> 800e520 (Organização do site)
=======
import EditorHomePage from './components/pages/EditorHomePage'


>>>>>>> 4d91f1b (Início da página do Editor)


>>>>>>> 4e6661d (Desenhista Forms)

function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
      <Container customClass = "min-height">
        <Route exact path="/"> 
        <Home />
        </Route>

        <Route exact path="/cadastros"> 
        <Cadastros />
        </Route>

        <Route exact path="/gibis"> 
        <Gibis />
        </Route>

        <Route exact path="/financeiro"> 
        <Financeiro />
        </Route>
<<<<<<< HEAD
=======

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 800e520 (Organização do site)
        <Route exact path="/escritorp"> 
        <EscritorP />
        </Route>

        <Route exact path="/escritor"> 
        <Escritor />
        </Route>

        <Route exact path="/desenhistap"> 
        <DesenhistaP />
        </Route>

        <Route exact path="/desenhista"> 
=======
        <Route exact path="/escritores"> 
        <Escritor />
        </Route>
        <Route exact path="/desenhistas"> 
>>>>>>> 2b4ac12 (ajustes)
=======
        <Route exact path="/escritor"> 
        <Escritor />
        </Route>
        <Route exact path="/desenhista"> 
>>>>>>> 9b92b34 (ajustes 3)
        <Desenhista />
        </Route>

        <Route exact path="/transportadoras"> 
        <Transportadoras />
        </Route>
<<<<<<< HEAD
<<<<<<< HEAD

      
        <Route exact path="/acervo"> 
        <Acervo />
        </Route>

        <Route exact path="/login"> 
        <Login />
        </Route>
=======
>>>>>>> e31c498 (Updates)
=======

<<<<<<< HEAD
        <Route exact path="/singin"> 
        <SingIn />
        </Route>
<<<<<<< HEAD
>>>>>>> ef88676 (Login page)
=======

=======
      
>>>>>>> 175ab58 (Ajuste após substituição do SingIn por Login)
        <Route exact path="/acervo"> 
        <Acervo />
        </Route>

        <Route exact path="/login"> 
        <Login />
        </Route>
        
<<<<<<< HEAD
>>>>>>> 7c60ee0 (Login Update (add image))
=======
        <Route exact path="/editorHomePage"> 
        <EditorHomePage />
        </Route>

>>>>>>> 4d91f1b (Início da página do Editor)
        
        <Route exact path="/editorHomePage"> 
        <EditorHomePage />
        </Route>

        <Route exact path="/banca"> 
        <Banca />
        </Route>

        
=======
        <Route exact path="/escritor"> 
        <Escritor />
        </Route>
>>>>>>> 1fe8be3 (Formulário Escritor - Cadastro)
<<<<<<< HEAD
>>>>>>> d1db7a3 (Formulário Escritor - Cadastro)
=======
=======
        <Route exact path="/desenhista"> 
        <Desenhista />
        </Route>
        
>>>>>>> 5253f45 (Desenhista Forms)
>>>>>>> 4e6661d (Desenhista Forms)
      </Container>
      </Switch>
      <Footer />
    </Router>
     )
}
export default App