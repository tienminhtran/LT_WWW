package vn.edu.iuh.fit.week2_phantiensinh.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter(autoApply = true )
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {


    /**
     * Hàm này chuyển đổi một đối tượng Enum (EmployeeStatus) thành một giá trị Integer để lưu vào cơ sở dữ liệu.
     * @param attribute
     * @return
     */
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if(attribute==null){
            return null;
        }
        return attribute.getValue();
    }

    /**
     * Hàm này chuyển đổi một giá trị Integer từ cơ sở dữ liệu thành đối tượng Enum tương ứng (EmployeeStatus).
     * @param dbData
     * @return
     */
    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null){
            return null;
        }
        return Stream.of(EmployeeStatus.values())
                .filter(c-> c.getValue() ==dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
