import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class class211 {

    static int[][] directions = new int[128][128];

    static int[][] distances = new int[128][128];

    static int[] bufferX = new int[4096];

    static int[] bufferY = new int[4096];

    public static class133 method1180(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
        boolean var4 = true;
        byte[] var5 = var0.getFile(var2 >> 16 & '\uffff', var2 & '\uffff');
        if (var5 == null) {
            var4 = false;
            return null;
        } else {
            int var6 = (var5[1] & 255) << 8 | var5[2] & 255;
            byte[] var7;
            if (var3) {
                var7 = var1.getFile(0, var6);
            } else {
                var7 = var1.getFile(var6, 0);
            }

            if (var7 == null) {
                var4 = false;
            }

            if (!var4) {
                return null;
            } else {
                if (class374.field3598 == null) {
                    class133.field1283 = Runtime.getRuntime().availableProcessors();
                    class374.field3598 = new ThreadPoolExecutor(0, class133.field1283, 0L, TimeUnit.MILLISECONDS,
                            new ArrayBlockingQueue(class133.field1283 * 100 + 100), new class130());
                }

                try {
                    return new class133(var0, var1, var2, var3);
                } catch (Exception var9) {
                    return null;
                }
            }
        }
    }
}
