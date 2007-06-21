package mfis.tiendavirtual.util;


// En esta clase tendran cabida operaciones comunes que tendremos que realizar.

public class Utilidades {
    public Utilidades() {
    }

    public static String capitalizeWord(String s) {
      if (s == null || s.length() == 0) {
          return s;
      } else {
          return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
      }
    }
}
