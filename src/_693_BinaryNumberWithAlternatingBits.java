public class _693_BinaryNumberWithAlternatingBits {

    // Copy and Paste in Solution Class in Leetcode


    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}
