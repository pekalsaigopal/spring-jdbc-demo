package in.psg.sjt.dao;

import in.psg.sjt.model.Office;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class OfficeDao implements Dao<Office> {

    private static final Logger logger = LoggerFactory.getLogger(Office.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Office> rowMapper = (rs, rowNum) -> {
        Office office = new Office();
        office.setOfficeCode(rs.getString("officeCode"));
        office.setCity(rs.getString("city"));
        office.setPhone(rs.getString("phone"));
        office.setAddressLine1(rs.getString("addressLine1"));
        office.setAddressLine2(rs.getString("addressLine2"));
        office.setState(rs.getString("state"));
        office.setCountry(rs.getString("country"));
        office.setPostalCode(rs.getString("postalCode"));
        office.setTeritory(rs.getString("territory"));
        return office;
    };

    @Autowired
    private void setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Office> list() {
        String sql = "SELECT officeCode, city,phone,addressLine1,addressLine2,state,country,postalCode,territory from offices";
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void create(Office office) {

    }

    @Override
    public Optional<Office> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Office office, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
