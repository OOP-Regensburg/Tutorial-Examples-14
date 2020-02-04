package basics;

import java.util.ArrayList;

public class Student {

    /**
     * Instanzvariablen für die relevanten Eigenschaften der Student-Objekte
     */
    private String name;
    private String studentID;
    private ArrayList<String> finishedCourses;

    /**
     * Konstruktor: Name und Matrikelnummer werden über Parameter des Konstruktors gesetzt. Für jedes Student-Objekt wird beim
     * Erstellen eine leere Liste zur Erfassung der bereits absolvierten Kurse erstellt.
     *
     * @param name Name des Studierenden
     * @param studentID Matrikelnummer des Studierenden
     */
    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.finishedCourses = new ArrayList<String>();
    }

    // Getter-Methode für das Auslesen des Namen des Studierenden
    public String getName() {
        return name;
    }

    // Setter-Methode zum Setzten des Namen des Studierenden
    public void setName(String name) {
        this.name = name;
    }

    // Getter-Methode für das Auslesen der Matrikelnummer des Studierenden
    public String getStudentID() {
        return studentID;
    }

    // Setter-Methode zum Setzten der Matrikelnummer des Studierenden
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // Methode zum Hinzufügen/Speichern eines absolvierten Kurses
    public void addCourse(String courseName) {
        finishedCourses.add(courseName);
    }

    // Methode zum Prüfen, ob der Studierende einen bestimmten Kurs (course) bereits absolviert hat
    public boolean hasFinishedCourse(String course) {
        return finishedCourses.contains(course);
    }

    // Überschrieben toString-Methode, die Name und Matrikelnummer zurückgibt
    @Override
    public String toString() {
        return name + " (" + studentID + ")";
    }
}