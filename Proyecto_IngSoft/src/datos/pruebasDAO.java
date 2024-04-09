package datos;

import database.Conexion;
import datos.interfaces.CrudPruebas;
import entidades.pruebas_calidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class pruebasDAO implements CrudPruebas<pruebas_calidad>
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public pruebasDAO()
    {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public boolean insertar(pruebas_calidad obj)
    {
        String sql;
        resp = false;
        try
        {
            sql = "insert into pruebas_calidad (id_usuario, id_muestra, resultado) values (?, ?, ?);";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setInt(2, obj.getId_muestra());
            ps.setString(3, obj.getResultado());
            
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