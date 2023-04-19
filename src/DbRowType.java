public class DbRowType extends DualNode {

    static AbstractArchive field4040;

    public static EvictingDualNodeHashTable DBRowType_cache = new EvictingDualNodeHashTable(64);

    Object[][] columnTypes;

    int[][] field4041;

    public int tableId = -1;

    void method2449(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method2452(var1, var2);
        }
    }

    public Object[] getColumnType(int var1) {
        return this.columnTypes == null ? null : this.columnTypes[var1];
    }

    void method2452(Buffer var1, int var2) {
        if (var2 == 3) {
            int var3 = var1.readUnsignedByte();
            if (this.columnTypes == null) {
                this.columnTypes = new Object[var3][];
                this.field4041 = new int[var3][];
            }

            for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
                int var5 = var1.readUnsignedByte();
                int[] var6 = new int[var5];

                for (int var7 = 0; var7 < var5; ++var7) {
                    var6[var7] = var1.readUShortSmart();
                }

                this.columnTypes[var4] = class377.method1998(var1, var6);
                this.field4041[var4] = var6;
            }
        } else if (var2 == 4) {
            this.tableId = var1.method2493();
        }

    }

    void method2450() {
    }
}
