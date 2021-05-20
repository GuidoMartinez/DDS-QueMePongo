package prenda;

public class Prenda {
  private TipoPrenda tipo;
  private Material material;
  private ColorRGB colorPrimario;
  private ColorRGB colorSecundario;
  private Trama trama;


  public Prenda(TipoPrenda tipo, Material material, ColorRGB colorPrimario,
                ColorRGB colorSecundario, Trama trama) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
  }

  public CategoriaPrenda getCategoria() {
    return tipo.getCategoria();
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Material getMaterial() {
    return material;
  }

  public ColorRGB getColorPrimario() {
    return colorPrimario;
  }

  public ColorRGB getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }
}
