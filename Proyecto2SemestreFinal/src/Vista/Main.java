package Vista;


import Area.Menu1Area;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Menu1Area menu1 = new Menu1Area();
            menu1.menu1Area();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
