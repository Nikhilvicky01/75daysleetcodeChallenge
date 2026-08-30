class Solution {
    public boolean rotateString(String s, String goal) {
        int j = 1;
        while(j <= s.length()){
        char arr[] = s.toCharArray();

        char first = arr[0];
        for(int i = 0; i < arr.length - 1; i ++){
            arr[i] = arr[i + 1];

        }
        arr[arr.length - 1] = first;
        String str = new String(arr);
        
        if(str.equals(goal)){
            return true;
        }
        j ++;
        s = str;
        }
        return false ;
    }
}