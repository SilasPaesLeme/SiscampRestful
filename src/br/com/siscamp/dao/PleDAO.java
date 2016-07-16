package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Ple;

public class PleDAO {

	public List<Ple> listarPle() {
		List<Ple> resultado = new ArrayList<Ple>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_ple";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Ple ple = new Ple();

				int idPle = rs.getInt("id_ple");
				ple.setIdPle(idPle);
				ple.setSupervisor(rs.getString("ple_supervisor"));
				ple.setData(rs.getString("ple_data"));
				ple.setHrInicial(String.valueOf(rs.getTime("ple_hrinicial")));
				ple.setHrFinal(String.valueOf(rs.getTime("ple_hrfinal")));
				ple.setIdLinhaDist(rs.getInt("fk_ple_id_linhadist"));

				resultado.add(ple);
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
