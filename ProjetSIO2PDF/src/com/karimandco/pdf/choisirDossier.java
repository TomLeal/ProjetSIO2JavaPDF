package com.karimandco.pdf;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * Ce composant hérite de JFileChooser et il permet d'afficher uniquement les dossiers et désactive la sélection multiple.
 * @author t.leal
 */
public class choisirDossier extends JFileChooser {
    
    public choisirDossier() {
        super();
        setMultiSelectionEnabled(false);
        setFileSelectionMode(DIRECTORIES_ONLY);
    }
}
