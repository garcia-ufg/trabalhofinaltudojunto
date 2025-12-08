package curriculoBack.curriculoBack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;
import simplesDB.Curriculo;
import simplesDB.Enviando;

//manda os dados associaidos a um ID de usuário de volta para o frontend. Os dados são buscados por meio de uma querry 
@RestController
public class curController{

    @GetMapping("/cur")
    public Enviando mandaCurriculo(@RequestParam(value = "id", defaultValue="n") String id){

	Curriculo tmp = carregaCurriculoId(id);
	if(tmp != null){
	    Enviando retorno = curriculoPraEnviar(tmp);
	    System.out.println("Dados de currículo enviados.");
	    return retorno;
	}
	return null;       
    }

}
