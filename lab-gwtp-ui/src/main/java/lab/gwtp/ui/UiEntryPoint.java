package lab.gwtp.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import lab.gwtp.domain.UsuarioVo;

public class UiEntryPoint implements EntryPoint {
  public void onModuleLoad() {
    UsuarioVo usuarioVo = new UsuarioVo();
    usuarioVo.setIdentificacao("admin");
    Window.alert("Módulo \"Principal\" carregado!" + "\nUsuário = " + usuarioVo.getIdentificacao());
  }
}
