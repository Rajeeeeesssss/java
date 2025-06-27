class Palindrome {
    int ispalindrome(String S){
        String reverse ="";
        for (int i=S.length()-1;i>=0;i--){
        reverse = reverse+S.charAt(i);    
        }
        if (S.equals(reverse))
        return 1;
        else 
         return 0;
    }
    

public static void main ( String [] args ){
    Palindrome p = new Palindrome();
    String teaString = "madam";
    if (p.ispalindrome(teaString)==1){
        System.out.println("is p");
    } else {
        System.out.println(" not");
    }
  }
}
