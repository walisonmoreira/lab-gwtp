package lab.gwtp.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.gwtp.domain.UsuarioService;
import lab.gwtp.domain.UsuarioVo;

@RestController
public class UsuarioRest {

  private static final Logger log = LoggerFactory.getLogger(UsuarioRest.class);
  
  @Autowired
  private UsuarioService usuarioService;

  /**
   * Obter usuários.
   */
  @RequestMapping("/obterUsuarios")
  public List<UsuarioVo> obterUsuarios() {
    log.debug("Executando serviço rest \"Obter Usuários\".");
    List<UsuarioVo> usuarios = usuarioService.obterUsuarios();
    log.debug("Serviço rest \"Obter Usuários\" executado.");
    return usuarios;
  }

}