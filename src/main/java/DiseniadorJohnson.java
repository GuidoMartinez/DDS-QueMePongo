public class DiseniadorJohnson implements  Diseniador {

  public Prenda crearPrendaSuperior() {

    BorradorPrenda borradorSuperior = new BorradorPrenda(TipoPrenda.CAMISA);
    borradorSuperior.agregarMaterial(Material.ALGODON);
    // Se toma ALGODON al no especificar material en requerimiento
    borradorSuperior.agregarColorPrimario(new ColorRGB(252, 252, 252));
    return borradorSuperior.crearPrenda();
  }

  public Prenda crearPrendaInferior() {

    BorradorPrenda borradorInferior = new BorradorPrenda(TipoPrenda.PANTALON);
    borradorInferior.agregarMaterial(Material.TELA);
    // Se toma TELA al no especificar material en requerimiento
    borradorInferior.agregarColorPrimario(new ColorRGB(28, 28, 28));
    return borradorInferior.crearPrenda();
  }

  public Prenda crearCalzado() {

    BorradorPrenda borradorInferior = new BorradorPrenda(TipoPrenda.ZAPATOS);
    borradorInferior.agregarMaterial(Material.CUERO);
    // Se toma CUERO al no especificar material en requerimiento
    borradorInferior.agregarColorPrimario(new ColorRGB(28, 28, 28));
    return borradorInferior.crearPrenda();
  }


}
