package simplesDB;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

//essa é a classe que é a interface que o usuário usa pra interagir com o banco de dados
public class sdb{

    private static String DIR_DADOS; //o diretorio com os JSON de dados
    private static String DIR_FOTOS; //o diretorio com as fotos dos usuários

    //retorna o caminho de dir_dados. Utilizado em aux.
    public static String getDIR_DADOS(){
	return DIR_DADOS;
    }

    //define o diretorio onde ficam os Json
    public static boolean setDados(String dir){
	File caminho = new File(dir);
	if(caminho.exists()){
	    DIR_DADOS = dir;
	    return true;
	}
	else{
	    return false;
	}
    }

    //define o diretorio onde ficam as fotos
    public static boolean setFotos(String dir){
	File caminho = new File(dir);
	if(caminho.exists()){
	    DIR_FOTOS = dir;
	    return true;
	}
	else{
	    return false;
	}
    }

    //verifica se o cpf fornecido corresponde a algum currículo no diretório de dados
    public static boolean noDiscoCPF(String cpf){

	String arquivo = aux.nomeArquivo(aux.calculaIdUsuario(cpf));
	String caminho = aux.caminhoArquivo(arquivo);

	File teste = new File(caminho);
	if(teste.exists()){
	    return true;
	}
	return false;
    }

    //verifica se existe curriculo no banco de dados com o ID fornecido
    public static boolean noDiscoID(String id){

	String arquivo = aux.nomeArquivo(id);
	String caminho = aux.caminhoArquivo(arquivo);

	File teste = new File(caminho);
	if(teste.exists()){
	    return true;
	}
	return false;
    }

    //carrega um curriculo do banco de dados utilizando o ID
    public static Curriculo carregaCurriculoId(String id){

	if(noDiscoID(id)){
	    
	    String arquivo = aux.nomeArquivo(id);
	    String caminho = aux.caminhoArquivo(arquivo);

	    try(FileReader leitor = new FileReader(caminho)){
		Curriculo retorno = aux.arquivoPraCurriculo(leitor);
		return retorno;
	    } catch (IOException e) { }	    
	}
	return null;
    }

    //carrega um curriculo do banco de dados utilizando o cpf
    public static Curriculo carregaCurriculoCpf(String cpf){
	String id_usuario = aux.calculaIdUsuario(cpf);
	Curriculo retorno = carregaCurriculoId(id_usuario);
	return retorno;
    }

    //recebe um JSON no formato certo de um currículo e carrega ele
    public static Curriculo carregaCurriculoJson(String json){
	Curriculo retorno = aux.jsonPraCurriculo(json);
	return retorno;
    }

        //cria um novo record Enviando pra ser mandado pro frontend com todos os dados que o frontend se importa.
    public static Enviando curriculoPraEnviar(Curriculo cur){
	Enviando retorno = new Enviando(cur.getNome(), cur.getCPF(), cur.getTelefone(), cur.getEmail(), cur.getEndereco(), cur.getHabilidades(), cur.getFormacao(), cur.getExperiencia(), cur.getDescricao());
	return retorno;
    }

    //recebe um record Recebendo com os dados e inicializa um objeto currículo com eles.
    public static Curriculo recebendoPraCurriculo(Recebendo en){
	Curriculo retorno = new Curriculo(en.nome(), en.cpf(), en.senha(), en.telefone(), en.email(), en.endereco(), en.habilidades(), en.formacao(), en.experiencia(), en.descricao());
	return retorno;
    }

    //cria um novo objeto curriculo
    public static boolean novoUsuario(Recebendo dados){
	Curriculo tmp = recebendoPraCurriculo(dados);
	boolean retorno = salvaCurriculo(tmp);
	return retorno;	
    }

    //salva um objeto currículo no banco de dados
    public static boolean salvaCurriculo(Curriculo cur){
	String caminho = DIR_DADOS + cur.getNome_Arquivo();

	try(FileWriter arquivo = new FileWriter(caminho)){

	    String saida = aux.curriculoPraJson(cur);
	    arquivo.write(saida);
	    arquivo.close();
	    return true;
	    
	} catch(IOException e){	} //não faz nada dnv
	
	return false;
    }

    //verifica se CPF e senha são válidos
    public static boolean autenticaUsuario(String cpf, String senha){

	if(noDiscoCPF(cpf)){

	    String id_usuario = aux.calculaIdUsuario(cpf);
	    int hash_senha = aux.calculaHashSenha(senha);
	    Curriculo tmp = carregaCurriculoId(id_usuario);
	    if(tmp.getHash_Senha() == hash_senha){
		return true;
	    }
	}	    
	return false;	
    }

    //delta um curriculo do banco de dados se ele existir e o cpf tiver certo
    public static boolean delUsuario(String cpf, String senha){

	if(autenticaUsuario(cpf, senha)){

	    String arquivo = aux.nomeArquivo(aux.calculaIdUsuario(cpf));
	    int hash_senha = aux.calculaHashSenha(senha);
	    String caminho = aux.caminhoArquivo(arquivo);
	    File lugar = new File(caminho);
	    lugar.delete();
	    return true;
	    
	}
	return false;
    }

    //edita os dados de um currículo caso CPF e senha fornecidos sejam válidos.
    public static boolean editaUsuario(Recebendo novosdados){
	String cpf = novosdados.cpf();
	String senha = novosdados.senha();	

	//o retorno true de autenticaUsuario já garante que o arquivo existe no disco.
	if(autenticaUsuario(cpf, senha)){
	    Curriculo tmp = recebendoPraCurriculo(novosdados);
	    salvaCurriculo(tmp); //sobrescreve o arquivo velho. como passou no autenticaUsuario, não tem risco de mudar o cpf ou a senha.
	    return true;
	}
	return false;
    }

}
