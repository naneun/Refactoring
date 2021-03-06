import java.util.Arrays;

public class Converter {
    private Adder adder = new Adder();

    private boolean[] dec2bin(int decimal) {
        int bit = 1, len = 0;
        while (bit < decimal) {
            bit <<= 1;
            ++len;
        }
        boolean[] answer = new boolean[len];
        for (int idx = 0; idx < len; ++idx) {
            answer[idx] = (decimal & 1) == 1;
            decimal >>= 1;
        }
        return answer;
    }

    private int bin2dec(boolean[] bin) {
        int answer = 0;
        int len = bin.length;
        for (int idx = 0; idx < len; ++idx) {
            answer |= (bin[idx] ? 1 : 0) << idx;
        }
        return answer;
    }

    private char dec2char(int decimal) {
        char ret = '0';
        if (decimal > 9) {
            ret = (char)('A' - 10);
        }
        return ret += decimal;
    }
    private String dec2hex(int dec1, int dec2) {
        boolean[] binA = dec2bin(dec1);
        boolean[] binB = dec2bin(dec2);
        boolean[] res = adder.byteAdder(binA, binB);
        int val = 1, len = res.length, ret = 0;
        StringBuffer sb = new StringBuffer();
        for (int idx = 0; idx < len; ++idx) {
            ret += (res[idx] ? 1 : 0) * val;
            val <<= 1;
            if (val > (1 << 3)) {
                val = 1;
                sb.append(dec2char(ret));
                ret = 0;
            }
        }
        sb.append(dec2char(ret));
        return sb.toString();
    }
}
