import java.util.LinkedList;

public abstract class AbstractWorldMapData {

    int regionXLow;

    int regionYLow;

    int regionX;

    int regionY;

    int minPlane;

    int planes;

    int groupId = -1;

    int fileId = -1;

    short[][][] floorUnderlayIds;

    short[][][] floorOverlayIds;

    byte[][][] field2390;

    byte[][][] field2396;

    WorldMapDecoration[][][][] decorations;

    boolean field2398;

    boolean field2399;

    AbstractWorldMapData() {
        new LinkedList();
        this.field2398 = false;
        this.field2399 = false;
    }

    abstract void readGeography(Buffer var1);

    boolean isFullyLoaded() {
        return this.field2398 && this.field2399;
    }

    void loadGeography(AbstractArchive var1) {
        if (!this.isFullyLoaded()) {
            byte[] var2 = var1.takeFile(this.groupId, this.fileId);
            if (var2 != null) {
                this.readGeography(new Buffer(var2));
                this.field2398 = true;
                this.field2399 = true;
            }

        }
    }

    void reset() {
        this.floorUnderlayIds = null;
        this.floorOverlayIds = null;
        this.field2390 = null;
        this.field2396 = null;
        this.decorations = null;
        this.field2398 = false;
        this.field2399 = false;
    }

    void readTile(int var1, int var2, Buffer var3) {
        int var4 = var3.readUnsignedByte();
        if (var4 != 0) {
            if ((var4 & 1) != 0) {
                this.method1516(var1, var2, var3, var4);
            } else {
                this.method1517(var1, var2, var3, var4);
            }

        }
    }

    void method1516(int var1, int var2, Buffer var3, int var4) {
        boolean var5 = (var4 & 2) != 0;
        if (var5) {
            this.floorOverlayIds[0][var1][var2] = (short) var3.readUnsignedShort();
        }

        this.floorUnderlayIds[0][var1][var2] = (short) var3.readUnsignedShort();
    }

    void method1517(int var1, int var2, Buffer var3, int var4) {
        int var5 = ((var4 & 24) >> 3) + 1;
        boolean var6 = (var4 & 2) != 0;
        boolean var7 = (var4 & 4) != 0;
        this.floorUnderlayIds[0][var1][var2] = (short) var3.readUnsignedShort();
        int var8;
        int var9;
        int var11;
        if (var6) {
            var8 = var3.readUnsignedByte();

            for (var9 = 0; var9 < var8; ++var9) {
                int var10 = var3.readUnsignedShort();
                if (var10 != 0) {
                    this.floorOverlayIds[var9][var1][var2] = (short) var10;
                    var11 = var3.readUnsignedByte();
                    this.field2390[var9][var1][var2] = (byte) (var11 >> 2);
                    this.field2396[var9][var1][var2] = (byte) (var11 & 3);
                }
            }
        }

        if (var7) {
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3.readUnsignedByte();
                if (var9 != 0) {
                    WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        int var12 = var3.method2516();
                        int var13 = var3.readUnsignedByte();
                        var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
                    }
                }
            }
        }

    }

    int getRegionX() {
        return this.regionX;
    }

    int getRegionY() {
        return this.regionY;
    }

    public static synchronized byte[] ByteArrayPool_getArray(int var0) {
        return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
    }
}
