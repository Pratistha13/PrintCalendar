import java.time.DayOfWeek;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MethodsPrintCalendar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter year: ");
		int year = input.nextInt();

		System.out.print("Enter month: ");
		int month = input.nextInt();

		printCalendar(year, month);

	}

	private static void printCalendar(int year, int month) {
		LocalDate calendar = LocalDate.of(year, month, 1);

		String formattedDate = calendar.format(DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("en")));
		DayOfWeek weekDay = calendar.getDayOfWeek();
		int dayOfWeek = weekDay.getValue();
		int daysInMonth = calendar.lengthOfMonth();
		System.out.print("\n");

		System.out.println(" > " + formattedDate + " <");
		System.out.println(" Mon Tue Wed Thu Fri Sat Sun");


		String initialSpace = "";
		for (int i = 0; i < dayOfWeek - 1; i++) {
			initialSpace += "    ";
		}
		System.out.print(initialSpace);


		for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
			for (int j = ((i == 0) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
				System.out.printf("  %2d", dayOfMonth);
				dayOfMonth++;
			}
			System.out.println();
		}
	}

}
