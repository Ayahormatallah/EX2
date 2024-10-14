package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.Produit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ma.projet.classes.Categorie;
 import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits = new ArrayList<>();

    @Override
    public boolean create(Produit produit) {
        return produits.add(produit);
    }

    @Override
    public Produit getById(int id) {
        return produits.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        return produits.stream()
                .filter(produit -> produit.getCategorie().equals(categorie))
                .collect(Collectors.toList());
    }
  
    
    // Méthode simplifiée pour afficher les produits commandés entre deux dates
    public void afficherProduitsCommandesEntreDeuxDates(Date dateDebut, Date dateFin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            // Requête simplifiée pour obtenir les produits entre deux dates
            String hql = "SELECT DISTINCT p FROM Produit p " +
                         "JOIN p.ligneCommandeProduits lcp " +
                         "JOIN lcp.commande c " +
                         "WHERE c.date BETWEEN :dateDebut AND :dateFin";
            
            Query query = (Query) session.createQuery(hql);
            query.setParameter("dateDebut", dateDebut);
            query.setParameter("dateFin", dateFin);
            
            List<Produit> produits = query.getResultList();
            
            // Afficher les produits commandés
            System.out.println("Produits commandés entre " + dateDebut + " et " + dateFin + " :");
            for (Produit produit : produits) {
                System.out.println(produit);
            }
            
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }}
        
        public void afficherProduitsPrixSuperieurA100() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Exécution de la requête nommée
            Query query = (Query) session.getNamedQuery("Produit.findPrixSuperieurA100");

            // Récupérer la liste des produits
            List<Produit> produits = query.getResultList();

            // Afficher la liste des produits
            System.out.println("Liste des produits avec un prix > 100 DH :");
            for (Produit produit : produits) {
                System.out.println("Référence: " + produit.getReference() + " Prix: " + produit.getPrix() + " DH");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}


    
    
   


