package datos;

import database.Conexion;
import datos.interfaces.CrudPruebas;
import entidades.pruebas_calidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class pruebasDAO implements CrudPruebas<pruebas_calidad>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public pruebasDAO()
    {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<pruebas_calidad> datos()
    {
        List<pruebas_calidad> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select * from pruebas_calidad;";
            ps = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new pruebas_calidad(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
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
    
    public List<pruebas_calidad> pruebasUsu(int id)
    {
        List<pruebas_calidad> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select * from pruebas_calidad where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new pruebas_calidad(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
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
    public boolean insertar(pruebas_calidad obj)
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into pruebas_calidad (id_usuario, id_muestra, resultado) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setInt(2, obj.getId_muestra());
            ps.setString(3, obj.getResultado());
            
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
    public boolean modificar(String res, int id)
    {
        String sql;
        resp = false;
        try
        {
            sql = "update pruebas_calidad set resultado = ? where id_prueba = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, res);
            ps.setInt(2, id);            
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
            sql = "delete from pruebas_calidad where id_prueba = ?";
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