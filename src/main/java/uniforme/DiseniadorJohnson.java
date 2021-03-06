package uniforme;

import prenda.*;

public class DiseniadorJohnson extends Diseniador {

  protected Prenda crearPrendaSuperior() {

    BorradorPrenda borradorSuperior = new BorradorPrenda(TipoPrenda.CAMISA, Trama.LISA);
    borradorSuperior.agregarMaterial(Material.ALGODON);
    // Se toma ALGODON al no especificar material en requerimiento
    borradorSuperior.agregarColorPrimario(new ColorRGB(252, 252, 252));
    return borradorSuperior.crearPrenda();
  }

  protected Prenda crearPrendaInferior() {

    BorradorPrenda borradorInferior = new BorradorPrenda(TipoPrenda.PANTALON, Trama.LISA);
    borradorInferior.agregarMaterial(Material.TELA);
    // Se toma TELA al no especificar material en requerimiento
    borradorInferior.agregarColorPrimario(new ColorRGB(28, 28, 28));
    return borradorInferior.crearPrenda();
  }

  protected Prenda crearCalzado() {

    BorradorPrenda borradorInferior = new BorradorPrenda(TipoPrenda.ZAPATOS, Trama.LISA);
    borradorInferior.agregarMaterial(Material.CUERO);
    // Se toma CUERO al no especificar material en requerimiento
    borradorInferior.agregarColorPrimario(new ColorRGB(28, 28, 28));
    return borradorInferior.crearPrenda();
  }


}
