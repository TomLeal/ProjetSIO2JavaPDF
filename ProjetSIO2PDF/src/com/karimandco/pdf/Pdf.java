/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.saupagna
 */
public class Pdf {

    String nom;
    String prenom;
    String numero;
    
    String lienPDF;

    public Pdf(String nom, String prenom, String numero, String lienPDF) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.lienPDF = lienPDF;
    }
    
    public boolean verifPDF(){
        if (nom!="" && prenom!="" && numero!="" && lienPDF!="") {
            return true;
        } else {
            return false;
        }
    }
    
    public String corrigeLeLien(String lien){
        char[] ancielLien=lien.toCharArray();
        String lienResult="";
        for (int i = 0; i < ancielLien.length; i++) {
            if (ancielLien[i]=='\\') {
                lienResult = lienResult + "\\\\";
            } else {
                lienResult = lienResult + ancielLien[i];
            }
        }
        lienResult=lienResult+"\\\\cv.pdf";
        System.out.println(lienResult);
        return lienResult;
    }
    
    public void genererPDF() throws FileNotFoundException, BadElementException, IOException{
        try {
            Document document = new Document();
            Image image;
            String url = "https://kodejava.org/wp-content/uploads/2017/01/kodejava.png";
            image = Image.getInstance(url);
            
            lienPDF = corrigeLeLien(lienPDF);
            System.out.println(lienPDF);
            PdfWriter.getInstance(document, new FileOutputStream(lienPDF));
            System.out.println("OK");
            document.open();
            
            PdfPTable Table = new PdfPTable(2);
            PdfPCell C1 = new PdfPCell(new Phrase("Image"));
            C1.addElement(image);
            C1.setBorderColor(BaseColor.WHITE);
            Table.addCell(C1);
            C1 = new PdfPCell(new Phrase(""));
            C1.setBorderColor(BaseColor.WHITE);
            Paragraph para1 = new Paragraph("");
            para1.add(new Paragraph(nom));
            para1.add(new Paragraph(prenom));
            para1.add(new Paragraph("Adresse"));
            para1.add(new Paragraph("Date Naissance"));
            para1.add(new Paragraph(numero));
            C1.addElement(para1);
            Table.addCell(C1);
//            Table.setHeaderRows(1);
//
            PdfPTable espace1 = new PdfPTable(1);
            PdfPCell C6 = new PdfPCell(new Phrase(" "));
            C6.setBorderColor(BaseColor.WHITE);
            espace1.addCell(C6);

            PdfPTable Table2 = new PdfPTable(1);
            PdfPCell C2 = new PdfPCell(new Phrase("FORMATIONS"));
            C2.setBorderColor(BaseColor.WHITE);
            Table2.addCell(C2);
//:              Table.setHeaderRows(1);
            
                
                PdfPTable Table3 = new PdfPTable(1);
            PdfPCell C3 = new PdfPCell(new Phrase("BTS SIO jean lurcat 2018/2020"));
            C3.setBorderColor(BaseColor.WHITE);
            Table3.addCell(C3);
            
            PdfPTable espace2 = new PdfPTable(1);
            PdfPCell C7 = new PdfPCell(new Phrase(" "));
            C7.setBorderColor(BaseColor.WHITE);
            espace2.addCell(C7);
            
            PdfPTable Table4 = new PdfPTable(1);
            PdfPCell C4 = new PdfPCell(new Phrase("EXPERIENCES PROFESSIONELLES"));
            C4.setBorderColor(BaseColor.WHITE);
            Table4.addCell(C4);
            //                Table.setHeaderRows(1);
                
             PdfPTable Table5 = new PdfPTable(1);
            PdfPCell C5 = new PdfPCell(new Phrase("Stage de bts chez Android"));
            C5.setBorderColor(BaseColor.WHITE);
            Table5.addCell(C5);

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
            document.add(espace1);
            document.add(Table2);
            document.add(Table3);
            document.add(espace2);
            document.add(Table4);
            document.add(Table5);

//            Paragraph para = new Paragraph("Test");
//            document.add(para);
            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String file_name = "P:\\Nouveau dossier\\test.pdf";
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            PdfPTable Table = new PdfPTable(2);
            PdfPCell C1 = new PdfPCell(new Phrase("Image"));

            C1.setBorderColor(BaseColor.WHITE);
            Table.addCell(C1);
            C1 = new PdfPCell(new Phrase(""));
            C1.setBorderColor(BaseColor.WHITE);
            Paragraph para1 = new Paragraph("");
            para1.add(new Paragraph("Nom"));
            para1.add(new Paragraph("Prénom"));
            para1.add(new Paragraph("Adresse"));
            para1.add(new Paragraph("Date Naissance"));
            para1.add(new Paragraph("Numéro"));
            C1.addElement(para1);
            Table.addCell(C1);
//            Table.setHeaderRows(1);
//
            PdfPTable espace1 = new PdfPTable(1);
            PdfPCell C6 = new PdfPCell(new Phrase(" "));
            C6.setBorderColor(BaseColor.WHITE);
            espace1.addCell(C6);

            PdfPTable Table2 = new PdfPTable(1);
            PdfPCell C2 = new PdfPCell(new Phrase("FORMATIONS"));
            C2.setBorderColor(BaseColor.WHITE);
            Table2.addCell(C2);
//:              Table.setHeaderRows(1);
            
                
                PdfPTable Table3 = new PdfPTable(1);
            PdfPCell C3 = new PdfPCell(new Phrase("BTS SIO jean lurcat 2018/2020"));
            C3.setBorderColor(BaseColor.WHITE);
            Table3.addCell(C3);
            
            PdfPTable espace2 = new PdfPTable(1);
            PdfPCell C7 = new PdfPCell(new Phrase(" "));
            C7.setBorderColor(BaseColor.WHITE);
            espace2.addCell(C7);
            
            PdfPTable Table4 = new PdfPTable(1);
            PdfPCell C4 = new PdfPCell(new Phrase("EXPERIENCES PROFESSIONELLES"));
            C4.setBorderColor(BaseColor.WHITE);
            Table4.addCell(C4);
            //                Table.setHeaderRows(1);
                
             PdfPTable Table5 = new PdfPTable(1);
            PdfPCell C5 = new PdfPCell(new Phrase("Stage de bts chez Android"));
            C5.setBorderColor(BaseColor.WHITE);
            Table5.addCell(C5);

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
            document.add(espace1);
            document.add(Table2);
            document.add(Table3);
            document.add(espace2);
            document.add(Table4);
            document.add(Table5);

//            Paragraph para = new Paragraph("Test");
//            document.add(para);
            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
