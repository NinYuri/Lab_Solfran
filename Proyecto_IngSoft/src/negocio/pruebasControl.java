package negocio;

import datos.pruebasDAO;
import datos.usuariosDAO;
import entidades.pruebas_calidad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class pruebasControl 
{
    private final pruebasDAO DATOS;
    private final usuariosDAO DATOSUSU;
    private pruebas_calidad obj;
    private DefaultTableModel modeloTabla;
    
    public pruebasControl()
    {
        DATOS = new pruebasDAO();
        DATOSUSU = new usuariosDAO();
        obj = new pruebas_calidad();
    }
    
    public DefaultTableModel Listar()
    {
        List<pruebas_calidad> lista = new ArrayList();
        lista.addAll(DATOS.datos());
        String[] titulos = {"ID", "Usuario", "ID Muestra", "Resultado"};
        String[] registro = new String[4];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(pruebas_calidad item:lista)
        {
            registro[0] = String.valueOf(item.getId_prueba());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = String.valueOf(item.getId_muestra());
            registro[3] = item.getResultado();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel Buscar(String nombreComp)
    {
        List<pruebas_calidad> lista = new ArrayList();
        lista.addAll(DATOS.pruebasUsu(DATOSUSU.getIdConcat(nombreComp)));
        String[] titulos = {"ID", "Usuario", "ID Muestra", "Resultado"};
        String[] registro = new String[4];
        modeloTabla = new DefaultTableModel(null, titulos);
        
        for(pruebas_calidad item:lista)
        {
            registro[0] = String.valueOf(item.getId_prueba());
            registro[1] = DATOSUSU.nombre(item.getId_usuario()) + " " + DATOSUSU.apellido(item.getId_usuario());
            registro[2] = String.valueOf(item.getId_muestra());
            registro[3] = item.getResultado();
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public String Insertar(int idUsuario, int idMuestra, String resultado)
    {
        obj.setId_usuario(idUsuario);
        obj.setId_muestra(idMuestra);
        obj.setResultado(resultado);
        
        if(DATOS.insertar(obj))
            return "OK";
        else
            return "Error en la inserción de la prueba";
    }
    
    public String Modificar(String res, int id)
    {
        obj.setResultado(res);
        obj.setId_prueba(id);
        
        if(DATOS.modificar(res, id))
            return "OK";
        else
            return "Error en la modificación";
    }
    
    public String Eliminar(int id)
    {
        if(DATOS.eliminar(id))
            return "OK";
        else
            return "No fue posible eliminar la muestra";
    }
}