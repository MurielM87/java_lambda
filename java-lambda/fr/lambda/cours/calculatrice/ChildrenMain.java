package fr.lambda.cours.calculatrice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChildrenMain {
    public static void main(String[] args) {
        List<Child> children = new ArrayList<>();
        children.add(new Child("Riri", 3, true));
        children.add(new Child("Fifi", 7, false));
        children.add(new Child("Loulou", 2, false));
        children.add(new Child("Donald", 5, true));
        children.add(new Child("Picsou", 2, true));
        children.add(new Child("Daisy", 13, false));
        children.add(new Child("Popop", 3, false));
        children.add(new Child("Minnie", 15, false));
        children.add(new Child("Mickey", 1, false));
        children.add(new Child("Dingo", 8, true));
        children.add(new Child("Gontrand", 15, false));
        children.add(new Child("Pat Hibulaire", 2, false));

       System.out.println("liste des enfants");
       children.stream()
               .map(c -> c.getPrenom())
               .forEach(c -> System.out.println(c));
                //.map(Child::getPrenom)
               //.forEach(System.out::println);

       System.out.println("En dessous de l'âge de 3 ans");
       children.stream()
               .filter(c -> c.getAge() < 3)
               .map(c -> c.getPrenom())
               .forEach((c -> {
                   System.out.println(c);
               }));
               //.map(Child::getPrenom)
               //.forEach(System.out::println);


                //children.stream().max((child1, child2) -> child1.getAge().compareTo(child2.getAge()).get().getPrenom()).ifPresent(child -> system.Out.println(child.getPrenom()););
       Optional<Child> oldestChild = children.stream()
               .max(Comparator.comparingInt(c -> c.getAge()));
                //.max(Comparator.comparingInt(Child::getAge));
        oldestChild.ifPresent(c -> System.out.println("L'enfant le plus âgé est " + c.getPrenom() + " - " + c.getAge() + " ans"));

       Optional<Child> youngerChild = children.stream()
               .min(Comparator.comparingInt(c -> c.getAge()));
               //.min(Comparator.comparingInt(Child::getAge));
        youngerChild.ifPresent(c -> System.out.println("L'enfant le plus jeune est " + c.getPrenom() + " - " + c.getAge()));

       double averageAge = children.stream()
               .mapToInt(c -> c.getAge()) //lambda classique
               //.mapToInt(Child::getAge) //reference de methode
               .average()
               .getAsDouble();
                //.orElse(0.0); //element par défaut
        System.out.printf("la moyenne des âges est de %.2f%n", averageAge);


       boolean hasChildOlderThan16 = children.stream()
                .anyMatch(c -> c.getAge() > 16);
        if (hasChildOlderThan16) {
            System.out.println("Il y a au moins un enfant qui a plus de 16 ans.");
        } else {
            System.out.println("Aucun enfant n'a plus de 16 ans.");
        }
        System.out.println("autre méthode pour limite d'âge : " + children.stream().anyMatch(c -> c.getAge() > 16));

        List<String> childrenOlderThan10 = children.stream()
                .filter(c -> c.getAge() > 10)
               .map(c -> c.getPrenom()).toList();
                //.map(Child::getPrenom).toList();
        if (!childrenOlderThan10.isEmpty()) {
            System.out.println(childrenOlderThan10);
            System.out.println("Les enfants qui ont plus de 10 ans : " + String.join(", ", childrenOlderThan10));
        } else {
            System.out.println("Aucun enfant n'a plus de 10 ans.");
        }

        //afficher tous les enfants turbulents
        System.out.println("les enfants turbulents");
        children.stream()
                .filter(c -> c.isTurbulent())
                .map(c -> c.getPrenom())
                .forEach(c -> System.out.println(c));

        //afficher tous les enfants turbulents avec une reference de methode
        System.out.println("avec reference de methode : ");
        children.stream()
                .filter(Child::isTurbulent)
                .map(Child::getPrenom)
                .forEach(System.out::println);

        //afficher les enfants non tubulents avec une reference de methode
        System.out.println("les enfants non-turbulents");
        children.stream()
                .filter(Predicate.not(Child::isTurbulent))
                .map(Child::getPrenom)
                .forEach(System.out::println);

    }
}
