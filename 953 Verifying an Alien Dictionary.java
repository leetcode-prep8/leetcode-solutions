class Solution {
    public class AlienComparator implements Comparator<String> {
        int[] order;

        public AlienComparator(String order) {
            this.order = new int[26];
            for (int i = 0; i < 26; i++) {
                this.order[order.charAt(i) - 97] = i;
            }
        }

        public int compare(String a, String b) {
            int maxIndex = Math.min(a.length(), b.length());
            for (int i = 0; i < maxIndex; i++) {
                int aOrder = order[a.charAt(i) - 97];
                int bOrder = order[b.charAt(i) - 97];
                if (aOrder == bOrder)
                    continue;
                if (aOrder < bOrder)
                    return -1;
                else {
                    return 1;
                }
            }
            if (a.length() > b.length())
                return 1;
            return -1;
        }
    }

    public boolean isAlienSorted(String[] words, String order) {

        String prev = words[0];
        AlienComparator comparator = new AlienComparator(order);
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            if (comparator.compare(prev, curr) > 0)
                return false;
            prev = curr;
        }
        return true;

        // custom comparator should implements comparator<T>
    }
}