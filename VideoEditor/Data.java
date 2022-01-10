import java.util.Arrays;
import java.util.UUID;

public class Data {
    public static final int MAX_COUNT = 5;
    public Video[] datas;

    public Data() {
        datas = new Video[MAX_COUNT];
        for (int idx = 0; idx < MAX_COUNT; ++idx) {
            datas[idx] = new Video((char) ('a' + idx) + "", "제목" + idx);
        }
    }

    public Video[] getDatas() {
        return datas;
    }

    public void setDatas(Video[] datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Data{" +
                "datas=" + Arrays.toString(datas) +
                '}';
    }
}
