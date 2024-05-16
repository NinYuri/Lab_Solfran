package negocio;

import datos.auditoriasDAO;
import datos.usuariosDAO;
import entidades.auditorias;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class auditoriasControl 
{
    private final auditoriasDAO DATOS;
    private final usuariosDAO DATOSUSU;
    private auditorias obj;
    private DefaultTableModel modeloTabla;
    
    public auditoriasControl()
    {
        DATOS = new auditoriasDAO();
        DATOSUSU = new usuariosDAO();
        obj = new auditorias();
    }
    
    public DefaultTableModel Listar()
    {
        List<auditorias> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Hallazgos", "Conformidad %", "Acciones Correctivas", "Informe"};
        String[] registro = new String[8];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(auditorias item:lista)
        {
            registro[0] = String.valueOf(item.getId_auditoria());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.getHallazgos();
            registro[5] = String.valueOf(item.getPorcentaje_conformidad());
            registro[6] = item.getAcciones_correctivas();
            registro[7] = item.getInforme();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel Buscar(String nombreComp)
    {
        List<auditorias> lista = new ArrayList();
        lista.addAll(DATOS.auditorUsu(DATOSUSU.getIdConcat(nombreComp)));
        String[] titulos = {"ID", "Usuario", "Fecha", "Hora", "Hallazgos", "Conformidad %", "Acciones Correctivas", "Informe"};
        String[] registro = new String[8];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(auditorias item:lista)
        {
            registro[0] = String.valueOf(item.getId_auditoria());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = item.getFecha();
            registro[3] = item.getHora();
            registro[4] = item.getHallazgos();
            registro[5] = String.valueOf(item.getPorcentaje_conformidad());
            registro[6] = item.getAcciones_correctivas();
            registro[7] = item.getInforme();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String Insertar(int idUsuario, String fecha, String hallazgos, int conformidad, String acciones, String informe)
    {
        obj.setId_usuario(idUsuario);
        obj.setFecha_auditoria(fecha);
        obj.setHallazgos(hallazgos);
        obj.setPorcentaje_conformidad(conformidad);
        obj.setAcciones_correctivas(acciones);
        obj.setInforme(informe);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la auditoría";
    }
    
    public String Eliminar(int id)
    {
        if(DATOS.eliminar(id))
            return "OK";
        else
            return "No fue posible eliminar la auditoría";
    }
}