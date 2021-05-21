import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prenda.CategoriaPrenda;
import prenda.Prenda;
import prenda.TipoPrenda;
import servicios.GeneradorSugerencias;
import servicios.ProveedorAccuWeather;
import servicios.ServicioClima;
import uniforme.Atuendo;

import java.util.Arrays;
import java.util.List;


public class TestSugerencias {

  // setup
  ProveedorAccuWeather servAccuWeatherMock = mock(ProveedorAccuWeather.class);
  ServicioClima servicioClima = new ServicioClima(servAccuWeatherMock);
  GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(servicioClima);

  // prendas fixture
  Prenda remera = generarPrenda(TipoPrenda.REMERA, 40.0);
  Prenda remeraMangaLarga = generarPrenda(TipoPrenda.REMERA_MANGA_LARGA, 20.0);
  Prenda cortoDeportivo = generarPrenda(TipoPrenda.CORTO_DEPORTIVO, 40.0);
  Prenda pantalon = generarPrenda(TipoPrenda.PANTALON, 20.0);
  Prenda ojotas = generarPrenda(TipoPrenda.OJOTAS, 40.0);
  Prenda pantuflas = generarPrenda(TipoPrenda.PANTUFLAS, 20.0);
  Prenda gafas = generarPrenda(TipoPrenda.GAFAS, 20.0);
  Prenda gorroLana = generarPrenda(TipoPrenda.GORRO_LANA, 20.0);

  List<Prenda> guardarropa = Arrays.asList(remera,remeraMangaLarga,
      cortoDeportivo,pantalon,ojotas,pantuflas,gafas,gorroLana);



  @DisplayName("Genero sugerencias sin restriccion de temperatura")
  @Test
  void sugerenciaSinRestriccionDeTemperatura() {
    Atuendo sugerencia = generadorSugerencias.getAtuendoSugerido(guardarropa);

    Assertions.assertTrue(guardarropa.stream()
        .filter(prenda -> prenda.getCategoria().equals(CategoriaPrenda.PARTE_SUPERIOR)).
            anyMatch(prenda -> prenda.equals(sugerencia.getParteSuperior())));

    Assertions.assertTrue(guardarropa.stream()
        .filter(prenda -> prenda.getCategoria().equals(CategoriaPrenda.PARTE_INFERIOR)).
            anyMatch(prenda -> prenda.equals(sugerencia.getParteInferior())));

    Assertions.assertTrue(guardarropa.stream()
        .filter(prenda -> prenda.getCategoria().equals(CategoriaPrenda.CALZADO)).
            anyMatch(prenda -> prenda.equals(sugerencia.getCalzado())));

    Assertions.assertTrue(guardarropa.stream()
        .filter(prenda -> prenda.getCategoria().equals(CategoriaPrenda.ACCESORIOS)).
            anyMatch(prenda -> prenda.equals(sugerencia.getAccesorio())));

  }

  @DisplayName("Genero sugerencia con prendas aptas para la temperatura indicada")
  @Test
  void sugerenciasConPrendasQueCumplenTemperaturaMaxima30C() {

    when(servAccuWeatherMock.getTemperaturaCelsius()).thenReturn(30.0);
    servicioClima.setProveedor(servAccuWeatherMock);

    Atuendo sugerencia = generadorSugerencias.getAtuendoSugeridoParaTemperaturaActual(guardarropa);

    Assertions.assertTrue(sugerencia.getPrendasAtuendo().stream()
        .allMatch(prenda -> prenda.getTemperaturaMaxima() <= servicioClima.getTemperatura()));
  } // llamo dos veces al servicio de clima ya que lo tengo mockeado, sino guardaria su valor
  // y compararia sobre ese atributo.



  private Prenda generarPrenda(TipoPrenda tipoPrenda, Double tempMax) {
    return new Prenda(tipoPrenda,null,null,null,null,tempMax);
  }

}
