import prenda.Prenda;

public abstract class Recomendacion {
  protected Prenda prenda;
  protected Guardarropa guardarropa;

  protected Recomendacion(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  public abstract void aplicar();

  public void deshacer() {
    // TODO
    // Hay una mejor opcion a tener una lista adicional de recomendaciones aceptadas en el guardarropas y
    // de ahi tirarle el deshacer? Es decir, pasarla de la lista de recomendaciones a ListaRecoAceptadas
    // Donde cada subclase si se quito, la agrega, y si la agrego, la quita?
    // Obtengo cada recomendacion y este metodo al contar con ambos atributos tiene la info necesaria para hacerlo
  }

  public Prenda getPrenda() {
    return prenda;
  }

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }

  public abstract void validarPrendaExisteEnGuardarropa();

}
