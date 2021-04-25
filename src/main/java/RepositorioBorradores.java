import java.util.ArrayList;
import java.util.List;

public final class RepositorioBorradores {
  private static RepositorioBorradores instance = new RepositorioBorradores();
  private List<BorradorPrenda> borradoresIncompletos = new ArrayList<>();

  private RepositorioBorradores(){
  }

  public static RepositorioBorradores getInstance() {
    return instance;
  }

  public void agregarBorradorIncompleto(BorradorPrenda borrador) {
    borradoresIncompletos.add(borrador);
  }

  public BorradorPrenda getBorradorOfIndex(int nro) {
    return borradoresIncompletos.get(nro);
  }


}




