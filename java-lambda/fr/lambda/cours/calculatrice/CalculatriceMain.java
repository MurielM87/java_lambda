package fr.lambda.cours.calculatrice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CalculatriceMain {

    public static void main(String[] args) {
       Calculatrice maCalculette = new Calculatrice();

        System.out.println("Multiplication");
       maCalculette.setOperationEnCours(new Multiplication());
       maCalculette.resetEntrees();
       maCalculette.executeOperation();
       maCalculette.afficheResultat();

        System.out.println("Division");
        Division division = new Division();
        maCalculette.setOperationEnCours(division);
        maCalculette.resetEntrees();
        maCalculette.executeOperation();
        maCalculette.afficheResultat();

        ///le client demande d'élever deux entiers avec une certaine puissance
        //Le code ci-dessous est long, et n'est jamais utilisé en entreprise
        Operation maPuissance = (int a, int b) -> {
            System.out.println("Ce code est une lambda");
            return (int) Math.pow(a,b);
        };
        maCalculette.setOperationEnCours(maPuissance);
        maCalculette.resetEntrees();
        maCalculette.executeOperation();
        maCalculette.afficheResultat();

        //le client demande un modulo
        //Le code ci-dessous est plus celui utilisé en entreprise
        maCalculette.setOperationEnCours((int a, int b) -> {return a%b;});
        //La ligne ci-dessus fait la même chose que celle ci-dessous
        maCalculette.setOperationEnCours((a, b) -> a%b);

        OperationUnaire operationUnaire = (int a) -> {return 2*a;};
        //La ligne ci-dessus fait la même chose que celle ci-dessous
        OperationUnaire operationUnaire2 = a -> 2*a;

        int nombreMagique = 42;
        Consumer<String> operationString = s -> {
            String s2 = "lkjlkj";
            int truc = nombreMagique * 4;
            System.out.println(s2 + s);
        };

        List<String> trucs = Arrays.asList("lkjlkj", "lklkj", " ", "");

        //soustraction
        Operation maSoustraction = (int a, int b) -> {
            System.out.println("lambda de soustraction");
            return (Math.abs(a - b));
        };
        maCalculette.setOperationEnCours(maSoustraction);
        maCalculette.resetEntrees();
        maCalculette.executeOperation();
        maCalculette.afficheResultat();

        maCalculette.setOperationEnCours((a, b) -> Math.abs(a - b));
        maCalculette.resetEntrees();
        maCalculette.executeOperation();
        maCalculette.afficheResultat();

        //difference
        Operation madifference = (int a, int b) -> {
            System.out.println("lambda de difference");
            if(a > b) {
                return 0;
            } else {
                return 1;
            }
        };
        maCalculette.setOperationEnCours(madifference);
        maCalculette.resetEntrees();
        maCalculette.executeOperation();
        maCalculette.afficheResultat();

        maCalculette.setOperationEnCours((a, b) -> a > b ? 0 : 1);
        maCalculette.resetEntrees();
        maCalculette.executeOperation();
        maCalculette.afficheResultat();



        int nouveauNombreMagique = 42;
        Consumer<String> operationString3 = s -> {
            String s2 = "lkjlkj";
            int truc = nombreMagique * 4;
            System.out.println(s2 + s);
        };

        List<String> trucsEtMachin = Arrays.asList("lkjlkj", "lklkj", " ", "");


        System.out.println("Affichage des éléments blancs avec une lambda classique");
        System.out.println(trucs.stream().filter(s -> s.isBlank()).count());

        System.out.println("Affichage des éléments blancs avec une référence de méthode");
        System.out.println(trucs.stream().filter(String::isBlank).count());

    }
}