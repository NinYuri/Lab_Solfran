package vista;

import negocio.usuariosControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswingdev.message.MessageDialog;
import javax.swing.JPanel;
import vista.Login.Contrasena;

public class Login extends javax.swing.JFrame 
{
    MessageDialog OptionPane = new MessageDialog(this);
    private final usuariosControl CONTROL;

    public Login() 
    {
        getContentPane().setBackground(Color.white);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        
        CONTROL = new usuariosControl();
        lblSee.setVisible(false);
    }
    
    private String Generar()
    {
        String VALIDO = "@$&#!*+/%:abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
        
        LinkedList<Character> cont = new LinkedList<>();
        String may = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String min = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String car = "@$&#!*+/%:";
        
        Random obr = new Random();
        cont.add(nums.charAt(obr.nextInt(nums.length())));
        cont.add(nums.charAt(obr.nextInt(nums.length())));
        cont.add(may.charAt(obr.nextInt(may.length())));
        cont.add(min.charAt(obr.nextInt(min.length())));
        cont.add(car.charAt(obr.nextInt(car.length())));
        cont.add(car.charAt(obr.nextInt(car.length())));
        
        for(int con = cont.size(); con <= 7; con++)
            cont.add(VALIDO.charAt(obr.nextInt(VALIDO.length())));
        
        //Mezcla los caracteres de la lista y los convierte en una cadena
        Collections.shuffle(cont, obr);
        StringBuilder sb = new StringBuilder();
        for(Character c : cont)
            sb.append(c);
        return sb.toString();
    }
    
