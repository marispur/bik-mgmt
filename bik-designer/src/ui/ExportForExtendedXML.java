/*
 * ExportForBasicXML.java
 *
 * Created on sv�tdiena, 2007, 2 septembris, 14:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ui;

import data.BikCatalog;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;

/**
 *
 * @author Maris
 */
public class ExportForExtendedXML {
    
    private MainWindow mv;
    private Integer sq;
    
    class ExportExtendedXMLTask extends SwingWorker<Void, Void> {
        
        private ProgressMonitor pm;
        private BikCatalog cat;
        private PrintWriter target;
        private Integer sq;
        
        public ExportExtendedXMLTask(ProgressMonitor pmval, BikCatalog catval, PrintWriter targetval, Integer sqval) {
            pm=pmval;
            cat=catval;
            target=targetval;
            sq=sqval;
        }
        
        @Override
        public Void doInBackground() {
            pm.setMillisToDecideToPopup(0);
            pm.setMillisToPopup(0);
            sq = cat.exportToFileForExtendedXML(target, pm, sq);
            target.flush();
            target.close();
            return null;
        }
        
        @Override
        public void done() {
            pm.close();
        }
    }

    
    /** Creates a new instance of ExportForBasicXML */
    public ExportForExtendedXML(MainWindow mvval, BikCatalog catval, Integer sqval) {
        mv = mvval;
        sq = sqval;
        
        JFileChooser fc = new JFileChooser("Desktop");
        mv.setStatusText("Izv�lieties failu, kur� eksport�t datus eBIK XML(papla�in�t� versija)...");
        int returnVal = fc.showSaveDialog(mv);
        if (returnVal == JFileChooser.APPROVE_OPTION ) {
            PrintWriter target;
            ProgressMonitor pmon = new ProgressMonitor(mv,"Eksport�ju papla�in�tos datus eBIKam...","S�ku eksportu",0,1);
            try {
                target = new PrintWriter(fc.getSelectedFile(),"UTF-8");
                mv.setStatusText("S�ku eksport�t datus fail� " +fc.getSelectedFile().getPath() + "...");
                ExportExtendedXMLTask t = new ExportExtendedXMLTask(pmon, catval, target, sq);
                t.execute(); 
                
                mv.setStatusText("Exports veiksm�gi pabeigts fail� " +fc.getSelectedFile().getPath());
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    
}
