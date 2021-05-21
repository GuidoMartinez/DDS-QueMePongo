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



  public Atuendo getAtuendoSugeridoParaTemperaturaActual(List<Prenda> prendasDisponibles) {
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


  // un atuendo random de la lista de prendas cargadas sin restriccion de temperatura
  // Se que repite logica ante el metodo anterior, podria utilizarlo poniendole por
  // ej 100C, pero preferi separarlos
  public Atuendo getAtuendoSugerido(List<Prenda> prendasDisponibles) {

    List<Prenda> partesSuperiores = getPrendaCategoriaCorrecta(prendasDisponibles,
        CategoriaPrenda.PARTE_SUPERIOR);
    List<Prenda> partesInferiores = getPrendaCategoriaCorrecta(prendasDisponibles,
        CategoriaPrenda.PARTE_INFERIOR);
    List<Prenda> calzados = getPrendaCategoriaCorrecta(prendasDisponibles,
        CategoriaPrenda.CALZADO);
    List<Prenda> accesorios = getPrendaCategoriaCorrecta(prendasDisponibles,
        CategoriaPrenda.ACCESORIOS);

    Prenda randomParteSup = partesSuperiores.get(new Random().nextInt(partesSuperiores.size()));
    Prenda randomParteInf = partesInferiores.get(new Random().nextInt(partesInferiores.size()));
    Prenda randomParteCalzado = calzados.get(new Random().nextInt(calzados.size()));
    Prenda randomParteAccesorio = accesorios.get(new Random().nextInt(accesorios.size()));

    return new Atuendo(randomParteSup, randomParteInf, randomParteCalzado, randomParteAccesorio);
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
