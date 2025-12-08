package curriculoBack.curriculoBack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;
import simplesDB.Curriculo;

@RestController
public class authController{

    @PostMapping("/auth")
    public boolean dizSeASenhaTaCerta(@RequestBody cpfSenha dados){

	String cpf = dados.cpf();
	String senha = dados.senha();
	boolean retorno = autenticaUsuario(cpf, senha);
	return retorno;

    }

}


