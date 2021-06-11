package dominio;

import acciones.AccionAlertaMeteorologica;
import acciones.Alerta;
import servicios.GeneradorSugerencias;
import uniforme.Atuendo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropas = new ArrayList<>();
  private String mail;
  private List<AccionAlertaMeteorologica> accionesAnteAlerta = new ArrayList<>();
  private Atuendo sugerencia;

  public Usuario(String mail, List<AccionAlertaMeteorologica> accionesAnteAlerta) {
    this.mail = mail;
    this.accionesAnteAlerta = accionesAnteAlerta;
  }

  public void recibirAlerta(Alerta alerta){
    accionesAnteAlerta.forEach(accion -> accion.alertar(this,alerta));
  }

  // Genero una sugerencia con las prendas del primer guardarropa en la lista de usuarios.
  // Para requerimiento 2, inyecto la lista de usuarios al empleado de QMP y genero la sugerencia para todos.
  public void generarSugerenciaDiaria(GeneradorSugerencias generadorSugerencias) {
  this.sugerencia = generadorSugerencias.getAtuendoSugeridoParaTemperaturaActual(guardarropas.get(0).getPrendas());
  }

















  public void agregarGuardarropa(Guardarropa guardarropa) {
    guardarropas.add(guardarropa);
  }

  public void agregarRecomendacion(Recomendacion recomendacion) {
    recomendacion.validarPrendaExisteEnGuardarropa();
    recomendacion.getGuardarropa().agregarRecomendacion(recomendacion);
  }

  private void quitarRecomendacion(Recomendacion recomendacion) {
    recomendacion.getGuardarropa().getRecomendaciones().remove(recomendacion);
  }

  public void aceptar(Recomendacion recomendacion) {
    recomendacion.aplicar();
    this.quitarRecomendacion(recomendacion);
  }

  public void rechazar(Recomendacion recomendacion) {
    this.quitarRecomendacion(recomendacion);
  }

  public List<Guardarropa> getGuardarropas() {
    return guardarropas;
  }


  public String getMail() {
    return mail;
  }
}
