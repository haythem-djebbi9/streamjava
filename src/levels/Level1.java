package levels;

import models.Teacher;
import utils.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        System.out.println("Tous les enseignants :");
        teachers.stream().forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        System.out.println("\nEnseignants dont le nom commence par la lettre 'n' :");
        teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("n"))
                .forEach(System.out::println);

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        System.out.println("\nEnseignants dont le nom commence par la lettre 'n' et le salaire > 100000 :");
        teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("n"))
                .filter(teacher -> teacher.getSalary() > 100000)
                .forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        System.out.println("\nEnseignants JAVA triés par salaire (sans doublons) :");
        teachers.stream()
                .filter(teacher -> teacher.getSubject() == models.Subject.JAVA)
                .distinct() // Éliminer les doublons
                .sorted(Comparator.comparingInt(Teacher::getSalary))
                .forEach(System.out::println);

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */
        System.out.println("\nNoms des enseignants dont le salaire > 60000 (manière 1) :");
        teachers.stream()
                .filter(teacher -> teacher.getSalary() > 60000)
                .forEach(teacher -> System.out.println(teacher.getName()));

        System.out.println("\nNoms des enseignants dont le salaire > 60000 (manière 2) :");
        teachers.stream()
                .filter(teacher -> teacher.getSalary() > 60000)
                .map(Teacher::getName) // Mapper vers les noms uniquement
                .forEach(System.out::println);

        /*
         * TO DO 6: Ajouter 200 Dt pour les enseignants dont le nom commence par 'm' et afficher celui qui a le salaire le plus élevé
         */
        System.out.println("\nEnseignant avec le plus grand salaire après ajout de 200Dt (noms commençant par 'm') :");
        teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("m"))
                .peek(teacher -> teacher.setSalary(teacher.getSalary() + 200)) // Ajouter 200Dt
                .max(Comparator.comparingInt(Teacher::getSalary)) // Trouver le maximum par salaire
                .ifPresent(System.out::println);
    }
}
