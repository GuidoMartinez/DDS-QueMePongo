package uniforme;

import prenda.*;

public abstract class Diseniador {

  public Atuendo getUniforme() {
    return new Atuendo(crearPrendaSuperior(), crearPrendaInferior(), crearCalzado());
  }

  protected abstract Prenda crearPrendaSuperior();

  protected abstract Prenda crearCalzado();

  protected abstract Prenda crearPrendaInferior();

}
