package DP;

import java.util.Arrays;

//using dp, top down
public class LongestCommonSubsequenceUsingDP {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));
        //System.out.println(longestCommonSubsequence(text1, text2));

    }

    //using dynamic programming
    //Time Complexity: O(m * n) which is much better than the worst-case time complexity of Naive Recursive implementation.
    //Auxiliary Space: O(m * n) because the algorithm uses an array of size (m+1)*(n+1) to store the length of the common substrings.
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        return lcs(n1, n2, text1, text2, dp);
    }

    public static int lcs(int n1, int n2, String str1, String str2, int[][] dp) {

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];

    }

    //using Memoization
    //Time Complexity: O(m * n) where m and n are the string lengths.
    //Auxiliary Space: O(m * n) here the recursive stack space is ignored.
    /*public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i = 0; i < n1 + 1; i++){
            for(int j = 0;j < n2 + 1; j++){
                dp[i][j] = -1;
            }
        }

        return lcs(n1, n2, text1, text2, dp);
    }

    public static int lcs(int n1, int n2, String str1, String str2, int[][] dp) {

        if(n1 == 0 || n2 == 0) {
            return 0;
        }

        if(dp[n1][n2] != -1) {
            return dp[n1][n2];
        }

        if(str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
            dp[n1][n2] = 1 + lcs(n1 - 1, n2 - 1, str1, str2, dp);
        }
        else {
            dp[n1][n2] = Math.max(lcs(n1 - 1, n2, str1, str2, dp), lcs(n1, n2 - 1, str1, str2, dp));
        }

        return dp[n1][n2];

    }*/


    //Using Recursion
    //Time Complexity: O(2^n)
    //Auxiliary Space: O(1)
    /*public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        return lcs(n1, n2, text1, text2);

    }

    public static int lcs(int n1, int n2, String str1, String str2) {

        if(n1 == 0 || n2 == 0) {
            return 0;
        }

        if(str1.charAt(n1-1) == str2.charAt(n2-1)) {
            return 1 + lcs(n1 - 1, n2 - 1, str1, str2);
        }
        else {
            return Math.max(lcs(n1 - 1, n2, str1, str2), lcs(n1, n2 - 1, str1, str2));
        }
    }*/
}
