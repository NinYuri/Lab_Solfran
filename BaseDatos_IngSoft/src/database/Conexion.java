package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion 
{
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/";
    private final String DB = "laboratorios_solfran";
    private final String USER = "root";
    private final String PASSWORD = "";
    public static Connection cadena;
    public static Conexion instancia;
    
    private Conexion() 
    {
        cadena = null;
    }
    
    public Connection Conectar() 
    {
        try {
            Class.forName(DRIVER);
            cadena = DriverManager.getConnection(URL+DB, USER, PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return cadena;
    }
    
    public void Desconectar() 
    {
        try {
            cadena.close();
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public synchronized static Conexion getInstancia() {
        if(instancia == null)
            instancia = new Conexion();
        return instancia;
    }
}