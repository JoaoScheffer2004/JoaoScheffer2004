package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.connectionFactory;
import model.bean.passageiro;

public class passageiroDAO {

	public void create(passageiro f) {
		Connection con = connectionFactory.getConnection(); 
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO passageiro (nome, genero, rg, cpf, endereco, email, telefone) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setBoolean(2, f.getGenero());
			stmt.setString(3, f.getRg());
			stmt.setString(4, f.getCpf());
			stmt.setString(5, f.getEndereco());
			stmt.setString(6, f.getEmail());
			stmt.setLong(7, f.getTelefone());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar" + e);
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
		
	public List<passageiro> read() {
		
		Connection con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<passageiro> passageiros = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM  passageiro");
			rs = stmt.executeQuery();
			while(rs.next()) {
				passageiro f = new passageiro();
				f.setId_passageiro(rs.getInt("idpassageiro"));
				f.setNome(rs.getString("nome"));
				f.setGenero(rs.getBoolean("genero"));
				f.setRg(rs.getString("rg"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getLong("telefone"));
				passageiros.add(f);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao exibir as informaes do BD" + e);
			e.printStackTrace();
		}finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
		return passageiros;
	}
	
	public void delete(passageiro f) {
		
		Connection con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE  FROM passageiro WHERE idpassageiro=?");
			stmt.setInt(1, f.getId_passageiro()); 
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Passageiro excuido com sucesso!");
		}catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
			
		}finally {
			
			connectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	public passageiro read(int id) {
		Connection con = connectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		passageiro f = new passageiro();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM passageiro WHERE idpassageiro=? LIMIT 1;");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {   
				f.setId_passageiro(rs.getInt("idpassageiro"));
				f.setNome(rs.getString("nome"));
				f.setGenero(rs.getBoolean("genero"));
				f.setRg(rs.getString("rg"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getLong("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
		return f;
	}
	
	public void update(passageiro f) {
		Connection con = connectionFactory.getConnection(); 
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE passageiro SET nome=?, genero=?, rg=?, cpf=?, endereco=?, email=?, telefone=? WHERE idpassageiro=?;");
			stmt.setString(1, f.getNome());
			stmt.setBoolean(2, f.getGenero());
			stmt.setString(3, f.getRg());
			stmt.setString(4, f.getCpf());
			stmt.setString(5, f.getEndereco());
			stmt.setString(6, f.getEmail());
			stmt.setLong(7, f.getTelefone());
			stmt.setInt(8, f.getId_passageiro());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar" + e);
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
		

	
}
