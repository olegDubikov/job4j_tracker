package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO items(name, created) VALUES(?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            if (statement.executeUpdate() == 0) {
                throw new SQLException("item not found with id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM items")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(itemResult(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            statement.setString(1, key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(itemResult(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = itemResult(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item itemResult(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
        Item item = new Item();
        item.setName(name);
        item.setCreated(created);
        item.setId(resultSet.getInt("id"));
        return item;
    }
}