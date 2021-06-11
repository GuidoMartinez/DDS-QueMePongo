import dominio.*;
import excepciones.PrendaNoExisteEnGuardarropaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import prenda.Prenda;

import java.util.ArrayList;
import java.util.List;


public class TestRecomendacion {

  Usuario usuario1, usuario2;
  Guardarropa guardarropa1,guardarropa2,guardarropa3,guardarropa4;
  Prenda prenda1,prenda2,prenda3,prenda4;
  List<Usuario> usuarios = new ArrayList<>();

  @BeforeEach
  void setup() {

    usuario1 = new Usuario(null,null);
    usuario2 = new Usuario(null,null);

    guardarropa1 = new Guardarropa();
    guardarropa2 = new Guardarropa();
    guardarropa3 = new Guardarropa();
    guardarropa4 = new Guardarropa();

    prenda1 = crearPrenda();
    prenda2 = crearPrenda();
    prenda3 = crearPrenda();
    prenda4 = crearPrenda();

    usuarios.clear();
  }

  @DisplayName("dominio.Usuario puede tener varios guardarropas")
  @Test
  void usuarioPuedeManejar3Guardarropas() {
    usuario1.agregarGuardarropa(guardarropa1);
    usuario1.agregarGuardarropa(guardarropa2);
    usuario1.agregarGuardarropa(guardarropa3);

    Assertions.assertEquals(3,usuario1.getGuardarropas().size());
    Assertions.assertTrue(usuario1.getGuardarropas().contains(guardarropa2));
  }

  @DisplayName("Dos usuarios comparten un mismo guardarropa")
  @Test
  void guardarropaPuedeSerCompartidoPorDosUsuarios() {
    usuario1.agregarGuardarropa(guardarropa1);
    usuario2.agregarGuardarropa(guardarropa1);

    Assertions.assertTrue(usuario1.getGuardarropas().contains(guardarropa1));
    Assertions.assertTrue(usuario2.getGuardarropas().contains(guardarropa1));
  }

  @DisplayName("Se recomienda agregar una prenda a un guardarropa")
  @Test
  void recomendacionAgregarUnaPrenda() {
    usuario1.agregarGuardarropa(guardarropa1);
    usuario2.agregarGuardarropa(guardarropa1);

    Recomendacion recomendacion = new AgregarPrenda(prenda1,guardarropa1);
    usuario2.agregarRecomendacion(recomendacion);

    Assertions.assertTrue(guardarropa1.getRecomendaciones().contains(recomendacion));
  }

  @DisplayName("Se recomienda quitar una prenda a un guardarropa que la contiene")
  @Test
  void recomendacionQuitarUnaPrendaExistenteEnElGuardarropa() {
    usuario1.agregarGuardarropa(guardarropa1);
    usuario2.agregarGuardarropa(guardarropa1);
    guardarropa1.agregarPrenda(prenda1);

    Recomendacion recomendacion = new QuitarPrenda(prenda1,guardarropa1);
    usuario2.agregarRecomendacion(recomendacion);

    Assertions.assertTrue(guardarropa1.getRecomendaciones().contains(recomendacion));
  }

  @DisplayName("Si se recomienda quitar una prenda a un guardarropa que no la contiene, arroja exception")
  @Test
  void recomendacionQuitarUnaPrendaInexistenteEnGuardarropaArrojaException() {
    usuario1.agregarGuardarropa(guardarropa1);
    usuario2.agregarGuardarropa(guardarropa1);

    Recomendacion recomendacion = new QuitarPrenda(prenda1,guardarropa1);

    Assertions.assertThrows(PrendaNoExisteEnGuardarropaException.class,
        () -> usuario2.agregarRecomendacion(recomendacion));
  }

  @DisplayName("Si agrego 3 propuestas, puedo listarlas y aceptarlas o rechazarlas")
  @Test
  void listoRecomendacionesYPuedoAceptarlaORechazarla() {
    usuario1.agregarGuardarropa(guardarropa1);
    usuario2.agregarGuardarropa(guardarropa1);
    guardarropa1.agregarPrenda(prenda1);
    guardarropa1.agregarPrenda(prenda2);

    Recomendacion quitarPrenda1 = new QuitarPrenda(prenda1,guardarropa1);
    Recomendacion agregarPrenda2 = new AgregarPrenda(prenda2,guardarropa1);
    Recomendacion agregarPrenda3 = new AgregarPrenda(prenda3,guardarropa1);

    usuario2.agregarRecomendacion(quitarPrenda1);
    usuario2.agregarRecomendacion(agregarPrenda2);
    usuario2.agregarRecomendacion(agregarPrenda3);

    List<Recomendacion> recomendaciones = guardarropa1.getRecomendaciones();

    usuario1.aceptar(recomendaciones.get(0));
    usuario1.aceptar(recomendaciones.get(0));
    usuario1.rechazar(recomendaciones.get(0));

    Assertions.assertFalse(guardarropa1.getPrendas().contains(prenda1));
    Assertions.assertTrue(guardarropa1.getPrendas().contains(prenda2));
    Assertions.assertFalse(guardarropa1.getPrendas().contains(prenda3));

  }






  Prenda crearPrenda() {
    return new Prenda(null,null,
        null,null,null,null);
  }




























}
