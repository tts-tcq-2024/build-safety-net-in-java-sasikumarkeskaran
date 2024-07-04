
package CodeTestCoverJava;
public class Soundex {
      public static String getSoundexCode(char c) {
        c = Character.toUpperCase(c);

        int ans = 0;

        ans = getMatchingSoundexNumericalDigit((c == 'B' || c == 'F' || c == 'P' || c == 'V'), ans, 1);
        ans = getMatchingSoundexNumericalDigit((c == 'C' || c == 'G' || c == 'J' || c == 'K' || c == 'Q' || c == 'S' || c == 'X' || c == 'Z'), ans, 2);
        ans = getMatchingSoundexNumericalDigit((c == 'D' || c == 'T'), ans, 3);
        ans = getMatchingSoundexNumericalDigit((c == 'L'), ans, 4);
        ans = getMatchingSoundexNumericalDigit((c == 'M' || c == 'N'), ans, 5);
        ans = getMatchingSoundexNumericalDigit((c == 'R'), ans, 6);

        return ans == 0 ? '0' : Character.forDigit(ans, 10);
    }
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

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "0000";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));
        int len = name.length();

        for (int i = 1; i < len && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            appendSoundexCode(code, soundex);
        }

        finalizeSoundex(soundex);
        return soundex.toString();
    }

}
