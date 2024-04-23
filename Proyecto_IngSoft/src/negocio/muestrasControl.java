package negocio;

import datos.muestrasDAO;
import datos.usuariosDAO;
import entidades.datos_muestras;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class muestrasControl 
{
    private final muestrasDAO DATOS;
    private final usuariosDAO DATOSUSU;
    private datos_muestras obj;
    private DefaultTableModel modeloTabla;
    
    public muestrasControl()
    {
        DATOS = new muestrasDAO();
        DATOSUSU = new usuariosDAO();
        obj = new datos_muestras();
    }
    
    public DefaultTableModel Listar()
    {
        List<datos_muestras> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Componente Extraño", "Contaminación Cruzada", "Mg", "Datos"};
        String[] registro = new String[8];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(datos_muestras item:lista)
        {
            registro[0] = String.valueOf(item.getId_muestra());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.isComponente_extraño() ? "Sí" : "No";
            registro[5] = item.isContaminacion_cruzada() ? "Sí" : "No";
            registro[6] = String.valueOf(item.getMg());
            registro[7] = item.getDatos();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel Buscar(String nombreComp)
    {
        List<datos_muestras> lista = new ArrayList();
        lista.addAll(DATOS.muestrasUsu(DATOSUSU.getIdConcat(nombreComp)));
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Componente Extraño", "Contaminación Cruzada", "Mg", "Datos"};
        String[] registro = new String[8];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(datos_muestras item:lista)
        {
            registro[0] = String.valueOf(item.getId_muestra());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.isComponente_extraño() ? "Sí" : "No";
            registro[5] = item.isContaminacion_cruzada() ? "Sí" : "No";
            registro[6] = String.valueOf(item.getMg());
            registro[7] = item.getDatos();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String Insertar(int idUsuario, String fecha, boolean componente, boolean cont, float mg, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_ingreso(fecha);
        obj.setComponente_extraño(componente);
        obj.setContaminacion_cruzada(cont);
        obj.setMg(mg);
        obj.setDatos(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Eror en la inserción de la muestra";
    }
    
    public String Modificar(int id, boolean comp, boolean cont, float mg, String datos)
    {
        obj.setId_muestra(id);
        obj.setComponente_extraño(comp);
        obj.setContaminacion_cruzada(cont);
        obj.setMg(mg);
        obj.setDatos(datos);
        
        if(DATOS.modificar(obj))
            return "OK";
        else
            return "Error en la actualización";
    }
}