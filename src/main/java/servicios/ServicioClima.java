package servicios;

import static java.util.Objects.requireNonNull;

import acciones.Alerta;
import excepciones.NoSePuedeObtenerInfoDelServicioDeClimaException;

import java.util.List;

public class ServicioClima {

  private ProveedorDeClima proveedor;

  public ServicioClima(ProveedorDeClima proveedor) {
    this.proveedor = requireNonNull(proveedor, "El proveedor de clima es obligatorio");
  }

  public Integer getProbabilidadDePrecipitaciones() {
    return proveedor.getProbabilidadDePrecipitaciones();
  }

  public Double getTemperatura() {
    try {
      return proveedor.getTemperaturaCelsius();
    } catch (Exception e) {
      throw new NoSePuedeObtenerInfoDelServicioDeClimaException(
          "No es posible obtener info de la temperatura del proveedor " + proveedor.toString());
    }// Aca podria seter un otro proveedor de clima para recuperarme del error
  }

  public List<Alerta> getAlertasActuales() {
    return this.proveedor.getAlertasActuales();
  }

  public void setProveedor(ProveedorDeClima nuevoProveedor) {
    this.proveedor = requireNonNull(nuevoProveedor, "El proveedor de clima es obligatorio");
  }


}
