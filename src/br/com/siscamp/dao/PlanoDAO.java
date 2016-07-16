package br.com.siscamp.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.siscamp.db.ConnectionFactory;
import br.com.siscamp.dto.Plano;

public class PlanoDAO {

	// public List<Blob> listarPlano() throws IOException {
	// List<Blob> resultado = new ArrayList<Blob>();
	// byte[] fileBytes;
	// Connection con = null;
	// try {
	// con = ConnectionFactory.getConnexao();
	//
	// String sql = "select * from tb_plano";
	//
	// PreparedStatement st = con.prepareStatement(sql);
	//
	// ResultSet rs = st.executeQuery();
	// if (rs.next()) {
	// fileBytes = rs.getBytes(1);
	// OutputStream targetFile = new FileOutputStream("C:");
	// targetFile.write(fileBytes);
	// targetFile.close();
	// }
	//
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (con != null) {
	// try {
	// con.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// return resultado;
	//
	// }

	// public void insertPDF(Connection conn, String filename) {
	// int len;
	// String query;
	// PreparedStatement pstmt;
	//
	// try {
	// File file = new File(filename);
	// FileInputStream fis = new FileInputStream(file);
	// len = (int) file.length();
	// query = ("insert into TableImage VALUES(?,?,?)");
	// pstmt = conn.prepareStatement(query);
	// pstmt.setString(1, file.getName());
	// pstmt.setInt(2, len);
	//
	// // method to insert a stream of bytes
	// pstmt.setBinaryStream(3, fis, len);
	// pstmt.executeUpdate();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public void getPDFDataBlob() {

		String SEPARATOR = File.separator;
		String CAMINHO_BACKUP = "C:" + SEPARATOR + "ArquivosPlanoSiscamp" + SEPARATOR;

		byte[] fileBytes;
		String query;

		for (int a = 8; a <= 19; a++) {

			try {
				query = "select * from tb_plano where fk_plano_id_linhadist =" + a;
				Connection con = null;

				con = ConnectionFactory.getConnexao();

				PreparedStatement st = con.prepareStatement(query);
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					fileBytes = rs.getBytes(2);
					OutputStream targetFile = new FileOutputStream(CAMINHO_BACKUP + "linha" + a + ".docx");
					targetFile.write(fileBytes);
					targetFile.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Plano getNomeArquivo(int idLinha) {

		String SEPARATOR = File.separator;
		String CAMINHO_ARQUIVO = "C:" + SEPARATOR + "ArquivosPlanoSiscamp" + SEPARATOR;
		Plano arq = new Plano();

		String query;

		try {
			query = "select * from tb_plano where fk_plano_id_linhadist =" + idLinha;
			Connection con = null;

			con = ConnectionFactory.getConnexao();

			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				arq.setCaminho(CAMINHO_ARQUIVO + rs.getString("plano_nome"));
				arq.setArquivo(rs.getString("plano_nome"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arq;
	}

	public List<Plano> listarPlanos() {
		List<Plano> resultado = new ArrayList<Plano>();

		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();
			String sql = "select * from tb_plano";

			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Plano plano = new Plano();

				int idLinha = rs.getInt("fk_plano_id_linhadist");

				plano.setIdLinha(idLinha);
				plano.setArquivo(rs.getString("plano_nome"));
				plano.setVersao(rs.getInt("plano_versao"));

				resultado.add(plano);
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

	public Plano listarPlanosOld(String str) {
		Plano plano = new Plano();
		Connection con = null;
		try {
			con = ConnectionFactory.getConnexao();

			String sql = "select * from tb_plano";
			if (str != null) {
				sql += " where fk_plano_id_linhadist = ?";
			}

			PreparedStatement st = con.prepareStatement(sql);
			if (str != null) {
				st.setString(1, str);
			}

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idLinha = rs.getInt("fk_plano_id_linhadist");

				plano.setIdLinha(idLinha);
				plano.setArquivo(rs.getString("plano_nome"));
				plano.setVersao(rs.getInt("plano_versao"));

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

		return plano;
	}

}
