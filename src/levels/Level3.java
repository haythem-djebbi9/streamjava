package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule séparés par # */
        String names = teachers.stream()
                .map(teacher -> teacher.getName().toUpperCase())
                .reduce((name1, name2) -> name1 + "#" + name2)
                .orElse("");
        System.out.println("Tous les noms des enseignants en majuscule séparés par # : " + names);

        /* TO DO 2: Retourner un set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream()
                .filter(teacher -> teacher.getSubject() == Subject.JAVA)
                .filter(teacher -> teacher.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("Enseignants Java avec un salaire > 80000 : " + teachers1);

        /* TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Teacher::getName)
                        .thenComparing(Teacher::getSalary))));
        System.out.println("TreeSet des enseignants triés par nom et par salaire : " + teachers2);

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Subject, List<Teacher>> map = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));
        System.out.println("Enseignants regroupés par module : " + map);

        /* TO DO 5: Retourner une Map qui regroupe les noms des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream()
                .collect(Collectors.toMap(
                        Teacher::getSalary,
                        Teacher::getName,
                        (name1, name2) -> name1 + ", " + name2 // En cas de salaire identique, concaténer les noms
                ));
        System.out.println("Noms des enseignants regroupés par salaire : " + map1);

        /* TO DO 6: Afficher les noms des enseignants de chaque module */
        System.out.println("Noms des enseignants par module :");
        map.forEach((subject, teacherList) -> {
            String teacherNames = teacherList.stream()
                    .map(Teacher::getName)
                    .collect(Collectors.joining(", "));
            System.out.println(subject + ": " + teacherNames);
        });
    }
}
