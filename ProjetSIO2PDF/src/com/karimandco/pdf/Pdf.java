package com.karimandco.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import static com.itextpdf.text.pdf.PdfName.DEST;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classer qui gère le CV.
 *
 * @author l.saupagna
 */
public class Pdf {

    private String nom;
    private String prenom;
    private String numero;
    private String courriel;
    private Date dateDeNaissance;
    private String[] experience;
    private String[] formation;
    private String[] informatique;
    private String[] langues;
    private String[] centreInteret;

    private String lienPDF;

    public Pdf(String nom, String prenom, String numero, String courriel, String lienPDF, Date dateNaissance, String[] experience, String[] formation, String[] informatique, String[] langues, String[] centreInteret) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.courriel = courriel;
        this.dateDeNaissance = dateNaissance;
        this.experience = experience;
        this.formation = formation;
        this.informatique = informatique;
        this.langues = langues;
        this.centreInteret = centreInteret;
        this.lienPDF = lienPDF;
    }

    /**
     * Vérifie si tout est remplie.
     *
     * @return boolean
     */
    public boolean verifPDF() {
        if (nom != "" && prenom != "" && numero != "" && courriel != "" && lienPDF != "" && dateDeNaissance != null && experience.length > 0 && formation.length > 0 && informatique.length > 0 && langues.length > 0 && centreInteret.length > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adapte le lien pour la méthode "genererPDF()". Elle ajoute un deuxieme
     * '\' quand il y en a un.
     *
     * @param lien
     * @return
     */
    private String corrigeLeLien(String lien) {
        char[] ancielLien = lien.toCharArray();
        String lienResult = "";
        for (int i = 0; i < ancielLien.length; i++) {
            if (ancielLien[i] == '\\') {
                lienResult = lienResult + "\\\\";
            } else {
                lienResult = lienResult + ancielLien[i];
            }
        }
        lienResult = lienResult + "\\\\cv.pdf";
        System.out.println(lienResult);
        return lienResult;
    }

    /**
     * Adapte la date pour la méthode "genererPDF()".
     * Si une valeur est inférieur à 10, on met un 0 avant le chiffre.
     * @param date
     * @return String
     */
    private String corrigeLaDate(Date date) {
        String result="";
        if (this.dateDeNaissance.getDay() < 10 && this.dateDeNaissance.getMonth() >= 10) {
            result="0"+date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
        } else if (this.dateDeNaissance.getDay() >= 10 && this.dateDeNaissance.getMonth() < 10) {
            result=date.getDay() + "/0" + date.getMonth() + "/" + date.getYear();
        } else if (this.dateDeNaissance.getDay() < 10 && this.dateDeNaissance.getMonth() < 10) {
            result="0"+date.getDay() + "/0" + date.getMonth() + "/" + date.getYear();
        } else {
            result="0"+date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
        }
        return result;
    }

    /**
     * Crée le CV dans la destination précisé dans "lienPDF" au format PDF.
     */
    public void genererPDF() throws FileNotFoundException, BadElementException, IOException {
        try {
            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            Image image;
            String url = "https://kodejava.org/wp-content/uploads/2017/01/kodejava.png";
            image = Image.getInstance(url);

            lienPDF = corrigeLeLien(lienPDF);
            System.out.println(lienPDF);
            PdfWriter.getInstance(document, new FileOutputStream(lienPDF));
            System.out.println("OK");
            document.open();
            float[] columnWidths = {2, 4};
            PdfPTable Table = new PdfPTable(columnWidths);
            Table.setWidthPercentage(100);
            Table.setSpacingBefore(0f);
            Table.setSpacingAfter(0f);

            /**
             * Travail dans la Premier Cellulue de la table
             */
            PdfPCell C1 = new PdfPCell(new Phrase("Image"));
            C1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            C1.setFixedHeight(840);

            Paragraph para1 = new Paragraph("");
            para1.add(new Paragraph("Personnelles"));
            para1.add(new Paragraph(" "));
            para1.add(new Paragraph(" "));
            para1.add(new Paragraph("Nom :"));
            para1.add(new Paragraph(nom));
            para1.add(new Paragraph(" "));
            para1.add(new Paragraph("Prenom :"));
            para1.add(new Paragraph(prenom));
            para1.add(new Paragraph(" "));
            para1.add(new Paragraph("Adresse :"));
            para1.add(new Paragraph(""));
            para1.add(new Paragraph(" "));
            para1.add(new Paragraph("Date Naissance :"));
            para1.add(new Paragraph(corrigeLaDate(dateDeNaissance)));
            para1.add(new Paragraph(" "));
            para1.add(new Paragraph("Numero :"));
            para1.add(new Paragraph(numero));
            para1.add(new Paragraph(" "));
            C1.addElement(image);
            C1.addElement(para1);
            C1.setBorderColor(BaseColor.WHITE);
            Table.addCell(C1);

            //Travail dans la Seconde Cellulue de la table
            PdfPTable Table2 = new PdfPTable(1);
            Table2.setWidthPercentage(100);
            Table2.setSpacingBefore(0f);
            Table2.setSpacingAfter(0f);
            PdfPCell C2 = new PdfPCell(new Phrase(""));
            Table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            Paragraph Titre = new Paragraph("Titre");
            C2.addElement(Titre);
            Table2.addCell(C2);
            Paragraph espace = new Paragraph("  ");
            espace.add(new Paragraph("   "));
            C2.addElement(espace);
            Table2.addCell(C2);
            Paragraph Formation = new Paragraph("FORMATIONS :");
            for (int i = 0; i < formation.length; i++) {
                Formation.add(new Paragraph(formation[i]));
            }
            C2.addElement(Formation);
            //
            Table2.addCell(C2);
            C2.addElement(espace);
            Table2.addCell(C2);
            Paragraph expepro = new Paragraph("EXPERIENCES PROFESSIONELLES :");
            for (int i = 0; i < experience.length; i++) {
                expepro.add(new Paragraph(experience[i]));
            }
            C2.addElement(expepro);
            //
            Table2.addCell(C2);
            C2.addElement(espace);
            Table2.addCell(C2);
            Paragraph info = new Paragraph("INFORMATIQUE :");
            for (int i = 0; i < informatique.length; i++) {
                info.add(new Paragraph(informatique[i]));
            }
            C2.addElement(info);
            Table2.addCell(C2);
            C2.addElement(espace);
            Paragraph lang = new Paragraph("LANGUES :");
            for (int i = 0; i < langues.length; i++) {
                lang.add(new Paragraph(langues[i]));
            }
            C2.addElement(lang);
            Table2.addCell(C2);
            C2.addElement(espace);
            Paragraph cI = new Paragraph("CENTRES D'INTERÊT :");
            for (int i = 0; i < centreInteret.length; i++) {
                cI.add(new Paragraph(centreInteret[i]));
            }
            C2.addElement(cI);
            Table.addCell(C2);

//            Table.setHeaderRows(1);
//            C1 = new PdfPCell(new Phrase("B1"));
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            C1 = new PdfPCell(new Phrase("B2"));
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            Table.setHeaderRows(1);
//            
//            
//            C1 = new PdfPCell(new Phrase("C1"));
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            C1 = new PdfPCell(new Phrase("C2"));
//            C1.setBorderColor(BaseColor.WHITE);
//            
//            Table.addCell(C1);
//            C1 = new PdfPCell(new Phrase("D1"));
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            C1 = new PdfPCell(new Phrase("d2"));
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            C1 = new PdfPCell(new Phrase("F1"));
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            C1 = new PdfPCell(new Phrase("f2"));
//           
//            
//            C1.setBorderColor(BaseColor.WHITE);
//            Table.addCell(C1);
//            C1.setBorderColor(BaseColor.WHITE);
            document.add(Table);

//            Paragraph para = new Paragraph("Test");
//            document.add(para);
            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
