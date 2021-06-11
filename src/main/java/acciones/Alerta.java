package acciones;

public enum Alerta {
  GRANIZO("GRANIZO, evita salir con el auto"),
  TORMENTA("TORMENTA, recuerda llevar un paraguas");

  String detalle;

  Alerta(String detalle) {
    this.detalle = detalle;
  }

  public String getDetalle() {
    return detalle;
  }
}
