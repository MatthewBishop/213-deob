public class Friend extends Buddy {

    boolean field3719;

    boolean field3718;

    int compareToFriend(Friend var1) {
        if (super.world == Client.worldId && Client.worldId != var1.world) {
            return -1;
        } else if (Client.worldId == var1.world && super.world != Client.worldId) {
            return 1;
        } else if (super.world != 0 && var1.world == 0) {
            return -1;
        } else if (var1.world != 0 && super.world == 0) {
            return 1;
        } else if (this.field3719 && !var1.field3719) {
            return -1;
        } else if (!this.field3719 && var1.field3719) {
            return 1;
        } else if (this.field3718 && !var1.field3718) {
            return -1;
        } else if (!this.field3718 && var1.field3718) {
            return 1;
        } else {
            return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
        }
    }

    public int compareTo_user(User var1) {
        return this.compareToFriend((Friend) var1);
    }

    public int compareTo(Object var1) {
        return this.compareToFriend((Friend) var1);
    }

    static void method2151() {
        WorldMapRegion.WorldMapRegion_cachedSprites.clear();
    }

    static final void method2153() {
        Client.field476 = 0;
        int var0 = (MusicPatchNode.localPlayer.x >> 7) + WorldMapData_0.baseX;
        int var1 = (MusicPatchNode.localPlayer.y >> 7) + GameObject.baseY;
        if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
            Client.field476 = 1;
        }

        if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
            Client.field476 = 1;
        }

        if (Client.field476 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
            Client.field476 = 0;
        }

    }

    static String method2152(int var0) {
        if (var0 < 0) {
            return "";
        } else {
            return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0]
                    : Client.menuActions[var0];
        }
    }
}
