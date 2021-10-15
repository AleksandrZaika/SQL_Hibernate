import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "1234567890";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT course_name, " +
                            "COUNT(subscription_date) / (MAX(MONTH(subscription_date)) " +
                            "- MIN(MONTH(subscription_date)) + 1) AS average_amount " +
                            "FROM PurchaseList " +
                            "WHERE year(subscription_date) = 2018 " +
                            "GROUP BY course_name;");
            while (resultSet.next()) {
                //String courseName = resultSet.getString("course_name");
                System.out.println(resultSet.getString("course_name") + " " +
                        resultSet.getString("average_amount"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
