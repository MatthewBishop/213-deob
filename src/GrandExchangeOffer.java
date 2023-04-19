public class GrandExchangeOffer {

    static String field3530;

    byte state;

    public int id;

    public int unitPrice;

    public int totalQuantity;

    public int currentQuantity;

    public int currentPrice;

    public GrandExchangeOffer() {
    }

    public GrandExchangeOffer(Buffer var1, boolean var2) {
        this.state = var1.readByte();
        this.id = var1.readUnsignedShort();
        this.unitPrice = var1.readInt();
        this.totalQuantity = var1.readInt();
        this.currentQuantity = var1.readInt();
        this.currentPrice = var1.readInt();
    }

    public int status() {
        return this.state & 7;
    }

    public int type() {
        return (this.state & 8) == 8 ? 1 : 0;
    }

    void method1928(int var1) {
        this.state &= -8;
        this.state = (byte) (this.state | var1 & 7);
    }

    void method1927(int var1) {
        this.state &= -9;
        if (var1 == 1) {
            this.state = (byte) (this.state | 8);
        }

    }

    public static void method1930(String[] var0, short[] var1) {
        class309.sortItemsByName(var0, var1, 0, var0.length - 1);
    }

    public static int method1929(byte[] var0, int var1, CharSequence var2) {
        int var3 = var2.length();
        int var4 = var1;

        for (int var5 = 0; var5 < var3; ++var5) {
            char var6 = var2.charAt(var5);
            if (var6 <= 127) {
                var0[var4++] = (byte) var6;
            } else if (var6 <= 2047) {
                var0[var4++] = (byte) (192 | var6 >> 6);
                var0[var4++] = (byte) (128 | var6 & 63);
            } else {
                var0[var4++] = (byte) (224 | var6 >> 12);
                var0[var4++] = (byte) (128 | var6 >> 6 & 63);
                var0[var4++] = (byte) (128 | var6 & 63);
            }
        }

        return var4 - var1;
    }

    public static FillMode[] FillMode_values() {
        return new FillMode[] { FillMode.field4120, FillMode.SOLID, FillMode.field4119 };
    }
}
