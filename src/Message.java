public class Message extends DualNode {

    int count;

    int cycle;

    int type;

    String sender;

    Username senderUsername;

    TriBool isFromFriend0;

    TriBool isFromIgnored0;

    String prefix;

    String text;

    Message(int var1, String var2, String var3, String var4) {
        this.isFromFriend0 = TriBool.TriBool_unknown;
        this.isFromIgnored0 = TriBool.TriBool_unknown;
        this.set(var1, var2, var3, var4);
    }

    void set(int var1, String var2, String var3, String var4) {
        this.count = class129.method762();
        this.cycle = Client.cycle;
        this.type = var1;
        this.sender = var2;
        this.fillSenderUsername();
        this.prefix = var3;
        this.text = var4;
        this.clearIsFromFriend();
        this.clearIsFromIgnored();
    }

    void clearIsFromFriend() {
        this.isFromFriend0 = TriBool.TriBool_unknown;
    }

    final boolean isFromFriend() {
        if (this.isFromFriend0 == TriBool.TriBool_unknown) {
            this.fillIsFromFriend();
        }

        return this.isFromFriend0 == TriBool.TriBool_true;
    }

    void fillIsFromFriend() {
        this.isFromFriend0 = World.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true
                : TriBool.TriBool_false;
    }

    void clearIsFromIgnored() {
        this.isFromIgnored0 = TriBool.TriBool_unknown;
    }

    final boolean isFromIgnored() {
        if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
            this.fillIsFromIgnored();
        }

        return this.isFromIgnored0 == TriBool.TriBool_true;
    }

    void fillIsFromIgnored() {
        this.isFromIgnored0 = World.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true
                : TriBool.TriBool_false;
    }

    final void fillSenderUsername() {
        if (this.sender != null) {
            this.senderUsername = new Username(ModeWhere.method1953(this.sender), class70.loginType);
        } else {
            this.senderUsername = null;
        }

    }

    static void requestNetFile(Archive var0, int var1, int var2, int var3, byte var4, boolean var5) {
        long var6 = (long) ((var1 << 16) + var2);
        NetFileRequest var8 = (NetFileRequest) NetCache.NetCache_pendingPriorityWrites.get(var6);
        if (var8 == null) {
            var8 = (NetFileRequest) NetCache.NetCache_pendingPriorityResponses.get(var6);
            if (var8 == null) {
                var8 = (NetFileRequest) NetCache.NetCache_pendingWrites.get(var6);
                if (var8 != null) {
                    if (var5) {
                        var8.removeDual();
                        NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
                        --NetCache.NetCache_pendingWritesCount;
                        ++NetCache.NetCache_pendingPriorityWritesCount;
                    }

                } else {
                    if (!var5) {
                        var8 = (NetFileRequest) NetCache.NetCache_pendingResponses.get(var6);
                        if (var8 != null) {
                            return;
                        }
                    }

                    var8 = new NetFileRequest();
                    var8.archive = var0;
                    var8.crc = var3;
                    var8.padding = var4;
                    if (var5) {
                        NetCache.NetCache_pendingPriorityWrites.put(var8, var6);
                        ++NetCache.NetCache_pendingPriorityWritesCount;
                    } else {
                        NetCache.NetCache_pendingWritesQueue.addFirst(var8);
                        NetCache.NetCache_pendingWrites.put(var8, var6);
                        ++NetCache.NetCache_pendingWritesCount;
                    }

                }
            }
        }
    }

    static float method358(class125 var0, float var1, boolean var2) {
        float var3 = 0.0F;
        if (var0 != null && var0.method748() != 0) {
            float var4 = (float) var0.field1219[0].field1175;
            float var5 = (float) var0.field1219[var0.method748() - 1].field1175;
            float var6 = var5 - var4;
            if ((double) var6 == 0.0D) {
                return var0.field1219[0].field1178;
            } else {
                float var7 = 0.0F;
                if (var1 > var5) {
                    var7 = (var1 - var5) / var6;
                } else {
                    var7 = (var1 - var4) / var6;
                }

                double var8 = (double) ((int) var7);
                float var10 = Math.abs((float) ((double) var7 - var8));
                float var11 = var10 * var6;
                var8 = Math.abs(var8 + 1.0D);
                double var12 = var8 / 2.0D;
                double var14 = (double) ((int) var12);
                var10 = (float) (var12 - var14);
                float var16;
                float var17;
                if (var2) {
                    if (var0.field1220 == class123.field1204) {
                        if ((double) var10 != 0.0D) {
                            var11 += var4;
                        } else {
                            var11 = var5 - var11;
                        }
                    } else if (var0.field1220 != class123.field1202 && var0.field1220 != class123.field1203) {
                        if (var0.field1220 == class123.field1200) {
                            var11 = var4 - var1;
                            var16 = var0.field1219[0].field1174;
                            var17 = var0.field1219[0].field1172;
                            var3 = var0.field1219[0].field1178;
                            if (0.0D != (double) var16) {
                                var3 -= var11 * var17 / var16;
                            }

                            return var3;
                        }
                    } else {
                        var11 = var5 - var11;
                    }
                } else if (var0.field1236 == class123.field1204) {
                    if ((double) var10 != 0.0D) {
                        var11 = var5 - var11;
                    } else {
                        var11 += var4;
                    }
                } else if (var0.field1236 != class123.field1202 && var0.field1236 != class123.field1203) {
                    if (var0.field1236 == class123.field1200) {
                        var11 = var1 - var5;
                        var16 = var0.field1219[var0.method748() - 1].field1176;
                        var17 = var0.field1219[var0.method748() - 1].field1173;
                        var3 = var0.field1219[var0.method748() - 1].field1178;
                        if (0.0D != (double) var16) {
                            var3 += var17 * var11 / var16;
                        }

                        return var3;
                    }
                } else {
                    var11 += var4;
                }

                var3 = GrandExchangeEvent.method1923(var0, var11);
                float var18;
                if (var2 && var0.field1220 == class123.field1203) {
                    var18 = var0.field1219[var0.method748() - 1].field1178 - var0.field1219[0].field1178;
                    var3 = (float) ((double) var3 - (double) var18 * var8);
                } else if (!var2 && var0.field1236 == class123.field1203) {
                    var18 = var0.field1219[var0.method748() - 1].field1178 - var0.field1219[0].field1178;
                    var3 = (float) ((double) var3 + (double) var18 * var8);
                }

                return var3;
            }
        } else {
            return var3;
        }
    }

    public static void method355(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
        class297.musicPlayerStatus = 1;
        class297.musicTrackArchive = var0;
        class379.musicTrackGroupId = var1;
        VarpDefinition.musicTrackFileId = var2;
        class100.musicTrackVolume = var3;
        class120.musicTrackBoolean = var4;
        class162.pcmSampleLength = 10000;
    }

    static final void method350(String var0) {
        VerticalAlignment.method1036("Please remove " + var0 + " from your ignore list first");
    }

    static void widgetDefaultMenuAction(int var0, int var1, int var2, int var3, String var4) {
        Widget var5 = SoundSystem.getWidgetChild(var1, var2);
        if (var5 != null) {
            if (var5.onOp != null) {
                ScriptEvent var6 = new ScriptEvent();
                var6.widget = var5;
                var6.opIndex = var0;
                var6.targetName = var4;
                var6.args = var5.onOp;
                HealthBarUpdate.runScriptEvent(var6);
            }

            boolean var11 = true;
            if (var5.contentType > 0) {
                var11 = method353(var5);
            }

            if (var11) {
                int var8 = KeyHandler.getWidgetFlags(var5);
                int var9 = var0 - 1;
                boolean var7 = (var8 >> var9 + 1 & 1) != 0;
                if (var7) {
                    PacketBufferNode var10;
                    if (var0 == 1) {
                        var10 = class330.getPacketBufferNode(ClientPacket.IF_BUTTON1, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 2) {
                        var10 = class330.getPacketBufferNode(ClientPacket.OPLOC5, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 3) {
                        var10 = class330.getPacketBufferNode(ClientPacket.field2540, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 4) {
                        var10 = class330.getPacketBufferNode(ClientPacket.OPNPC5, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 5) {
                        var10 = class330.getPacketBufferNode(ClientPacket.OPNPC2, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 6) {
                        var10 = class330.getPacketBufferNode(ClientPacket.field2535, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 7) {
                        var10 = class330.getPacketBufferNode(ClientPacket.field2558, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 8) {
                        var10 = class330.getPacketBufferNode(ClientPacket.field2527, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 9) {
                        var10 = class330.getPacketBufferNode(ClientPacket.WALK, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                    if (var0 == 10) {
                        var10 = class330.getPacketBufferNode(ClientPacket.OPPLAYERT, Client.packetWriter.isaacCipher);
                        var10.packetBuffer.writeInt(var1);
                        var10.packetBuffer.writeShort(var2);
                        var10.packetBuffer.writeShort(var3);
                        Client.packetWriter.addNode(var10);
                    }

                }
            }
        }
    }

    static final boolean method353(Widget var0) {
        int var1 = var0.contentType;
        if (var1 == 205) {
            Client.logoutTimer = 250;
            return true;
        } else {
            int var2;
            int var3;
            if (var1 >= 300 && var1 <= 313) {
                var2 = (var1 - 300) / 2;
                var3 = var1 & 1;
                Client.playerAppearance.changeAppearance(var2, var3 == 1);
            }

            if (var1 >= 314 && var1 <= 323) {
                var2 = (var1 - 314) / 2;
                var3 = var1 & 1;
                Client.playerAppearance.method1699(var2, var3 == 1);
            }

            if (var1 == 324) {
                Client.playerAppearance.method1694(0);
            }

            if (var1 == 325) {
                Client.playerAppearance.method1694(1);
            }

            if (var1 == 326) {
                PacketBufferNode var4 = class330.getPacketBufferNode(ClientPacket.field2468,
                        Client.packetWriter.isaacCipher);
                Client.playerAppearance.write(var4.packetBuffer);
                Client.packetWriter.addNode(var4);
                return true;
            } else {
                return false;
            }
        }
    }
}
