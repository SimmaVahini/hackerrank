class Solution {
    public int buttonWithLongestTime(int[][] events) {
        // The time for the first button is simply its timestamp
        int longestIndex = events[0][0];
        int maxDuration = events[0][1];
        
        // Iterate through the remaining events
        for (int i = 1; i < events.length; i++) {
            int currentIndex = events[i][0];
            int currentTime = events[i][1];
            int prevTime = events[i - 1][1];
            
            // Calculate time taken for this button push
            int duration = currentTime - prevTime;
            
            // Update if we find a longer duration, or a tie with a smaller index
            if (duration > maxDuration) {
                maxDuration = duration;
                longestIndex = currentIndex;
            } else if (duration == maxDuration) {
                if (currentIndex < longestIndex) {
                    longestIndex = currentIndex;
                }
            }
        }
        
        return longestIndex;
    }
}
