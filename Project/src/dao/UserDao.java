package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

    /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, convartpassword(password));
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


    /**
     * 全てのユーザ情報を取得する
     * @return
     */
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user where login_id not in ('admin')";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
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
        return userList;
    }

    public List<User> findSearch(String loginId, String name, String birthDate1, String birthDate2 ) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user where login_id not in ('admin')";

            if(!loginId.equals("")) {
            		sql += " and login_id = '" + loginId + "'";
            }

            if(!name.equals("")) {
        		sql += " and name LIKE '%" + name + "%'";
            }

            if(!birthDate1.equals("")) {
        		sql += " and birth_date >= '" + birthDate1 + "'";
            }
            if(!birthDate2.equals("")) {
        		sql += " and birth_date <= '" + birthDate2 + "'";
            }



             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId1 = rs.getString("login_id");
                String name1 = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId1, name1, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
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
        return userList;
    }

    public void insertDate (String loginId, String password, String name, String birthDate) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            String insert = "INSERT INTO user(login_id,password,name,birth_date,create_date,update_date) VALUES(?,?,?,?,now(),now())";


            PreparedStatement pStmt = conn.prepareStatement(insert);
            pStmt.setString(1, loginId);
            pStmt.setString(2, convartpassword(password));
            pStmt.setString(3, name);
            pStmt.setString(4, birthDate);


            pStmt.executeUpdate();
            conn.close();



        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

        	 if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                 }
                 conn = null;
             }
         }
     }

    public User UserDate (String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            String Usersdata = "SELECT * FROM user WHERE id=?";


            PreparedStatement pStmt = conn.prepareStatement(Usersdata);
            pStmt.setString(1, id);


            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int iid = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User userdata = new User(iid, loginId, name, birthDate, password, createDate, updateDate);
                return userdata;


            }
            conn.close();



        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

        	 if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                 }
                 conn = null;
             }
         }
		return null;
     }


    public void updateDate (String password, String name, String birthDate, String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            String update = "UPDATE user SET password=?,name=?,birth_date=? WHERE id=?";



            PreparedStatement pStmt = conn.prepareStatement(update);
            pStmt.setString(1, convartpassword(password));
            pStmt.setString(2, name);
            pStmt.setString(3, birthDate);
            pStmt.setString(4, id);

            pStmt.executeUpdate();




            conn.close();



        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

        	 if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                 }
                 conn = null;
             }
         }
     }

    public void UserDelete (String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            String delete = "DELETE FROM user WHERE id=?";



            PreparedStatement pStmt = conn.prepareStatement(delete);

            pStmt.setString(1, id);

            pStmt.executeUpdate();




            conn.close();



        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

        	 if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                 }
                 conn = null;
             }
         }
     }
    public boolean UserNameDate(String loginId) {
    	Connection conn = null;
        try {
            conn = DBManager.getConnection();
            String namedata = "SELECT * FROM user WHERE login_Id = ?";
            PreparedStatement pStmt = conn.prepareStatement(namedata);

            pStmt.setString(1,loginId);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return false;
            }

            conn.close();




        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

        	 if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                 }
                 conn = null;
             }
         }
		return true;

    }

public void updateDateNoPass (String name, String birthDate, String id) {
    Connection conn = null;
    try {
        // データベースへ接続
        conn = DBManager.getConnection();
        String update = "UPDATE user SET name=?,birth_date=? WHERE id=?";



        PreparedStatement pStmt = conn.prepareStatement(update);

        pStmt.setString(1, name);
        pStmt.setString(2, birthDate);
        pStmt.setString(3, id);

        pStmt.executeUpdate();




        conn.close();



    } catch (SQLException e) {
        e.printStackTrace();

    } finally {

    	 if (conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
             }
             conn = null;
         }
     }
 }

	private String convartpassword(String password) {
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		return result;
	}


}



