package lab.gwtp.domain;

public class UsuarioVo {

  private String identificacao;

  private String senha;

  /**
   * @see UsuarioVo#identificacao
   */
  public String getIdentificacao() {
    return identificacao;
  }

  /**
   * @see UsuarioVo#identificacao
   */
  public void setIdentificacao(String identificacao) {
    this.identificacao = identificacao;
  }

  /**
   * @see UsuarioVo#senha
   */
  public String getSenha() {
    return senha;
  }

  /**
   * @see UsuarioVo#senha
   */
  public void setSenha(String senha) {
    this.senha = senha;
  }
}
