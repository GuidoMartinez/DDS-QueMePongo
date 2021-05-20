package servicios;

import java.util.*;

public class ServicioAccuWeather implements ProveedorDeClima {

  private static final String CIUDAD = "Buenos Aires, Argentina";

  private AccuWeatherAPI apiClima = new AccuWeatherAPI();
  private List<Map<String, Object>> condicionesClimaticas;

  public Double getProbabilidadDePrecipitaciones() {
    actualizarDatosClima();
    return (Double) condicionesClimaticas.get(0).get("PrecipitationProbability");
    //Devuelve un número del 0 al 1;
  }

  public Double getTemperatura() {
    actualizarDatosClima();
    return (Double) condicionesClimaticas.get(0).get("Temperature");
  } // TODO -- Parsear la respuesta del obj Temperatura y obtener Value y pasarlo de F a C


  private void actualizarDatosClima() {
    this.condicionesClimaticas =  apiClima.getWeather(CIUDAD);
  }



}
