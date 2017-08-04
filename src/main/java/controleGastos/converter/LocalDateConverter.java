package controleGastos.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public final class LocalDateConverter implements Converter<String, LocalDate>{

	private DateTimeFormatter pattern;

	public LocalDateConverter(String dateFormat) {
		pattern = DateTimeFormatter.ofPattern(dateFormat);
	}
	
	public LocalDate convert(String source) {
		if(source == null || source.isEmpty())
			return null;
		return LocalDate.parse(source,pattern);
	}

}
