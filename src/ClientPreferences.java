import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ClientPreferences {

    boolean roofsHidden;

    boolean hideUsername = false;

    boolean titleMusicDisabled;

    boolean displayFps = false;

    int field1040;

    double brightness = 0.8D;

    int musicVolume = 127;

    int soundEffectsVolume = 127;

    int areaSoundEffectsVolume = 127;

    int field1036 = -1;

    String rememberedUsername = null;

    int windowMode = 1;

    final Map parameters = new LinkedHashMap();

    ClientPreferences() {
        this.method557(true);
    }

    ClientPreferences(Buffer var1) {
        if (var1 != null && var1.array != null) {
            int var2 = var1.readUnsignedByte();
            if (var2 >= 0 && var2 <= 10) {
                if (var1.readUnsignedByte() == 1) {
                    this.roofsHidden = true;
                }

                if (var2 > 1) {
                    this.titleMusicDisabled = var1.readUnsignedByte() == 1;
                }

                if (var2 > 3) {
                    this.windowMode = var1.readUnsignedByte();
                }

                if (var2 > 2) {
                    int var3 = var1.readUnsignedByte();

                    for (int var4 = 0; var4 < var3; ++var4) {
                        int var5 = var1.readInt();
                        int var6 = var1.readInt();
                        this.parameters.put(var5, var6);
                    }
                }

                if (var2 > 4) {
                    this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
                }

                if (var2 > 5) {
                    this.hideUsername = var1.readBoolean();
                }

                if (var2 > 6) {
                    this.brightness = (double) var1.readUnsignedByte() / 100.0D;
                    this.musicVolume = var1.readUnsignedByte();
                    this.soundEffectsVolume = var1.readUnsignedByte();
                    this.areaSoundEffectsVolume = var1.readUnsignedByte();
                }

                if (var2 > 7) {
                    this.field1036 = var1.readUnsignedByte();
                }

                if (var2 > 8) {
                    this.displayFps = var1.readUnsignedByte() == 1;
                }

                if (var2 > 9) {
                    this.field1040 = var1.readInt();
                }
            } else {
                this.method557(true);
            }
        } else {
            this.method557(true);
        }

    }

    void method557(boolean var1) {
    }

    Buffer toBuffer() {
        Buffer var1 = new Buffer(417, true);
        var1.writeByte(10);
        var1.writeByte(this.roofsHidden ? 1 : 0);
        var1.writeByte(this.titleMusicDisabled ? 1 : 0);
        var1.writeByte(this.windowMode);
        var1.writeByte(this.parameters.size());
        Iterator var2 = this.parameters.entrySet().iterator();

        while (var2.hasNext()) {
            Entry var3 = (Entry) var2.next();
            var1.writeInt((Integer) var3.getKey());
            var1.writeInt((Integer) var3.getValue());
        }

        var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
        var1.writeBoolean(this.hideUsername);
        var1.writeByte((int) (this.brightness * 100.0D));
        var1.writeByte(this.musicVolume);
        var1.writeByte(this.soundEffectsVolume);
        var1.writeByte(this.areaSoundEffectsVolume);
        var1.writeByte(this.field1036);
        var1.writeByte(this.displayFps ? 1 : 0);
        var1.writeInt(this.field1040);
        return var1;
    }

    void setRoofsHidden(boolean var1) {
        this.roofsHidden = var1;
        class100.savePreferences();
    }

    boolean getRoofsHidden() {
        return this.roofsHidden;
    }

    void setIsUsernameHidden(boolean var1) {
        this.hideUsername = var1;
        class100.savePreferences();
    }

    boolean getIsUsernameHidden() {
        return this.hideUsername;
    }

    void getTitleMusicDisabled(boolean var1) {
        this.titleMusicDisabled = var1;
        class100.savePreferences();
    }

    boolean getTitleMusicDisabled() {
        return this.titleMusicDisabled;
    }

    void method580(boolean var1) {
        this.displayFps = var1;
        class100.savePreferences();
    }

    void method556() {
        this.method580(!this.displayFps);
    }

    boolean method562() {
        return this.displayFps;
    }

    void method587(int var1) {
        this.field1040 = var1;
        class100.savePreferences();
    }

    int method573() {
        return this.field1040;
    }

    void setBrightness(double var1) {
        this.brightness = var1;
        class100.savePreferences();
    }

    double getBrightness() {
        return this.brightness;
    }

    void setCurrentMusicVolume(int var1) {
        this.musicVolume = var1;
        class100.savePreferences();
    }

    int getCurrentMusicVolume() {
        return this.musicVolume;
    }

    void setCurrentSoundEffectVolume(int var1) {
        this.soundEffectsVolume = var1;
        class100.savePreferences();
    }

    int getCurrentSoundEffectsVolume() {
        return this.soundEffectsVolume;
    }

    void setAreaSoundEffectsVolume(int var1) {
        this.areaSoundEffectsVolume = var1;
        class100.savePreferences();
    }

    int getAreaSoundEffectsVolume() {
        return this.areaSoundEffectsVolume;
    }

    void setUsernameToRemember(String var1) {
        this.rememberedUsername = var1;
        class100.savePreferences();
    }

    String getUsernameToRemember() {
        return this.rememberedUsername;
    }

    void method574(int var1) {
        this.field1036 = var1;
        class100.savePreferences();
    }

    int method575() {
        return this.field1036;
    }

    void method576(int var1) {
        this.windowMode = var1;
        class100.savePreferences();
    }

    int method577() {
        return this.windowMode;
    }

    void method582(String var1, int var2) {
        int var3 = this.method581(var1);
        if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
            Iterator var4 = this.parameters.entrySet().iterator();
            var4.next();
            var4.remove();
        }

        this.parameters.put(var3, var2);
        class100.savePreferences();
    }

    boolean method563(String var1) {
        int var2 = this.method581(var1);
        return this.parameters.containsKey(var2);
    }

    int method579(String var1) {
        int var2 = this.method581(var1);
        return !this.parameters.containsKey(var2) ? 0 : (Integer) this.parameters.get(var2);
    }

    int method581(String var1) {
        return Actor.method539(var1.toLowerCase());
    }

    static final void method583(PacketBuffer var0, int var1, Player var2, int var3) {
        byte var4 = MoveSpeed.STATIONARY.speed;
        int var5;
        if ((var3 & 2) != 0) {
            var5 = var0.readUnsignedByteNeg();
            byte[] var6 = new byte[var5];
            Buffer var7 = new Buffer(var6);
            var0.readBytes(var6, 0, var5);
            Players.cachedAppearanceBuffer[var1] = var7;
            var2.read(var7);
        }

        int var13;
        if ((var3 & 16) != 0) {
            var5 = var0.readUnsignedShortAdd();
            if (var5 == 65535) {
                var5 = -1;
            }

            var13 = var0._readUnsignedByteSub();
            FloorDecoration.performPlayerAnimation(var2, var5, var13);
        }

        if ((var3 & 4) != 0) {
            var2.targetIndex = var0.readUnsignedShortLE();
            var2.targetIndex += var0.readUnsignedByteNeg() << 16;
            var5 = 16777215;
            if (var2.targetIndex == var5) {
                var2.targetIndex = -1;
            }
        }

        if ((var3 & 128) != 0) {
            var2.overheadText = var0.readStringCp1252NullTerminated();
            if (var2.overheadText.charAt(0) == '~') {
                var2.overheadText = var2.overheadText.substring(1);
                UserComparator5.addGameMessage(2, var2.username.getName(), var2.overheadText);
            } else if (var2 == MusicPatchNode.localPlayer) {
                UserComparator5.addGameMessage(2, var2.username.getName(), var2.overheadText);
            }

            var2.isAutoChatting = false;
            var2.field957 = 0;
            var2.field1002 = 0;
            var2.overheadTextCyclesRemaining = 150;
        }

        int var8;
        int var9;
        int var12;
        int var14;
        if ((var3 & 64) != 0) {
            var5 = var0.readUnsignedByte();
            int var10;
            int var11;
            if (var5 > 0) {
                for (var13 = 0; var13 < var5; ++var13) {
                    var8 = -1;
                    var9 = -1;
                    var10 = -1;
                    var14 = var0.readUShortSmart();
                    if (var14 == 32767) {
                        var14 = var0.readUShortSmart();
                        var9 = var0.readUShortSmart();
                        var8 = var0.readUShortSmart();
                        var10 = var0.readUShortSmart();
                    } else if (var14 != 32766) {
                        var9 = var0.readUShortSmart();
                    } else {
                        var14 = -1;
                    }

                    var11 = var0.readUShortSmart();
                    var2.addHitSplat(var14, var9, var8, var10, Client.cycle, var11);
                }
            }

            var13 = var0.readUnsignedByteNeg();
            if (var13 > 0) {
                for (var14 = 0; var14 < var13; ++var14) {
                    var8 = var0.readUShortSmart();
                    var9 = var0.readUShortSmart();
                    if (var9 != 32767) {
                        var10 = var0.readUShortSmart();
                        var11 = var0.readUnsignedByteAdd();
                        var12 = var9 > 0 ? var0._readUnsignedByteSub() : var11;
                        var2.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
                    } else {
                        var2.removeHealthBar(var8);
                    }
                }
            }
        }

        if ((var3 & 1) != 0) {
            var2.movingOrientation = var0.readUnsignedShort();
            if (var2.pathLength == 0) {
                var2.orientation = var2.movingOrientation;
                var2.method527();
            }
        }

        if ((var3 & 32) != 0) {
            var5 = var0.readUnsignedShortAdd();
            PlayerType var17 = (PlayerType) StructComposition.findEnumerated(StudioGame.PlayerType_values(),
                    var0.readUnsignedByte());
            boolean var21 = var0._readUnsignedByteSub() == 1;
            var8 = var0.readUnsignedByteNeg();
            var9 = var0.offset;
            if (var2.username != null && var2.appearance != null) {
                boolean var20 = false;
                if (var17.isUser && World.friendSystem.isIgnored(var2.username)) {
                    var20 = true;
                }

                if (!var20 && Client.field476 == 0 && !var2.isHidden) {
                    Players.field1094.offset = 0;
                    var0.readBytes(Players.field1094.array, 0, var8);
                    Players.field1094.offset = 0;
                    String var15 = AbstractFont.escapeBrackets(
                            BuddyRankComparator.method711(SceneTilePaint.readString(Players.field1094)));
                    var2.overheadText = var15.trim();
                    var2.field957 = var5 >> 8;
                    var2.field1002 = var5 & 255;
                    var2.overheadTextCyclesRemaining = 150;
                    var2.isAutoChatting = var21;
                    var2.showPublicPlayerChat = var2 != MusicPatchNode.localPlayer && var17.isUser
                            && "" != Client.field586 && var15.toLowerCase().indexOf(Client.field586) == -1;
                    if (var17.isPrivileged) {
                        var12 = var21 ? 91 : 1;
                    } else {
                        var12 = var21 ? 90 : 2;
                    }

                    if (var17.modIcon != -1) {
                        UserComparator5.addGameMessage(var12,
                                ArchiveDiskActionHandler.addImageTag(var17.modIcon) + var2.username.getName(), var15);
                    } else {
                        UserComparator5.addGameMessage(var12, var2.username.getName(), var15);
                    }
                }
            }

            var0.offset = var9 + var8;
        }

        if ((var3 & 4096) != 0) {
            var5 = var0.readUnsignedShort();
            var13 = var0.method2519();
            var2.updateGraphic(0, var5, var13 >> 16, var13 & '\uffff');
        }

        if ((var3 & 1024) != 0) {
            var2.field983 = var0.readByte();
            var2.field985 = var0.method2503();
            var2.field984 = var0.method2535();
            var2.field1003 = var0.method2535();
            var2.spotAnimation = var0.readUnsignedShortLE() + Client.cycle;
            var2.exactMoveArrive1Cycle = var0.readUnsignedShort() + Client.cycle;
            var2.exactMoveDirection = var0.readUnsignedShortLE();
            if (var2.hasMovementPending) {
                var2.field983 += var2.tileX;
                var2.field985 += var2.tileY;
                var2.field984 += var2.tileX;
                var2.field1003 += var2.tileY;
                var2.pathLength = 0;
            } else {
                var2.field983 += var2.pathX[0];
                var2.field985 += var2.pathY[0];
                var2.field984 += var2.pathX[0];
                var2.field1003 += var2.pathY[0];
                var2.pathLength = 1;
            }

            var2.field1006 = 0;
        }

        if ((var3 & 512) != 0) {
            MoveSpeed[] var16 = Players.playerMovementSpeeds;
            MoveSpeed[] var19 = new MoveSpeed[] { MoveSpeed.WALK, MoveSpeed.STATIONARY, MoveSpeed.CRAWL,
                    MoveSpeed.RUN };
            var16[var1] = (MoveSpeed) StructComposition.findEnumerated(var19, var0.method2531());
        }

        if ((var3 & 2048) != 0) {
            var4 = var0.readByte();
        }

        if ((var3 & 8192) != 0) {
            for (var5 = 0; var5 < 3; ++var5) {
                var2.actions[var5] = var0.readStringCp1252NullTerminated();
            }
        }

        if ((var3 & '耀') != 0) {
            var2.recolourStartCycle = Client.cycle + var0.readUnsignedShortLE();
            var2.recolourEndCycle = Client.cycle + var0.readUnsignedShort();
            var2.recolourHue = var0.readByte();
            var2.recolourSaturation = var0.readByte();
            var2.recolourLuminance = var0.method2531();
            var2.recolourAmount = (byte) var0._readUnsignedByteSub();
        }

        if ((var3 & 65536) != 0) {
            var5 = var0.readUnsignedByteAdd();

            for (var13 = 0; var13 < var5; ++var13) {
                var14 = var0._readUnsignedByteSub();
                var8 = var0.readUnsignedShortLE();
                var9 = var0.readInt();
                var2.updateGraphic(var14, var8, var9 >> 16, var9 & '\uffff');
            }
        }

        if (var2.hasMovementPending) {
            if (var4 == 127) {
                var2.resetPath(var2.tileX, var2.tileY);
            } else {
                MoveSpeed var22;
                if (var4 != MoveSpeed.STATIONARY.speed) {
                    MoveSpeed[] var18 = new MoveSpeed[] { MoveSpeed.WALK, MoveSpeed.STATIONARY, MoveSpeed.CRAWL,
                            MoveSpeed.RUN };
                    var22 = (MoveSpeed) StructComposition.findEnumerated(var18, var4);
                } else {
                    var22 = Players.playerMovementSpeeds[var1];
                }

                var2.move(var2.tileX, var2.tileY, var22);
            }
        }

    }
}
