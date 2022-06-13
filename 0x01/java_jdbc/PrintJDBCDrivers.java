

import java.sql.*;
import java.sql.DriverAction;
import java.util.Enumeration;

public class PrintJDBCDrivers {

    public static void main(String[] args) {
        System.out.println("Listar Drivers");
        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();) {
            Driver driver = e.nextElement();
            print(driver);
        }
    }

    public static void print(Driver driver) {
        String className = driver.getClass().getName();
        int majorVersion = driver.getMajorVersion();
        int minorVersion = driver.getMinorVersion();
        System.out.println(className + " " + majorVersion);

    }
}
