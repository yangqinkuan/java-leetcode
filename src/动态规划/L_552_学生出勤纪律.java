package 动态规划;

public class L_552_学生出勤纪律 {
    public static void main(String[] args) {
        checkRecord(10);
    }

    public static int checkRecord(int n) {
        long[][][] dp = new long[2][3][n+1];//dp[i][j][k] 表示有i个A,结尾是连续j个L,长度为k的字符串所代表的组合数
        dp[0][0][1] = 1;
        dp[1][0][1] = 1;
        dp[0][1][1] = 1;
        long mod = 1000000007;
        for(int len=1;len<=n-1;len++){
            // P
            dp[0][0][len+1] = (dp[0][0][len]+dp[0][1][len]+dp[1][0][len]+dp[1][1][len]+dp[1][2][len]+dp[0][2][len])%mod;
            // A
            dp[1][0][len+1] += dp[0][0][len]%mod;
            dp[1][1][len+1] += dp[0][1][len]%mod;
            dp[1][2][len+1] += dp[0][2][len]%mod;
            //L
            dp[0][1][len+1] += dp[0][0][len]%mod;
            dp[0][2][len+1] += dp[0][1][len]%mod;
            dp[1][1][len+1] += dp[1][0][len]%mod;
            dp[1][2][len+1] += dp[1][1][len]%mod;

        }
        return (int)((dp[0][0][n]+dp[0][1][n]+dp[1][0][n]+dp[1][1][n]+dp[1][2][n]+dp[0][2][n])%mod);
    }
}
