import java.util.ArrayList;
import java.util.List;
import prenda.Prenda;

public class Guardarropa {
  List<Prenda> prendas = new ArrayList<>();
  List<Recomendacion> recomendaciones = new ArrayList<>();

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public void agregarRecomendacion(Recomendacion recomendacion) {
    recomendaciones.add(recomendacion);
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public List<Recomendacion> getRecomendaciones() {
    return recomendaciones;
  }
}
