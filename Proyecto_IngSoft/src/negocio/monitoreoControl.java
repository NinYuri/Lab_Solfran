package negocio;

import datos.monitoreoDAO;
import datos.usuariosDAO;
import entidades.monitoreo_produccion_distribucion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class monitoreoControl 
{
    private final monitoreoDAO DATOS;
    private final usuariosDAO DATOSUSU;
    private monitoreo_produccion_distribucion obj;
    private DefaultTableModel modeloTabla;
    
    public monitoreoControl()
    {
        DATOS = new monitoreoDAO();
        DATOSUSU = new usuariosDAO();
        obj = new monitoreo_produccion_distribucion();
    }
    
    public DefaultTableModel Listar()
    {
        List<monitoreo_produccion_distribucion> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Reporte"};
        String[] registro = new String[5];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(monitoreo_produccion_distribucion item:lista)
        {
            registro[0] = String.valueOf(item.getId_monitoreo());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.getDatos();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel Buscar(String nombreComp)
    {
        List<monitoreo_produccion_distribucion> lista = new ArrayList();
        lista.addAll(DATOS.moniUsu(DATOSUSU.getIdConcat(nombreComp)));
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Reporte"};
        String[] registro = new String[5];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(monitoreo_produccion_distribucion item:lista)
        {
            registro[0] = String.valueOf(item.getId_monitoreo());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.getDatos();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String Insertar(int idUsuario, String fecha, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_monitoreo(fecha);
        obj.setDatos(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción del informe de monitoreo";
    }
    
    public String Modificar(String datos, int id)
    {
        obj.setDatos(datos);
        obj.setId_monitoreo(id);
        
        if(DATOS.modificar(datos, id))
            return "OK";
        else
            return "Error en la modificación";
    }
    
    public String Eliminar(int id)
    {
        if(DATOS.eliminar(id))
            return "OK";
        else
            return "No fue posible eliminar el reporte";
    }
}