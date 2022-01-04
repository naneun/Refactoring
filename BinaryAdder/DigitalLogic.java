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
}
