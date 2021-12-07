import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
import Gibis from './components/pages/Gibis'
import Financeiro from './components/pages/Financeiro'
import Container from './components/layout/Container'
import Footer from './components/layout/Footer'
import Navbar from './components/layout/Navbar'

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
        <Desenhista />
        </Route>

        <Route exact path="/transportadoras"> 
        <Transportadoras />
        </Route>

      
        <Route exact path="/acervo"> 
        <Acervo />
        </Route>

        <Route exact path="/login"> 
        <Login />
        </Route>
        
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
>>>>>>> d1db7a3 (Formulário Escritor - Cadastro)
      </Container>
      </Switch>
      <Footer />
    </Router>
     )
}
export default App