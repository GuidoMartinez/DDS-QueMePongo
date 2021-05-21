package servicios;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import prenda.CategoriaPrenda;
import prenda.Prenda;
import uniforme.Atuendo;

public class GeneradorSugerencias {
  private ServicioClima servicioClima;
  private Double tempActual;

  public GeneradorSugerencias(ServicioClima servicioClima) {
    this.servicioClima = servicioClima;
  }


  // ya que no se desarrolla iteracion 3 se implementa este metodo a fin de simplificar
  // un atuendo random de la lista de sugerencias creadas
  public Atuendo atuendoSugeridoParaTemperaturaActual(List<Prenda> prendasDisponibles) {
    this.tempActual = temperaturaActual();

    Prenda parteSuperior = getPrendaRandomAdecuadaParaLaTemperatura(prendasDisponibles,
        CategoriaPrenda.PARTE_SUPERIOR, tempActual);
    Prenda parteInferior = getPrendaRandomAdecuadaParaLaTemperatura(prendasDisponibles,
        CategoriaPrenda.PARTE_INFERIOR, tempActual);
    Prenda calzado = getPrendaRandomAdecuadaParaLaTemperatura(prendasDisponibles,
        CategoriaPrenda.CALZADO, tempActual);
    Prenda accesorio = getPrendaRandomAdecuadaParaLaTemperatura(prendasDisponibles,
        CategoriaPrenda.ACCESORIOS, tempActual);

    return new Atuendo(parteSuperior, parteInferior, calzado, accesorio);
  }


  private Prenda getPrendaRandomAdecuadaParaLaTemperatura(List<Prenda> prendas,
                                                     CategoriaPrenda categoria, Double tempActual) {

    List<Prenda> prendasTemperaturaValida = getPrendaCategoriaCorrecta(prendas, categoria)
        .stream().filter(prenda -> prenda.getTemperaturaMaxima() <= tempActual)
        .collect(Collectors.toList());

    return prendasTemperaturaValida.get(new Random().nextInt(prendasTemperaturaValida.size()));
  }

  private List<Prenda> getPrendaCategoriaCorrecta(List<Prenda> prendas, CategoriaPrenda categoria) {
    return  prendas.stream().filter(prenda -> prenda.getCategoria().equals(categoria))
        .collect(Collectors.toList());
  }

  private Double temperaturaActual() {
    return servicioClima.getTemperatura();
  }

  public ServicioClima getServicioClima() {
    return servicioClima;
  }
}
