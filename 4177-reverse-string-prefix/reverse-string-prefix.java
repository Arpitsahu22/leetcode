class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = s.toCharArray();

        int i = 0, j = k - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}