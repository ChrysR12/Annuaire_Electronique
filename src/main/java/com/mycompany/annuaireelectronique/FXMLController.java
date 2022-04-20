package com.mycompany.annuaireelectronique;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SortEvent;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class FXMLController implements Initializable {
    ClassAction traitement = new ClassAction();
    private Label label;
    @FXML
    private TextField TfRentree;
    @FXML
    private TextField TfLocalisation;
    @FXML
    private TextField TfFormations;
    @FXML
    private TextField TfNom;
    @FXML
    private TextField TfPrenom;
    @FXML
    private TextField TfRecherche;
    @FXML
    private Button Btrecherche;
    @FXML
    private Button BtAjouter;
    @FXML
    private Button BtSupprimer;
    @FXML
    private TableView<Personne> tableView;
    @FXML
    private TableColumn<Personne, String> TcDate;
    @FXML
    private TableColumn<Personne, String> TcLocalisation;
    @FXML
    private TableColumn<Personne, String> TcFormation;
    @FXML
    private TableColumn<Personne, String> TcSecteur;
    @FXML
    private TableColumn<Personne, String> TcGenre;
    @FXML
    private TableColumn<Personne, String> TcNom;
    @FXML
    private TableColumn<Personne, String> TcPrenom;
    @FXML
    private Button BtLogout;
    @FXML
    private Label LabelGenre;
    @FXML
    private RadioButton RadioButtonFeminin;
    @FXML
    private RadioButton RadioButtonMasculin;
    @FXML
    private Label LabelEtablissement;
    @FXML
    private RadioButton RadioButtonPublic;
    @FXML
    private RadioButton RadioButtonPrive;
    @FXML
    private Button BtModifier;
    @FXML
    private Button BtAnnulerRaz;
    @FXML
    private TextField TfLogin;
    @FXML
    private PasswordField PfPassword;
@FXML
    private Button BtConnexion;
    @FXML
    private Button BtAnnuler;
    @FXML
    private AnchorPane connexionAdmin;
    @FXML
    private AnchorPane commandeAdmin;
    @FXML
    private Button btconnexAdm;
    @FXML
    private Button revenirUtilisateur;
    @FXML
    private TextArea aPropos;
    @FXML
    private VBox lesBtDroite;
    @FXML
    private Button btStatisque;
    @FXML
    private Button btAPropos;
    @FXML
    private Button revenir;
    private ScrollBar Scrol;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private Label lbAfficheurMode;
    @FXML
    private ImageView ivchecked;
    @FXML
    private ImageView ivFail;
    @FXML
    private BarChart<?, ?> localStat;
    @FXML
    private NumberAxis statLocalNbEtudiant;
    @FXML
    private CategoryAxis statLocalLieu;
    @FXML
    private LineChart<String, Number> statEnBas;
    @FXML
    private Button btStatbas;
    @FXML
    private ImageView imgSuppr;
    @FXML
    private ImageView imgAnnulé;
    @FXML
    private ImageView imgRecherche;
    @FXML
    private ImageView notFound;
    @FXML
    private Label labelnbEtudiant;
    String file = "src/main/resources/bd/donnees16le.txt";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//          ==============================STYLE=============================
                 if(revenirUtilisateur.isVisible() || BtLogout.isVisible() ){
            btStatbas.setVisible(true);
        }else{ if(btStatisque.isVisible())
            { btStatbas.setVisible(false);
        } 
      }

        connexionAdmin.setVisible(false);
        commandeAdmin.setVisible(false);
        revenirUtilisateur.setVisible(false);
        aPropos.setVisible(false);
        revenir.setVisible(false);
        lbAfficheurMode.setText("MODE UTILISATEUR"); 
        ivchecked.setVisible(false);
        ivFail.setVisible(false);
        localStat.setVisible(false);
        statEnBas.setVisible(false);
        btStatbas.setVisible(false);
        imgSuppr.setVisible(false);
        imgRecherche.setVisible(false);
        notFound.setVisible(false);
        imgAnnulé.setVisible(false);

//============================= BACK END=========================
traitement.affichage(tableView, TcDate, TcLocalisation, TcFormation, TcSecteur, TcGenre, TcNom, TcPrenom);
//============================STATISTIQUE======================
XYChart.Series set1 = new XYChart.Series<>();
set1.getData().add(new  XYChart.Data("Autres écoles de spécialités diverses",2 ));
set1.getData().add(new  XYChart.Data("Autres formations d'ingénieurs",5 ));
set1.getData().add(new  XYChart.Data("Classes préparatoires aux grandes écoles (CPGE)",1 ));
set1.getData().add(new  XYChart.Data("Ecoles de commerce, gestion et comptabilité",2 ));
set1.getData().add(new  XYChart.Data("Écoles juridiques et administratives",2 ));
set1.getData().add(new  XYChart.Data("Écoles normales supérieures (ENS)",2 ));
set1.getData().add(new  XYChart.Data("Écoles paramédicales et sociales",2 ));
set1.getData().add(new  XYChart.Data("Écoles supérieures art et culture",2 ));
set1.getData().add(new  XYChart.Data("Etablissements d'enseignement universitaire privés",2 ));
set1.getData().add(new  XYChart.Data("Instituts nationaux polytechniques (INP)",2 ));
set1.getData().add(new  XYChart.Data("Sections de techniciens supérieurs (STS) et assimilés",2 ));
set1.getData().add(new  XYChart.Data("Total des formations d'enseignement supérieur",2 ));
set1.getData().add(new  XYChart.Data("Universités",2 ));
set1.getData().add(new  XYChart.Data("Universités de technologie (UT)",2 ));
localStat.getData().addAll(set1);

XYChart.Series<String,Number> series = new XYChart.Series<>();
series.getData().add(new XYChart.Data<String,Number>("Autre école",2 ));
series.getData().add(new XYChart.Data<String,Number>("Autre formation",5 ));
series.getData().add(new XYChart.Data<String,Number>("CPGE",1 ));
series.getData().add(new XYChart.Data<String,Number>("ECGC",2 ));
series.getData().add(new XYChart.Data<String,Number>("EJA",2 ));
series.getData().add(new XYChart.Data<String,Number>("EPS",2 ));
series.getData().add(new XYChart.Data<String,Number>("ESC",2 ));
series.getData().add(new XYChart.Data<String,Number>("EEUP",2 ));
series.getData().add(new XYChart.Data<String,Number>("INP",2 ));
series.getData().add(new XYChart.Data<String,Number>("STS",2 ));
series.getData().add(new XYChart.Data<String,Number>("TFES",2 ));
series.getData().add(new XYChart.Data<String,Number>("Universités",2 ));
series.getData().add(new XYChart.Data<String,Number>("UT",2 ));
statEnBas.getData().add(series);
    }    
    
    @FXML
    private void BtrechercheAction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String aChercher = TfRecherche.getText();
        SortedMap<Integer,String> map=new TreeMap<Integer,String>();    
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-16LE"));
        //    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             String curLine;
            int idPers = 0;
            int i=0;
            ArrayList indexList = new ArrayList();
        while ((curLine = bufferedReader.readLine()) != null) {
                map.put(i,curLine);
               
                if(curLine.toLowerCase().contains(aChercher.toLowerCase())){
                 indexList.add(i);
                }
                i++;

        }
        System.out.println(map);
        System.out.println(indexList);
        traitement.affichageRecherche(indexList, tableView, TcDate, TcFormation, TcLocalisation, TcSecteur, TcGenre, TcNom, TcPrenom);
        if (indexList.size()>0){
            imgRecherche.setVisible(true);
                 FadeTransition rech = new FadeTransition(Duration.millis(7000), imgRecherche);
rech.setFromValue(1.0);
rech.setToValue(0.0);
rech.playFromStart();
        } else { notFound.setVisible(true);
               FadeTransition notFoun = new FadeTransition(Duration.millis(7000), notFound);
notFoun.setFromValue(1.0);
notFoun.setToValue(0.0);
notFoun.playFromStart();
     
        }

    }

    @FXML
    private void BtAjouterAction(ActionEvent event) throws IOException {
                String genre = bRadioGenre();
        String secteur = bRadioSecteur();
        if(TfRentree.getText().isEmpty()
                ||TfLocalisation.getText().isEmpty()
                ||TfFormations.getText().isEmpty()
                ||secteur.equals(null)
                ||genre.equals(null)
                ||TfNom.getText().isEmpty()){
                Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information");
alert.setHeaderText(null);
alert.setContentText("Veuillez remplir tout les champs!!!");
alert.showAndWait();
        }else{
            if(TfPrenom.getText().isEmpty()){
                TfPrenom.setText(" ");
            }
        String newLineContent = TfRentree.getText()+"\t"+ TfLocalisation.getText()+"\t"+ TfFormations.getText()+"\t"+ secteur+"\t"+ genre+"\t"+ TfNom.getText()+"\t"+ TfPrenom.getText();

        Path filePath = Paths.get(file);
        Files.write(filePath,(newLineContent+System.lineSeparator()).getBytes(UTF_16LE),StandardOpenOption.APPEND);
        
        traitement.affichage(tableView, TcDate, TcLocalisation, TcFormation, TcSecteur, TcGenre, TcNom, TcPrenom);
            
        raz();
        ivchecked.setVisible(true);
 FadeTransition checked = new FadeTransition(Duration.millis(5000), ivchecked);
checked.setFromValue(1.0);
checked.setToValue(0.0);
checked.playFromStart();
        }
        
    }
