class Solution {
    public String rearrangeString(String s, char x, char y) {
        char ch[] = s.toCharArray();
        int i = 0, j = ch.length - 1;

        while (i < j) {
            if (ch[i] == x && ch[j] == y) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            } else if (ch[i] == x && ch[j] != y) {
                j--;
            } else if (ch[i] != x && ch[j] == y) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return new String(ch);
    }
}