public class DigitalLogic {
    public boolean AND(boolean bitA, boolean bitB) { return bitA && bitB; }
    public boolean OR(boolean bitA, boolean bitB) {
        return bitA || bitB;
    }
    public boolean NOT(boolean bitA) {
        return !bitA;
    }
    public boolean NAND(boolean bitA, boolean bitB) {
        return !(bitA && bitB);
    }
    public boolean NOR(boolean bitA, boolean bitB) {
        return !(bitA || bitB);
    }
    public boolean XOR(boolean bitA, boolean bitB) {
        return !(bitA && bitB) && (bitA || bitB);
    }

    public void showResult(boolean bitA, boolean bitB) {
        System.out.println("bitA is " + bitA + " and bitB is " + bitB);
        System.out.println("bitA AND bitB: " + AND(bitA, bitB));
        System.out.println("bitA OR bitB: " + OR(bitA, bitB));
        System.out.println("NOT bitA: " + NOT(bitA));
        System.out.println("bitA NAND bitB: " + NAND(bitA, bitB));
        System.out.println("bitA NOR bitB: " + NOR(bitA, bitB));
        System.out.println("bitA XOR bitB: " + XOR(bitA, bitB));
        System.out.println();
    }
}
