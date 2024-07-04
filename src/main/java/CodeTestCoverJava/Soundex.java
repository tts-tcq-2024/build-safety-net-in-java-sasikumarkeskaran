package CodeTestCoverJava;

public class Soundex {
    private static final int[] ALPHA_MAPPING = {
        0, 1, 2, 3, 0, 1, 2, 0, 0, 2,
        2, 4, 5, 5, 0, 1, 2, 6, 2, 3,
        0, 1, 0, 2, 0, 2
    };

    private static char getSoundexCode(char c) {
        c = Character.toUpperCase(c);
        if (c < 'A' || c > 'Z') {
            return '0';
        }
        return (char) (ALPHA_MAPPING[c - 'A'] + '0');
    }

    private static void appendSoundexCode(char code, StringBuilder soundex) {
        if (code != '0' && code != soundex.charAt(soundex.length() - 1)) {
            soundex.append(code);
        }
    }

    private static void finalizeSoundex(StringBuilder soundex) {
        while (soundex.length() < 4) {
            soundex.append('0');
        }
        if (soundex.length() > 4) {
            soundex.setLength(4);
        }
    }

    private static void initializeSoundex(String name, StringBuilder soundex) {
        soundex.append(Character.toUpperCase(name.charAt(0)));
    }

    private static void processName(String name, StringBuilder soundex) {
        int len = name.length();
        for (int i = 1; i < len && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            appendSoundexCode(code, soundex);
        }
    }

public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "0000";
        }

        StringBuilder soundex = new StringBuilder();
        initializeSoundex(name, soundex);
        processName(name, soundex);
        finalizeSoundex(soundex);
        return soundex.toString();
    }
}
