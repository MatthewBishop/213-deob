import java.net.URL;

public class Players {

    static int field1095;

    static byte[] activityFlags = new byte[2048];

    static MoveSpeed[] playerMovementSpeeds = new MoveSpeed[2048];

    static Buffer[] cachedAppearanceBuffer = new Buffer[2048];

    static int Players_count = 0;

    static int[] Players_indices = new int[2048];

    static int Players_emptyIdxCount = 0;

    static int[] Players_emptyIndices = new int[2048];

    static int[] Players_regions = new int[2048];

    static int[] Players_orientations = new int[2048];

    static int[] Players_targetIndices = new int[2048];

    static int Players_pendingUpdateCount = 0;

    static int[] Players_pendingUpdateIndices = new int[2048];

    static Buffer field1094 = new Buffer(new byte[5000]);

    static SpritePixels[] mapMarkerSprites;

    static class429 varclan;

    static boolean loadWorlds() {
        try {
            if (class11.World_request == null) {
                class11.World_request = class14.urlRequester.request(new URL(GrandExchangeOffer.field3530));
            } else if (class11.World_request.isDone()) {
                byte[] var0 = class11.World_request.getResponse();
                Buffer var1 = new Buffer(var0);
                var1.readInt();
                World.World_count = var1.readUnsignedShort();
                class31.World_worlds = new World[World.World_count];

                World var3;
                for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
                    var3 = class31.World_worlds[var2] = new World();
                    var3.id = var1.readUnsignedShort();
                    var3.properties = var1.readInt();
                    var3.host = var1.readStringCp1252NullTerminated();
                    var3.activity = var1.readStringCp1252NullTerminated();
                    var3.location = var1.readUnsignedByte();
                    var3.population = var1.readShort();
                }

                class123.sortWorlds(class31.World_worlds, 0, class31.World_worlds.length - 1, World.World_sortOption1,
                        World.World_sortOption2);
                class11.World_request = null;
                return true;
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            class11.World_request = null;
        }

        return false;
    }
}
