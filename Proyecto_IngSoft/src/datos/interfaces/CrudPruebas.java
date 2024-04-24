package datos.interfaces;

import java.util.List;

public interface CrudPruebas<T> 
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean modificar(String res, int id);
    public boolean eliminar(int id);
}