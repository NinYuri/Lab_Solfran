package datos.interfaces;

import java.util.List;

public interface CrudMonitoreo<T>
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean modificar(String datos, int id);
    public boolean eliminar(int id);
}