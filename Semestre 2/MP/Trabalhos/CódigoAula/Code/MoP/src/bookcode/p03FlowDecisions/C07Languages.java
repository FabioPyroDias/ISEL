package bookcode.p03FlowDecisions;

/**
 * Enum - is a type with the declared value. Later we will learn enums better
 * 
 */
public class C07Languages {

	// type language and his values
	enum Language
	{
		ENGLISH, GERMAN, FRENCH, PORTUGUESE, SPANISH
	};

	public static void main(String[] args) {

		// one variable of type Language
		Language lang; // initially null

		// initialize with one value of Language type
		lang = Language.ENGLISH;
		// lang = Language.SPANISH;

		// printing one enum value, it prints its name
		System.out.println(lang);

		// enum are very good to be used in switch
		switch (lang) {
		case PORTUGUESE:
			System.out.println("Como estás?");
		case GERMAN:
			System.out.println("Wie geht's?");
			break;
		case FRENCH:
			System.out.println("Comment vas-tu?");
			break;
		case ENGLISH:
		default:
			System.out.println("How are you?");
		case SPANISH:
			System.out.println("¿Cómo estás?");
			break;
		}

		System.out.println("Just asking.....");
	}
}
