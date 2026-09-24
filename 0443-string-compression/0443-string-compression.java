class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < chars.length; i++){
            sb.append(chars[i]);
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < sb.length(); i ++){
            Integer count = 1;
            while(i < sb.length() - 1 && sb.charAt(i) == sb.charAt(i + 1)){
                count ++;
                i++;
            }
            result.append(sb.charAt(i));
            if(count > 1){
                result.append(count);
            }
        }
        for(int i = 0; i < result.length(); i ++){
            chars[i] = result.charAt(i);
        }
        return result.length();
    }
}