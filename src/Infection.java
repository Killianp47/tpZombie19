public class Infection {


    public static void infecter(Person person) {
        for (String variant : person.variants) {
            switch (variant) {
                case Constante.zombieA:
                    infecterHautenBas(person, Constante.zombieA, p -> true);
                    break;
                case Constante.zombieB:
                    infecterBasenHaut(person, Constante.zombieB, p -> true);
                    break;
                case Constante.zombie32:
                    infecterPourAge(person, 32);
                    break;
                case Constante.zombieC:
                    infecterUnsurDeux(person, Constante.zombieC);
                    break;
                case Constante.zombieUltime:
                    infecterBasenHaut(person, Constante.zombieUltime, p -> p.amiConnexe == null);
                    break;
            }
        }

        for (Person p : person.relation) {
            infecter(p);
        }
    }

    private static void infecterHautenBas(Person person, String variant, Condition conditionFn) {
        if (peutEtreInfecter(person, variant, conditionFn)) {
            System.out.println(person.name + " infecté par " + variant);
            person.variants.add(variant);
        }

        for (Person r : person.relation) {
            infecterHautenBas(r, variant, conditionFn);
        }
    }

    private static void infecterBasenHaut(Person person, String variant, Condition conditionFn) {
        if (peutEtreInfecter(person, variant, conditionFn)) {
            System.out.println(person.name + " infecté par " + variant);
            person.variants.add(variant);
        }

        if (person.amiConnexe != null) {
            infecterBasenHaut(person.amiConnexe, variant, conditionFn);
        }
    }

    private static void infecterPourAge(Person person, int ageSeuil) {
        infecterHautenBas(person, Constante.zombie32, p -> p.age >= ageSeuil);
        infecterBasenHaut(person, Constante.zombie32, p -> p.age >= ageSeuil);
    }

    private static void infecterUnsurDeux(Person person, String variant) {
        if (person.amiConnexe != null) {
            int indexPersonne = person.amiConnexe.relation.indexOf(person);

            for (int index = 0; index < person.amiConnexe.relation.size(); index++) {
                int pairImpair = indexPersonne % 2 == 0 ? 0 : 1;
                Person r = person.amiConnexe.relation.get(index);
                if (index % 2 == pairImpair && peutEtreInfecter(r, variant, p -> true)) {
                    System.out.println(r.name + " a été infecté par le virus " + variant);
                    r.variants.add(variant);
                }
            }
        }
    }
    private static boolean peutEtreInfecter(Person person, String variant, Condition conditionFn) {
        return person.peutInfecter && !person.isSafe && !person.isDead &&
                !person.variants.contains(variant) && conditionFn.test(person);
    }
    interface Condition {
        boolean test(Person person);
    }
}
