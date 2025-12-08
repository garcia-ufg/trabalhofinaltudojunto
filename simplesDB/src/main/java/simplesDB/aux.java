package simplesDB;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//funções auxiliares utilizadas pela classe sdb e Curriculo
class aux{

    //calcula o hash que é o nome do arquivo a partir do CPF
    protected static String calculaIdUsuario(String cpf){
	int tmp = cpf.hashCode() & 0x7fffffff; //pra ser sempre um número positivo.
	String retorno = Integer.toString(tmp);
	return retorno;
    }

    //calcula e retorna o hash de uma senha fornecida
    protected static int calculaHashSenha(String senha){
	int retorno = senha.hashCode();
	return retorno;
    }

    //recebe um ID de usuário como string e simplesmente adiciona ".json" no final.
    //utilizad pra gerenciar arquivos no disco
    protected static String nomeArquivo(String ID){
	String retorno = ID + ".json";
	return retorno;
    }

    //recebe o nome de um arquivo com .json no final e retorna o caminho dele no disco
    protected static String caminhoArquivo(String nomeArquivo){
	String retorno = sdb.getDIR_DADOS() + nomeArquivo;
	return retorno;
    }

    //transforma um objeto currículo em um JSON
    protected static String curriculoPraJson(Curriculo entrada){
	Gson gson = new Gson();
	String retorno = gson.toJson(entrada);
	return retorno;
    }

    //transforma um JSON em um objeto currículo
    protected static Curriculo jsonPraCurriculo(String json){
	Gson gson = new Gson();
	Curriculo retorno = gson.fromJson(json, Curriculo.class);
	return retorno;
    }

    //le um arquivo e retorna um objeto curriculo
    protected static Curriculo arquivoPraCurriculo(FileReader arquivo){
	Gson gson = new Gson();
	Curriculo retorno = gson.fromJson(arquivo, Curriculo.class);
	return retorno;
    }

}
