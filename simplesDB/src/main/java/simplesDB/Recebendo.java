package simplesDB;

//Esse record representa os dados que o frontend enviaria para o backend para cadastrar um novo usuário ou editar os dados de um usuário existente.
public record Recebendo(String nome, String cpf, String senha, String telefone, String email, String endereco, String habilidades, String formacao, String experiencia, String descricao){}
