class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        for (int i = 2; i <= n; i++) {
            String next = "";
            for (int j = 0, k = 0; j < curr.length(); j = k) {
                while (k < curr.length() && curr.charAt(k) == curr.charAt(j))
                    k++;
                next += Integer.toString(k - j) + curr.charAt(j);
            }
            curr = next;
        }
        return curr;
    }
}