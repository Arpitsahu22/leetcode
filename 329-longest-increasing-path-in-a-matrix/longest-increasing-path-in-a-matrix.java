class Solution {

     class Tuple{
        int value;
        int x;
        int y;

        Tuple(int value, int x, int y){
            this.x=x;
            this.y=y;
            this.value = value;

        }
        
    }
    public int longestIncreasingPath(int[][] matrix) {


        List<Tuple>list = new ArrayList<>();
        for(int i = 0; i <matrix.length;i++){
            for(int j = 0; j<matrix[0].length; j++){
                int curr = matrix[i][j];
                Tuple temp = new Tuple(curr,i,j);
                list.add(temp);
            }
        }
        ////arrow function, comparable, comparator
        list.sort((a,b) -> Integer.compare(a.value,b.value));

        int[][] dp = new int[matrix.length][matrix[0].length];

        int ans = 0;

        for(Tuple curr : list){
            int value = curr.value;
            int x = curr.x;
            int y = curr.y;

            dp[x][y] = 1;

            if(x > 0 && matrix[x-1][y] < value){
                dp[x][y] = Math.max(dp[x][y],dp[x-1][y] + 1);
            }

            if(x < matrix.length-1 && matrix[x+1][y] < value){
                dp[x][y] = Math.max(dp[x][y],dp[x+1][y] + 1);
            }

            if(y > 0 && matrix[x][y-1] < value){
                dp[x][y] = Math.max(dp[x][y],dp[x][y-1] + 1);
            }

            if(y < matrix[0].length-1 && matrix[x][y+1] < value){
                dp[x][y] = Math.max(dp[x][y],dp[x][y+1] + 1);
            }

            ans = Math.max(ans,dp[x][y]);
        }

        return ans;
    }
}