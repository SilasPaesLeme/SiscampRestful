package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Sobreaviso;

public class SobreavisoDAO {

	public List<Sobreaviso> listarSobreaviso() {
		List<Sobreaviso> resultado = new ArrayList<Sobreaviso>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_sobreaviso";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Sobreaviso sobreaviso = new Sobreaviso();

				int idSobreaviso = rs.getInt("id_sobreaviso");
				sobreaviso.setIdSobreaviso(idSobreaviso);
				sobreaviso.setFuncMatricula(rs.getInt("fk_func_matricula"));
				sobreaviso.setData(rs.getString("sobreaviso_data"));

				resultado.add(sobreaviso);
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
