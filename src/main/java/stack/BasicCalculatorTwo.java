package stack;

import java.util.Stack;

public class BasicCalculatorTwo {
    public int calculate(String s) {

        int ans = 0;

        if(s==null || s.length()==0) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        // sign is used to store the previous operator, for initialization, we can assume
        // There is a '+' before the expression
        char sign = '+';
        int i =0;

        while(i<s.length()) {

            if(s.charAt(i)==' ') {
                i++;
                continue;
            }

            // store current number
            int number = 0;

            while(i<s.length() && Character.isDigit(s.charAt(i))) {
                number = number*10+ (int)(s.charAt(i)-'0');
                i++;
            }

            // This sign is previous sign
            if(sign=='+') {
                stack.push(number);

            } else if(sign=='-') {
                stack.push(-number);

            } else if(sign=='*') {
                stack.push(stack.pop()*number);

            } else if(sign=='/'){
                stack.push(stack.pop()/number);
            }

            if(i==s.length()) {
                break;
            } else {
                sign = s.charAt(i);
            }

            i++;

        }

        for(Integer cur: stack) {
            ans+=cur;
        }

        return ans;

    }
}