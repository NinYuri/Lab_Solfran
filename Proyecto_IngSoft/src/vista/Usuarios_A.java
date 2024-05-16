package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.message.MessageDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import negocio.accesosControl;
import negocio.auditoriasControl;
import negocio.inventarioControl;
import negocio.monitoreoControl;
import negocio.muestrasControl;
import negocio.pruebasControl;
import negocio.usuariosControl;
import vista.Usuarios_A.Contrasena;

public class Usuarios_A extends javax.swing.JFrame 
{
    MessageDialog OptionPane = new MessageDialog(this);
    private final usuariosControl CONTROL;
    private final accesosControl CONTROLACCESS;
    private final muestrasControl CONTROLMUESTRAS;
    private final pruebasControl CONTROLPRUEBAS;
    private final inventarioControl CONTROLINV;
    private final monitoreoControl CONTROLMONI;
    private final auditoriasControl CONTROLAUDI;
    Font subT = new Font("Roboto", Font.PLAIN, 20);
    Font opc = new Font("Roboto", Font.BOLD, 20);
    Font prinOpc = new Font("Roboto", Font.PLAIN, 17);
    
    Date actual = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fecha = formato.format(actual);
    
    int id, cantidad;
    String nombre, apellido, correo, rol, compExt, contCru, datosM, resPrueba, nombreLogin;
    float mg;

    public Usuarios_A() 
    {
        getContentPane().setBackground(Color.white);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);   
        
        Tipografia();
        pnlOpc2.setVisible(false);
        pnlOpc3.setVisible(false);
        lblSee.setVisible(false);
        revisarDatos.setVisible(false);        
                
