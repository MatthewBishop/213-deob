public class UserComparator8 extends AbstractUserComparator {

    static int field1157;

    static String worldHost;

    final boolean reversed;

    public UserComparator8(boolean var1) {
        this.reversed = var1;
    }

    int compareBuddy(Buddy var1, Buddy var2) {
        if (Client.worldId == var1.world) {
            if (var2.world != Client.worldId) {
                return this.reversed ? -1 : 1;
            }
        } else if (var2.world == Client.worldId) {
            return this.reversed ? 1 : -1;
        }

        return this.compareUser(var1, var2);
    }

    public int compare(Object var1, Object var2) {
        return this.compareBuddy((Buddy) var1, (Buddy) var2);
    }

    public static int method688(int var0, int var1) {
        return (int) Math.round(Math.atan2((double) var0, (double) var1) * 2607.5945876176133D) & 16383;
    }

    static float[] method686(JSONObject var0, String var1) throws JSONException {
        float[] var2 = new float[4];

        try {
            JSONArray var3 = var0.getJSONArray(var1);
            var2[0] = (float) var3.optDouble(0, 0.0D);
            var2[1] = (float) var3.optDouble(1, 0.0D);
            var2[2] = (float) var3.optDouble(2, 1.0D);
            var2[3] = (float) var3.optDouble(3, 1.0D);
        } catch (JSONException var4) {
            var2[0] = 0.0F;
            var2[1] = 0.0F;
            var2[2] = 1.0F;
            var2[3] = 1.0F;
        }

        return var2;
    }

    static final void method689() {
        if (GameEngine.Client_plane != Client.field596) {
            Client.field596 = GameEngine.Client_plane;
            int var0 = GameEngine.Client_plane;
            int[] var1 = UrlRequester.sceneMinimapSprite.pixels;
            int var2 = var1.length;

            int var3;
            for (var3 = 0; var3 < var2; ++var3) {
                var1[var3] = 0;
            }

            int var4;
            int var5;
            for (var3 = 1; var3 < 103; ++var3) {
                var4 = (103 - var3) * 2048 + 24628;

                for (var5 = 1; var5 < 103; ++var5) {
                    if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
                        class31.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
                    }

                    if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
                        class31.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
                    }

                    var4 += 4;
                }
            }

            var3 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8)
                    + (238 + (int) (Math.random() * 20.0D) - 10);
            var4 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
            UrlRequester.sceneMinimapSprite.setRaster();

            int var6;
            for (var5 = 1; var5 < 103; ++var5) {
                for (var6 = 1; var6 < 103; ++var6) {
                    if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
                        class149.drawObject(var0, var6, var5, var3, var4);
                    }

                    if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
                        class149.drawObject(var0 + 1, var6, var5, var3, var4);
                    }
                }
            }

            Client.mapIconCount = 0;

            for (var5 = 0; var5 < 104; ++var5) {
                for (var6 = 0; var6 < 104; ++var6) {
                    long var7 = class31.scene.getFloorDecorationTag(GameEngine.Client_plane, var5, var6);
                    if (var7 != 0L) {
                        int var9 = InterfaceParent.Entity_unpackID(var7);
                        int var10 = class144.getObjectDefinition(var9).mapIconId;
                        if (var10 >= 0 && class354.WorldMapElement_get(var10).field1491) {
                            Client.mapIcons[Client.mapIconCount] = class354.WorldMapElement_get(var10)
                                    .getSpriteBool(false);
                            Client.mapIconXs[Client.mapIconCount] = var5;
                            Client.mapIconYs[Client.mapIconCount] = var6;
                            ++Client.mapIconCount;
                        }
                    }
                }
            }

            RouteStrategy.rasterProvider.apply();
        }

    }
}
