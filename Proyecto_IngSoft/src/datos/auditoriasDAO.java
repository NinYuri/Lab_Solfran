package datos;

import database.Conexion;
import datos.interfaces.CrudAuditorias;
import entidades.auditorias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public List<auditorias> datos()
    {
        List<auditorias> registros = new ArrayList();
        String sql;
        try 
        {
            sql = "select id_auditoria, id_usuario, DATE(fecha_auditoria), TIME(fecha_auditoria), hallazgos, porcentaje_conformidad, acciones_correctivas, informe\n" +
                "from auditorias;";
            ps = CON.Conectar().prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new auditorias(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
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
    
    public List<auditorias> auditorUsu(int id)
    {
        List<auditorias> registros = new ArrayList();
        String sql;
        try
        {
            sql = "select id_auditoria, id_usuario, DATE(fecha_auditoria), TIME(fecha_auditoria), hallazgos, porcentaje_conformidad, acciones_correctivas, informe\n" +
                "from auditorias where id_usuario = ?;";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next())
                registros.add(new auditorias(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
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
    public boolean insertar(auditorias obj) 
    {
        String sql;
        resp = false;
        try
        {
            sql= "insert into auditorias (id_usuario, fecha_auditoria, hallazgos, porcentaje_conformidad, acciones_correctivas, informe) \n" +
                    "values (?, ?, ?, ?, ?, ?)";
            ps = CON.Conectar().prepareStatement(sql);
            
            ps.setInt(1, obj.getId_usuario());
            ps.setString(2, obj.getFecha_auditoria());
            ps.setString(3, obj.getHallazgos());
            ps.setInt(4, obj.getPorcentaje_conformidad());
            ps.setString(5, obj.getAcciones_correctivas());
            ps.setString(6, obj.getInforme());
            
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
    public boolean eliminar(int id)
    {
        String sql;
        resp = false;
        try
        {
            sql = "delete from auditorias where id_auditoria = ?";
            ps = CON.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
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