    private boolean valTexto(String texto)
    {
        String patron = "^[a-zA-Z]+$";
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

        pnlRegistro = new RoundedPanel(50);
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSee = new javax.swing.JLabel();
        lblBlind = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        lblCrearC = new javax.swing.JLabel();
        lblGenerar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRegistro.setBackground(new java.awt.Color(72, 149, 239, 40));
        pnlRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Usuario.png"))); // NOI18N
        pnlRegistro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 142, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Usuario.png"))); // NOI18N
        pnlRegistro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 72, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/mail.png"))); // NOI18N
        pnlRegistro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 208, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/Rol.png"))); // NOI18N
        pnlRegistro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 279, -1, -1));

        lblSee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/blind.png"))); // NOI18N
        lblSee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSeeMouseClicked(evt);
            }
        });
        pnlRegistro.add(lblSee, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 352, -1, -1));

        lblBlind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/see.png"))); // NOI18N
        lblBlind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBlind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBlindMouseClicked(evt);
            }
        });
        pnlRegistro.add(lblBlind, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 352, -1, -1));

        txtNombre.setBackground(new java.awt.Color(20, 89, 169, 130));
        txtNombre.setFont(new java.awt.Font("Consolas", 1, 19)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setText("Nombre de usuario");
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        pnlRegistro.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 540, 45));

        txtApellido.setBackground(new java.awt.Color(20, 89, 169, 130));
        txtApellido.setFont(new java.awt.Font("Consolas", 1, 19)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setText("Apellido paterno");
        txtApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        pnlRegistro.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 540, 45));

        txtCorreo.setBackground(new java.awt.Color(20, 89, 169, 130));
        txtCorreo.setFont(new java.awt.Font("Consolas", 1, 19)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setText("Correo electrónico");
        txtCorreo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        pnlRegistro.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 540, 45));

        txtRol.setBackground(new java.awt.Color(20, 89, 169, 130));
        txtRol.setFont(new java.awt.Font("Consolas", 1, 19)); // NOI18N
        txtRol.setForeground(new java.awt.Color(255, 255, 255));
        txtRol.setText("Rol de usuario");
        txtRol.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtRol.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRolFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRolFocusLost(evt);
            }
        });
        pnlRegistro.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 540, 45));

        txtContrasena.setBackground(new java.awt.Color(20, 89, 169, 130));
        txtContrasena.setFont(new java.awt.Font("Consolas", 1, 19)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(255, 255, 255));
        txtContrasena.setText("Contraseña");
        txtContrasena.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusLost(evt);
            }
        });
        pnlRegistro.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 540, 45));

        lblCrearC.setBackground(new java.awt.Color(20, 89, 169));
        lblCrearC.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lblCrearC.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCrearC.setText("Crear Cuenta");
        lblCrearC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblCrearC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrearC.setOpaque(true);
        lblCrearC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCrearCMouseClicked(evt);
            }
        });
        pnlRegistro.add(lblCrearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 430, 55));

        lblGenerar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblGenerar.setText("Generar contraseña segura");
        lblGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenerarMouseClicked(evt);
            }
        });
        pnlRegistro.add(lblGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 395, -1, 30));

        getContentPane().add(pnlRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 255, 580, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCrearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearCMouseClicked
    String resp;    
        
        if(!txtNombre.getText().isEmpty() && !txtNombre.getText().equals("Nombre de usuario"))
            if(!valTexto(txtNombre.getText()))
                OptionPane.showMessage("Registro en el Sistema", "El nombre de usuario no puede contener números", "/img/iconos/Close.png");
            else
                if(!txtApellido.getText().isEmpty() && !txtApellido.getText().equals("Apellido paterno"))
                    if(!valTexto(txtApellido.getText()))
                        OptionPane.showMessage("Registro en el Sistema", "El apellido del usuario no puede contener números", "/img/iconos/Close.png");
                    else
                        if(CONTROL.Existe(txtNombre.getText(), txtApellido.getText()))
                            OptionPane.showMessage("Registro en el Sistema", "El usuario " + txtNombre.getText() + " " + txtApellido.getText() + " ya se encuentra registrado", "/img/iconos/Close.png");
                        else
                            if(!txtCorreo.getText().isEmpty() && !txtCorreo.getText().equals("Correo electrónico"))
                                if(valCorreo(txtCorreo.getText()) != null)
                                    OptionPane.showMessage("Registro en el Sistema", valCorreo(txtCorreo.getText()), "/img/iconos/Close.png");
                                else
                                    if(!txtRol.getText().isEmpty() && !txtRol.getText().equals("Rol de usuario"))
                                        if(!valRol(txtRol.getText()))
                                            OptionPane.showMessage("Registro en el Sistema", "Los roles son Administrador, Laboratorista o Auditor", "/img/iconos/Close.png");
                                        else
                                            if(!String.valueOf(txtContrasena.getPassword()).isEmpty() && !String.valueOf(txtContrasena.getPassword()).equals("Contraseña")) 
                                            {
                                                Contrasena obc = new Contrasena(String.valueOf(txtContrasena.getPassword()));
                                                if(obc.ValidarContrasena())
                                                {
                                                    resp = CONTROL.Insertar(txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), String.valueOf(txtContrasena.getPassword()), txtRol.getText());
                                                    OptionPane.showMessage("Registro en el Sistema", "Usuario registrado exitosamente, por favor ingrese con su nueva cuenta", "/img/iconos/Info.png");
                                                    txtNombre.setText("Nombre de usuario");
                                                    txtApellido.setText("Apellido paterno de usuario");
                                                    txtCorreo.setText("Correo electrónico");
                                                    txtContrasena.setText("Contraseña");
                                                    txtRol.setText("Rol");
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
    }//GEN-LAST:event_lblCrearCMouseClicked

    private void lblGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerarMouseClicked
        txtContrasena.setText(Generar());
    }//GEN-LAST:event_lblGenerarMouseClicked

    private void txtContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusLost
        if(String.valueOf(txtContrasena.getPassword()).equals(""))
            txtContrasena.setText("Contraseña");
    }//GEN-LAST:event_txtContrasenaFocusLost

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained
        if(String.valueOf(txtContrasena.getPassword()).equals("Contraseña"))
            txtContrasena.setText("");
    }//GEN-LAST:event_txtContrasenaFocusGained

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        if(txtApellido.getText().isEmpty())
            txtApellido.setText("Apellido paterno");
    }//GEN-LAST:event_txtApellidoFocusLost

    private void txtApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusGained
        if(txtApellido.getText().equals("Apellido paterno"))
            txtApellido.setText("");
    }//GEN-LAST:event_txtApellidoFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().isEmpty())
            txtNombre.setText("Nombre de usuario");
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if(txtNombre.getText().equals("Nombre de usuario"))
            txtNombre.setText("");
    }//GEN-LAST:event_txtNombreFocusGained

    private void lblBlindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBlindMouseClicked
        lblBlind.setVisible(false);
        lblSee.setVisible(true);
        txtContrasena.setEchoChar((char)0);
    }//GEN-LAST:event_lblBlindMouseClicked

    private void lblSeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSeeMouseClicked
        lblBlind.setVisible(true);
        lblSee.setVisible(false);
        txtContrasena.setEchoChar('*');
    }//GEN-LAST:event_lblSeeMouseClicked

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        if(txtCorreo.getText().equals("Correo electrónico"))
            txtCorreo.setText("");
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if(txtCorreo.getText().equals(""))
            txtCorreo.setText("Correo electrónico");
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtRolFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRolFocusGained
        if(txtRol.getText().equals("Rol de usuario"))
            txtRol.setText("");
    }//GEN-LAST:event_txtRolFocusGained

    private void txtRolFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRolFocusLost
        if(txtRol.getText().equals(""))
            txtRol.setText("Rol de usuario");
    }//GEN-LAST:event_txtRolFocusLost

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
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
            error = "Hace falta una Mayúscula";
            return false;
        }

        private boolean tieneLetraMinuscula()
        {
            for(int i = 0; i < password.length(); i++)
                if(Character.isLowerCase(password.charAt(i)))
                    return true;
            error = "Hacen falta Minúsculas";
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
                error = "Hace falta un Número";
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
                error = "Hace falta un Caracter Especial";
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblBlind;
    private javax.swing.JLabel lblCrearC;
    private javax.swing.JLabel lblGenerar;
    private javax.swing.JLabel lblSee;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
}
