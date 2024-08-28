package fr.lambda.cours.calculatrice;

import java.util.ArrayList;
import java.util.List;

public class stream {

    public static void main(String[] args) {
        List<Stagiaires> stagiaires = new ArrayList<>();
        stagiaires.add(new Stagiaires("Hammou", "Yannis", false));
        stagiaires.add(new Stagiaires("Bossard", "Hugo", false));
        stagiaires.add(new Stagiaires("Marchal", "Muriel", true));
        stagiaires.add(new Stagiaires("Benseddik", "Amir", true));

        //affichage prenoms stagiaires relous
        for(Stagiaires stagiaire : stagiaires) {
            if(stagiaire.isRelou()) {
                System.out.println(stagiaire.getPrenom());
            }
        }
        //code dans entreprise
        stagiaires.stream()
                .filter(Stagiaires::isRelou)
                .forEach(System.out::println);

        //l'équivalent avec un stream fonctionnel
        //le stream ne modifie pas la Collection
        stagiaires.stream()
                .filter((Stagiaires s) -> {return s.isRelou();})
                .forEach((Stagiaires s ) -> {
                    System.out.println(s.getPrenom());
                });

        //l'équivalent avec un stream fonctionnel - raccourci
        stagiaires.stream()
                .filter(s -> s.isRelou())
                .forEach(s -> System.out.println(s.getPrenom()));

        stagiaires.stream().filter(s -> s.getPrenom().startsWith("Yan"))
                .filter(s -> s.getNom().length() > 5)
                .map(s -> s.getPrenom())
                .forEach(s -> System.out.println(s));

        List<String> prenomsStagiares = stagiaires.stream()
                .filter(s -> s.getPrenom().startsWith("Yan"))
                .filter(s -> s.getNom().length() > 5)
                .map(s -> s.getPrenom())
                .toList();
        System.out.println(prenomsStagiares);
    }
}
