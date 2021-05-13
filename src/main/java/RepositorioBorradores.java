import java.util.ArrayList;
import java.util.List;

public class RepositorioBorradores {
  private List<BorradorPrenda> borradoresIncompletos = new ArrayList<>();

  public RepositorioBorradores(){
  }

  public void agregarBorradorIncompleto(BorradorPrenda borrador) {
    borradoresIncompletos.add(borrador);
  }

  public List<BorradorPrenda> getBorradoresIncompletos() {
    return borradoresIncompletos;
  }

}




