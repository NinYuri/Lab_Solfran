package datos;

import database.Conexion;
import datos.interfaces.CrudAccesos;
import entidades.accesos_remotos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class accesosDAO implements CrudAccesos<accesos_remotos>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public accesosDAO()
    {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<accesos_remotos> datos()
    {
        List<accesos_remotos> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_acceso, id_usuario, DATE(fecha_solicitud), TIME(fecha_solicitud), autorizado from accesos_remotos;";
            ps  = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new accesos_remotos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
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
    
    public List<accesos_remotos> accesosUsu(int id)
    {
        List<accesos_remotos> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_acceso, id_usuario, DATE(fecha_solicitud), TIME(fecha_solicitud), autorizado from accesos_remotos \n" +
                    "where id_usuario = ?";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new accesos_remotos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
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
    public boolean insertar(accesos_remotos obj)
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into accesos_remotos (id_usuario, fecha_solicitud, autorizado) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_solicitud());
            ps.setBoolean(3, obj.isAutorizado());
            
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
            sql = "delete from accesos_remotos where id_acceso = ?;";
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