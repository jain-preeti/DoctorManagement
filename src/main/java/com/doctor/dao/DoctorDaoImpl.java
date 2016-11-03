package com.doctor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doctor.model.DoctorDetail;

@Repository
public class DoctorDaoImpl {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
    protected JdbcTemplate jdbc;

    public DoctorDetail getDoctorDetails(long id) {
        return jdbc.queryForObject("SELECT * FROM doctor_detail WHERE doctor_id=?", userMapper, id);
    }
	
    private static final RowMapper<DoctorDetail> userMapper = new RowMapper<DoctorDetail>() {
        public DoctorDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        	DoctorDetail doctorDetail = new DoctorDetail();
            
            return doctorDetail;
        }
    };
}
