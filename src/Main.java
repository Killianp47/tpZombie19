import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person tree = buildTree();

        // Exécution du code
        System.out.println("======================================================");
        System.out.println("Début de l'infection :");
        Infection.infecter(tree);

        System.out.println("======================================================");
        System.out.println("Application vaccin A1 : ");
        Vaccin.a1Vaccin(tree);

        System.out.println("======================================================");
        System.out.println("Déploiement du vaccin B1...");
        Vaccin.b1Vaccin(tree);

        System.out.println("======================================================");
        System.out.println("Déploiement du vaccin Ultime...");
        Vaccin.ultimateVaccine(tree);
    }

    static Person relierAmisAvecAmisConnexes(Person person, Person amiConnexe) {
        for (Person ami : person.relation) {
            relierAmisAvecAmisConnexes(ami, person);
        }
        person.amiConnexe = amiConnexe;
        return person;
    }

    static Person buildTree() {

        Person ophelie = new Person("Ophelie", false, true, false, 33, new ArrayList<>(List.of(Constante.zombieB)), new ArrayList<>());
        Person didier = new Person("Didier", false, true, false, 50, new ArrayList<>(), new ArrayList<>(List.of(ophelie)));
        Person corentin = new Person("Corentin", false, true, false, 45, new ArrayList<>(), new ArrayList<>());
        Person sophie = new Person("Sophie", false, true, false, 25, new ArrayList<>(), new ArrayList<>(List.of(didier, corentin)));
        Person julie = new Person("Julie", false, true, false, 24, new ArrayList<>(List.of(Constante.zombie32)), new ArrayList<>());
        Person lea = new Person("Lea", false, true, false, 24, new ArrayList<>(List.of(Constante.zombieUltime)), new ArrayList<>());
        Person jules = new Person("Jules", false, true, false, 26, new ArrayList<>(), new ArrayList<>(List.of(lea)));
        Person clement = new Person("Clément", false, true, false, 32, new ArrayList<>(List.of(Constante.zombieC)), new ArrayList<>(List.of(julie, jules)));
        Person azyz = new Person("Azyz", false, true, false, 25, new ArrayList<>(), new ArrayList<>());
        Person lucas = new Person("Lucas", false, true, false, 25, new ArrayList<>(), new ArrayList<>());
        Person killian = new Person("Killian", false, true, false, 23, new ArrayList<>(List.of(Constante.zombieA)), new ArrayList<>(List.of(sophie, clement, azyz, lucas)));


        relierAmisAvecAmisConnexes(killian, null);

        return killian;
    }
}



