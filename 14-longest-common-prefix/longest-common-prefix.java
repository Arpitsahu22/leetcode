class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = "";

        for (int i = 0; i < strs[0].length(); i++) {
            prefix += strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }

        return prefix;
    }
}