package datos;

import database.Conexion;
import datos.interfaces.CrudMuestras;
import entidades.datos_muestras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public boolean existe(int id_usuario, String fecha)
    {
        String sql;
        resp = false;
        try
        {
            sql = "select id_muestra from datos_muestras where id_usuario = ? and date(fecha_ingreso) = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id_usuario);
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
}