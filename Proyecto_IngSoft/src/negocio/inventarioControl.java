package negocio;

import datos.inventarioDAO;
import datos.usuariosDAO;
import entidades.control_inventario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class inventarioControl 
{
    private final inventarioDAO DATOS;
    private final usuariosDAO DATOSUSU;
    private control_inventario obj;
    private DefaultTableModel modeloTabla;
    
    public inventarioControl()
    {
        DATOS = new inventarioDAO();
        DATOSUSU = new usuariosDAO();
        obj = new control_inventario();
    }
    
    public DefaultTableModel Listar()
    {
        List<control_inventario> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Título", "Cantidad", "Datos"};
        String[] registro = new String[7];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(control_inventario item:lista)
        {
            registro[0] = String.valueOf(item.getId_inventario());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.getNombre();
            registro[5] = String.valueOf(item.getCantidad());
            registro[6] = item.getDatos();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel Buscar(String nombreComp)
    {
        List<control_inventario> lista = new ArrayList();
        lista.addAll(DATOS.invUsu(DATOSUSU.getIdConcat(nombreComp)));
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Título", "Cantidad", "Datos"};
        String[] registro = new String[7];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(control_inventario item:lista)
        {
            registro[0] = String.valueOf(item.getId_inventario());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.getNombre();
            registro[5] = String.valueOf(item.getCantidad());
            registro[6] = item.getDatos();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String Insertar(int idUsuario, String fecha, String nombre, int cantidad, String datos)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_registro(fecha);
        obj.setNombre(nombre);
        obj.setCantidad(cantidad);
        obj.setDatos(datos);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de inventario";
    }
    
    public String Modificar(String nombre, int can, String datos, int id)
    {
        obj.setNombre(nombre);
        obj.setCantidad(can);
        obj.setDatos(datos);
        obj.setId_inventario(id);
        
        if(DATOS.modificar(nombre, can, datos, id))
            return "OK";
        else
            return "Error en la modificación";
    }
    
    public String Eliminar(int id)
    {
        if(DATOS.eliminar(id))
            return "OK";
        else
            return "No fue posible eliminar el inventario";
    }
}