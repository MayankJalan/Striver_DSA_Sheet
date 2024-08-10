package Stacks_Queues;

import java.util.Stack;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        outer:
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stk.push(asteroids[i]);
            } else {
                if(stk.peek()<0){
                    stk.push(asteroids[i]);
                    continue outer;
                }
                while (!stk.isEmpty()) {
                    if (Math.abs(asteroids[i]) == stk.peek()) {
                        stk.pop();
                    } else if (Math.abs(asteroids[i]) > stk.peek()) {
                        stk.pop();
                    } else {
                        continue outer;
                    }
                }
                stk.push(asteroids[i]);
            }
        }
        int k = stk.size();
        int[] ans = new int[k--];
        while (!stk.isEmpty()) {
            ans[k--] = stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,-2,-2,-2};
        new AsteroidCollision_735().asteroidCollision(arr);

    }
}
