public class class127 implements class356 {

    static final class127 field1252 = new class127(0, 0, (String) null, -1, -1);

    static final class127 field1254 = new class127(1, 1, (String) null, 0, 2);

    static final class127 field1253 = new class127(2, 2, (String) null, 1, 2);

    static final class127 field1251 = new class127(3, 3, (String) null, 2, 2);

    static final class127 field1271 = new class127(4, 4, (String) null, 3, 1);

    static final class127 field1266 = new class127(5, 5, (String) null, 4, 1);

    static final class127 field1257 = new class127(6, 6, (String) null, 5, 1);

    static final class127 field1258 = new class127(7, 7, (String) null, 6, 3);

    static final class127 field1259 = new class127(8, 8, (String) null, 7, 3);

    static final class127 field1260 = new class127(9, 9, (String) null, 8, 3);

    static final class127 field1261 = new class127(10, 10, (String) null, 0, 7);

    static final class127 field1255 = new class127(11, 11, (String) null, 1, 7);

    static final class127 field1263 = new class127(12, 12, (String) null, 2, 7);

    static final class127 field1256 = new class127(13, 13, (String) null, 3, 7);

    static final class127 field1262 = new class127(14, 14, (String) null, 4, 7);

    static final class127 field1265 = new class127(15, 15, (String) null, 5, 7);

    static final class127 field1264 = new class127(16, 16, (String) null, 0, 5);

    static int js5Port;

    final int field1267;

    final int field1268;

    final int field1269;

    class127(int var1, int var2, String var3, int var4, int var5) {
        this.field1267 = var1;
        this.field1268 = var2;
        this.field1269 = var4;
    }

    public int rsOrdinal() {
        return this.field1268;
    }

    int method756() {
        return this.field1269;
    }

    static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
        if (class31.World_worlds != null) {
            class13.doWorldSorting(0, class31.World_worlds.length - 1, var0, var1, var2, var3);
        }

    }

    public static void method761() {
        ItemComposition.ItemDefinition_cachedSprites.clear();
    }

    static final void loadRegions(boolean var0, PacketBuffer var1) {
        Client.isInInstance = var0;
        int var2;
        int var4;
        int var5;
        int var6;
        int var7;
        if (!Client.isInInstance) {
            var2 = var1.readUnsignedShortAddLE();
            int var3 = var1.readUnsignedShortAddLE();
            var4 = var1.readUnsignedShort();
            GameObject.xteaKeys = new int[var4][4];

            for (var5 = 0; var5 < var4; ++var5) {
                for (var6 = 0; var6 < 4; ++var6) {
                    GameObject.xteaKeys[var5][var6] = var1.readInt();
                }
            }

            WorldMapAreaData.regions = new int[var4];
            FontName.regionMapArchiveIds = new int[var4];
            Archive.regionLandArchiveIds = new int[var4];
            class4.regionLandArchives = new byte[var4][];
            ObjectSound.regionMapArchives = new byte[var4][];
            var4 = 0;

            for (var5 = (var3 - 6) / 8; var5 <= (var3 + 6) / 8; ++var5) {
                for (var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
                    var7 = var6 + (var5 << 8);
                    WorldMapAreaData.regions[var4] = var7;
                    FontName.regionMapArchiveIds[var4] = GrandExchangeOfferTotalQuantityComparator.archive9
                            .getGroupId("m" + var5 + "_" + var6);
                    Archive.regionLandArchiveIds[var4] = GrandExchangeOfferTotalQuantityComparator.archive9
                            .getGroupId("l" + var5 + "_" + var6);
                    ++var4;
                }
            }

            Decimator.method331(var3, var2, true);
        } else {
            var2 = var1.readUnsignedShortAddLE();
            boolean var15 = var1.readUnsignedByte() == 1;
            var4 = var1.readUnsignedShortLE();
            var5 = var1.readUnsignedShort();
            var1.importIndex();

            int var8;
            int var9;
            for (var6 = 0; var6 < 4; ++var6) {
                for (var7 = 0; var7 < 13; ++var7) {
                    for (var8 = 0; var8 < 13; ++var8) {
                        var9 = var1.readBits(1);
                        if (var9 == 1) {
                            Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
                        } else {
                            Client.instanceChunkTemplates[var6][var7][var8] = -1;
                        }
                    }
                }
            }

            var1.exportIndex();
            GameObject.xteaKeys = new int[var5][4];

            for (var6 = 0; var6 < var5; ++var6) {
                for (var7 = 0; var7 < 4; ++var7) {
                    GameObject.xteaKeys[var6][var7] = var1.readInt();
                }
            }

            WorldMapAreaData.regions = new int[var5];
            FontName.regionMapArchiveIds = new int[var5];
            Archive.regionLandArchiveIds = new int[var5];
            class4.regionLandArchives = new byte[var5][];
            ObjectSound.regionMapArchives = new byte[var5][];
            var5 = 0;

            for (var6 = 0; var6 < 4; ++var6) {
                for (var7 = 0; var7 < 13; ++var7) {
                    for (var8 = 0; var8 < 13; ++var8) {
                        var9 = Client.instanceChunkTemplates[var6][var7][var8];
                        if (var9 != -1) {
                            int var10 = var9 >> 14 & 1023;
                            int var11 = var9 >> 3 & 2047;
                            int var12 = (var10 / 8 << 8) + var11 / 8;

                            int var13;
                            for (var13 = 0; var13 < var5; ++var13) {
                                if (WorldMapAreaData.regions[var13] == var12) {
                                    var12 = -1;
                                    break;
                                }
                            }

                            if (var12 != -1) {
                                WorldMapAreaData.regions[var5] = var12;
                                var13 = var12 >> 8 & 255;
                                int var14 = var12 & 255;
                                FontName.regionMapArchiveIds[var5] = GrandExchangeOfferTotalQuantityComparator.archive9
                                        .getGroupId("m" + var13 + "_" + var14);
                                Archive.regionLandArchiveIds[var5] = GrandExchangeOfferTotalQuantityComparator.archive9
                                        .getGroupId("l" + var13 + "_" + var14);
                                ++var5;
                            }
                        }
                    }
                }
            }

            Decimator.method331(var2, var4, !var15);
        }

    }

    static final void runIntfCloseListeners(int var0, int var1) {
        if (SoundSystem.loadInterface(var0)) {
            class143.runComponentCloseListeners(VerticalAlignment.Widget_interfaceComponents[var0], var1);
        }
    }
}
