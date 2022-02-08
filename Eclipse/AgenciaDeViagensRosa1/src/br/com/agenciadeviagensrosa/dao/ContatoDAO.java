package br.com.agenciadeviagensrosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciadeviagensrosa.factory.ConnectionFactoryAgenciaDeViagensRosa;
import br.com.agenciadeviagensrosa.model.Contato;

public class ContatoDAO {

public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(local,data,valor)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getCpf());
			pstm.setString(4, contato.getTelefone());
			
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
	String sql = "DELETE FROM contatos WHERE ID = ?";
	
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

public void update(Contato contato ) {
	
	String sql = "UPDATE contatos SET nome = ?, email = ?, cpf= ? telefone = ?" + "WHERE id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, contato.getNome());
		pstm.setString(2, contato.getEmail());
		pstm.setString(3, contato.getCpf());
		pstm.setString(4, contato.getTelefone());
		
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

public List<Contato> getContatos(){
	
	String sql = "SELECT * FROM contatos";
	
	List<Contato> contatos = new ArrayList<Contato>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactoryAgenciaDeViagensRosa.createConnectionSQLServer();
		
		pstm = conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while(rset.next()) {
			
			Contato contato = new Contato();
			
			contato.setId(rset.getInt("id"));
			
			contato.setNome(rset.getString("nome"));
			
			contato.setEmail(rset.getString("email"));
			
			contato.setCpf(rset.getString("cpf"));
			
			contato.setTelefone(rset.getString("telefone"));
			
			
			
			contatos.add(contato);
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

return contatos;
}
}