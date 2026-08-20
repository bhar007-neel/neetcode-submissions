class Solution {
    public boolean isPalindrome(String s) {
        String newString ="";
        for(int i =0; i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                newString = newString  + s.charAt(i);
            }
        }
        newString = newString.toLowerCase();
        for(int i =0; i< newString.length()/2;i++){
            if(newString.charAt(i)!=newString.charAt(newString.length()-i-1)){
                return false;
            }

        }
        return true;
    }
}
