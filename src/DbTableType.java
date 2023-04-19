public class DbTableType extends DualNode {

    static AbstractArchive field4036;

    static EvictingDualNodeHashTable DBTableType_cache = new EvictingDualNodeHashTable(64);

    public int[][] types;

    public Object[][] defaultValues;

    void method2444(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method2445(var1, var2);
        }
    }

    void method2445(Buffer var1, int var2) {
        if (var2 == 1) {
            int var3 = var1.readUnsignedByte();
            if (this.types == null) {
                this.types = new int[var3][];
            }

            for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) {
                int var5 = var4 & 127;
                boolean var6 = (var4 & 128) != 0;
                int[] var7 = new int[var1.readUnsignedByte()];

                for (int var8 = 0; var8 < var7.length; ++var8) {
                    var7[var8] = var1.readUShortSmart();
                }

                this.types[var5] = var7;
                if (var6) {
                    if (this.defaultValues == null) {
                        this.defaultValues = new Object[this.types.length][];
                    }

                    this.defaultValues[var5] = class377.method1998(var1, var7);
                }
            }
        }

    }

    void method2446() {
    }
}
