/*
 * SectionLine.java
 *
 * Created on tre�diena, 2007, 18 apr�lis, 16:50
 */

package ui;

import data.BikObjType;
import data.BikComment;
import data.HistoryEvent;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author  mpurins
 */
public class CommentLine extends AbstractBikItemLine {

    /** Creates new form CommentLine */
    public CommentLine() {
        initComponents();
        // hide IDs
        tfId.setVisible(false);
        lId.setVisible(false);

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        tfPrintSequence = new javax.swing.JTextField();
        lId = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        iconNotForPrint = new javax.swing.JLabel();
        iconNeedsProofReading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taBody = new javax.swing.JTextPane();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(626, 77));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tfPrintSequence.setText("11");
        tfPrintSequence.setToolTipText("Drukas k\u0101rt\u012bbas indekss");
        tfPrintSequence.setEnabled(false);
        tfPrintSequence.setMinimumSize(new java.awt.Dimension(60, 20));
        tfPrintSequence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfPrintSequenceMouseClicked(evt);
            }
        });
        tfPrintSequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrintSequenceActionPerformed(evt);
            }
        });
        tfPrintSequence.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPrintSequenceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPrintSequenceFocusLost(evt);
            }
        });

        add(tfPrintSequence, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 15, 20, -1));

        lId.setText("CommentId:");
        lId.setFocusable(false);
        add(lId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tfId.setEditable(false);
        tfId.setText("1234");
        tfId.setFocusable(false);
        add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 35, -1));

        iconNotForPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/nonprinting.gif")));
        add(iconNotForPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 15, 12));

        iconNeedsProofReading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/proofread.gif")));
        add(iconNeedsProofReading, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 27, 12, 15));

        jLabel1.setLabelFor(tfPrintSequence);
        jLabel1.setText("Drukas indekss:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 14, -1, 21));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/docu-32x32.png")));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 9, 32, 32));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        taBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taBodyMouseClicked(evt);
            }
        });
        taBody.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                taBodyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                taBodyFocusLost(evt);
            }
        });
        taBody.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taBodyKeyPressed(evt);
            }
        });

        jScrollPane2.setViewportView(taBody);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 3, 492, 51));

    }// </editor-fold>//GEN-END:initComponents

    private void taBodyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taBodyKeyPressed
