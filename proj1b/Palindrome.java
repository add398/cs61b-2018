public class Palindrome {
    //Palindrome.java: A class for palindrome operations.
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        if (word == null){
            return true;
        }
        int len = word.length();
        if (len <= 1){
            return true;
        }
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)){
                return false;
            }
        }
        return true;
    }


    /** overloaded isPalindrome, decide if the given word is palindrome.
     * according to the given CharacterComparator
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }


}
