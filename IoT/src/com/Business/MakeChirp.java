package com.Business;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Models.Chirp;


@Component
public class MakeChirp {

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void MakeRandomChirp() {
		double randDuation = Math.random(); //get random ducation such that 0 < duration < 1.0 ; I went this way because I figured 1 second was long enough for a bird chrip
        double randAmplitude = Math.random() * (70 - 10) + 10; // get random amplitude such that 10 < amplitude < 70 ; measured in Decibels
        int randFrequency = (int) Math.random() * (20000 - 1667) + 1667; // get frequency such that 1667 < frequency < 20000 ; measured in Hertz

        //create Chirp as DTO
        Chirp chirp = new Chirp(randDuation, randAmplitude, randFrequency);

        //save chirp to database
        this.jdbcTemplate.update(chirp.generateInsertSQL());
	}
	
	
	
}
