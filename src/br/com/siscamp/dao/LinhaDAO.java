package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Linha;

public class LinhaDAO {

	public List<Linha> listarLinhas(String str) {
		List<Linha> resultado = new ArrayList<Linha>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_linhadistribuicao";
			if (str != null) {
				sql += " where linhadist_nomenclatura like ?";
			}

			PreparedStatement st = con.prepareStatement(sql);
			if (str != null) {
				st.setString(1, "%" + str + "%");
			}

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Linha linha = new Linha();

				int idLinha = rs.getInt("id_linhadist");

				linha.setId(idLinha);
				linha.setNomenclatura(rs.getString("linhadist_nomenclatura"));
				linha.setCaboCond(rs.getString("linhadist_cabopraio"));
				linha.setCaboRaio(rs.getString("linhadist_cabocond"));
				linha.setLargFaixa(rs.getInt("linhadist_largfaixa"));

				resultado.add(linha);
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
