public class Uniforme {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = validarPrenda(parteSuperior, CategoriaPrenda.PARTE_SUPERIOR);
    this.parteInferior = validarPrenda(parteInferior, CategoriaPrenda.PARTE_INFERIOR);
    this.calzado = validarPrenda(calzado, CategoriaPrenda.CALZADO);
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

}
