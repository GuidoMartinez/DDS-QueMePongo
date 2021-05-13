public abstract class Diseniador {

  public Uniforme getUniforme() {
    return new Uniforme(crearPrendaSuperior(), crearPrendaInferior(), crearCalzado());
  }

  protected abstract Prenda crearPrendaSuperior();

  protected abstract Prenda crearCalzado();

  protected abstract Prenda crearPrendaInferior();

}