@FXML
      private void BtSupprimerAction(ActionEvent event) throws IOException {
          Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText(null);
alert.setContentText("Voulez-vous vraiment supprimer "+ "\n"+ TcNom.getCellData(tableView.getSelectionModel().getFocusedIndex())+ " "+TcPrenom.getCellData(tableView.getSelectionModel().getFocusedIndex()));
   Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    SortedMap<Integer,String> map=new TreeMap<Integer,String>();    
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-16LE"));
             String curLine;
            int idPers = 0;
            int i=0;
        while ((curLine = bufferedReader.readLine()) != null) {
                map.put(i,curLine);
                i++;
}
        for(i=0; i<=map.lastKey();i++){
            System.out.println(i+"   ----->   "+map.get(i));
        }
        System.out.println(map);
        System.out.println(map.size());
        Object elementSuppr = map.remove(tableView.getSelectionModel().getFocusedIndex()+1);
         System.out.println("apres suppression");
         System.out.println(map);
        System.out.println(map.size());
        bufferedReader.close();
        
        File suppr = new File(file);

         File treeMap = new File(file);
        FileWriter f = new FileWriter(treeMap , true);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-16LE"));
        
                PrintWriter p = new PrintWriter(bufferedWriter);
                for (Map.Entry<Integer,String>entry: map.entrySet()){
                    p.write(entry.getValue()+"\n");
                   
                }
                p.flush();
                p.close(); 
                
            imgSuppr.setVisible(true);
                 FadeTransition supprm = new FadeTransition(Duration.millis(5000), imgSuppr);
supprm.setFromValue(1.0);
supprm.setToValue(0.0);
supprm.playFromStart();
                             
       traitement.affichage(tableView, TcGenre, TcLocalisation, TcSecteur, TcSecteur, TcGenre, TcNom, TcPrenom);
       raz();
} else {
               
       traitement.affichage(tableView, TcGenre, TcLocalisation, TcSecteur, TcSecteur, TcGenre, TcNom, TcPrenom);
       raz();
}
        
   
    }

    @FXML
     private void BtModifierAction(ActionEvent event) throws FileNotFoundException, IOException {
         Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Confirmation Modification");
alert.setHeaderText(null);
alert.setContentText("Voulez-vous vraiment Modifier "+ "\n"+ TcNom.getCellData(tableView.getSelectionModel().getFocusedIndex())+" "+TcPrenom.getCellData(tableView.getSelectionModel().getFocusedIndex())+"?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    SortedMap<Integer,String> map=new TreeMap<Integer,String>();    

            int lineToBeChange = (tableView.getSelectionModel().getFocusedIndex()+1);
            String genre = bRadioGenre();
        String secteur = bRadioSecteur();
            
            String newLineContent = TfRentree.getText()+"\t"+ TfLocalisation.getText()+"\t"+ TfFormations.getText()+"\t"+ secteur+"\t"+ genre+"\t"+ TfNom.getText()+"\t"+ TfPrenom.getText();

           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-16LE"));
             String curLine;
            int i=0;
        while ((curLine = bufferedReader.readLine()) != null) {
                map.put(i,curLine);
                i++;
}

        System.out.println(map);
        System.out.println(map.size());
        Object elementModif = map.replace(lineToBeChange,newLineContent);
         System.out.println("apres suppression");
         System.out.println(map);
        System.out.println(map.size());
        bufferedReader.close();
        
        File suppr = new File(file);
        if(suppr.delete()==true){
            System.out.println("le fichier a été supprimé");
        }else{
                 System.out.println("echec de la suppression fichier");   
                    }
        File treeMap = new File(file);
        FileWriter f = new FileWriter(treeMap , true);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-16LE"));
                PrintWriter p = new PrintWriter(bufferedWriter);
                for (Map.Entry<Integer,String>entry: map.entrySet()){
                    p.write(entry.getValue()+"\n");
                   
                }
                p.flush();
                p.close(); 
                
                   ivchecked.setVisible(true);
 FadeTransition checked = new FadeTransition(Duration.millis(5000), ivchecked);
checked.setFromValue(1.0);
checked.setToValue(0.0);
checked.playFromStart();
        

            traitement.affichage(tableView, TcDate, TcLocalisation, TcFormation, TcSecteur, TcGenre, TcNom, TcPrenom);
            raz();
} else {
     traitement.affichage(tableView, TcDate, TcLocalisation, TcFormation, TcSecteur, TcGenre, TcNom, TcPrenom);
            raz();
}
        
    }

    @FXML
    private void BtAnnulerRazAction(ActionEvent event) {
        raz();
                imgAnnulé.setVisible(true);
 FadeTransition annul = new FadeTransition(Duration.millis(5000), imgAnnulé);
annul.setFromValue(1.0);
annul.setToValue(0.0);
annul.playFromStart();

    }


    @FXML
    private void BtConnexionAction(ActionEvent event) {
        if (TfLogin.getText().equals("Admin") && PfPassword.getText().equals("123456"))
        { connexionAdmin.setVisible(false);
        commandeAdmin.setVisible(true);
        revenirUtilisateur.setVisible(false);
      anchorPrincipal.setId("bgAdmin");
      Btrecherche.setId("bgAdmin");
      BtAjouter.setId("bgAdmin");
      BtSupprimer.setId("bgAdmin");
      BtLogout.setId("bgAdmin");
      BtAnnulerRaz.setId("bgAdmin");
      btStatisque.setId("bgAdmin");
      revenir.setId("bgAdmin");        
      btAPropos.setId("bgAdmin");
      BtModifier.setId("bgAdmin");      
      btStatbas.setId("bgAdmin");
            lbAfficheurMode.setText("MODE ADMNISTRATEUR");        
            
      
        }
        else {
            Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information");
alert.setHeaderText(null);
alert.setContentText("votre login ou votre mot de passe est incorrect, veuillez rectifier!");
alert.showAndWait();
         }
       }

    @FXML
    private void BtAnnulerAction(ActionEvent event) {
        TranslateTransition slide = new TranslateTransition ();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(tableView);
        slide.setToX(9.0);
        slide.play();
        connexionAdmin.setVisible(false);
        btconnexAdm.setVisible(true);
        revenirUtilisateur.setVisible(false);
        lesBtDroite.setVisible(true);
        btStatbas.setVisible(false);
        statEnBas.setVisible(false);
        btStatisque.setVisible(true);
        revenir.setVisible(false);
        lesBtDroite.setLayoutX(1506);       
        lesBtDroite.setLayoutY(354);
        revenir.setLayoutX(1543);
        revenir.setLayoutY(769);
        aPropos.setLayoutX(1385);
        aPropos.setLayoutY(158);  
        aPropos.setPrefWidth(396);
       aPropos.setPrefHeight(548);
    }

    @FXML
    private void btconnexAdmAction(ActionEvent event) {
        TranslateTransition slide = new TranslateTransition ();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(tableView);
        slide.setToX(404);
        slide.setByX(1343);
        slide.play();
        connexionAdmin.setVisible(true);
        btconnexAdm.setVisible(false);
        revenirUtilisateur.setVisible(true);
         aPropos.setVisible(false);
         revenir.setVisible(false);
         localStat.setVisible(false);
         btStatisque.setVisible(false);
         btStatbas.setVisible(true);
         btAPropos.setVisible(true);
        lesBtDroite.setLayoutX(887);       
        lesBtDroite.setLayoutY(840);
        revenir.setLayoutX(1070);
        revenir.setLayoutY(887);
        aPropos.setLayoutX(640);
        aPropos.setLayoutY(829);
       aPropos.setPrefWidth(420 );
       aPropos.setPrefHeight(150);
       
//        ========================STATISQUE=============
    }
    
