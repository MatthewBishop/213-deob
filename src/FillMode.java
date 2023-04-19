public enum FillMode implements class356 {

    SOLID(0, 0),

    field4119(1, 1),

    field4120(2, 2);

    public final int field4118;

    final int field4121;

    FillMode(int var3, int var4) {
        this.field4118 = var3;
        this.field4121 = var4;
    }

    public int rsOrdinal() {
        return this.field4121;
    }

    static void changeWorldSelectSorting(int var0, int var1) {
        int[] var2 = new int[4];
        int[] var3 = new int[4];
        var2[0] = var0;
        var3[0] = var1;
        int var4 = 1;

        for (int var5 = 0; var5 < 4; ++var5) {
            if (World.World_sortOption1[var5] != var0) {
                var2[var4] = World.World_sortOption1[var5];
                var3[var4] = World.World_sortOption2[var5];
                ++var4;
            }
        }

        World.World_sortOption1 = var2;
        World.World_sortOption2 = var3;
        class123.sortWorlds(class31.World_worlds, 0, class31.World_worlds.length - 1, World.World_sortOption1,
                World.World_sortOption2);
    }
}
