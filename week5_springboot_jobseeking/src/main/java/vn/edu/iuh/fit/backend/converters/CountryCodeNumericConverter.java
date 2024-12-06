

package vn.edu.iuh.fit.backend.converters;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class CountryCodeNumericConverter implements AttributeConverter<CountryCode, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CountryCode countryCode) {
        return countryCode != null ? countryCode.getNumeric(): null;
    }

    @Override
    public CountryCode convertToEntityAttribute(Integer integer) {
        return integer != null ? CountryCode.getByCode(integer): null;
    }
}