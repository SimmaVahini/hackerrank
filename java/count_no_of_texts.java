class Solution {
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long mod = 1_000_000_007;
        
        // dp[i] stores the number of ways to decode the first i characters
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: 1 way to decode an empty string
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Case: Single press (always possible)
            
            char ch = pressedKeys.charAt(i - 1);
            int maxPress = (ch == '7' || ch == '9') ? 4 : 3;
            
            // Check for sequences of 2, 3, or 4 identical characters
            for (int k = 2; k <= maxPress && i - k >= 0; k++) {
                if (pressedKeys.charAt(i - k) == ch) {
                    dp[i] = (dp[i] + dp[i - k]) % mod;
                } else {
                    break; // Stop if the sequence is broken
                }
            }
        }
        
        return (int) dp[n];
    }
}
