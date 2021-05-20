package prenda;

public enum TipoPrenda {
  ZAPATOS(CategoriaPrenda.CALZADO),
  CAMISA(CategoriaPrenda.PARTE_SUPERIOR),
  PANTALON(CategoriaPrenda.PARTE_INFERIOR),
  REMERA(CategoriaPrenda.PARTE_SUPERIOR),
  GAFAS(CategoriaPrenda.ACCESORIOS),
  CHOMBA(CategoriaPrenda.PARTE_SUPERIOR),
  ZAPATILLAS(CategoriaPrenda.CALZADO);

  TipoPrenda(CategoriaPrenda categoria) {
    this.categoria = categoria;
  }

  private CategoriaPrenda categoria;

  public CategoriaPrenda getCategoria() {
    return this.categoria;
  }
}
