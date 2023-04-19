public class class145 extends class155 {

    int field1334;

    byte field1335;

    int field1337;

    String field1336;
    // $FF: synthetic field

    final class156 this$0;

    class145(class156 var1) {
        this.this$0 = var1;
        this.field1334 = -1;
    }

    void vmethod3238(Buffer var1) {
        this.field1334 = var1.readUnsignedShort();
        this.field1335 = var1.readByte();
        this.field1337 = var1.readUnsignedShort();
        var1.readLong();
        this.field1336 = var1.readStringCp1252NullTerminated();
    }

    void vmethod3239(ClanChannel var1) {
        ClanChannelMember var2 = (ClanChannelMember) var1.members.get(this.field1334);
        var2.rank = this.field1335;
        var2.world = this.field1337;
        var2.username = new Username(this.field1336);
    }
}
