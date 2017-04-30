package tp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import tp.model.*;


public class DAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public DAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Ddti get(String pmtId) {
		String sql = "SELECT * FROM transaction WHERE PmtId='" + pmtId +"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Ddti>() {

			public Ddti extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					return new Ddti(rs.getInt("Id"),
							rs.getString("Num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"),
							new Mri(rs.getString("MndtId"),rs.getString("DtOfSgntr")),
							new Fii(rs.getString("BIC")) , new Name(rs.getString("Nm")), 
							new Identification(rs.getString("IBAN")),rs.getString("RmtInf"));
				}
				
				return null;
			}
			
		});
	}

	public int getLastId() {
		return jdbcTemplate.queryForObject("select max(Id) from transaction", Integer.class);
	}

	public Stats getStats() {
		return new Stats(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM transaction", Integer.class),
				jdbcTemplate.queryForObject("SELECT ROUND(SUM(InstdAmt),2) FROM transaction", Double.class));
	}
	
	public List<Ddti> list() {
		String sql = "select * from transaction";
		List<Ddti> listTransactions = jdbcTemplate.query(sql, new RowMapper<Ddti>() {

			public Ddti mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Ddti(rs.getInt("Id"),
						rs.getString("Num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"),
						
						new Mri(rs.getString("MndtId"),rs.getString("DtOfSgntr")),
						new Fii(rs.getString("BIC")) , new Name(rs.getString("Nm")),
						new Identification(rs.getString("IBAN")),rs.getString("RmtInf"));										
			}
			
		});
		
		return listTransactions;
	}

	public void add(Ddti ddti) {
		String sql = "INSERT INTO transaction (Num, PmtId, InstdAmt, MndtId, DtOfSgntr, BIC, Nm, IBAN, RmtInf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, ddti.getNum(), ddti.getPmtId(), ddti.getInstdAmt(), 
				ddti.getDrctDbtTx().getMndtId(), 
				ddti.getDrctDbtTx().getDtOfSgntr()
				, ddti.getDbtrAgt().getBIC(), ddti.getDbtr().getNm(), 
				ddti.getDbtrAcct().getIBAN(), ddti.getRmtInf());
	}
	
	public List<Resume> listResume() {
		String sql = "SELECT * FROM transaction";
		List<Resume> listTransactions = jdbcTemplate.query(sql, new RowMapper<Resume>() {

			public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Resume(rs.getString("Num"),rs.getString("PmtId"),rs.getDouble("InstdAmt"), 
						rs.getString("DtOfSgntr"));
				
			}
			
		});
		
		return listTransactions;
	}

}
