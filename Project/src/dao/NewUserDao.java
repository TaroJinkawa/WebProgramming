package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class NewUserDao {
    public User findByLoginInfo(String loginId, String password, String name, java.sql.Date birth_date) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            String insql = "INSERT INTO use(login_id,name,birthdate,password) VALUES()";
            
            

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ? and name = ? birth_date = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            pStmt.setString(3, name);
            pStmt.setDate(4, birth_date);
            
            
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

}