package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		Consumer<Field> printer = f -> System.out.println(String.format("%s %s %s",
				Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));

		String line;
		while (!"HARVEST".equals(line = reader.readLine())) {
			String finalLine = line;
			Field[] filteredFields = Arrays.stream(fields)
					.filter(f -> Modifier.toString(f.getModifiers()).equals(finalLine))
					.toArray(Field[]::new);

			if (filteredFields.length == 0) {
				Arrays.stream(fields).forEach(printer);
			} else {
				Arrays.stream(filteredFields).forEach(printer);
			}
		}
	}
}
