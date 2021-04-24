import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  @Test
  void laCategoriaDeUnZAPATOesCALZADO() {
    assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.ZAPATO).getCategoria(), CategoriaPrenda.CALZADO);
  }
  @Test
  void laCategoriaDeUnPANTALONesPARTE_INFERIOR() {
    assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.PANTALON).getCategoria(), CategoriaPrenda.PARTE_INFERIOR);
  }
  @Test
  void laCategoriaDeUnaCAMISAesPARTE_SUPERIOR() {
    assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.CAMISA).getCategoria(), CategoriaPrenda.PARTE_SUPERIOR);
  }
  @Test
  void laCategoriaDeUnaREMERAesPARTE_SUPERIOR() {
    assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.REMERA).getCategoria(), CategoriaPrenda.PARTE_SUPERIOR);
  }
  @Test
  void unaPrendaSinTipoNoPuedeSerCreada() {
    Assertions.assertThrows(PrendaIncompletaException.class,
        () -> prendaDeCueroYColorPrimario(null));
  }
  @Test
  void unaPrendaSinMaterialNoPuedeSerCreada() {
    Assertions.assertThrows(PrendaIncompletaException.class,
        () -> new Prenda(TipoPrenda.CAMISA,null,new ColorRGB(5,5,5)));
  }
  @Test
  void unaPrendaSinColorPrimarioNoPuedeSerCreada() {
    Assertions.assertThrows(PrendaIncompletaException.class,
        () -> new Prenda(TipoPrenda.CAMISA,MaterialPrenda.ALGODON,null));
  }


  private Prenda prendaDeCueroYColorPrimario(TipoPrenda tipo) {

    return new Prenda(tipo,MaterialPrenda.CUERO,new ColorRGB(15,15,15));
  }

}
