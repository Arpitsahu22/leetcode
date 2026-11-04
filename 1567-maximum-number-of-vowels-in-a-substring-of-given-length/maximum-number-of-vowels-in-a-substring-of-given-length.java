class Solution {
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int maxVowel=0;
        int left=0;
        int vowel=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i)))vowel++;
            if((i-left+1) == k){
                maxVowel=Math.max(maxVowel,vowel);
                if(isVowel(s.charAt(left)))vowel--;
                left++;
            }
        }
        return maxVowel;
    }
}