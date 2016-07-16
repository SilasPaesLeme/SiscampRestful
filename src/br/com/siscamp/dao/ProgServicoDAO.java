package br.com.siscamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.ProgServico;

public class ProgServicoDAO {

	public List<ProgServico> listarProgServico() {
		List<ProgServico> resultado = new ArrayList<ProgServico>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_progservico";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ProgServico progs = new ProgServico();

				int idProgServico = rs.getInt("id_progservico");
				progs.setIdProgServico(idProgServico);
				progs.setIdLinhaDist(rs.getInt("fk_progs_id_linhadist"));
				progs.setDescServico(rs.getString("progs_descservico"));
				progs.setSemanaExec(rs.getInt("progs_semanaexec"));
				progs.setDataExec(rs.getString("progs_dataexec"));
				progs.setQtdPessoas(rs.getInt("progs_qtdpessoas"));
				progs.setIdPle(rs.getInt("fk_progs_id_ple"));

				resultado.add(progs);
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
