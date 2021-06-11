package servicios;

import acciones.Alerta;

import java.util.List;

public interface ProveedorDeClima {

  Integer getProbabilidadDePrecipitaciones();

  Double getTemperaturaCelsius();

  List<Alerta> getAlertasActuales();

}
