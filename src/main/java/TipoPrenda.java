public enum TipoPrenda {
  ZAPATO {
    public CategoriaPrenda getCategoria() {
      return CategoriaPrenda.CALZADO;
    }
  },
  CAMISA {
    public CategoriaPrenda getCategoria() {
      return CategoriaPrenda.PARTE_SUPERIOR;
    }
  },
  PANTALON {
    public CategoriaPrenda getCategoria() {
      return CategoriaPrenda.PARTE_INFERIOR;
    }
  },
  REMERA {
    public CategoriaPrenda getCategoria() {
      return CategoriaPrenda.PARTE_SUPERIOR;
    }
  },
  GAFAS {
    public CategoriaPrenda getCategoria() {
      return CategoriaPrenda.ACCESORIOS;
    }
  };

  public abstract CategoriaPrenda getCategoria();
}
