import java.util.ArrayList;
import java.util.List;

public class Usuario {
  List<Guardarropa> guardarropas = new ArrayList<>();


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

}
