package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Datos {
	
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "segurosgroup";
    
    public Datos() {
    	
    }
    
    public Connection obtenerConexion() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(host + dbName + "?useSSL=false&serverTimezone=UTC", user, pass);
    }
    
    public int ejecutarProcedimientoAlmacenado(String consulta, Object[] parametros) {
    	int filas = 0; 
    	try(Connection cn = obtenerConexion();
    		CallableStatement cs = cn.prepareCall(consulta);){
    		
    		for(int i = 0; i < parametros.length; i++) {
    			cs.setObject(i + 1, parametros[i]);
    		}
    		
    		filas = cs.executeUpdate(); 
    	}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return filas; 
    }
    
	public int EjecutarAccion(String consulta, Object[] parametros) {
		int filasafectadas = 0; 
		
		try(Connection connection = obtenerConexion(); 
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);){
			
			for(int i = 0; i < parametros.length; i ++) {
				preparedStatement.setObject(i + 1, parametros[i]);
			}
			
			filasafectadas = preparedStatement.executeUpdate(); 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasafectadas; 
	}

}
