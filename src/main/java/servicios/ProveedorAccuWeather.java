package servicios;

import java.util.*;

import static java.lang.Math.round;


public class ServicioAccuWeather implements ProveedorDeClima {

  private static final String CIUDAD = "Buenos Aires, Argentina";

  private AccuWeatherAPI apiClima = new AccuWeatherAPI();
  private List<Map<String, Object>> condicionesClimaticas;

  public Integer getProbabilidadDePrecipitaciones() {
    actualizarDatosClima();
    return (Integer) condicionesClimaticas.get(0).get("PrecipitationProbability");
    //Devuelve un número del 0 al 1;
  }

  public Double getTemperaturaCelsius() {
    actualizarDatosClima();
    Map<String, Object> temp = (Map<String, Object>) condicionesClimaticas
        .get(0).get("Temperature");
    return fahrenheitToCelsius((Integer) temp.get("Value"));
  }

  private void actualizarDatosClima() {
    this.condicionesClimaticas =  apiClima.getWeather(CIUDAD);
  }

  private double fahrenheitToCelsius(Integer tempF) {
    return round((tempF - 32) * (5.0 / 9.0));
  } // Devuelve 14
}
