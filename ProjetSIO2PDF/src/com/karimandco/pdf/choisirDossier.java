/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.pdf;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author t.leal
 */
public class choisirDossier extends JFileChooser {

    Integer result;
    
    public choisirDossier() {
        super();
        setMultiSelectionEnabled(false);
        setFileSelectionMode(DIRECTORIES_ONLY);
        
    }
    
    
    
}