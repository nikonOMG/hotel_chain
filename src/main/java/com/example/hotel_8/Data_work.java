package com.example.hotel_8;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.sql.*;
import java.sql.Date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Data_work extends SQLException {
    private static String myDriver;
    public static Connection conn;
    public static String login;
    public static String password;
    public static String name;
    public static int id;
    public static int hotelID;
    public static int finances;
    public static int workers_count;
    public static String post;
    public static int salary;
    public static String email;
    public static String email_pas;
    public static String host = "imap.gmail.com";


    static {
        try {
            myDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(myDriver);
            conn = DriverManager.getConnection("jdbc:mysql://bcalydbu3z2fxht2xnnd-mysql.services.clever-cloud.com:3306/bcalydbu3z2fxht2xnnd", "uy0pllhi16asmquc", "N2BCPexKg09xUxUEjP4f");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String
    removeFirstandLast(String str)
    {

        // Creating a StringBuilder object
        StringBuilder sb = new StringBuilder(str);

        // Removing the last character
        // of a string
        sb.deleteCharAt(str.length() - 1);

        // Removing the first character
        // of a string
        sb.deleteCharAt(0);

        // Converting StringBuilder into a string
        // and return the modified string
        return sb.toString();
    }





    public static ArrayList<String> get_hotels() {
        ArrayList<String> name_hotels = new ArrayList<>();
        try
        {
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Name FROM Hotels";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String Name = rs.getString("Name");
                name_hotels.add(Name);

            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return name_hotels;
    }

    public static ArrayList<String> get_rooms(boolean EXB, boolean CHD) {
        ArrayList<String> name_hotels = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            if(EXB && CHD) {
                query = "SELECT Name, Size, Type, View FROM Rooms WHERE Rooms.Extra_bed = 1 and Rooms.Child = 1 and Rooms.isAvailable = 1" ;
            } else if(EXB){
                query = "SELECT Name, Size, Type, View FROM Rooms WHERE Rooms.Extra_bed = 1 and Rooms.isAvailable = 1";
            } else if(CHD){
                query = "SELECT Name, Size, Type, View FROM Rooms WHERE Rooms.Child = 1 and Rooms.isAvailable = 1";
            } else{
                query = "SELECT Name, Size, Type, View FROM Rooms Where Rooms.isAvailable = 1";
            }
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String Name = rs.getString("Name");
                String View = rs.getString("View");
                String Size = rs.getString("Size");
                String Type = rs.getString("Type");
                name_hotels.add(Name + " " + Size + " " + View + " " + Type);

            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return name_hotels;
    }

    public static ArrayList<String> getWorkers() {
        ArrayList<String> name_hotels = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "SELECT WorkerID, Fullname, Post FROM Workers Where Workers.HotelID = " + hotelID;

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String idd = rs.getString("WorkerID");
                String Name = rs.getString("Fullname");
                String POST = rs.getString("Post");
                name_hotels.add(idd + " " +  Name + " " + POST);

            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return name_hotels;
    }

    public static ArrayList<String> getWorkerswithoutDirector() {
        ArrayList<String> name_hotels = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "SELECT WorkerID, Fullname, Post FROM Workers Where Workers.HotelID = " + hotelID + " and Post != \"Director\" and Post != \"Admin\"";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String idd = rs.getString("WorkerID");
                String Name = rs.getString("Fullname");
                String POST = rs.getString("Post");
                name_hotels.add(idd + " " +  Name + " " + POST);

            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return name_hotels;
    }

    public static ArrayList<String> getView() {
        ArrayList<String> view = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "select Name from Сlassification_of_rooms Where Type = 'View'";
            System.out.println(query);

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String idd = rs.getString("Name");
                view.add(idd);

            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return view;
    }

    public static ArrayList<String> getSize() {
        ArrayList<String> view = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "select Name from Сlassification_of_rooms Where Type = 'Basic'";
            System.out.println(query);

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String idd = rs.getString("Name");
                view.add(idd);

            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return view;
    }

    public static ArrayList<String> getType() {
        ArrayList<String> view = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "select Name from Сlassification_of_rooms Where Type = 'Comfort'";
            System.out.println(query);

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                String idd = rs.getString("Name");
                view.add(idd);

            }
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return view;
    }





    public static ResultSet getWorkerInfo(String iddd) {
        ArrayList<String> name_hotels = new ArrayList<>();
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "SELECT Fullname, Passport, Salary, Login, Email, Password FROM Workers Where Workers.HotelID = " + hotelID + " and Workers.WorkerID = " + iddd;

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
//            while (rs.next())
//            {
////                String Name = rs.getString("Fullname");
////                String Passport = rs.getString("Passport");
////                String Salary = rs.getString("Salary");
////                String Login = rs.getString("Login");
////                String Email = rs.getString("Email");
////                String Password = rs.getString("Password");
////                name_hotels.addAll(Name, Passport, Salary, Login, Email, Password);
//
//            }
            return rs;

        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static ResultSet getWorkerSalary(String iddd) {
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "SELECT Salary FROM Workers Where Workers.HotelID = " + hotelID + " and Workers.WorkerID = " + iddd;

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
//            while (rs.next())
//            {
////                String Name = rs.getString("Fullname");
////                String Passport = rs.getString("Passport");
////                String Salary = rs.getString("Salary");
////                String Login = rs.getString("Login");
////                String Email = rs.getString("Email");
////                String Password = rs.getString("Password");
////                name_hotels.addAll(Name, Passport, Salary, Login, Email, Password);
//
//            }
            return rs;

        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static ResultSet getHotelinfo() {
        try
        {
            String query;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"

            query = "SELECT * FROM Hotels Where HotelID = " + hotelID;

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
//            while (rs.next())
//            {
////                String Name = rs.getString("Fullname");
////                String Passport = rs.getString("Passport");
////                String Salary = rs.getString("Salary");
////                String Login = rs.getString("Login");
////                String Email = rs.getString("Email");
////                String Password = rs.getString("Password");
////                name_hotels.addAll(Name, Passport, Salary, Login, Email, Password);
//
//            }
            return rs;

        }
        catch (Exception e)
        {
            System.err.println("Got an exception!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }



    public static boolean sign_in(String log, String pass, String hotel){
        try
        {
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Workers WHERE Workers.HotelID = \"";

            int idHotel = getIdHotel(hotel);
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query + idHotel + "\"");

            // iterate through the java resultset
            while (rs.next())
            {
                login = rs.getString("Login");
                password = rs.getString("Password");
                id = rs.getInt("WorkerID");
                hotelID = rs.getInt("HotelID");
                post = rs.getString("Post");
                salary = rs.getInt("Salary");
                email = rs.getString("Email");
                name = rs.getString("Fullname");
                email_pas = rs.getString("Email_password");
                finances = getFinances();
                workers_count = getWorkers_count();


                if(login.equals(log) & password.equals(pass)){
                    hotelID = idHotel;
                    return true;
                }

            }
            st.close();
        }
        catch (Exception e) {
            System.err.println("Got an exception!!! ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static int getCost(String room){
        try
        {
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();
            List<String> list = new ArrayList<String>(Arrays.asList(room.split(" ")));
            System.out.println(list);
            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Price FROM Rooms WHERE Rooms.Name = \"";

            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query + list.get(0) + "Rooms.Size = " + list.get(1) + "\"");

            // iterate through the java resultset
            while (rs.next())
            {
                int price = rs.getInt("Price");
                return price;
                }


        }
        catch (Exception e) {
            System.err.println("Got an exception!!! ");
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static String getJob(String login, String hotel){
        try
        {
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Post FROM Workers WHERE Workers.HotelID = \"" ;
            int idHotel = getIdHotel(hotel);
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            System.out.println(login);
            ResultSet rs = st.executeQuery(query + idHotel +"and Workers.Login = " + login + "\"");

            // iterate through the java resultset

            while(rs.next()){
                String post = rs.getString("Post");
                System.out.println(post);}
            return post;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static int getFinances(){
        try
        {

            String query = "SELECT Finances FROM Hotels WHERE Hotels.HotelID = " + hotelID;
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                System.out.println("profit " + getProfit(String.valueOf(LocalDate.now().getMonth())));
                finances = rs.getInt("Finances") - getLoss(String.valueOf(LocalDate.now().getMonth())) + getProfit(String.valueOf(LocalDate.now().getMonth()));
                System.out.println(finances);
            }
            return finances;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return finances;
    }

    public static int getWorkers_count(){
        int count = 0;
        try
        {
            String query = "SELECT * FROM Workers WHERE Workers.HotelID = " + hotelID;
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                count++;
            }
            return count;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return count;
    }

    public static int getCountRooms(){
        int count = 0;
        try
        {
            String query = "SELECT * FROM Rooms WHERE Rooms.HotelID = " + hotelID;
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                count++;
            }
            return count;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return count;
    }

    public static int getCountClients(){
        int count = 0;
        try
        {
            Date date = Date.valueOf(LocalDate.now());
            System.out.println(date);

            String query = "SELECT * FROM Clients WHERE Clients.HotelID = " + hotelID + " and '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime";
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                count++;
            }
            return count;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return count;
    }

    public static int getLoss(String month){
        try
        {

            String query = "SELECT " + month +" FROM Loss WHERE Loss.HotelID = " + hotelID;
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                return rs.getInt(month);
            }


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static void setLoss(String month){
        try {
            Statement st = conn.createStatement();
            String query = "UPDATE Loss Set "+ month +" = '" + getLossNow() + "' WHERE Loss.HotelID = " + hotelID;
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int getLossNow(){
        int loss = 0;
        try
        {
            String query = "SELECT Salary FROM Workers WHERE Workers.HotelID = " + hotelID;
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                loss += rs.getInt("Salary");
            }

            query = "Select Loss from Workers where HotelID = " + hotelID + " or HotelID = 0";

            rs = st.executeQuery(query);

            System.out.println(query);
            while(rs.next()) {
                loss += rs.getInt("Loss");
            }


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return loss;
    }


    public static int getProfit(String month){
        try
        {

            String query = "SELECT " + month +" FROM Profit WHERE Profit.HotelID = " + hotelID;
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                return rs.getInt(month);
            }


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static void setProfit(String month){
        try {
            Statement st = conn.createStatement();
            String query = "UPDATE Profit Set "+ month +" = '" + getProfitNow() + "' WHERE Profit.HotelID = " + hotelID;
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int getProfitNow(){
        int profit = 0;
        try
        {
            String query = "select Amount from Clients where CheckInTime between '" + LocalDate.now().withDayOfMonth(1) + "' and '" + LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()) + "'";
            // create the java statement
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            System.out.println(query);
            while(rs.next()) {
                profit += rs.getInt("Amount");
                System.out.println("cc " + profit);
            }

            query = "Select Price from monetary_fine where HotelID = " + hotelID + " and monetary_fine.Date between '" + LocalDate.now().withDayOfMonth(1) + "' and '" + LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()) + "'";

            rs = st.executeQuery(query);

            System.out.println(query);
            while(rs.next()) {
                profit += rs.getInt("Price");
                System.out.println("cc " + profit);

            }


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return profit;
    }


    public static String getDescriptionS(String room){
        try
        {
            List<String> list = new ArrayList<String>(Arrays.asList(room.split(" ")));
            System.out.println(list);
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Description FROM Сlassification_of_rooms WHERE Сlassification_of_rooms.Name = \"";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query + list.get(1) + "\"");

            // iterate through the java resultset
            rs.next();
            String post = rs.getString("Description");
            return post;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static String getDescriptionT(String room){
        try
        {
            List<String> list = new ArrayList<String>(Arrays.asList(room.split(" ")));
            System.out.println(list);
            String n;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            if(list.size() == 7){
                n = list.get(5) + " " + list.get(6);

            }else if(list.size() == 6){
                n = list.get(5);
            } else{
                n = list.get(4);
            }
            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT Description FROM Сlassification_of_rooms WHERE Сlassification_of_rooms.Name = \"";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query + n + "\"");

            // iterate through the java resultset
            rs.next();
            String post = rs.getString("Description");
            return post;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }


//    public static Connection getConnection() throws SQLException {
////        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://bcalydbu3z2fxht2xnnd-mysql.services.clever-cloud.com:3306/bcalydbu3z2fxht2xnnd", "uy0pllhi16asmquc", "N2BCPexKg09xUxUEjP4f");
//
//        return connection;
//    }

//    public static boolean addHotel() throws SQLException, ClassNotFoundException {
//        String myDriver = "com.mysql.cj.jdbc.Driver";
//        Class.forName(myDriver);
//        Connection conn = getConnection();
//
//        // our SQL SELECT query.
//        // if you only need a few columns, specify them by name instead of using "*"
//        Statement st = conn.createStatement();
//
//        String name = AdminAddHotelController.getHotelName();
//        String address = AdminAddHotelController.getHotelAddress();
//        String stars = AdminAddHotelController.getHotelStars();
//        int workers = AdminAddHotelController.getHotelWorkers();
//        int rooms = AdminAddHotelController.getHotelRooms();
//        int clients = AdminAddHotelController.getHotelClients();
//        int finances = AdminAddHotelController.getHotelFinances();
//        System.out.println(name);
//        System.out.println(address);
//        System.out.println(stars);
//        System.out.println(workers);
//        System.out.println(rooms);
//        System.out.println(clients);
//        System.out.println(finances);
//        // the mysql insert statement
//        try {
//            String query = " insert into Hotels (Name, Address, Stars, Workers, Clients, Finances, Rooms)"
//                    + " values (?, ?, ?, ?, ?, ?, ?)";
//
//            // create the mysql insert preparedstatement
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString(1, name);
//            preparedStmt.setString(2, address);
//            preparedStmt.setInt(3, Integer.parseInt(stars));
//            preparedStmt.setInt(4, workers);
//            preparedStmt.setInt(5, clients);
//            preparedStmt.setInt(6, finances);
//            preparedStmt.setInt(7, rooms);
//
//            // execute the preparedstatement
//            preparedStmt.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
////        fixID(conn, "Hotels");
//        // our SQL SELECT query.
//        // if you only need a few columns, specify them by name instead of using "*"
//        return false;
//    }


    public static void changeEmail(String newEmail) throws SQLException, ClassNotFoundException{
        try{
            Statement st = conn.createStatement();
            String query = "UPDATE Workers Set Email = '" +newEmail + "' WHERE Workers.Login = '" + login + "' and Workers.Password = '" + password + "'";
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();
            email = newEmail;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update_rooms() throws SQLException, ClassNotFoundException{
        try{
            Statement st = conn.createStatement();
            Date date = Date.valueOf(LocalDate.now());
//            String query = "UPDATE Rooms Set isAvailable = 1 WHERE '" + date + "' not between Clients.CheckInTime and Clients.CheckOutTime";

            String query2 = "select Name from Clients where '" + date + "' > Clients.CheckOutTime";

            ResultSet rs2 = st.executeQuery(query2);

            while (rs2.next()){
                String query3 = "update Rooms set isAvailable = 1 where Name = " + rs2.getInt("Name");
                PreparedStatement preparedStmt = conn.prepareStatement(query3);
                preparedStmt.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean changeEmailHR(String emailtest, String pass) throws SQLException, ClassNotFoundException{

        try{
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, emailtest, pass);


            email = emailtest;
            email_pas = pass;
            return true;

        } catch (NoSuchProviderException e) {
            return false;
        } catch (MessagingException e) {
            return false;
        }

    }

    public static boolean addNewWorker(String name, String newPassport, String newEmail, String newLogin, String newPassword, String newPost, int newSalary) throws SQLException, ClassNotFoundException{

        try {



            String query = " insert into Workers (HotelID, Fullname, Passport, Salary, Post, Login, Password, Email)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, hotelID);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, newPassport);
            preparedStmt.setInt(4, newSalary);
            preparedStmt.setString(5, newPost);
            preparedStmt.setString(6, newLogin);
            preparedStmt.setString(7, newPassword);
            preparedStmt.setString(8, newEmail);

            // execute the preparedstatement
            preparedStmt.execute();

            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            int iddd = getWorkerId(newPassport);
            for(int i = 0; i<12; i++){
                query = "insert into " + months[i] + " (WorkerID) values (?)";
                System.out.println(query);
                preparedStmt = conn.prepareStatement(query);

                preparedStmt.setInt(1, iddd);

                preparedStmt.execute();
            }
//            query = "insert into " + months[LocalDate.now().getMonthValue() - 1] + " (WorkerID) values (?)";
//            System.out.println(query);
//            preparedStmt = conn.prepareStatement(query);
//
//            preparedStmt.setInt(1, getWorkerId(newPassport));
//
//            preparedStmt.execute();


            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//        fixID(conn, "Hotels");
        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        return false;

    }

    public static boolean addNewRoom(int number, int price ,String size, String view, String type, boolean extrabed, boolean child){

        try {



            String query = " insert into Rooms (HotelID, Price, Size, Extra_bed, Child, Type, View, Name)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, hotelID);
            preparedStmt.setInt(2, price);
            preparedStmt.setString(3, size);
            if(extrabed)
                preparedStmt.setInt(4, 1);
            else
                preparedStmt.setInt(4, 0);
            if(child)
                preparedStmt.setInt(5, 1);
            else
                preparedStmt.setInt(5, 0);
            preparedStmt.setString(6, type);
            preparedStmt.setString(7, view);
            preparedStmt.setInt(8, number);

            // execute the preparedstatement
            preparedStmt.execute();


            return true;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//        fixID(conn, "Hotels");
        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        return false;

    }


    public static int getWorkerId(String passport){
        try
        {

            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT WorkerID FROM Workers WHERE Passport = \'" + passport + "\'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            rs.next();
            int post = rs.getInt("WorkerID");
            return post;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public static void update_finances(){
            try {
                Statement st = conn.createStatement();
                String query = "UPDATE Hotels Set Finances = '" + getFinances() + "' WHERE HotelID = " + hotelID;
                System.out.println(query);
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();

                query = "update Workers Set Loss = 0 where HotelID = " + hotelID;
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static boolean changePassword(String oldPas, String newPas, String conNewPas) throws SQLException, ClassNotFoundException{
        if(oldPas.equals(password) && newPas.equals(conNewPas) && !newPas.equals(oldPas)) {
            try {
                Statement st = conn.createStatement();
                String query = "UPDATE Workers Set Password = '" + newPas + "' WHERE Workers.Login = '" + login + "' and Workers.Password = '" + password + "'";
                System.out.println(query);
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();
                password = newPas;
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static void changeWorker(int idd, String name, String passport, String email, String login, String password, int salary) throws SQLException, ClassNotFoundException{
        try {
            Statement st = conn.createStatement();
            String query = "UPDATE Workers Set Fullname = ?, Passport = ?, Salary = ?, Login = ?, Password = ?, Email = ? where WorkerID = ?";
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,name);
            preparedStmt.setString(2, passport);
            preparedStmt.setInt(3, salary);
            preparedStmt.setString(4, login);
            preparedStmt.setString(5, password);
            preparedStmt.setString(6, email);
            preparedStmt.setInt(7, idd);

            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void changeHotel(String name, String address, int stars, int finances) throws SQLException, ClassNotFoundException{
        try {
            Statement st = conn.createStatement();
            String query = "UPDATE Hotels Set Name = ?, Address = ?, Stars = ?, Finances = ? where HotelID = ?";
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,name);
            preparedStmt.setString(2, address);
            preparedStmt.setInt(3, stars);
            preparedStmt.setInt(4, finances);
            preparedStmt.setInt(5, hotelID);


            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static void changeWorkerSalary(int idd, int salary) throws SQLException, ClassNotFoundException{
        try {
            Statement st = conn.createStatement();
            String query = "UPDATE Workers Set Salary = ? where WorkerID = ?";
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1,salary);
            preparedStmt.setInt(2, idd);

            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void update_attendance(int idd, Date date, String radio) throws SQLException, ClassNotFoundException{
        try {
            String[] months = {"January", "February", "March", "April", "May", "June", "Juli", "August", "September", "October", "November", "December"};


            Statement st = conn.createStatement();
//            String query = "update " + months[date.getMonth()] + " set  " + date.getDate() + " = ' + radio + " where WorkerID = " + idd;
            String query = "update "+ months[date.getMonth()]+" set `"+ date.getDate() +"` = ? where WorkerID = ?";
            System.out.println(query);
            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString(1, months[date.getMonth()]);
//            preparedStmt.setInt(1, date.getDate());
            preparedStmt.setString(1, radio);
            preparedStmt.setInt(2, idd);


            preparedStmt.executeUpdate();
            System.out.println("okkkkkkkkkkk");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static boolean addClient(String name, String passport, LocalDate dob, LocalDate intime, LocalDate outtime, String room) throws SQLException, ClassNotFoundException {


        try {

            List<String> list = new ArrayList<String>(Arrays.asList(room.split(" ")));
            System.out.println(list);

            String query = " insert into Clients (HotelID, Name, Fullname, Passport, DateOfBirth, CheckInTime, CheckOutTime, Amount)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, hotelID);
            preparedStmt.setInt(2, Integer.parseInt(list.get(0)));
            preparedStmt.setString(3, name);
            preparedStmt.setString(4, passport);
            preparedStmt.setDate(5, Date.valueOf(dob));
            preparedStmt.setDate(6, Date.valueOf(intime));
            preparedStmt.setDate(7, Date.valueOf(outtime));
            System.out.println("cost " + list.get(0));
            preparedStmt.setInt(8, ((int) ChronoUnit.DAYS.between(intime, outtime) )* Data_work.getCost(room));

            // execute the preparedstatement
            preparedStmt.execute();

            Statement st = conn.createStatement();
            query = "UPDATE Rooms Set isAvailable = 0 WHERE Rooms.HotelID = " + hotelID + " and Rooms.Name = " + list.get(0);
            System.out.println(query);
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//        fixID(conn, "Hotels");
        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        return false;
    }




    public static int getId() throws ClassNotFoundException, SQLException {
//        String myDriver = "com.mysql.cj.jdbc.Driver";
//        Class.forName(myDriver);
//        Connection conn = getConnection();

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(idHotels) AS id FROM Hotels");
        rs.next();
        int lastid = rs.getInt("id");
        return lastid;
    }
    public static int getIdHotel(String hotel) throws ClassNotFoundException, SQLException {
//        String myDriver = "com.mysql.cj.jdbc.Driver";
//        Class.forName(myDriver);
//        Connection conn = getConnection();

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        Statement st = conn.createStatement();
        String query = "SELECT HotelID AS id FROM Hotels WHERE Hotels.Name = \"";
        ResultSet rs = st.executeQuery(query + hotel + "\"");
        rs.next();
        int lastid = rs.getInt("id");
        return lastid;
    }

    public static Map<String, String> getMonths(String month){
        try
        {
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String dmonth = "$." + month.toLowerCase().substring(0, 1).toUpperCase() + month.toLowerCase().substring(1);
            String query = "SELECT JSON_EXTRACT(Month, \"" + dmonth + "\" ) AS Months FROM Workers WHERE Workers.Login = \"";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query + login +"\" and Workers.Password = \"" + password + "\"");
            //Creating a JSONObject object
            // iterate through the java resultset
            rs.next();

            String post = removeFirstandLast(rs.getString("Months"));
            System.out.println(post);

            // New HashMap obj
            Map<String, String> hashMap
                    = new HashMap<String, String>();

            // split the String by a comma
            String parts[] = post.split(",");

            // iterate the parts and add them to a HashMap
            for (String part : parts) {

                // split the student data by colon to get the
                // name and roll number
                String stuData[] = part.split(":");

                String stuRollNo = stuData[0].trim();
                String stuName = stuData[1].trim();

                // Add to map
                hashMap.put(stuRollNo, stuName);
            }

            // Print hashMap

            return hashMap;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static Map<String, String> getMonth(String month){
        try
        {
            String[] m31 = {"January", "March", "May", "Juli", "August", "October", "December"};
            String[] m30 = {"April", "June", "September", "November"};
            String query;
            int d;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String dmonth = month.toLowerCase().substring(0, 1).toUpperCase() + month.toLowerCase().substring(1);
            if(Arrays.stream(m31).anyMatch(dmonth::equals)) {
                query = "SELECT `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31` from " + dmonth + " WHERE " + dmonth + ".WorkerID = " + id;
                d = 31;
            }
            else if(Arrays.stream(m30).anyMatch(dmonth::equals)){
                query = "SELECT `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30` from " + dmonth + " WHERE " + dmonth + ".WorkerID = " + id;
                d = 30;
            }
            else{
                query = "SELECT `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29` from " + dmonth + " WHERE " + dmonth + ".WorkerID = " + id;
                d = 29;
            }

            // create the java statement
            System.out.println(query);
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            //Creating a JSONObject object
            // iterate through the java resultset
            Map<String, String> hashMap
                    = new HashMap<String, String>();
            rs.next();
            for (int i = 1; i <= d; i++) {
                hashMap.put(String.valueOf(i), rs.getString(String.valueOf(i)));
            }


            System.out.println(hashMap);





            return hashMap;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static Map<String, String> getMonth(String month, int id){
        try
        {
            String[] m31 = {"January", "March", "May", "Juli", "August", "October", "December"};
            String[] m30 = {"April", "June", "September", "November"};
            String query;
            int d;
            // create our mysql database connection
//            String myDriver = "com.mysql.cj.jdbc.Driver";
//            Class.forName(myDriver);
//            Connection conn = getConnection();

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String dmonth = month.toLowerCase().substring(0, 1).toUpperCase() + month.toLowerCase().substring(1);
            if(Arrays.stream(m31).anyMatch(dmonth::equals)) {
                query = "SELECT `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31` from " + dmonth + " WHERE " + dmonth + ".WorkerID = " + id;
                d = 31;
            }
            else if(Arrays.stream(m30).anyMatch(dmonth::equals)){
                query = "SELECT `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30` from " + dmonth + " WHERE " + dmonth + ".WorkerID = " + id;
                d = 30;
            }
            else{
                query = "SELECT `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29` from " + dmonth + " WHERE " + dmonth + ".WorkerID = " + id;
                d = 29;
            }

            // create the java statement
            System.out.println(query);
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            //Creating a JSONObject object
            // iterate through the java resultset
            Map<String, String> hashMap
                    = new HashMap<String, String>();
            rs.next();
            for (int i = 1; i <= d; i++) {
                hashMap.put(String.valueOf(i), rs.getString(String.valueOf(i)));
            }


            System.out.println(hashMap);





            return hashMap;


        }
        catch (Exception e) {
            System.err.println("Got an exception!!!! ");
            System.err.println(e.getMessage());
        }
        return null;
    }



//    public static void delete_hotel(String id){
//        System.out.println(id);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = getConnection();
//            PreparedStatement st = connection.prepareStatement("DELETE FROM Hotels WHERE HotelID = ?");
//            st.setInt(1, Integer.parseInt(id));
//            st.executeUpdate();
//            Statement s = connection.createStatement();
//            s.execute("ALTER TABLE Hotels AUTO_INCREMENT=1;");
//
//        } catch(Exception e) {
//            System.out.println(e);
//        }
//    }

        public static void deleteWorker(String id) {
            System.out.println(id);
            try {

//                Statement stmt = conn.createStatement();
//                stmt.execute("SET FOREIGN_KEY_CHECKS=0");
//                stmt.close();

                PreparedStatement st = conn.prepareStatement("DELETE FROM Workers WHERE WorkerID = ?");
//                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, Integer.parseInt(id));
                st.executeUpdate();

//                stmt = conn.createStatement();
//                stmt.execute("SET FOREIGN_KEY_CHECKS=1");
//                stmt.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }




}


