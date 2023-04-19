public class class330 {

    static final class330 field3071 = new class330(51, 27, 800, 0, 16, 16);

    static final class330 field3072 = new class330(25, 28, 800, 656, 40, 40);

    final int field3073;

    final int field3074;

    class330(int var1, int var2, int var3, int var4, int var5, int var6) {
        this.field3073 = var5;
        this.field3074 = var6;
    }

    public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
        PacketBufferNode var2 = SpotAnimationDefinition.method1044();
        var2.clientPacket = var0;
        var2.clientPacketLength = var0.length;
        if (var2.clientPacketLength == -1) {
            var2.packetBuffer = new PacketBuffer(260);
        } else if (var2.clientPacketLength == -2) {
            var2.packetBuffer = new PacketBuffer(10000);
        } else if (var2.clientPacketLength <= 18) {
            var2.packetBuffer = new PacketBuffer(20);
        } else if (var2.clientPacketLength <= 98) {
            var2.packetBuffer = new PacketBuffer(100);
        } else {
            var2.packetBuffer = new PacketBuffer(260);
        }

        var2.packetBuffer.setIsaacCipher(var1);
        var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
        var2.index = 0;
        return var2;
    }

    static void readPlayerUpdate(PacketBuffer var0, int var1) {
        boolean var2 = var0.readBits(1) == 1;
        if (var2) {
            Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
        }

        int var3 = var0.readBits(2);
        Player var4 = Client.players[var1];
        if (var3 == 0) {
            if (var2) {
                var4.hasMovementPending = false;
            } else if (Client.localPlayerIndex == var1) {
                throw new RuntimeException();
            } else {
                Players.Players_regions[var1] = (var4.plane << 28) + (WorldMapData_0.baseX + var4.pathX[0] >> 13 << 14)
                        + (GameObject.baseY + var4.pathY[0] >> 13);
                if (var4.movingOrientation != -1) {
                    Players.Players_orientations[var1] = var4.movingOrientation;
                } else {
                    Players.Players_orientations[var1] = var4.orientation;
                }

                Players.Players_targetIndices[var1] = var4.targetIndex;
                Client.players[var1] = null;
                if (var0.readBits(1) != 0) {
                    WorldMapID.updateExternalPlayer(var0, var1);
                }

            }
        } else {
            int var5;
            int var6;
            int var7;
            if (var3 == 1) {
                var5 = var0.readBits(3);
                var6 = var4.pathX[0];
                var7 = var4.pathY[0];
                if (var5 == 0) {
                    --var6;
                    --var7;
                } else if (var5 == 1) {
                    --var7;
                } else if (var5 == 2) {
                    ++var6;
                    --var7;
                } else if (var5 == 3) {
                    --var6;
                } else if (var5 == 4) {
                    ++var6;
                } else if (var5 == 5) {
                    --var6;
                    ++var7;
                } else if (var5 == 6) {
                    ++var7;
                } else if (var5 == 7) {
                    ++var6;
                    ++var7;
                }

                if (Client.localPlayerIndex != var1
                        || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                    if (var2) {
                        var4.hasMovementPending = true;
                        var4.tileX = var6;
                        var4.tileY = var7;
                    } else {
                        var4.hasMovementPending = false;
                        var4.move(var6, var7, Players.playerMovementSpeeds[var1]);
                    }
                } else {
                    var4.resetPath(var6, var7);
                    var4.hasMovementPending = false;
                }

            } else if (var3 == 2) {
                var5 = var0.readBits(4);
                var6 = var4.pathX[0];
                var7 = var4.pathY[0];
                if (var5 == 0) {
                    var6 -= 2;
                    var7 -= 2;
                } else if (var5 == 1) {
                    --var6;
                    var7 -= 2;
                } else if (var5 == 2) {
                    var7 -= 2;
                } else if (var5 == 3) {
                    ++var6;
                    var7 -= 2;
                } else if (var5 == 4) {
                    var6 += 2;
                    var7 -= 2;
                } else if (var5 == 5) {
                    var6 -= 2;
                    --var7;
                } else if (var5 == 6) {
                    var6 += 2;
                    --var7;
                } else if (var5 == 7) {
                    var6 -= 2;
                } else if (var5 == 8) {
                    var6 += 2;
                } else if (var5 == 9) {
                    var6 -= 2;
                    ++var7;
                } else if (var5 == 10) {
                    var6 += 2;
                    ++var7;
                } else if (var5 == 11) {
                    var6 -= 2;
                    var7 += 2;
                } else if (var5 == 12) {
                    --var6;
                    var7 += 2;
                } else if (var5 == 13) {
                    var7 += 2;
                } else if (var5 == 14) {
                    ++var6;
                    var7 += 2;
                } else if (var5 == 15) {
                    var6 += 2;
                    var7 += 2;
                }

                if (Client.localPlayerIndex != var1
                        || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                    if (var2) {
                        var4.hasMovementPending = true;
                        var4.tileX = var6;
                        var4.tileY = var7;
                    } else {
                        var4.hasMovementPending = false;
                        var4.move(var6, var7, Players.playerMovementSpeeds[var1]);
                    }
                } else {
                    var4.resetPath(var6, var7);
                    var4.hasMovementPending = false;
                }

            } else {
                var5 = var0.readBits(1);
                int var8;
                int var9;
                int var10;
                int var11;
                if (var5 == 0) {
                    var6 = var0.readBits(12);
                    var7 = var6 >> 10;
                    var8 = var6 >> 5 & 31;
                    if (var8 > 15) {
                        var8 -= 32;
                    }

                    var9 = var6 & 31;
                    if (var9 > 15) {
                        var9 -= 32;
                    }

                    var10 = var8 + var4.pathX[0];
                    var11 = var9 + var4.pathY[0];
                    if (Client.localPlayerIndex != var1
                            || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                        if (var2) {
                            var4.hasMovementPending = true;
                            var4.tileX = var10;
                            var4.tileY = var11;
                        } else {
                            var4.hasMovementPending = false;
                            var4.move(var10, var11, Players.playerMovementSpeeds[var1]);
                        }
                    } else {
                        var4.resetPath(var10, var11);
                        var4.hasMovementPending = false;
                    }

                    var4.plane = (byte) (var7 + var4.plane & 3);
                    if (Client.localPlayerIndex == var1) {
                        GameEngine.Client_plane = var4.plane;
                    }

                } else {
                    var6 = var0.readBits(30);
                    var7 = var6 >> 28;
                    var8 = var6 >> 14 & 16383;
                    var9 = var6 & 16383;
                    var10 = (var8 + WorldMapData_0.baseX + var4.pathX[0] & 16383) - WorldMapData_0.baseX;
                    var11 = (var9 + GameObject.baseY + var4.pathY[0] & 16383) - GameObject.baseY;
                    if (Client.localPlayerIndex != var1
                            || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                        if (var2) {
                            var4.hasMovementPending = true;
                            var4.tileX = var10;
                            var4.tileY = var11;
                        } else {
                            var4.hasMovementPending = false;
                            var4.move(var10, var11, Players.playerMovementSpeeds[var1]);
                        }
                    } else {
                        var4.resetPath(var10, var11);
                        var4.hasMovementPending = false;
                    }

                    var4.plane = (byte) (var7 + var4.plane & 3);
                    if (Client.localPlayerIndex == var1) {
                        GameEngine.Client_plane = var4.plane;
                    }

                }
            }
        }
    }

    static int method1846() {
        return Login.loginIndex;
    }
}
