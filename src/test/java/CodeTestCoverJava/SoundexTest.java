package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class SoundexTest {


 @Test
    public void testNames() {
        assertTrue("case 1", Soundex.generateSoundex("Ashcraft").equals("A261"));
        assertTrue("case 2", Soundex.generateSoundex("Rubin").equals("R150"));
    }

@Test
    public void testComplexNames() {
        assertTrue("case 3", Soundex.generateSoundex("Honeyman").equals("H555"));
        assertTrue("case 4", Soundex.generateSoundex("Pfister").equals("P236"));
    }

  
}
