package tasks;

public class FindIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        int idx = -1;

        for(int i = 0; i < haystack.length(); i++) {
            if(idx == -1) {
                if(haystack.charAt(i) == needle.charAt(0)) {
                    idx = i;
                }

                continue;
            }

            if(i - idx == needle.length()) {
                break;
            }

            if(haystack.charAt(i) != needle.charAt(i - idx)) {
                idx = -1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        String haystack = "haystack";
        String needle = "stx";

        int idx = new FindIndexOfFirstOccurrenceInString().strStr(haystack, needle);
        System.out.println(idx);
    }
}
