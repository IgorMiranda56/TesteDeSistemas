function Formulario(botao, eventoTeclado){
    return(
        <form>
            <input type="text" onChange={eventoTeclado}name="nome" placeholder="Nome" className="form-control"/>
            <input type="text" onChange={eventoTeclado}name="marca" placeholder="Marca" className="form-control"/>
            {
                botao
                ?
                <input type="button" placeholder="Cadastrar" className="btn btn-primary"/>
                :
                <div>
                    
                    <input type="button" placeholder="Alterar" className="btn btn-warning"/>
                    <input type="button" placeholder="Remover" className="btn btn-danger"/>
                    <input type="button" placeholder="Cancelar" className="btn btn-secondary"/>
                </div>
            }
        </form>
    )
}
export default Formulario;