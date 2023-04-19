public class class152 extends class155 {

    int field1380;

    byte field1381;

    int field1382;

    String field1383;
    // $FF: synthetic field

    final class156 this$0;

    class152(class156 var1) {
        this.this$0 = var1;
        this.field1380 = -1;
    }

    void vmethod3238(Buffer var1) {
        var1.readUnsignedByte();
        this.field1380 = var1.readUnsignedShort();
        this.field1381 = var1.readByte();
        this.field1382 = var1.readUnsignedShort();
        var1.readLong();
        this.field1383 = var1.readStringCp1252NullTerminated();
        var1.readUnsignedByte();
    }

    void vmethod3239(ClanChannel var1) {
        ClanChannelMember var2 = (ClanChannelMember) var1.members.get(this.field1380);
        var2.rank = this.field1381;
        var2.world = this.field1382;
        var2.username = new Username(this.field1383);
    }

    public static void method878(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
        SequenceDefinition.SequenceDefinition_archive = var0;
        SequenceDefinition.SequenceDefinition_animationsArchive = var1;
        SequenceDefinition.SequenceDefinition_skeletonsArchive = var2;
    }
}
