package datos;

import database.Conexion;
import datos.interfaces.CrudAutomatizacion;
import entidades.automatizacion_procesos_clave;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class automatizacionDAO implements CrudAutomatizacion<automatizacion_procesos_clave>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public automatizacionDAO()
    {
        CON = Conexion.getInstancia();
    }

    @Override
    public boolean insertar(automatizacion_procesos_clave obj) 
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into automatizacion_procesos_clave (id_usuario, fecha_automatizacion, datos_automatizados) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_automatizacion());
            ps.setString(3, obj.getDatos_automatizados());
            
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