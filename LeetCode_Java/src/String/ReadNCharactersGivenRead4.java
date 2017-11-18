package String;

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 */
public class ReadNCharactersGivenRead4 {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int read = 0;
        while (true) {
            int curRead = read4(buffer);
            int curReadLength = Math.min(curRead, n - read);
            for (int i = 0; i < curReadLength; i++) {
                buf[read + i] = buffer[i];
            }
            read += curReadLength;
            if (read == n || curReadLength < 4) return read;
        }
    }

    /* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */
	private int read4(char[] buffer) {
		//ignore this part
		return 0;
	}
}