//pressing Enter key saves the record
        if (evt.getKeyCode()==10){
            // and does not allow new line to be inserted
            evt.consume();
            saveLine();
        }
    }//GEN-LAST:event_taBodyKeyPressed

    private void taBodyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taBodyFocusLost
        saveLine();
    }//GEN-LAST:event_taBodyFocusLost

    private void taBodyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taBodyFocusGained
        selectLine(this);
    }//GEN-LAST:event_taBodyFocusGained

    private void taBodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taBodyMouseClicked
        selectLine(this);
    }//GEN-LAST:event_taBodyMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selectLine(this);
    }//GEN-LAST:event_formMouseClicked

    private void tfPrintSequenceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPrintSequenceMouseClicked
        selectLine(this);
    }//GEN-LAST:event_tfPrintSequenceMouseClicked

    private void tfPrintSequenceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrintSequenceFocusLost
        saveLine();
    }//GEN-LAST:event_tfPrintSequenceFocusLost

    private void tfPrintSequenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrintSequenceFocusGained
        selectLine(this);
    }//GEN-LAST:event_tfPrintSequenceFocusGained

    private void tfPrintSequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrintSequenceActionPerformed
        saveLine();
    }//GEN-LAST:event_tfPrintSequenceActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconNeedsProofReading;
    private javax.swing.JLabel iconNotForPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lId;
    private javax.swing.JTextPane taBody;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfPrintSequence;
    // End of variables declaration//GEN-END:variables

    public Boolean isPriceDefUser() {
        return false;
    }
    
    public BikComment getBikComment() {
        return (BikComment) this.getBikDataObject();
    }
    public void setBikComment(BikComment commentVal){
        this.setBikDataObject(commentVal);
        updateUiComponents();
    }

    public void updateUiComponents() {
        taBody.setEnabled(!getBikComment().getDeleted());
        tfPrintSequence.setEnabled(!getBikComment().getDeleted());
        
        taBody.setText(getBikComment().getBody());
        taBody.setCaretPosition(0);
        tfPrintSequence.setText(getBikComment().getPrintSequence().toString());
        tfId.setText(getBikComment().getId().toString());
    }
    private void saveLine(){
        // now validate data
        Integer printSequence;
        try {
            printSequence = new Integer(tfPrintSequence.getText());
        }catch (NumberFormatException ex) {
            getMainWindow(this).setStatusText("K��DA: Drukas k�rt�bas v�rt�ba ["+tfPrintSequence.getText()+"] neder. J�b�t veselam skaitlim.");
            tfPrintSequence.requestFocus();
            return;
        }

        if (getBikComment().getBody().equals(taBody.getText()) &&
                getBikComment().getPrintSequence().equals(printSequence)){
            return ;
        } else {
            //dirty record need to save
            // first save the history records because after save cannot see 
            // difference between state in db and memory
            if (!getBikComment().getPrintSequence().equals(printSequence)){
                HistoryEvent he = new data.HistoryEvent();
                he.setDate(new Date(System.currentTimeMillis()));
                he.setObjId(getBikComment().getId());
                he.setObjType(getBikComment().getObjType().getId());
                he.setFieldName("printSequence");
                he.setMessage("Main�ts druk��anas k�rt�bas indekss");
                he.setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
                he.setNewVal(printSequence.toString());
                he.setOldVal(getBikComment().getPrintSequence().toString());
                he.bikSave();
            }

            if (!getBikComment().getBody().equals(taBody.getText())){
                HistoryEvent he = new data.HistoryEvent();
                he.setDate(new Date(System.currentTimeMillis()));
                he.setObjId(getBikComment().getId());
                he.setObjType(getBikComment().getObjType().getId());
                he.setFieldName("body");
                he.setMessage("Nomain�ts saturs");
                he.setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
                he.setNewVal(taBody.getText().trim());
                he.setOldVal(getBikComment().getBody());
                getBikComment().setNeedProofReading(true);
                he.bikSave();
            }
            
            getBikComment().setPrintSequence(printSequence);
            getBikComment().setBody(taBody.getText());
            getBikComment().setDateModified(new Date(System.currentTimeMillis()));
            getBikComment().setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
            getBikComment().bikSave(getMainWindow(this).getHibernateSession());
            decorateLine();
        }
    }

    public void decorateLine() {
        if (getBikComment().isNotForPrint()) iconNotForPrint.setVisible(true); 
        else iconNotForPrint.setVisible(false); 

        if (getBikComment().isNeedProofReading()) iconNeedsProofReading.setVisible(true); 
        else iconNeedsProofReading.setVisible(false); 

        // now let's color deleted items
        if (getBikComment().getDeleted()) {
            this.setBackground(deletedItemColor);
            tfPrintSequence.setBackground(deletedItemColor);
            taBody.setBackground(deletedItemColor);
            return ;
        } else {
            this.setBackground(backgroundColor);
            tfPrintSequence.setBackground(editableFieldBackgroundColor);
            taBody.setBackground(editableFieldBackgroundColor);
        }
        // now let's color selected line
        if (getMainWindow(this)!=null && getMainWindow(this).getSelectedLine().equals(this)){
            this.setBackground(selectedLineBackgroundColor);
            tfPrintSequence.setBackground(editableFieldBackgroundColor);
            taBody.setBackground(editableFieldBackgroundColor);
        }
        
    }
    
    
    public JTextComponent getDefaultFocusComponent() {
        return taBody;
    }

    public void expand() {
        return ;
    }
    

}
