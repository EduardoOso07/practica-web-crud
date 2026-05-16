/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author eduos
 */
public class Contacto {
    
    private int id;
    private String nom;
    private String tel;
    private String dir;
    private String mail;
    
    public Contacto() {}
    
    public Contacto(String nom, String tel, String dir, String mail) {
        this.nom = nom;
        this.tel = tel;
        this.dir = dir;
        this.mail = mail;
    }
    /**
     * @return the nom
     */
    public int getId() {
        return id;
    }

    /**
     * @param nom the nom to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
    /*public Contacto addContacto(fname, lname){
        //Conexion de base de datos
        try
        {
          // create a mysql database connection
          String myDriver = "org.gjt.mm.mysql.Driver";
          String myUrl = "jdbc:mysql://localhost/test";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          Statement st = conn.createStatement();

          // note that i'm leaving "date_created" out of this insert statement
          st.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) "
              +"VALUES ('Fred', 'Flinstone', false, 10000)");

          conn.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
    }*/
    //todos los modelos que interactuan con la base de datos
    
}
