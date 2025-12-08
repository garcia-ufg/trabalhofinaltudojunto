import { useState } from 'react'
import { Route, Routes, useNavigate } from 'react-router-dom'
import './App.css'
import AparenciaCurriculo from './componentes/AparenciaCurriculo'
import DadosPessoais from './componentes/DadosPessoais'

function App() {

  const navigate = useNavigate()

  const [dadosPessoais, setDadosPessoais] = useState({
    nome: "",
    cpf:"",
    nome_arquivo:"",
    senha:"",
    endereco:"",
    numeroTelefone:"",
    email:"",
    foto: null,
    experiencia:"",
    formacao:"",
    descricao:"",
    habilidades:""
  })

  function continuar() {
    navigate("/pdf")
  }

  return (
    <Routes>

      <Route path="/" element={
        <div>
          <h1>Curriculo</h1>
          <DadosPessoais dados={dadosPessoais} setDados={setDadosPessoais}/>
          <button onClick={continuar}>CONTINUAR</button>
        </div>
      }/>

      <Route
        path="/pdf"
        element={<AparenciaCurriculo dados={dadosPessoais} />}
      />

    </Routes>
  ) 
}

export default App
