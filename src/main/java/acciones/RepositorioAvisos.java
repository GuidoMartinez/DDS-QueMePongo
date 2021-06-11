package acciones;

import dominio.Usuario;
import servicios.ProveedorDeClima;
import servicios.ServicioClima;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAvisos {

  private List<Usuario> suscriptores = new ArrayList<>();
  private ServicioClima servicioClima;
  private List<Alerta> ultimasAlertas = new ArrayList<>();

  public RepositorioAvisos(ServicioClima servicio) {
    this.servicioClima = servicio;
  }

  public void suscribirse(Usuario usuario) {
    suscriptores.add(usuario);
  }

  public void desuscribirse(Usuario usuario) {
    suscriptores.remove(usuario);
  }

  // Actualizo al lista de alertas y notifico a los usuarios interesados para disparar las acciones configuradas
  public void actualizarAlertas(String ciudad) {
    this.ultimasAlertas = servicioClima.getAlertasActuales();
    informarAlertasSuscriptores(ultimasAlertas);
  }

  private void informarAlertasSuscriptores(List<Alerta> alertas) {
    int cantidadAlertas = alertas.size();

    // No encontre como iterar con un doble forEach (por cada alerta, mandarle un mensaje a cada usuario)
    for (int iterador = 0; iterador < cantidadAlertas; iterador++) {
      suscriptores.forEach(suscriptor -> suscriptor.recibirAlerta(alertas.get(0)));
    }
  }

  public List<Usuario> getSuscriptores() {
    return suscriptores;
  }

  public List<Alerta> getUltimasAlertas() {
    return ultimasAlertas;
  }
}
