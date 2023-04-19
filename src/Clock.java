public abstract class Clock {

    public abstract void mark();

    public abstract int wait(int var1, int var2);

    static final void method970(int var0, int var1, boolean var2) {
        if (Client.currentClanChannels[var0] != null) {
            if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method898()) {
                ClanChannelMember var3 = (ClanChannelMember) Client.currentClanChannels[var0].members.get(var1);
                PacketBufferNode var4 = class330.getPacketBufferNode(ClientPacket.field2543,
                        Client.packetWriter.isaacCipher);
                var4.packetBuffer
                        .writeByte(4 + DynamicObject.stringCp1252NullTerminatedByteSize(var3.username.getName()));
                var4.packetBuffer.writeByte(var0);
                var4.packetBuffer.writeShort(var1);
                var4.packetBuffer.writeBoolean(var2);
                var4.packetBuffer.writeStringCp1252NullTerminated(var3.username.getName());
                Client.packetWriter.addNode(var4);
            }
        }
    }
}
