package basics;

import java.util.ArrayList;
import java.util.Scanner;

public class CharFrequencyApp implements Task {

    /**
     * Lassen Sie beliebig viele Einzelwörter vom Nutzenden eingeben. Dieser kann die Eingabe neuer Wörter
     * nach jedem Wort fortsetzten oder beenden. Geben Sie im Anschluss eine Häufikgeitsverteilung der Buchstaben
     * (A-Z) aus.
     */

    private static final String ENTER_WORD_PROMPT = "Bitte geben Sie ein Wort ein: ";
    private static final String ASK_FOR_NEXT_WORD_PROMPT = "Möchten Sie ein zusätzliches Wort eingeben? [ja/nein]";

    @Override
    public void run() {
        System.out.println("Running: CharFrequencyApp");
        // Einlesen der Wörter
        ArrayList<String> words = readWords();
        // Berechnen der Zeichenhäufigkeit
        int[] charFrequency = calculateCharFrequency(words);
        // Ausgabe der Zeichenhäufigkeit
        printCharFrequency(charFrequency);
    }

    /**
     * Lässt die Nutzenden ein beliebig lange Liste an Wörtern eingeben. Nach jedem Wort hat der Nutzer/die Nutzerin
     * die Möglichkeit, die Eingabe fortzusetzten oder zu beenden.
     *
     * @return Alle vom Benutzer eingegebenen Wörter als ArrayList
     */
    private ArrayList<String> readWords() {
        ArrayList<String> words = new ArrayList<String>();
        boolean shouldReadNextWord = true;
        while(shouldReadNextWord) {
            String nextWord = readStringFromUser(ENTER_WORD_PROMPT);
            words.add(nextWord);
            shouldReadNextWord = shouldAskForNextWord();
        }
        return words;
    }

    /**
     * Erfrägt beim Nutzenden, ob ein weiteres Wort eingelesen werden soll.
     *
     * @return true, wenn ein weiteres Wort eingelesen werden soll, false wenn nicht
     */
    private boolean shouldAskForNextWord() {
        String input = readStringFromUser(ASK_FOR_NEXT_WORD_PROMPT);
        if(input.equals("ja")) {
            return true;
        }
        return false;
    }

    /**
     * Liest eine Benutzereingabe von der Konsole ein und gibt vorher die als msg übergebene Nachricht aus.
     *
     * @param msg Nachricht an den Nutzer/die Nutzerin
     * @return Als String eingelesene, komplette Antwortzeile des Nutzers/der Nutzerin
     */
    private String readStringFromUser(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        String userInput = in.nextLine();
        return userInput;
    }

    /**
     * Gibt ein Integer-Array der Länge 26 zurück. Jeder Eintrag repräsentiert die Auftretenshäufigkeiten des jeweiligen,
     * alphabetisch sortierten, Zeichens in der Menge der übergebenen Wörter.
     *
     *  [0]: "Häufigkeit des Zeichens 'a'"
     *  [1]: "Häufigkeit des Zeichens 'b'"
     *  ...
     *
     * Groß-/Kleinschreibung wird dabei nicht beachtet.
     *
     * @param words Liste der zu bearbeitenden Wörter.
     * @return Integer-Array mit der Zeichenhäufigkeit.
     */
    private int[] calculateCharFrequency(ArrayList<String> words) {
        // Erstellen des Arrays zum Zählen der Zeichenhäufigkeit der Zeichen 'a' bis 'z'
        // Alle Elemente des Arrays werden mit dem Default-Wert 0 initalisiert.
        int[] charFrequency = new int[26];
        // Wir iterieren über alle Wörter in der als Parameter übergebenen Liste ...
        for(String word: words) {
            // ... wandeln jedes Wort in die Kleinbuchstaben-Repräsentation um ...
            String lowerCaseWord = word.toLowerCase();
            // ... und betrachten jedes Zeichen des Wortes:
            for(char c: lowerCaseWord.toCharArray()) {
                // Ausgehend vom numerischen Wert des Zeichens (ASCII) wird dessen alphabetische Position berechnet ...
                int alphabeticIndex = c - 97;
                // ... und - falls es sich um einen Buchstaben zwischen 'a' und 'z' handelt ...
                if(alphabeticIndex >= 0 && alphabeticIndex < 26) {
                    // ... der entsprechende Zähler im "Häufigkeits-Array" inkrementiert.
                    charFrequency[alphabeticIndex]++;
                }
            }
        }
        return charFrequency;
    }

    /**
     * Gibt den Inhalt des übergebenen Arrays auf der Konsole aus. Das Array wird als Liste mit der Auftretenshäufigkeit
     * der Buchstaben A bis Z interpretiert. Vor dem Inhalt jeden Elements wird das korrespondierende Zeichen ausgegeben.
     *
     * @param frequency Integer-Array mit den alphabetisch sortierten Häufigkeitswerten für die Buchstaben 'a' bis 'z'
     */
    private void printCharFrequency(int[] frequency) {
        for(int i = 0; i < frequency.length; i++) {
            // Der aktuelle Wert von i (0 bis 25) wird in den jeweiligen Buchstaben an der entsprechenden Stelle des
            // Alphabets umgerechnet. Der Wert 97 kennzeichnet im ASCII-Code das kleine 'a'.
            char currentChar = (char) (97 + i);
            // Zwischen Buchstabe und numerischer Häufigkeit wird ein TAB-Zeichen eingefügt.
            System.out.println(currentChar + ":\t" + frequency[i]);
        }
    }

}
