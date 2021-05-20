import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import prenda.*;

public class PrendaTest {

  @Test
  void laCategoriaDeUnZAPATOesCALZADO() {
    Assertions.assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.ZAPATOS).getCategoria(), CategoriaPrenda.CALZADO);
  }
  @Test
  void laCategoriaDeUnPANTALONesPARTE_INFERIOR() {
    Assertions.assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.PANTALON).getCategoria(), CategoriaPrenda.PARTE_INFERIOR);
  }
  @Test
  void laCategoriaDeUnaCAMISAesPARTE_SUPERIOR() {
    Assertions.assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.CAMISA).getCategoria(), CategoriaPrenda.PARTE_SUPERIOR);
  }
  @Test
  void laCategoriaDeUnaREMERAesPARTE_SUPERIOR() {
    Assertions.assertEquals(prendaDeCueroYColorPrimario(TipoPrenda.REMERA).getCategoria(), CategoriaPrenda.PARTE_SUPERIOR);
  }

  private Prenda prendaDeCueroYColorPrimario(TipoPrenda tipo) {

    return new Prenda(tipo, Material.CUERO,new ColorRGB(15,15,15),
        null, null, null);
  }

}
