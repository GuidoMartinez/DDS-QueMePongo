package acciones;

import dominio.Usuario;

public class AvisoApp implements AccionAlertaMeteorologica {
  private NotificationService notificationService;

  public AvisoApp(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @Override
  public void alertar(Usuario usuario, Alerta alerta) {
    notificationService.notify(alerta.getDetalle());
  }
}
