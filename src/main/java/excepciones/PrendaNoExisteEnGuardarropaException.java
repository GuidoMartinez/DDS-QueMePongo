package excepciones;

public class PrendaNoExisteEnGuardarropaException extends RuntimeException {
  public PrendaNoExisteEnGuardarropaException(String message) {
    super(message);
  }
}
