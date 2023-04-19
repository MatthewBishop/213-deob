public class WorldMapIcon_1 extends AbstractWorldMapIcon {

    final int objectDefId;

    final WorldMapRegion region;

    int element;

    WorldMapLabel label;

    int subWidth;

    int subHeight;

    WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
        super(var1, var2);
        this.objectDefId = var3;
        this.region = var4;
        this.init();
    }

    void init() {
        this.element = class144.getObjectDefinition(this.objectDefId).transform().mapIconId;
        this.label = this.region.createMapLabel(class354.WorldMapElement_get(this.element));
        WorldMapElement var1 = class354.WorldMapElement_get(this.getElement());
        SpritePixels var2 = var1.getSpriteBool(false);
        if (var2 != null) {
            this.subWidth = var2.subWidth;
            this.subHeight = var2.subHeight;
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
