Cette application permet de gérer le stock de produits informatiques dans un magasin. Les fonctionnalités incluent la gestion des produits, des catégories, des commandes, et des lignes de commande. L'application est conçue avec une couche de persistance utilisant Hibernate pour interagir avec une base de données MySQL, et une couche service pour implémenter les opérations métier.

Structure du Projet
Le projet est divisé en plusieurs packages, chacun correspondant à une couche différente de l'application :

ma.projet.classes : Contient les classes entités représentant les produits, catégories, commandes et lignes de commande.
ma.projet.config : Contient le fichier de configuration pour Hibernate.
ma.projet.dao : Définit l'interface générique IDao pour les opérations CRUD.
ma.projet.service : Implémente les services métier, gérant les entités et leurs interactions.
ma.projet.util : Contient des classes utilitaires comme HibernateUtil pour la gestion des sessions Hibernate.
