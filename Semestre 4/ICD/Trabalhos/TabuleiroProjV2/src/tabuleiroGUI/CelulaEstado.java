package tabuleiroGUI;

public class CelulaEstado {
	public final static int LIVRE 	= 0;
	//Estados para o tabuleiro da Batalha Naval
	public final static int BARCO 	= 1;
	public final static int AGUA 	= 2;
	public final static int TIRO 	= 3;
	public final static int FUNDO 	= 4;
	//Estados para o tabuleiro do 4 em linha
	public final static int JOG1 	= 5;
	public final static int JOG2 	= 6;
	
	public static String decodeEstadoString(int e) {
		switch (e) {
		case LIVRE: return ".";
		case BARCO: return "O";
		case AGUA: return "~";
		case TIRO: return "X";
		case FUNDO: return "+";
		case JOG1: return "1";
		case JOG2: return "2";
		default: 	return "?";
		}
	}
	public static int encodeEstadoString(String e) {
		switch (e) {
		case ".": return LIVRE;
		case "O": return BARCO;
		case "~": return AGUA;
		case "X": return TIRO;
		case "+": return FUNDO;
		case "1": return JOG1;
		case "2": return JOG2;
		default: 	return -1;
		}
	}
	
	//Converter coordenada de inteiro para letra
	public static String encodeCoordIntChar(int coord) {
		return String.valueOf((char)('A' + coord));
	}
	//Converter coordenada de letra para inteiro
	public static int decodeCoordIntChar(String coord) {
		return  coord.charAt(0) - 'A';
	}
}