        CONTROL = new usuariosControl();
        CONTROLACCESS = new accesosControl();
        CONTROLMUESTRAS = new muestrasControl();
        CONTROLPRUEBAS = new pruebasControl();
        CONTROLINV = new inventarioControl();
        CONTROLMONI = new monitoreoControl();
        CONTROLAUDI= new auditoriasControl();
        Listar();
        
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct1, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct2, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct3, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct4, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct5, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Refresh.png")), lblIconAct6, 20);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_4, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_5, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_6, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_8, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_10, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_12, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Lupa.png")), lbl_14, 0);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User.png")), lbl_1, 0);        
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);        
        Opc_2.setBackground(new Color(255, 255, 255));
        AccesosRemotos.setVisible(false);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_3.setBackground(new Color(255, 255, 255));
        Muestras.setVisible(false);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_4.setBackground(new Color(255, 255, 255));
        Pruebas.setVisible(false);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_5.setBackground(new Color(255, 255, 255));
        Inventario.setVisible(false);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_6.setBackground(new Color(255, 255, 255));
        ProdDis.setVisible(false);
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        Opc_7.setBackground(new Color(255, 255, 255));
        Auditorias.setVisible(false);
        
        nombreLogin = "";
    }
    
    public Usuarios_A(String nombre)
    {        
        this();
        nombreLogin = nombre;
    }
    
    public void Listar()
    {
        tblUsuarios.setModel(CONTROL.Listar());
    }
    
    public void ListarAccesos()
    {
        tblAccesos.setModel(CONTROLACCESS.Listar());
    }
    
    public void ListarMuestras()
    {
        tblMuestras.setModel(CONTROLMUESTRAS.Listar());
    }
    
    public void ListarPruebas()
    {
        tblPruebas.setModel(CONTROLPRUEBAS.Listar());
    }
    
    public void ListarInv()
    {
        tblInventario.setModel(CONTROLINV.Listar());
    }
    
    public void ListarMonitoreo()
    {
        tblMonitoreo.setModel(CONTROLMONI.Listar());
    }
    
    public void ListarAuditorias()
    {
        tblAccesos1.setModel(CONTROLAUDI.Listar());
    }
    
    public void Tipografia() 
    {        
        lbl1.setFont(subT);
        lbl9.setFont(subT);
        lbl10.setFont(subT);
        lbl17.setFont(subT);
        lbl19.setFont(subT);
        lbl26.setFont(subT);
        lbl32.setFont(subT);
        opc1.setFont(opc);
        opc4.setFont(opc);
        opc5.setFont(opc);
        opc8.setFont(opc);
        opc11.setFont(opc);
        opc14.setFont(opc);
        opc17.setFont(opc);
        opc2.setFont(subT);
        opc3.setFont(subT);
        opc6.setFont(subT);
        opc7.setFont(subT);
        opc9.setFont(subT);
        opc10.setFont(subT);
        opc12.setFont(subT);
        opc13.setFont(subT);
        opc15.setFont(subT);
        opc16.setFont(subT);
        lblopc_1.setFont(opc);
        lblopc_2.setFont(prinOpc);
        lblopc_3.setFont(prinOpc);
        lblopc_4.setFont(prinOpc);
        lblopc_5.setFont(prinOpc);
        lblopc_6.setFont(prinOpc);
        lblopc_7.setFont(prinOpc);
    }
    
    private boolean valTexto(String texto)
    {
        String patron = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }
    
    private String valCorreo(String correo)
    {
	String estructura = "^(?<local>[a-zA-Z0-9#'_+&-]+(?:\\.[a-zA-Z0-9#'_+&-]+)*)@(?<dominio>(?:[a-zA-Z0-9-_]+\\.)+[a-zA-Z]{2,10})$";
        Pattern patron = Pattern.compile(estructura);
	Matcher matcher = patron.matcher(correo);
			
	if(!matcher.matches()) 
	    return "El correo no cumple con la estructura";
	else 
	    if(matcher.group("local").length() > 64)
	        return "La parte local del correo no debe exceder los 64 caracteres";
	    else
	        if(matcher.group("dominio").length() > 255)
	            return "La parte de dominio del correo no debe exceder los 255 caracteres.";
	        else
                    return null;
    }
    
    private boolean valRol(String rol)
    {
        String patron = "^(Administrador|Laboratorista|Auditor)$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(rol);
        return matcher.matches();
    }
    
    private boolean valResPruebas(String res)
    {
        String patron = "^(Aceptada|Rechazada|En proceso)$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(res);
        return matcher.matches();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opc_1 = new RoundedPanel(20);
        lbl_1 = new javax.swing.JLabel();
        lblopc_1 = new javax.swing.JLabel();
        Opc_2 = new RoundedPanel(20);
        lbl_2 = new javax.swing.JLabel();
        lblopc_2 = new javax.swing.JLabel();
        Opc_3 = new RoundedPanel(20);
        lbl_3 = new javax.swing.JLabel();
        lblopc_3 = new javax.swing.JLabel();
        Opc_4 = new RoundedPanel(20);
        lbl_7 = new javax.swing.JLabel();
        lblopc_4 = new javax.swing.JLabel();
        Opc_5 = new RoundedPanel(20);
        lbl_9 = new javax.swing.JLabel();
        lblopc_5 = new javax.swing.JLabel();
        Opc_6 = new RoundedPanel(20);
        lbl_11 = new javax.swing.JLabel();
        lblopc_6 = new javax.swing.JLabel();
        Opc_7 = new RoundedPanel(20);
        lbl_13 = new javax.swing.JLabel();
        lblopc_7 = new javax.swing.JLabel();
        GestionUsuarios = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlOpc1 = new javax.swing.JPanel();
        opc1 = new javax.swing.JLabel();
        pnlOpc2 = new javax.swing.JPanel();
        opc2 = new javax.swing.JLabel();
        pnlOpc3 = new javax.swing.JPanel();
        opc3 = new javax.swing.JLabel();
        subirDatos = new javax.swing.JPanel();
        lbl3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbl4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lbl5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lbl6 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        lbl7 = new javax.swing.JLabel();
        lblSee = new javax.swing.JLabel();
        lblBlind = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        lblIniSes = new javax.swing.JLabel();
        revisarDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new rojeru_san.complementos.RSTableMetro();
        lblEliminar = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        lblIconAct = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        lbl_5 = new javax.swing.JLabel();
        AccesosRemotos = new javax.swing.JPanel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnlOpc4 = new javax.swing.JPanel();
        opc4 = new javax.swing.JLabel();
        revisarDatos1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAccesos = new rojeru_san.complementos.RSTableMetro();
        lblEliminar1 = new javax.swing.JLabel();
        lblIconAct1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lbl_4 = new javax.swing.JLabel();
        Muestras = new javax.swing.JPanel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnlOpc5 = new javax.swing.JPanel();
        opc5 = new javax.swing.JLabel();
        pnlOpc6 = new javax.swing.JPanel();
        opc6 = new javax.swing.JLabel();
        pnlOpc7 = new javax.swing.JPanel();
        opc7 = new javax.swing.JLabel();
        subirDatosM = new javax.swing.JPanel();
        lbl12 = new javax.swing.JLabel();
        txtNombreUsu = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        txtComponente = new javax.swing.JTextField();
        lbl14 = new javax.swing.JLabel();
        txtContaminacion = new javax.swing.JTextField();
        lbl15 = new javax.swing.JLabel();
        txtMg = new javax.swing.JTextField();
        lbl16 = new javax.swing.JLabel();
        lblRegMuestra = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDatos = new javax.swing.JTextArea();
        revisarDatosM = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMuestras = new rojeru_san.complementos.RSTableMetro();
        lblEliminar2 = new javax.swing.JLabel();
        lblModificar1 = new javax.swing.JLabel();
        lblIconAct2 = new javax.swing.JLabel();
        txtBuscar2 = new javax.swing.JTextField();
        lbl_6 = new javax.swing.JLabel();
        Pruebas = new javax.swing.JPanel();
        lbl17 = new javax.swing.JLabel();
        lbl18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnlOpc8 = new javax.swing.JPanel();
        opc8 = new javax.swing.JLabel();
        pnlOpc9 = new javax.swing.JPanel();
        opc9 = new javax.swing.JLabel();
        pnlOpc10 = new javax.swing.JPanel();
        opc10 = new javax.swing.JLabel();
        subirDatosP = new javax.swing.JPanel();
        lbl20 = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        txtIDMuestra = new javax.swing.JTextField();
        lbl22 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        lblRegPrueba = new javax.swing.JLabel();
        txtNombreUsuP = new javax.swing.JLabel();
        txtIDMuestraM = new javax.swing.JLabel();
        revisarDatosP = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPruebas = new rojeru_san.complementos.RSTableMetro();
        lblEliminar3 = new javax.swing.JLabel();
        lblModificar2 = new javax.swing.JLabel();
        lblIconAct3 = new javax.swing.JLabel();
        txtBuscar3 = new javax.swing.JTextField();
        lbl_8 = new javax.swing.JLabel();
        Inventario = new javax.swing.JPanel();
        lbl19 = new javax.swing.JLabel();
        lbl23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        pnlOpc11 = new javax.swing.JPanel();
        opc11 = new javax.swing.JLabel();
        pnlOpc12 = new javax.swing.JPanel();
        opc12 = new javax.swing.JLabel();
        pnlOpc13 = new javax.swing.JPanel();
        opc13 = new javax.swing.JLabel();
        subirDatosI = new javax.swing.JPanel();
        lbl24 = new javax.swing.JLabel();
        txtNombreUsuI = new javax.swing.JLabel();
        lbl25 = new javax.swing.JLabel();
        txtNomInventario = new javax.swing.JTextField();
        lbl27 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lbl28 = new javax.swing.JLabel();
        lblRegInv = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDatosI = new javax.swing.JTextArea();
        revisarDatosI = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblInventario = new rojeru_san.complementos.RSTableMetro();
        lblEliminar4 = new javax.swing.JLabel();
        lblModificar3 = new javax.swing.JLabel();
        lblIconAct4 = new javax.swing.JLabel();
        txtBuscar4 = new javax.swing.JTextField();
        lbl_10 = new javax.swing.JLabel();
        ProdDis = new javax.swing.JPanel();
        lbl26 = new javax.swing.JLabel();
        lbl29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        pnlOpc14 = new javax.swing.JPanel();
        opc14 = new javax.swing.JLabel();
        pnlOpc15 = new javax.swing.JPanel();
        opc15 = new javax.swing.JLabel();
        pnlOpc16 = new javax.swing.JPanel();
        opc16 = new javax.swing.JLabel();
        subirDatosPD = new javax.swing.JPanel();
        lbl30 = new javax.swing.JLabel();
        txtNombreUsuPD = new javax.swing.JLabel();
        lbl33 = new javax.swing.JLabel();
        lblGuardarInf = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDatosPD = new javax.swing.JTextArea();
        revisarDatosPD = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblMonitoreo = new rojeru_san.complementos.RSTableMetro();
        lblEliminar5 = new javax.swing.JLabel();
        lblModificar4 = new javax.swing.JLabel();
        lblIconAct5 = new javax.swing.JLabel();
        txtBuscar5 = new javax.swing.JTextField();
        lbl_12 = new javax.swing.JLabel();
        Auditorias = new javax.swing.JPanel();
        lbl31 = new javax.swing.JLabel();
        lbl32 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pnlOpc17 = new javax.swing.JPanel();
        opc17 = new javax.swing.JLabel();
        revisarDatos2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblAccesos1 = new rojeru_san.complementos.RSTableMetro();
        lblEliminar6 = new javax.swing.JLabel();
        lblIconAct6 = new javax.swing.JLabel();
        txtBuscar6 = new javax.swing.JTextField();
        lbl_14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Opc_1.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_1MouseClicked(evt);
            }
        });
        Opc_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_1.add(lbl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_1.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_1.setForeground(new java.awt.Color(255, 255, 255));
        lblopc_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_1.setText("Gestión de Usuarios");
        lblopc_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_1.add(lblopc_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 240, -1));

        getContentPane().add(Opc_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 320, 40));

        Opc_2.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_2MouseClicked(evt);
            }
        });
        Opc_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_2.add(lbl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_2.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_2.setText("Accesos Remotos");
        lblopc_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_2.add(lblopc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 240, -1));

        getContentPane().add(Opc_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 40));

        Opc_3.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_3MouseClicked(evt);
            }
        });
        Opc_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_3.add(lbl_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_3.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_3.setText("Gestión de Muestras");
        lblopc_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_3.add(lblopc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 240, -1));

        getContentPane().add(Opc_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 320, 40));

        Opc_4.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_4MouseClicked(evt);
            }
        });
        Opc_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_4.add(lbl_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_4.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_4.setText("Pruebas de Calidad");
        lblopc_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_4.add(lblopc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 240, -1));

        getContentPane().add(Opc_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 320, 40));

        Opc_5.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_5MouseClicked(evt);
            }
        });
        Opc_5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_5.add(lbl_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_5.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_5.setText("Control de Inventario");
        lblopc_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_5.add(lblopc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 240, -1));

        getContentPane().add(Opc_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 320, 40));

        Opc_6.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_6MouseClicked(evt);
            }
        });
        Opc_6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_6.add(lbl_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_6.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_6.setText("Producción y Distribución");
        lblopc_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_6.add(lblopc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 260, -1));

        getContentPane().add(Opc_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 320, 40));

        Opc_7.setBackground(new java.awt.Color(161,29,152, 150));
        Opc_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Opc_7MouseClicked(evt);
            }
        });
        Opc_7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Opc_7.add(lbl_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        lblopc_7.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lblopc_7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblopc_7.setText("Auditorías");
        lblopc_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Opc_7.add(lblopc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 260, -1));

        getContentPane().add(Opc_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 320, 40));

        GestionUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        GestionUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl1.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl1.setForeground(new java.awt.Color(105, 99, 135));
        lbl1.setText("Creación, modificación y eliminación de cuentas, así como la asignación de roles y permisos.");
        GestionUsuarios.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        lbl2.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl2.setForeground(new java.awt.Color(161, 29, 152));
        lbl2.setText("Gestión de Usuarios");
        GestionUsuarios.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(72, 149, 239));
        GestionUsuarios.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc1.setBackground(new java.awt.Color(72, 149, 239));
        GestionUsuarios.add(pnlOpc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 130, 7));

        opc1.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc1.setText("Subir datos");
        opc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc1MouseClicked(evt);
            }
        });
        GestionUsuarios.add(opc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 130, -1));

        pnlOpc2.setBackground(new java.awt.Color(72, 149, 239));
        GestionUsuarios.add(pnlOpc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 190, 7));

        opc2.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc2.setForeground(new java.awt.Color(105, 99, 135));
        opc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc2.setText("Revisar registros");
        opc2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc2MouseClicked(evt);
            }
        });
        GestionUsuarios.add(opc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 126, 190, -1));

        pnlOpc3.setBackground(new java.awt.Color(72, 149, 239));
        GestionUsuarios.add(pnlOpc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 155, 200, 7));

        opc3.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc3.setForeground(new java.awt.Color(105, 99, 135));
        opc3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc3.setText("Modificar registros");
        opc3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GestionUsuarios.add(opc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 126, 200, -1));

        subirDatos.setBackground(new java.awt.Color(255, 255, 255));
        subirDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl3.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl3.setText("Nombre de Usuario");
        subirDatos.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        txtNombre.setBackground(new java.awt.Color(118, 186, 254));
        txtNombre.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 45));

        lbl4.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl4.setText("Apellido Paterno");
        subirDatos.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 170, -1));

        txtApellido.setBackground(new java.awt.Color(118, 186, 254));
        txtApellido.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 45));

        lbl5.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl5.setText("Correo Electrónico");
        subirDatos.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, -1));

        txtCorreo.setBackground(new java.awt.Color(118, 186, 254));
        txtCorreo.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 660, 45));

        lbl6.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl6.setText("Rol de Usuario");
        subirDatos.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 190, -1));

        txtRol.setBackground(new java.awt.Color(118, 186, 254));
        txtRol.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtRol.setForeground(new java.awt.Color(255, 255, 255));
        txtRol.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 660, 45));

        lbl7.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl7.setText("Contraseña ");
        subirDatos.add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 190, -1));

        lblSee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/blind.png"))); // NOI18N
        lblSee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSeeMouseClicked(evt);
            }
        });
        subirDatos.add(lblSee, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, -1, -1));

        lblBlind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/see.png"))); // NOI18N
        lblBlind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBlind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBlindMouseClicked(evt);
            }
        });
        subirDatos.add(lblBlind, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, -1, -1));

        txtContrasena.setBackground(new java.awt.Color(118, 186, 254));
        txtContrasena.setFont(new java.awt.Font("Consolas", 1, 19)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(255, 255, 255));
        txtContrasena.setToolTipText("");
        txtContrasena.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 660, 45));

        lblIniSes.setBackground(new java.awt.Color(20, 89, 169));
        lblIniSes.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIniSes.setForeground(new java.awt.Color(255, 255, 255));
        lblIniSes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIniSes.setText("REGISTRAR");
        lblIniSes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIniSes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIniSes.setOpaque(true);
        lblIniSes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIniSesMouseClicked(evt);
            }
        });
        subirDatos.add(lblIniSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 430, 55));

        GestionUsuarios.add(subirDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 830, 640));

        revisarDatos.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuarios.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblUsuarios.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblUsuarios.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblUsuarios.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblUsuarios.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblUsuarios.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblUsuarios.setFuenteHead(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        tblUsuarios.setRowHeight(25);
        jScrollPane1.setViewportView(tblUsuarios);

        revisarDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 860, 480));

        lblEliminar.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar.setText("ELIMINAR");
        lblEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.setOpaque(true);
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });
        revisarDatos.add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 280, 55));

        lblModificar.setBackground(new java.awt.Color(20, 89, 169));
        lblModificar.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblModificar.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModificar.setText("MODIFICAR");
        lblModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar.setOpaque(true);
        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });
        revisarDatos.add(lblModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 280, 55));

        lblIconAct.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct.setOpaque(true);
        lblIconAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconActMouseClicked(evt);
            }
        });
        revisarDatos.add(lblIconAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 70, 55));

        GestionUsuarios.add(revisarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar1.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar1.setText(" Buscar Usuario");
        txtBuscar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar1FocusLost(evt);
            }
        });
        GestionUsuarios.add(txtBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_5MouseClicked(evt);
            }
        });
        GestionUsuarios.add(lbl_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(GestionUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        AccesosRemotos.setBackground(new java.awt.Color(255, 255, 255));
        AccesosRemotos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl8.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl8.setForeground(new java.awt.Color(161, 29, 152));
        lbl8.setText("Accesos Remotos");
        AccesosRemotos.add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lbl9.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl9.setForeground(new java.awt.Color(105, 99, 135));
        lbl9.setText("Controla y organiza los accesos remotos de manera segura y eficiente");
        AccesosRemotos.add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        jPanel4.setBackground(new java.awt.Color(72, 149, 239));
        AccesosRemotos.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc4.setBackground(new java.awt.Color(72, 149, 239));
        AccesosRemotos.add(pnlOpc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 190, 7));

        opc4.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc4.setText("Revisar Registros");
        opc4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AccesosRemotos.add(opc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 190, -1));

        revisarDatos1.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAccesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAccesos.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblAccesos.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblAccesos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblAccesos.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblAccesos.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblAccesos.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblAccesos.setFuenteHead(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        tblAccesos.setRowHeight(25);
        jScrollPane2.setViewportView(tblAccesos);

        revisarDatos1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 860, 480));

        lblEliminar1.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar1.setText("ELIMINAR");
        lblEliminar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar1.setOpaque(true);
        lblEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminar1MouseClicked(evt);
            }
        });
        revisarDatos1.add(lblEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 280, 55));

        lblIconAct1.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct1.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct1.setOpaque(true);
        lblIconAct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconAct1MouseClicked(evt);
            }
        });
        revisarDatos1.add(lblIconAct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 70, 55));

        AccesosRemotos.add(revisarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar.setText(" Buscar Usuario");
        txtBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        AccesosRemotos.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_4MouseClicked(evt);
            }
        });
        AccesosRemotos.add(lbl_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(AccesosRemotos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        Muestras.setBackground(new java.awt.Color(255, 255, 255));
        Muestras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl10.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl10.setForeground(new java.awt.Color(105, 99, 135));
        lbl10.setText("Visualización y gestión de los resultados de las muestras analizadas en el laboratorio.");
        Muestras.add(lbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        lbl11.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl11.setForeground(new java.awt.Color(161, 29, 152));
        lbl11.setText("Resultados de Muestras");
        Muestras.add(lbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(72, 149, 239));
        Muestras.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc5.setBackground(new java.awt.Color(72, 149, 239));
        Muestras.add(pnlOpc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 130, 7));

        opc5.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc5.setText("Subir datos");
        opc5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc5MouseClicked(evt);
            }
        });
        Muestras.add(opc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 130, -1));

        pnlOpc6.setBackground(new java.awt.Color(72, 149, 239));
        Muestras.add(pnlOpc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 190, 7));

        opc6.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc6.setForeground(new java.awt.Color(105, 99, 135));
        opc6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc6.setText("Revisar registros");
        opc6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc6MouseClicked(evt);
            }
        });
        Muestras.add(opc6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 126, 190, -1));

        pnlOpc7.setBackground(new java.awt.Color(72, 149, 239));
        Muestras.add(pnlOpc7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 155, 200, 7));

        opc7.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc7.setForeground(new java.awt.Color(105, 99, 135));
        opc7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc7.setText("Modificar registros");
        opc7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Muestras.add(opc7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 126, 200, -1));

        subirDatosM.setBackground(new java.awt.Color(255, 255, 255));
        subirDatosM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl12.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl12.setText("Nombre de Usuario");
        subirDatosM.add(lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, -1));

        txtNombreUsu.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        txtNombreUsu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtNombreUsu.setText("\"\"");
        txtNombreUsu.setToolTipText("");
        subirDatosM.add(txtNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 45));

        lbl13.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl13.setText("Componente Extraño");
        subirDatosM.add(lbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, -1));

        txtComponente.setBackground(new java.awt.Color(118, 186, 254));
        txtComponente.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtComponente.setForeground(new java.awt.Color(255, 255, 255));
        txtComponente.setText("SI / NO");
        txtComponente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtComponente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtComponenteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtComponenteFocusLost(evt);
            }
        });
        subirDatosM.add(txtComponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 300, 45));

        lbl14.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl14.setText("Contaminación Cruzada");
        subirDatosM.add(lbl14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 280, -1));

        txtContaminacion.setBackground(new java.awt.Color(118, 186, 254));
        txtContaminacion.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtContaminacion.setForeground(new java.awt.Color(255, 255, 255));
        txtContaminacion.setText("SI / NO");
        txtContaminacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtContaminacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContaminacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContaminacionFocusLost(evt);
            }
        });
        subirDatosM.add(txtContaminacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 300, 45));

        lbl15.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl15.setText("Miligramos");
        subirDatosM.add(lbl15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, -1));

        txtMg.setBackground(new java.awt.Color(118, 186, 254));
        txtMg.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtMg.setForeground(new java.awt.Color(255, 255, 255));
        txtMg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatosM.add(txtMg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 660, 45));

        lbl16.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl16.setText("Datos");
        subirDatosM.add(lbl16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 190, -1));

        lblRegMuestra.setBackground(new java.awt.Color(20, 89, 169));
        lblRegMuestra.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblRegMuestra.setForeground(new java.awt.Color(255, 255, 255));
        lblRegMuestra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegMuestra.setText("INSERTAR MUESTRA");
        lblRegMuestra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRegMuestra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegMuestra.setOpaque(true);
        lblRegMuestra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegMuestraMouseClicked(evt);
            }
        });
        subirDatosM.add(lblRegMuestra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 430, 55));

        txtDatos.setBackground(new java.awt.Color(118, 186, 254));
        txtDatos.setColumns(20);
        txtDatos.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtDatos.setForeground(new java.awt.Color(255, 255, 255));
        txtDatos.setRows(5);
        txtDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane4.setViewportView(txtDatos);

        subirDatosM.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 660, 140));

        Muestras.add(subirDatosM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 830, 640));

        revisarDatosM.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatosM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMuestras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMuestras.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblMuestras.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblMuestras.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblMuestras.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblMuestras.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblMuestras.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblMuestras.setFuenteHead(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        tblMuestras.setRowHeight(25);
        jScrollPane3.setViewportView(tblMuestras);

        revisarDatosM.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 480));

        lblEliminar2.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar2.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar2.setText("ELIMINAR");
        lblEliminar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar2.setOpaque(true);
        lblEliminar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminar2MouseClicked(evt);
            }
        });
        revisarDatosM.add(lblEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 280, 55));

        lblModificar1.setBackground(new java.awt.Color(20, 89, 169));
        lblModificar1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblModificar1.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModificar1.setText("MODIFICAR");
        lblModificar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar1.setOpaque(true);
        lblModificar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificar1MouseClicked(evt);
            }
        });
        revisarDatosM.add(lblModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 280, 55));

        lblIconAct2.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct2.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct2.setOpaque(true);
        lblIconAct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconAct2MouseClicked(evt);
            }
        });
        revisarDatosM.add(lblIconAct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 70, 55));

        Muestras.add(revisarDatosM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar2.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar2.setText(" Buscar Usuario");
        txtBuscar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar2FocusLost(evt);
            }
        });
        Muestras.add(txtBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_6MouseClicked(evt);
            }
        });
        Muestras.add(lbl_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(Muestras, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        Pruebas.setBackground(new java.awt.Color(255, 255, 255));
        Pruebas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl17.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl17.setForeground(new java.awt.Color(105, 99, 135));
        lbl17.setText("Ingresa y actualiza los resultados de las pruebas de calidad realizadas en las muestras.");
        Pruebas.add(lbl17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        lbl18.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl18.setForeground(new java.awt.Color(161, 29, 152));
        lbl18.setText("Pruebas de Calidad");
        Pruebas.add(lbl18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(72, 149, 239));
        Pruebas.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc8.setBackground(new java.awt.Color(72, 149, 239));
        Pruebas.add(pnlOpc8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 130, 7));

        opc8.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc8.setText("Subir datos");
        opc8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc8MouseClicked(evt);
            }
        });
        Pruebas.add(opc8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 130, -1));

        pnlOpc9.setBackground(new java.awt.Color(72, 149, 239));
        Pruebas.add(pnlOpc9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 190, 7));

        opc9.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc9.setForeground(new java.awt.Color(105, 99, 135));
        opc9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc9.setText("Revisar registros");
        opc9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc9MouseClicked(evt);
            }
        });
        Pruebas.add(opc9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 126, 190, -1));

        pnlOpc10.setBackground(new java.awt.Color(72, 149, 239));
        Pruebas.add(pnlOpc10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 155, 220, 7));

        opc10.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc10.setForeground(new java.awt.Color(105, 99, 135));
        opc10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc10.setText("Actualizar resultados");
        opc10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pruebas.add(opc10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 126, 220, -1));

        subirDatosP.setBackground(new java.awt.Color(255, 255, 255));
        subirDatosP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl20.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl20.setText("Nombre de Usuario");
        subirDatosP.add(lbl20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, -1));

        lbl21.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl21.setText("ID de la Muestra");
        subirDatosP.add(lbl21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 280, -1));

        txtIDMuestra.setBackground(new java.awt.Color(118, 186, 254));
        txtIDMuestra.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtIDMuestra.setForeground(new java.awt.Color(255, 255, 255));
        txtIDMuestra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatosP.add(txtIDMuestra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 45));

        lbl22.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl22.setText("Resultado");
        subirDatosP.add(lbl22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, -1));

        txtResultado.setBackground(new java.awt.Color(118, 186, 254));
        txtResultado.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(255, 255, 255));
        txtResultado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatosP.add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 660, 45));

        lblRegPrueba.setBackground(new java.awt.Color(20, 89, 169));
        lblRegPrueba.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblRegPrueba.setForeground(new java.awt.Color(255, 255, 255));
        lblRegPrueba.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegPrueba.setText("INSERTAR PRUEBA");
        lblRegPrueba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRegPrueba.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegPrueba.setOpaque(true);
        lblRegPrueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegPruebaMouseClicked(evt);
            }
        });
        subirDatosP.add(lblRegPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 430, 55));

        txtNombreUsuP.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        txtNombreUsuP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtNombreUsuP.setText("\"\"");
        txtNombreUsuP.setToolTipText("");
        subirDatosP.add(txtNombreUsuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 45));

        txtIDMuestraM.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        txtIDMuestraM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtIDMuestraM.setText("\"\"");
        txtIDMuestraM.setToolTipText("");
        subirDatosP.add(txtIDMuestraM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 45));

        Pruebas.add(subirDatosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 830, 640));

        revisarDatosP.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatosP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPruebas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPruebas.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblPruebas.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblPruebas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblPruebas.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblPruebas.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblPruebas.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblPruebas.setFuenteHead(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        tblPruebas.setRowHeight(25);
        jScrollPane6.setViewportView(tblPruebas);

        revisarDatosP.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 860, 480));

        lblEliminar3.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar3.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar3.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar3.setText("ELIMINAR");
        lblEliminar3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar3.setOpaque(true);
        lblEliminar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminar3MouseClicked(evt);
            }
        });
        revisarDatosP.add(lblEliminar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 280, 55));

        lblModificar2.setBackground(new java.awt.Color(20, 89, 169));
        lblModificar2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblModificar2.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModificar2.setText("ACTUALIZAR RESULTADO");
        lblModificar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar2.setOpaque(true);
        lblModificar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificar2MouseClicked(evt);
            }
        });
        revisarDatosP.add(lblModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 320, 55));

        lblIconAct3.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct3.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct3.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct3.setOpaque(true);
        lblIconAct3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconAct3MouseClicked(evt);
            }
        });
        revisarDatosP.add(lblIconAct3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 70, 55));

        Pruebas.add(revisarDatosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar3.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar3.setText(" Buscar Usuario");
        txtBuscar3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar3FocusLost(evt);
            }
        });
        Pruebas.add(txtBuscar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_8MouseClicked(evt);
            }
        });
        Pruebas.add(lbl_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(Pruebas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        Inventario.setBackground(new java.awt.Color(255, 255, 255));
        Inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl19.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl19.setForeground(new java.awt.Color(105, 99, 135));
        lbl19.setText("Seguimiento y control del inventario de los productos mediante el registro de sus entradas.");
        Inventario.add(lbl19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        lbl23.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl23.setForeground(new java.awt.Color(161, 29, 152));
        lbl23.setText("Gestión de Inventario");
        Inventario.add(lbl23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(72, 149, 239));
        Inventario.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc11.setBackground(new java.awt.Color(72, 149, 239));
        Inventario.add(pnlOpc11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 130, 7));

        opc11.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc11.setText("Subir datos");
        opc11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc11MouseClicked(evt);
            }
        });
        Inventario.add(opc11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 130, -1));

        pnlOpc12.setBackground(new java.awt.Color(72, 149, 239));
        Inventario.add(pnlOpc12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 190, 7));

        opc12.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc12.setForeground(new java.awt.Color(105, 99, 135));
        opc12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc12.setText("Revisar registros");
        opc12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc12MouseClicked(evt);
            }
        });
        Inventario.add(opc12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 126, 190, -1));

        pnlOpc13.setBackground(new java.awt.Color(72, 149, 239));
        Inventario.add(pnlOpc13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 155, 200, 7));

        opc13.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc13.setForeground(new java.awt.Color(105, 99, 135));
        opc13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc13.setText("Modificar registros");
        opc13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Inventario.add(opc13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 126, 200, -1));

        subirDatosI.setBackground(new java.awt.Color(255, 255, 255));
        subirDatosI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl24.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl24.setText("Nombre de Usuario");
        subirDatosI.add(lbl24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, -1));

        txtNombreUsuI.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        txtNombreUsuI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtNombreUsuI.setText("\"\"");
        txtNombreUsuI.setToolTipText("");
        subirDatosI.add(txtNombreUsuI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 45));

        lbl25.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl25.setText("Título de Inventario");
        subirDatosI.add(lbl25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 230, -1));

        txtNomInventario.setBackground(new java.awt.Color(118, 186, 254));
        txtNomInventario.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtNomInventario.setForeground(new java.awt.Color(255, 255, 255));
        txtNomInventario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatosI.add(txtNomInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 45));

        lbl27.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl27.setText("Cantidad");
        subirDatosI.add(lbl27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, -1));

        txtCantidad.setBackground(new java.awt.Color(118, 186, 254));
        txtCantidad.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatosI.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 660, 45));

        lbl28.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl28.setText("Datos");
        subirDatosI.add(lbl28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 190, -1));

        lblRegInv.setBackground(new java.awt.Color(20, 89, 169));
        lblRegInv.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblRegInv.setForeground(new java.awt.Color(255, 255, 255));
        lblRegInv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegInv.setText("REGISTRAR INVENTARIO");
        lblRegInv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRegInv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegInv.setOpaque(true);
        lblRegInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegInvMouseClicked(evt);
            }
        });
        subirDatosI.add(lblRegInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 430, 55));

        txtDatosI.setBackground(new java.awt.Color(118, 186, 254));
        txtDatosI.setColumns(20);
        txtDatosI.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtDatosI.setForeground(new java.awt.Color(255, 255, 255));
        txtDatosI.setRows(5);
        txtDatosI.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane5.setViewportView(txtDatosI);

        subirDatosI.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 660, 140));

        Inventario.add(subirDatosI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 830, 640));

        revisarDatosI.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatosI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInventario.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblInventario.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblInventario.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblInventario.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblInventario.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblInventario.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblInventario.setFuenteHead(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        tblInventario.setRowHeight(25);
        jScrollPane7.setViewportView(tblInventario);

        revisarDatosI.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 480));

        lblEliminar4.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar4.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar4.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar4.setText("ELIMINAR");
        lblEliminar4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar4.setOpaque(true);
        lblEliminar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminar4MouseClicked(evt);
            }
        });
        revisarDatosI.add(lblEliminar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 280, 55));

        lblModificar3.setBackground(new java.awt.Color(20, 89, 169));
        lblModificar3.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblModificar3.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModificar3.setText("MODIFICAR");
        lblModificar3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar3.setOpaque(true);
        lblModificar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificar3MouseClicked(evt);
            }
        });
        revisarDatosI.add(lblModificar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 280, 55));

        lblIconAct4.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct4.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct4.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct4.setOpaque(true);
        lblIconAct4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconAct4MouseClicked(evt);
            }
        });
        revisarDatosI.add(lblIconAct4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 70, 55));

        Inventario.add(revisarDatosI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar4.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar4.setText(" Buscar Usuario");
        txtBuscar4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar4FocusLost(evt);
            }
        });
        Inventario.add(txtBuscar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_10MouseClicked(evt);
            }
        });
        Inventario.add(lbl_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        ProdDis.setBackground(new java.awt.Color(255, 255, 255));
        ProdDis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl26.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl26.setForeground(new java.awt.Color(105, 99, 135));
        lbl26.setText("Generación de informes sobre la producción y distribución de los productos");
        ProdDis.add(lbl26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        lbl29.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl29.setForeground(new java.awt.Color(161, 29, 152));
        lbl29.setText("Monitoreo de Producción y Distribución");
        ProdDis.add(lbl29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel8.setBackground(new java.awt.Color(72, 149, 239));
        ProdDis.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc14.setBackground(new java.awt.Color(72, 149, 239));
        ProdDis.add(pnlOpc14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 130, 7));

        opc14.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc14.setText("Subir datos");
        opc14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc14MouseClicked(evt);
            }
        });
        ProdDis.add(opc14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 130, -1));

        pnlOpc15.setBackground(new java.awt.Color(72, 149, 239));
        ProdDis.add(pnlOpc15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 190, 7));

        opc15.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc15.setForeground(new java.awt.Color(105, 99, 135));
        opc15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc15.setText("Revisar registros");
        opc15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc15MouseClicked(evt);
            }
        });
        ProdDis.add(opc15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 126, 190, -1));

        pnlOpc16.setBackground(new java.awt.Color(72, 149, 239));
        ProdDis.add(pnlOpc16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 155, 200, 7));

        opc16.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc16.setForeground(new java.awt.Color(105, 99, 135));
        opc16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc16.setText("Modificar registros");
        opc16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ProdDis.add(opc16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 126, 200, -1));

        subirDatosPD.setBackground(new java.awt.Color(255, 255, 255));
        subirDatosPD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl30.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl30.setText("Nombre de Usuario");
        subirDatosPD.add(lbl30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, -1));

        txtNombreUsuPD.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        txtNombreUsuPD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtNombreUsuPD.setText("\"\"");
        txtNombreUsuPD.setToolTipText("");
        subirDatosPD.add(txtNombreUsuPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 45));

        lbl33.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl33.setText("Datos");
        subirDatosPD.add(lbl33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, -1));

        lblGuardarInf.setBackground(new java.awt.Color(20, 89, 169));
        lblGuardarInf.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblGuardarInf.setForeground(new java.awt.Color(255, 255, 255));
        lblGuardarInf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGuardarInf.setText("GUARDAR INFORME");
        lblGuardarInf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblGuardarInf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGuardarInf.setOpaque(true);
        lblGuardarInf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarInfMouseClicked(evt);
            }
        });
        subirDatosPD.add(lblGuardarInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 430, 55));

        txtDatosPD.setBackground(new java.awt.Color(118, 186, 254));
        txtDatosPD.setColumns(20);
        txtDatosPD.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtDatosPD.setForeground(new java.awt.Color(255, 255, 255));
        txtDatosPD.setRows(5);
        txtDatosPD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane8.setViewportView(txtDatosPD);

        subirDatosPD.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 340));

        ProdDis.add(subirDatosPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 830, 640));

        revisarDatosPD.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatosPD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMonitoreo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMonitoreo.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblMonitoreo.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblMonitoreo.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblMonitoreo.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblMonitoreo.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblMonitoreo.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        tblMonitoreo.setFuenteHead(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        tblMonitoreo.setRowHeight(25);
        jScrollPane9.setViewportView(tblMonitoreo);

        revisarDatosPD.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 480));

        lblEliminar5.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar5.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar5.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar5.setText("ELIMINAR");
        lblEliminar5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar5.setOpaque(true);
        lblEliminar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminar5MouseClicked(evt);
            }
        });
        revisarDatosPD.add(lblEliminar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 280, 55));

        lblModificar4.setBackground(new java.awt.Color(20, 89, 169));
        lblModificar4.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblModificar4.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModificar4.setText("MODIFICAR");
        lblModificar4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModificar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar4.setOpaque(true);
        lblModificar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificar4MouseClicked(evt);
            }
        });
        revisarDatosPD.add(lblModificar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 280, 55));

        lblIconAct5.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct5.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct5.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct5.setOpaque(true);
        lblIconAct5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconAct5MouseClicked(evt);
            }
        });
        revisarDatosPD.add(lblIconAct5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 70, 55));

        ProdDis.add(revisarDatosPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar5.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar5.setText(" Buscar Usuario");
        txtBuscar5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar5FocusLost(evt);
            }
        });
        ProdDis.add(txtBuscar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_12MouseClicked(evt);
            }
        });
        ProdDis.add(lbl_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(ProdDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        Auditorias.setBackground(new java.awt.Color(255, 255, 255));
        Auditorias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl31.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl31.setForeground(new java.awt.Color(161, 29, 152));
        lbl31.setText("Auditorías");
        Auditorias.add(lbl31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lbl32.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl32.setForeground(new java.awt.Color(105, 99, 135));
        lbl32.setText("Controla y organiza los resultados de las auditorías de manera segura y eficiente");
        Auditorias.add(lbl32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1080, -1));

        jPanel9.setBackground(new java.awt.Color(72, 149, 239));
        Auditorias.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 900, 2));

        pnlOpc17.setBackground(new java.awt.Color(72, 149, 239));
        Auditorias.add(pnlOpc17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 190, 7));

        opc17.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc17.setText("Revisar Registros");
        opc17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Auditorias.add(opc17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 190, -1));

        revisarDatos2.setBackground(new java.awt.Color(255, 255, 255));
        revisarDatos2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAccesos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAccesos1.setColorBackgoundHead(new java.awt.Color(20, 89, 169));
        tblAccesos1.setColorFilasBackgound2(new java.awt.Color(72, 149, 239));
        tblAccesos1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblAccesos1.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tblAccesos1.setFuenteFilas(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        tblAccesos1.setFuenteFilasSelect(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        tblAccesos1.setFuenteHead(new java.awt.Font("Roboto Black", 0, 13)); // NOI18N
        tblAccesos1.setRowHeight(25);
        jScrollPane10.setViewportView(tblAccesos1);

        revisarDatos2.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 860, 480));

        lblEliminar6.setBackground(new java.awt.Color(20, 89, 169));
        lblEliminar6.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblEliminar6.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar6.setText("ELIMINAR");
        lblEliminar6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblEliminar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar6.setOpaque(true);
        lblEliminar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminar6MouseClicked(evt);
            }
        });
        revisarDatos2.add(lblEliminar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 280, 55));

        lblIconAct6.setBackground(new java.awt.Color(20, 89, 169));
        lblIconAct6.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lblIconAct6.setForeground(new java.awt.Color(255, 255, 255));
        lblIconAct6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconAct6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblIconAct6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconAct6.setOpaque(true);
        lblIconAct6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconAct6MouseClicked(evt);
            }
        });
        revisarDatos2.add(lblIconAct6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 70, 55));

        Auditorias.add(revisarDatos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 910, 640));

        txtBuscar6.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtBuscar6.setText(" Buscar Usuario");
        txtBuscar6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBuscar6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscar6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscar6FocusLost(evt);
            }
        });
        Auditorias.add(txtBuscar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 123, 190, 30));

        lbl_14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_14MouseClicked(evt);
            }
        });
        Auditorias.add(lbl_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 125, 30, 25));

        getContentPane().add(Auditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 1100, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSeeMouseClicked
        lblBlind.setVisible(true);
        lblSee.setVisible(false);
        txtContrasena.setEchoChar('*');
    }//GEN-LAST:event_lblSeeMouseClicked

    private void lblBlindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBlindMouseClicked
        lblBlind.setVisible(false);
        lblSee.setVisible(true);
        txtContrasena.setEchoChar((char)0);
    }//GEN-LAST:event_lblBlindMouseClicked

    private void lblIniSesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIniSesMouseClicked
        String resp;  
              
        if(lblIniSes.getText().equals("REGISTRAR"))
        {
            if(!txtNombre.getText().isEmpty() && !txtNombre.getText().equals(" Nombre de usuario"))
                if(!valTexto(txtNombre.getText()))
                    OptionPane.showMessage("Registro en el Sistema", "El nombre de usuario no puede contener números", "/img/iconos/Close.png");
                else
                    if(!txtApellido.getText().isEmpty() && !txtApellido.getText().equals(" Apellido paterno"))
                        if(!valTexto(txtApellido.getText()))
                            OptionPane.showMessage("Registro en el Sistema", "El apellido del usuario no puede contener números", "/img/iconos/Close.png");
                        else
                            if(CONTROL.Existe(txtNombre.getText(), txtApellido.getText()))
                                OptionPane.showMessage("Registro en el Sistema", "El usuario " + txtNombre.getText() + " " + txtApellido.getText() + " ya se encuentra registrado", "/img/iconos/Close.png");
                            else
                                if(!txtCorreo.getText().isEmpty() && !txtCorreo.getText().equals(" Correo electrónico"))
                                    if(valCorreo(txtCorreo.getText()) != null)
                                        OptionPane.showMessage("Registro en el Sistema", valCorreo(txtCorreo.getText()), "/img/iconos/Close.png");
                                    else
                                        if(!txtRol.getText().isEmpty() && !txtRol.getText().equals(" Rol de usuario"))
                                            if(!valRol(txtRol.getText()))
                                                OptionPane.showMessage("Registro en el Sistema", "Los roles son Administrador, Laboratorista o Auditor", "/img/iconos/Close.png");
                                            else
                                                if(!String.valueOf(txtContrasena.getPassword()).isEmpty() && !String.valueOf(txtContrasena.getPassword()).equals(" Contraseña")) 
                                                {
                                                    Contrasena obc = new Contrasena(String.valueOf(txtContrasena.getPassword()));
                                                    if(obc.ValidarContrasena())
                                                    {                                                   
                                                        resp = CONTROL.Insertar(txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), String.valueOf(txtContrasena.getPassword()), txtRol.getText());
                                                        OptionPane.showMessage("Registro en el Sistema", "Usuario registrado exitosamente", "/img/iconos/Info.png");                                                    

                                                        Listar();
                                                        txtNombre.setText("");
                                                        txtApellido.setText("");
                                                        txtCorreo.setText("");
                                                        txtContrasena.setText("");
                                                        txtRol.setText("");
                                                    }
                                                    else
                                                        OptionPane.showMessage("Registro en el Sistema", obc.Error(), "/img/iconos/Close.png");                                               
                                                }
                                                else
                                                    OptionPane.showMessage("Registro en el Sistema", "Debe ingresar una contraseña", "/img/iconos/Close.png");
                                        else
                                            OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un rol de trabajo", "/img/iconos/Close.png");
                                else
                                    OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un correo electrónico", "/img/iconos/Close.png");
                    else
                        OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un apellido paterno", "/img/iconos/Close.png");
            else
                OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un nombre de usuario", "/img/iconos/Close.png");
        }
        else
            if(lblIniSes.getText().equals("MODIFICAR"))
            {
                if(!txtNombre.getText().isEmpty() && !txtNombre.getText().equals(" Nombre de usuario"))
                    if(!valTexto(txtNombre.getText()))
                        OptionPane.showMessage("Registro en el Sistema", "El nombre de usuario no puede contener números", "/img/iconos/Close.png");
                    else
                        if(!txtApellido.getText().isEmpty() && !txtApellido.getText().equals(" Apellido paterno"))
                            if(!valTexto(txtApellido.getText()))
                                OptionPane.showMessage("Registro en el Sistema", "El apellido del usuario no puede contener números", "/img/iconos/Close.png");
                            else
                                if(!txtCorreo.getText().isEmpty() && !txtCorreo.getText().equals(" Correo electrónico"))
                                    if(valCorreo(txtCorreo.getText()) != null)
                                        OptionPane.showMessage("Registro en el Sistema", valCorreo(txtCorreo.getText()), "/img/iconos/Close.png");
                                    else
                                        if(!txtRol.getText().isEmpty() && !txtRol.getText().equals(" Rol de usuario"))
                                            if(!valRol(txtRol.getText()))
                                                OptionPane.showMessage("Registro en el Sistema", "Los roles son Administrador, Laboratorista o Auditor", "/img/iconos/Close.png");
                                            else
                                            {
                                                nombre = txtNombre.getText();
                                                apellido = txtApellido.getText();
                                                correo = txtCorreo.getText();
                                                rol = txtRol.getText();
                                                
                                                resp = CONTROL.Modificar(id, nombre, apellido, correo, rol);
                                                OptionPane.showMessage("Registro en el Sistema", "Usuario " + txtNombre.getText() + " " + txtApellido.getText() + " modificado exitosamente", "/img/iconos/Info.png");                                                    

                                                txtNombre.setText("");
                                                txtApellido.setText("");
                                                txtCorreo.setText("");
                                                txtRol.setText("");
                                                Listar();
                                                opc1.setFont(subT);
                                                opc1.setForeground(new Color(105,99,135));
                                                opc2.setFont(opc);
                                                opc2.setForeground(new Color(0,0,0));     
                                                opc3.setFont(subT);
                                                opc3.setForeground(new Color(105,99,135)); 
                                                pnlOpc1.setVisible(false);
                                                pnlOpc2.setVisible(true); 
                                                pnlOpc3.setVisible(false);
                                                revisarDatos.setVisible(true);
                                                subirDatos.setVisible(false);
                                            }                                                    
                                            else
                                                OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un rol de trabajo", "/img/iconos/Close.png");
                                    else
                                        OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un correo electrónico", "/img/iconos/Close.png");
                        else
                            OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un apellido paterno", "/img/iconos/Close.png");
                else
                    OptionPane.showMessage("Registro en el Sistema", "Debe ingresar un nombre de usuario", "/img/iconos/Close.png");
            }
    }//GEN-LAST:event_lblIniSesMouseClicked

    private void opc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc1MouseClicked
        opc1.setFont(opc);
        opc1.setForeground(new Color(0,0,0));
        opc2.setFont(subT);
        opc2.setForeground(new Color(105,99,135));     
        opc3.setFont(subT);
        opc3.setForeground(new Color(105,99,135)); 
        pnlOpc1.setVisible(true);
        pnlOpc2.setVisible(false); 
        pnlOpc3.setVisible(false);
        revisarDatos.setVisible(false);
        subirDatos.setVisible(true);     
        lbl7.setVisible(true);
        lblBlind.setVisible(true);
        txtContrasena.setVisible(true);
        lblIniSes.setText("REGISTRAR");
    }//GEN-LAST:event_opc1MouseClicked

    private void opc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc2MouseClicked
        opc1.setFont(subT);
        opc1.setForeground(new Color(105,99,135));
        opc2.setFont(opc);
        opc2.setForeground(new Color(0,0,0));
        opc3.setFont(subT);
        opc3.setForeground(new Color(105,99,135));
        pnlOpc1.setVisible(false);
        pnlOpc2.setVisible(true);
        pnlOpc3.setVisible(false);
        subirDatos.setVisible(false);
        revisarDatos.setVisible(true);
    }//GEN-LAST:event_opc2MouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        if(tblUsuarios.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0)));
            nombre = String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 1));
            rol = String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 3));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar al " + rol + " " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROL.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Usuario eliminado", "/img/iconos/Info.png");
                    Listar();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar al usuario " + nombre, "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar un usuario de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        if(tblUsuarios.getSelectedRowCount() == 1)
        {
            opc1.setFont(subT);
            opc1.setForeground(new Color(105, 99, 135));
            opc2.setFont(subT);
            opc2.setForeground(new Color(105,99,135));
            opc3.setFont(opc);
            opc3.setForeground(new Color(0,0,0));
            pnlOpc1.setVisible(false);
            pnlOpc2.setVisible(false);
            pnlOpc3.setVisible(true);
            subirDatos.setVisible(true);
            revisarDatos.setVisible(false);
            
            lbl7.setVisible(false);
            lblSee.setVisible(false);
            lblBlind.setVisible(false);
            txtContrasena.setVisible(false);
            lblIniSes.setText("MODIFICAR");
            
            id  = Integer.parseInt(String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0)));            
            nombre = CONTROL.getNombre(id);
            apellido = CONTROL.getApellido(id);
            correo = String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 2));
            rol = String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 3));
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtCorreo.setText(correo);
            txtRol.setText(rol);
        }
        else
            OptionPane.showMessage("Modificar", "Debe seleccionar un usuario de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblIconActMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconActMouseClicked
        Listar();
    }//GEN-LAST:event_lblIconActMouseClicked

    private void Opc_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_1MouseClicked
        Opc_1.setBackground(new Color(161,29,152, 150));
        lblopc_1.setFont(opc);
        lblopc_1.setForeground(new Color(255, 255, 255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(255,255,255));
        lblopc_2.setFont(prinOpc);
        lblopc_2.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(255,255,255));
        lblopc_3.setFont(prinOpc);
        lblopc_3.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(255,255,255));
        lblopc_4.setFont(prinOpc);
        lblopc_4.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(255,255,255));
        lblopc_5.setFont(prinOpc);
        lblopc_5.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(255,255,255));
        lblopc_6.setFont(prinOpc);
        lblopc_6.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(255,255,255));
        lblopc_7.setFont(prinOpc);
        lblopc_7.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(true);
        opc1.setFont(opc);
        opc1.setForeground(new Color(0,0,0));
        opc2.setFont(subT);
        opc2.setForeground(new Color(105,99,135));     
        opc3.setFont(subT);
        opc3.setForeground(new Color(105,99,135)); 
        pnlOpc1.setVisible(true);
        pnlOpc2.setVisible(false); 
        pnlOpc3.setVisible(false);
        revisarDatos.setVisible(false);
        subirDatos.setVisible(true);     
        lbl7.setVisible(true);
        lblBlind.setVisible(true);
        txtContrasena.setVisible(true);
        lblIniSes.setText("REGISTRAR");
        txtBuscar1.setText(" Buscar Usuario");
        
        AccesosRemotos.setVisible(false);
        Muestras.setVisible(false);
        Pruebas.setVisible(false);
        Inventario.setVisible(false);
        ProdDis.setVisible(false);
        Auditorias.setVisible(false);
    }//GEN-LAST:event_Opc_1MouseClicked

    private void Opc_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_2MouseClicked
        Opc_1.setBackground(new Color(255,255,255));
        lblopc_1.setFont(prinOpc);
        lblopc_1.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User_B.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(161,29,152, 150));
        lblopc_2.setFont(opc);
        lblopc_2.setForeground(new Color(255,255,255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(255,255,255));
        lblopc_3.setFont(prinOpc);
        lblopc_3.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(255,255,255));
        lblopc_4.setFont(prinOpc);
        lblopc_4.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(255,255,255));
        lblopc_5.setFont(prinOpc);
        lblopc_5.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(255,255,255));
        lblopc_6.setFont(prinOpc);
        lblopc_6.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(255,255,255));
        lblopc_7.setFont(prinOpc);
        lblopc_7.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(false);
        AccesosRemotos.setVisible(true);
        ListarAccesos();
        txtBuscar.setText(" Buscar Usuario");
        Muestras.setVisible(false);
        Pruebas.setVisible(false);
        Inventario.setVisible(false);
        ProdDis.setVisible(false);
        Auditorias.setVisible(false);
    }//GEN-LAST:event_Opc_2MouseClicked

    private void lblEliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminar1MouseClicked
        if(tblAccesos.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblAccesos.getValueAt(tblAccesos.getSelectedRow(), 0)));
            nombre = String.valueOf(tblAccesos.getValueAt(tblAccesos.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar el acceso remoto del usuario " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROLACCESS.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Acceso eliminado", "/img/iconos/Info.png");
                    ListarAccesos();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar el acceso remoto", "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar un acceso remoto de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminar1MouseClicked

    private void lblIconAct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconAct1MouseClicked
        ListarAccesos();
    }//GEN-LAST:event_lblIconAct1MouseClicked

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if(txtBuscar.getText().equals(" Buscar Usuario"))
            txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if(txtBuscar.getText().isEmpty())
            txtBuscar.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscarFocusLost

    private void lbl_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_4MouseClicked
        if(!txtBuscar.getText().isEmpty() && !txtBuscar.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar.getText()))
                tblAccesos.setModel(CONTROLACCESS.Buscar(txtBuscar.getText()));         
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_4MouseClicked

    private void txtBuscar1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar1FocusGained
        if(txtBuscar1.getText().equals(" Buscar Usuario"))
            txtBuscar1.setText("");
    }//GEN-LAST:event_txtBuscar1FocusGained

    private void txtBuscar1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar1FocusLost
        if(txtBuscar1.getText().isEmpty())
            txtBuscar1.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscar1FocusLost

    private void lbl_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_5MouseClicked
        if(!txtBuscar1.getText().isEmpty() && !txtBuscar1.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar1.getText()))              
                tblUsuarios.setModel(CONTROL.Buscar(txtBuscar1.getText()));          
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar1.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_5MouseClicked

    private void Opc_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_3MouseClicked
        Opc_1.setBackground(new Color(255,255,255));
        lblopc_1.setFont(prinOpc);
        lblopc_1.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User_B.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(255,255,255));
        lblopc_2.setFont(prinOpc);
        lblopc_2.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(161,29,152, 150));
        lblopc_3.setFont(opc);
        lblopc_3.setForeground(new Color(255,255,255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(255,255,255));
        lblopc_4.setFont(prinOpc);
        lblopc_4.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(255,255,255));
        lblopc_5.setFont(prinOpc);
        lblopc_5.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(255,255,255));
        lblopc_6.setFont(prinOpc);
        lblopc_6.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(255,255,255));
        lblopc_7.setFont(prinOpc);
        lblopc_7.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(false);
        AccesosRemotos.setVisible(false);
        Muestras.setVisible(true);
        opc5.setFont(opc);
        opc5.setForeground(new Color(0,0,0));
        opc6.setFont(subT);
        opc6.setForeground(new Color(105,99,135));
        opc7.setFont(subT);
        opc7.setForeground(new Color(105,99,135));
        pnlOpc5.setVisible(true);
        pnlOpc6.setVisible(false);
        pnlOpc7.setVisible(false);
        subirDatosM.setVisible(true);
        revisarDatosM.setVisible(false);  
        txtNombreUsu.setFont(subT);
        txtNombreUsu.setForeground(new Color(105,99,135));
        txtNombreUsu.setText(nombreLogin);
        txtBuscar2.setText(" Buscar Usuario");
        Pruebas.setVisible(false);
        Inventario.setVisible(false);
        ProdDis.setVisible(false);
        Auditorias.setVisible(false);
    }//GEN-LAST:event_Opc_3MouseClicked

    private void opc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc5MouseClicked
        opc5.setFont(opc);
        opc5.setForeground(new Color(0,0,0));
        opc6.setFont(subT);
        opc6.setForeground(new Color(105,99,135));
        opc7.setFont(subT);
        opc7.setForeground(new Color(105,99,135));
        pnlOpc5.setVisible(true);
        pnlOpc6.setVisible(false);
        pnlOpc7.setVisible(false);
        subirDatosM.setVisible(true);
        txtNombreUsu.setText(nombreLogin);
        revisarDatosM.setVisible(false);        
    }//GEN-LAST:event_opc5MouseClicked

    private void opc6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc6MouseClicked
        opc5.setFont(subT);
        opc5.setForeground(new Color(105,99,135));
        opc6.setFont(opc);
        opc6.setForeground(new Color(0,0,0));
        opc7.setFont(subT);
        opc7.setForeground(new Color(105,99,135));
        pnlOpc5.setVisible(false);
        pnlOpc6.setVisible(true);
        pnlOpc7.setVisible(false);
        subirDatosM.setVisible(false);
        revisarDatosM.setVisible(true);
        ListarMuestras();
    }//GEN-LAST:event_opc6MouseClicked

    private void lblRegMuestraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegMuestraMouseClicked
    String resp;
                
        if(!txtComponente.getText().isEmpty())
            if(txtComponente.getText().equalsIgnoreCase("SI") || txtComponente.getText().equalsIgnoreCase("NO"))
                if(!txtContaminacion.getText().isEmpty())
                    if(txtContaminacion.getText().equalsIgnoreCase("SI") || txtContaminacion.getText().equalsIgnoreCase("NO"))
                        if(!txtMg.getText().isEmpty())
                            if(txtMg.getText().matches("\\d+(\\.\\d+)?"))
                            {
                                if(lblRegMuestra.getText().equals("INSERTAR MUESTRA"))
                                {
                                    resp = CONTROLMUESTRAS.Insertar(CONTROL.getIDConcat(nombreLogin), fecha, txtComponente.getText().equalsIgnoreCase("Si"), txtContaminacion.getText().equalsIgnoreCase("Si"), Float.parseFloat(txtMg.getText()), txtDatos.getText());
                                    OptionPane.showMessage("Inserción de Muestras", "Muestra insertada exitosamente", "/img/iconos/Info.png");
                                    
                                    txtComponente.setText("SI / NO");
                                    txtContaminacion.setText("SI / NO");
                                    txtMg.setText("");
                                    txtDatos.setText("");
                                    ListarMuestras();
                                }
                                else
                                    if(lblRegMuestra.getText().equals("MODIFICAR"))
                                    {
                                        resp = CONTROLMUESTRAS.Modificar(id, txtComponente.getText().equalsIgnoreCase("Si"), txtContaminacion.getText().equalsIgnoreCase("Si"), Float.parseFloat(txtMg.getText()), txtDatos.getText());
                                        OptionPane.showMessage("Inserción de Muestras", "Muestra modificada exitosamente", "/img/iconos/Info.png");                                       
                                        
                                        txtComponente.setText("SI / NO");
                                        txtContaminacion.setText("SI / NO");
                                        txtMg.setText("");
                                        txtDatos.setText("");
                                        ListarMuestras();
                                        lblRegMuestra.setText("INSERTAR MUESTRA");
                                        subirDatosM.setVisible(false);
                                        revisarDatosM.setVisible(true);
                                        opc6.setFont(opc);
                                        opc6.setForeground(new Color(0,0,0));
                                        opc7.setFont(subT);
                                        opc7.setForeground(new Color(105,99,135));
                                        pnlOpc6.setVisible(true);
                                        pnlOpc7.setVisible(false);

                                    }                                                                
                            }
                            else
                                OptionPane.showMessage("Inserción de Muestras", "La cantidad de miligramos debe ser un número entero", "/img/iconos/Close.png");
                        else
                            OptionPane.showMessage("Inserción de Muestras", "Debe ingresar la cantidad de miligramos", "/img/iconos/Close.png");
                    else
                        OptionPane.showMessage("Inserción de Muestras", "Debe ingresar Si o No en cuanto al nivel de contaminación cruzada", "/img/iconos/Close.png");
                else
                    OptionPane.showMessage("Inserción de Muestras", "Debe ingresar si existió, o no, la presencia de un nivel de contaminación", "/img/iconos/Close.png");
            else
                OptionPane.showMessage("Inserción de Muestras", "Debe ingresar Si o No en cuanto a la presencia de un componente extraño", "/img/iconos/Close.png"); 
        else
            OptionPane.showMessage("Inserción de Muestras", "Debe ingresar si existió, o no, la presencia de un componente extraño", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblRegMuestraMouseClicked

    private void lblEliminar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminar2MouseClicked
        if(tblMuestras.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 0)));
            nombre = String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar la muestra registrada por el usuario " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROLMUESTRAS.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Muestra eliminada", "/img/iconos/Info.png");
                    ListarMuestras();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar la muestra", "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar una muestra de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminar2MouseClicked

    private void lblModificar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificar1MouseClicked
        if(tblMuestras.getSelectedRowCount() == 1)
        {
            opc5.setFont(subT);
            opc5.setForeground(new Color(105, 99, 135));
            opc6.setFont(subT);
            opc6.setForeground(new Color(105,99,135));
            opc7.setFont(opc);
            opc7.setForeground(new Color(0,0,0));
            pnlOpc5.setVisible(false);
            pnlOpc6.setVisible(false);
            pnlOpc7.setVisible(true);
            subirDatosM.setVisible(true);
            revisarDatosM.setVisible(false);
            
            lblRegMuestra.setText("MODIFICAR");
            
            id  = Integer.parseInt(String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 0)));            
            txtNombreUsu.setText(String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 1)));
            compExt = String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 4));
            contCru = String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 5));
            mg = Float.parseFloat(String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 6)));
            datosM = String.valueOf(tblMuestras.getValueAt(tblMuestras.getSelectedRow(), 7));
            txtComponente.setText(compExt);
            txtContaminacion.setText(contCru);
            txtMg.setText(String.valueOf(mg));
            txtDatos.setText(datosM);
        }
        else
            OptionPane.showMessage("Modificar", "Debe seleccionar un usuario de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblModificar1MouseClicked

    private void lblIconAct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconAct2MouseClicked
        ListarMuestras();
    }//GEN-LAST:event_lblIconAct2MouseClicked

    private void txtBuscar2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar2FocusGained
        if(txtBuscar2.getText().equals(" Buscar Usuario"))
            txtBuscar2.setText("");
    }//GEN-LAST:event_txtBuscar2FocusGained

    private void txtBuscar2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar2FocusLost
        if(txtBuscar2.getText().isEmpty())
            txtBuscar2.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscar2FocusLost

    private void lbl_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_6MouseClicked
        if(!txtBuscar2.getText().isEmpty() && !txtBuscar2.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar2.getText()))              
                tblMuestras.setModel(CONTROLMUESTRAS.Buscar(txtBuscar2.getText()));          
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar2.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_6MouseClicked

    private void txtComponenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComponenteFocusGained
        if(txtComponente.getText().equals("SI / NO"))
            txtComponente.setText("");
    }//GEN-LAST:event_txtComponenteFocusGained

    private void txtComponenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComponenteFocusLost
        if(txtComponente.getText().isEmpty())
            txtComponente.setText("SI / NO");
    }//GEN-LAST:event_txtComponenteFocusLost

    private void txtContaminacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContaminacionFocusGained
        if(txtContaminacion.getText().equals("SI / NO"))
            txtContaminacion.setText("");
    }//GEN-LAST:event_txtContaminacionFocusGained

    private void txtContaminacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContaminacionFocusLost
        if(txtContaminacion.getText().isEmpty())
            txtContaminacion.setText("SI / NO");
    }//GEN-LAST:event_txtContaminacionFocusLost

    private void Opc_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_4MouseClicked
        Opc_1.setBackground(new Color(255,255,255));
        lblopc_1.setFont(prinOpc);
        lblopc_1.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User_B.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(255,255,255));
        lblopc_2.setFont(prinOpc);
        lblopc_2.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(255,255,255));
        lblopc_3.setFont(prinOpc);
        lblopc_3.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(161,29,152, 150));
        lblopc_4.setFont(opc);
        lblopc_4.setForeground(new Color(255,255,255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(255,255,255));
        lblopc_5.setFont(prinOpc);
        lblopc_5.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(255,255,255));
        lblopc_6.setFont(prinOpc);
        lblopc_6.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(255,255,255));
        lblopc_7.setFont(prinOpc);
        lblopc_7.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(false);
        AccesosRemotos.setVisible(false);
        Muestras.setVisible(false);
        Pruebas.setVisible(true);
        opc8.setFont(opc);
        opc8.setForeground(new Color(0,0,0));
        opc9.setFont(subT);
        opc9.setForeground(new Color(105,99,135));
        opc10.setFont(subT);
        opc10.setForeground(new Color(105,99,135));
        pnlOpc8.setVisible(true);
        pnlOpc9.setVisible(false);
        pnlOpc10.setVisible(false);
        subirDatosP.setVisible(true);
        revisarDatosP.setVisible(false);
        txtBuscar3.setText(" Buscar Usuario");
        txtNombreUsuP.setFont(subT);
        txtNombreUsuP.setForeground(new Color(105,99,135));
        txtNombreUsuP.setText(nombreLogin);
        txtIDMuestraM.setVisible(false);
        Inventario.setVisible(false);
        ProdDis.setVisible(false);
        Auditorias.setVisible(false);
    }//GEN-LAST:event_Opc_4MouseClicked

    private void opc8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc8MouseClicked
        opc8.setFont(opc);
        opc8.setForeground(new Color(0,0,0));
        opc9.setFont(subT);
        opc9.setForeground(new Color(105,99,135));
        opc10.setFont(subT);
        opc10.setForeground(new Color(105,99,135));
        pnlOpc8.setVisible(true);
        pnlOpc9.setVisible(false);
        pnlOpc10.setVisible(false);
        subirDatosP.setVisible(true);
        txtNombreUsuP.setText(nombreLogin);
        txtIDMuestraM.setVisible(false);
        revisarDatosP.setVisible(false);  
    }//GEN-LAST:event_opc8MouseClicked

    private void opc9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc9MouseClicked
        opc8.setFont(subT);
        opc8.setForeground(new Color(105,99,135));
        opc9.setFont(opc);
        opc9.setForeground(new Color(0,0,0));
        opc10.setFont(subT);
        opc10.setForeground(new Color(105,99,135));
        pnlOpc8.setVisible(false);
        pnlOpc9.setVisible(true);
        pnlOpc10.setVisible(false);
        subirDatosP.setVisible(false);
        revisarDatosP.setVisible(true);
        ListarPruebas();
    }//GEN-LAST:event_opc9MouseClicked

    private void lblRegPruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegPruebaMouseClicked
        if(lblRegPrueba.getText().equals("INSERTAR PRUEBA"))
        {
            if(!txtIDMuestra.getText().isEmpty())
                if(CONTROLMUESTRAS.Existe(Integer.parseInt(txtIDMuestra.getText()), CONTROLMUESTRAS.getFecha(Integer.parseInt(txtIDMuestra.getText()))))
                    if(!txtResultado.getText().isEmpty())
                        if(valResPruebas(txtResultado.getText()))
                        {
                            String resp = CONTROLPRUEBAS.Insertar(CONTROL.getIDConcat(nombreLogin), Integer.parseInt(txtIDMuestra.getText()), txtResultado.getText());
                            OptionPane.showMessage("Inserción de Pruebas", "Prueba de calidad insertada correctamente", "/img/iconos/Info.png");

                            txtIDMuestra.setText("");
                            txtResultado.setText("");
                            ListarPruebas();
                        }
                        else
                            OptionPane.showMessage("Inserción de Pruebas", "Los resultados sólo pueden ser: Aceptada, Rechazada o En proceso", "/img/iconos/Close.png");
                    else
                        OptionPane.showMessage("Inserción de Pruebas", "Debe ingresar el resultado de la prueba de calidad", "/img/iconos/Close.png");
                else
                    OptionPane.showMessage("Inserción de Pruebas", "La muestra con el ID " + txtIDMuestra.getText() + " no existe \n Consulte los registros de muestras", "/img/iconos/Close.png"); 
            else
                OptionPane.showMessage("Inserción de Pruebas", "Debe ingresar un ID de Muestra", "/img/iconos/Close.png");
        }
        else
            if(lblRegPrueba.getText().equals("ACTUALIZAR"))
            {
                if(!txtResultado.getText().isEmpty())
                    if(valResPruebas(txtResultado.getText()))
                    {
                        String resp = CONTROLPRUEBAS.Modificar(txtResultado.getText(), id);
                        OptionPane.showMessage("Modificación de Pruebas", "Resultado de prueba de calidad modificado correctamente", "/img/iconos/Info.png");
                        
                        txtIDMuestraM.setText("");
                        txtIDMuestraM.setVisible(false);
                        txtIDMuestra.setVisible(true);
                        txtResultado.setText("");
                        lblRegPrueba.setText("INSERTAR PRUEBA");
                        subirDatosP.setVisible(false);
                        revisarDatosP.setVisible(true);
                        opc9.setFont(opc);
                        opc9.setForeground(new Color(0,0,0));
                        opc10.setFont(subT);
                        opc10.setForeground(new Color(105,99,135));
                        pnlOpc9.setVisible(true);
                        pnlOpc10.setVisible(false);
                        ListarPruebas();
                    }
                    else
                        OptionPane.showMessage("Modificación de Pruebas", "Los resultados sólo pueden ser: Aceptada, Rechazada o En proceso", "/img/iconos/Close.png");
                else
                    OptionPane.showMessage("Modificación de Pruebas", "Debe ingresar el resultado de la prueba de calidad", "/img/iconos/Close.png");
            }
    }//GEN-LAST:event_lblRegPruebaMouseClicked

    private void lblEliminar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminar3MouseClicked
        if(tblPruebas.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblPruebas.getValueAt(tblPruebas.getSelectedRow(), 0)));
            nombre = String.valueOf(tblPruebas.getValueAt(tblPruebas.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar la prueba registrada por el usuario " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROLPRUEBAS.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Prueba de calidad eliminada", "/img/iconos/Info.png");
                    ListarPruebas();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar la prueba de calidad", "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar una prueba de calidad de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminar3MouseClicked

    private void lblModificar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificar2MouseClicked
        if(tblPruebas.getSelectedRowCount() == 1)
        {
            opc8.setFont(subT);
            opc8.setForeground(new Color(105,99,135));
            opc9.setFont(subT);
            opc9.setForeground(new Color(105,99,135));
            opc10.setFont(opc);
            opc10.setForeground(new Color(0,0,0));
            pnlOpc8.setVisible(false);
            pnlOpc9.setVisible(false);
            pnlOpc10.setVisible(true);
            subirDatosP.setVisible(true);
            txtIDMuestra.setVisible(false);
            txtIDMuestraM.setVisible(true);
            txtIDMuestraM.setFont(subT);
            txtIDMuestraM.setForeground(new Color(105,99,135));
            revisarDatosP.setVisible(false);            
            
            lblRegPrueba.setText("ACTUALIZAR");
            
            id = Integer.parseInt(String.valueOf(tblPruebas.getValueAt(tblPruebas.getSelectedRow(), 0)));            
            txtNombreUsuP.setText(String.valueOf(tblPruebas.getValueAt(tblPruebas.getSelectedRow(), 1)));
            txtIDMuestraM.setText(String.valueOf(tblPruebas.getValueAt(tblPruebas.getSelectedRow(), 2)));
            resPrueba = String.valueOf(tblPruebas.getValueAt(tblPruebas.getSelectedRow(), 3));
            txtResultado.setText(resPrueba);
        }
        else
            OptionPane.showMessage("Modificar", "Debe seleccionar una prueba de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblModificar2MouseClicked

    private void lblIconAct3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconAct3MouseClicked
        ListarPruebas();
    }//GEN-LAST:event_lblIconAct3MouseClicked

    private void txtBuscar3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar3FocusGained
        if(txtBuscar3.getText().equals(" Buscar Usuario"))
            txtBuscar3.setText("");
    }//GEN-LAST:event_txtBuscar3FocusGained

    private void txtBuscar3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar3FocusLost
        if(txtBuscar3.getText().isEmpty())
            txtBuscar3.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscar3FocusLost

    private void lbl_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_8MouseClicked
        if(!txtBuscar3.getText().isEmpty() && !txtBuscar3.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar3.getText()))             
                tblPruebas.setModel(CONTROLPRUEBAS.Buscar(txtBuscar3.getText()));                     
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar3.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_8MouseClicked

    private void Opc_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_5MouseClicked
        Opc_1.setBackground(new Color(255,255,255));
        lblopc_1.setFont(prinOpc);
        lblopc_1.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User_B.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(255,255,255));
        lblopc_2.setFont(prinOpc);
        lblopc_2.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(255,255,255));
        lblopc_3.setFont(prinOpc);
        lblopc_3.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(255,255,255));
        lblopc_4.setFont(prinOpc);
        lblopc_4.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(161,29,152, 150));
        lblopc_5.setFont(opc);
        lblopc_5.setForeground(new Color(255,255,255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(255,255,255));
        lblopc_6.setFont(prinOpc);
        lblopc_6.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(255,255,255));
        lblopc_7.setFont(prinOpc);
        lblopc_7.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(false);
        AccesosRemotos.setVisible(false);
        Muestras.setVisible(false);
        Pruebas.setVisible(false);
        Inventario.setVisible(true);
        opc11.setFont(opc);
        opc11.setForeground(new Color(0,0,0));
        opc12.setFont(subT);
        opc12.setForeground(new Color(105,99,135));
        opc13.setFont(subT);
        opc13.setForeground(new Color(105,99,135));
        pnlOpc11.setVisible(true);
        pnlOpc12.setVisible(false);
        pnlOpc13.setVisible(false);
        subirDatosI.setVisible(true);
        revisarDatosI.setVisible(false);
        txtBuscar4.setText(" Buscar Usuario");
        txtNombreUsuI.setFont(subT);
        txtNombreUsuI.setForeground(new Color(105,99,135));
        txtNombreUsuI.setText(nombreLogin);    
        ProdDis.setVisible(false);
        Auditorias.setVisible(false);
    }//GEN-LAST:event_Opc_5MouseClicked

    private void opc11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc11MouseClicked
        opc11.setFont(opc);
        opc11.setForeground(new Color(0,0,0));
        opc12.setFont(subT);
        opc12.setForeground(new Color(105,99,135));
        opc13.setFont(subT);
        opc13.setForeground(new Color(105,99,135));
        pnlOpc11.setVisible(true);
        pnlOpc12.setVisible(false);
        pnlOpc13.setVisible(false);
        subirDatosI.setVisible(true);
        revisarDatosI.setVisible(false);
        txtNombreUsuI.setText(nombreLogin);
    }//GEN-LAST:event_opc11MouseClicked

    private void opc12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc12MouseClicked
        opc11.setFont(subT);
        opc11.setForeground(new Color(105,99,135));
        opc12.setFont(opc);
        opc12.setForeground(new Color(0,0,0));
        opc13.setFont(subT);
        opc13.setForeground(new Color(105,99,135));
        pnlOpc11.setVisible(false);
        pnlOpc12.setVisible(true);
        pnlOpc13.setVisible(false);
        subirDatosI.setVisible(false);
        revisarDatosI.setVisible(true);
        ListarInv();
    }//GEN-LAST:event_opc12MouseClicked

    private void lblRegInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegInvMouseClicked
        if(!txtNomInventario.getText().isEmpty())
            if(!txtCantidad.getText().isEmpty())
                if(txtCantidad.getText().matches("[0-9]+"))
                {
                    if(lblRegInv.getText().equals("REGISTRAR INVENTARIO"))
                    {
                        String resp = CONTROLINV.Insertar(CONTROL.getIDConcat(nombreLogin), fecha, txtNomInventario.getText(), Integer.parseInt(txtCantidad.getText()), txtDatosI.getText());
                        OptionPane.showMessage("Registro de Inventario", "Nuevo inventario registrado", "/img/iconos/Info.png");
                        
                        txtNomInventario.setText("");
                        txtCantidad.setText("");
                        txtDatosI.setText("");
                        ListarInv();
                    }
                    else
                        if(lblRegInv.getText().equals("MODIFICAR"))
                        {
                            String resp = CONTROLINV.Modificar(txtNomInventario.getText(), Integer.parseInt(txtCantidad.getText()), txtDatosI.getText(), id);
                            OptionPane.showMessage("Registro de Inventario", "Inventario modificado correctamente", "/img/iconos/Info.png");
                            
                            txtNomInventario.setText("");
                            txtCantidad.setText("");
                            txtDatosI.setText("");
                            lblRegInv.setText("REGISTRAR INVENTARIO");
                            ListarInv();
                            
                            opc12.setFont(opc);
                            opc12.setForeground(new Color(0,0,0));
                            opc13.setFont(subT);
                            opc13.setForeground(new Color(105,99,135));
                            pnlOpc12.setVisible(true);
                            pnlOpc12.setVisible(false);
                            subirDatosI.setVisible(false);
                            revisarDatosI.setVisible(true);
                        }
                }
                else
                    OptionPane.showMessage("Registro de Inventario", "Debe ingresar una cantidad válida de unidades", "/img/iconos/Close.png");
            else
                OptionPane.showMessage("Registro de Inventario", "Debe ingresar la cantidad de stock", "/img/iconos/Close.png"); 
        else
            OptionPane.showMessage("Registro de Inventario", "Debe ingresar un título para el nuevo inventario", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblRegInvMouseClicked

    private void lblEliminar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminar4MouseClicked
        if(tblInventario.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 0)));
            nombre = String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar el inventario registrado por el usuario " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROLINV.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Registro de inventario eliminado con éxito", "/img/iconos/Info.png");
                    ListarInv();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar el registro de inventario", "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar un registro de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminar4MouseClicked

    private void lblModificar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificar3MouseClicked
        if(tblInventario.getSelectedRowCount() == 1)
        {
            opc11.setFont(subT);
            opc11.setForeground(new Color(105,99,135));
            opc12.setFont(subT);
            opc12.setForeground(new Color(105,99,135));
            opc13.setFont(opc);
            opc13.setForeground(new Color(0,0,0));
            pnlOpc11.setVisible(false);
            pnlOpc12.setVisible(false);
            pnlOpc13.setVisible(true);
            subirDatosI.setVisible(true);
            revisarDatosI.setVisible(false);            
            
            lblRegInv.setText("MODIFICAR");
            
            id = Integer.parseInt(String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 0)));            
            txtNombreUsuI.setText(String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 1)));
            nombre = String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 4));
            cantidad = Integer.parseInt(String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 5)));
            datosM = String.valueOf(tblInventario.getValueAt(tblInventario.getSelectedRow(), 6)); 
            txtNomInventario.setText(nombre);
            txtCantidad.setText(String.valueOf(cantidad));
            txtDatosI.setText(datosM);
        }
        else
            OptionPane.showMessage("Modificar", "Debe seleccionar un registro de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblModificar3MouseClicked

    private void lblIconAct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconAct4MouseClicked
        ListarInv();
    }//GEN-LAST:event_lblIconAct4MouseClicked

    private void txtBuscar4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar4FocusGained
        if(txtBuscar4.getText().equals(" Buscar Usuario"))
            txtBuscar4.setText("");
    }//GEN-LAST:event_txtBuscar4FocusGained

    private void txtBuscar4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar4FocusLost
        if(txtBuscar4.getText().isEmpty())
            txtBuscar4.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscar4FocusLost

    private void lbl_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_10MouseClicked
        if(!txtBuscar4.getText().isEmpty() && !txtBuscar4.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar4.getText()))             
                tblInventario.setModel(CONTROLINV.Buscar(txtBuscar4.getText()));                     
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar4.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_10MouseClicked

    private void Opc_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_6MouseClicked
        Opc_1.setBackground(new Color(255,255,255));
        lblopc_1.setFont(prinOpc);
        lblopc_1.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User_B.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(255,255,255));
        lblopc_2.setFont(prinOpc);
        lblopc_2.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(255,255,255));
        lblopc_3.setFont(prinOpc);
        lblopc_3.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(255,255,255));
        lblopc_4.setFont(prinOpc);
        lblopc_4.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(255,255,255));
        lblopc_5.setFont(prinOpc);
        lblopc_5.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(161,29,152, 150));
        lblopc_6.setFont(opc);
        lblopc_6.setForeground(new Color(255,255,255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(255,255,255));
        lblopc_7.setFont(prinOpc);
        lblopc_7.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor_B.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(false);
        AccesosRemotos.setVisible(false);
        Muestras.setVisible(false);
        Pruebas.setVisible(false);
        Inventario.setVisible(false);
        ProdDis.setVisible(true);
        txtBuscar5.setText(" Buscar Usuario");
        opc14.setFont(opc);
        opc14.setForeground(new Color(0,0,0));
        opc15.setFont(subT);
        opc15.setForeground(new Color(105,99,135));
        opc16.setFont(subT);
        opc16.setForeground(new Color(105,99,135));
        pnlOpc14.setVisible(true);
        pnlOpc15.setVisible(false);
        pnlOpc16.setVisible(false);
        subirDatosPD.setVisible(true);
        revisarDatosPD.setVisible(false);
        txtNombreUsuPD.setFont(subT);
        txtNombreUsuPD.setForeground(new Color(105,99,135));
        txtNombreUsuPD.setText(nombreLogin);
        Auditorias.setVisible(false);
    }//GEN-LAST:event_Opc_6MouseClicked

    private void opc14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc14MouseClicked
        opc14.setFont(opc);
        opc14.setForeground(new Color(0,0,0));
        opc15.setFont(subT);
        opc15.setForeground(new Color(105,99,135));
        opc16.setFont(subT);
        opc16.setForeground(new Color(105,99,135));
        pnlOpc14.setVisible(true);
        pnlOpc15.setVisible(false);
        pnlOpc16.setVisible(false);
        subirDatosPD.setVisible(true);
        revisarDatosPD.setVisible(false);
        txtNombreUsuPD.setText(nombreLogin);
    }//GEN-LAST:event_opc14MouseClicked

    private void opc15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc15MouseClicked
        opc14.setFont(subT);
        opc14.setForeground(new Color(105,99,135));
        opc15.setFont(opc);
        opc15.setForeground(new Color(0,0,0));
        opc16.setFont(subT);
        opc16.setForeground(new Color(105,99,135));
        pnlOpc14.setVisible(false);
        pnlOpc15.setVisible(true);
        pnlOpc16.setVisible(false);
        subirDatosPD.setVisible(false);
        revisarDatosPD.setVisible(true);
        ListarMonitoreo();
    }//GEN-LAST:event_opc15MouseClicked

    private void lblGuardarInfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarInfMouseClicked
        if(!txtDatosPD.getText().isEmpty())
        {
            if(lblGuardarInf.getText().equals("GUARDAR INFORME"))
            {
                String resp = CONTROLMONI.Insertar(CONTROL.getIDConcat(nombreLogin), fecha, txtDatosPD.getText());
                OptionPane.showMessage("Guardar Informe", "Nuevo reporte de monitoreo de producción y distribución guardado con éxito en el registro", "/img/iconos/Info.png");

                txtDatosPD.setText("");
                ListarMonitoreo();
            }
            else
                if(lblGuardarInf.getText().equals("MODIFICAR"))
                {
                    String resp = CONTROLMONI.Modificar(txtDatosPD.getText(), id);
                    OptionPane.showMessage("Guardar Informe", "Reporte de monitoreo de producción y distribución modificado exitosamente", "/img/iconos/Info.png");                    
                    
                    txtDatosPD.setText("");
                    lblGuardarInf.setText("GUARDAR INFORME");
                    ListarMonitoreo();
                    
                    opc15.setFont(opc);
                    opc15.setForeground(new Color(0,0,0));
                    opc16.setFont(subT);
                    opc16.setForeground(new Color(105,99,135));
                    pnlOpc15.setVisible(true);
                    pnlOpc16.setVisible(false);
                    subirDatosPD.setVisible(false);
                    revisarDatosPD.setVisible(true);
                }
        } 
        else
            OptionPane.showMessage("Guardar Informe", "Debe ingresar un reporte", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblGuardarInfMouseClicked

    private void lblEliminar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminar5MouseClicked
        if(tblMonitoreo.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblMonitoreo.getValueAt(tblMonitoreo.getSelectedRow(), 0)));
            nombre = String.valueOf(tblMonitoreo.getValueAt(tblMonitoreo.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar el reporte guardado por el usuario " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROLMONI.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Reporte de monitoreo eliminado con éxito", "/img/iconos/Info.png");
                    ListarMonitoreo();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar el reporte", "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar un registro de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminar5MouseClicked

    private void lblModificar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificar4MouseClicked
        if(tblMonitoreo.getSelectedRowCount() == 1)
        {
            opc14.setFont(subT);
            opc14.setForeground(new Color(105,99,135));
            opc15.setFont(subT);
            opc15.setForeground(new Color(105,99,135));
            opc16.setFont(opc);
            opc16.setForeground(new Color(0,0,0));
            pnlOpc14.setVisible(false);
            pnlOpc15.setVisible(false);
            pnlOpc16.setVisible(true);
            subirDatosPD.setVisible(true);
            revisarDatosPD.setVisible(false);            
            
            lblGuardarInf.setText("MODIFICAR");
            
            id = Integer.parseInt(String.valueOf(tblMonitoreo.getValueAt(tblMonitoreo.getSelectedRow(), 0)));            
            txtNombreUsuPD.setText(String.valueOf(tblMonitoreo.getValueAt(tblMonitoreo.getSelectedRow(), 1)));
            datosM = String.valueOf(tblMonitoreo.getValueAt(tblMonitoreo.getSelectedRow(), 4));
            txtDatosPD.setText(datosM);
        }
        else
            OptionPane.showMessage("Modificar", "Debe seleccionar un registro de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblModificar4MouseClicked

    private void lblIconAct5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconAct5MouseClicked
        ListarMonitoreo();
    }//GEN-LAST:event_lblIconAct5MouseClicked

    private void txtBuscar5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar5FocusGained
        if(txtBuscar5.getText().equals(" Buscar Usuario"))
            txtBuscar5.setText("");
    }//GEN-LAST:event_txtBuscar5FocusGained

    private void txtBuscar5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar5FocusLost
        if(txtBuscar5.getText().isEmpty())
            txtBuscar5.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscar5FocusLost

    private void lbl_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_12MouseClicked
        if(!txtBuscar5.getText().isEmpty() && !txtBuscar5.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar5.getText()))             
                tblMonitoreo.setModel(CONTROLMONI.Buscar(txtBuscar5.getText()));                     
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar5.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_12MouseClicked

    private void Opc_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Opc_7MouseClicked
        Opc_1.setBackground(new Color(255,255,255));
        lblopc_1.setFont(prinOpc);
        lblopc_1.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/User_B.png")), lbl_1, 0);
        Opc_2.setBackground(new Color(255,255,255));
        lblopc_2.setFont(prinOpc);
        lblopc_2.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Remote_B.png")), lbl_2, 0);
        Opc_3.setBackground(new Color(255,255,255));
        lblopc_3.setFont(prinOpc);
        lblopc_3.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Muestras_B.png")), lbl_3, 0);
        Opc_4.setBackground(new Color(255,255,255));
        lblopc_4.setFont(prinOpc);
        lblopc_4.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Calidad_B.png")), lbl_7, 0);
        Opc_5.setBackground(new Color(255,255,255));
        lblopc_5.setFont(prinOpc);
        lblopc_5.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Inventory_B.png")), lbl_9, 0);
        Opc_6.setBackground(new Color(255,255,255));
        lblopc_6.setFont(prinOpc);
        lblopc_6.setForeground(new Color(0,0,0));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Produccion_B.png")), lbl_11, 0);
        Opc_7.setBackground(new Color(161,29,152, 150));
        lblopc_7.setFont(opc);
        lblopc_7.setForeground(new Color(255,255,255));
        Icono(new ImageIcon(getClass().getResource("/img/iconos/Auditor.png")), lbl_13, 0);
        
        GestionUsuarios.setVisible(false);
        AccesosRemotos.setVisible(false);        
        Muestras.setVisible(false);
        Pruebas.setVisible(false);
        Inventario.setVisible(false);
        ProdDis.setVisible(false);
        Auditorias.setVisible(true);
        ListarAuditorias();
        txtBuscar6.setText(" Buscar Usuario");
    }//GEN-LAST:event_Opc_7MouseClicked

    private void lblEliminar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminar6MouseClicked
        if(tblAccesos1.getSelectedRowCount() == 1)
        {
            id  = Integer.parseInt(String.valueOf(tblAccesos1.getValueAt(tblAccesos1.getSelectedRow(), 0)));
            nombre = String.valueOf(tblAccesos1.getValueAt(tblAccesos1.getSelectedRow(), 1));
            if(JOptionPane.showConfirmDialog(this, "¿Desea eliminar la auditoría realizada por el usuario " + nombre + "?", "Eliminar",JOptionPane.YES_NO_OPTION) == 0)
            {
                String resp = CONTROLAUDI.Eliminar(id);
                if(resp.equals("OK"))
                {
                    OptionPane.showMessage("Eliminar", "Auditoría eliminada con éxito", "/img/iconos/Info.png");
                    ListarAuditorias();
                }
                else
                    OptionPane.showMessage("Eliminar", "Hubo un error al eliminar la auditoría", "/img/iconos/Close.png");
            }
        }
        else
            OptionPane.showMessage("Eliminar", "Debe seleccionar una auditoría de la tabla", "/img/iconos/Close.png");
    }//GEN-LAST:event_lblEliminar6MouseClicked

    private void lblIconAct6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconAct6MouseClicked
        ListarAuditorias();
    }//GEN-LAST:event_lblIconAct6MouseClicked

    private void txtBuscar6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar6FocusGained
        if(txtBuscar6.getText().equals(" Buscar Usuario"))
            txtBuscar6.setText("");
    }//GEN-LAST:event_txtBuscar6FocusGained

    private void txtBuscar6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscar6FocusLost
        if(txtBuscar6.getText().isEmpty())
            txtBuscar6.setText(" Buscar Usuario");
    }//GEN-LAST:event_txtBuscar6FocusLost

    private void lbl_14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_14MouseClicked
        if(!txtBuscar6.getText().isEmpty() && !txtBuscar6.getText().equals(" Buscar Usuario"))
            if(CONTROL.existeConcat(txtBuscar6.getText()))             
                tblAccesos1.setModel(CONTROLAUDI.Buscar(txtBuscar6.getText()));                     
            else
                OptionPane.showMessage("Buscar", "El usuario " + txtBuscar6.getText() + " no existe en el sistema", "/img/iconos/Close.png");                           
        else
            OptionPane.showMessage("Buscar", "Debe ingresar un nombre de usuario a buscar", "/img/iconos/Close.png");
    }//GEN-LAST:event_lbl_14MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuarios_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios_A.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios_A().setVisible(true);
            }
        });
    }
    
    public void Icono(ImageIcon icono, JLabel label, int val)
    {
        Image image = icono.getImage();
        if(val != 0)
            image = image.getScaledInstance(label.getWidth() - val, label.getHeight() - val, Image.SCALE_SMOOTH);
        else
            image = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);            
        icono = new ImageIcon(image);
        label.setIcon(icono);
    }
    
    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
 
        public RoundedPanel(int radius) 
        {
            super();
            cornerRadius = radius;   
        }
         
        @Override
        protected void paintComponent(Graphics g) 
        {
            Color color = Color.WHITE;
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setColor(color);  // 'color' es el color que deseas utilizar
            graphics.fillRect(0, 0, getWidth(), getHeight());
            if (backgroundColor != null) 
                graphics.setColor(backgroundColor);
            else
                graphics.setColor(getBackground());
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
        }    
    }
    
    public class Contrasena 
    {
        private String password;
        private String error;

        public Contrasena(String password) 
        {
            this.password = password;
        }

        public boolean ValidarContrasena()
        {
            //Verificar la longitud del password
            if(password.length() >= 8)
                //Verificar que tenga al menos 1 letra mayúscula
                if(tieneLetraMayuscula())
                    //Verificar que tenga letras minúsculas
                    if(tieneLetraMinuscula())
                        //Verificar que tenga numeros
                        if(tieneNumeros())
                          //Verificar caracteres especiales
                            if(tieneCaracteresEspeciales())
                                return true;
                            else
                               return false;
                        else
                            return false;
                    else
                        return false;
                else
                    return false;
            else
            {
                error = "Contraseña menor a 8 caracteres";
                return false;
            }
        }

        private boolean tieneLetraMayuscula()
        {
            for(int i = 0; i < password.length(); i++)
                if(Character.isUpperCase(password.charAt(i)))
                    return true;
            error = "La contraseña debe tener, como mínimo, una mayúscula.";
            return false;
        }

        private boolean tieneLetraMinuscula()
        {
            for(int i = 0; i < password.length(); i++)
                if(Character.isLowerCase(password.charAt(i)))
                    return true;
            error = "La contraseña debe contener letras minúsculas.";
            return false;
        }

        private boolean tieneNumeros()
        {
            int con = 0;
            for(int i = 0; i < password.length(); i++)
            {
                if(Character.isDigit(password.charAt(i)))
                    con++;
            } 
            if(con >= 1)
                return true;
            else
            {
                error = "La contraseña debe tener, como mínimo, un número.";
                return false;
            }
        }

        private boolean tieneCaracteresEspeciales()
        {
            int con = 0;
            for(int i = 0; i < password.length(); i++)
            {
                if(tieneCaracter(password.charAt(i)))
                    con++;
            } 
            if(con >= 1)
                return true;
            else
            {
                error = "La contraseña debe tener, como mínimo, un caracter especial";
                return false;
            }
        }

        //Función que regresa verdadero si tiene un caracter especial
        private boolean tieneCaracter(char car)
        {
            char arrCaracteres[] = {'@','$','&','#','!','*','+','/','%',':'};   
            for(int j = 0; j < arrCaracteres.length; j++)
                if(car == arrCaracteres[j])
                    return true;
            return false;
        }

        public String Error()
        {
            return error;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccesosRemotos;
    private javax.swing.JPanel Auditorias;
    private javax.swing.JPanel GestionUsuarios;
    private javax.swing.JPanel Inventario;
    private javax.swing.JPanel Muestras;
    private javax.swing.JPanel Opc_1;
    private javax.swing.JPanel Opc_2;
    private javax.swing.JPanel Opc_3;
    private javax.swing.JPanel Opc_4;
    private javax.swing.JPanel Opc_5;
    private javax.swing.JPanel Opc_6;
    private javax.swing.JPanel Opc_7;
    private javax.swing.JPanel ProdDis;
    private javax.swing.JPanel Pruebas;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl18;
    private javax.swing.JLabel lbl19;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl20;
    private javax.swing.JLabel lbl21;
    private javax.swing.JLabel lbl22;
    private javax.swing.JLabel lbl23;
    private javax.swing.JLabel lbl24;
    private javax.swing.JLabel lbl25;
    private javax.swing.JLabel lbl26;
    private javax.swing.JLabel lbl27;
    private javax.swing.JLabel lbl28;
    private javax.swing.JLabel lbl29;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl30;
    private javax.swing.JLabel lbl31;
    private javax.swing.JLabel lbl32;
    private javax.swing.JLabel lbl33;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblBlind;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblEliminar1;
    private javax.swing.JLabel lblEliminar2;
    private javax.swing.JLabel lblEliminar3;
    private javax.swing.JLabel lblEliminar4;
    private javax.swing.JLabel lblEliminar5;
    private javax.swing.JLabel lblEliminar6;
    private javax.swing.JLabel lblGuardarInf;
    private javax.swing.JLabel lblIconAct;
    private javax.swing.JLabel lblIconAct1;
    private javax.swing.JLabel lblIconAct2;
    private javax.swing.JLabel lblIconAct3;
    private javax.swing.JLabel lblIconAct4;
    private javax.swing.JLabel lblIconAct5;
    private javax.swing.JLabel lblIconAct6;
    private javax.swing.JLabel lblIniSes;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblModificar1;
    private javax.swing.JLabel lblModificar2;
    private javax.swing.JLabel lblModificar3;
    private javax.swing.JLabel lblModificar4;
    private javax.swing.JLabel lblRegInv;
    private javax.swing.JLabel lblRegMuestra;
    private javax.swing.JLabel lblRegPrueba;
    private javax.swing.JLabel lblSee;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_10;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JLabel lbl_9;
    private javax.swing.JLabel lblopc_1;
    private javax.swing.JLabel lblopc_2;
    private javax.swing.JLabel lblopc_3;
    private javax.swing.JLabel lblopc_4;
    private javax.swing.JLabel lblopc_5;
    private javax.swing.JLabel lblopc_6;
    private javax.swing.JLabel lblopc_7;
    private javax.swing.JLabel opc1;
    private javax.swing.JLabel opc10;
    private javax.swing.JLabel opc11;
    private javax.swing.JLabel opc12;
    private javax.swing.JLabel opc13;
    private javax.swing.JLabel opc14;
    private javax.swing.JLabel opc15;
    private javax.swing.JLabel opc16;
    private javax.swing.JLabel opc17;
    private javax.swing.JLabel opc2;
    private javax.swing.JLabel opc3;
    private javax.swing.JLabel opc4;
    private javax.swing.JLabel opc5;
    private javax.swing.JLabel opc6;
    private javax.swing.JLabel opc7;
    private javax.swing.JLabel opc8;
    private javax.swing.JLabel opc9;
    private javax.swing.JPanel pnlOpc1;
    private javax.swing.JPanel pnlOpc10;
    private javax.swing.JPanel pnlOpc11;
    private javax.swing.JPanel pnlOpc12;
    private javax.swing.JPanel pnlOpc13;
    private javax.swing.JPanel pnlOpc14;
    private javax.swing.JPanel pnlOpc15;
    private javax.swing.JPanel pnlOpc16;
    private javax.swing.JPanel pnlOpc17;
    private javax.swing.JPanel pnlOpc2;
    private javax.swing.JPanel pnlOpc3;
    private javax.swing.JPanel pnlOpc4;
    private javax.swing.JPanel pnlOpc5;
    private javax.swing.JPanel pnlOpc6;
    private javax.swing.JPanel pnlOpc7;
    private javax.swing.JPanel pnlOpc8;
    private javax.swing.JPanel pnlOpc9;
    private javax.swing.JPanel revisarDatos;
    private javax.swing.JPanel revisarDatos1;
    private javax.swing.JPanel revisarDatos2;
    private javax.swing.JPanel revisarDatosI;
    private javax.swing.JPanel revisarDatosM;
    private javax.swing.JPanel revisarDatosP;
    private javax.swing.JPanel revisarDatosPD;
    private javax.swing.JPanel subirDatos;
    private javax.swing.JPanel subirDatosI;
    private javax.swing.JPanel subirDatosM;
    private javax.swing.JPanel subirDatosP;
    private javax.swing.JPanel subirDatosPD;
    private rojeru_san.complementos.RSTableMetro tblAccesos;
    private rojeru_san.complementos.RSTableMetro tblAccesos1;
    private rojeru_san.complementos.RSTableMetro tblInventario;
    private rojeru_san.complementos.RSTableMetro tblMonitoreo;
    private rojeru_san.complementos.RSTableMetro tblMuestras;
    private rojeru_san.complementos.RSTableMetro tblPruebas;
    private rojeru_san.complementos.RSTableMetro tblUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtBuscar3;
    private javax.swing.JTextField txtBuscar4;
    private javax.swing.JTextField txtBuscar5;
    private javax.swing.JTextField txtBuscar6;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtComponente;
    private javax.swing.JTextField txtContaminacion;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDatos;
    private javax.swing.JTextArea txtDatosI;
    private javax.swing.JTextArea txtDatosPD;
    private javax.swing.JTextField txtIDMuestra;
    private javax.swing.JLabel txtIDMuestraM;
    private javax.swing.JTextField txtMg;
    private javax.swing.JTextField txtNomInventario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtNombreUsu;
    private javax.swing.JLabel txtNombreUsuI;
    private javax.swing.JLabel txtNombreUsuP;
    private javax.swing.JLabel txtNombreUsuPD;
    private javax.swing.JTextField txtResultado;
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
}
