package prenda;

import static java.util.Objects.requireNonNull;

import excepciones.PrendaIncompletaException;

public class BorradorPrenda {

  private TipoPrenda tipo;
  private Material material;
  private ColorRGB colorPrimario;
  private ColorRGB colorSecundario;
  private Trama trama;
  private Trama tramaDefault;
  private Double temperaturaMaxima;


  public BorradorPrenda(TipoPrenda tipo, Trama tramaDefault) {
    this.tipo = requireNonNull(tipo, "el tipo de prenda no puede ser nulo");
    this.tramaDefault = tramaDefault;
    this.trama = tramaDefault;
  }

  public void agregarMaterial(Material material) {
    this.material = material;
  }

  public void agregarColorPrimario(ColorRGB colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void agregarColorSecundario(ColorRGB colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void agregarTrama(Trama trama) {
    this.trama = trama == null ? tramaDefault : trama;
  }

  public void agregarTemperaturaMaxima(Double tempMax) {
    this.temperaturaMaxima = tempMax;
  }

  private void validarReglasDeCreacion() {
    if (material == null || colorPrimario == null) {
      throw new PrendaIncompletaException("prenda.Prenda invalida, "
          + "no se indico MATERIAL o COLOR PRIMARIO");
    }
  }

  public Prenda crearPrenda() {
    validarReglasDeCreacion();
    return new Prenda(tipo, material, colorPrimario, colorSecundario, trama, temperaturaMaxima);

  }

  public void agregarseARepoBorradores(RepositorioBorradores repositorioBorradores) {
    repositorioBorradores.agregarBorradorIncompleto(this);
  }
}
