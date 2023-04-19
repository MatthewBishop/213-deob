public class class96 {

    public static String[] cacheSubPaths;

    static Bounds field1063;

    static int field1064;

    static int widgetDragDuration;

    public static final synchronized long clockNow() {
        long var0 = System.currentTimeMillis();
        if (var0 < class293.field2711) {
            class293.field2712 += class293.field2711 - var0;
        }

        class293.field2711 = var0;
        return var0 + class293.field2712;
    }
}
