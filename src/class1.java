import java.util.Iterator;
import java.util.concurrent.Callable;

public class class1 implements Callable {

    static Iterator field4;

    static Widget scriptActiveWidget;

    static Task socketTask;

    final Buffer field0;

    final class3 field1;
    // $FF: synthetic field

    final class7 this$0;

    class1(class7 var1, Buffer var2, class3 var3) {
        this.this$0 = var1;
        this.field0 = var2;
        this.field1 = var3;
    }

    public Object call() {
        return this.field1.vmethod12(this.field0);
    }

    public static void method2(int[] var0, int var1, int var2, float[] var3) {
        if (var3 == null && Rasterizer3D.field1992 == Rasterizer3D.field1999) {
            Rasterizer3D.field1999 = Rasterizer3D.field1998;
        }

        Rasterizer3D.field1999.method1223(var0, var1, var2, var3);
    }

    static void playSong(int var0) {
        if (var0 == -1 && !Client.playingJingle) {
            FloorUnderlayDefinition.method1050();
        } else if (var0 != -1 && var0 != Client.currentTrackGroupId
                && class20.clientPreferences.getCurrentMusicVolume() != 0 && !Client.playingJingle) {
            Actor.method538(2, class399.archive6, var0, 0, class20.clientPreferences.getCurrentMusicVolume(), false);
        }

        Client.currentTrackGroupId = var0;
    }

    static final void method5() {
        class133.method777(WorldMapRectangle.field2405, Players.field1095, KitDefinition.field1519);
        GraphicsObject.method433(ScriptEvent.field851, class86.field888);
        if (class36.cameraX == WorldMapRectangle.field2405 && class174.cameraY == Players.field1095
                && class297.cameraZ == KitDefinition.field1519
                && ScriptEvent.field851 == WorldMapSectionType.cameraPitch && class125.cameraYaw == class86.field888) {
            Client.field598 = false;
            Client.isCameraLocked = false;
            Client.field541 = false;
            Client.field614 = false;
            FontName.field3970 = 0;
            MilliClock.field1455 = 0;
            ScriptFrame.field343 = 0;
            Archive.field3467 = 0;
            WorldMapElement.field1503 = 0;
            class138.field1314 = 0;
            KeyHandler.field81 = 0;
            ObjTypeCustomisation.field1471 = 0;
            class123.field1209 = 0;
            class16.field54 = 0;
            Client.field535 = null;
            Client.field604 = null;
            Client.field617 = null;
        }

    }

    static void method4() {
        PacketBufferNode var0 = class330.getPacketBufferNode(ClientPacket.field2480, Client.packetWriter.isaacCipher);
        var0.packetBuffer.writeByte(GrandExchangeOfferNameComparator.getWindowedMode());
        var0.packetBuffer.writeShort(GameEngine.canvasWidth);
        var0.packetBuffer.writeShort(class262.canvasHeight);
        Client.packetWriter.addNode(var0);
    }
}
