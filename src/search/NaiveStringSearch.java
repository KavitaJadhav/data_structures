//Time complexity -
// best - O(1)
// Average - O(n)
// worst - O(n)
package search;

public class NaiveStringSearch {
    private static int present(String original, String sub) {
        int matches = 0;
        if (original == null || original.length() == 0)
            return 0;

        for (int j = 0; j < sub.length(); j++) {
            if (original.startsWith(sub)) {
                matches++;
                break;
            }
        }

        matches += present(original.substring(1), sub);
        return matches;
    }

    public static void main(String[] args) {

        System.out.println("Value present in a : " + NaiveStringSearch.present("a", "abc") + " times");
        System.out.println("Value present in aabc : " + NaiveStringSearch.present("aabc", "abc") + " times");
        System.out.println("Value present in ababc : " + NaiveStringSearch.present("ababc", "abc") + " times");
        System.out.println("Value present in abcabc : " + NaiveStringSearch.present("abcabc", "abc") + " times");
        System.out.println("Value present in aababc123abc123 : " + NaiveStringSearch.present("aababc123abc123", "abc") + " times");
    }
}
