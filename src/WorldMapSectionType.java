public enum WorldMapSectionType implements class356 {

    WORLDMAPSECTIONTYPE0(1, (byte) 0),

    WORLDMAPSECTIONTYPE1(0, (byte) 1),

    WORLDMAPSECTIONTYPE2(3, (byte) 2),

    WORLDMAPSECTIONTYPE3(2, (byte) 3);

    static Decimator decimator;

    public static String formattedOperatingSystemName;

    static boolean field2384;

    static int cameraPitch;

    static int field2385;

    final int type;

    final byte id;

    WorldMapSectionType(int var3, byte var4) {
        this.type = var3;
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }

    public static String method1510(byte[] var0) {
        return class144.method826(var0, 0, var0.length);
    }

    public static boolean isNumber(CharSequence var0) {
        return UrlRequester.method671(var0, 10, true);
    }

    static char method1507(char var0) {
        return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
    }

    static WorldMapSectionType[] method1508() {
        return new WorldMapSectionType[] { WORLDMAPSECTIONTYPE1, WORLDMAPSECTIONTYPE2, WORLDMAPSECTIONTYPE3,
                WORLDMAPSECTIONTYPE0 };
    }
}
