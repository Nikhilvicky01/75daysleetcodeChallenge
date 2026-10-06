class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
       int openb = 0;
       int add = 0;

       for(int i = 0;i < n;i ++){
        if(s.charAt(i) == '('){
            openb ++ ;
        }else{
            if(openb >  0){
                openb --;
            }else{
                add ++ ;
            }
        }
       }
       return add + openb;
    }
}