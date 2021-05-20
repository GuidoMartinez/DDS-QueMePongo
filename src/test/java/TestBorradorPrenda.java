import excepciones.PrendaIncompletaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prenda.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBorradorPrenda {

  @Test
  @DisplayName("Al instanciar un prenda.BorradorPrenda sin prenda.TipoPrenda, arroja una excepcion")
  void TipoPrendaNullArrojaNullPointerException() {
    Assertions.assertThrows(NullPointerException.class,
        () -> new BorradorPrenda(null, Trama.LISA));
  }

  @Test
  @DisplayName("Si no indico una trama para la prenda en creacion, por defecto es la indicada en el constructor")
  void tramaSinEspecificarEnConstruccionEsLISA() {

    Assertions.assertEquals(borradorPrendaValidaSinTramaSeteadaEnConstruccion(Trama.LISA)
        .crearPrenda().getTrama(), Trama.LISA);
   }

  @Test
  @DisplayName("Si seteo null la trama, devuelve la default")
  void siNulleoLaTramaDevuelveTramaDefault() {
    BorradorPrenda borradorTramaNull = borradorPrendaValidaSinTramaSeteadaEnConstruccion(Trama.CUADROS);
    borradorTramaNull.agregarTrama(null);
    Prenda prendaLISA = borradorTramaNull.crearPrenda();

    Assertions.assertEquals(prendaLISA.getTrama(), Trama.CUADROS);

  }

  @Test
  @DisplayName("Si el borrador no tiene seteado el colorPrimario no puedo crear una prenda")
  void borradorSinColorPrimarioNoCreaPrenda() {

    Assertions.assertThrows(PrendaIncompletaException.class, () -> borradorSinColorPrimario().crearPrenda());
  }

  @Test
  @DisplayName("Si el borrador no tiene seteado el prenda.Material no puedo crear una prenda")
  void borradorSinMaterialNoCreaPrenda() {

    Assertions.assertThrows(PrendaIncompletaException.class, () -> borradorSinMaterial().crearPrenda());
  }

  @DisplayName("Puedo guardar un borradorPrenda y verificar que existe en el repo para recuperarlo")
  @Test
  void agregarBorradorARepositorioBorradoresYValidarQueSeGuardaOK(){
    BorradorPrenda borradorAGuardar = borradorPrendaValidaSinTramaSeteadaEnConstruccion(Trama.LISA);
    borradorAGuardar.agregarseARepoBorradores(repositorioBorradores);

    Assertions.assertTrue(repositorioBorradores.getBorradoresIncompletos().contains(borradorAGuardar));
    }


  private BorradorPrenda borradorPrendaValidaSinTramaSeteadaEnConstruccion(Trama tramaDefault) {
    BorradorPrenda prendaCreableConTramaDefaultParametrizada= new BorradorPrenda(TipoPrenda.CAMISA, tramaDefault);
    prendaCreableConTramaDefaultParametrizada.agregarColorPrimario(new ColorRGB(0,10,20));
    prendaCreableConTramaDefaultParametrizada.agregarMaterial(Material.ALGODON);

    return prendaCreableConTramaDefaultParametrizada;
  }

  private BorradorPrenda borradorSinColorPrimario() {
    BorradorPrenda BorradorsinColorPrimario = new BorradorPrenda(TipoPrenda.PANTALON, Trama.LISA);
    BorradorsinColorPrimario.agregarMaterial(Material.ALGODON);

    return BorradorsinColorPrimario;
  }

  private BorradorPrenda borradorSinMaterial() {
    BorradorPrenda BorradorsinMaterial = new BorradorPrenda(TipoPrenda.CAMISA, Trama.LISA);
    BorradorsinMaterial.agregarColorPrimario(new ColorRGB(0,10,20));
    BorradorsinMaterial.agregarColorSecundario(new ColorRGB(20,30,50));

    return BorradorsinMaterial;
  }

  private final RepositorioBorradores repositorioBorradores = new RepositorioBorradores();

}