//    942 834

    @FXML
    private void revenirUtilisateurAction(ActionEvent event) {
         TranslateTransition slide = new TranslateTransition ();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(tableView);
        slide.setToX(9.0);
        slide.play();
        connexionAdmin.setVisible(false);
        btconnexAdm.setVisible(true);
        revenirUtilisateur.setVisible(false);
         lesBtDroite.setVisible(true);
         btStatisque.setVisible(true);
         btStatbas.setVisible(false);
         statEnBas.setVisible(false);
          revenir.setVisible(false);
          aPropos.setVisible(false);
         lesBtDroite.setLayoutX(1506);       
        lesBtDroite.setLayoutY(354);
        revenir.setLayoutX(1543);
        revenir.setLayoutY(887);
        aPropos.setLayoutX(1365);
        aPropos.setLayoutY(234);  
        aPropos.setPrefWidth(396);
       aPropos.setPrefHeight(548);
         
      }

    @FXML
    private void BtLogoutAction(ActionEvent event) {
           TranslateTransition slide = new TranslateTransition ();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(tableView);
        slide.setToX(9.0);
        slide.play();
        connexionAdmin.setVisible(false);
        btconnexAdm.setVisible(true);
        revenirUtilisateur.setVisible(false);
        commandeAdmin.setVisible(false);
        lesBtDroite.setVisible(true);
        btStatisque.setVisible(true);
        btStatbas.setVisible(false);
        revenir.setVisible(false);
        statEnBas.setVisible(false);
        lesBtDroite.setLayoutX(1506);       
        lesBtDroite.setLayoutY(354);
        revenir.setLayoutX(1543);
        revenir.setLayoutY(887);
        aPropos.setLayoutX(1365);
        aPropos.setLayoutY(234);  
        aPropos.setPrefWidth(396);
       aPropos.setPrefHeight(548);
       raz();
////        fond'écran
        anchorPrincipal.setId("bgUser");
            Btrecherche.setId("bgUser");
            Btrecherche.setId("boutton");
      BtAjouter.setId("bgUser");
      BtSupprimer.setId("bgUser");
      BtLogout.setId("bgUser");
      BtAnnulerRaz.setId("bgUser");
      btStatisque.setId("bgUser");
       btStatisque.setId("boutton");
       btAPropos.setId("bgUser");
        btAPropos.setId("boutton");
      BtModifier.setId("bgUser");
      btStatbas.setId("bgUser");
      revenir.setId("bgUser");
      lbAfficheurMode.setText("MODE UTILISATEUR");
    }
    
    @FXML
    private void btStatisqueAction(ActionEvent event) {
        localStat.setVisible(true);
        revenir.setVisible(true);
        btStatbas.setVisible(false);
    }

    @FXML
    private void btAProposAction(ActionEvent event) {
        aPropos.setVisible(true);
        lesBtDroite.setVisible(false); 
        revenir.setVisible(true);
        btStatbas.setVisible(false);
    }
    
    @FXML
    private void revenirAction(ActionEvent event) {
         aPropos.setVisible(false);
        lesBtDroite.setVisible(true);
        revenir.setVisible(false);
        localStat.setVisible(false);
        statEnBas.setVisible(false);
        btStatbas.setVisible(false);
        if(revenirUtilisateur.isVisible() || BtLogout.isVisible()){
            btStatbas.setVisible(true);
        }
    }
    
    
    @FXML
    private void btStatbasAction(ActionEvent event) {
        statEnBas.setVisible(true);
        lesBtDroite.setVisible(false);
         revenir.setVisible(true);
         btStatbas.setVisible(false);
        revenir.setLayoutX(1390);
        revenir.setLayoutY(884);
    }
    
    @FXML
    //remise à zéro de l'autre boutton non selectionné
    public void rbGenreF(MouseEvent event) {
        RadioButtonFeminin.setSelected(true);
        RadioButtonMasculin.setSelected(false);
    }
