public class Prenda {
  private TipoPrenda tipo;
  private MaterialPrenda material;
  private ColorRGB colorPrimario;
  private ColorRGB colorSecundario;


  public Prenda(TipoPrenda tipo, MaterialPrenda material, ColorRGB colorPrimario) {

    try {
      validarCreacion(tipo, material, colorPrimario);
      this.tipo = tipo;
      this.material = material;
      this.colorPrimario = colorPrimario;

    } catch (PrendaIncompletaException e) {
      throw new PrendaIncompletaException("Debe especificarse el tipo, material y colorPrimario");
    }
  } // Validar una excepcion en el constructor me hace ruido, pero implementar un Builder me parece sumar
  // mucha complejidad para los requerimientos actuales


  private void validarCreacion(TipoPrenda tipo, MaterialPrenda material, ColorRGB colorPrimario) {
    if (tipo == null || material == null || colorPrimario == null) {
      throw new PrendaIncompletaException("Prenda invalida");
    }
  }


  public void setColorSecundario(ColorRGB colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public CategoriaPrenda getCategoria() {
    return tipo.getCategoria();
  }

  public MaterialPrenda getMaterial() {
    return material;
  }

  public ColorRGB getColorPrimario() {
    return colorPrimario;
  }

  public ColorRGB getColorSecundario() {
    return colorSecundario;
  }
}
