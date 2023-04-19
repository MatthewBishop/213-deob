public class VarcInt extends DualNode {

    public static EvictingDualNodeHashTable VarcInt_cached = new EvictingDualNodeHashTable(64);

    public boolean persist = false;

    public void method991(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method992(var1, var2);
        }
    }

    void method992(Buffer var1, int var2) {
        if (var2 == 2) {
            this.persist = true;
        }

    }

    public static boolean isCharPrintable(char var0) {
        if (var0 >= ' ' && var0 <= '~') {
            return true;
        } else if (var0 >= 160 && var0 <= 255) {
            return true;
        } else {
            return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
        }
    }
}
