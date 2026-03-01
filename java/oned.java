import java.util.*;

public class oned {

    public static boolean canWin(int leap, int[] game) {
        return canWinFrom(0, leap, game);
    }

    private static boolean canWinFrom(int position, int leap, int[] game) {
        
        if (position >= game.length) {
            return true;
        }

        
        if (position < 0 || game[position] == 1) {
            return false;
        }

    
        game[position] = 1;

        
        if (canWinFrom(position + leap, leap, game)) {
            return true;
        }

        
        if (canWinFrom(position + 1, leap, game)) {
            return true;
        }

    
        if (canWinFrom(position - 1, leap, game)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
