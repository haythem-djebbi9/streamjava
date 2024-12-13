package levels;

import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("s"))
                .count();
        System.out.println("Nombre des enseignants dont le nom commence avec 's' : " + nbr);

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream()
                .filter(teacher -> teacher.getSubject() == models.Subject.FLUTTER)
                .mapToInt(Teacher::getSalary)
                .sum();
        System.out.println("Somme des salaires des enseignants Flutter : " + sum);

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("a"))
                .mapToInt(Teacher::getSalary)
                .average()
                .orElse(0.0); // Retourne 0 si aucun enseignant correspondant
        System.out.println("Moyenne des salaires des enseignants dont le nom commence avec 'a' : " + average);

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("f"))
                .collect(Collectors.toList());
        System.out.println("Enseignants dont le nom commence par 'f' : " + teachers1);

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("s"))
                .collect(Collectors.toList());
        System.out.println("Enseignants dont le nom commence par 's' : " + teachers2);

        /* TO DO 6: Retourner true si il y a au min un enseignant dont le salaire > 100000, false sinon */
        boolean test = teachers.stream()
                .anyMatch(teacher -> teacher.getSalary() > 100000);
        System.out.println("Y a-t-il au moins un enseignant avec un salaire > 100000 ? : " + test);

        /* TO DO 7: Afficher le premier enseignant Unity dont le nom commence avec g avec 2 manières différentes */
        System.out.println("Premier enseignant Unity dont le nom commence par 'g' (1ère manière) :");
        teachers.stream()
                .filter(teacher -> teacher.getSubject() == models.Subject.UNITY)
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("g"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("Premier enseignant Unity dont le nom commence par 'g' (2ème manière) :");
        Optional<Teacher> firstTeacher = teachers.stream()
                .filter(teacher -> teacher.getSubject() == models.Subject.UNITY)
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("g"))
                .findFirst();
        firstTeacher.ifPresent(System.out::println);

        /* TO DO 8: Afficher le deuxième enseignant dont le nom commence avec s */
        System.out.println("Deuxième enseignant dont le nom commence par 's' :");
        teachers.stream()
                .filter(teacher -> teacher.getName().toLowerCase().startsWith("s"))
                .skip(1) // Ignorer le premier résultat
                .findFirst() // Obtenir le deuxième résultat
                .ifPresent(System.out::println);
    }
}
