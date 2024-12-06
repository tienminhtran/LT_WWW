
package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.backend.models.SkillLevel;


@Converter(autoApply = true)
public class SkillLevelConverter implements AttributeConverter<SkillLevel, Byte> {

    @Override
    public Byte convertToDatabaseColumn(SkillLevel skillLevel) {
        return (skillLevel!=null) ? skillLevel.getLevel() : null;
    }

    @Override
    public SkillLevel convertToEntityAttribute(Byte level) {
        return (level!=null) ? SkillLevel.fromByte(level) : null;
    }
}
