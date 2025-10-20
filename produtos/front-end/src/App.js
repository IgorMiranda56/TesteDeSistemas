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
    setObjProduto({...objProduto, [e.target.name]: e.target.value});
  }

  //Cadastrar produto.
  const cadastrar = () =>{
    fetch("http://localhost:8080/cadastrar",{
      method:'post',
      body:JSON.stringify(objProduto),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno=>retorno.json())
    .then(retorno_convertido=>{
      if(retorno_convertido.mensagem !== undefined){
        alert(retorno_convertido.mensagem);
      }else{
        setProdutos([...produtos, retorno_convertido]);
        alert("Produto cadastrado com sucesso!");
        limparFormulario();
      }
    })
  }

  //Limpar formulário.
  const limparFormulario = () =>{
    setObjProduto(produto);
    setBtnCadastrar(true);
  }

  //Selecionar produto.
  const selecionarProduto = (indice) =>{
    setObjProduto(produtos[indice]);
    setBtnCadastrar(false);
  }

  //Remover produto.
  const remover = () =>{
    fetch("http://localhost:8080/remover/"+objProduto.id,{
      method:'delete',
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno=>retorno.json())
    .then(retorno_convertido=>{
    //Mensagem.
      alert(retorno_convertido.mensagem);
      //Cópia do vetor de produtos.
      let vetorTemp = [...produtos];
      //Índice.
      let indice = vetorTemp.findIndex((p)=>{
        return p.id === objProduto.id;
      });
      //Remover produto do vetor.
      vetorTemp.splice(indice, 1);
      //Atualizar o vetor de produtos.
      setProdutos(vetorTemp);
      //Limpar formulário.
      limparFormulario();
    })
      }

  //Alterar produto.
  const alterar = () =>{
    fetch("http://localhost:8080/alterar",{
      method:'put',
      body:JSON.stringify(objProduto),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno=>retorno.json())
    .then(retorno_convertido=>{
      if(retorno_convertido.mensagem !== undefined){
        alert(retorno_convertido.mensagem);
      }else{
        alert("Produto alterado com sucesso!");
        //Cópia do vetor de produtos.
        let vetorTemp = [...produtos];
        //Índice.
        let indice = vetorTemp.findIndex((p)=>{
          return p.id === objProduto.id;
        });
        //Alterar produto do vetor.
        vetorTemp[indice] = objProduto;
        //Atualizar o vetor de produtos.
        setProdutos(vetorTemp);
        //Limpar formulário.
        limparFormulario();
      }
    })
  }

  //Retorno
  return (
    <div>
      <Formulario botao = {btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objProduto} cancelar={limparFormulario} remover={remover} alterar={alterar}/>
      <Tabela vetor={produtos} selecionar={selecionarProduto}/>
    </div>
  );
}

export default App;
