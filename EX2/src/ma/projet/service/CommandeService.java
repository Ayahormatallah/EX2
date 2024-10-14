package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.Commande;
import java.util.ArrayList;
import java.util.List;

public class CommandeService implements IDao<Commande> {

    private List<Commande> commandes = new ArrayList<>();

    @Override
    public boolean create(Commande commande) {
        return commandes.add(commande);
    }

    @Override
    public Commande getById(int id) {
        return commandes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Commande> getAll() {
        return commandes;
    }
}