//remise à zéro de l'autre boutton non selectionné
    @FXML
    public void rbGenreM(MouseEvent event) {
        RadioButtonFeminin.setSelected(false);
        RadioButtonMasculin.setSelected(true);
    }
    //remise à zéro de l'autre boutton non selectionné
    @FXML
    void rbSecteurPrive(MouseEvent event) {
        RadioButtonPublic.setSelected(false);
        RadioButtonPrive.setSelected(true);
    }

    //remise à zéro de l'autre boutton non selectionné
    @FXML
    void rbSecteurPublic(MouseEvent event) {
        RadioButtonPublic.setSelected(true);
        RadioButtonPrive.setSelected(false);
    }
    @FXML
    void selection(MouseEvent event){
        String rentree = TcDate.getCellData(tableView.getSelectionModel().getFocusedIndex());
        String localisation = TcLocalisation.getCellData(tableView.getSelectionModel().getFocusedIndex());
        String formation = TcFormation.getCellData(tableView.getSelectionModel().getFocusedIndex());
        String secteur = TcSecteur.getCellData(tableView.getSelectionModel().getFocusedIndex());
        String genre = TcGenre.getCellData(tableView.getSelectionModel().getFocusedIndex());
        String nom = TcNom.getCellData(tableView.getSelectionModel().getFocusedIndex());
        String prenom = TcPrenom.getCellData(tableView.getSelectionModel().getFocusedIndex());
        
        TfRentree.setText(rentree);
        TfLocalisation.setText(localisation);
        TfFormations.setText(formation);
        if(secteur.equals("Établissements publics")){
            RadioButtonPublic.setSelected(true);
            RadioButtonPrive.setSelected(false);
        }else{
            RadioButtonPublic.setSelected(false);
            RadioButtonPrive.setSelected(true);
        }
        if(genre.equals("Masculin")){
            RadioButtonFeminin.setSelected(false);
            RadioButtonMasculin.setSelected(true);
        }else{
            RadioButtonMasculin.setSelected(false);
            RadioButtonFeminin.setSelected(true);
        }
        TfNom.setText(nom);
        TfPrenom.setText(prenom);
    }
    
    @FXML
    void deselection (MouseEvent event){
    traitement.affichage(tableView, TcDate, TcLocalisation, TcFormation, TcSecteur, TcGenre, TcNom, TcPrenom);
    raz();
    }
    
    //.................ICI TOUTE LES FONCTIONS.............
    private void raz() {
        TfRentree.setText("");
        TfLocalisation.setText("");
        TfFormations.setText("");
        RadioButtonPublic.setSelected(false);
        RadioButtonPrive.setSelected(false);
        RadioButtonFeminin.setSelected(false);
        RadioButtonMasculin.setSelected(false);
        TfNom.setText("");
        TfPrenom.setText("");
        PfPassword.setText("");
        TfLogin.setText("");
        TfRecherche.setText("");
    }
    //retourne la valeur du boutton selectionné
    private String bRadioGenre(){
        String res;
        if (RadioButtonFeminin.isSelected()){
        RadioButtonFeminin.setSelected(true);
        RadioButtonMasculin.setSelected(false);
        res = "Feminin";
        }else{
            RadioButtonFeminin.setSelected(false);
            RadioButtonMasculin.setSelected(true);
            res = "Masculin";
        }
        
        return res;
    }
    //retourne la valeur du boutton selectionné
    private String bRadioSecteur(){
        String res;
        if (RadioButtonPublic.isSelected()){

        res = "Établissements publics";
        }else{

            res = "Établissements privés";
        }
        
        return res;
    }

  

       }

    

