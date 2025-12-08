import jsPDF from "jspdf";

function GerarPdf(dadosPessoais){
    const doc = new jsPDF();
    if(dadosPessoais.foto){
        doc.addImage(dadosPessoais.foto, 10, 10, 40, 40)
    }
    
    doc.text(`Nome: ${dadosPessoais.Nome}`, 10, 50);
    doc.text(`Sobrenome: ${dadosPessoais.Sobrenome}`, 10, 60);
    doc.text(`Data de nascimento: ${dadosPessoais.DataNascimento}`, 10, 70);
    doc.text(`Endereço: ${dadosPessoais.Endereco}`, 10, 80);
    doc.text(`Telefone: ${dadosPessoais.NumeroTelefone}`, 10, 90);
    doc.text(`Email: ${dadosPessoais.Email}`, 10, 100);

    doc.save("curriculo.pdf");
}

export default GerarPdf
