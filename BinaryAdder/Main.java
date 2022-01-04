public class Main {
    public static void main(String[] args) {
        DigitalLogic dl = new DigitalLogic();
        dl.showResult(false, false);
        dl.showResult(false, true);
        dl.showResult(true, false);
        dl.showResult(true, true);

        Adder adder = new Adder();
        adder.showHalfAdder(true, true);
        adder.showHalfAdder(true, false);
        adder.showFullAdder(true, true, true);
        adder.showFullAdder(true, false, true);

        adder.showByteAdder(
                new boolean[] { true, true, false, true }
                , new boolean[] { true, false, true, true });

        adder.showByteAdder(
                new boolean[] { true, true, false, false, true, false, true, false, true, true, false, false, true, false, true, false }
                , new boolean[] { true, true, false, true, true, false, false, true, true, true, false, true, true, false, false, true });

        Converter cvt = new Converter();
        cvt.showDec2bin(10);
        cvt.showDec2bin(173);

        cvt.showBin2dec(new boolean[] { false, true, true, true });
        cvt.showBin2dec(new boolean[] { true, true, true, true, false, true, false, true });
        cvt.showDec2hex(7000, 562);
    }
}
