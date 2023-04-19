public class FriendsChat extends UserList {

    static int worldPort;

    final LoginType loginType;

    final Usernamed localUser;

    public String name = null;

    public String owner = null;

    public byte minKick;

    public int rank;

    int memberCount = 1;

    public FriendsChat(LoginType var1, Usernamed var2) {
        super(500);
        this.loginType = var1;
        this.localUser = var2;
    }

    User newInstance() {
        return new ClanMate();
    }

    User[] newTypedArray(int var1) {
        return new ClanMate[var1];
    }

    final void method2141(String var1) {
        this.name = SecureRandomFuture.method458(var1);
    }

    final void method2147(String var1) {
        this.owner = SecureRandomFuture.method458(var1);
    }

    public final void method2142(Buffer var1, int var2) {
        this.method2147(var1.readStringCp1252NullTerminated());
        long var3 = var1.readLong();
        this.method2141(class244.method1393(var3));
        this.minKick = var1.readByte();
        int var5;
        short var6;
        if (var2 == 1) {
            var5 = var1.readUnsignedByte();
            var6 = 255;
        } else {
            if (var2 != 2) {
                throw new IllegalArgumentException("Invalid friend chat full update version: " + var2);
            }

            var5 = var1.method2491();
            var6 = -1;
        }

        if (var5 != var6) {
            int var7 = var5;
            this.clear();

            for (int var8 = 0; var8 < var7; ++var8) {
                ClanMate var9 = (ClanMate) this
                        .addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
                int var10 = var1.readUnsignedShort();
                var9.set(var10, ++this.memberCount - 1);
                var9.rank = var1.readByte();
                var1.readStringCp1252NullTerminated();
                this.isLocalPlayer(var9);
            }

        }
    }

    public final void method2146(Buffer var1) {
        Username var2 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
        int var3 = var1.readUnsignedShort();
        byte var4 = var1.readByte();
        boolean var5 = false;
        if (var4 == -128) {
            var5 = true;
        }

        ClanMate var6;
        if (var5) {
            if (this.getSize() == 0) {
                return;
            }

            var6 = (ClanMate) this.getByCurrentUsername(var2);
            if (var6 != null && var6.getWorld() == var3) {
                this.remove(var6);
            }
        } else {
            var1.readStringCp1252NullTerminated();
            var6 = (ClanMate) this.getByCurrentUsername(var2);
            if (var6 == null) {
                if (this.getSize() > super.capacity) {
                    return;
                }

                var6 = (ClanMate) this.addLastNoPreviousUsername(var2);
            }

            var6.set(var3, ++this.memberCount - 1);
            var6.rank = var4;
            this.isLocalPlayer(var6);
        }

    }

    public final void clearFriends() {
        for (int var1 = 0; var1 < this.getSize(); ++var1) {
            ((ClanMate) this.get(var1)).clearIsFriend();
        }

    }

    public final void invalidateIgnoreds() {
        for (int var1 = 0; var1 < this.getSize(); ++var1) {
            ((ClanMate) this.get(var1)).clearIsIgnored();
        }

    }

    final void isLocalPlayer(ClanMate var1) {
        if (var1.getUsername().equals(this.localUser.username())) {
            this.rank = var1.rank;
        }

    }

    static final void method2139(int var0, int var1, int var2, int var3) {
        for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
            if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0
                    && Client.rootWidgetXs[var4] < var0 + var2
                    && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1
                    && Client.rootWidgetYs[var4] < var3 + var1) {
                Client.field574[var4] = true;
            }
        }

    }
}
