public class WorldMapSection2 implements WorldMapSection {

    static Widget[] field2292;

    int minPlane;

    int planes;

    int regionStartX;

    int regionStartY;

    int regionEndX;

    int regionEndY;

    int field2293;

    int field2299;

    int field2300;

    int field2302;

    public void expandBounds(WorldMapArea var1) {
        if (var1.regionLowX > this.field2293) {
            var1.regionLowX = this.field2293;
        }

        if (var1.regionHighX < this.field2300) {
            var1.regionHighX = this.field2300;
        }

        if (var1.regionLowY > this.field2299) {
            var1.regionLowY = this.field2299;
        }

        if (var1.regionHighY < this.field2302) {
            var1.regionHighY = this.field2302;
        }

    }

    public boolean containsCoord(int var1, int var2, int var3) {
        if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
            return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY
                    && var3 >> 6 <= this.regionEndY;
        } else {
            return false;
        }
    }

    public boolean containsPosition(int var1, int var2) {
        return var1 >> 6 >= this.field2293 && var1 >> 6 <= this.field2300 && var2 >> 6 >= this.field2299
                && var2 >> 6 <= this.field2302;
    }

    public int[] getBorderTileLengths(int var1, int var2, int var3) {
        if (!this.containsCoord(var1, var2, var3)) {
            return null;
        } else {
            int[] var4 = new int[] { var2 + (this.field2293 * 64 - this.regionStartX * 64),
                    var3 + (this.field2299 * 64 - this.regionStartY * 64) };
            return var4;
        }
    }

    public Coord coord(int var1, int var2) {
        if (!this.containsPosition(var1, var2)) {
            return null;
        } else {
            int var3 = this.regionStartX * 64 - this.field2293 * 64 + var1;
            int var4 = var2 + (this.regionStartY * 64 - this.field2299 * 64);
            return new Coord(this.minPlane, var3, var4);
        }
    }

    public void read(Buffer var1) {
        this.minPlane = var1.readUnsignedByte();
        this.planes = var1.readUnsignedByte();
        this.regionStartX = var1.readUnsignedShort();
        this.regionStartY = var1.readUnsignedShort();
        this.regionEndX = var1.readUnsignedShort();
        this.regionEndY = var1.readUnsignedShort();
        this.field2293 = var1.readUnsignedShort();
        this.field2299 = var1.readUnsignedShort();
        this.field2300 = var1.readUnsignedShort();
        this.field2302 = var1.readUnsignedShort();
        this.postRead();
    }

    void postRead() {
    }
}
