import java.util.*;

public class dequeue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            
            deque.addLast(num);

        
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }
            if (deque.size() == m) {
                if (map.size() > maxUnique) {
                    maxUnique = map.size();
                }
            }
        }

        System.out.println(maxUnique);
        sc.close();
    }
}
