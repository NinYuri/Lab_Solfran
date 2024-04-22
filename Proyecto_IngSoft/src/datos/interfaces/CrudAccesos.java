package datos.interfaces;

import java.util.List;

public interface CrudAccesos<T>
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean eliminar(int id);
}