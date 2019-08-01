package com.gl.Library.com.gl.Library.Class.Library;


import com.gl.Library.com.gl.Library.Class.Object.Customer;
import com.gl.Library.com.gl.Library.Class.Object.Librarian;
import com.gl.Library.com.gl.Library.Controller.Service.LibraryService;
import com.gl.Library.com.gl.Library.View.HomeScreen;
import com.gl.Library.com.gl.Library.View.LibraryScreen;
import com.gl.Library.com.gl.Library.View.MainScreen;
import com.gl.Library.com.gl.Library.View.RegisterScreen;

public class InputParser {
    private static LibraryService service = LibraryService.getInstance();
    private static MainScreen mainScreen = new MainScreen();

    public static void controller() {
        // Property menu
        LibraryService service = LibraryService.getInstance();
        HomeScreen homeScreen = new HomeScreen();
        // Login section
        switch (HomeScreen.homeDisplay()) {
            case "1":
                // Librarian login
                String login = mainScreen.loginDisplay();
                if (login.equals("1")) {
                    Librarian loginLibrarian = mainScreen.librarianDisplay();
                    if (loginLibrarian != null) {
                        service.setLibrarianDetail(loginLibrarian);
                        adminLogin();
                    } else {
                        mainScreen.LoginFailed();
                    }
                } else {
                    // Customer login
                    if (login.equals("2")) {
                        Customer logincustomer = mainScreen.customerDisplay();
                        if (logincustomer != null) {
                            service.setCustomerDetail(logincustomer);
                            userLogin();
                        } else {
                            mainScreen.LoginFailed();
                        }
                    } else {
                        mainScreen.defaultworks();
                    }
                }
                break;
            case "2":
                // Registeration
                register();
                break;
            case "3":
                // Exit program
                mainScreen.exitCommand();

            case "Libra":
                // Extra function show all librarian account detail
                for (int i = 0; i < service.getLibrariansService().getLibrarians().size(); i++) {
                    System.out.println("Librarian Detail " + (i + 1) + " : " + service.getLibrariansService().getLibrarians().get(i));
                }
                System.out.println("=====================");
                controller();
                break;

            case "Custo":
                // Extra function show all customer account detail
                for (int i = 0; i < service.getCustomersService().getCustomers().size(); i++) {
                    System.out.println("Customer Detail " + (i + 1) + " : " + service.getCustomersService().getCustomers().get(i));
                }
                System.out.println("==========================");
                controller();
                break;

            default:
                mainScreen.defaultworks();

        }
    }

    // Librarian login pass
    public static void adminLogin() {
        System.out.println("================================");
        System.out.println("" + service.getLibrarianDetail().getFirstName() + " " + service.getLibrarianDetail().getLastName());
        service.setCustomerDetail(null);
        //******************** Select Section ********************//
        switch (mainScreen.librarianMenu()) {
            case "1":
//                Library.addBook();
                LibraryScreen.addBookshow();
                break;
            case "2":
                LibraryScreen.removeBook();
                break;
            case "3":
                LibraryScreen.searchBook();
                break;
            case "4":
                LibraryScreen.checkBook(  );
                break;
            case "5":
                LibraryScreen.historyBook();
                break;
            case "6":
                LibraryScreen.sortBook();
                break;
            case "7":
                LibraryScreen.confirmShow();
                break;
            case "8":
                LibraryScreen.changDate();
                break;
            case "9":
                service.setLibrarianDetail(null);
                controller();
                break;
            case "0":
                mainScreen.exitCommand();
            default:
                mainScreen.defaultworks();
        }
    }

    // Customer login pass
    public static void userLogin() {
        System.out.println("================================");
        System.out.println("" + service.getCustomerDetail().getFirstName() + " " + service.getCustomerDetail().getLastName());
        service.setLibrarianDetail(null);
        switch (mainScreen.customerMenu()) {
            case "1":
                LibraryScreen.searchBook();
                break;
            case "2":
               LibraryScreen.checkBook(  );
                break;
            case "3":
                LibraryScreen.borrowBook();
                break;
            case "4":
               LibraryScreen.returnBook();
                break;
            case "5":
                LibraryScreen.changDate();
                break;
            case "6":
                service.setCustomerDetail(null);
                controller();
                break;
            case "0":
                mainScreen.exitCommand();
            default:
                mainScreen.defaultworks();
        }
    }

    // Registeration new account
    public static void register() {
        System.out.println("================================");
        switch (RegisterScreen.registerMenu()) {
            case "1":
                Library.librarianRegister();
                break;
            case "2":
                Library.customerRegister();
                break;
            case "3":
                controller();
                break;
            case "4":
                mainScreen.exitCommand();
            default:
                mainScreen.defaultworks();
        }
    }
}

