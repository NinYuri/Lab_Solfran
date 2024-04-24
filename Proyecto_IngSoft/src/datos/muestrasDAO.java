package datos;

import database.Conexion;
import datos.interfaces.CrudMuestras;
import entidades.datos_muestras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class muestrasDAO implements CrudMuestras<datos_muestras>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public muestrasDAO()
    {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<datos_muestras> datos()
    {
        List<datos_muestras> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_muestra, id_usuario, DATE(fecha_ingreso), TIME(fecha_ingreso), componente_extraño, contaminacion_cruzada, mg, datos \n" +
                "from datos_muestras;";
            ps = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new datos_muestras(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getBoolean(6), rs.getFloat(7), rs.getString(8)));
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
    
    public List<datos_muestras> muestrasUsu(int id)
    {
        List<datos_muestras> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_muestra, id_usuario, DATE(fecha_ingreso), TIME(fecha_ingreso), componente_extraño, contaminacion_cruzada, mg, datos \n" +
                "from datos_muestras where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new datos_muestras(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getBoolean(6), rs.getFloat(7), rs.getString(8)));
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
    public boolean insertar(datos_muestras obj)
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into datos_muestras (id_usuario, fecha_ingreso, componente_extraño, contaminacion_cruzada, mg, datos) \n" +
                    "values (?, ?, ?, ?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_ingreso());
            ps.setBoolean(3, obj.isComponente_extraño());
            ps.setBoolean(4, obj.isContaminacion_cruzada());
            ps.setFloat(5, obj.getMg());
            ps.setString(6, obj.getDatos());
            
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
    public boolean existe(int id_muestra, String fecha)
    {
        String sql;
        resp = false;
        try
        {
            sql = "select * from datos_muestras where id_muestra = ? and date(fecha_ingreso) = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id_muestra);
            ps.setString(2, fecha);
            
            rs = ps.executeQuery();
            if(rs.next())
                resp = true;
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
        return resp;
    }
    
    @Override
    public boolean modificar(datos_muestras obj)
    {
        String sql;
        resp = false;
        try
        {
            sql = "update datos_muestras\n" +
                "set componente_extraño = ?, contaminacion_cruzada = ?, mg = ?, datos = ? \n" +
                "where id_muestra = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setBoolean(1, obj.isComponente_extraño());
            ps.setBoolean(2, obj.isContaminacion_cruzada());
            ps.setFloat(3, obj.getMg());
            ps.setString(4, obj.getDatos());
            ps.setInt(5, obj.getId_muestra());
            
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
            sql = "delete from datos_muestras where id_muestra = ?;";
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
    
    public String fecha(int id)
    {
        String fecha = "";
        String sql;
        try
        {
            sql = "select DATE(fecha_ingreso) from datos_muestras where id_muestra = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);            
            rs = ps.executeQuery();
            if(rs.next())
                fecha = rs.getString(1);
            ps.close();
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
        return fecha;
    }
}