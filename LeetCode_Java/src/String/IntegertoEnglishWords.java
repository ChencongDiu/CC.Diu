package String;

/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegertoEnglishWords {
	private final String space = " ";
    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion"};
    private final String[] TEN = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] ONE_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if (num == 0) {return "Zero";}
        
        int thousand = 0;
        String res = "";
        while (num > 0) {
            if (num % 1000 != 0)
                res = /*(num % 1000 == 0)? "":*/helper(num % 1000) + THOUSAND[thousand] + space + res;
            num /= 1000;
            thousand++;
        }
        return res.trim();
    }
    
    public String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return ONE_TWENTY[num] + space;
        else if (num < 100) 
            return TEN[num / 10] + space + helper(num % 10);
        else {
            return ONE_TWENTY[num / 100] + space + "Hundred" + space + helper(num % 100);
        }
    }
}
