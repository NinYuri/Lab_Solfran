package datos.interfaces;

import java.util.List;

public interface CrudMuestras<T> 
{
    public List<T> datos();
    public boolean insertar(T obj);
    public boolean existe(int id_usuario, String fecha);
    public boolean modificar(T obj);
    public boolean eliminar(int id);
}