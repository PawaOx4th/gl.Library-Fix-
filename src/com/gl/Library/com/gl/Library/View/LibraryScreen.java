package com.gl.Library.com.gl.Library.View;


import com.gl.Library.com.gl.Library.Class.Enum.BookCategory;
import com.gl.Library.com.gl.Library.Class.Enum.BookSituation;
import com.gl.Library.com.gl.Library.Class.Library.InputParser;
import com.gl.Library.com.gl.Library.Class.Library.Library;
import com.gl.Library.com.gl.Library.Class.Object.Book;
import com.gl.Library.com.gl.Library.Class.Object.History;
import com.gl.Library.com.gl.Library.Controller.Service.LibraryService;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

public class LibraryScreen {
    private static LibraryService service = LibraryService.getInstance();
    private static InputParser inputParser = new InputParser();

    public static void checkBook() {
        // Display book
        System.out.println("================================");
        for (int i = 0; i < service.getBooksService().getBooks().size(); i++) {
            System.out.println("Book Detail " + (i + 1) + " : " + service.getBooksService().getBooks().get(i));
        }
        LibraryScreen.SessionCheck(null);
    }


    // Add book input
    public static String[] addDisplay() {
        Scanner scanner = new Scanner(System.in);                                   // Create scanner to get input //
        System.out.print("Please enter book name : ");
        String name = scanner.nextLine();
        System.out.print("Please enter book category : ");
        String category = scanner.nextLine();
        System.out.print("Please enter book author : ");
        String author = scanner.nextLine();
        System.out.print("Please enter book abstract : ");
        String abstracts = scanner.nextLine();
        return new String[]{name, category, author, abstracts};
    }
    public static void addBookshow(){
        String[] value = LibraryScreen.addDisplay();
        Library.addBook( value);
    }
    /*---------------------------------------------------------------------------------------*/

    // Remove book input
    public static String removeDisplay() {
        Scanner scanner = new Scanner(System.in);                                       // Create scanner to get input //
        System.out.println("Please enter book code to remove : ");
        return scanner.nextLine();
    }
    public static  void removeBook(){
        String id = LibraryScreen.removeDisplay();
        Library.removeBook(id);
        int ID = Integer.valueOf(id);
//        System.out.println("Book code : " + book.getBookCode() + " remove successful");
//        System.out.println("Book code : " + service.getBooksService().getBooks().get(ID)+ " remove successful");
    }
    public static  void removeBookshow(String id,int show){
        switch (show){
            case 1 :
                System.out.println("Book code : " + id + " remove successful");
                checkBook();
                break;
            case 2:
                System.out.println("Sorry your book code is not exist");
                break;
        }
    }

