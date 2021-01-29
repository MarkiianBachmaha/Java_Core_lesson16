package task01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		Class person = Person.class;

		String nameOfClass = person.getName();
		System.out.println("Name of class = " + nameOfClass);
		System.out.println();

		String simpleName = person.getSimpleName();
		System.out.println("Simple name of class = " + simpleName);
		System.out.println();

		int modifier = person.getModifiers();
		System.out.println("Class modifier = " + modifier);
		System.out.println();

		System.out.println("Is static = " + Modifier.isStatic(modifier));
		System.out.println("Is public = " + Modifier.isPublic(modifier));
		System.out.println("Is abstract = " + Modifier.isAbstract(modifier));
		System.out.println();

		Package classPackage = person.getPackage();
		System.out.println("Package of current class = " + classPackage);
		System.out.println();

		Class superClass = person.getSuperclass();
		System.out.println("Super class = " + superClass);
		System.out.println();

		Class[] interfaces = person.getInterfaces();
		System.out.println("Interfaces = " + Arrays.toString(interfaces));
		System.out.println();

		Constructor<Person>[] personConstructor = person.getConstructors();

		for (int i = 0; i < personConstructor.length; i++) {
			Constructor<Person> constructor = personConstructor[i];
			System.out.println("Constructor = " + constructor);
		}

		System.out.println("Constructors size = " + personConstructor.length);
		System.out.println();

		Constructor<Person> singleConstructor = person.getConstructor(String.class, int.class);
		System.out.println("Single constructor = " + singleConstructor);
		Person newInstancePerson = singleConstructor.newInstance("Frank", 26);
		System.out.println("Reflection Person = " + newInstancePerson);
		System.out.println();

		Field[] fields = person.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		System.out.println();

		fields = person.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}

		Field nameField = person.getField("name");
		nameField.set(newInstancePerson, "Charlie");
		System.out.println("Person new name = " + newInstancePerson);
		System.out.println();

		Field privateLastNameField = fields[1];
		privateLastNameField.setAccessible(true);
		System.out.println("Private value = " + privateLastNameField.get(newInstancePerson));
		System.out.println();

		Method[] methods = person.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}
		System.out.println();

		methods[4].invoke(newInstancePerson, "Paul");
		methods[8].invoke(newInstancePerson, 57);

		System.out.println(newInstancePerson);

	}

}