package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> soundexMap = new HashMap<>();

    static {
        initializeSoundexMap();
    }

    private static void initializeSoundexMap() {
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
        if (isNullOrEmpty(name)) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));

        processCharacters(name, soundex);

        padWithZeros(soundex);

        return soundex.toString();
    }

    private static boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private static void processCharacters(String name, StringBuilder soundex) {
        char prevCode = getSoundexCode(name.charAt(0));

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char currentCode = getSoundexCode(name.charAt(i));
            if (shouldAppendCode(currentCode, prevCode)) {
                soundex.append(currentCode);
                prevCode = currentCode;
            }
        }
    }

    private static boolean shouldAppendCode(char currentCode, char prevCode) {
        return currentCode != '0' && currentCode != prevCode;
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
