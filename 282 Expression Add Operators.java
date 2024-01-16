class Solution {
    List<String> res = new ArrayList<>();

    private void recurse(String num, int target, int index, StringBuilder sb, long eval, long prevVal) {
        if (index == num.length()) {
            if (target == eval)
                res.add(sb.toString());
            return;
        }
        for (int i = index; i < num.length(); i++) { // cont, +-*
            if (num.charAt(index) == '0' && i != index)
                break;
            long currNum = Long.parseLong(num.substring(index, i + 1));
            int len = sb.length();
            if (index == 0) {
                recurse(num, target, i + 1, sb.append(currNum), currNum, currNum);
                sb.setLength(len);
            } else {
                recurse(num, target, i + 1, sb.append("+" + currNum), eval + currNum, currNum);
                sb.setLength(len);
                recurse(num, target, i + 1, sb.append("-" + currNum), eval - currNum, -currNum);
                sb.setLength(len);
                recurse(num, target, i + 1, sb.append("*" + currNum), eval - prevVal + prevVal * currNum,
                        prevVal * currNum);
                sb.setLength(len);
            }
        }

    }

    public List<String> addOperators(String num, int target) {
        recurse(num, target, 0, new StringBuilder(), 0, 0);
        return res;
    }
}