public class UserComparator7 extends AbstractUserComparator {

    final boolean reversed;

    public UserComparator7(boolean var1) {
        this.reversed = var1;
    }

    int compareBuddy(Buddy var1, Buddy var2) {
        if (var1.world != 0 && var2.world != 0) {
            return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
        } else {
            return this.compareUser(var1, var2);
        }
    }

    public int compare(Object var1, Object var2) {
        return this.compareBuddy((Buddy) var1, (Buddy) var2);
    }

    public static final int method693(double var0, double var2, double var4) {
        double var6 = var4;
        double var8 = var4;
        double var10 = var4;
        if (var2 != 0.0D) {
            double var12;
            if (var4 < 0.5D) {
                var12 = var4 * (var2 + 1.0D);
            } else {
                var12 = var4 + var2 - var2 * var4;
            }

            double var14 = var4 * 2.0D - var12;
            double var16 = var0 + 0.3333333333333333D;
            if (var16 > 1.0D) {
                --var16;
            }

            double var20 = var0 - 0.3333333333333333D;
            if (var20 < 0.0D) {
                ++var20;
            }

            if (var16 * 6.0D < 1.0D) {
                var6 = 6.0D * (var12 - var14) * var16 + var14;
            } else if (var16 * 2.0D < 1.0D) {
                var6 = var12;
            } else if (var16 * 3.0D < 2.0D) {
                var6 = var14 + (0.6666666666666666D - var16) * (var12 - var14) * 6.0D;
            } else {
                var6 = var14;
            }

            if (var0 * 6.0D < 1.0D) {
                var8 = var14 + 6.0D * (var12 - var14) * var0;
            } else if (var0 * 2.0D < 1.0D) {
                var8 = var12;
            } else if (var0 * 3.0D < 2.0D) {
                var8 = var14 + 6.0D * (var12 - var14) * (0.6666666666666666D - var0);
            } else {
                var8 = var14;
            }

            if (var20 * 6.0D < 1.0D) {
                var10 = 6.0D * (var12 - var14) * var20 + var14;
            } else if (var20 * 2.0D < 1.0D) {
                var10 = var12;
            } else if (var20 * 3.0D < 2.0D) {
                var10 = (0.6666666666666666D - var20) * (var12 - var14) * 6.0D + var14;
            } else {
                var10 = var14;
            }
        }

        int var22 = (int) (var6 * 256.0D);
        int var13 = (int) (var8 * 256.0D);
        int var23 = (int) (var10 * 256.0D);
        int var15 = var23 + (var13 << 8) + (var22 << 16);
        return var15;
    }

    public static int get3dZoom() {
        return Rasterizer3D.clips.field2227;
    }

    static int method694(int var0, Script var1, boolean var2) {
        return 2;
    }

    static void method692(int var0, String var1) {
        int var2 = Players.Players_count;
        int[] var3 = Players.Players_indices;
        boolean var4 = false;
        Username var5 = new Username(var1, class70.loginType);

        for (int var6 = 0; var6 < var2; ++var6) {
            Player var7 = Client.players[var3[var6]];
            if (var7 != null && var7 != MusicPatchNode.localPlayer && var7.username != null
                    && var7.username.equals(var5)) {
                PacketBufferNode var8;
                if (var0 == 1) {
                    var8 = class330.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeByteAdd(0);
                    var8.packetBuffer.writeShort(var3[var6]);
                    Client.packetWriter.addNode(var8);
                } else if (var0 == 4) {
                    var8 = class330.getPacketBufferNode(ClientPacket.field2526, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeByteNeg(0);
                    var8.packetBuffer.writeIntME(var3[var6]);
                    Client.packetWriter.addNode(var8);
                } else if (var0 == 6) {
                    var8 = class330.getPacketBufferNode(ClientPacket.IF_BUTTONT, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeShortAddLE(var3[var6]);
                    var8.packetBuffer.writeByteNeg(0);
                    Client.packetWriter.addNode(var8);
                } else if (var0 == 7) {
                    var8 = class330.getPacketBufferNode(ClientPacket.OPOBJT, Client.packetWriter.isaacCipher);
                    var8.packetBuffer.writeShortAdd(var3[var6]);
                    var8.packetBuffer.method2500(0);
                    Client.packetWriter.addNode(var8);
                }

                var4 = true;
                break;
            }
        }

        if (!var4) {
            UserComparator5.addGameMessage(4, "", "Unable to find " + var1);
        }

    }
}
