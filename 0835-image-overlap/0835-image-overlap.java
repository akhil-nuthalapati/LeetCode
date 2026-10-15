class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int n = a[0].length;
        int maxcount = 0;
        for(int rows_offset = -(n-1) ; rows_offset < n ; rows_offset++)
            {
                for(int cols_offset = -(n-1) ; cols_offset < n ; cols_offset++){
                    int count = 0;
                    for(int i =0 ; i<n ;i++){
                        for(int j=0; j<n ;j++){
                            int x = i+ rows_offset;
                            int y = j+ cols_offset;
                            if(x < 0 || x >= n || y < 0 || y >= n)
                             continue;
                            if(a[i][j] == 1 && b[x][y] == 1)
                             count++;
                        }
                    }
                    maxcount = Math.max(maxcount,count);

                }
            }
return maxcount;
    }
}