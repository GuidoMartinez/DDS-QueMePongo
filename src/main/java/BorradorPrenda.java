import static java.util.Objects.requireNonNull;

public class BorradorPrenda {
  private TipoPrenda tipo;
  private Material material;
  private ColorRGB colorPrimario;
  private ColorRGB colorSecundario;
  private Trama trama = Trama.LISA;

  public BorradorPrenda(TipoPrenda tipo) {
    this.tipo = requireNonNull(tipo, "el tipo de prenda no puede ser nulo");
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public void setColorPrimario(ColorRGB colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void setColorSecundario(ColorRGB colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama trama) {
    if (trama == null) {
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }

  private void validarReglasDeCreacion() {
    if (material == null || colorPrimario == null) {
      throw new PrendaIncompletaException("Prenda invalida, no se indico MATERIAL o COLOR PRIMARIO");
    }
  }

  public Prenda crearPrenda() {
    validarReglasDeCreacion();
    return new Prenda(tipo, material, colorPrimario, colorSecundario, trama);

  }
}
