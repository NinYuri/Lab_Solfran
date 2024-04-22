package negocio;

import datos.accesosDAO;
import datos.usuariosDAO;
import entidades.accesos_remotos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class accesosControl 
{
    private final accesosDAO DATOS;
    private final usuariosDAO DATOSUSU;
    private accesos_remotos obj;
    private DefaultTableModel modeloTabla;
    
    public accesosControl()
    {
        DATOS = new accesosDAO();
        DATOSUSU = new usuariosDAO();
        obj = new accesos_remotos();
    }
    
    public DefaultTableModel Listar()
    {
        List<accesos_remotos> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Autorizado"};
        String[] registro = new String[5];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(accesos_remotos item:lista)
        {
            registro[0] = String.valueOf(item.getId_acceso());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = String.valueOf(item.isAutorizado()).equals("true") ? "Sí" : "No";
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel Buscar(String nombreComp)
    {
        List<accesos_remotos> lista = new ArrayList();
        lista.addAll(DATOS.accesosUsu(DATOSUSU.getIdConcat(nombreComp)));
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Autorizado"};
        String[] registro = new String[5];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(accesos_remotos item:lista)
        {
            registro[0] = String.valueOf(item.getId_acceso());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = String.valueOf(item.isAutorizado()).equals("true") ? "Sí" : "No";
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String Insertar(int id_usuario, String fecha, boolean autorizado)
    {
        obj.setId_usuario(id_usuario);
        obj.setFecha_solicitud(fecha);
        obj.setAutorizado(autorizado);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción del acceso remoto";
    }
    
    public String Eliminar(int id)
    {
        if(DATOS.eliminar(id))
            return "OK";
        else
            return "No fue posible eliminar el acceso remoto";
    }
    
}