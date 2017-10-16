/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clas.detectors;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author devita
 */
public class Contact  extends JTabbedPane {        
    JPanel monitoringPanel =  new JPanel(new BorderLayout());
    JPanel calibrationPanel = new JPanel(new BorderLayout());
    
    public Contact() {
        this.add("Monitoring Contacts", this.monitoringPanel);
        this.add("Calibration Contacts", this.calibrationPanel);
        JTextPane monitoringContacts = new JTextPane();
        monitoringContacts.setText("\nContact for the online monitoring:\n\n"
                + "Stefan Diehl,  sdiehl@jlab.org\n\n"
                + "Contact persons for the expert monitoring:\n\n"
                + "CND:    xx xx  xx@jlab.org\n"
                + "CTOF:   xx xx  xx@jlab.org\n"
                + "DC:     xx xx  xx@jlab.org\n"
                + "EC:   Cole Smith, lcsmith@jlab.org\n"
                + "FTOF:   xx xx  xx@jlab.org\n"
                + "FTTRK:  xx xx  xx@jlab.org\n"
                + "FTHODO: xx xx  xx@jlab.org\n"
                + "FTCAL:  xx xx  xx@jlab.org\n"
                + "HTTC:   xx xx  xx@jlab.org\n"
                + "LTTC:   xx xx  xx@jlab.org\n"
                + "MVT:    xx xx  xx@jlab.org\n"
                + "SVT:    xx xx  xx@jlab.org");
        this.monitoringPanel.add(monitoringContacts,BorderLayout.CENTER);
        monitoringContacts.setFont(new Font("Avenir",Font.PLAIN,20));
        monitoringContacts.setEditable(false);
        JTextPane calibrationContacts = new JTextPane();
        calibrationContacts.setText("\nCalibration coordinators:\n\n"
                + "xx xx  xx@jlab.org\n\n"
                + "Contact persons for the calibration of the subsystems:\n\n"
                + "CND:    xx xx  xx@jlab.org\n"
                + "CTOF:   xx xx  xx@jlab.org\n"
                + "DC:     xx xx  xx@jlab.org\n"
                + "EC:     xx xx, xx@jlab.org\n"
                + "FTOF:   xx xx  xx@jlab.org\n"
                + "FTTRK:  xx xx  xx@jlab.org\n"
                + "FTHODO: xx xx  xx@jlab.org\n"
                + "FTCAL:  xx xx  xx@jlab.org\n"
                + "HTTC:   xx xx  xx@jlab.org\n"
                + "LTTC:   xx xx  xx@jlab.org\n"
                + "MVT:    xx xx  xx@jlab.org\n"
                + "SVT:    xx xx  xx@jlab.org");
        this.calibrationPanel.add(calibrationContacts,BorderLayout.CENTER);
        calibrationContacts.setFont(new Font("Avenir",Font.PLAIN,20));
        calibrationContacts.setEditable(false);
    }
      
}
