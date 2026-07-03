class Solution {
    public boolean detectCapitalUse(String word) {
        int n=word.length();
        int c=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='A' && ch<='Z'){
                c++;
            }
        }
        if(c==n){
            return true;
        }
        if(c==0){
            return true;
        }
        if(c==1 && word.charAt(0)>='A' && word.charAt(0)<='Z'){
            return true;
        }
        return false;
    }
}