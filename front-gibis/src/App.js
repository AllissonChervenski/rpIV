import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Home from './components/pages/Home'
import Cadastros from './components/pages/Cadastros'
import Gibis from './components/pages/Gibis'
import Financeiro from './components/pages/FinanceiroP'
import Container from './components/layout/Container'
import Footer from './components/layout/Footer'
import Navbar from './components/layout/Navbar'
import Desenhista from './components/pages/crudDesenhista/DesenhistaLIsta'
import Escritor from './components/pages/crudEscritor/EscritorLista'
import Gibi from './components/pages/crudGibi/GibiLista'
import Transportadoras from './components/pages/Transportadoras'
import Acervo from './components/pages/Acervo'
import Login from './components/pages/Login'
import DesenhistaP from './components/pages/DesenhistaP'
import EscritorP from './components/pages/EscritorP'
import NewEscritor from './components/pages/crudEscritor/NewEscritor'
import GibisP from './components/pages/GibisP'
import Banca from './components/pages/Banca'
import EditorHomePage from './components/pages/EditorHomePage'
import Nascimento from './components/pages/crudGibi/NewGibi'
import NewDesenhista from './components/pages/NewDesenhista'
import UpdateDesenhista from './components/pages/crudDesenhista/FormUpdate';
import  UpdateEscritor from './components/pages/crudEscritor/FormUpdateEscritor'
import UpdateGibi from './components/pages/crudGibi/FormUpdateGibi'

import axios from 'axios'



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

        <Route exact path="/gibi"> 
        <Gibi />
        </Route>

        <Route exact path="/updategibi">
        < UpdateGibi/>
        </Route>

        <Route exact path="/newgibi">
        <Nascimento />
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

        <Route exact path="/newescritor">
        <NewEscritor />
        </Route>

        <Route exact path="/updateescritor">
        < UpdateEscritor/>
        </Route>


        <Route exact path="/desenhistap"> 
        <DesenhistaP />
        </Route>

        <Route exact path="/desenhista">
        <Desenhista />
        </Route>

        <Route exact path="/desenhista/delete">
        <deletar />
        </Route>

        
        <Route exact path="/newdesenhista">
        <NewDesenhista />
        </Route>

        <Route exact path="/updatedesenhista">
        < UpdateDesenhista/>
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