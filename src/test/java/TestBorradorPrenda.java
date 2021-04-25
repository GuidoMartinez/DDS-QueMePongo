import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class TestBorradorPrenda {

  @Test
  @DisplayName("Al instanciar un BorradorPrenda sin TipoPrenda, arroja una excepcion")
  void TipoPrendaNullArrojaNullPointerException() {
    Assertions.assertThrows(NullPointerException.class,
        () -> new BorradorPrenda(null));
  }

  @Test
  @DisplayName("Si no indico una trama, o la nulleo, por defecto es lisa")
  void tramaSinEspecificarEsLISA() {
    BorradorPrenda borradorTramaNull = borradorPrendaValidaSinTrama();
    borradorTramaNull.agregarTrama(null);
    Prenda prendaLISA = borradorTramaNull.crearPrenda();

    assertEquals(borradorPrendaValidaSinTrama().crearPrenda().getTrama(), Trama.LISA);
    assertEquals(prendaLISA.getTrama(), Trama.LISA);

  }

  @Test
  @DisplayName("Si el borrador no tiene seteado el colorPrimario no puedo crear una prenda")
  void borradorSinColorPrimarioNoCreaPrenda() {

    assertThrows(PrendaIncompletaException.class, () -> borradorSinColorPrimario().crearPrenda());
  }

  @Test
  @DisplayName("Si el borrador no tiene seteado el Material no puedo crear una prenda")
  void borradorSinMaterialNoCreaPrenda() {

    assertThrows(PrendaIncompletaException.class, () -> borradorSinMaterial().crearPrenda());
  }


  private BorradorPrenda borradorPrendaValidaSinTrama() {
    BorradorPrenda prendaCreable = new BorradorPrenda(TipoPrenda.CAMISA);
    prendaCreable.agregarColorPrimario(new ColorRGB(0,10,20));
    prendaCreable.agregarMaterial(Material.ALGODON);

    return prendaCreable;
  }

  private BorradorPrenda borradorSinColorPrimario() {
    BorradorPrenda sinColorPrimario = new BorradorPrenda(TipoPrenda.PANTALON);
    sinColorPrimario.agregarMaterial(Material.ALGODON);

    return sinColorPrimario;
  }

  private BorradorPrenda borradorSinMaterial() {
    BorradorPrenda sinMaterial = new BorradorPrenda(TipoPrenda.CAMISA);
    sinMaterial.agregarColorPrimario(new ColorRGB(0,10,20));
    sinMaterial.agregarColorSecundario(new ColorRGB(20,30,50));

    return sinMaterial;
  }
}
