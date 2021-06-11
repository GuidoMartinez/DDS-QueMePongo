package dominio;

import excepciones.PrendaNoExisteEnGuardarropaException;
import prenda.Prenda;

public class QuitarPrenda extends Recomendacion {

  public QuitarPrenda(Prenda prenda, Guardarropa guardarropa) {
    super(prenda, guardarropa);
  }

  public void aplicar() {
    validarPrendaExisteEnGuardarropa();
    guardarropa.quitarPrenda(prenda);
  }

  //Se valida tanto al agregar la recomendacion al guadarropa como al momento asincronico de aceptar
  // la misma, en caso que el usuario la haya eliminado antes de haber visto la misma
  public void validarPrendaExisteEnGuardarropa() {
    if (!guardarropa.getPrendas().contains(prenda)) {
      throw new PrendaNoExisteEnGuardarropaException(
          "La prenda que recomiendas quitar no se encuentra en el guardarropas indicado");
    }
  }

}
