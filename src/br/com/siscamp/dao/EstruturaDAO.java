package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Estrutura;

public class EstruturaDAO {

	public List<Estrutura> listarEstruturas(String str) {
		List<Estrutura> resultado = new ArrayList<Estrutura>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_estrutura";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Estrutura estrutura = new Estrutura();

				int idEstrutura = rs.getInt("id_estrutura");

				estrutura.setIdEstrutura(idEstrutura);
				estrutura.setNumero(rs.getString("est_numero"));
				estrutura.setModelo(rs.getString("est_modelo"));
				estrutura.setTipo(rs.getString("est_tipo"));
				estrutura.setAltura(rs.getString("est_altura"));

				resultado.add(estrutura);
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
