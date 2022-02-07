package cs09.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DummyData {
    private static final int MAIN_LOOP = 10;
    private static final int SUB_LOOP = 100_000;

    private static Random random;
    private static FileWriter fw;
    private static BufferedWriter bw;
    private static SimpleDateFormat sdf;

    private enum Nick {
        bangtae, 난정, 도토리, 베니, 지미뉴트론, Hemdi, BB, sonya, Khan, S, 도리, J, Jamie, ver, dony
        , Nick, Millie, Oliver, 이누, otter, 이든, 포키FE, Muffin, 건, 호이, JinJeon, 파크, Janet, 콜라
        , 럼카, 아울, 도비, Maeve, JS, Alan, jinnie, 옐로우, 도트, Jwu, 산토리, Phil, 쿠킴, Meenzino, donggi
        , BC, 땃쥐, 후, 케이, ikjo, zzangmin, Sammy, 노리, JayBE, Miller, Yan, 헤이호, Dave, 선을로, Lucid, Hwi
        , sallyBE, Nathan, Jerry, 피오, 벅픽, Ader, Jun, 포키BE, 데이먼, 루이, Hanse, Lee, 검봉, Tany, 테리, 로니
        , Shine, Riako, 반스, Ebony, Sol, Mase, 주방, bibi, Alex, Shingha, 피그백, Eddy, Selina, Jason, Matthew
        , sallyIOS, Chez, Rosa, Jed, dale, 푸코, Kai, Ocean, Beck, 다마고치, Jee, wooki
        , Josh, 히데, JungPark, JayAND, 스타크, stitch, Andrew, Han, Linus, Funny
    }

    private static String randomString() {
        return random.ints('0','z' + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(4)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String randomDate() {
        return sdf.format(System.currentTimeMillis() - (long) (Math.random() * (long) 30 * 24 * 60 * 60 * 1000 + 1));
    }

    public static void main(String[] args) {
        File file = new File("C:\\dummyData.sql");
        try {
            if (file.createNewFile()) {
                System.out.println("Create dummyData.sql");
            }
            random = new Random();
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            sdf = new SimpleDateFormat("yyyy-MM-dd");

            Nick[] nicks = Nick.values();
            int nicksSize = Nick.values().length;
            bw.write("SET AUTOCOMMIT = FALSE; ");
            for (int i = 0; i < MAIN_LOOP; ++i) {
                bw.write("INSERT user_log VALUES");
                for (int j = 0; j < SUB_LOOP; ++j) {
                    bw.write("('" + nicks[(int) (Math.random() * (nicksSize) - 1)]
                            + randomString()
                            + String.format("%04d", (int) (Math.random() * 10_000))
                            + "', " + ((int) (Math.random() * 10_000) + 1)
                            + ", '" + randomDate() + "')");
                    bw.write(j < SUB_LOOP - 1 ? ", " : "; ");
                }
            }
            bw.write("COMMIT; SET AUTOCOMMIT = TRUE;");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
