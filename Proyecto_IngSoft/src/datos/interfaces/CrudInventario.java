package datos.interfaces;

import java.util.List;

public interface CrudInventario<T>
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean modificar(String nombre, int cant, String datos, int id);
    public boolean eliminar(int id);
}