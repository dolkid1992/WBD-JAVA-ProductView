package services;

import models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost:3306/AwesomeBusiness";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "12345678";

    public ProductServiceImpl() {
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        Connection conn = null;
        Statement stmt = null;

        log("Dang ket noi toi co so du lieu .... ");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        log("Tao lenh truy van SQL ...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, code, name FROM Product";

        log("Dang thuc hien truy van");
        ResultSet rs = stmt.executeQuery(sql);

        List<Product> products = new ArrayList<>();
        log("Dang thu thap ket qua");
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setCode(rs.getString("code"));
            product.setName(rs.getString("name"));

            products.add(product);
        }

        log("Hoan thanh thu thaap ket qua. Dang dong ket noi....");
        rs.close();
        stmt.close();
        conn.close();

        log("Thanh cong");
        return products;
    }

    private void log(String message) {
        System.out.println("ProductServiceImpl: " + message);
    }
}
