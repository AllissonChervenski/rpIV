import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
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

        <Route exact path="/financeiro"> 
        <Financeiro />
        </Route>
      </Container>
      </Switch>
      <Footer />
    </Router>
     )
}
export default App