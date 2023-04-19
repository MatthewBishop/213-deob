public class VarpDefinition extends DualNode {

    public static AbstractArchive VarpDefinition_archive;

    public static int field1475;

    public static EvictingDualNodeHashTable VarpDefinition_cached = new EvictingDualNodeHashTable(64);

    public static int musicTrackFileId;

    public int type = 0;

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 5) {
            this.type = var1.readUnsignedShort();
        }

    }

    static SpritePixels method982(int var0, int var1, int var2) {
        return (SpritePixels) WorldMapRegion.WorldMapRegion_cachedSprites
                .get(BuddyRankComparator.method710(var0, var1, var2));
    }

    static class126[] method983() {
        return new class126[] { class126.field1243, class126.field1240, class126.field1241, class126.field1246,
                class126.field1247, class126.field1244 };
    }

    public static void method981(int var0, int var1, int var2) {
        Rasterizer3D.clips.method1360(var0, var1, var2);
    }
}
