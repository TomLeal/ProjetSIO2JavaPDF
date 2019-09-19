package com.karimandco.pdf;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * Cette classe hérite de la classe JFileChooser. Elle ajoute quelques modifications.
 * @author t.leal
 */
public class ChoisirDossier extends JFileChooser {
    
    public ChoisirDossier() {
        super();
        setMultiSelectionEnabled(false); //Empeche de sélectionner plusieurs dossiers.
        setFileSelectionMode(DIRECTORIES_ONLY); //Permet d'afficher que les dossiers.
        
    }
}
