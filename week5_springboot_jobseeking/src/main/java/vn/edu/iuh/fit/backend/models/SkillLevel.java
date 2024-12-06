package vn.edu.iuh.fit.backend.models;

public enum SkillLevel {
    BEGINNER(1),
    INTERMEDIATE(2),
    ADVANCED(3),
    PROFESSIONAL(4),
    MASTER(5);


    private final byte level;

    SkillLevel(int level) {
        this.level = (byte) level;
    }

    public byte getLevel() {
        return level;
    }

    public static SkillLevel fromByte(byte level) {
        for (SkillLevel skillLevel : SkillLevel.values()) {
            if (skillLevel.getLevel() == level) {
                return skillLevel;
            }
        }
        throw new IllegalArgumentException("Unknown level: " + level);
    }
}
