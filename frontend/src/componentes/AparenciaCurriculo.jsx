import GerarPdf from "./GerarPdf";
import iconePessoa from "./iconePessoa.png";

function AparenciaCurriculo({ dados }) {
  return (
    <div className="min-h-screen w-full flex justify-center p-8 bg-gray-100">
      <div className="w-full max-w-4xl bg-white shadow-lg rounded-lg overflow-hidden">

        {/* Cabeçalho */}
        <div className="bg-[#496267] text-white p-8 flex gap-6 items-center">
          <img
            src={dados.foto || iconePessoa}
            alt="Foto"
            className="w-32 h-32 object-cover rounded-md border-2 border-white"
          />

          <div>
            <h1 className="text-4xl font-bold text-black">{dados.nome || "Nome não informado"}</h1>
            <p className="text-sm mt-2 opacity-80 text-black">{dados.email}</p>
            <p className="text-sm opacity-80 text-black">{dados.numeroTelefone}</p>
          </div>
        </div>

        {/* Corpo */}
        <div className="p-8 space-y-8">

          {/* Dados Pessoais */}
          <section>
            <h2 className="text-xl font-bold text-[#496267] border-b pb-1 mb-3">Dados pessoais</h2>
            <div className="space-y-1 text-black">
              <p><strong>CPF:</strong> {dados.cpf}</p>
              <p><strong>Endereço:</strong> {dados.endereco}</p>
              <p><strong>Email:</strong> {dados.email}</p>
              <p><strong>Telefone:</strong> {dados.numeroTelefone}</p>
            </div>
          </section>

          {/* Resumo */}
          <section>
            <h2 className="text-xl font-bold text-[#496267] border-b pb-1 mb-3">Resumo</h2>
            <p className="text-justify text-black">{dados.descricao}</p>
          </section>

          {/* Habilidades */}
          <section>
            <h2 className="text-xl font-bold text-[#496267] border-b pb-1 mb-3">Habilidades</h2>
            <p className="text-justify whitespace-pre-line text-black">{dados.habilidades}</p>
          </section>

          {/* Experiência */}
          <section>
            <h2 className="text-xl font-bold text-[#496267] border-b pb-1 mb-3">Experiência profissional</h2>
            <p className="text-justify whitespace-pre-line text-black">{dados.experiencia}</p>
          </section>

          {/* Formação */}
          <section>
            <h2 className="text-xl font-bold text-[#496267] border-b pb-1 mb-3">Formação</h2>
            <p className="text-justify whitespace-pre-line text-black">{dados.formacao}</p>
          </section>

          {/* Botão */}
          <div className="flex justify-center pt-4">
            <button
              className="px-6 py-3 bg-[#496267] hover:bg-[#3b5054] text-black rounded-md font-semibold transition"
              onClick={() => GerarPdf(dados)}
            >
              Gerar PDF do currículo
            </button>
          </div>

        </div>
      </div>
    </div>
  );
}

export default AparenciaCurriculo;

