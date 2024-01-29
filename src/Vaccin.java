public class Vaccin {
    static int indexMort = 0;
    public static void a1Vaccin(Person person) {
        if (person.variants.contains(Constante.zombieA) || person.variants.contains(Constante.zombie32)) {
            if (person.age <= Constante.SEUIL_AGE_VACCIN) {
                System.out.println(person.name + " (" + person.age + " ans) vacciné et est immunisé contre tous les variants.");
                person.variants.clear();
                person.isSafe = true;
            } else {
                System.out.println(person.name + " (" + person.age + " ans) est trop vieux, le vaccin est inefficace.");
            }
        }
        for (Person p : person.relation) {
            a1Vaccin(p);
        }
    }

    public static void b1Vaccin(Person person) {
        if (person.variants.contains(Constante.zombieB) || person.variants.contains(Constante.zombieC)) {
            if (indexMort % Constante.INDICE_MORT_PAIR == 0) {
                System.out.println(person.name + " a été vacciné n'est plus infecté par le virus Zombie-B ou Zombie-C.");
                person.variants.removeIf(variant -> variant.equals(Constante.zombieB) || variant.equals(Constante.zombieC));
            } else {
                System.out.println(person.name + " a été tué par le vaccin.");
                person.isDead = true;
            }
            indexMort++;
        }
        for (Person p : person.relation) {
            b1Vaccin(p);
        }
    }

    public static void ultimateVaccine(Person person) {
        if (person.variants.contains(Constante.zombieUltime)) {
            System.out.println(person.name + " est vacciné et ne pourra être infecté ou infecter");
            person.variants.clear();
            person.isSafe = true;
            person.peutInfecter = false;
        }
        for (Person p : person.relation) {
            ultimateVaccine(p);
        }
    }
}
