import java.io.IOException;
import java.net.Socket;

public class class186 {

    static short[][][] Tiles_underlays;

    public static AbstractSocket method1008(Socket var0, int var1, int var2) throws IOException {
        return new BufferedNetSocket(var0, var1, var2);
    }

    static final boolean method1009(int var0, int var1, int var2, int var3, int var4) {
        PendingSpawn var5 = null;

        for (PendingSpawn var6 = (PendingSpawn) Client.pendingSpawns
                .last(); var6 != null; var6 = (PendingSpawn) Client.pendingSpawns.previous()) {
            if (var0 == var6.plane && var6.x == var1 && var2 == var6.y && var3 == var6.type) {
                var5 = var6;
                break;
            }
        }

        if (var5 != null) {
            var5.field931 = var4;
            return true;
        } else {
            return false;
        }
    }
}
