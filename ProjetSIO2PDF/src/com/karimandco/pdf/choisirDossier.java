package com.karimandco.pdf;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * Version modifiée du composant JFileChooser.
 * Ce composant permet d'afficher uniquement les dossiers et désactive la sélection multiple.
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
