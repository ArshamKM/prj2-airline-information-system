package datarecords;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import javax.sql.DataSource;

/**
 * Data carrier for CustomerData.
 * A record is not mutable. Getter methods (e.g. firstName(), not getFirstName()), 
 * hashCode(), equals() end toString available for free.
 * 
 * @author Informatics Fontys Venlo
 */

    

    
public record CustomerData (int id, String firstName, String lastName, LocalDate dob) {

    static Map<String, DataSource> cache = new HashMap<>(); 

    static DataSource getDataSource(final String sourceName) {

        return cache.get(sourceName);
    }

    static CustomerData getCustomerDataFromDatabase(int customerId, String sourceName) { 
        String query = "SELECT id, first_name, last_name, dob FROM customers WHERE id = ?";

try ( 
    Connection con = datasource.getConnection(); 
    PreparedStatement stmt = con.PreparedStatement(query); ) { 
        int count = 0; 
        for (Object param : customerData) { 
            stmt.setObject(++count, param); 

        }
        return stmt.executeUpdate(); 
    }







}
}