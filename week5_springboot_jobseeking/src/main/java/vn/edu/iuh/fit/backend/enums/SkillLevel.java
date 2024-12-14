package vn.edu.iuh.fit.backend.enums;
/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
public enum SkillLevel {
    BEGINNER((byte) 1),
    INTERMEDIATE((byte) 2),
    ADVANCED((byte) 3),
    PROFESSIONAL((byte) 4),
    MASTER((byte) 5);


    private byte level;

    SkillLevel(byte level) {
        this.level = level;
    }

    public byte getLevel() {
        return level;
    }
}
