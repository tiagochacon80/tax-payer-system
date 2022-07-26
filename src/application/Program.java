package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int taxpayers = sc.nextInt();

        for (int i = 1; i <= taxpayers; i++) {
            System.out.println("Taxpayer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'i') {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Anual income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Anuel income: ");
                double anualIncome = sc.nextDouble();
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberEmployees));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");

        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer.getName() + ":$ " + String.format("%.2f", taxPayer.tax()));
        }

        System.out.println();
        double sum = 0.0;
        for (TaxPayer taxPayer : list) {
            sum += taxPayer.tax();
        }
        System.out.println("Total taxes: $ " + String.format("%.2f", sum));
        sc.close();
    }
}
