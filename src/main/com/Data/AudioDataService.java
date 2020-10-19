package main.com.Data;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import main.com.Models.Audio;

public class AudioDataService {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public AudioDataService() {
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	public boolean create(Audio t) {
		// TODO Auto-generated method stub
		return false;
	}
	public Audio read(Audio t) {
		// TODO Auto-generated method stub
		return null;
	}

}
