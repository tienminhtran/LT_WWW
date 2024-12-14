package vn.edu.iuh.fit.backend.enums;
/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
public enum SkillType {
    SOFT_SKILL((byte) 1),
    UNSPECIFIC((byte) 2),
    TECHNICAL_SKILL((byte) 3);

    private byte type;

    SkillType(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }

}
