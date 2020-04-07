package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();
		int x = 0;

		List<Employee> employees = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			System.out.println("Employee #" + i + ":");

			int id = sc.nextInt();
			Employee employee = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
			
			if (employee != null) {
				System.out.println("Id already exists.\nEnter id: ");
				int newID = sc.nextInt();
				employee = employees.stream().filter(e -> e.getId() == newID).findFirst().orElse(null);
				x = newID;
			}

			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.println("Salary: ");
			double salary = sc.nextDouble();

			if (x == 0)
				employees.add(new Employee(id, name, salary));
			else
				employees.add(new Employee(x, name, salary));
		}

		{
			System.out.println("\nEnter the employee id that will have the salary increase: ");
			int id = sc.nextInt();
			Employee employee = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
	
			if (employee == null)
				System.out.println("This id does not exist!");
			else {
				System.out.println("Enter the percentage: ");
				double percentage = sc.nextDouble();
				employee.increaseSalary(percentage);
			}
		}

		System.out.println("\nList of employees:");
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		sc.close();

	}

}
