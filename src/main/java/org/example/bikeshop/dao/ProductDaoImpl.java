package org.example.bikeshop.dao;

import org.example.Bike;
import org.example.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final Connection connection;

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product product = createProduct(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = createProduct(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        return switch (type) {
            case "Bike" -> new Bike(
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getString("specifications"),
                    rs.getDouble("price"),
                    List.of(new Color(rs.getString("color_code"), rs.getString("image_url")))
            );
            case "Accessories" -> new Accessories(
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getString("specifications"),
                    rs.getDouble("price"),
                    List.of(new Color(rs.getString("color_code"), rs.getString("image_url")))
            );
            case "emtb" -> new Emtb(
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getString("specifications"),
                    rs.getDouble("price"),
                    List.of(new Color(rs.getString("color_code"), rs.getString("image_url")))
            );
            default -> throw new IllegalArgumentException("Unknown product type: " + type);
        };
    }
}
