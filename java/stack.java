import java.util.*;

class stack {
    
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input));
        }
        sc.close();
    }
    
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            
            else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
