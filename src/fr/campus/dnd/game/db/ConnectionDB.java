package fr.campus.dnd.game.db;

import java.sql.*;
import fr.campus.dnd.game.characters.Character;

public class ConnectionDB {
    String url = "jdbc:mysql://localhost:3306/DungeonNDragons";
    String user = "claire_dgr";
    String password = "0*Butterfly*0";


    public void saveData( Character hero){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "insert into Hero (type, name, life_points, strength_points, offensive_weapon, defensive_weapon) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hero.getJob());
            preparedStatement.setString(2, hero.getName());
            preparedStatement.setInt(3, hero.getLifePoints());
            preparedStatement.setInt(4, hero.getStrength());
            preparedStatement.setString(5, hero.getOffensiveWeapon());
            preparedStatement.setString(6, hero.getDefensiveWeapon());

            preparedStatement.executeUpdate();
            connection.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void loadData(Character hero){

    }
    public void checkSavedData(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Hero");
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("name")+ "\n"+
                        resultSet.getString("type")+ "\n"+
                        resultSet.getString("life_points")+ "\n"+
                        resultSet.getString("strength_points")+ "\n"+
                        resultSet.getString("offensive_weapon")+"\n"+
                        resultSet.getString("defensive_weapon")
                );
            }
            connection.close();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
