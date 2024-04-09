package datos;

import database.Conexion;
import datos.interfaces.CrudAccesos;
import entidades.accesos_remotos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}