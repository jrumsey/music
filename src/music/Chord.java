// Jeremy Rumsey

package music;

import java.util.Arrays;
import java.util.Scanner;

public class Chord {
	
	private static String[] chordNotes;
	public static String[][] notes = {{"B#", "C", "Dbb"}, {"Bx", "C#", "Db"}, {"Cx", "D", "Ebb"}, {"D#", "Eb", "Fbb"},
	{"Dx", "E", "Fb"}, {"E#", "F", "Gbb"}, {"Ex", "F#", "Gb"}, {"Fx", "G", "Abb"}, {"G#", "Ab", "Ab"},
	{"Gx", "A", "Bbb"}, {"A#", "Bb", "Cbb"}, {"Ax", "B", "Cb"}};
	
	public static void main(String args[]) {
		chordNotes = new String[3];
				
		while(true) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("What is the tonic note of the chord? (Double sharps and double flats will not be accepted)");
			String noteName;
			noteName = userInput.next();
			checkChordNoteName(noteName);
				
			System.out.println("Is the chord major, minor, augmented, or diminished?");
			String chordType;
			chordType = userInput.next();
			
			if(chordType.equals("major")) {
				createMajorChord(noteName);
			} 
			else if(chordType.equals("minor")) {
				createMinorChord(noteName);
			}
			else if(chordType.equals("augmented")) {
				createAugmentedChord(noteName);
			}
			else if(chordType.equals("diminished")) {
				createDiminishedChord(noteName);
			}
		} 
	}
	
	public static void checkChordNoteName(String chordNoteName) {
		String possibleNoteNames[] = {"C", "C#", "Db", "D", "Eb", "E", "F", "F#", "Gb", "G", "Ab", "A", "Bb", "B", "Cb"};
		if(!(Arrays.asList(possibleNoteNames).contains(chordNoteName))) {
			System.out.println("Please enter a valid note.");
			System.out.println("Valid notes are: \"C\", \"C#\", \"Db\", \"D\", \"Eb\", \"E\", \"F\", \"F#\", \"Gb\", \"G\", \"Ab\", \"A\", \"Bb\", \"B\", \"Cb\"");
			Scanner userInput = new Scanner(System.in);
			String newNote;
			newNote = userInput.next();
			checkChordNoteName(newNote);
		}
	}
	
	/* 
	 * The parameters for the following functions should be the note name of the scale (e.g. "C" or "C#" or "Cb")
	 * Parameters will not include double sharps or double flats 
	 * 
	 * Chord
	 * Step 1: Takes tonic note and creates triad with zero accidentals
	 * Step 2: Find amount of half-steps between the tonic and the 3rd and 5th
	 * Step 3: Corrects (or leaves alone) the 3rd and 5th by adding a sharp, double sharp, flat, or double flat
	 */

	public static String createMajorChord(String tonicNoteName) {
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		//remove accidental from tonicNoteName
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		int thirdOfChord, fifthOfChord;
		thirdOfChord = rootIndex + 2;
		thirdOfChord = octaveCheck7(thirdOfChord);
		fifthOfChord = rootIndex + 4;
		fifthOfChord = octaveCheck7(fifthOfChord);
		String[] chordBase = {noAccidentalNotes[rootIndex], noAccidentalNotes[thirdOfChord], noAccidentalNotes[fifthOfChord]};

		chordNotes[0] = tonicNoteName;
		chordNotes[1] = pickAccidentalv2(tonicNoteName, chordBase[1], 4);
		chordNotes[2] = pickAccidentalv2(tonicNoteName, chordBase[2], 7);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(chordNotes[i]);
		}
		
		return chordNotes[0];
	}
	
	public static void createMinorChord(String tonicNoteName) {
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		//remove accidental from tonicNoteName
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		int thirdOfChord;
		int fifthOfChord;
		thirdOfChord = rootIndex + 2;
		thirdOfChord = octaveCheck7(thirdOfChord);
		fifthOfChord = rootIndex + 4;
		fifthOfChord = octaveCheck7(fifthOfChord);
		String[] chordBase = {noAccidentalNotes[rootIndex], noAccidentalNotes[thirdOfChord], noAccidentalNotes[fifthOfChord]};

		chordNotes[0] = tonicNoteName;
		chordNotes[1] = pickAccidentalv2(tonicNoteName, chordBase[1], 3);
		chordNotes[2] = pickAccidentalv2(tonicNoteName, chordBase[2], 7);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(chordNotes[i]);
		}
	}
	
	// Not fully functional (needs to incorporate double sharps for a few chords)
	public static void createAugmentedChord(String tonicNoteName) {
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		//remove accidental from tonicNoteName
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		int thirdOfChord;
		int fifthOfChord;
		thirdOfChord = rootIndex + 2;
		thirdOfChord = octaveCheck7(thirdOfChord);
		fifthOfChord = rootIndex + 4;
		fifthOfChord = octaveCheck7(fifthOfChord);
		String[] chordBase = {noAccidentalNotes[rootIndex], noAccidentalNotes[thirdOfChord], noAccidentalNotes[fifthOfChord]};

		chordNotes[0] = tonicNoteName;
		chordNotes[1] = pickAccidentalv2(tonicNoteName, chordBase[1], 4);
		chordNotes[2] = pickAccidentalv2(tonicNoteName, chordBase[2], 8);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(chordNotes[i]);
		}
	}
	//Not fully functional (needs to incorporate double flats for a few chords)
	public static void createDiminishedChord(String tonicNoteName) {
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		//remove accidental from tonicNoteName
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		int thirdOfChord;
		int fifthOfChord;
		thirdOfChord = rootIndex + 2;
		thirdOfChord = octaveCheck7(thirdOfChord);
		fifthOfChord = rootIndex + 4;
		fifthOfChord = octaveCheck7(fifthOfChord);
		String[] chordBase = {noAccidentalNotes[rootIndex], noAccidentalNotes[thirdOfChord], noAccidentalNotes[fifthOfChord]};

		chordNotes[0] = tonicNoteName;
		chordNotes[1] = pickAccidentalv2(tonicNoteName, chordBase[1], 3);
		chordNotes[2] = pickAccidentalv2(tonicNoteName, chordBase[2], 6);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(chordNotes[i]);
		}
	}
	
	public static int octaveCheck12(int var) {
		if(var >= 12) {
			var = var - 12;
		}
		return var;
	}
	
	public static int octaveCheck7(int var) {
		if(var >= 7) {
			var = var - 7;
		}
		return var;
	}
	
	public static String pickAccidentalv2(String tonicNoteName, String secondNoteName, int interval) {		// interval is in half-steps

		
		int secondNoteIndex = -1;
		for(int i=0; i<12; i++) {
			for(int j=0; j<3; j++) {				
				if(notes[i][j].equals(tonicNoteName)) {
					secondNoteIndex = i + interval;
					secondNoteIndex = octaveCheck12(secondNoteIndex);							
				}
			}
		}
		for(int k=0; k<3; k++) {
			if(notes[secondNoteIndex][k].contains(secondNoteName)) {
				return notes[secondNoteIndex][k];
			}
		}
		return "Error with pickAccidentalv2";
	}
}
