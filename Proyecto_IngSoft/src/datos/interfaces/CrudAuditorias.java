package datos.interfaces;

import java.util.List;

public interface CrudAuditorias<T>
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean eliminar(int id);
}