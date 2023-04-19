import java.text.DecimalFormat;

public class Login {

    static int xPadding = 0;

    static IndexedSprite titleboxSprite;

    static IndexedSprite options_buttons_0Sprite;

    static IndexedSprite field733;

    static IndexedSprite field745;

    static int field763;

    static Buffer field764;

    static int loginBoxX;

    static int Login_loadingPercent;

    static String Login_loadingText;

    static int field738;

    static int field752;

    static int loginIndex;

    static String Login_response0;

    static String Login_response1;

    static String Login_response2;

    static String Login_response3;

    static String Login_username;

    static String Login_password;

    static int field747;

    static String[] field748;

    static String field749;

    static boolean field730;

    static boolean field740;

    static boolean field751;

    static int currentLoginField;

    static boolean worldSelectOpen;

    static int hoveredWorldIndex;

    static int worldSelectPage;

    static int worldSelectPagesCount;

    static long field734;

    static long field759;

    static String[] field760;

    static String[] field761;

    static String[] field762;

    static {
        loginBoxX = xPadding + 202;
        Login_loadingPercent = 10;
        Login_loadingText = "";
        field738 = -1;
        field752 = 1;
        loginIndex = 0;
        Login_response0 = "";
        Login_response1 = "";
        Login_response2 = "";
        Login_response3 = "";
        Login_username = "";
        Login_password = "";
        field747 = 0;
        field748 = new String[8];
        field749 = "";
        field730 = false;
        field740 = false;
        field751 = true;
        currentLoginField = 0;
        worldSelectOpen = false;
        hoveredWorldIndex = -1;
        worldSelectPage = 0;
        worldSelectPagesCount = 0;
        new DecimalFormat("##0.00");
        new class129();
        field734 = -1L;
        field759 = -1L;
        field760 = new String[] { "title.jpg" };
        field761 = new String[] { "logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton",
                "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute",
                "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4",
                "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button" };
        field762 = new String[] { "logo_speedrunning" };
    }

    static void method444(boolean var0) {
        byte var1 = 0;
        if (!class134.method779()) {
            var1 = 12;
        } else if (ScriptFrame.client.method394() || ScriptFrame.client.method370() || ScriptFrame.client.method369()) {
            var1 = 10;
        }

        class129.method763(var1);
        if (var0) {
            Login_username = "";
            Login_password = "";
            class204.field1846 = 0;
            Messages.otp = "";
        }

        WallDecoration.method1385();
        if (Client.Login_isUsernameRemembered && Login_username != null && Login_username.length() > 0) {
            currentLoginField = 1;
        } else {
            currentLoginField = 0;
        }

    }

    static void method446() {
        if (Players.loadWorlds()) {
            worldSelectOpen = true;
            worldSelectPage = 0;
            worldSelectPagesCount = 0;
        }

    }

    static final void FriendSystem_invalidateIgnoreds() {
        class124.method742();
        if (UserComparator5.friendsChat != null) {
            UserComparator5.friendsChat.invalidateIgnoreds();
        }

    }
}
