import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecureRandomFuture {

    static int selectedSpellFlags;

    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future future;

    SecureRandomFuture() {
        this.future = this.executor.submit(new SecureRandomCallable());
    }

    void shutdown() {
        this.executor.shutdown();
        this.executor = null;
    }

    boolean isDone() {
        return this.future.isDone();
    }

    SecureRandom get() {
        try {
            return (SecureRandom) this.future.get();
        } catch (Exception var4) {
            SecureRandom var3 = new SecureRandom();
            var3.nextInt();
            return var3;
        }
    }

    public static int method457() {
        return ++MouseHandler.MouseHandler_idleCycles - 1;
    }

    public static String method458(CharSequence var0) {
        String var1 = FloorUnderlayDefinition.base37DecodeLong(class172.method954(var0));
        if (var1 == null) {
            var1 = "";
        }

        return var1;
    }

    public static int method456(CharSequence var0, int var1, boolean var2) {
        if (var1 >= 2 && var1 <= 36) {
            boolean var3 = false;
            boolean var4 = false;
            int var5 = 0;
            int var6 = var0.length();

            for (int var7 = 0; var7 < var6; ++var7) {
                char var8 = var0.charAt(var7);
                if (var7 == 0) {
                    if (var8 == '-') {
                        var3 = true;
                        continue;
                    }

                    if (var8 == '+') {
                        continue;
                    }
                }

                int var10;
                if (var8 >= '0' && var8 <= '9') {
                    var10 = var8 - 48;
                } else if (var8 >= 'A' && var8 <= 'Z') {
                    var10 = var8 - 55;
                } else {
                    if (var8 < 'a' || var8 > 'z') {
                        throw new NumberFormatException();
                    }

                    var10 = var8 - 87;
                }

                if (var10 >= var1) {
                    throw new NumberFormatException();
                }

                if (var3) {
                    var10 = -var10;
                }

                int var9 = var10 + var5 * var1;
                if (var9 / var1 != var5) {
                    throw new NumberFormatException();
                }

                var5 = var9;
                var4 = true;
            }

            if (!var4) {
                throw new NumberFormatException();
            } else {
                return var5;
            }
        } else {
            throw new IllegalArgumentException("" + var1);
        }
    }
}
