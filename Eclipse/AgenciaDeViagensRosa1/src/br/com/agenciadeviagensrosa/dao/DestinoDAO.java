package br.com.agenciadeviagensrosa.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciadeviagensrosa.factory.ConnectionFactoryAgenciaDeViagensRosa;
import br.com.agenciadeviagensrosa.model.Destino;

public class DestinoDAO {
	
	public void save(Destino destino) {
		
		String sql = "INSERT INTO destinos(local,data,valor)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getLocal());
			pstm.setString(2, destino.getData());
			pstm.setDouble(3, destino.getValor());
			
			pstm.execute();
			
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			
			try {
				if(pstm !=null) {
					
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
					
				} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}


public void removeById(int id) {
	String sql = "DELETE FROM destinos WHERE ID = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		pstm.execute();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		try {
			if(pstm != null) {
				
				pstm.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}

public void update(Destino destino) {
	
	String sql = "UPDATE destinos SET local = ?, data = ?, valor= ?" + "WHERE id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, destino.getLocal());
		pstm.setString(2, destino.getData());
		pstm.setDouble(3, destino.getValor());
		
		pstm.execute();

	} catch (Exception e) {
		
		e.printStackTrace();
	}finally {
		
		try {
			if (pstm !=null) {
				
				pstm.close();
			}
			
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}

public List<Destino> getDestinos(){
	
	String sql = "SELECT * FROM destinos";
	
	List<Destino> destinos = new ArrayList<Destino>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while(rset.next()) {
			
			Destino destino = new Destino();
			
			destino.setId(rset.getInt("id"));
			
			destino.setLocal(rset.getString("local"));
			
			destino.setData(rset.getString("data"));
			
			destino.setValor(rset.getDouble("valor"));
			
			destinos.add(destino);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
		try {
			
			if(rset != null) {
				
				rset.close();
			}
			
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
	}
}

return destinos;
}
}