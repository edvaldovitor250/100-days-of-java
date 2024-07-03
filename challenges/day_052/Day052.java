import java.sql.*;
import java.util.Scanner;

public class Day052 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase"; 
    private static final String USER = "root"; 
    private static final String PASS = "password"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Conexão com o banco de dados estabelecida!");

            while (true) {
                System.out.print("Digite a consulta SQL (ou 'sair' para encerrar): ");
                String sql = scanner.nextLine();

                if (sql.equalsIgnoreCase("sair")) {
                    break;
                }

                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();

                    while (rs.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) System.out.print(",  ");
                            String columnValue = rs.getString(i);
                            System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                        }
                        System.out.println();
                    }
                } catch (SQLException e) {
                    System.out.println("Erro ao executar a consulta: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Aplicativo encerrado.");
    }
}
