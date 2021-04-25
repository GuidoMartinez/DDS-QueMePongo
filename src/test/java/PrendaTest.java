import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  @Test
  void laCategoriaDeUnZAPATOesCALZADO() {
    assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.ZAPATOS).getCategoria(), CategoriaPrenda.CALZADO);
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

  private Prenda prendaDeCueroYColorPrimario(TipoPrenda tipo) {

    return new Prenda(tipo, Material.CUERO,new ColorRGB(15,15,15), null, null);
  }

}
