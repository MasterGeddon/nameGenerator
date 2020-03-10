package Generator;

public class NameGenerator {

	String[] namen = { "Carl", "heinz", "frederik", "thomas", "müller" };

	String[] namen_a_m = { "Aaron", "Abdul", "Abel", "Abraham", "Achim", "Adam", "Adolf", "Adreon", "Adrian", "Adriano",
			"Adrien", "Aeneas", "Ahe", "Aheahe", "Aidan", "Aiden", "Aika",

			"Aimo", "Akamai", "Akamu", "Akela", "Aki", "Akoni", "Alain", "Alan", "Alarich", "Albert", "Albrecht",
			"Alec", "Alessandro"

			, "Alessio", "Alex", "Alexander", "Alexej", "Alexis", "Alfons", "Alfred", "Ali", "Alika", "Aljoscha",
			"Allard", "Aloha", "Alois", "Alrik", "Alvaro", "Alwin",

			"Amadeus", "Amandus", "Amaranth", "Amel", "Amelio", "Amir", "Amiran", "Amon", "Anais", "Anakin", "Anders"

			, "Andre", "André", "Andrea", "Andreas", "Andrej", "Andres", "Andrew", "Andrico", "Andrik", "Andy", "Angus",
			"Anian", "Aniani", "Anil", "Annick", "Anno", "Ano",

			"Anouck", "Anouk", "Anselm", "Ansgar", "Anthony", "Antoine", "Anton", "Antonie", "Antonio", "Antonios",
			"Antonius", "Aolani"

			, "Aoloa", "Aouli", "Aragorn", "Aramis", "Arendt", "Ares", "Ari", "Arian", "Ariel", "Arik", "Aris", "Arlan",
			"Arman", "Armand", "Armin", "Arndt", "Arne", "Arnit",

			"Arno", "Arnold", "Aron", "Arthur", "Artur", "Arved", "Arvid", "Arwed", "Asger", "Asmus", "Athan", "Attila",
			"August"

			, "Augustin", "Aurel", "Aurelian", "Aurelius", "Avino", "Axel" };

	public String[] getNamen_a_m() {
		return namen_a_m;
	}

	private int nLang = 4;

	private int anzN = 20;

	String[] vokale = { "a", "ae", "au", "ao", "ai", "ay",

			            "e", "eu", "ei", "ea", "eo", "ey",

			"i", "ie", "iu", "io", "ia", "iy",

			"o", "ou", "oe", "oa", "oy",

			"u", "uo", "ue", "ui",

			"y", "yo", "ya", "ye", "yu", "yi" };

	String[] konsonanten = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w",
			"x", "z",

