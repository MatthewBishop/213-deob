public class FriendSystem {

    final LoginType loginType;

    public final FriendsList friendsList;

    public final IgnoreList ignoreList;

    int field672 = 0;

    FriendSystem(LoginType var1) {
        this.loginType = var1;
        this.friendsList = new FriendsList(var1);
        this.ignoreList = new IgnoreList(var1);
    }

    boolean method420() {
        return this.field672 == 2;
    }

    final void method411() {
        this.field672 = 1;
    }

    final void readUpdate(Buffer var1, int var2) {
        this.friendsList.read(var1, var2);
        this.field672 = 2;

        for (int var3 = 0; var3 < Players.Players_count; ++var3) {
            Player var4 = Client.players[Players.Players_indices[var3]];
            var4.clearIsFriend();
        }

        GameEngine.method180();
        if (UserComparator5.friendsChat != null) {
            UserComparator5.friendsChat.clearFriends();
        }

    }

    final void processFriendUpdates() {
        for (FriendLoginUpdate var1 = (FriendLoginUpdate) this.friendsList.friendLoginUpdates
                .last(); var1 != null; var1 = (FriendLoginUpdate) this.friendsList.friendLoginUpdates.previous()) {
            if ((long) var1.field3722 < class96.clockNow() / 1000L - 5L) {
                if (var1.worldId > 0) {
                    UserComparator5.addGameMessage(5, "", var1.friendUsername + " has logged in.");
                }

                if (var1.worldId == 0) {
                    UserComparator5.addGameMessage(5, "", var1.friendUsername + " has logged out.");
                }

                var1.remove();
            }
        }

    }

    final void clear() {
        this.field672 = 0;
        this.friendsList.clear();
        this.ignoreList.clear();
    }

    final boolean isFriended(Username var1, boolean var2) {
        if (var1 == null) {
            return false;
        } else if (var1.equals(MusicPatchNode.localPlayer.username)) {
            return true;
        } else {
            return this.friendsList.isFriended(var1, var2);
        }
    }

    final boolean isIgnored(Username var1) {
        if (var1 == null) {
            return false;
        } else {
            return this.ignoreList.contains(var1);
        }
    }

    final void addFriend(String var1) {
        if (var1 != null) {
            Username var2 = new Username(var1, this.loginType);
            if (var2.hasCleanName()) {
                if (this.friendsListIsFull()) {
                    VerticalAlignment
                            .method1036("Your friend list is full. Max of 200 for free users, and 400 for members");
                } else if (MusicPatchNode.localPlayer.username.equals(var2)) {
                    class33.method143();
                } else if (this.isFriended(var2, false)) {
                    VerticalAlignment.method1036(var1 + " is already on your friend list");
                } else if (this.isIgnored(var2)) {
                    Message.method350(var1);
                } else {
                    PacketBufferNode var3 = class330.getPacketBufferNode(ClientPacket.field2519,
                            Client.packetWriter.isaacCipher);
                    var3.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
                    var3.packetBuffer.writeStringCp1252NullTerminated(var1);
                    Client.packetWriter.addNode(var3);
                }
            }
        }
    }

    final boolean friendsListIsFull() {
        return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.isMembers != 1;
    }

    final void addIgnore(String var1) {
        if (var1 != null) {
            Username var2 = new Username(var1, this.loginType);
            if (var2.hasCleanName()) {
                if (this.canAddIgnore()) {
                    VerticalAlignment
                            .method1036("Your ignore list is full. Max of 100 for free users, and 400 for members");
                } else if (MusicPatchNode.localPlayer.username.equals(var2)) {
                    GrandExchangeOfferOwnWorldComparator.method364();
                } else if (this.isIgnored(var2)) {
                    VerticalAlignment.method1036(var1 + " is already on your ignore list");
                } else if (this.isFriended(var2, false)) {
                    VerticalAlignment.method1036("Please remove " + var1 + " from your friend list first");
                } else {
                    PacketBufferNode var3 = class330.getPacketBufferNode(ClientPacket.field2485,
                            Client.packetWriter.isaacCipher);
                    var3.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
                    var3.packetBuffer.writeStringCp1252NullTerminated(var1);
                    Client.packetWriter.addNode(var3);
                }
            }
        }
    }

    final boolean canAddIgnore() {
        return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.isMembers != 1;
    }

    final void removeFriend(String var1) {
        if (var1 != null) {
            Username var2 = new Username(var1, this.loginType);
            if (var2.hasCleanName()) {
                if (this.friendsList.removeByUsername(var2)) {
                    Client.field557 = Client.cycleCntr;
                    PacketBufferNode var3 = class330.getPacketBufferNode(ClientPacket.field2560,
                            Client.packetWriter.isaacCipher);
                    var3.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
                    var3.packetBuffer.writeStringCp1252NullTerminated(var1);
                    Client.packetWriter.addNode(var3);
                }

                for (int var5 = 0; var5 < Players.Players_count; ++var5) {
                    Player var4 = Client.players[Players.Players_indices[var5]];
                    var4.clearIsFriend();
                }

                GameEngine.method180();
                if (UserComparator5.friendsChat != null) {
                    UserComparator5.friendsChat.clearFriends();
                }

            }
        }
    }

    public final void removeIgnore(String var1, boolean var2) {
        if (var1 != null) {
            Username var3 = new Username(var1, this.loginType);
            if (var3.hasCleanName()) {
                if (this.ignoreList.removeByUsername(var3)) {
                    Client.field557 = Client.cycleCntr;
                    if (var2) {
                        PacketBufferNode var4 = class330.getPacketBufferNode(ClientPacket.field2478,
                                Client.packetWriter.isaacCipher);
                        var4.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var1));
                        var4.packetBuffer.writeStringCp1252NullTerminated(var1);
                        Client.packetWriter.addNode(var4);
                    }
                }

                Login.FriendSystem_invalidateIgnoreds();
            }
        }
    }

    final boolean isFriendAndHasWorld(Username var1) {
        Friend var2 = (Friend) this.friendsList.getByUsername(var1);
        return var2 != null && var2.hasWorld();
    }

    static int method425(int var0, Script var1, boolean var2) {
        return 2;
    }
}
