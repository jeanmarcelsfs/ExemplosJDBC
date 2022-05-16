package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conection.SingleConnection;
import model.Pessoa;

public class PessoaDAO {
	
	private Connection connection;
		public PessoaDAO() {
			connection = SingleConnection.getConnection();
		}
		
		public void inserir(Pessoa p) {
			try {
				String sql = "insert into pessoas (id, nome, email) values (?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setInt(1, p.getId());
				pst.setString(2, p.getNome());
				pst.setString(3, p.getTelefone());
				pst.execute();
				connection.commit();
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

}
