package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

    @Test
    void testBasicNames() {
        assertEquals("A261", Soundex.generateSoundex("Ashcraft"));
        assertEquals("R150", Soundex.generateSoundex("Rubin"));
    }

    @Test
    void testEdgeCases() {
        assertEquals("", Soundex.generateSoundex(null));
        assertEquals("", Soundex.generateSoundex(""));
        assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    void testNamesWithHWSeparatingSameSoundingConsonants() {
        assertEquals("H555", Soundex.generateSoundex("Honeyman"));
        assertEquals("P236", Soundex.generateSoundex("Pfister"));
    }
}
