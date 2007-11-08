/*
 * SectionLine.java
 *
 * Created on tre�diena, 2007, 18 apr�lis, 16:50
 */

package ui;

import bikdesigner.HibernateUtil;
import data.BikComment;
import data.BikObjType;
import data.BikSection;
import data.BikSubsection;
import data.BikWorkItem;
import data.HistoryEvent;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  mpurins
 */
public class SubsectionLine extends AbstractBikItemLine {
    
    /** Creates new form SectionLine */
    public SubsectionLine() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        expanderButton = new javax.swing.JToggleButton();
        tfCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfName = new javax.swing.JTextArea();
        tfSectionCode = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        lId = new javax.swing.JLabel();
        iconNotForPrint = new javax.swing.JLabel();
        iconNeedsProofReading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(700, 38));
        setPreferredSize(new java.awt.Dimension(700, 38));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        expanderButton.setText("+");
        expanderButton.setEnabled(false);
        expanderButton.setFocusPainted(false);
        expanderButton.setFocusable(false);
        expanderButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        expanderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expanderButtonActionPerformed(evt);
            }
        });

        add(expanderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 12, 15, 15));

        tfCode.setText("11");
        tfCode.setEnabled(false);
        tfCode.setMinimumSize(new java.awt.Dimension(60, 20));
        tfCode.setNextFocusableComponent(tfName);
        tfCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfCodeMouseClicked(evt);
            }
        });
        tfCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodeActionPerformed(evt);
            }
        });
        tfCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodeFocusLost(evt);
            }
        });

        add(tfCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 9, 50, 24));

        tfName.setColumns(20);
        tfName.setFont(fieldFont);
        tfName.setLineWrap(true);
        tfName.setRows(2);
        tfName.setWrapStyleWord(true);
        tfName.setEnabled(false);
        tfName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfNameMouseClicked(evt);
            }
        });
        tfName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNameFocusLost(evt);
            }
        });
        tfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNameKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(tfName);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 3, 531, -1));

        tfSectionCode.setEditable(false);
        tfSectionCode.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        tfSectionCode.setText("01-");
        tfSectionCode.setBorder(null);
        tfSectionCode.setFocusable(false);
        tfSectionCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSectionCodeMouseClicked(evt);
            }
        });

        add(tfSectionCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 9, 27, 24));

        tfId.setEditable(false);
        tfId.setText("1234");
        add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 3, 70, -1));

        lId.setText("Subsection ID:");
        add(lId, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 3, -1, -1));

        iconNotForPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/nonprinting.gif")));
        iconNotForPrint.setToolTipText("Vajag p\u0101rbaud\u012bt gramatiku");
        add(iconNotForPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 4, 24, 15));

        iconNeedsProofReading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/proofread.gif")));
        add(iconNeedsProofReading, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 12, 21, 21));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Folder-copy-2-32x32.png")));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 3, 33, -1));

    }// </editor-fold>//GEN-END:initComponents

    private void tfNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameKeyPressed
        
        //pressing Enter key saves the record
        if (evt.getKeyCode()==10){
            // and does not allow new line to be inserted
            evt.consume();
            saveLine();
        }
        //System.out.println(evt.getKeyCode());
        
    }//GEN-LAST:event_tfNameKeyPressed

    private void tfNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusLost
        saveLine();
    }//GEN-LAST:event_tfNameFocusLost

    private void tfNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNameMouseClicked
        selectLine(this);
    }//GEN-LAST:event_tfNameMouseClicked
    
    private void tfCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCodeMouseClicked
        selectLine(this);
    }//GEN-LAST:event_tfCodeMouseClicked
    
    private void tfCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodeFocusLost
        saveLine();
        // System.out.println("tfCodeFocusLost");
    }//GEN-LAST:event_tfCodeFocusLost
    
    private void tfCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodeActionPerformed
        saveLine();
        // System.out.println("tfCodeActionPerformed");
    }//GEN-LAST:event_tfCodeActionPerformed
    
    private void tfSectionCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSectionCodeMouseClicked
        selectLine(this);
        // System.out.println("tfSectionCodeMouseClicked");
    }//GEN-LAST:event_tfSectionCodeMouseClicked
        
    private void tfNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusGained
        selectLine(this);
        // System.out.println("tfNameFocusGained");
    }//GEN-LAST:event_tfNameFocusGained
    
    private void tfCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodeFocusGained
        selectLine(this);
        // System.out.println("tfCodeFocusGained");
    }//GEN-LAST:event_tfCodeFocusGained
        
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selectLine(this);
    }//GEN-LAST:event_formMouseClicked
    
    private void expanderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expanderButtonActionPerformed
        selectLine(this);
        saveLine();
        
        int curParentIndex;
        for (curParentIndex=0; curParentIndex<getParent().getComponentCount();curParentIndex++){
            if (getParent().getComponent(curParentIndex).equals(this)) break;
        }
        
        
        if (expanderButton.isSelected()) {
            expanderButton.setText("-");
            getMainWindow(this).getHibernateSession().refresh(getBikSubsection());
            Iterator wiIt = getBikSubsection().getBikWorkItemCollection().iterator();
            int addIndex = curParentIndex+1;
            Boolean hd = getMainWindow(this).getViewHideDeleted();
            
            Iterator commentsIt = getBikSubsection().getBikComments().iterator();
            while (commentsIt.hasNext()){
                BikComment comment = (BikComment) commentsIt.next();
                if ( !(hd && comment.getDeleted()) ){
                    CommentLine commentL = new CommentLine();
                    HibernateUtil.getCurrentSession().refresh(comment);
                    commentL.setBikComment(comment);
                    this.getParent().add(commentL,addIndex);
                    addIndex++;
                }
            }

            while (wiIt.hasNext()){
                BikWorkItem wi = (BikWorkItem)wiIt.next();
                if ( !(hd && wi.getDeleted()) ){
                    WorkItemLine wiL = new WorkItemLine();
                    getMainWindow(this).getHibernateSession().refresh(wi);
                    wiL.setBikWorkItem(wi);
                    this.getParent().add(wiL,addIndex);
                    addIndex++;
                }
            }
            
        } else {
            expanderButton.setText("+");
            while(getParent().getComponentCount()>curParentIndex+1){
                IBikItemLine il = (IBikItemLine) getParent().getComponent(curParentIndex+1);
                if (il.getBikDataObject().getObjType().equals(BikObjType.SECTION) ||
                        il.getBikDataObject().getObjType().equals(BikObjType.SUBSECTION)) break;
                getParent().remove(curParentIndex+1);
            }
        }
        
    }//GEN-LAST:event_expanderButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton expanderButton;
    private javax.swing.JLabel iconNeedsProofReading;
    private javax.swing.JLabel iconNotForPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lId;
    private javax.swing.JTextField tfCode;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextArea tfName;
    private javax.swing.JTextField tfSectionCode;
    // End of variables declaration//GEN-END:variables
    
    public Boolean isPriceDefUser() {
        return false;
    }
    
    public BikSubsection getBikSubsection() {
        return (BikSubsection) this.getBikDataObject();
    }
    public void setBikSubsection(BikSubsection secVal){
        this.setBikDataObject(secVal);
        updateUiComponents();
        decorateLine();
    }
    
    public void updateUiComponents() {
        
        // hide IDs
        tfId.setVisible(false);
        lId.setVisible(false);
        if (getMainWindow(this)!=null){
            // null may be only during initiation
            if (getMainWindow(this).getViewHideObjectIds()){
                tfId.setVisible(false);
                lId.setVisible(false);
            }
        }
        tfCode.setText(getBikSubsection().getCode());
        tfName.setText(getBikSubsection().getName());
        tfName.setCaretPosition(0);
        tfId.setText(getBikSubsection().getId().toString());
        expanderButton.setEnabled(true);
        expanderButton.setToolTipText("Darbu skaits:"+getBikSubsection().getBikWorkItemCollection().size());
        tfSectionCode.setText(getBikSubsection().getSection().getCode()+"-");
        
        // if deleted - controls are disabled
        tfCode.setEnabled(!getBikSubsection().getDeleted());
        tfName.setEnabled(!getBikSubsection().getDeleted());
    }
    private void saveLine(){
        // now validate data
        if (tfCode.getText().length()>5) {
            getMainWindow(this).setStatusText("K��DA: Sada�as kods ["+tfCode.getText()+"] neder. Garums nedr�kst p�rsniegt 5 simbolus.");
            tfCode.requestFocus();
            return;
        }
        if (getBikSubsection().getCode().equals(tfCode.getText())&&
                getBikSubsection().getName().equals(tfName.getText())){
            return ;
        } else {
            //dirty record need to save
            // first save the history records because after save cannot see 
            // difference between state in db and memory
            if (!getBikSubsection().getCode().equals(tfCode.getText())){
                HistoryEvent he = new data.HistoryEvent();
                he.setDate(new Date(System.currentTimeMillis()));
                he.setObjId(getBikSubsection().getId());
                he.setObjType(getBikSubsection().getObjType().getId());
                he.setFieldName("code");
                he.setMessage("Nomain�ts kods");
                he.setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
                he.setNewVal(tfCode.getText().trim());
                he.setOldVal(getBikSubsection().getCode());
                he.bikSave();
            }

            if (!getBikSubsection().getName().equals(tfName.getText())){
                HistoryEvent he = new data.HistoryEvent();
                he.setDate(new Date(System.currentTimeMillis()));
                he.setObjId(getBikSubsection().getId());
                he.setObjType(getBikSubsection().getObjType().getId());
                he.setFieldName("name");
                he.setMessage("Nomain�ts nosaukums");
                he.setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
                he.setNewVal(tfName.getText().trim());
                he.setOldVal(getBikSubsection().getName());
                getBikSubsection().setNeedProofReading(true);
                he.bikSave();
            }
            
            
            getBikSubsection().setCode(tfCode.getText());
            getBikSubsection().setName(tfName.getText());
            getBikSubsection().setDateModified(new Date(System.currentTimeMillis()));
            getBikSubsection().setModifiedBy(getMainWindow(this).getCurrentUser().getFullName());
            getBikSubsection().bikSave(getMainWindow(this).getHibernateSession());
            decorateLine();
        }
    }

    public void decorateLine() {
        
        if (getBikSubsection().isNotForPrint()) iconNotForPrint.setVisible(true); 
        else iconNotForPrint.setVisible(false); 

        if (getBikSubsection().isNeedProofReading()) iconNeedsProofReading.setVisible(true); 
        else iconNeedsProofReading.setVisible(false); 

        // now let's color deleted items
        if (getBikSubsection().getDeleted()) {
            this.setBackground(deletedItemColor);
            tfCode.setBackground(deletedItemColor);
            tfName.setBackground(deletedItemColor);
            tfSectionCode.setBackground(deletedItemColor);
            expanderButton.setBackground(deletedItemColor);
            return ;
        } else {
            this.setBackground(backgroundColor);
            tfCode.setBackground(editableFieldBackgroundColor);
            tfName.setBackground(editableFieldBackgroundColor);
            tfSectionCode.setBackground(backgroundColor);
            expanderButton.setBackground(backgroundColor);
        }
        
        // now let's color selected line
        if (getMainWindow(this)!=null && getMainWindow(this).getSelectedLine().equals(this)){
            this.setBackground(selectedLineBackgroundColor);
            tfCode.setBackground(editableFieldBackgroundColor);
            tfName.setBackground(editableFieldBackgroundColor);
            tfSectionCode.setBackground(selectedLineBackgroundColor);
            expanderButton.setBackground(selectedLineBackgroundColor);
        }
    }
    
    public JTextComponent getDefaultFocusComponent() {
        return tfName;
    }

    public void expand() {
        if (expanderButton.isSelected()) return ;
        expanderButton.setSelected(true);
        expanderButtonActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,""));
    }

}