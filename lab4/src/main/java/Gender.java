import java.util.Random;

public enum Gender {
        MALE,
        FEMALE;

        public static Gender getRandomGender() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
}
