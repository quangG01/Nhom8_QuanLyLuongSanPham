package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Connection.MyConnection;
import Entity.CongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;
public class DAO_CongNhanVien {
	private static ArrayList<CongNhanVien> dsCongNhanVien = new ArrayList<CongNhanVien>();
	public ArrayList<CongNhanVien> docTuBang(){
		try {
			Connection con = MyConnection.getInstance().getConnection();
			String sql = "select * from CongNhanVien" ;

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maCongNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String maCanCuocCongDan = rs.getString(5);
				String soDienThoai = rs.getString(6);
				String diaChi = rs.getString(7);
				boolean trangThai = rs.getBoolean(8);
				Date ngayVaoLam = rs.getDate(9);
				CongNhanVien temp = new CongNhanVien(maCongNhanVien, hoTen, gioiTinh, ngaySinh, maCanCuocCongDan, soDienThoai, diaChi, trangThai, ngayVaoLam);
				dsCongNhanVien.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCongNhanVien;		
	}
	public boolean taoCNV(CongNhanVien cnv) {
		Connection con = MyConnection.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql ="insert into CongNhanVien values(?,?,?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(2, cnv.getHoTen());
			stm.setBoolean(3, cnv.isGioiTinh());
			stm.setDate(4, cnv.getNgaySinh());
			stm.setString(5, cnv.getMaCanCuocCongDan());
			stm.setString(6, cnv.getSoDienThoai());
			stm.setString(7, cnv.getDiaChi());
			stm.setBoolean(8, cnv.isTrangThai());
			stm.setDate(9, cnv.getNgayVaoLam());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return n > 0;
	}
}
