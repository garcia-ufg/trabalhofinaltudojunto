package curriculoBack.curriculoBack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;
import simplesDB.Curriculo;
import simplesDB.Recebendo;

@RestController
public class novController{

    @PostMapping("/nov")
    public boolean gravaCurriculoNoDisco(@RequestBody Recebendo inf){
	//internamente, salvaCurriculo já converte um Recebendo em um currículo e escreve ele no disco.
	boolean retorno = novoUsuario(inf);
	if(retorno) System.out.println("Novo usuário registrado.");
	return retorno;
    }
}
