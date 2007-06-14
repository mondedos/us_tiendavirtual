package mfis.tiendavirtual.util;

public class Paginador {
    /** Numero maximo de elementos por pagina. Tiene que ser un valor distinto de 0 */
    public static final int MAXELEMPORPAGINA = 12;
    /** Pagina que se quiere mostrar*/
    int pagina;
    /** Numero de elementos en la coleccion actual*/
    int sizeCollection;
    /** Numero de pagina que se van a necesitar*/
    int numpaginas;
    /** Primer elemento de la pagina*/
    int firstPageElement;
    /** Ultimo elemento de la pagina*/
    int lastPageElement;


    public Paginador(int pagina , int sizeCollection) {
      this.pagina = pagina;
      this.sizeCollection = sizeCollection;
      this.numpaginas = calculaPaginas();
      this.firstPageElement = primerElementoDePagina();
      this.lastPageElement = ultimoElementoDePagina();
    }

    public int primerElementoDePagina() {
        if(this.pagina == 0)
            return 0;
        else
            return MAXELEMPORPAGINA * (pagina-1);
    }

    public int ultimoElementoDePagina() {
        if(this.pagina == 0)
            return sizeCollection;
        else
            return ((firstPageElement + MAXELEMPORPAGINA) <= sizeCollection ) ? firstPageElement + MAXELEMPORPAGINA : sizeCollection;
    }

    public int getMAXELEMPORPAGINA() {
      return MAXELEMPORPAGINA;
    }

    public void setPagina(int pagina) {
      this.pagina = pagina;
    }

    public int getPagina() {
      return pagina;
    }

    public void setSizeCollection(int sizeCollection) {
      this.sizeCollection = sizeCollection;
    }

    public int getSizeCollection() {
      return sizeCollection;
    }

    private int calculaPaginas()  {
        if(this.pagina == 0) {
            return 1;
        }
        int res = 0;
        res = sizeCollection / MAXELEMPORPAGINA;
        if( (sizeCollection % MAXELEMPORPAGINA) != 0) {
            res++;
          }
        return res;
    }

    public void setNumpaginas(int numpaginas) {
      this.numpaginas = numpaginas;
    }

    public int getNumpaginas() {
      return numpaginas;
    }


    public void setFirstPageElement(int firstPageElement)
    {
      this.firstPageElement = firstPageElement;
    }


    public int getFirstPageElement()
    {
      return firstPageElement;
    }


    public void setLastPageElement(int lastPageElement)
    {
      this.lastPageElement = lastPageElement;
    }


    public int getLastPageElement()
    {
      return lastPageElement;
    }
}
