import java.util.ArrayList;
import java.util.HashMap;

public class ByteArrayPool {

    static int ByteArrayPool_smallCount = 0;

    static int ByteArrayPool_mediumCount = 0;

    static int ByteArrayPool_largeCount = 0;

    static int field3666 = 0;

    static int field3659 = 1000;

    static int field3660 = 250;

    static int field3661 = 100;

    static int field3655 = 50;

    static byte[][] ByteArrayPool_small = new byte[1000][];

    static byte[][] ByteArrayPool_medium = new byte[250][];

    static byte[][] ByteArrayPool_large = new byte[100][];

    static byte[][] field3664 = new byte[50][];

    static ArrayList field3662 = new ArrayList();

    static WorldMapEvent worldMapEvent;

    static int field3668;

    static {
        class273.method1570();
        new HashMap();
    }

    public static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
        byte[] var2;
        if ((var0 == 100 || var0 < 100 && var1) && ByteArrayPool_smallCount > 0) {
            var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
            ByteArrayPool_small[ByteArrayPool_smallCount] = null;
            return var2;
        } else if ((var0 == 5000 || var0 < 5000 && var1) && ByteArrayPool_mediumCount > 0) {
            var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
            ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
            return var2;
        } else if ((var0 == 10000 || var0 < 10000 && var1) && ByteArrayPool_largeCount > 0) {
            var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
            ByteArrayPool_large[ByteArrayPool_largeCount] = null;
            return var2;
        } else if ((var0 == 30000 || var0 < 30000 && var1) && field3666 > 0) {
            var2 = field3664[--field3666];
            field3664[field3666] = null;
            return var2;
        } else {
            int var4;
            if (UserComparator3.ByteArrayPool_arrays != null) {
                for (var4 = 0; var4 < ClanChannel.ByteArrayPool_alternativeSizes.length; ++var4) {
                    if ((ClanChannel.ByteArrayPool_alternativeSizes[var4] == var0
                            || var0 < ClanChannel.ByteArrayPool_alternativeSizes[var4] && var1)
                            && class136.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
                        byte[] var3 = UserComparator3.ByteArrayPool_arrays[var4][--class136.ByteArrayPool_altSizeArrayCounts[var4]];
                        UserComparator3.ByteArrayPool_arrays[var4][class136.ByteArrayPool_altSizeArrayCounts[var4]] = null;
                        return var3;
                    }
                }
            }

            if (var1 && ClanChannel.ByteArrayPool_alternativeSizes != null) {
                for (var4 = 0; var4 < ClanChannel.ByteArrayPool_alternativeSizes.length; ++var4) {
                    if (var0 <= ClanChannel.ByteArrayPool_alternativeSizes[var4]
                            && class136.ByteArrayPool_altSizeArrayCounts[var4] < UserComparator3.ByteArrayPool_arrays[var4].length) {
                        return new byte[ClanChannel.ByteArrayPool_alternativeSizes[var4]];
                    }
                }
            }

            return new byte[var0];
        }
    }

    static final boolean method2091() {
        return Client.isMenuOpen;
    }
}
