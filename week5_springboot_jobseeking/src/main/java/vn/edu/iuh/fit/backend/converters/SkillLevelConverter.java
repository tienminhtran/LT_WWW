
package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Byte> {

    @Override
    public Byte convertToDatabaseColumn(SkillLevel skillLevel) {
        return (skillLevel!=null) ? skillLevel.getLevel() : null;
    }

    @Override
    public SkillLevel convertToEntityAttribute(Byte level) {
        if (level == null) {
            return null;
        }
        for (SkillLevel skillLevel : SkillLevel.values()) {
            if (skillLevel.getLevel() == level) {
                return skillLevel;
            }
        }
        throw new IllegalArgumentException("Unknown level: " + level);
    }
}
