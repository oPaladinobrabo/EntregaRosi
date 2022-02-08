package br.com.agenciadeviagensrosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciadeviagensrosa.factory.ConnectionFactoryAgenciaDeViagensRosa;

import br.com.agenciadeviagensrosa.model.Promocoes;


public class PromocoesDAO {
	public void save(Promocoes promocoes) {
		
		String sql = "INSERT INTO promocoes(destino,data,valor)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, promocoes.getFk_destino());
			pstm.setString(2, promocoes.getData());
			pstm.setDouble(3, promocoes.getValor());
			
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
		String sql = "DELETE FROM promocoes WHERE ID = ?";
		
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

public void update(Promocoes promocoes) {
	
	String sql = "UPDATE promocoes SET destino = ?, data = ?, valor= ?" + "WHERE id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, promocoes.getFk_destino());
		pstm.setString(2, promocoes.getData());
		pstm.setDouble(3, promocoes.getValor());
		
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

public List<Promocoes> getPromocoes(){
	
	String sql = "SELECT * FROM promocoes";
	
	List<Promocoes> promocoess = new ArrayList<Promocoes>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while(rset.next()) {
			
			Promocoes promocoes = new Promocoes();
			
			promocoes.setId(rset.getInt("id"));
			
			promocoes.setFk_destino(rset.getInt("destino"));
			
			promocoes.setData(rset.getString("data"));
			
			promocoes.setValor(rset.getDouble("valor"));
			
			promocoess.add(promocoes);
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

return promocoess;
}
}