package com.courses.phones.dao;

import com.courses.phones.Phone;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * Created by vladimir on 27.04.2015.
 */
public class PhoneDAO {
    private JdbcTemplate jdbcTemplate;

    public PhoneDAO() {}

    public PhoneDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Phone getPhoneBy(Long id) {
        final Phone phone = jdbcTemplate.queryForObject("select * from phone where ID = ?", new Object[]{id}, new RowMapper<Phone>() {
                                                        @Override
                                                        public Phone mapRow(ResultSet resultSet, int i) throws SQLException {
                                                            Phone p = new Phone();
                                                            p.setId(resultSet.getLong("id"));
                                                            p.setName(resultSet.getString("name"));
                                                            p.setPrice(resultSet.getInt("price"));
                                                            return p;
                                                        }
                                                    });
        return phone;
    }

    public Phone add(final Phone phone) {
        final String sql = "insert into phone(name, price) values (?, ?); ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement stmt = con.prepareStatement(sql, new String[] {"id"});
                        stmt.setString(1, phone.getName());
                        stmt.setInt(2, phone.getPrice());

                        return stmt;
                    }
                }, keyHolder);
//        List<SqlParameter> declaredParams = new ArrayList<>();
//        declaredParams.add(new SqlParameter(Types.VARCHAR));
//        declaredParams.add(new SqlParameter(Types.INTEGER));
//
//        PreparedStatementCreatorFactory pscFactory =
//                new PreparedStatementCreatorFactory("insert into phone(name, price) values (?, ?)", declaredParams);
//
//
//        jdbcTemplate.update(pscFactory.newPreparedStatementCreator(
//                                        new Object[] {phone.getName(), phone.getPrice()}), keyHolder);
        phone.setId(keyHolder.getKey().longValue());

        return phone;
    }

    public void update(Phone phone) {
        jdbcTemplate.update("update phone set NAME = ?, PRICE =? where ID = ?", new Object[] {phone.getName(), phone.getPrice(), phone.getId()});

    }

    public List<Phone> getAll() {
        List<Phone> phones = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from phone");
        for(Map<String, Object> row: rows) {
            Phone phone = new Phone();
            phone.setId(convertToLong(row.get("id")));
            phone.setName((String)row.get("name"));
            phone.setPrice((Integer)row.get("price"));

            phones.add(phone);
        }

        return phones;
    }

    private Long convertToLong(Object obj) {
        if(obj == null) return null;

        return Long.valueOf(obj.toString());
    }

}
