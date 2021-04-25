import static java.util.Objects.requireNonNull;

public class Uniforme {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = requireNonNull(parteSuperior, "debe tener prenda superior");
    this.parteInferior = requireNonNull(parteInferior, "debe tener prenda inferior");
    this.calzado = requireNonNull(calzado, "debe tener calzado");
  }

  public static Uniforme uniformeInstitucion(Diseniador disInstitucion) {
    return new Uniforme(disInstitucion.crearPrendaSuperior(),
        disInstitucion.crearPrendaInferior(),
        disInstitucion.crearCalzado());
  }
  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
