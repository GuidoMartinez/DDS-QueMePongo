public class DiseniadorSanJuan implements  Diseniador {

  public Prenda crearPrendaSuperior() {

    BorradorPrenda borradorSuperior = new BorradorPrenda(TipoPrenda.CHOMBA, Trama.LISA);
    borradorSuperior.agregarMaterial(Material.PIQUE);
    borradorSuperior.agregarColorPrimario(new ColorRGB(0, 143, 57));
    return borradorSuperior.crearPrenda();
  }

  public Prenda crearPrendaInferior() {

    BorradorPrenda borradorInferior = new BorradorPrenda(TipoPrenda.PANTALON, Trama.LISA);
    borradorInferior.agregarMaterial(Material.ACETATO);
    borradorInferior.agregarColorPrimario(new ColorRGB(144, 144, 144));
    return borradorInferior.crearPrenda();
  }

  public Prenda crearCalzado() {

    BorradorPrenda borradorInferior = new BorradorPrenda(TipoPrenda.ZAPATILLAS, Trama.LISA);
    borradorInferior.agregarMaterial(Material.CUERO);
    // Se toma CUERO al no especificar material en requerimiento
    borradorInferior.agregarColorPrimario(new ColorRGB(252, 252, 252));
    return borradorInferior.crearPrenda();
  }
}
