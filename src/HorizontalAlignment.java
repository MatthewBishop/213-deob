public enum HorizontalAlignment implements class356 {

    field1547(0, 0),

    HorizontalAlignment_centered(2, 1),

    field1549(1, 2);

    public static String userHomeDirectory;

    static PcmPlayer pcmPlayer1;

    public final int value;

    final int id;

    HorizontalAlignment(int var3, int var4) {
        this.value = var3;
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }

    public static int method1019(boolean var0, boolean var1) {
        byte var2 = 0;
        int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount
                + NetCache.NetCache_pendingPriorityResponsesCount;
        return var3;
    }
}
