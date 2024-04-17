package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.message.MessageDialog;
import javax.swing.JPanel;
import negocio.usuariosControl;
import vista.Usuarios_A.Contrasena;

public class Usuarios_A extends javax.swing.JFrame 
{
    MessageDialog OptionPane = new MessageDialog(this);
    private final usuariosControl CONTROL;

    public Usuarios_A() 
    {
        getContentPane().setBackground(Color.white);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);   
        
        Tipografia();
        pnlOpc2.setVisible(false);
        lblSee.setVisible(false);
        
        CONTROL = new usuariosControl();
    }
    
    public void Tipografia() 
    {
        Font subT = new Font("Roboto", Font.PLAIN, 20);
        lbl1.setFont(subT);
        opc2.setFont(subT);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        pnlIniSes = new RoundedPanel(50);
        jPanel3 = new javax.swing.JPanel();
        pnlOpc2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        opc1 = new javax.swing.JLabel();
        opc2 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl1.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl1.setForeground(new java.awt.Color(105, 99, 135));
        lbl1.setText("Creación, modificación y eliminación de cuentas, así como la asignación de roles y permisos.");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 100, 1080, -1));

        lbl2.setFont(new java.awt.Font("Roboto Black", 1, 42)); // NOI18N
        lbl2.setForeground(new java.awt.Color(161, 29, 152));
        lbl2.setText("Gestión de Usuarios");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        pnlIniSes.setBackground(new java.awt.Color(181, 23, 158, 130));
        pnlIniSes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnlIniSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 210, 130));

        jPanel3.setBackground(new java.awt.Color(72, 149, 239));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 900, 2));

        pnlOpc2.setBackground(new java.awt.Color(72, 149, 239));
        getContentPane().add(pnlOpc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 185, 190, 7));

        jPanel1.setBackground(new java.awt.Color(72, 149, 239));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 185, 130, 7));

        opc1.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc1.setText("Subir datos");
        opc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opc1MouseClicked(evt);
            }
        });
        getContentPane().add(opc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 156, 130, -1));

        opc2.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        opc2.setForeground(new java.awt.Color(105, 99, 135));
        opc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opc2.setText("Revisar registros");
        opc2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(opc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 156, 190, -1));

        subirDatos.setBackground(new java.awt.Color(255, 255, 255));
        subirDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl3.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl3.setForeground(new java.awt.Color(105, 99, 135));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl3.setText("Nombre de Usuario");
        subirDatos.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        txtNombre.setBackground(new java.awt.Color(20, 89, 169, 80));
        txtNombre.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 45));

        lbl4.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl4.setForeground(new java.awt.Color(105, 99, 135));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl4.setText("Apellido Paterno");
        subirDatos.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 170, -1));

        txtApellido.setBackground(new java.awt.Color(20, 89, 169, 80));
        txtApellido.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 45));

        lbl5.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl5.setForeground(new java.awt.Color(105, 99, 135));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl5.setText("Correo Electrónico");
        subirDatos.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, -1));

        txtCorreo.setBackground(new java.awt.Color(20, 89, 169, 80));
        txtCorreo.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 660, 45));

        lbl6.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl6.setForeground(new java.awt.Color(105, 99, 135));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl6.setText("Rol de Usuario");
        subirDatos.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 190, -1));

        txtRol.setBackground(new java.awt.Color(20, 89, 169, 80));
        txtRol.setFont(new java.awt.Font("Roboto Black", 1, 19)); // NOI18N
        txtRol.setForeground(new java.awt.Color(255, 255, 255));
        txtRol.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        subirDatos.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 660, 45));

        lbl7.setFont(new java.awt.Font("Roboto Black", 1, 20)); // NOI18N
        lbl7.setForeground(new java.awt.Color(105, 99, 135));
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

        txtContrasena.setBackground(new java.awt.Color(20, 89, 169, 80));
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

        getContentPane().add(subirDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 830, 640));

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
    }//GEN-LAST:event_lblIniSesMouseClicked

    private void opc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opc1MouseClicked
        subirDatos.setVisible(true);
    }//GEN-LAST:event_opc1MouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lblBlind;
    private javax.swing.JLabel lblIniSes;
    private javax.swing.JLabel lblSee;
    private javax.swing.JLabel opc1;
    private javax.swing.JLabel opc2;
    private javax.swing.JPanel pnlIniSes;
    private javax.swing.JPanel pnlOpc2;
    private javax.swing.JPanel subirDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
}
