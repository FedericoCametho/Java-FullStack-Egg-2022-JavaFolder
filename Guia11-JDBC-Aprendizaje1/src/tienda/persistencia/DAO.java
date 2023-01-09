
package tienda.persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarDB() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(DRIVER);
            String urlDB = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlDB, USER, PASSWORD);           
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    }
    
    protected void desconectarDB() throws Exception{
        try{
            if (resultado != null){
                resultado.close();
            }
            if (sentencia != null){
                sentencia.close();
            }
            if (conexion != null){
                conexion.close();
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws SQLException, ClassNotFoundException, Exception{
        try {
            this.conectarDB();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch(SQLException | ClassNotFoundException ex){
            // connecxion.rollBack();    para que si falla una insercion de muchas que se estan realilzando, se pueda volver atras y no se inserte nada
            /* para eso es necesario tambien correr el script siguiente en workbench
                
            SET autocommit=1;
            COMMIT;
            
            */
            throw ex;
        } finally {
            this.desconectarDB();
        }
    }
    
    protected void consultarDB(String sql) throws Exception{
        try {
            this.conectarDB();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            
        } catch(Exception ex){
            throw ex;
        }
    }
    
}
