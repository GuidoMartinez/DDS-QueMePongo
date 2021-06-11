package servicios;

import acciones.Alerta;

import java.util.Arrays;
import java.util.List;

public class ProveedorOtro implements ProveedorDeClima {

  public Integer getProbabilidadDePrecipitaciones() {
    return 0;
  }

  public Double getTemperaturaCelsius() {
    return 12.0;
  }

  public List<Alerta> getAlertasActuales() {
    return Arrays.asList(Alerta.GRANIZO, Alerta.TORMENTA);
  }
}
