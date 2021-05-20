package servicios;

public class ServicioClima {

  private ProveedorDeClima proveedor;

  public ServicioClima(ProveedorDeClima proveedor) {
    this.proveedor = proveedor;
  }

  public Double getProbabilidadDePrecipitaciones() {
    return proveedor.getProbabilidadDePrecipitaciones();
  }

  public Double getTemperatura() {
    return proveedor.getTemperatura();
  }

  public void setProveedor(ProveedorDeClima nuevoProveedor) {
    this.proveedor = nuevoProveedor;
  }


}
