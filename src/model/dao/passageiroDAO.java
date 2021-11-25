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
			stmt.setString(7, f.getTelefone());
			
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
				f.setId_passageiro(rs.getInt("id_passageiro"));
				f.setNome(rs.getString("nome"));
				f.setGenero(rs.getBoolean("genero"));
				f.setRg(rs.getString("rg"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getString("telefone"));
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
			stmt = con.prepareStatement("DELETE  FROM passageiro WHERE id_passageiro=?");
			stmt.setInt(1, f.getId_passageiro()); 
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Passageiro excuido com sucesso!");
		}catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
			
		}finally {
			
			connectionFactory.closeConnection(con, stmt);
			
		}
		
	}
	
	
}
