import java.util.ArrayList;
import java.util.List;

public class CryptoCollapz {
    public static void main(String[] args) {
        int[] test = { 6, 7, 8, 9, 10};
        System.out.println(solution(test).toString());
    }
    public static List<Integer> solution (int[] input){
        List<Integer> returnList = new ArrayList<>();
        for(int current:input){
            returnList.add(solution_helper(current,4));
        }
        return returnList;
    }
    public static int solution_helper(int input,int max){
        if(max<input){
            max=input;
        }
        if(input==2){
            return max;
        }
        int curr;
        if(input%2==0){
            curr = solution_helper(input/2,max);
            max = Math.max(curr, max);
        } else {
            curr  = solution_helper(input*3+1,max);
            max = Math.max(curr, max);

        }
        return max;
    }
}
