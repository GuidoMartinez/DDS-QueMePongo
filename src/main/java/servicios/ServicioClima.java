package servicios;

import excepciones.NoSePuedeObtenerInfoDelServicioDeClimaException;

public class ServicioClima {

  private ProveedorDeClima proveedor;

  public ServicioClima(ProveedorDeClima proveedor) {
    this.proveedor = proveedor;
  }

  public Double getProbabilidadDePrecipitaciones() {
    return proveedor.getProbabilidadDePrecipitaciones();
  }

  public Double getTemperatura() {
    try {
      return proveedor.getTemperatura();
    }
    catch (Exception e) {
      throw new NoSePuedeObtenerInfoDelServicioDeClimaException(
          "No es posible obtener info de la temperuta del proveedor " +proveedor.toString());
    }

  }

  public void setProveedor(ProveedorDeClima nuevoProveedor) {
    this.proveedor = nuevoProveedor;
  }


}
