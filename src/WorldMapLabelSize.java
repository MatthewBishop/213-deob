public class WorldMapLabelSize {

    public static final WorldMapLabelSize WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);

    public static final WorldMapLabelSize WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);

    public static final WorldMapLabelSize WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);

    static Archive field2285;

    final int field2282;

    final int field2279;

    final int field2283;

    WorldMapLabelSize(int var1, int var2, int var3) {
        this.field2282 = var1;
        this.field2279 = var2;
        this.field2283 = var3;
    }

    boolean method1394(float var1) {
        return var1 >= (float) this.field2283;
    }

    static WorldMapLabelSize method1395(int var0) {
        WorldMapLabelSize[] var1 = new WorldMapLabelSize[] { WorldMapLabelSize_small, WorldMapLabelSize_medium,
                WorldMapLabelSize_large };
        WorldMapLabelSize[] var2 = var1;

        for (int var3 = 0; var3 < var2.length; ++var3) {
            WorldMapLabelSize var4 = var2[var3];
            if (var0 == var4.field2279) {
                return var4;
            }
        }

        return null;
    }

    static final void method1397(PacketBuffer var0) {
        for (int var1 = 0; var1 < Players.Players_pendingUpdateCount; ++var1) {
            int var2 = Players.Players_pendingUpdateIndices[var1];
            Player var3 = Client.players[var2];
            int var4 = var0.readUnsignedByte();
            if ((var4 & 8) != 0) {
                var4 += var0.readUnsignedByte() << 8;
            }

            if ((var4 & 16384) != 0) {
                var4 += var0.readUnsignedByte() << 16;
            }

            ClientPreferences.method583(var0, var2, var3, var4);
        }

    }

    static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
        ArchiveDisk var5 = null;
        if (JagexCache.JagexCache_dat2File != null) {
            var5 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, class370.JagexCache_idxFiles[var0], 1000000);
        }

        return new Archive(var5, WorldMapID.masterDisk, var0, var1, var2, var3, var4);
    }
}
