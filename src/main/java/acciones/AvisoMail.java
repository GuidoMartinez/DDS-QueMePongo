package acciones;

import dominio.Usuario;

public class AvisoMail implements AccionAlertaMeteorologica {
  private MailSender sender;

  public AvisoMail(MailSender sender) {
    this.sender = sender;
  }

  @Override
  public void alertar(Usuario usuario, Alerta alerta) {
    sender.send(usuario.getMail(), alerta.getDetalle());
  }
}
