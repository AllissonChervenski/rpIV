function GibisForm(){
    return (
        <form>
            <div>
            <input type="text" placeholder="Título do Gibi" />
            </div>

            <div>
            <input type="number" placeholder="Ano de início da publicação" />
            </div>

            <div>
            <input type="number" placeholder="Ano de fim da publicação. Caso ainda esteja sendo publicado, deixar campo em branco" />
            </div>
            
            <div> 
            <select name="descontinuado_id">
                <option disabled>O Gibi foi descontinuado?</option>
            </select>
            </div>

            <div>
            <input type="submit" placeholder="Cadastrar Gibi" />
            </div>
        </form>
    )
}

export default GibisForm