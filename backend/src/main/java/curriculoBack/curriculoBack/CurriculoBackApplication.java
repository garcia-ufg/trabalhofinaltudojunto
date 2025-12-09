package curriculoBack.curriculoBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;

//a aplicação principal. Não faz muito. O caminho dos diretórios onde são guardados os dados é definido aqui.
@SpringBootApplication
public class CurriculoBackApplication {

    public static void main(String[] args) {


	boolean sucesso1 = setDados("./Dados/Jsons/");
	boolean sucesso2 = setFotos("./Dados/Fotos/");

	if(sucesso1) System.out.println("Diretório de dados encontrado");
	if(sucesso2) System.out.println("Diretório de fotos encontrado");


	SpringApplication.run(CurriculoBackApplication.class, args);
    }    

}
