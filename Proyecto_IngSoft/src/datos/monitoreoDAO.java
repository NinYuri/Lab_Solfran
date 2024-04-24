package datos;

import database.Conexion;
import datos.interfaces.CrudMonitoreo;
import entidades.monitoreo_produccion_distribucion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class monitoreoDAO implements CrudMonitoreo<monitoreo_produccion_distribucion>
{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public monitoreoDAO()
    {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<monitoreo_produccion_distribucion> datos()
    {
        List<monitoreo_produccion_distribucion> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_monitoreo, id_usuario, DATE(fecha_monitoreo), TIME(fecha_monitoreo), datos \n" +
                    "from monitoreo_produccion_distribucion;";
            ps = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new monitoreo_produccion_distribucion(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5)));
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
    
    public List<monitoreo_produccion_distribucion> moniUsu(int id)
    {
        List<monitoreo_produccion_distribucion> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_monitoreo, id_usuario, DATE(fecha_monitoreo), TIME(fecha_monitoreo), datos \n" +
                    "from monitoreo_produccion_distribucion where id_monitoreo = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new monitoreo_produccion_distribucion(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5)));
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
    public boolean insertar(monitoreo_produccion_distribucion obj) 
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into monitoreo_produccion_distribucion (id_usuario, fecha_monitoreo, datos) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_monitoreo());
            ps.setString(3, obj.getDatos());
            
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
    public boolean modificar(String datos, int id)
    {
        String sql;
        resp = false;
        try
        {
            sql = "update monitoreo_produccion_distribucion set datos = ? where id_monitoreo = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, datos);
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
            sql = "delete from monitoreo_produccion_distribucion where id_monitoreo = ?";
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