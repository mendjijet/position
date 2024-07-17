package com.jet.position.dao.implementation;

import com.jet.position.dao.CustomerDao;
import com.jet.position.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project position
 * @version 1.0
 * @author MENDJIJET
 * @since 16/07/2024
 */

@Repository
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {
    private static final String FIND_ALL_CUSTOMER = "SELECT * FROM customers";
    private final JdbcTemplate jdbcTemplate;
    private RowMapper<CustomerDto> customerRowMapper =
            (rs, name) -> new CustomerDto(rs.getInt("id"), rs.getString("email"));
    @Override
    public List<CustomerDto> search() {
        return this.jdbcTemplate.query(FIND_ALL_CUSTOMER, customerRowMapper);
    }
}
