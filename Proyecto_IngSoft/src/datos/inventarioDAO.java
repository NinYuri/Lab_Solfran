package datos;

import database.Conexion;
import datos.interfaces.CrudInventario;
import entidades.control_inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class inventarioDAO implements CrudInventario<control_inventario>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public inventarioDAO()
    {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<control_inventario> datos()
    {
        List<control_inventario> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_inventario, id_usuario, DATE(fecha_registro), TIME(fecha_registro), nombre, cantidad, datos \n" +
                "from control_inventario;";
            ps = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new control_inventario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }
    
    public List<control_inventario> invUsu(int id)
    {
        List<control_inventario> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_inventario, id_usuario, DATE(fecha_registro), TIME(fecha_registro), nombre, cantidad, datos \n" +
                "from control_inventario where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new control_inventario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }
    
    @Override
    public boolean insertar(control_inventario obj) 
    {
        String sql;
        resp = false;
        try 
        {
            sql = "insert into control_inventario (id_usuario, fecha_registro, nombre, cantidad, datos)\n" +
                    "values (?, ?, ?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_registro());
            ps.setString(3, obj.getNombre());
            ps.setInt(4, obj.getCantidad());
            ps.setString(5, obj.getDatos());
            
            if(ps.executeUpdate() > 0)
                resp = true;
            ps.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps = null;
            CON.Desconectar();
        }
        return resp;
    }
    
    @Override
    public boolean modificar(String nombre, int can, String datos, int id)
    {
        String sql;
        resp = false;
        try
        {
            sql = "update control_inventario set nombre = ?, cantidad = ?, datos = ? where id_inventario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setInt(2, can);
            ps.setString(3, datos);
            ps.setInt(4, id);
            if(ps.executeUpdate() > 0)
                resp = true;
            ps.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps = null;
            CON.Desconectar();
        }
        return resp;
    }  
    
    @Override
    public boolean eliminar(int id)
    {
        String sql;
        resp = false;
        try
        {
            sql = "delete from control_inventario where id_inventario = ?";
            ps = CON.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0)
                resp = true;
            ps.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps = null;
            CON.Desconectar();
        }
        return resp;
    }
}