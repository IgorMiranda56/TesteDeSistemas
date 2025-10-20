/* eslint-disable no-unused-vars */
import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {
  //useState
  const[btnCadastrar, setBtnCadastrar] = useState(true);
  const[produtos, setProdutos] = useState([])
  const[objProduto, setObjProduto] = useState(produto);
  
  //Objeto produto
  const produto = {
    id: 0,
    nome:"",
    marca:""
  }

  //useEffetch
  useEffect(()=>{
    fetch("http://localhost:8080/listar")
    .then(retorno=>retorno.json())
    .then(retorno_convertido=>setProduto(retorno_convertido));

  },[]);

  //Obtendo os dados do formulário.
  const aoDigitar = (e)=>{
    console.log(e.target);
  }

  //Retorno
  return (
    <div>
      <p>{JSON.stringify(objProduto)}</p>
      <Formulario botao = {btnCadastrar}/>
      <Tabela/>
    </div>
  );
}

export default App;
