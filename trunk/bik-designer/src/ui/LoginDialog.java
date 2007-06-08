/*
 * LoginDialog.java
 *
 * Created on tre�diena, 2007, 18 apr�lis, 10:45
 */

package ui;

import bikdesigner.HibernateUtil;
import data.BikUser;
import java.security.*;
import java.security.spec.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.crypto.*;
import javax.crypto.spec.*;
import org.hibernate.*;

/**
 *
 * @author  mpurins
 */
public class LoginDialog extends javax.swing.JDialog {
    private List bikUsers;
    private Session hibernateSession;
    
    /** Creates new form LoginDialog */
    
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void attemptLogin() {
        if (tfUserName.getText().length()==0 || tfPassword.getPassword().length==0){
            tfStatus.setText("Lieto�jv�rdam un paroles laukam j�b�t aizpild�tiem.");
            return ;
        }
        
        Boolean foundUser=false;
        Session s = HibernateUtil.getCurrentSession();
        bikUsers = s.createQuery("from BikUser").list();
        Iterator userIterator = bikUsers.iterator();
        BikUser user = null;
        
        
        while (userIterator.hasNext()){
            user = (BikUser) userIterator.next();
            if (user.getShortName().equals(tfUserName.getText())){
                foundUser=true;
                break;
            }
        }
        
        if (!foundUser){
            tfStatus.setText("Lietot�js nav atrasts [" +tfUserName.getText()+"].");
            return;
        }
        tfStatus.setText("Lietot�js ir atrasts [" +tfUserName.getText()+"]. P�rbaudu paroli...");
        if (user.getPassword()!=null) {
            
            if (!getEncryptedSecret(tfPassword.getPassword()).equals(user.getPassword())) {
                tfStatus.setText(new Date(System.currentTimeMillis()) + " Nepareiza parole!");
                return;
            }
            
        } else {
            String passHash = getEncryptedSecret(tfPassword.getPassword());
            user.setPassword(passHash);
            user.bikSave();
        };
        //it's a success user authenticated
        ((MainWindow)this.getParent()).setCurrentUser(user);
        this.setVisible(false);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        tfUserName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfStatus = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lietot\u0101ja autentifik\u0101cija");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setModal(true);
        setName("loginDialog");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Lietot\u0101ja v\u0101rds:");

        jLabel2.setText("Parole:");

        loginButton.setText("Piesl\u0113gties");
        loginButton.setNextFocusableComponent(exitButton);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Beigt darbu");
        exitButton.setNextFocusableComponent(tfUserName);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        tfUserName.setNextFocusableComponent(tfPassword);
        tfUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserNameActionPerformed(evt);
            }
        });

        tfPassword.setNextFocusableComponent(loginButton);
        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        tfStatus.setBackground(java.awt.SystemColor.control);
        tfStatus.setColumns(20);
        tfStatus.setEditable(false);
        tfStatus.setFont(new java.awt.Font("Tahoma", 0, 10));
        tfStatus.setRows(2);
        tfStatus.setText("Ievadiet lietot\u0101jv\u0101rdu un paroli!");
        tfStatus.setWrapStyleWord(true);
        jScrollPane1.setViewportView(tfStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPassword)
                            .addComponent(tfUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        attemptLogin();
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void tfUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserNameActionPerformed
        tfPassword.requestFocus();
    }//GEN-LAST:event_tfUserNameActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    this.tfUserName.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
    this.setVisible(false);    
    System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        attemptLogin();
    }//GEN-LAST:event_loginButtonActionPerformed
private static String getEncryptedSecret(char[] passwd) {
        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec;
        SecretKeyFactory keyFac = null;
        Cipher pbeCipher = null;
        byte[] secretToEncrypt = "BikDesigner".getBytes();
        String secret;
        
        // Setup encryoption key
        byte[] salt = {
            (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
            (byte)0xde, (byte)0x45, (byte)0xee, (byte)0x88
        };
        int count = 20;
        pbeParamSpec = new PBEParameterSpec(salt, count);
        // String passw = new String (tfPassword.getPassword());
        pbeKeySpec = new PBEKeySpec(passwd);
        SecretKey pbeKey = null;
        try {
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            //System.out.println("Encoded key " +pbeKey.getEncoded() + " from text: " +passw);
            pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
            // Encrypt the cleartext
            secret = new String(pbeCipher.doFinal(secretToEncrypt));
            //System.out.println("'BikDesigner' encrypted: "+secret);
            return secret;
            
        } catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (InvalidAlgorithmParameterException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        }
        return null;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
        bikUsers = getHibernateSession().createQuery("from BikUser").list();

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextArea tfStatus;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
    
}