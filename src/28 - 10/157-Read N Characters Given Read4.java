/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int index = 0;
        
        while(true){
        	int readLen = read4(buffer);
        	int newLen = Math.min(readLen, n - index);
        	for(int i = 0; i < newLen; i++){
        		buf[index + i] = buffer[i];
        	}
        	index += newLen;
        	
        	if(readLen != 4 || index == n) return index;
        }
    }
}