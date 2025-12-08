package curriculoBack.curriculoBack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;

@RestController
public class verUController{

    @GetMapping("/verU")
    public boolean verificaSeJaExisteEsseCara(@RequestParam(value = "cpf", defaultValue="0000000") String cpf){
	boolean retorno = noDiscoCPF(cpf);
	if(retorno) System.out.println("Curriculo já no banco de dados");
	return retorno;
    }

}
