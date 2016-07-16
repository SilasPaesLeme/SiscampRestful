package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.MovEstLinha;

public class MovEstLinhaDAO {

	public List<MovEstLinha> listarMovEstLinha() {
		List<MovEstLinha> resultado = new ArrayList<MovEstLinha>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from mov_est_linha";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				MovEstLinha mov = new MovEstLinha();

				int idMovEstLinha = rs.getInt("ID_MOVESTLINHA");

				mov.setIdMovEstLinha(idMovEstLinha);
				mov.setIdLinhaDist(rs.getInt("FK_MOV_ID_LINHADIST"));
				mov.setIdEstrutura(rs.getInt("FK_MOV_ID_ESTRUTURA"));
				resultado.add(mov);
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
