package datos;

import database.Conexion;
import datos.interfaces.CrudMonitoreo;
import entidades.monitoreo_produccion_distribucion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}