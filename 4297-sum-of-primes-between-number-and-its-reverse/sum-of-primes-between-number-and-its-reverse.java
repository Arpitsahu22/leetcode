class Solution {
    public boolean isprime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        int safe=n;
        int rev=0;
        while(safe!=0){
            rev=rev*10+(safe%10);
            safe/=10;
        }
        if(n>rev){
            int temp=n;
            n=rev;
            rev=temp;
        }
        int sum=0;
        for(int i=n;i<=rev;i++){
            if(isprime(i)){
                sum+=i;
            }
        }
        return sum;
    }
}