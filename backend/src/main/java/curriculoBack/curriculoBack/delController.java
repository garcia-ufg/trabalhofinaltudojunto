package curriculoBack.curriculoBack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;
import simplesDB.Curriculo;

@RestController
public class delController{

    @PostMapping("/del")
    public boolean deletaCurriculoSeEleExistir(@RequestBody cpfSenha credenciais){
	String cpf = credenciais.cpf();
	String senha = credenciais.senha();

	boolean retorno = delUsuario(cpf, senha);
	if(retorno) System.out.println("Dados deletados.");
	return retorno;
    }
}
