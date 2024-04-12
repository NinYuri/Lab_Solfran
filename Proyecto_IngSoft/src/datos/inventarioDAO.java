package datos;

import database.Conexion;
import datos.interfaces.CrudInventario;
import entidades.control_inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class inventarioDAO implements CrudInventario<control_inventario>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public inventarioDAO()
    {
        CON = Conexion.getInstancia();
    }

    @Override
    public boolean insertar(control_inventario obj) 
    {
        String sql;
        resp = false;
        try 
        {
            sql = "insert into control_inventario (id_usuario, fecha_registro, nombre, cantidad, datos)\n" +
                    "values (?, ?, ?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_registro());
            ps.setString(3, obj.getNombre());
            ps.setInt(4, obj.getCantidad());
            ps.setString(5, obj.getDatos());
            
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