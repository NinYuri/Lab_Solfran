package datos.interfaces;

public interface CrudMuestras<T> 
{
    public boolean insertar(T obj);
    public boolean existe(int id_usuario, String fecha);
}