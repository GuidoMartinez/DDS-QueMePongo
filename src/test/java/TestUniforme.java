import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUniforme {

  @Test
  @DisplayName("Prenda inferior del uniforme de Johnson se obtiene de manera correcta")
  void laParteInferiorDeJohnsonEsUnPatalonDeVestirNegro() {
    Uniforme uniJohnson = new DiseniadorJohnson().getUniforme();

    assertEquals(uniJohnson.getParteInferior().getTipo(),TipoPrenda.PANTALON);
    assertEquals(uniJohnson.getParteInferior().getMaterial(),Material.TELA);
    assertEquals(uniJohnson.getParteInferior().getColorPrimario().getRed(),28);
    assertEquals(uniJohnson.getParteInferior().getColorPrimario().getGreen(),28);
    assertEquals(uniJohnson.getParteInferior().getColorPrimario().getBlue(),28);

  }

  @Test
  @DisplayName("Prenda superior del uniforme de San Juan se obtiene de manera correcta")
  void laParteSuperiorDeSanJuanEsUnChombaVerdeDePique() {
    Uniforme uniSanJuan = new DiseniadorSanJuan().getUniforme();

    assertEquals(uniSanJuan.getParteSuperior().getTipo(),TipoPrenda.CHOMBA);
    assertEquals(uniSanJuan.getParteSuperior().getMaterial(),Material.PIQUE);
    assertEquals(uniSanJuan.getParteSuperior().getColorPrimario().getRed(),0);
    assertEquals(uniSanJuan.getParteSuperior().getColorPrimario().getGreen(),143);
    assertEquals(uniSanJuan.getParteSuperior().getColorPrimario().getBlue(),57);
  }

  @Test
  @DisplayName("Un uniforme siempre tiene una Prenda Superior, Inferior y Calzado")
  void UniformeConPrendaNullArrojaNullPointerException() {
    Assertions.assertThrows(NullPointerException.class,
        () -> new Uniforme(null, prendaInferior(), prendaCalzado()));

    Assertions.assertThrows(NullPointerException.class,
        () -> new Uniforme(prendaSuperior(), null, prendaCalzado()));

    Assertions.assertThrows(NullPointerException.class,
        () -> new Uniforme(prendaSuperior(), prendaInferior(), null));
  }

  @Test
  @DisplayName("No puedo construir Uniformes con prendas de categorias incorrectas")
  void siConstruyoUnUniformeConPrendasDeCategoriaErroneaArrojaExcepcion() {
    Assertions.assertThrows(CategoriaErroneaEnParteDePrendaException.class,
        () -> new Uniforme(prendaInferior(), prendaInferior(), prendaCalzado()));

    Assertions.assertThrows(CategoriaErroneaEnParteDePrendaException.class,
        () -> new Uniforme(prendaSuperior(), prendaCalzado(), prendaCalzado()));

    Assertions.assertThrows(CategoriaErroneaEnParteDePrendaException.class,
        () -> new Uniforme(prendaSuperior(), prendaInferior(), prendaInferior()));

  }

  private Prenda prendaSuperior() {
    return new Prenda(TipoPrenda.CAMISA, Material.ALGODON, new ColorRGB(10,10,10),
        null, Trama.ESTAMPA);
  }

  private Prenda prendaInferior() {
    return new Prenda(TipoPrenda.PANTALON, Material.ALGODON, new ColorRGB(55,55,55),
        null, Trama.ESTAMPA);
  }

  private Prenda prendaCalzado() {
    return new Prenda(TipoPrenda.ZAPATOS, Material.CUERO, new ColorRGB(55,55,55),
        null, Trama.LISA);
  }

}
