package datos;

import database.Conexion;
import datos.interfaces.CrudAuditorias;
import entidades.auditorias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class auditoriasDAO implements CrudAuditorias<auditorias>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public auditoriasDAO()
    {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public boolean insertar(auditorias obj) 
    {
        String sql;
        resp = false;
        try
        {
            sql= "insert into auditorias (id_usuario, fecha_auditoria, datos_consultados) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_auditoria());
            ps.setString(3, obj.getDatos_consultados());
            
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