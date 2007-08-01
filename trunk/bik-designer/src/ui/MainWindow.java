/*
 * MainWindow.java
 *
 * Created on pirmdiena, 2007, 16 apr�lis, 16:23
 */

package ui;

import bikdesigner.HibernateUtil;
import data.BikCatalog;
import data.BikComment;
import data.BikObjType;
import data.BikSection;
import data.BikSubsection;
import data.BikUser;
import data.BikWorkItem;
import data.BikWorkItemComponent;
import data.HistoryEvent;
import data.HistoryTableModel;
import data.IBikDataObject;
import java.awt.Adjustable;
import java.awt.ScrollPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.BoundedRangeModel;
import javax.swing.JFileChooser;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import org.hibernate.Session;

/**
 *
 * @author  mpurins
 */
public class MainWindow extends javax.swing.JFrame{
    
    private BikCatalog catalog;
    private PriceSelectionDialog priceDialog = new PriceSelectionDialog(this, true);
    private Session hibernateSession = HibernateUtil.getCurrentSession();
    private LoginDialog loginDialog = new LoginDialog(this, true);
    private BikUser currentUser=null;
    private IBikItemLine selectedLine = null;
    private HistoryTableModel historyTableModel = new HistoryTableModel();
    
    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        priceDialog.setHibernateSession(this.getHibernateSession());
        loginDialog.setHibernateSession(this.getHibernateSession());
    }
    
    public void setStatusText(String msg){
        lStatusText.setText(msg);
    }
    
    public PriceSelectionDialog getPriceDialog() {
        return priceDialog;
    }
    
    public void setPriceDialog(PriceSelectionDialog priceDialog) {
        this.priceDialog = priceDialog;
    }
    
    public BikUser getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(BikUser currentUser) {
        this.currentUser = currentUser;
    }
    
    public IBikItemLine getSelectedLine() {
        return selectedLine;
    }
    
    public void refreshSelectedLineHistory() {
        IBikDataObject obj = selectedLine.getBikDataObject();
        historyTableModel.setParent(obj.getId(), obj.getObjType().getId());
        if (historyTableModel.getRowCount()==0) {
            historyTable.setEnabled(false);
            historyTableLabel.setEnabled(false);
        }
        else {
            historyTable.setEnabled(true);
            historyTableLabel.setEnabled(false);
        }
        historyTable.invalidate();
        historyObjTypeLabel.setText(obj.getClass().getCanonicalName());
        historyObjID.setText(obj.getId().toString());
        
    }
    
    public void setSelectedLine(IBikItemLine selectedLine) {
        IBikItemLine oldSelectedLine = this.selectedLine;
        this.selectedLine = selectedLine;
        if (oldSelectedLine!=null) oldSelectedLine.decorateLine();
        selectedLine.decorateLine();
        refreshSelectedLineHistory();
        updateAccessibleCommands();
    }
    
    public Boolean getViewHideDeleted(){
        return hideDeletedMenuItem.isSelected();
    }
    
    public Boolean getViewHideObjectIds() {
        return hideObjectIds.isSelected();
    }
    
    public Boolean getViewShowDeletedOnly() {
        return onlyDeleted.isSelected();
    }
    
    public Boolean getViewShowProofReadingOnly() {
        return onlyNeedProofreading.isSelected();
    }
    
    public Boolean getViewShowNotForPrintOnly() {
        return onlyNotForPrint.isSelected();
    }

    class Task extends SwingWorker<Void, Void> {
        
        private ProgressMonitor pm;
        
        public Task(ProgressMonitor pmval) {
            pm=pmval;
        }
        
        @Override
        public Void doInBackground() {
                int progresscounter=0;
                pm.setMillisToPopup(0);
                pm.setMillisToDecideToPopup(0);
                pm.setMaximum(catalog.getBikSectionCollection().size());
                listViewPanel.removeAll();
                Iterator secIter = catalog.getBikSectionCollection().iterator();
                while (secIter.hasNext()){
                    progresscounter +=1;
                    pm.setProgress(progresscounter);
                    BikSection s = (BikSection) secIter.next();
                    pm.setNote(s.getCode().trim() + " " + s.getName());

                    if ( !(getViewHideDeleted() && s.getDeleted()) ){
                        SectionLine sl = new SectionLine();
                        sl.setBikSection(s);
                        listViewPanel.add(sl);
                    }
                }
                listViewPanel.validate();
                return null;
        }
        
        @Override
        public void done() {
            pm.close();
            if (pm.isCanceled()) setStatusText("Noda�as saturs iel�d�ts");
            
        }
    }

    private void fillSections(){
        ProgressMonitor pm = new ProgressMonitor(this, "Sa�emu noda�as datus no servera", 
                 "L�d�ju noda�as", 0, 3);

        Task t = new Task(pm);
        t.execute();            

    }

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        statusBar = new javax.swing.JToolBar();
        lStatusText = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lUserName = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        historyObjTypeLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        historyTableLabel = new javax.swing.JLabel();
        historyObjID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listViewPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenuItem();
        changePasswordMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        exportTypesettingMenuItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        exitMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        hideDeletedMenuItem = new javax.swing.JCheckBoxMenuItem();
        hideObjectIds = new javax.swing.JCheckBoxMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        onlyDeleted = new javax.swing.JCheckBoxMenuItem();
        onlyNotForPrint = new javax.swing.JCheckBoxMenuItem();
        onlyNeedProofreading = new javax.swing.JCheckBoxMenuItem();
        editMenu = new javax.swing.JMenu();
        addWiCMaterialsMI = new javax.swing.JMenuItem();
        addWiCLabourMI = new javax.swing.JMenuItem();
        addWiCDepreciationMI = new javax.swing.JMenuItem();
        addWiCDepreciationPercentMI = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        addWorkItemMI = new javax.swing.JMenuItem();
        addSubsectionMI = new javax.swing.JMenuItem();
        addCommentMI = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        deletedStatusMenuItem = new javax.swing.JCheckBoxMenuItem();
        requiresProofreadingStatusMenuItem = new javax.swing.JCheckBoxMenuItem();
        notPrintingMenuItem = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BIK dizaineris 2007 v0.1");
        setName("MainFrame");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        statusBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lStatusText.setText("Statusa teksts");
        statusBar.add(lStatusText);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        statusBar.add(jSeparator2);

        jLabel2.setText(" Lietot\u0101js: ");
        statusBar.add(jLabel2);

        lUserName.setText("---- l\u016bdzu piesl\u0113dzieties sist\u0113mai ----");
        lUserName.setFocusable(false);
        lUserName.setRequestFocusEnabled(false);
        statusBar.add(lUserName);

        getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setDividerLocation(705);
        jSplitPane1.setDividerSize(3);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1000, 706));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(170, 404));
        historyTable.setModel(getHistoryTableModel());
        jScrollPane2.setViewportView(historyTable);

        historyObjTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        historyObjTypeLabel.setText("jLabel1");

        jLabel3.setText("Nosaukums:");

        jLabel4.setText("BIK kods:");

        jLabel1.setText("BIK dizainera ID:");

        historyTableLabel.setText("V\u0113sture:");

        historyObjID.setEditable(false);
        historyObjID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(historyObjTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(168, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(historyObjID, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(historyTableLabel)
                        .addContainerGap(172, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyObjTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(historyObjID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(historyTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jSplitPane1.setRightComponent(jPanel1);

        jScrollPane1.setBorder(null);
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        listViewPanel.setLayout(new javax.swing.BoxLayout(listViewPanel, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane1.setViewportView(listViewPanel);

        jSplitPane1.setLeftComponent(jScrollPane1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        fileMenu.setText("Sist\u0113ma");
        loginMenu.setText("Piesl\u0113gties...");
        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });

        fileMenu.add(loginMenu);

        changePasswordMenu.setText("Nomain\u012bt paroli...");
        changePasswordMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordMenuActionPerformed(evt);
            }
        });

        fileMenu.add(changePasswordMenu);

        fileMenu.add(jSeparator1);

        exportTypesettingMenuItem.setText("Eksport\u0113t maket\u0113\u0161anai...");
        exportTypesettingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTypesettingMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exportTypesettingMenuItem);

        fileMenu.add(jSeparator6);

        exitMenuItem.setText("Beigt darbu");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        viewMenu.setText("Skats");
        hideDeletedMenuItem.setText("Sl\u0113pt dz\u0113stos");
        hideDeletedMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideDeletedMenuItemActionPerformed(evt);
            }
        });

        viewMenu.add(hideDeletedMenuItem);

        hideObjectIds.setSelected(true);
        hideObjectIds.setText("Sl\u0113pt objektu identifik\u0101torus");
        hideObjectIds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideObjectIdsActionPerformed(evt);
            }
        });

        viewMenu.add(hideObjectIds);

        viewMenu.add(jSeparator3);

        onlyDeleted.setText("R\u0101d\u012bt tikai dz\u0113stos ");
        viewMenu.add(onlyDeleted);

        onlyNotForPrint.setText("R\u0101d\u012bt tikai nedruk\u0101jamos");
        viewMenu.add(onlyNotForPrint);

        onlyNeedProofreading.setText("R\u0101d\u012bti tikai kori\u0123\u0113jamos");
        viewMenu.add(onlyNeedProofreading);

        menuBar.add(viewMenu);

        editMenu.setText("Darb\u012bbas");
        addWiCMaterialsMI.setText("+ Materi\u0101li");
        addWiCMaterialsMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWiCMaterialsMIActionPerformed(evt);
            }
        });

        editMenu.add(addWiCMaterialsMI);

        addWiCLabourMI.setText("+ Darba alga");
        addWiCLabourMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWiCLabourMIActionPerformed(evt);
            }
        });

        editMenu.add(addWiCLabourMI);

        addWiCDepreciationMI.setText("+ Amortiz\u0101cija");
        addWiCDepreciationMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWiCDepreciationMIActionPerformed(evt);
            }
        });

        editMenu.add(addWiCDepreciationMI);

        addWiCDepreciationPercentMI.setText("+ Amortiz\u0101cija (%)");
        addWiCDepreciationPercentMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWiCDepreciationPercentMIActionPerformed(evt);
            }
        });

        editMenu.add(addWiCDepreciationPercentMI);

        editMenu.add(jSeparator5);

        addWorkItemMI.setText("+ Darbs");
        addWorkItemMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkItemMIActionPerformed(evt);
            }
        });

        editMenu.add(addWorkItemMI);

        addSubsectionMI.setText("+ Sada\u013ca");
        addSubsectionMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubsectionMIActionPerformed(evt);
            }
        });

        editMenu.add(addSubsectionMI);

        addCommentMI.setText("+ Koment\u0101rs");
        addCommentMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommentMIActionPerformed(evt);
            }
        });

        editMenu.add(addCommentMI);

        editMenu.add(jSeparator4);

        deletedStatusMenuItem.setText("Ieraksts dz\u0113sts");
        deletedStatusMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletedStatusMenuItemActionPerformed(evt);
            }
        });

        editMenu.add(deletedStatusMenuItem);

        requiresProofreadingStatusMenuItem.setText("Gramatika");
        requiresProofreadingStatusMenuItem.setToolTipText("Iesl\u0113gts, ja nepiecie\u0161ams veikt gramatikas p\u0101rbaudi");
        editMenu.add(requiresProofreadingStatusMenuItem);

        notPrintingMenuItem.setText("Nedruk\u0101t");
        notPrintingMenuItem.setToolTipText("Ja iesl\u0113gts - netiks iek\u013cauts izdruk\u0101s");
        editMenu.add(notPrintingMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletedStatusMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletedStatusMenuItemActionPerformed
        IBikItemLine curLine;
        
        // negation because state of a button already changed
        if (!deletedStatusMenuItem.getState()) {
            // TODO: UNdelete action must be performed

            IBikDataObject bdo = getSelectedLine().getBikDataObject();
            bdo.setDeleted(false);
            bdo.setDeletedBy("");
            bdo.setDateDeleted(null);
            HibernateUtil.getCurrentSession().beginTransaction();
            HibernateUtil.getCurrentSession().saveOrUpdate(bdo);
            HibernateUtil.getCurrentSession().getTransaction().commit();

            HistoryEvent he = new data.HistoryEvent();
            he.setDate(new Date(System.currentTimeMillis()));
            he.setObjId(bdo.getId());
            he.setObjType(bdo.getObjType().getId());
            he.setFieldName("");
            he.setMessage("Ieraksts atjaunots");
            he.setModifiedBy(getCurrentUser().getFullName());
            he.bikSave();
            
            setStatusText("Ieraksts atjaunots");
            
        } else {
            // user requested to delete item 
            
            if (getSelectedLine()==null) return ;
            getSelectedLine().getBikDataObject().delete(getCurrentUser().getFullName());
            getSelectedLine().getBikDataObject().bikSave(getHibernateSession());

            HistoryEvent he = new data.HistoryEvent();
            he.setDate(new Date(System.currentTimeMillis()));
            he.setObjId(getSelectedLine().getBikDataObject().getId());
            he.setObjType(getSelectedLine().getBikDataObject().getObjType().getId());
            he.setFieldName("");
            he.setMessage("Ieraksts dz�sts");
            he.setModifiedBy(getCurrentUser().getFullName());
            he.bikSave();
            setStatusText("Ieraksts izdz�sts");
        }
        
        getSelectedLine().updateUiComponents();
        getSelectedLine().decorateLine();
        int i = getSelectedLineIndex();
        while (i<listViewPanel.getComponentCount()) {
            curLine = (IBikItemLine)listViewPanel.getComponent(i);
            curLine.updateUiComponents();
            curLine.decorateLine();
            i++;
        }

    }//GEN-LAST:event_deletedStatusMenuItemActionPerformed

    private void hideObjectIdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideObjectIdsActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_hideObjectIdsActionPerformed

    private void addCommentMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCommentMIActionPerformed
        addCommentLine();
    }//GEN-LAST:event_addCommentMIActionPerformed

    private void exportTypesettingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTypesettingMenuItemActionPerformed
        final JFileChooser fc = new JFileChooser("Desktop");
        this.setStatusText("Izv�lieties failu, kur� eksport�t datus maket��anai...");
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION ) {
            PrintWriter target;
            try {
                target = new PrintWriter(new BufferedWriter(new FileWriter(fc.getSelectedFile())));
                this.setStatusText("S�ku eksport�t datus fail� " +fc.getSelectedFile().getPath() + "...");
                this.catalog.exportToFileForTypesetting(target);
                target.close();
                this.setStatusText("Exports veiksm�gi pabeigts fail� " +fc.getSelectedFile().getPath());
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_exportTypesettingMenuItemActionPerformed

    private void addSubsectionMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubsectionMIActionPerformed
        addSubsectionLine();
    }//GEN-LAST:event_addSubsectionMIActionPerformed

    private void addWorkItemMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkItemMIActionPerformed
        addWorkItemLine();
    }//GEN-LAST:event_addWorkItemMIActionPerformed

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        if (evt.getScrollType()==evt.WHEEL_UNIT_SCROLL){
            BoundedRangeModel vsm = jScrollPane1.getVerticalScrollBar().getModel();
            vsm.setValue(vsm.getValue()+(evt.getWheelRotation()*40));
        }
    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    private void addWiCDepreciationPercentMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWiCDepreciationPercentMIActionPerformed
        addWorkItemComponentLine(BikObjType.DEPRECIATION_PERCENT);
    }//GEN-LAST:event_addWiCDepreciationPercentMIActionPerformed

    private void addWiCDepreciationMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWiCDepreciationMIActionPerformed
        addWorkItemComponentLine(BikObjType.DEPRECIATION);
    }//GEN-LAST:event_addWiCDepreciationMIActionPerformed

    private void addWiCMaterialsMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWiCMaterialsMIActionPerformed
        addWorkItemComponentLine(BikObjType.MATERIAL);
    }//GEN-LAST:event_addWiCMaterialsMIActionPerformed

    private void addWiCLabourMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWiCLabourMIActionPerformed
        addWorkItemComponentLine(BikObjType.LABOUR);

    }//GEN-LAST:event_addWiCLabourMIActionPerformed
    
    private void hideDeletedMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideDeletedMenuItemActionPerformed
        fillSections();
        listViewPanel.validate();
    }//GEN-LAST:event_hideDeletedMenuItemActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loginMenuActionPerformed(new java.awt.event.ActionEvent(this,1,"aaa"));
    }//GEN-LAST:event_formWindowOpened
    
    private void changePasswordMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordMenuActionPerformed
        priceDialog.setVisible(true);
    }//GEN-LAST:event_changePasswordMenuActionPerformed
    
    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuActionPerformed
        
        loginDialog.setVisible(true);
        lUserName.setText(currentUser.getFullName());
        lStatusText.setText("Lietot�js veiksm�gi piesl�dzies BIK serverim");
        catalog = new BikCatalog(getHibernateSession());
        catalog.setName("BIK 2007");
        fillSections();
    }//GEN-LAST:event_loginMenuActionPerformed
        
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    public void showPriceDialog(IPriceDefUser caller, String idVal){
        this.priceDialog.setCaller(caller);
        this.priceDialog.setOldPriceDefId(idVal);
        this.priceDialog.setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCommentMI;
    private javax.swing.JMenuItem addSubsectionMI;
    private javax.swing.JMenuItem addWiCDepreciationMI;
    private javax.swing.JMenuItem addWiCDepreciationPercentMI;
    private javax.swing.JMenuItem addWiCLabourMI;
    private javax.swing.JMenuItem addWiCMaterialsMI;
    private javax.swing.JMenuItem addWorkItemMI;
    private javax.swing.JMenuItem changePasswordMenu;
    private javax.swing.JCheckBoxMenuItem deletedStatusMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exportTypesettingMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBoxMenuItem hideDeletedMenuItem;
    private javax.swing.JCheckBoxMenuItem hideObjectIds;
    private javax.swing.JTextField historyObjID;
    private javax.swing.JLabel historyObjTypeLabel;
    private javax.swing.JTable historyTable;
    private javax.swing.JLabel historyTableLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lStatusText;
    private javax.swing.JLabel lUserName;
    private javax.swing.JPanel listViewPanel;
    private javax.swing.JMenuItem loginMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JCheckBoxMenuItem notPrintingMenuItem;
    private javax.swing.JCheckBoxMenuItem onlyDeleted;
    private javax.swing.JCheckBoxMenuItem onlyNeedProofreading;
    private javax.swing.JCheckBoxMenuItem onlyNotForPrint;
    private javax.swing.JCheckBoxMenuItem requiresProofreadingStatusMenuItem;
    private javax.swing.JToolBar statusBar;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
    
    /**
     * returns index of currently selected line in ListView
     * if no line is selected - returns <I>-1</I>
     */
    public int getSelectedLineIndex(){
        int rv =-1,i=0;
        boolean found=false;
        
        for(i=0;i<listViewPanel.getComponentCount();i++){
            if (listViewPanel.getComponent(i).equals(getSelectedLine())){
                found=true;
                break;
            }
        }
        if (found) rv=i;
        return rv;
    }
    private void addWorkItemComponentLine(BikObjType objType) {
        BikWorkItem wicParent = null;
        if (getSelectedLine()==null) return ;
        BikObjType botype = getSelectedLine().getBikDataObject().getObjType();
        if (botype.equals(BikObjType.CATALOG) ||
                botype.equals(BikObjType.SECTION) ||
                botype.equals(BikObjType.COMMENT) ||
                botype.equals(BikObjType.SUBSECTION)) {
            setStatusText("Darba sast�vda�u var pievienot tikai darbam");
            return ;
        }
        
        if (botype.equals(BikObjType.WORK_ITEM)) {
            getSelectedLine().expand();
            wicParent = (BikWorkItem)getSelectedLine().getBikDataObject();
        }
        if (botype.equals(BikObjType.LABOUR) ||
                botype.equals(BikObjType.MATERIAL) ||
                botype.equals(BikObjType.DEPRECIATION) ||
                botype.equals(BikObjType.DEPRECIATION_PERCENT) ) {
            wicParent = ((BikWorkItemComponent)getSelectedLine().getBikDataObject()).getWi();
        }        
        if (wicParent!=null){
            // creating record
            BikWorkItemComponent wic = new BikWorkItemComponent();
            wic.setType(objType.getId());
            wic.setWi(wicParent);
            wicParent.getBikWorkItemComponentCollection().add(wic);
            Session s = getHibernateSession();
            s.beginTransaction();
            s.saveOrUpdate(wic);
            s.saveOrUpdate(wicParent);
            s.getTransaction().commit();
            s.refresh(wic);

            HistoryEvent he = new data.HistoryEvent();
            he.setDate(new Date(System.currentTimeMillis()));
            he.setObjId(wic.getId());
            he.setObjType(wic.getObjType().getId());
            he.setFieldName("");
            he.setMessage("Ieraksts izveidots");
            he.setModifiedBy(getCurrentUser().getFullName());
            he.bikSave();

            WorkItemComponentLine wicline = new WorkItemComponentLine();
            wicline.setBikWorkItemComponent(wic);
            listViewPanel.add(wicline,getSelectedLineIndex()+1);
            listViewPanel.validate();
            wicline.getDefaultFocusComponent().requestFocus();
        }
    }
    private void addCommentLine() {
        if (getSelectedLine()==null) return ;
        data.IBikDataObject parentObj = getSelectedLine().getBikDataObject();
        int insertIndex = getNextWorkItemLineSpot();
        if (insertIndex==-1) {
            setStatusText("Koment�ru nevar pievienot - nevar atrast vietu, kur pievienot");
            return ;
        }
        BikObjType botype = parentObj.getObjType();
        if (botype.equals(BikObjType.SECTION) ||
                botype.equals(BikObjType.SUBSECTION)) {
            // s�kam izveidot rindu
            BikComment bc = new BikComment();
            bc.setParentType(botype.getId());
            bc.setParentId(parentObj.getId());
            if (botype.equals(BikObjType.SECTION)) {
                ((BikSection)parentObj).getBikComments().add(bc);
            }
            else {
                ((BikSubsection)parentObj).getBikComments().add(bc);
            }
            Session s = getHibernateSession();
            s.beginTransaction();
            s.saveOrUpdate(bc);
            s.saveOrUpdate(parentObj);
            s.getTransaction().commit();
            s.refresh(bc);

            HistoryEvent he = new data.HistoryEvent();
            he.setDate(new Date(System.currentTimeMillis()));
            he.setObjId(bc.getId());
            he.setObjType(bc.getObjType().getId());
            he.setFieldName("");
            he.setMessage("Ieraksts izveidots");
            he.setModifiedBy(getCurrentUser().getFullName());
            he.bikSave();
            
            CommentLine cline = new CommentLine();
            cline.setBikComment(bc);
            listViewPanel.add(cline,insertIndex);
            listViewPanel.validate();
            cline.getDefaultFocusComponent().requestFocus();
            

        } else {
            setStatusText("Koment�ru var pievienot tikai noda�ai un sada�ai");
            return ;
        }
    }
    
    private void addWorkItemLine() {
        BikSubsection wiParent = null;
        
        
        
        if (getSelectedLine()==null) return ;
        BikObjType botype = getSelectedLine().getBikDataObject().getObjType();
        if (botype.equals(BikObjType.CATALOG) ||
                botype.equals(BikObjType.COMMENT) ||
                botype.equals(BikObjType.SECTION)) {
            setStatusText("Darbu nevar pievienot katalogam vai noda�ai");
            return ;
        }
        
        if (botype.equals(BikObjType.SUBSECTION)) {
            getSelectedLine().expand();
            wiParent = (BikSubsection)getSelectedLine().getBikDataObject();
        }
        if (botype.equals(BikObjType.WORK_ITEM)) {
            wiParent = ((BikWorkItem)getSelectedLine().getBikDataObject()).getSubsection();
        }
        if (botype.equals(BikObjType.LABOUR) ||
                botype.equals(BikObjType.MATERIAL) ||
                botype.equals(BikObjType.DEPRECIATION) ||
                botype.equals(BikObjType.DEPRECIATION_PERCENT) ) {
            wiParent = ((BikWorkItemComponent)getSelectedLine().getBikDataObject()).getWi().getSubsection();
        }        

        int insertIndex = getNextWorkItemLineSpot();
        if (insertIndex==-1) {
            setStatusText("Darbu nevar pievienot - nevar atrast vietu, kur pievienot");
            return ;
        }

        if (wiParent!=null){
            // creating record
            BikWorkItem wi = new BikWorkItem();
            wi.setSubsection(wiParent);
            wiParent.getBikWorkItemCollection().add(wi);
            Session s = getHibernateSession();
            s.beginTransaction();
            s.saveOrUpdate(wi);
            s.saveOrUpdate(wiParent);
            s.getTransaction().commit();
            s.refresh(wi);

            HistoryEvent he = new data.HistoryEvent();
            he.setDate(new Date(System.currentTimeMillis()));
            he.setObjId(wi.getId());
            he.setObjType(wi.getObjType().getId());
            he.setFieldName("");
            he.setMessage("Ieraksts izveidots");
            he.setModifiedBy(getCurrentUser().getFullName());
            he.bikSave();

            WorkItemLine wiline = new WorkItemLine();
            wiline.setBikWorkItem(wi);
            listViewPanel.add(wiline,insertIndex);
            listViewPanel.validate();
            wiline.getDefaultFocusComponent().requestFocus();
        }
    }

    private void addSubsectionLine() {
        BikSection subsParent = null;
        
        if (getSelectedLine()==null) return ;
        BikObjType botype = getSelectedLine().getBikDataObject().getObjType();
        if (botype.equals(BikObjType.CATALOG) ||
            botype.equals(BikObjType.COMMENT)) {
            setStatusText("Sada�u nevar pievienot katalogam vai koment�ram");
            return ;
        }
        
        if (botype.equals(BikObjType.SECTION)) {
            
            subsParent = (BikSection)getSelectedLine().getBikDataObject();
        }
        if (botype.equals(BikObjType.SUBSECTION)) {
            subsParent = ((BikSubsection)getSelectedLine().getBikDataObject()).getSection();
            getSelectedLine().expand();
        }
        if (botype.equals(BikObjType.WORK_ITEM)) {
            subsParent = ((BikWorkItem)getSelectedLine().getBikDataObject()).getSubsection().getSection();
        }
        if (botype.equals(BikObjType.LABOUR) ||
                botype.equals(BikObjType.MATERIAL) ||
                botype.equals(BikObjType.DEPRECIATION) ||
                botype.equals(BikObjType.DEPRECIATION_PERCENT) ) {
            subsParent = ((BikWorkItemComponent)getSelectedLine().getBikDataObject()).getWi().getSubsection().getSection();
        }        

        int insertIndex = getNextSubsectionLineSpot();
        if (insertIndex==-1) {
            setStatusText("Sada�u nevar pievienot - nevar atrast vietu, kur pievienot");
            return ;
        }

        if (subsParent!=null){
            // creating record
            BikSubsection subs = new BikSubsection();
            subs.setSection(subsParent);
            subsParent.getBikSubsectionCollection().add(subs);
            Session s = getHibernateSession();
            s.beginTransaction();
            s.saveOrUpdate(subs);
            s.saveOrUpdate(subsParent);
            s.getTransaction().commit();
            s.refresh(subs);

            HistoryEvent he = new data.HistoryEvent();
            he.setDate(new Date(System.currentTimeMillis()));
            he.setObjId(subs.getId());
            he.setObjType(subs.getObjType().getId());
            he.setFieldName("");
            he.setMessage("Ieraksts izveidots");
            he.setModifiedBy(getCurrentUser().getFullName());
            he.bikSave();
            
            SubsectionLine subsLine = new SubsectionLine();
            subsLine.setBikSubsection(subs);
            listViewPanel.add(subsLine,insertIndex);
            listViewPanel.validate();
            subsLine.getDefaultFocusComponent().requestFocus();
        }
    }
    
    /**
     * Returns index of next available spot where WorkItem may be insterted in 
     * ListView. 
     * Serach is satrting from currently selected line
     */
    public int getNextWorkItemLineSpot() {
        int startIndex=0, rv =-1;
        IBikItemLine curLine;
        if (getSelectedLineIndex()!=-1) startIndex = getSelectedLineIndex()+1;
        while ( startIndex<listViewPanel.getComponentCount()) {
            curLine = (IBikItemLine)listViewPanel.getComponent(startIndex);
            BikObjType curObjType = curLine.getBikDataObject().getObjType();
            if (curObjType.equals(BikObjType.SUBSECTION)|| 
                    curObjType.equals(BikObjType.WORK_ITEM)||
                    curObjType.equals(BikObjType.SECTION)) {
                rv = startIndex;
                break;
            }
            
            startIndex++;
        }
        return rv;
    }
        /**
     * Returns index of next available spot where Subsection may be insterted in 
     * ListView. 
     * Serach is satrting from currently selected line
     */
    public int getNextSubsectionLineSpot() {
        int startIndex=0, rv =-1;
        IBikItemLine curLine;
        if (getSelectedLineIndex()!=-1) startIndex = getSelectedLineIndex()+1;
        while ( startIndex<listViewPanel.getComponentCount()) {
            curLine = (IBikItemLine)listViewPanel.getComponent(startIndex);
            BikObjType curObjType = curLine.getBikDataObject().getObjType();
            if (curObjType.equals(BikObjType.SUBSECTION)|| 
                    curObjType.equals(BikObjType.SECTION)) {
                rv = startIndex;
                break;
            }
            
            startIndex++;
        }
        return rv;
    }

    public HistoryTableModel getHistoryTableModel() {
        return historyTableModel;
    }
    public void setHistoryTableModel(HistoryTableModel htmVal) {
        this.historyTableModel=htmVal;
    }
    
    public void updateAccessibleCommands(){
        if (getSelectedLine()==null) return;
        deletedStatusMenuItem.setSelected(getSelectedLine().getBikDataObject().isDeleted());
        requiresProofreadingStatusMenuItem.setSelected(getSelectedLine().getBikDataObject().isNeedProofReading());
        notPrintingMenuItem.setSelected(getSelectedLine().getBikDataObject().isNotForPrint());
    }

}
