/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DB.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {
    
    private DbConnection dbConn;
    
    public ContactoDAO() {
        dbConn = new DbConnection();
    }
    
    // Insertar
    public boolean insertar(Contacto c) {
        String sql = "INSERT INTO contactos (nom, tel, dir, mail) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getNom());
            pstmt.setString(2, c.getTel());
            pstmt.setString(3, c.getDir());
            pstmt.setString(4, c.getMail());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Listar todos
    public List<Contacto> listar() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try (Connection conn = dbConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setTel(rs.getString("tel"));
                c.setDir(rs.getString("dir"));
                c.setMail(rs.getString("mail"));
                lista.add(c);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    // Obtener por ID
    public Contacto obtenerPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        try (Connection conn = dbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setTel(rs.getString("tel"));
                c.setDir(rs.getString("dir"));
                c.setMail(rs.getString("mail"));
                return c;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Actualizar
    public boolean actualizar(Contacto c) {
        String sql = "UPDATE contactos SET nom = ?, tel = ?, dir = ?, mail = ? WHERE id = ?";
        try (Connection conn = dbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getNom());
            pstmt.setString(2, c.getTel());
            pstmt.setString(3, c.getDir());
            pstmt.setString(4, c.getMail());
            pstmt.setInt(5, c.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Eliminar
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        try (Connection conn = dbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}