    /*---------------------------------------------------------------------------------------*/
    // Search menu
    public static String searchDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your search type");
        System.out.println("1 - Search by name\n2 - Search by Category\n3 - Search by Code");
        return scanner.nextLine();
    }

    // Search by name
    public static String searchNameDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book name to search : ");
        return scanner.nextLine();
    }
    public  static void searchNameshow(){
        String name = LibraryScreen.searchNameDisplay();
        Library.SearchByName(Boolean.FALSE ,name);
    }

    // Search by category
    public static String searchCategoryDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book category to search : ");
        return scanner.nextLine();
    }
    public  static void searchCategoryshow(){
        String category = LibraryScreen.searchCategoryDisplay();
        Library.SearchByCategory(Boolean.FALSE,category);
    }

    // Search by code
    public static String searchCodeDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code to search : ");
        return scanner.nextLine();
    }
    public  static void searchCodeshow(){
        String code = LibraryScreen.searchCodeDisplay();
        Library.SearchByCode(Boolean.FALSE,code);
    }

    // Search display
    public static void searchShow() {
        System.out.println("==========================");
        System.out.println("Book Name   : " + service.getBookDetail().getBookName());
        System.out.println("Book Type   : " + service.getBookDetail().getBookCategory());
        System.out.println("Book Code   : " + service.getBookDetail().getBookCode());
        System.out.println("Book Status : " + service.getBookDetail().getBookStatus());
        service.setBookDetail(null);
    }
    // Sort menu
    public static int sortDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please use sorting function");
        System.out.println("1 - Sort by Name\n2 - Sort by Category\n3 - Sort by Serial\n4 - Sort by Status");
        return scanner.nextInt();
    }

    // Sort display
    public static void sortShow() {
        for (Book sort : service.getBooksService().getBooks()) {
            System.out.println(sort);                                                   // Display book after sorting //
        }
    }

    // Confirm menu
    public static String ConfirmView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your property");
        System.out.println("1 - Approve\t2 - Accept");
        return scanner.nextLine();
    }

    // Book Code Input
    public static String ChangeView() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code : ");
        return scanner.nextLine();
    }

    // Change date Input
    public static int ChangeDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your number to change return date : ");
        return scanner.nextInt();
    }

    // Borrow & Return Input
    public static String ConfirmInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code : ");
        return scanner.nextLine();
    }

    // Session Check
    public static void SessionCheck(Boolean Found) {
        if (Found != null) {
            if (!Found) {
                System.out.println("Your book it doesn't exist");
            }
        }
        if (service.getLibrarianDetail() == null) {
            inputParser.userLogin();
        } else {
            inputParser.adminLogin();
        }
    }

    public static void DayLateCheck() {
        int x = (int) DAYS.between(service.getHistoryDetail().getDayReturn(), LocalDate.now());
        if (x > 0) {
            System.out.println("" + service.getHistoryDetail().getCustomername() + ", You return book late " + x + " day(s)");
        }
    }


    // Generate Book Code
    public static String GenerateCode(String value) {
        String CategoryCode = BookCategory.valueOf(value).getCode();                    // Pull code (String) from category enum
        DecimalFormat decimalFormat = new DecimalFormat("0000");                // DecimalFormat change display value from 1 to 0001
//        Random random = new Random();
//        int NumberCode = random.nextInt(1000);                                    // Random number  0 - 1000
//        String code = CategoryCode + decimalFormat.format(NumberCode);            // Combine String

        Integer runningNo = null;
        if (service.getBooksService().getBooks().size() != 0) {
            for (Book b : service.getBooksService().getBooks()) {
                if (CategoryCode.equals(b.getBookCode().substring(0, 1))) {
                    if (runningNo == null || runningNo < Integer.parseInt(b.getBookCode().substring(1))) {
                        runningNo = Integer.parseInt(b.getBookCode().substring(1));
                    }
                } else {
                    if (runningNo == null) {
                        runningNo = 0;
                    }
                }
            }
        } else {
            runningNo = 0;
        }
        runningNo = runningNo + 1;
        String code = CategoryCode + decimalFormat.format(runningNo);
        return code;
    }

    // History Add
    public static void HistoryAdd(History historyForeach) {
        History history = new History();

        // Add data to history object
        history.setUuid(UUID.randomUUID());
        history.setBookname(service.getBookDetail().getBookName());
        history.setBookcode(service.getBookDetail().getBookCode());
        history.setBookcategory(service.getBookDetail().getBookCategory());
        history.setBookauthor(service.getBookDetail().getBookAuthor());

        // Add history data to history list
        if (historyForeach == null) {
            // Can use if (service.getBookDetail().getBookStatus().equals(BookStatus.Wait_Approve))
            history.setCustomername(service.getCustomerDetail().getFirstName());
            history.setBooksituation(BookSituation.Wait_Approve);
            service.getHistoriesService().getHistories().add(history);
        } else {
            // Can use if (service.getBookDetail().getBookStatus().equals(BookStatus.Wait_Accept))
            history.setCustomername(historyForeach.getCustomername());
            history.setDayBorrow(historyForeach.getDayBorrow());
            history.setDayReturn(historyForeach.getDayReturn());
            history.setBooksituation(BookSituation.Wait_Accept);
            service.getHistoriesService().getHistories().add(history);
//
        }
    }
}
