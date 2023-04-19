public class class137 extends class139 {

    static Font fontBold12;

    long field1311;

    String field1312;
    // $FF: synthetic field

    final class142 this$0;

    class137(class142 var1) {
        this.this$0 = var1;
        this.field1311 = -1L;
        this.field1312 = null;
    }

    void vmethod3254(Buffer var1) {
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            this.field1311 = var1.readLong();
        }

        this.field1312 = var1.readStringCp1252NullTerminatedOrNull();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method849(this.field1311, this.field1312, 0);
    }

    static void method792() {
        Tiles.Tiles_minPlane = 99;
        class186.Tiles_underlays = new short[4][104][104];
        Tiles.Tiles_overlays = new short[4][104][104];
        Tiles.Tiles_shapes = new byte[4][104][104];
        Tiles.field824 = new byte[4][104][104];
        class161.field1407 = new int[4][105][105];
        Tiles.field819 = new byte[4][105][105];
        Tiles.field821 = new int[105][105];
        FileSystem.Tiles_hue = new int[104];
        Tiles.Tiles_saturation = new int[104];
        class283.Tiles_lightness = new int[104];
        UserComparator4.Tiles_hueMultiplier = new int[104];
        class31.field92 = new int[104];
    }
}
