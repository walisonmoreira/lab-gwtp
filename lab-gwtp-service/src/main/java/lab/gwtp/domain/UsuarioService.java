package lab.gwtp.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

  public List<UsuarioVo> obterUsuarios() {
    log.debug("Executando serviço \"Obter Usuários\".");
    List<UsuarioVo> r = new ArrayList<UsuarioVo>();

    UsuarioVo u = new UsuarioVo();
    u.setIdentificacao("jose.maria");
    u.setSenha("123");

    r.add(u);

    u = new UsuarioVo();
    u.setIdentificacao("maria.jose");
    u.setSenha("abc");

    r.add(u);
    log.debug("Serviço \"Obter Usuários\" executado.");
    return r;
  }

}
