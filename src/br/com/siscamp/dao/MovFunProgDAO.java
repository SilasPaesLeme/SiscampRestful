package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.MovFunProg;

public class MovFunProgDAO {

	public List<MovFunProg> listarMovFunProg() {
		List<MovFunProg> resultado = new ArrayList<MovFunProg>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from mov_fun_prog";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				MovFunProg mov = new MovFunProg();

				int idMovFun = rs.getInt("id_mov_fun");

				mov.setIdMovFun(idMovFun);
				mov.setIdProgServico(rs.getInt("fk_mov_id_progservico"));
				mov.setIdMatricula(rs.getInt("fk_mov_matricula"));

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
