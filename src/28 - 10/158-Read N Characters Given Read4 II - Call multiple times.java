/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int lastIndex = 0;
    private int LastCount = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (lastIndex == 0) {
            	LastCount = read4(buff);
            }
            if (LastCount == 0) break;
            while (ptr < n && lastIndex < LastCount) {
                buf[ptr++] = buff[lastIndex++];
            }
            if (lastIndex >= LastCount) lastIndex = 0;
        }
        return ptr;
    }
}