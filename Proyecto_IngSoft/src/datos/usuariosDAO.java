package datos;

import database.Conexion;
import datos.interfaces.CrudUsuarios;
import entidades.usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class usuariosDAO implements CrudUsuarios<usuarios>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public usuariosDAO()
    {
        CON = Conexion.getInstancia();
    }

    @Override
    public boolean insertar(usuarios obj) 
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into usuarios (nombre, apellido, correo, contrasena, rol)\n" +
                    "values(?, ?, ?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getCorreo());
            ps.setString(4, obj.getContrasena());
            ps.setString(5, obj.getRol());
            
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
    public boolean existe(String nombre, String apellido)
    {
        String sql;
        resp = false;
        try
        {
            sql = "select id_usuario from usuarios where nombre = ? and apellido = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            
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
