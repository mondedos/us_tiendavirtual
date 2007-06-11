package mfis.tiendavirtual.mocks.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import mfis.tiendavirtual.mocks.persistence.Item;
import mfis.tiendavirtual.mocks.persistence.Producto;

@Deprecated
public class ProductosDAO {

    @SuppressWarnings("unchecked")
	public static List<Producto> listarProductosBusqueda(float precioMinimo,
            float precioMaximo, String categoria, List<String> palabrasClave){

    	List l = new ArrayList();
		Producto a = new Producto();
		a.setMarca("Marca Producto A");
		a.setDimensiones("10x10");
		a.setGanancia(new BigDecimal(20));
		a.setModelo("Modelo Producto A");
		a.setPrecio(new BigDecimal(1000));
		a.setReferencia("00000A");
		Producto b = new Producto();
		b.setMarca("Marca Producto B");
		b.setDimensiones("10x10");
		b.setGanancia(new BigDecimal(30));
		b.setModelo("Modelo Producto B");
		b.setPrecio(new BigDecimal(2000));
		b.setReferencia("00000B");
		Producto c = new Producto();
		c.setMarca("Marca Producto C");
		c.setDimensiones("10x10");
		c.setGanancia(new BigDecimal(50));
		c.setModelo("Modelo Producto C");
		c.setPrecio(new BigDecimal(3000));
		c.setReferencia("00000C");

		l.add(a);
		l.add(b);
		l.add(c);


        return l;
    }


    @SuppressWarnings("unchecked")
	public static List<Producto> listarProductosCategoria(String categoria) {
    	List l = new ArrayList();
		Producto a = new Producto();
		a.setMarca("Marca Producto A");
		a.setDimensiones("10x10");
		a.setGanancia(new BigDecimal(20));
		a.setModelo("Modelo Producto A");
		a.setPrecio(new BigDecimal(1000));
		a.setReferencia("00000A");
		Producto b = new Producto();
		b.setMarca("Marca Producto B");
		b.setDimensiones("10x10");
		b.setGanancia(new BigDecimal(30));
		b.setModelo("Modelo Producto B");
		b.setPrecio(new BigDecimal(2000));
		b.setReferencia("00000B");
		Producto c = new Producto();
		c.setMarca("Marca Producto C");
		c.setDimensiones("10x10");
		c.setGanancia(new BigDecimal(50));
		c.setModelo("Modelo Producto C");
		c.setPrecio(new BigDecimal(3000));
		c.setReferencia("00000C");

		l.add(a);
		l.add(b);
		l.add(c);


        return l;
    }

    public static Item getProducto(int id) {

    	Item i = new Item();
    	i.setReferencia("00001");

    	return i;
    }

    public static void anadirProducto(Producto p) {
    	System.out.println("Se ha anadido un producto");
    }

    public static void modificarProducto(int id, Producto p){
    	System.out.println("Se ha modificado el producto " + id);
    }

    public static void eliminarProducto(int id) {
    	System.out.println("Se ha eliminado el producto " +id);
    }

    @SuppressWarnings("unchecked")
	public static List<Producto> get10ProductosMasBeneficiosos() {
    	List l = new ArrayList();
		Producto a = new Producto();
		a.setMarca("Marca Producto A");
		a.setDimensiones("10x10");
		a.setGanancia(new BigDecimal(20));
		a.setModelo("Modelo Producto A");
		a.setPrecio(new BigDecimal(1000));
		a.setReferencia("00000A");
		Producto b = new Producto();
		b.setMarca("Marca Producto B");
		b.setDimensiones("10x10");
		b.setGanancia(new BigDecimal(30));
		b.setModelo("Modelo Producto B");
		b.setPrecio(new BigDecimal(2000));
		b.setReferencia("00000B");
		Producto c = new Producto();
		c.setMarca("Marca Producto C");
		c.setDimensiones("10x10");
		c.setGanancia(new BigDecimal(50));
		c.setModelo("Modelo Producto C");
		c.setPrecio(new BigDecimal(3000));
		c.setReferencia("00000C");

		l.add(a);
		l.add(b);
		l.add(c);


        return l;
    }
    @SuppressWarnings("unchecked")
	public static List<Producto> get10ProductosMenosBeneficiosos() {
    	List l = new ArrayList();
		Producto a = new Producto();
		a.setMarca("Marca Producto A");
		a.setDimensiones("10x10");
		a.setGanancia(new BigDecimal(20));
		a.setModelo("Modelo Producto A");
		a.setPrecio(new BigDecimal(1000));
		a.setReferencia("00000A");
		Producto b = new Producto();
		b.setMarca("Marca Producto B");
		b.setDimensiones("10x10");
		b.setGanancia(new BigDecimal(30));
		b.setModelo("Modelo Producto B");
		b.setPrecio(new BigDecimal(2000));
		b.setReferencia("00000B");
		Producto c = new Producto();
		c.setMarca("Marca Producto C");
		c.setDimensiones("10x10");
		c.setGanancia(new BigDecimal(50));
		c.setModelo("Modelo Producto C");
		c.setPrecio(new BigDecimal(3000));
		c.setReferencia("00000C");

		l.add(a);
		l.add(b);
		l.add(c);


        return l;
    }
}
