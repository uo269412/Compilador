package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

    public static char lexemeToChar(String text) {
		try {
			if (text.length() == 3) {
				return text.charAt(1);
			} else if (text.length() == 4) {
				if (text.charAt(2) == 'n') {
					return '\n';
				} else {
					return '\t';
				}
			} else {
				int aux = Integer.parseInt(text.substring(2, text.length()-1));
				return (char) aux;
			}

		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return '\0';
	}


	public static double lexemeToReal(String text) {
		try {
			return Double.parseDouble(text);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;

	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
