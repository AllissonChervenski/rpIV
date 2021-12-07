import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
import Gibis from './components/pages/Gibis'
import Financeiro from './components/pages/Financeiro'
import Container from './components/layout/Container'
import Footer from './components/layout/Footer'
import Navbar from './components/layout/Navbar'
import Desenhista from './components/pages/Desenhista'
import Transportadoras from './components/pages/Transportadoras'



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

        <Route exact path="/desenhista"> 
        <Desenhista />
        </Route>

        <Route exact path="/transportadoras"> 
        <Transportadoras />
        </Route>
        
      </Container>
      </Switch>
      <Footer />
    </Router>
     )
}
export default App