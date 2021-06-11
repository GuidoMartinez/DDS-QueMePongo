package acciones;

import dominio.Usuario;
import servicios.GeneradorSugerencias;

public class RecalculoSugerencia implements AccionAlertaMeteorologica{
  private GeneradorSugerencias generadorSugerencias;

  public RecalculoSugerencia(GeneradorSugerencias generadorSugerencias) {
    this.generadorSugerencias = generadorSugerencias;
  }

  @Override
  public void alertar(Usuario usuario, Alerta alerta) {
    usuario.generarSugerenciaDiaria(generadorSugerencias);

  }
}
