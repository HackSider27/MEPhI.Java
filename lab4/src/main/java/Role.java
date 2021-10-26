import java.util.Random;

public enum Role {
    STAFF,
    MANAGER,
    EXECUTIVE;


    public static Role getRandomRole() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
