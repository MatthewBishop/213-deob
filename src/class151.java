public class class151 extends class155 {

    String field1379;

    int field1378;

    byte field1377;
    // $FF: synthetic field

    final class156 this$0;

    class151(class156 var1) {
        this.this$0 = var1;
        this.field1379 = null;
    }

    void vmethod3238(Buffer var1) {
        if (var1.readUnsignedByte() != 255) {
            --var1.offset;
            var1.readLong();
        }

        this.field1379 = var1.readStringCp1252NullTerminatedOrNull();
        this.field1378 = var1.readUnsignedShort();
        this.field1377 = var1.readByte();
        var1.readLong();
    }

    void vmethod3239(ClanChannel var1) {
        ClanChannelMember var2 = new ClanChannelMember();
        var2.username = new Username(this.field1379);
        var2.world = this.field1378;
        var2.rank = this.field1377;
        var1.addMember(var2);
    }

    static Script getWorldMapScript(int var0, int var1, int var2) {
        int var3 = (var1 << 8) + var0;
        Script var5 = ObjectComposition.method1096(var3, var0);
        if (var5 != null) {
            return var5;
        } else {
            int var4 = class262.method1527(var2, var0);
            Script var7 = (Script) Script.Script_cached.get((long) (var4 << 16));
            Script var6;
            if (var7 != null) {
                var6 = var7;
            } else {
                String var8 = String.valueOf(var4);
                int var9 = class126.archive12.getGroupId(var8);
                if (var9 == -1) {
                    var6 = null;
                } else {
                    byte[] var10 = class126.archive12.takeFileFlat(var9);
                    if (var10 != null) {
                        if (var10.length <= 1) {
                            var6 = null;
                            return var6 != null ? var6 : null;
                        }

                        var7 = class33.newScript(var10);
                        if (var7 != null) {
                            Script.Script_cached.put(var7, (long) (var4 << 16));
                            var6 = var7;
                            return var6 != null ? var6 : null;
                        }
                    }

                    var6 = null;
                }
            }

            return var6 != null ? var6 : null;
        }
    }

    static void method874(float var0, float var1, float var2, float var3, class125 var4) {
        float var5 = var1 - var0;
        float var6 = var2 - var1;
        float var7 = var3 - var2;
        float var8 = var6 - var5;
        var4.field1226 = var7 - var6 - var8;
        var4.field1237 = var8 + var8 + var8;
        var4.field1224 = var5 + var5 + var5;
        var4.field1223 = var0;
    }

    static final void method872(int var0, int var1) {
        ClanChannel var2 = var0 >= 0 ? Client.currentClanChannels[var0] : MouseHandler.guestClanChannel;
        if (var2 != null && var1 >= 0 && var1 < var2.method898()) {
            ClanChannelMember var3 = (ClanChannelMember) var2.members.get(var1);
            if (var3.rank == -1) {
                String var4 = var3.username.getName();
                PacketBufferNode var5 = class330.getPacketBufferNode(ClientPacket.field2551,
                        Client.packetWriter.isaacCipher);
                var5.packetBuffer.writeByte(3 + DynamicObject.stringCp1252NullTerminatedByteSize(var4));
                var5.packetBuffer.writeByte(var0);
                var5.packetBuffer.writeShort(var1);
                var5.packetBuffer.writeStringCp1252NullTerminated(var4);
                Client.packetWriter.addNode(var5);
            }
        }
    }
}
