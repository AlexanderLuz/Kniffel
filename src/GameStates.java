public enum GameStates {
    ROLL_DICE_PHASE(0),
    ENTER_RESULT_PHASE(1),
    ENDGAME_PHASE(2);

    private final int INDEX;

    GameStates(int index) {
        INDEX = index;
    }

    public GameStates getGameState(int i) {
        return switch (i) {
            case 1 -> ENTER_RESULT_PHASE;
            case 2 -> ENDGAME_PHASE;
            default -> ROLL_DICE_PHASE;
        };
    }

    public int getINDEX() {
        return INDEX;
    }
}
