import java.util.Collections;

public enum class134 implements class356 {

    field1291(0, 0),

    field1298(1, 1),

    field1290(2, 2),

    field1293(3, 3),

    field1288(4, 4),

    field1292(5, 5),

    field1289(6, 6),

    field1294(7, 7),

    field1295(8, 8);

    final int field1296;

    final int field1297;

    class134(int var3, int var4) {
        this.field1296 = var3;
        this.field1297 = var4;
    }

    public int rsOrdinal() {
        return this.field1297;
    }

    public static void method782(int[] var0, int[] var1) {
        if (var0 != null && var1 != null) {
            ClanChannel.ByteArrayPool_alternativeSizes = var0;
            class136.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
            UserComparator3.ByteArrayPool_arrays = new byte[var0.length][][];

            for (int var2 = 0; var2 < ClanChannel.ByteArrayPool_alternativeSizes.length; ++var2) {
                UserComparator3.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
                ByteArrayPool.field3662.add(var0[var2]);
            }

            Collections.sort(ByteArrayPool.field3662);
        } else {
            ClanChannel.ByteArrayPool_alternativeSizes = null;
            class136.ByteArrayPool_altSizeArrayCounts = null;
            UserComparator3.ByteArrayPool_arrays = null;
            class273.method1570();
        }
    }

    public static int method780(int var0, int var1, int var2) {
        int var3 = class140.method806(var2 - var1 + 1);
        var3 <<= var1;
        var0 |= var3;
        return var0;
    }

    public static boolean isCharAlphabetic(char var0) {
        return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
    }

    static boolean method779() {
        return class20.clientPreferences.method575() >= Client.param21;
    }
}
