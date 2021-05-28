import prenda.Prenda;

public class AgregarPrenda extends Recomendacion {

  public AgregarPrenda(Prenda prenda, Guardarropa guardarropa) {
    super(prenda, guardarropa);
  }

  public void aplicar() {
    guardarropa.agregarPrenda(prenda);
  }

  public void validarPrendaExisteEnGuardarropa() {
  }


}
