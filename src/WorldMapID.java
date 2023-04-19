public class WorldMapID {

    static ArchiveDisk masterDisk;

    static final WorldMapID field2418 = new WorldMapID(0);

    static final WorldMapID field2419 = new WorldMapID(1);

    final int value;

    WorldMapID(int var1) {
        this.value = var1;
    }

    static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
        int var2 = var0.readBits(2);
        int var3;
        int var4;
        int var7;
        int var8;
        int var9;
        int var10;
        if (var2 == 0) {
            if (var0.readBits(1) != 0) {
                updateExternalPlayer(var0, var1);
            }

            var3 = var0.readBits(13);
            var4 = var0.readBits(13);
            boolean var12 = var0.readBits(1) == 1;
            if (var12) {
                Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
            }

            if (Client.players[var1] != null) {
                throw new RuntimeException();
            } else {
                Player var6 = Client.players[var1] = new Player();
                var6.index = var1;
                if (Players.cachedAppearanceBuffer[var1] != null) {
                    var6.read(Players.cachedAppearanceBuffer[var1]);
                }

                var6.orientation = Players.Players_orientations[var1];
                var6.targetIndex = Players.Players_targetIndices[var1];
                var7 = Players.Players_regions[var1];
                var8 = var7 >> 28;
                var9 = var7 >> 14 & 255;
                var10 = var7 & 255;
                var6.pathTraversed[0] = Players.playerMovementSpeeds[var1];
                var6.plane = (byte) var8;
                var6.resetPath((var9 << 13) + var3 - WorldMapData_0.baseX, (var10 << 13) + var4 - GameObject.baseY);
                var6.hasMovementPending = false;
                return true;
            }
        } else if (var2 == 1) {
            var3 = var0.readBits(2);
            var4 = Players.Players_regions[var1];
            Players.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
            return false;
        } else {
            int var5;
            int var11;
            if (var2 == 2) {
                var3 = var0.readBits(5);
                var4 = var3 >> 3;
                var5 = var3 & 7;
                var11 = Players.Players_regions[var1];
                var7 = (var11 >> 28) + var4 & 3;
                var8 = var11 >> 14 & 255;
                var9 = var11 & 255;
                if (var5 == 0) {
                    --var8;
                    --var9;
                }

                if (var5 == 1) {
                    --var9;
                }

                if (var5 == 2) {
                    ++var8;
                    --var9;
                }

                if (var5 == 3) {
                    --var8;
                }

                if (var5 == 4) {
                    ++var8;
                }

                if (var5 == 5) {
                    --var8;
                    ++var9;
                }

                if (var5 == 6) {
                    ++var9;
                }

                if (var5 == 7) {
                    ++var8;
                    ++var9;
                }

                Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
                return false;
            } else {
                var3 = var0.readBits(18);
                var4 = var3 >> 16;
                var5 = var3 >> 8 & 255;
                var11 = var3 & 255;
                var7 = Players.Players_regions[var1];
                var8 = (var7 >> 28) + var4 & 3;
                var9 = var5 + (var7 >> 14) & 255;
                var10 = var11 + var7 & 255;
                Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
                return false;
            }
        }
    }

    static Frames getFrames(int var0) {
        Frames var1 = (Frames) SequenceDefinition.SequenceDefinition_cachedFrames.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            var1 = PendingSpawn.method523(SequenceDefinition.SequenceDefinition_animationsArchive,
                    SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
            if (var1 != null) {
                SequenceDefinition.SequenceDefinition_cachedFrames.put(var1, (long) var0);
            }

            return var1;
        }
    }
}
