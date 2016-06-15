package model;

import bd.Conexion;
import model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Piaa FernanDaa
 */
public class Data {
    private Conexion c;
    private String q;
    private ResultSet rs;
    private List<Producto> productos;
    private List<Tipo> tipo;
    private List<VentaProducto> compras;
    private List<Cliente> clientes;
    
    public Data() throws SQLException {
        c = new Conexion(
                "localhost",
                "bd_tienda",
                "root",
                "");
    }
    public void crearProducto(Producto p) throws SQLException{
        q = "insert into producto values (null, "
                + "'"+p.getNombre()+"',"
                + "'"+p.getPrecio()+"',"
                + "'"+p.getTipo()+"')";
        System.out.println(q);
        c.ejecutar(q);
    }
    
    public List<Producto> getProductos() throws SQLException{
        productos = new ArrayList<>();
        Producto p;
        q = "SELECT * FROM producto";
        rs = c.ejecutarSelect(q);            
        while(rs.next()){
            p = new Producto();
            
            p.setId(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setPrecio(rs.getInt(3));
            p.setTipo(rs.getInt(4));
            
            productos.add(p);

        }
        c.desconectar();
        return productos;
    }
    
    //solo un producto
    public Producto getProductoPorId(int id) throws SQLException{
        
        q = "select * from producto where id = '"+id+"'";
        productos = new ArrayList<>();
        rs = c.ejecutarSelect(q);
        Producto p = null;
        if(rs.next()){
            p = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            productos.add(p);
        }
        c.desconectar();
            
        return p;
    }
    
    public void eliminarProducto(int id) throws SQLException{
        q = "delete from producto where id = '"+ id +"'";
        c.ejecutar(q);       
    }
//    
//    public void actualizarPrecioProducto(Producto p) throws SQLException{
//        q = "UPDATE producto SET precio = '"+p.getPrecio()+"' where "
//                + "id = '"+p.getId()+"'";
//        c.ejecutar(q);
//    }
    
    public List<Producto> BuscarProducto (String filtro) throws SQLException{
        productos = new ArrayList<>();
        Producto p ;
        q = "select * from Producto where nombre like '%"+filtro+"%'";
        rs = c.ejecutarSelect(q);        
        while(rs.next()){
            p = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

            productos.add(p);
        }
        c.desconectar();
        return productos;
    }

    public Tipo getTipoPorId(int id) throws SQLException {
        q = "select * from tipo where id = '"+id+"'";
        System.out.println(q);
        tipo = new ArrayList<>();
        rs = c.ejecutarSelect(q);
        Tipo t = null;
        /*Mientras exista un siguiente registro*/
        if(rs.next()){
            t = new Tipo();
            
            t.setId(rs.getInt(1));
            t.setNombre(rs.getString(2));
            
            tipo.add(t);
        }
        c.desconectar();
        
        return t;
    }
    public List <Tipo> getTipo() throws SQLException{
        tipo = new ArrayList<>();
        Tipo t;
        
        q = "select * from tipo";
        
        tipo = new ArrayList<>();
        rs = c.ejecutarSelect(q);
        
        /*Mientras exista un siguiente registro*/
        
        while(rs.next()){
            t = new Tipo();
            
            t.setId(rs.getInt(1));
            t.setNombre(rs.getString(2));
  
            
            tipo.add(t);
        }
        c.desconectar();
        return tipo;
        
    }
    public void agregarCliente (Cliente cl) throws SQLException{
       
            q = "insert into cliente values (NULL, "
                    + "'"+cl.getNombre()+"',"
                    + "'"+cl.getApellido()+"',"
                    + "'"+cl.getTelefono()+"',"
                    + "'"+cl.getDireccion()+"',"
                    + "'"+cl.getRut()+"')";
            c.ejecutar(q);

    }
    
        public void ventaNueva (Venta v) throws SQLException{
       
            q = "insert into venta values (NULL, "
                    + "'"+v.getId()+"',"
                    + "'"+v.getTotal()+"')";
                    
            c.ejecutar(q);

    }
    public void crearBoleta (VentaProducto b) throws SQLException{
        q = "insert into ventaProducto values (NULL, "
                    + "'"+b.getIdProducto()+"',"
                    + "'"+b.getIdVenta()+"',"
                    + "'"+b.getCantidadProductos()+"',"
                    + "'"+b.getSubTotal()+"')";
            c.ejecutar(q);
    }
    
    public List<VentaProducto> cargarBoletaPorId(int id) throws SQLException {
        compras = new ArrayList<>();
        VentaProducto vp;
        q = "select * from ventaProducto where id like '%" + id + "%'";
        rs = c.ejecutarSelect(q);
        while (rs.next()) {
            vp = new VentaProducto(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5));

            compras.add(vp);

        }
        c.desconectar();
        return compras;
    }
    
    public List<Cliente> buscarClienteRut (String filtro) throws SQLException{
        clientes = new ArrayList<>();
        Cliente cl;
        q = "select * from producto where rut like '%"+filtro+"%'";
        rs = c.ejecutarSelect(q);        
        while(rs.next()){
            
            cl = new Cliente(
                    rs.getInt(1),
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getInt(4), 
                    rs.getString(5),
                    rs.getString(6));

            clientes.add(cl);
        }
        c.desconectar();
        return clientes;
    }
  //falta crear as demas consultas para las demas tablas
    
}
