public enum StudioGame implements class356 {

    runescape("runescape", "RuneScape", 0),

    stellardawn("stellardawn", "Stellar Dawn", 1),

    game3("game3", "Game 3", 2),

    game4("game4", "Game 4", 3),

    game5("game5", "Game 5", 4),

    oldscape("oldscape", "RuneScape 2007", 5);

    public final String name;

    final int id;

    StudioGame(String var3, String var4, int var5) {
        this.name = var3;
        this.id = var5;
    }

    public int rsOrdinal() {
        return this.id;
    }

    public static PlayerType[] PlayerType_values() {
        return new PlayerType[] { PlayerType.PlayerType_ironman, PlayerType.PlayerType_normal, PlayerType.field3434,
                PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_ultimateIronman, PlayerType.field3440,
                PlayerType.field3430, PlayerType.field3433, PlayerType.field3439, PlayerType.field3444,
                PlayerType.field3432, PlayerType.field3437, PlayerType.PlayerType_playerModerator, PlayerType.field3436,
                PlayerType.PlayerType_hardcoreIronman, PlayerType.field3431, PlayerType.field3428 };
    }
}