			"sch", "st", "sp", "ch", "sz", "qu", "tj", "kl", "gh", "pr",

	};

	private String[] fetzWort;

	private String[][] fetzModWort;

	/** normaler aufruf generiert aus vorgegebenen parametern Mehrere Namen **/

	public NameGenerator() {

//ausgabe(generateName(namen_a_m,2)); 

//ausgabe(generate_multipleNames(anzN,nLang,namen_a_m)); 

//ausgabe(fetzen(100)); 

	}

	/** gibt entweder einen namen oder mehrere Namen aus **/

	public NameGenerator(boolean ausgabe) {

		if (ausgabe) {

			ausgabe(generateName(namen_a_m, nLang));

		} else {

			ausgabe(generate_multipleNames(anzN, nLang, namen_a_m));

		}

	}

	/**
	 * gibt entweder einen Namen oder mehrere Namen aus und gibt die länge der namen
	 * an
	 **/

	public NameGenerator(boolean ausgabe, int nameLength) {

		if (ausgabe) {

			ausgabe(generateName(namen_a_m, nameLength));

		}

		else {

			ausgabe(generate_multipleNames(anzN, nameLength, namen_a_m));

		}

	}

	/**
	 * gibt entweder einen Namen oder mehrere Namen aus und gibt sowohl die Länge
	 * als auch eine Namens liste an
	 **/

	public NameGenerator(boolean ausgabe, int nameLength, String[] names) {

		if (ausgabe) {

			ausgabe(generateName(names, nameLength));

		}

		else {

			ausgabe(generate_multipleNames(anzN, nameLength, names));

		}

	}

	/** gibt die anzahl an Namen aus **/

	public NameGenerator(int anzNames) {

		ausgabe(generate_multipleNames(anzNames, nLang, namen_a_m));

	}

	/** gibt die anzahl an Namen aus mit bestimmter namenslänge **/

	public NameGenerator(int anzNames, int nameLength) {

		ausgabe(generate_multipleNames(anzNames, nameLength, namen_a_m));

	}

	/**
	 * gibt die anzahl an namen aus mit bestimmeter namens länge und bestimmter
	 * Namensliste
	 **/

	public NameGenerator(int anzNames, int nameLength, String[] names) {

		ausgabe(generate_multipleNames(anzNames, nameLength, names));

	}

	/** gibt bestimmte anzahl an namen aus mit bestimmter Namensliste **/

	public NameGenerator(int anzNames, String[] names) {

		ausgabe(generate_multipleNames(anzNames, nLang, names));

	}

	/** gibt bestimmte namen aus mit bestimmter namensliste und namenslänge **/

	public NameGenerator(String[] names, int nameLength) {

		ausgabe(generate_multipleNames(anzN, nameLength, names));

	}

	/** gibt anhand der bestimmten namensliste namen aus. **/

	public NameGenerator(String[] names) {

		ausgabe(generate_multipleNames(anzN, nLang, names));

	}

	/**
	 * generiert mehrere Namen anhand vom [anzahlNamen][längederNamen][ListeanNamen]
	 **/

	public String[][] generate_multipleNames(int anzNames, int nameLength, String[] names) {

		String[][] nameList = new String[anzNames][nameLength];

		for (int i = 0; i < anzNames; i++) {

			String[] fullname = generateName(names, nameLength);

			for (int j = 0; j < nameLength; j++) {

				nameList[i][j] = fullname[j];

			}

		}

		return nameList;

	}

	/**
	 * 
	 * generiert einen Namen anhand von einem array aus namen und dessen Namens
	 * länge
	 * 
	 * 
	 * 
	 **/

	public String[] generateName(String[] names, int nameLength) {

		String[] generated = new String[nameLength];

		for (int i = 0; i < nameLength; i++) {

			int ranName = (int) (Math.random() * names.length);

			generated[i] = names[ranName];

		}

		return generated;

	}

	/**
	 * 
	 * gibt einen namen aus benötigt einen String[]
	 * 
	 **/

	public  void ausgabe(String[] genNames) {

		for (String names : genNames) {

			System.out.println(names);

		}

	}

	/**
	 * 
	 * gibt mehrere Namen aus benötigt einen String[][]
	 * 
	 */

	public void ausgabe(String[][] genNames) {

		for (String[] nameList : genNames) {

			String fullName = "";

			for (String names : nameList) {

				fullName = fullName + " " + names;

			}

			System.out.println(fullName + "\n" + "------------" + "\n");

		}

	}

	/**
	 * 
	 * Diese funktion generiert Namen aus buchstaben fetzen auf 5 verschiedene arten
	 * 
	 **/

	public String[] fetzen(int anzFet) {

		String[] fetz = new String[anzFet];

		for (int i = 0; i < anzFet; i++) {

			int modus = (int) (Math.random() * 5) + 1;

			if (modus == 1) {

//voakl + leer 

				fetz[i] = vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())];

				fetz[i] = tallWritten(fetz[i]);

			} else if (modus == 2) {

//leer +vokal 

				fetz[i] = konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())];

				fetz[i] = tallWritten(fetz[i]);

			} else if (modus == 3) {

//leer+vokal+leer 

				fetz[i] = konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())];

				fetz[i] = tallWritten(fetz[i]);

			} else if (modus == 4) {

//vokal+leer+vokal 

				fetz[i] = vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())];

				fetz[i] = tallWritten(fetz[i]);

			} else if (modus == 5) {

//leer 

				fetz[i] = konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())];

				fetz[i] = tallWritten(fetz[i]);

			}

		}

		fetzWort = fetz;

		return fetz;

	}

	/**
	 * 
	 * Dies funktion speichert sowohl die Wort Fetzen als auch deren Modus ab , um
	 * später möglicherweise diese zu größeren wörtern zusammen zu setzen
	 * 
	 */

	public String[][] fetzenWModus(int anzFet) {

		String[][] fetz = new String[anzFet][2];

		for (int i = 0; i < anzFet; i++) {

			int modus = (int) (Math.random() * 5) + 1;

			String mod = modus + "";

			if (modus == 1) {

//voakl + leer 

				fetz[i][0] = mod;

				fetz[i][1] = vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())];

			} else if (modus == 2) {

//leer +vokal 

				fetz[i][0] = mod;

				fetz[i][1] = konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())];

			} else if (modus == 3) {

//leer+vokal+leer 

				fetz[i][0] = mod;

				fetz[i][1] = konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())];

			} else if (modus == 4) {

//vokal+leer+vokal 

				fetz[i][0] = mod;

				fetz[i][1] = vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())];

			} else if (modus == 5) {

//leer+vokal+leer+leer 

				fetz[i][0] = mod;

				fetz[i][1] = konsonanten[(int) (konsonanten.length * Math.random())]
						+ vokale[(int) (vokale.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())]
						+ konsonanten[(int) (konsonanten.length * Math.random())];

			}

		}

		fetzModWort = fetz;

		return fetz;

	}

	/**
	 * 
	 * Diese Funktion schreibt den String als großen Namen
	 * 
	 */

	public String tallWritten(String name) {

		String upperName = "";

		char[] littleName = name.toCharArray();

		if (name.length() <= 0) {
		}

		else {

			littleName[0] = Character.toUpperCase(littleName[0]);

			upperName = String.valueOf(littleName);

		}

		return upperName;

	}

	/*
	 * 
	 * GETTER SETTER
	 * 
	 * 
	 * 
	 */

	public int getnLang() {

		return nLang;

	}

	public void setnLang(int nLang) {

		this.nLang = nLang;

	}

	public int getAnzN() {

		return anzN;

	}

	public void setAnzN(int anzN) {

		this.anzN = anzN;

	}

	public String[] getFetzWort() {

		return fetzWort;

	}

	public void setFetzWort(String[] fetzWort) {

		this.fetzWort = fetzWort;

	}

	public String[][] getFetzModWort() {

		return fetzModWort;

	}

	public void setFetzModWort(String[][] fetzModWort) {

		this.fetzModWort = fetzModWort;

	}

}