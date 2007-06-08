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
        jScrollPane1 = new javax.swing.JScrollPane();
        tfBody = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

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
        tfPrintSequence.setNextFocusableComponent(tfBody);
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

        add(tfPrintSequence, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 20, -1));

        lId.setText("CommentId:");
        lId.setFocusable(false);
        add(lId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tfId.setEditable(false);
        tfId.setText("1234");
        tfId.setFocusable(false);
        add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 35, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(606, 54));
        tfBody.setFont(fieldFont);
        tfBody.setLineWrap(true);
        tfBody.setRows(4);
        tfBody.setToolTipText("Koment\u0101rs");
        tfBody.setEnabled(false);
        tfBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfBodyMouseClicked(evt);
            }
        });
        tfBody.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBodyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBodyFocusLost(evt);
            }
        });

        jScrollPane1.setViewportView(tfBody);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 5, 480, 50));

        jLabel1.setText("Drukas indekss:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 20));

    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selectLine(this);
    }//GEN-LAST:event_formMouseClicked

    private void tfBodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBodyMouseClicked
        selectLine(this);
    }//GEN-LAST:event_tfBodyMouseClicked

    private void tfBodyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBodyFocusLost
        saveLine();
    }//GEN-LAST:event_tfBodyFocusLost

    private void tfBodyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBodyFocusGained
        selectLine(this);
    }//GEN-LAST:event_tfBodyFocusGained

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lId;
    private javax.swing.JTextArea tfBody;
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
        tfBody.setEnabled(!getBikComment().getDeleted());
        tfPrintSequence.setEnabled(!getBikComment().getDeleted());
        
        tfBody.setText(getBikComment().getBody());
        tfBody.setCaretPosition(0);
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

        if (getBikComment().getBody().equals(tfBody.getText()) &&
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

            if (!getBikComment().getBody().equals(tfBody.getText())){
                HistoryEvent he = new data.HistoryEvent();
                he.setDate(new Date(System.currentTimeMillis()));
                he.setObjId(getBikComment().getId());
                he.setObjType(getBikComment().getObjType().getId());
                he.setFieldName("body");
                he.setMessage("Nomain�ts saturs");
                he.setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
                he.setNewVal(tfBody.getText().trim());
                he.setOldVal(getBikComment().getBody());
                he.bikSave();
            }
            
            getBikComment().setPrintSequence(printSequence);
            getBikComment().setBody(tfBody.getText());
            getBikComment().setDateModified(new Date(System.currentTimeMillis()));
            getBikComment().setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
            getBikComment().bikSave(getMainWindow(this).getHibernateSession());
        }
    }

    public void decorateLine() {
         // now let's color deleted items
        if (getBikComment().getDeleted()) {
            this.setBackground(deletedItemColor);
            tfPrintSequence.setBackground(deletedItemColor);
            tfBody.setBackground(deletedItemColor);
            return ;
        } else {
            this.setBackground(backgroundColor);
            tfPrintSequence.setBackground(editableFieldBackgroundColor);
            tfBody.setBackground(editableFieldBackgroundColor);
        }
        // now let's color selected line
        if (getMainWindow(this)!=null && getMainWindow(this).getSelectedLine().equals(this)){
            this.setBackground(selectedLineBackgroundColor);
            tfPrintSequence.setBackground(editableFieldBackgroundColor);
            tfBody.setBackground(editableFieldBackgroundColor);
        }
    }
    
    
    public JTextComponent getDefaultFocusComponent() {
        return tfBody;
    }

    public void expand() {
        return ;
    }
    

}
