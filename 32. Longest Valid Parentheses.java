/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.  
*/


class Solution {
    public int longestValidParentheses(String s) {
        
        /* Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(-1);
        
        int maxLength = 0;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength,i-stack.peek());
                }
            }
        }
        
        return maxLength; */
        
        
        int left = 0;
        int right = 0;
        
        int maxLength = 0;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                ++left;
            } else {
                ++right;
            }
            
            if(left==right) {
                maxLength= Math.max(2*left,maxLength);
            }
            
            if(right>left) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)=='(') {
                ++left;
            } else {
                ++right;
            }
            
            if(left==right) {
                maxLength= Math.max(2*left,maxLength);
            }
            
            if(right<left) {
                left = 0;
                right = 0;
            }
        }
        
        return maxLength;
        
        
        
    }
}
