import java.util.Arrays;

public class Adder {
    private DigitalLogic dl = new DigitalLogic();

    private boolean sum(boolean bitA, boolean bitB) {
        return dl.XOR(bitA, bitB);
    }

    private boolean carry(boolean bitA, boolean bitB) {
        return dl.AND(bitA, bitB);
    }

    private boolean[] halfAdder(boolean bitA, boolean bitB) {
        return new boolean[] { carry(bitA, bitB), sum(bitA, bitB) };
    }

    private boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] halfRes = halfAdder(bitA, bitB);
        boolean[] answer = halfAdder(carry, halfRes[1]);
        answer[0] = dl.OR(halfRes[0], answer[0]);
        return answer;
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int len = Math.max(byteA.length, byteB.length);
        boolean[] answer = new boolean[len + 1];
        boolean[] binA = new boolean[len];
        boolean[] binB = new boolean[len];
        System.arraycopy(byteA, 0, binA, 0, byteA.length);
        System.arraycopy(byteB, 0, binB, 0, byteB.length);

        boolean[] res = null;
        boolean carry = false;
        int idx = 0;
        for (; idx < len; ++idx) {
            res = fullAdder(binA[idx], binB[idx], carry);
            answer[idx] = res[1];
            carry = res[0];
        }
        answer[idx] = carry;
        return answer;
    }
}
