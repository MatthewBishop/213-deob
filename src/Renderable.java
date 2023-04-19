public abstract class Renderable extends DualNode {

    public int height = 1000;

    protected Model getModel() {
        return null;
    }

    void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
        Model var11 = this.getModel();
        if (var11 != null) {
            this.height = var11.height;
            var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
        }

    }

    static void method1291() {
        class186.Tiles_underlays = null;
        Tiles.Tiles_overlays = null;
        Tiles.Tiles_shapes = null;
        Tiles.field824 = null;
        class161.field1407 = null;
        Tiles.field819 = null;
        Tiles.field821 = null;
        FileSystem.Tiles_hue = null;
        Tiles.Tiles_saturation = null;
        class283.Tiles_lightness = null;
        UserComparator4.Tiles_hueMultiplier = null;
        class31.field92 = null;
    }
}
