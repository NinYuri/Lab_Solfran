package datos;

import database.Conexion;
import datos.interfaces.CrudNormas;
import entidades.verificacion_cumplimiento_normativo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class normasDAO implements CrudNormas<verificacion_cumplimiento_normativo>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public normasDAO()
    {
        CON = Conexion.getInstancia();
    }

    @Override
    public boolean insertar(verificacion_cumplimiento_normativo obj) 
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into verificacion_cumplimiento_normativo (id_usuario, fecha_verificacion, datos_verificados) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_verificacion());
            ps.setString(3, obj.getDatos_verificados());
            
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