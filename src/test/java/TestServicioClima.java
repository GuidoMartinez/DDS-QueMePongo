import static org.mockito.Mockito.*;

import excepciones.NoSePuedeObtenerInfoDelServicioDeClimaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servicios.ServicioAccuWeather;
import servicios.ServicioClima;

public class TestServicioClima {

    ServicioClima servicioClima = new ServicioClima(new ServicioAccuWeather());
    ServicioAccuWeather mockAccuWeather = mock(ServicioAccuWeather.class);


  // Se prueba de esta manera al ser estatico, se llama 2 veces a la API por test ya que
  // no se parsea la respuesta a un objeto
  @DisplayName("Servicio AccuWeather devuelve 13,89 grados y 0 de probabilidadDePrecipitaciones ")
  @Test
  void servicioAccuWeatherDevuelveCondicionesClimaticas() {
    Assertions.assertEquals(0,servicioClima.getProbabilidadDePrecipitaciones());
    Assertions.assertEquals(14,servicioClima.getTemperatura());

  }

  @DisplayName("El proveedor de clima no puede ser null, arroja exception")
  @Test
  void siElProveedorClimaSeSeteaNulloArrojaException(){

    Assertions.assertThrows(NullPointerException.class, () -> servicioClima.setProveedor(null));
    Assertions.assertThrows(NullPointerException.class, () -> new ServicioClima(null));
  }

  @Test
  void siFallaConexionAPIArrojaExcepction(){
    when(mockAccuWeather.getTemperaturaCelsius()).thenThrow(new RuntimeException("API off"));
    servicioClima.setProveedor(mockAccuWeather);

    Assertions.assertThrows(NoSePuedeObtenerInfoDelServicioDeClimaException.class,
        () ->  servicioClima.getTemperatura());

    verify(mockAccuWeather,times(1)).getTemperaturaCelsius();

  }

}
