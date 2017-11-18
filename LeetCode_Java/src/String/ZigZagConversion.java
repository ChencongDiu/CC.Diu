package String;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
public String convert(String s, int numRows) {
        
        char[] c = s.toCharArray(); //convert String to Char[]
        int len = c.length;
        StringBuffer[] sbSet = new StringBuffer[numRows];
        
        for (int i = 0; i < numRows; i++) {
            sbSet[i] = new StringBuffer();
        }
        
        int i = 0;
        while (i < len) {
            //down
            for (int n = 0; n < numRows && i < len; n++) {
                sbSet[n].append(c[i++]);
            }
            //up
            for (int n = numRows - 2; n > 0 && i < len; n--) {
                sbSet[n].append(c[i++]);
            }
        }
        
        StringBuffer result = new StringBuffer();
        for (int n = 0; n < numRows; n++) {
            result.append(sbSet[n]);
        }
        
        return result.toString();
    }
}
