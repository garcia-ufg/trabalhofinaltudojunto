package curriculoBack.curriculoBack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static simplesDB.sdb.*;
import simplesDB.Curriculo;
import simplesDB.Recebendo;

@RestController
public class editController{

    @PostMapping("/edit")
    public boolean editaCurriculoSeEleExistirEAAutenticacaoTiverCerta(@RequestBody Recebendo dados){
	//o método editaUsuario só edita o usuário se a autenticação, que ele verifica internamente, estiver certa.
	boolean retorno = editaUsuario(dados);
	if(retorno) System.out.println("Dados editados com sucesso");
	return retorno;
    }
}
