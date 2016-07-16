package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Contato;

public class ContatoDAO {

	public List<Contato> listarContatos() {
		List<Contato> resultado = new ArrayList<Contato>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();
			String sql = "select * from tb_contatos";
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();

				int idContato = rs.getInt("id_contato");

				contato.setIdContato(idContato);
				contato.setNome(rs.getString("contato_nome"));
				contato.setEspecialidade(rs.getString("contato_espec"));
				contato.setTel1(rs.getString("contato_tel1"));
				contato.setTel2(rs.getString("contato_tel2"));
				contato.setCidade(rs.getString("contato_cidade"));
				contato.setEnd(rs.getString("contato_end"));

				resultado.add(contato);
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
}
