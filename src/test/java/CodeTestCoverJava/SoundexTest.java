package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

    @Test
    void testBasicNames() {
        assertEquals("A123", Soundex.generateSoundex("Ashcraft"));
        assertEquals("B652", Soundex.generateSoundex("Bartosz"));
    }

    @Test
    void testEdgeCases() {
        assertEquals("", Soundex.generateSoundex(null));
        assertEquals("", Soundex.generateSoundex(""));
        assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    void testComplexNames() {
        assertEquals("H452", Soundex.generateSoundex("Hemingway"));
        assertEquals("L000", Soundex.generateSoundex("Lee"));
    }

    @Test
    void testNamesWithSimilarSoundingConsonants() {
        assertEquals("T522", Soundex.generateSoundex("Thompson"));
        assertEquals("P532", Soundex.generateSoundex("Peterson"));
    }

    @Test
    void testNamesWithHWSeparatingSameSoundingConsonants() {
        assertEquals("W252", Soundex.generateSoundex("Wright"));
        assertEquals("P530", Soundex.generateSoundex("Pfister"));
    }
}
