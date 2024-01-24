import java.util.Random;
import java.util.Scanner;

class Bakugan {
    private String nom;
    private int puissance;

    public Bakugan(String nom, int puissance) {
        this.nom = nom;
        this.puissance = puissance;
    }

    public String getNom() {
        return nom;
    }

    public int getPuissance() {
        return puissance;
    }
}

class Joueur {
    private String nom;
    private Bakugan bakuganActif;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Bakugan getBakuganActif() {
        return bakuganActif;
    }

    public void setBakuganActif(Bakugan bakuganActif) {
        this.bakuganActif = bakuganActif;
    }
}

public class RPG {
    private static Random random;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            Bakugan bakugan1 = new Bakugan("Dragonoid", random.nextInt(100));
            Bakugan bakugan2 = new Bakugan("Tigrerra", random.nextInt(100));

            Joueur joueur1 = new Joueur("Joueur 1");
            Joueur joueur2 = new Joueur("Joueur 2");

            joueur1.setBakuganActif(bakugan1);
            joueur2.setBakuganActif(bakugan2);

            System.out.println("Bienvenue dans le jeu Bakugan!");

            while (true) {
                afficherStatutJoueurs(joueur1, joueur2);

                System.out.println("Joueur 1, que voulez-vous faire?");
                System.out.println("1. Attaquer");
                System.out.println("2. Changer de Bakugan");
                System.out.println("3. Quitter");

                int choixJoueur1 = scanner.nextInt();

                switch (choixJoueur1) {
                    case 1:
                        effectuerCombat(joueur1, joueur2);
                        break;
                    case 2:
                        changerBakugan(joueur1, random);
                        break;
                    case 3:
                        System.out.println("Fin du jeu. Au revoir!");
                        System.exit(0);
                    default:
                        System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 3.");
                }

                // Joueur 2 effectue son tour
                effectuerCombat(joueur2, joueur1);
            }
        }
    }

    private static void afficherStatutJoueurs(Joueur joueur1, Joueur joueur2) {
        System.out.println("\nStatut des joueurs:");
        System.out.println(joueur1.getNom() + ": " + joueur1.getBakuganActif().getNom() +
                " (Puissance: " + joueur1.getBakuganActif().getPuissance() + ")");
        System.out.println(joueur2.getNom() + ": " + joueur2.getBakuganActif().getNom() +
                " (Puissance: " + joueur2.getBakuganActif().getPuissance() + ")");
    }

    private static void effectuerCombat(Joueur attaquant, Joueur defenseur) {
        System.out.println(attaquant.getNom() + " attaque!");

        int puissanceAttaque = attaquant.getBakuganActif().getPuissance();
        int puissanceDefense = defenseur.getBakuganActif().getPuissance();

        if (puissanceAttaque > puissanceDefense) {
            System.out.println("Attaque réussie! " + defenseur.getNom() + " perd un Bakugan.");
            // Simulation de la capture du Bakugan de l'adversaire
            defenseur.setBakuganActif(new Bakugan("Nouveau Bakugan", random.nextInt(100)));
        } else {
            System.out.println("Attaque échouée! Aucun Bakugan n'est perdu.");
        }
    }

    private static void changerBakugan(Joueur joueur, Random random) {
        // Simulation du changement de Bakugan
        joueur.setBakuganActif(new Bakugan("Nouveau Bakugan", random.nextInt(100)));
        System.out.println(joueur.getNom() + " a changé de Bakugan.");
    }
}
