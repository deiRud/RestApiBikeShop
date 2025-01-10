package org.example.bikeshop.dao;

import org.example.Color;
import org.example.Product;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final DataSource dataSource;

    private static final String PRODUCT_ID = "product_id";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String SPECIFICATIONS = "specifications";
    private static final String PRICE = "price";
    private static final String COLOR = "color";
    private static final String IMAGE_URL = "imageurl";

    public ProductDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, category);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Product product = createProduct(rs);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt(PRODUCT_ID),
                rs.getString(BRAND),
                rs.getString(MODEL),
                rs.getString(SPECIFICATIONS),
                rs.getString(PRICE),
                new Color[]{
                        new Color(rs.getString(COLOR), rs.getString(IMAGE_URL))
                }
        );
    }
}
