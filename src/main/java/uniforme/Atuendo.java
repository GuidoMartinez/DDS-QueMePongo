package uniforme;

import excepciones.CategoriaErroneaEnParteDePrendaException;
import prenda.*;


public class Atuendo {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;
  private Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = validarPrenda(parteSuperior, CategoriaPrenda.PARTE_SUPERIOR);
    this.parteInferior = validarPrenda(parteInferior, CategoriaPrenda.PARTE_INFERIOR);
    this.calzado = validarPrenda(calzado, CategoriaPrenda.CALZADO);
  }

  // Se sobrecarga constructor para requerimiento de Sugerencias de iteracion 4
  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio) {
    this.parteSuperior = validarPrenda(parteSuperior, CategoriaPrenda.PARTE_SUPERIOR);
    this.parteInferior = validarPrenda(parteInferior, CategoriaPrenda.PARTE_INFERIOR);
    this.calzado = validarPrenda(calzado, CategoriaPrenda.CALZADO);
    this.accesorio = validarAccesorio(accesorio);
  }

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  private Prenda validarPrenda(Prenda prenda, CategoriaPrenda categoria) {
    if (prenda.getCategoria() != categoria) {
      throw new CategoriaErroneaEnParteDePrendaException(
          categoria.toString() + " es obligatorio y debe ser de la categoria correcta");
    }
    return prenda;
  }

  // se utiliza otra validacion ya que los Uniformes creados por los Disenadores no tienen accesorio
  private Prenda validarAccesorio(Prenda accesorio) {
    if (accesorio.getCategoria() == CategoriaPrenda.ACCESORIOS || accesorio == null) {
      return accesorio;
    }
    throw new CategoriaErroneaEnParteDePrendaException(
        "ACCESORIO debe ser de la categoria correcta");
  }

}
