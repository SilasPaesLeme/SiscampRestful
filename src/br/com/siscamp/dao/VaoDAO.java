package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Vao;

public class VaoDAO {

	public List<Vao> listarVao() {
		List<Vao> resultado = new ArrayList<Vao>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_vao";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Vao vao = new Vao();

				int idVao = rs.getInt("id_vao");
				vao.setIdVao(idVao);
				vao.setIdEstInicial(rs.getInt("fk_id_est_inicial"));
				vao.setIdEstFinal(rs.getInt("fk_id_est_final"));
				vao.setDistancia(rs.getFloat("vao_distancia"));
				vao.setProgressiva(rs.getFloat("vao_progressiva"));
				vao.setRegressiva(rs.getFloat("vao_regressiva"));

				resultado.add(vao);
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
