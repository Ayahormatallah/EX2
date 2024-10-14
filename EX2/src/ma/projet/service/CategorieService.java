package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.Categorie;
import java.util.ArrayList;
import java.util.List;

public class CategorieService implements IDao<Categorie> {

    private List<Categorie> categories = new ArrayList<>();

    @Override
    public boolean create(Categorie categorie) {
        return categories.add(categorie);
    }

    @Override
    public Categorie getById(int id) {
        return categories.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Categorie> getAll() {
        return categories;
    }
}
