public class WorldMapIcon_0 extends AbstractWorldMapIcon {

    public static short[] field2359;

    final int element;

    final WorldMapLabel label;

    final int subWidth;

    final int subHeight;

    WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
        super(var1, var2);
        this.element = var3;
        this.label = var4;
        WorldMapElement var5 = class354.WorldMapElement_get(this.getElement());
        SpritePixels var6 = var5.getSpriteBool(false);
        if (var6 != null) {
            this.subWidth = var6.subWidth;
            this.subHeight = var6.subHeight;
        } else {
            this.subWidth = 0;
            this.subHeight = 0;
        }

    }

    public int getElement() {
        return this.element;
    }

    WorldMapLabel getLabel() {
        return this.label;
    }

    int getSubWidth() {
        return this.subWidth;
    }

    int getSubHeight() {
        return this.subHeight;
    }
}
