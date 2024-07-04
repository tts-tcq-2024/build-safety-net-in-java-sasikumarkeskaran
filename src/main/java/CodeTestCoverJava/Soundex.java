package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> soundexMap = new HashMap<>();

    static {
        soundexMap.put('B', '1');
        soundexMap.put('F', '1');
        soundexMap.put('P', '1');
        soundexMap.put('V', '1');
        soundexMap.put('C', '2');
        soundexMap.put('G', '2');
        soundexMap.put('J', '2');
        soundexMap.put('K', '2');
        soundexMap.put('Q', '2');
        soundexMap.put('S', '2');
        soundexMap.put('X', '2');
        soundexMap.put('Z', '2');
        soundexMap.put('D', '3');
        soundexMap.put('T', '3');
        soundexMap.put('L', '4');
        soundexMap.put('M', '5');
        soundexMap.put('N', '5');
        soundexMap.put('R', '6');
    }

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));

        String encodedName = encodeName(name);
        appendEncodedCharacters(soundex, encodedName);

        padWithZeros(soundex);

        return soundex.toString();
    }

    private static String encodeName(String name) {
        StringBuilder encoded = new StringBuilder();
        char prevCode = getSoundexCode(name.charAt(0));

        for (int i = 1; i < name.length(); i++) {
            char code = getSoundexCode(name.charAt(i));
            if (code != '0' && code != prevCode) {
                encoded.append(code);
                prevCode = code;
            }
        }

        return encoded.toString();
    }

    private static void appendEncodedCharacters(StringBuilder soundex, String encodedName) {
        for (int i = 0; i < encodedName.length() && soundex.length() < 4; i++) {
            soundex.append(encodedName.charAt(i));
        }
    }

    private static void padWithZeros(StringBuilder soundex) {
        while (soundex.length() < 4) {
            soundex.append('0');
        }
    }

    private static char getSoundexCode(char c) {
        c = Character.toUpperCase(c);
        return soundexMap.getOrDefault(c, '0');
    }
}
