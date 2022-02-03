import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
import Escritor from './components/pages/Escritor'
import Gibis from './components/pages/Gibis'
import Financeiro from './components/pages/FinanceiroP'
import Container from './components/layout/Container'
import Footer from './components/layout/Footer'
import Navbar from './components/layout/Navbar'
import Desenhista from './components/pages/Desenhista'
import Transportadoras from './components/pages/Transportadoras'
import Acervo from './components/pages/Acervo'
import Login from './components/pages/Login'
import DesenhistaP from './components/pages/DesenhistaP'
import EscritorP from './components/pages/EscritorP'
import GibisP from './components/pages/GibisP'
import Banca from './components/pages/Banca'
import EditorHomePage from './components/pages/EditorHomePage'





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

        <Route exact path="/gibisp"> 
        <GibisP />
        </Route>

        <Route exact path="/financeiro"> 
        <Financeiro />
        </Route>

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

        
      </Container>
      </Switch>
      <Footer />
    </Router>
     )
}
export default App