public class _657_RobotReturnTo_Origin {

    // Copy and Paste in Solution Class in Leetcode


    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'R'){
                y++;
            } else if(moves.charAt(i) == 'L'){
                y--;
            } else if(moves.charAt(i) == 'U'){
                x++;
            } else{
                x--;
            }
        }
        if(x == 0 && y == 0) return true;
        return false;
    }
}
