package ProjectHouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;



public class WareHouse1DAO {
	
	public Vector listWare() {
		Vector items = new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.oraConn();
			String sql="select num,name,company,amount,price,volume "
					+ " from warehouse1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row=new Vector();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String company=rs.getString("company");
				int amount=rs.getInt("amount");
				int price=rs.getInt("price");
				int volume=rs.getInt("volume");
				row.add(num);
				row.add(name);
				row.add(company);
				row.add(amount);
				row.add(price);
				row.add(volume);
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return items;
	}
	
	public int insertWare(WareHouse1DTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.oraConn();
			String sql="insert into warehouse1 values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getCompany());
			pstmt.setInt(4, dto.getAmount());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setInt(6, dto.getVolume());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteWare(String num) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.oraConn();
			String sql="delete warehouse1 where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int UpdateWare(WareHouse1DTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.oraConn();
			String sql="update warehouse1 set name=?, company=?, amount=?, price=?, volume=? "
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getCompany());
			pstmt.setInt(3, dto.getAmount());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, dto.getVolume());
			pstmt.setString(6, dto.getNum());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int sumWare(WareHouse1DTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.oraConn();
			String sql="select sum(volume) from warehouse1";
			pstmt=conn.prepareStatement(sql);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

}
