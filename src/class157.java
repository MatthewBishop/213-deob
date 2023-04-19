public class class157 extends class139 {

    static AbstractArchive ObjectDefinition_modelsArchive;

    int field1391;

    int field1393;
    // $FF: synthetic field

    final class142 this$0;

    class157(class142 var1) {
        this.this$0 = var1;
    }

    void vmethod3254(Buffer var1) {
        this.field1391 = var1.readInt();
        this.field1393 = var1.readInt();
    }

    void vmethod3248(ClanSettings var1) {
        var1.method861(this.field1391, this.field1393);
    }
}
