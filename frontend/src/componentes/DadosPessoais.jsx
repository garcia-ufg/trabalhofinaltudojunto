import { useRef } from "react";
import iconePessoa from "./iconePessoa.png";
function DadosPessoais({dados,setDados}){

    const escolher = useRef();

    function escolherFoto(){
        escolher.current.click();

    }

function handleFoto(e) {
    const arquivo = e.target.files[0];

    if (!arquivo) {
        console.warn("Nenhum arquivo selecionado.");
        return;
    }

    const reader = new FileReader();

    reader.onload = () => {
        console.log("Base64 gerado:", reader.result);
        setDados({ ...dados, foto: reader.result });
    };

    reader.readAsDataURL(arquivo);
}

    return(
        <div className="space-y-4 p-6 bg-slate-200 rounded-md shadow">
            <div>
                <img
                    src={dados.foto ? dados.foto : iconePessoa}
                    alt="Foto do usuário"
                    style={{ width: "90px", height: "90px", objectFit: "cover", borderRadius: "50%" }}
                />

                <input type="file" 
                    ref={escolher}
                    onChange={handleFoto}
                    accept="image/*"
                    style={{display: "none"}}
                />
                <button onClick={escolherFoto}>Adicionar foto</button>
                <form className="grid grid-cols-1 gap-4 mt-4">

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Nome</label>
        <input
            type="text"
            placeholder="Nome"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.nome}
            onChange={(e) => setDados({ ...dados, nome: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Cpf</label>
        <input
            type="text"
            placeholder="cpf"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.cpf}
            onChange={(e) => setDados({ ...dados, cpf: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Descrição</label>
        <textarea
            placeholder="Descrição"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.descricao}
            onChange={(e) => setDados({ ...dados, descricao: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Formação</label>
        <input
            type="text"
            placeholder="Formação"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.formacao}
            onChange={(e) => setDados({ ...dados, formacao: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Endereço</label>
        <input
            type="text"
            placeholder="Endereço"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.endereco}
            onChange={(e) => setDados({ ...dados, endereco: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Telefone</label>
        <input
            type="text"
            placeholder="Telefone"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.numeroTelefone}
            onChange={(e) => setDados({ ...dados, numeroTelefone: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">E-mail</label>
        <input
            type="email"
            placeholder="E-mail"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.email}
            onChange={(e) => setDados({ ...dados, email: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Senha</label>
        <input
            type="password"
            placeholder="Senha"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.Senha}
            onChange={(e) => setDados({ ...dados, Senha: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Habilidades</label>
        <textarea
            placeholder="Habilidades"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.habilidades}
            onChange={(e) => setDados({ ...dados, habilidades: e.target.value })}
        />
    </div>

    <div>
        <label className="block mb-1 font-semibold text-gray-700">Experiência</label>
        <textarea
            placeholder="Experiência profissional"
            className="w-full p-2 rounded-md border border-gray-300 text-black focus:ring-2 focus:ring-blue-400 focus:outline-none"
            value={dados.experiencia}
            onChange={(e) => setDados({ ...dados, experiencia: e.target.value })}
        />
    </div>

</form>

            </div>
        </div>
    )
}

export default DadosPessoais