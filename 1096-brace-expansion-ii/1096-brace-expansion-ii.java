class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = dfs(expression, 0, expression.length() - 1);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    private Set<String> dfs(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");
        int i = l;
        while (i <= r) {
            Set<String> part;
            if (Character.isLetter(s.charAt(i))) {
                part = new HashSet<>();
                part.add(String.valueOf(s.charAt(i)));
                i++;
            }
            else if (s.charAt(i) == '{') {
                int start = i;
                int balance = 0;
                do {
                    if (s.charAt(i) == '{')
                        balance++;
                    else if (s.charAt(i) == '}')
                        balance--;
                    i++;
                } while (balance != 0);
                part = dfs(s, start + 1, i - 2);
            }
            else {
                result.addAll(current);
                current.clear();
                current.add("");
                i++;
                continue;
            }
            Set<String> next = new HashSet<>();
            for (String a : current) {
                for (String b : part) {
                    next.add(a + b);
                }
            }
            current = next;
        }
        result.addAll(current);
        return result;
    }
}