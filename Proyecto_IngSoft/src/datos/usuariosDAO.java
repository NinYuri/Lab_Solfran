package datos;

import database.Conexion;
import datos.interfaces.CrudUsuarios;
import entidades.usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public List<usuarios> datos() 
    {
        List<usuarios> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_usuario, nombre, apellido, correo, rol from usuarios;";
            ps = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
    public boolean modificar(usuarios obj)
    {
        String sql;
        resp = false;
        try
        {
            sql = "update usuarios \n" +
            "set nombre = ?, apellido = ?, correo = ?, rol = ? \n" +
            "where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getCorreo());
            ps.setString(4, obj.getRol());
            ps.setInt(5, obj.getId_usuario());
            
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
    
    @Override
    public boolean comparar(String nombre, String apellido, String pass)
    {
        String sql;
        resp = false;
        try
        {
            sql = "select contrasena from usuarios where nombre = ? and apellido = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            
            rs = ps.executeQuery();
            if(rs.next())
                if(rs.getString(1).equals(pass))
                    resp = true;
                else
                    resp = false;
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
    public int id(String nombre, String apellido, String pass)
    {
        int id = 0;
        String sql;
        try {
            sql = "select id_usuario from usuarios where\n" + 
                    "nombre = ? and apellido = ? and contrasena = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, pass);
            
            rs = ps.executeQuery();
            if(rs.next())
                id =  rs.getInt(1);
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
        return id;
    }
    
    public String rol(String nombre, String apellido, String pass)
    {
        String rol = "";
        String sql;
        try
        {
            sql = "select rol from usuarios where nombre = ? and apellido = ? and contrasena = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, pass);
            
            rs = ps.executeQuery();
            if(rs.next())
                rol = rs.getString(1);
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
        return rol;
    }
    
    public String nombre(int id)
    {
        String nombre = "";
        String sql;
        try
        {
            sql = "select nombre from usuarios where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if(rs.next())
                nombre = rs.getString(1);
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
        return nombre;
    }
    
    public String apellido(int id)
    {
        String apellido = "";
        String sql;
        try
        {
            sql = "select apellido from usuarios where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if(rs.next())
                apellido = rs.getString(1);
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
        return apellido;
    }
}