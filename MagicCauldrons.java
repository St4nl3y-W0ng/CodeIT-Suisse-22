
public class MagicCauldrons {
    public static void main(String[] args) {
//        System.out.println(solution_part1(20,1,0,0));
//        System.out.println(solution_part1(23,1,0,0));
//        System.out.println(solution_part2(10,10,0,0));
//        System.out.println(solution_part2(17,34,0,0));
//        System.out.println(solution_part3(30,2,0,0));
//        System.out.println(solution_part3(36,1,0,0));
        System.out.println(solution_part4(50,100,0,0));
        System.out.println(solution_part4(5,20,0,0));
    }
    public static int solution_part1(int flow_Rate,int time, int row, int col){
        int volume = flow_Rate*time;
        int cauldrons_before = (row)*(row+1)/2;
        if(cauldrons_before*100>=volume){
            return 0;
        }
        int remaining_volume = volume - cauldrons_before*100;
        return remaining_volume/(row+1);
    }
    public static int solution_part2(int flow_Rate,int amount_of_soup, int row, int col){
        int cauldrons_before = (row)*(row+1)/2;
        int volume = cauldrons_before*100+(row+1)*amount_of_soup;
        return volume/flow_Rate;
    }
    public static int solution_part3(int flow_Rate,int time, int row, int col){
        int volume = flow_Rate*time;
        int cauldrons_before = (row)*(row+1)/2;

        int[] irregularArr = new int[100];
        for(int i=0;i<irregularArr.length;i++){
            if(i==0){
                irregularArr[i]=0;
            }
            else if(i==1){
                irregularArr[i]=1;
            }
            else if(i%2==0){
                irregularArr[i]=irregularArr[i-1];
            } else {
                irregularArr[i] = irregularArr[i-1]+1;
            }
        }
        int[] cumulative_irregularArr = new int[100];
        for (int i=0;i<cumulative_irregularArr.length;i++){
            if(i==0){
                cumulative_irregularArr[i]=0;
            } else if (i==1){
                cumulative_irregularArr[i]=1;
            } else {
                cumulative_irregularArr[i]=irregularArr[i]+cumulative_irregularArr[i-1];
            }
        }
        int num_irregular = cumulative_irregularArr[row];
        int helper = (cauldrons_before - num_irregular) * 100 + num_irregular * 150;
        if(helper >=volume){
            return 0;
        }
        int remaining_volume = volume - helper;
        return remaining_volume/(row+1);
    }
    public static int solution_part4(int flow_Rate,int amount_of_soup, int row, int col){
        int[] irregularArr = new int[100];
        for(int i=0;i<irregularArr.length;i++){
            if(i==0){
                irregularArr[i]=0;
            }
            else if(i==1){
                irregularArr[i]=1;
            }
            else if(i%2==0){
                irregularArr[i]=irregularArr[i-1];
            } else {
                irregularArr[i] = irregularArr[i-1]+1;
            }
        }
        int[] cumulative_irregularArr = new int[100];
        for (int i=0;i<cumulative_irregularArr.length;i++){
            if(i==0){
                cumulative_irregularArr[i]=0;
            } else if (i==1){
                cumulative_irregularArr[i]=1;
            } else {
                cumulative_irregularArr[i]=irregularArr[i]+cumulative_irregularArr[i-1];
            }
        }
        int cauldrons_before = (row)*(row+1)/2;
        int num_irregular = cumulative_irregularArr[row];
        int volume = (cauldrons_before - num_irregular) * 100 + num_irregular * 150+(row+1)*amount_of_soup;
        return volume/flow_Rate;
    }
}
