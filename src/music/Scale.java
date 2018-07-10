package music;

import java.util.Arrays;
import java.util.Scanner;

public class Scale {

	public static String[][] notes = {{"B#", "C", "Dbb"}, {"Bx", "C#", "Db"}, {"Cx", "D", "Ebb"}, {"D#", "Eb", "Fbb"},
	{"Dx", "E", "Fb"}, {"E#", "F", "Gbb"}, {"Ex", "F#", "Gb"}, {"Fx", "G", "Abb"}, {"G#", "Ab", "Ab"},
	{"Gx", "A", "Bbb"}, {"A#", "Bb", "Cbb"}, {"Ax", "B", "Cb"}};
	
	public static void main(String[] args) {
		
		while(true) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("What is the tonic note of the scale? (Double sharps and double flats will not be accepted)");
			String noteName;
			noteName = userInput.next();
			checkScaleNoteName(noteName);
				
			System.out.println("Is the scale major, minor, or a mode?");
			String scaleType;
			scaleType = userInput.next();
			
			if(scaleType.equals("major")) {
				createMajorScale(noteName);
			} 
			else if(scaleType.equals("minor")) {
				System.out.println("Is the minor scale natural, harmonic, or melodic?");
				String minorType;
				minorType = userInput.next();
				
				if(minorType.equals("natural")) {
					createNaturalMinorChord(noteName);
				}
				else if(minorType.equals("harmonic")) {
					createHarmonicMinorChord(noteName);
				}
				else if(minorType.equals("melodic")) {
					createMelodicMinorChord(noteName);
				}
			}
			else if(scaleType.equals("mode")) {
				System.out.println("Is the modal scale Dorian, Phrygian, Lydian, Mixolydian, or Locrian?");
				String modeType;
				modeType = userInput.next();
				
				if(modeType.equals("Dorian")) {
					createDorianScale(noteName);
				}
				else if(modeType.equals("Phrygian")) {
					createPhrygianScale(noteName);
				}
				else if(modeType.equals("Lydian")) {
					createLydianScale(noteName);
				}
				else if(modeType.equals("Mixolydian")) {
					createMixolydianScale(noteName);
				}
				else if(modeType.equals("Locrian")) {
					createLocrianScale(noteName);
				}
			}
		} 
	}
	
	public static void checkScaleNoteName(String chordNoteName) {
		String possibleNoteNames[] = {"C", "C#", "Db", "D", "Eb", "E", "F", "F#", "Gb", "G", "Ab", "A", "Bb", "B", "Cb"};
		if(!(Arrays.asList(possibleNoteNames).contains(chordNoteName))) {
			System.out.println("Please enter a valid note.");
			System.out.println("Valid notes are: \"C\", \"C#\", \"Db\", \"D\", \"Eb\", \"E\", \"F\", \"F#\", \"Gb\", \"G\", \"Ab\", \"A\", \"Bb\", \"B\", \"Cb\"");
			Scanner userInput = new Scanner(System.in);
			String newNote;
			newNote = userInput.next();
			checkScaleNoteName(newNote);
		}
	}
	
	/*
	 * Major Scale
	 */
	public static String createMajorScale(String tonicNoteName) {
		String[] majorScale = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		majorScale[0] = tonicNoteName;
		majorScale[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2); 
		majorScale[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 4);
		majorScale[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		majorScale[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		majorScale[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 9);
		majorScale[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 11);
		
		for(int i=0; i<7; i++) {
			System.out.println(majorScale[i]);
		}
		
		return "TEMP";
	}
	
	/*
	 * Minor Scales
	 */
	
	public static String createNaturalMinorChord(String tonicNoteName) {
		String[] nMinorScale = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		nMinorScale[0] = tonicNoteName;
		nMinorScale[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		nMinorScale[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3);
		nMinorScale[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		nMinorScale[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		nMinorScale[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 8);
		nMinorScale[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 10);
		
		for(int i=0; i<7; i++) {
			System.out.println(nMinorScale[i]);
		}
		return "TEMP";
	}
	
	public static String createHarmonicMinorChord(String tonicNoteName) {
		String[] hMinorScale = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		hMinorScale[0] = tonicNoteName;
		hMinorScale[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		hMinorScale[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3);
		hMinorScale[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		hMinorScale[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		hMinorScale[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 8);
		hMinorScale[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 11);
		
		for(int i=0; i<7; i++) {
			System.out.println(hMinorScale[i]);
		}
		return "TEMP";
	}
	
	public static String createMelodicMinorChord(String tonicNoteName) {
		String[] mMinorScale = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		mMinorScale[0] = tonicNoteName;
		mMinorScale[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		mMinorScale[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3);
		mMinorScale[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		mMinorScale[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		mMinorScale[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 9);
		mMinorScale[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 11);

		/* descending 
		mMinorScale[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 10);
		mMinorScale[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 8);
		mMinorScale[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		mMinorScale[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		mMinorScale[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3);
		mMinorScale[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		*/
		
		for(int i=0; i<7; i++) {
			System.out.println(mMinorScale[i]);
		}
		return "TEMP";
	}

	/*
	 * Modal Scales
	 */
	
	public static String createDorianScale(String tonicNoteName) {
		String[] dorianMode = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		dorianMode[0] = tonicNoteName;
		dorianMode[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		dorianMode[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3);
		dorianMode[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		dorianMode[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		dorianMode[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 9);
		dorianMode[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 10);
		
		for(int i=0; i<7; i++) {
			System.out.println(dorianMode[i]);
		}
		return "TEMP";
	}
	
	public static String createPhrygianScale(String tonicNoteName) {
		String[] phrygianMode = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		phrygianMode[0] = tonicNoteName;
		phrygianMode[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 1);
		phrygianMode[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3);
		phrygianMode[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		phrygianMode[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		phrygianMode[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 8);
		phrygianMode[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 10);
		
		for(int i=0; i<7; i++) {
			System.out.println(phrygianMode[i]);
		}
		return "TEMP";
	}
	
	public static String createLydianScale(String tonicNoteName) {
		String[] lydianMode = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		lydianMode[0] = tonicNoteName;
		lydianMode[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		lydianMode[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 4); 
		lydianMode[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 6);
		lydianMode[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		lydianMode[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 9);
		lydianMode[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 11);
		
		for(int i=0; i<7; i++) {
			System.out.println(lydianMode[i]);
		}
		return "TEMP";
	}
	
	public static String createMixolydianScale(String tonicNoteName) {
		String[] mixolydianMode = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		mixolydianMode[0] = tonicNoteName;
		mixolydianMode[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 2);
		mixolydianMode[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 4); 
		mixolydianMode[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		mixolydianMode[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 7);
		mixolydianMode[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 9);
		mixolydianMode[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 10);
		
		for(int i=0; i<7; i++) {
			System.out.println(mixolydianMode[i]);
		}
		return "TEMP";
	}
	
	public static String createLocrianScale(String tonicNoteName) {
		String[] locrianMode = new String[7];
		String[] noAccidentalNotes = {"C", "D", "E", "F", "G", "A", "B"};
		String tonicNoteBase = tonicNoteName.substring(0, 1);
		int rootIndex = Arrays.asList(noAccidentalNotes).indexOf(tonicNoteBase);
		
		String[] scaleBase = new String[7];
		scaleBase[0] = tonicNoteName;
		for(int i=1; i<7; i++) {
			int temp = rootIndex + i;
			temp = octaveCheck7(temp);
			scaleBase[i] = noAccidentalNotes[temp];
		}

		locrianMode[0] = tonicNoteName;
		locrianMode[1] = checkMajorAccidental(tonicNoteName, scaleBase[1], 1);
		locrianMode[2] = checkMajorAccidental(tonicNoteName, scaleBase[2], 3); 
		locrianMode[3] = checkMajorAccidental(tonicNoteName, scaleBase[3], 5);
		locrianMode[4] = checkMajorAccidental(tonicNoteName, scaleBase[4], 6);
		locrianMode[5] = checkMajorAccidental(tonicNoteName, scaleBase[5], 8);
		locrianMode[6] = checkMajorAccidental(tonicNoteName, scaleBase[6], 10);
		
		for(int i=0; i<7; i++) {
			System.out.println(locrianMode[i]);
		}
		return "TEMP";
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
	
	public static String checkMajorAccidental(String tonicNoteName, String secondNoteName, int interval) {
		
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
		
		return "TEMP";
	}
	
	/* Chromatic
	 * Pentatonic
	 * Whole-tone
	 * Octatonic
	 */
}
