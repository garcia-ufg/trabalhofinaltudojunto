package simplesDB;

import java.util.ArrayList;

//tem o Curriculo e os dados do usuáiro
public class Curriculo{

    //Coisas imutáveis utilizadas pra gerenciar o banco de dados.
    private final String cpf;
    private final String id_usuario;
    private final String nome_arquivo; //o hash cpf é utilizado pra nomear o arquivo com os dados do usuáiro
    private final int hash_senha; //a senha provida pelo usuário como uma string é armazenada como um hash.
    
    //Dados de usuário
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String habilidades;
    private String formacao;
    private String experiencia;
    private String descricao;

    //o construtor da classe recebe tudo.
    protected Curriculo(String nome, String cpf, String senha, String telefone, String email, String endereco, String habilidades, String formacao, String experiencia, String descricao) {
	this.cpf = cpf;
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
	this.endereco = endereco;
	this.habilidades = habilidades;
	this.formacao = formacao;
	this.experiencia = experiencia;
	this.descricao = descricao;

	this.id_usuario = aux.calculaIdUsuario(cpf);
	this.nome_arquivo = aux.nomeArquivo(id_usuario);
	this.hash_senha = aux.calculaHashSenha(senha);
	
    }

    //Getters 
    protected String getCPF(){
	return this.cpf;
    }
    protected String getId_usuario(){
	return this.id_usuario;
    }
    protected String getNome_Arquivo(){
	return this.nome_arquivo;
    }
    protected int getHash_Senha(){
	return this.hash_senha;
    }
    protected String getNome() {
	return this.nome;
    }
    protected String getTelefone(){
	return this.telefone;
    }
    protected String getEmail(){
	return this.email;
    }
    protected String getEndereco(){
	return this.endereco;
    }
    protected String getHabilidades(){
	return this.habilidades;
    }
    protected String getFormacao(){
	return this.formacao;
    }
    protected String getExperiencia(){
	return this.experiencia;
    }
    protected String getDescricao(){
	return this.descricao;
    }
    
    //Setters
    protected void setNome(String novonome){
	this.nome = novonome;
    }
    protected void setTelefone(String novotelefone){
	this.telefone = novotelefone;
    }
    protected void setEmail(String email){
	this.email = email;
    }
    protected void setEndereco(String endereco){
	this.endereco = endereco;
    }
    protected void setHabilidades(String habilidades){
	this.habilidades = habilidades;
    }
    protected void setFormacao(String forma){
	this.formacao = forma;
    }
    protected void setExperiencia(String exp){
	this.experiencia = exp;
    }
    protected void setDescricao(String ent){
	this.descricao = ent;
    }
    
}
