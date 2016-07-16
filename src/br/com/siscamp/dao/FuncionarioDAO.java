package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Funcionario;
import br.com.siscamp.util.Criptografia;

public class FuncionarioDAO {

	public List<Funcionario> listarFuncionarios() {
		List<Funcionario> resultado = new ArrayList<Funcionario>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_funcionario";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();

				int idFuncionario = rs.getInt("matricula");

				funcionario.setMatricula(idFuncionario);
				funcionario.setNome(rs.getString("func_nome"));
				funcionario.setTel(rs.getString("func_telpessoal"));

				resultado.add(funcionario);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return resultado;
	}
	
	public static Funcionario validarLogin(String usuario, String senha) {
		Funcionario user = null;
		
		Criptografia pass = new Criptografia();
		String senhasegura = pass.Criptografar(senha);

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_funcionario where func_login = ? and func_senha = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, usuario);
			st.setString(2, senhasegura);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new Funcionario();

				user.setMatricula(rs.getInt("matricula"));
				user.setLogado(true);
				user.setLogin(rs.getString("func_login"));
				user.setSenha(rs.getString("func_senha"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return user;
	}
}
