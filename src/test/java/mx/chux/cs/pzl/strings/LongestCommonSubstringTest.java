package mx.chux.cs.pzl.strings;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LongestCommonSubstringTest {

    LongestCommonSubstring testCase;
    
    @Before
    public void initializeArray() {
        testCase = new LongestCommonSubstring("abbcde");
    }
    
    @Test
    public void nullLCSSTest() {
        assertThat(testCase.apply(null)).isEmpty();
    }
    
    @Test
    public void emptyLCSSTest() {
        assertThat(testCase.apply("")).isEmpty();
    }
    
    @Test
    public void lcssTest() {
        assertThat(testCase.apply("abcd")).isEqualTo("bcd");
        assertThat(testCase.apply("abc")).isEqualTo("ab");
        assertThat(testCase.apply("abe")).isEqualTo("ab");
    }
    
    @Test
    public void complexTest() {
        final LongestCommonSubstring testCase = new LongestCommonSubstring("zxabcdezy");
        assertThat(testCase.apply("yzabcdezx")).isEqualTo("abcdez");
    }
    
}
