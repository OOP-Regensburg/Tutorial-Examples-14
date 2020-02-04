package basics;

import java.util.ArrayList;

public class StudentApp implements Task {

    /**
     * Implementieren Sie eine Klasse Student, die einen Studierenden repräsentiert. Jeder Studierende verfügt über
     * nicht-öffentliche Variablen für den Namen, die Matrikelnummer und eine Liste der besuchten Kurse (Strings).
     * Ergänzen Sie die Klasse mit geeigneten Methoden zum Setzen und Auslesen der Eigenschaften.
     *
     * Ergänzen Sie in dieser Klasse eine Datenstruktur zum Verwalten einer Liste von Studierenden und implementieren
     * Sie Methoden für die folgenden Funktionen:
     *
     *  - Suche nach Studierenden anhand des Namens oder der Matrikelnummer
     *  - Erzeugen von Listen mit allen Studierenden, die einen bestimmten Kurs besucht haben
     */

    private ArrayList<Student> students;

    @Override
    public void run() {
        System.out.println("Running: StudentApp");
        // Erstellen einer Liste von Student-Objekten (mit Demodaten)
        createStudentList();
        // Hinzufügen von Kursen zu einigen der erstellten Student-Objekten
        modifyStudentList();
        // Ausgabe aller Studierenden, die bereits den Kurs "OOP" besucht haben
        printStudentsFromCourse("OOP");
    }

    /**
     * Erstellt eine neue ArrayList in der Instanzvariable "students" und befüllt diese mit drei
     * Demo-Objekten.
     */
    private void createStudentList() {
        students = new ArrayList<Student>();
        students.add(new Student("Test Student", "1234567890"));
        students.add(new Student("Another Student", "1234567891"));
        students.add(new Student("One Student More", "1234567892"));
    }

    /**
     * Markiert für einige der Student-Objekte in "students" die Kurse "OOP" und "Android" als absolviert.
     */
    private void modifyStudentList() {
        markCourseAsFinishedForStudentWithID("1234567890", "OOP");
        markCourseAsFinishedForStudentWithID("1234567890", "Android");
        markCourseAsFinishedForStudentWithID("1234567891", "OOP");
    }

    /**
     * Gibt alle Student-Objekte aus "students" aus, die den als course-Parameter übergebenen Kurs bereis absolviert haben.
     * @param course
     */
    private void printStudentsFromCourse(String course) {
        ArrayList<Student> matchingStudents = findStudentsByCourse(course);
        System.out.println("These students have finished [" + course + "]");
        for(Student student: matchingStudents) {
            System.out.println(student);
        }

    }

    /**
     * Sucht den Studierenden mit der übergebenen Matrikelnummer aus "students" heraus und markiert für diesen den
     * als course-Parameter übergebenen Kurs als absolviert.
     *
     * @param studentID Matrikelnummer des relevanten Studierenden
     * @param course Kurs(-name), der als absolviert markiert werden soll
     */
    private void markCourseAsFinishedForStudentWithID(String studentID, String course) {
        Student student = findStudentByID(studentID);
        if(student != null) {
            student.addCourse(course);
        }
    }

    /**
     * Gibt eine Liste aller Studierende zurück, für die der als course-Parameter übergebenen Kurs als absolviert
     * markiert ist.
     *
     * @param course Name des relevanten Kurses
     * @return ArrayList mit allen passenden Studen-Objekten
     */
    private ArrayList<Student> findStudentsByCourse(String course) {
        ArrayList<Student> matchingStudents = new ArrayList<Student>();
        for(Student student: students) {
            if(student.hasFinishedCourse(course)) {
                matchingStudents.add(student);
            }
        }
        return matchingStudents;
    }

    /**
     * Gibt das Student-Objekt mit der gesuchten Matrikelnummer zurück
     *
     * @param studentID Die gesuchte Matrikelnummer
     * @return Das gefundene Student-Objekt oder null, wenn kein Studierende mit der Matrikelnummer existiert.
     */
    private Student findStudentByID(String studentID) {
        for(Student currentStudent: students) {
            if(currentStudent.getStudentID().equals(studentID)) {
                return currentStudent;
            }
        }
        return null;
    }

    /**
     * Gibt das Student-Objekt mit dem gesuchten Namen zurück
     *
     * @param name Der gesuchte Name
     * @return Das gefundene Student-Objekt oder null, wenn kein Studierende mit dem Namen existiert.
     */
    private Student findStudentByName(String name) {
        for(Student currentStudent: students) {
            if(currentStudent.getName().equals(name)) {
                return currentStudent;
            }
        }
        return null;
    }
}
