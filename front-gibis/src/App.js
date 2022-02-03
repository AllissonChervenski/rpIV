import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
<<<<<<< HEAD
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
=======
import Escritor from './components/pages/Escritor'
import Gibis from './components/pages/Gibis'
import Financeiro from './components/pages/FinanceiroP'
import Container from './components/layout/Container'
import Footer from './components/layout/Footer'
import Navbar from './components/layout/Navbar'
import Desenhista from './components/pages/Desenhista'
import Transportadoras from './components/pages/Transportadoras'
>>>>>>> origin/main
import Acervo from './components/pages/Acervo'
import Login from './components/pages/Login'
import DesenhistaP from './components/pages/DesenhistaP'
import EscritorP from './components/pages/EscritorP'
import GibisP from './components/pages/GibisP'
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 66ca9bb (Banca e financeiro)
=======
>>>>>>> origin/main
import Banca from './components/pages/Banca'
import EditorHomePage from './components/pages/EditorHomePage'


<<<<<<< HEAD
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
=======



function App() {
  return (
    
>>>>>>> origin/main
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

<<<<<<< HEAD
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
=======
        <Route exact path="/gibisp"> 
        <GibisP />
        </Route>

        <Route exact path="/financeiro"> 
        <Financeiro />
        </Route>

>>>>>>> origin/main
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
<<<<<<< HEAD
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
=======
>>>>>>> origin/main
        <Desenhista />
        </Route>

        <Route exact path="/transportadoras"> 
        <Transportadoras />
        </Route>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/main

      
        <Route exact path="/acervo"> 
        <Acervo />
        </Route>

        <Route exact path="/login"> 
        <Login />
        </Route>
<<<<<<< HEAD
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
=======
>>>>>>> origin/main
        
        <Route exact path="/editorHomePage"> 
        <EditorHomePage />
        </Route>

        <Route exact path="/banca"> 
        <Banca />
        </Route>

        
<<<<<<< HEAD
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
=======
>>>>>>> origin/main
      </Container>
      </Switch>
      <Footer />
    </Router>
     )
}
export default App