package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> SOUND_CODE_MAP = new HashMap<>();

    static {
        SOUND_CODE_MAP.put('B', '1'); SOUND_CODE_MAP.put('F', '1'); SOUND_CODE_MAP.put('P', '1'); SOUND_CODE_MAP.put('V', '1');
        SOUND_CODE_MAP.put('C', '2'); SOUND_CODE_MAP.put('G', '2'); SOUND_CODE_MAP.put('J', '2'); SOUND_CODE_MAP.put('K', '2');
        SOUND_CODE_MAP.put('Q', '2'); SOUND_CODE_MAP.put('S', '2'); SOUND_CODE_MAP.put('X', '2'); SOUND_CODE_MAP.put('Z', '2');
        SOUND_CODE_MAP.put('D', '3'); SOUND_CODE_MAP.put('T', '3');
        SOUND_CODE_MAP.put('L', '4');
        SOUND_CODE_MAP.put('M', '5'); SOUND_CODE_MAP.put('N', '5');
        SOUND_CODE_MAP.put('R', '6');
    }

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));
        char prevCode = getSoundexCode(name.charAt(0));

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            if (code != '0' && code != prevCode) {
                soundex.append(code);
                prevCode = code;
            }
        }

        while (soundex.length() < 4) {
            soundex.append('0');
        }

        return soundex.toString();
    }

    private static char getSoundexCode(char c) {
        return SOUND_CODE_MAP.getOrDefault(Character.toUpperCase(c), '0');
    }

}
