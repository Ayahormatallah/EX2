package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.LigneCommandeProduit;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeService implements IDao<LigneCommandeProduit> {

    private List<LigneCommandeProduit> ligneCommandes = new ArrayList<>();

    @Override
    public boolean create(LigneCommandeProduit ligneCommande) {
        return ligneCommandes.add(ligneCommande);
    }

    @Override
    public LigneCommandeProduit getById(int id) {
        return ligneCommandes.stream()
                .filter(lc -> lc.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<LigneCommandeProduit> getAll() {
        return ligneCommandes;
    }
}
