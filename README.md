# KarimAndCo - Composant JAVA PDF

*Projet de BTS SIO seconde année.*

Ce composant sert à créer un CV et l'enregistrer au format PDF en récupérant les informations 

## Installation

Vous devez avoir ces librairies : [Cliquez ici](https://drive.google.com/drive/folders/1SffbFEgjzfLVLia0XcM6A5xaVZoLIS67?usp=sharing)

### Application Java

Avec Netbeans.

* Téléchargez le composant.
* Intégrez le package "com.karimandco.pdf dans votre projet.
* Ajoutez le fichier "VoirPdf.java" dans votre pallete (*clique droit --> tools --> add to palette*) si vous voulez le mettre dans votre fenêtre.

### Maven

Avec Netbeans.

* Télécharger le composant.
* Clique droit sur “Dependencies” puis “Add dependencies”
* Cherchez les librairies “itextpdf 5.5.13.1” et "acrobat", vous trouverez “com.itextpdf : itextpdf” et "com.adobe.acrobat : acrobat".
* Prenez la version 5.5.13.1 pour itext et la version 1.1 pour acrobat.
* Intégrez le package "com.karimandco.pdf dans votre projet.
* Ajoutez le fichier "VoirPdf.java" dans votre pallete (*clique droit --> tools --> add to palette*) si vous voulez le mettre dans votre fenêtre.

### Configuration

* Entrer les informations de votre base de données dans la classe "DaoSIO".
* Ajouter un Utilisateur avec la méthode setUtil(Utilisateur) de la classe PDF.

## Documents

* [Documentation](https://docs.google.com/document/d/119Ruata1XwvecIp7XuenZ_cP0t_y3ueiwdJiSaINICg/edit?usp=sharing)
