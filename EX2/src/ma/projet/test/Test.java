package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
public class Test {

    public static void main(String[] args) {
     
        
        ProduitService produitService = new ProduitService();
        CategorieService categorieService = new CategorieService();
        CommandeService commandeService = new CommandeService();
        
        // Scanner pour lire les entrées
        Scanner scanner = new Scanner(System.in);
        
        // Méthode 1: Afficher tous les produits
        System.out.println("Liste des produits :");
      
        
        // Méthode 2: Afficher les produits dont le prix est supérieur à 100 DH
        System.out.println("\nListe des produits avec un prix > 100 DH :");
        produitService.afficherProduitsPrixSuperieurA100();
        
        // Méthode 3: Afficher la liste des produits par catégorie
        System.out.println("\nEntrer l'ID de la catégorie pour afficher ses produits : ");
        int categorieId = scanner.nextInt();
        
        
        // Méthode 4: Afficher les produits commandés entre deux dates
        try {
            System.out.println("\nEntrer la première date (format : yyyy-MM-dd) : ");
            String date1Str = scanner.next();
            System.out.println("Entrer la deuxième date (format : yyyy-MM-dd) : ");
            String date2Str = scanner.next();
            
            // Convertir les chaînes de caractères en objets Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(date1Str);
            Date date2 = dateFormat.parse(date2Str);
            
            // Afficher les produits commandés entre ces deux dates
            produitService.afficherProduitsCommandesEntreDeuxDates(date1, date2);
            
        } catch (ParseException e) {
            System.out.println("Format de date incorrect.");
        }
        
        // Méthode 5: Afficher les produits d'une commande donnée
        System.out.println("\nEntrer l'ID de la commande pour afficher ses produits : ");
        int commandeId = scanner.nextInt();
       
        scanner.close();
    }
}
