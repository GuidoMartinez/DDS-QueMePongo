package uniforme;

import excepciones.CategoriaErroneaEnParteDePrendaException;
import java.util.Arrays;
import java.util.List;
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
    this.accesorio = accesorio.getCategoria() == CategoriaPrenda.ACCESORIOS ? accesorio : null;
  }
  // Se valida accesorio de esta manera ya que no es obligatorio, si categoria es
  // erronea , se nullea

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public Prenda getAccesorio() {
    return this.accesorio;
  }

  public List<Prenda> getPrendasAtuendo() {
    return Arrays.asList(parteSuperior, parteInferior, calzado, accesorio);
  }

  private Prenda validarPrenda(Prenda prenda, CategoriaPrenda categoria) {
    if (prenda.getCategoria() != categoria) {
      throw new CategoriaErroneaEnParteDePrendaException(
          categoria.toString() + " es obligatorio y debe ser de la categoria correcta");
    }
    return prenda;
  }
}
