/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.annuaireelectronique;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ClassAction {
  
String file = "src/main/resources/bd/donnees16le.txt";
    public void nombreListe(Label lab,TableView table){
        int nbrPers = table.getItems().size();
        String nbr = Integer.toString(nbrPers);
        lab.setText("Nous avons"+nbr+"listes de personnes.");
        
    }
    public void affichage(TableView<Personne> table, TableColumn rentree, TableColumn localisation, TableColumn etablissement, TableColumn secteur, TableColumn genre, TableColumn nom, TableColumn prenom){
        ObservableList<Personne> list = FXCollections.observableArrayList();
        try{
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-16LE"));
            
            String br;
            int idPers = 0;
            while ((br = bufferedReader.readLine()) != null) {
                
                String[] mots = br.split("\t");
                ArrayList pers = new ArrayList();
                for(int i=0;i<mots.length;i++){
                    pers.add(mots[i]);
                }
                idPers++;
                if (idPers>1){
                  list.add(new Personne(idPers,
                        pers.get(0).toString(),
                        pers.get(1).toString(),
                        pers.get(2).toString(),
                        pers.get(3).toString(),
                        pers.get(4).toString(),
                        pers.get(5).toString(),
                        pers.get(6).toString()));
                }
              
            }
            bufferedReader.close();
            
            rentree.setCellValueFactory(new PropertyValueFactory<>("rentree"));
            localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
            etablissement.setCellValueFactory(new PropertyValueFactory<>("etablissement"));
            secteur.setCellValueFactory(new PropertyValueFactory<>("secteur"));
            genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            table.setItems(list);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
         public void affichageRecherche(ArrayList indexListe,TableView<Personne> table, TableColumn rentree, TableColumn localisation, TableColumn etablissement, TableColumn secteur, TableColumn genre, TableColumn nom, TableColumn prenom){
                    ObservableList<Personne> list = FXCollections.observableArrayList();
        try{
  //          String file = "C:\\Users\\Inclusiv Academy 21\\Desktop\\Sedra\\AnnuaireElectronique\\src\\main\\resources\\bd\\dProjetC.txt";
            
      //      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-16LE"));
            
            String br;
            int idPers = 0;
            
            
        while ((br = bufferedReader.readLine()) != null) {
           
            String[] mots = br.split("\t");
            ArrayList pers = new ArrayList();
            for(int i=0;i<mots.length;i++){
                pers.add(mots[i]);
            }
            idPers++;
            //System.out.println(pers.size());
            
            
            String in =null;
            int a;
            
            for (int i = 0;i<indexListe.size();i++){
                 in = indexListe.get(i).toString();
            a = Integer.parseInt(in);
            if((idPers-1)==a){
                list.add(new Personne(idPers,
            pers.get(0).toString(),
            pers.get(1).toString(),
            pers.get(2).toString(),
            pers.get(3).toString(),
            pers.get(4).toString(),
            pers.get(5).toString(),
            pers.get(6).toString()));
            }
            }
       
        }
            bufferedReader.close();
            
            rentree.setCellValueFactory(new PropertyValueFactory<>("rentree"));
            localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
            etablissement.setCellValueFactory(new PropertyValueFactory<>("etablissement"));
            secteur.setCellValueFactory(new PropertyValueFactory<>("secteur"));
            genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            table.setItems(list);
           
        }
        catch(Exception e){
            System.out.println(e);
          }
        
        }
    }

