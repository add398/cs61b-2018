import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.


    @Test
    public void testIsPalindrome0() {
        boolean a = palindrome.isPalindrome("noon");
        boolean b = palindrome.isPalindrome("dasnjdnajsd");
        assertTrue(a);
        assertFalse(b);

    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("aaccbbbccaa"));

        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("ababba"));
    }








}
