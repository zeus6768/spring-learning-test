package cholog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryingDAO {
    private JdbcTemplate jdbcTemplate;

    public QueryingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Customer> customerRowMapper = (resultSet, rowNum) -> new Customer(
            resultSet.getLong("id"),
            resultSet.getString("first_name"),
            resultSet.getString("last_name")
    );

    /**
     * public <T> T queryForObject(String sql, Class<T> requiredType)
     */
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from customers", Integer.class);
    }

    /**
     * public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args)
     */
    public String getLastName(Long id) {
        return jdbcTemplate.queryForObject("select last_name from customers where id = ?", String.class, id);
    }

    /**
     * public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     */
    public Customer findCustomerById(Long id) {
        return jdbcTemplate.queryForObject(
                "select id, first_name, last_name from customers where id = ?",
                customerRowMapper,
                id
        );
    }

    /**
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper)
     */
    public List<Customer> findAllCustomers() {
        return jdbcTemplate.query(
                "select id, first_name, last_name from customers",
                customerRowMapper
        );
    }

    /**
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     */
    public List<Customer> findCustomerByFirstName(String firstName) {
        //TODO : firstName을 기준으로 customer를 list형태로 반환
        return jdbcTemplate.query(
                "select id, first_name, last_name from customers where first_name = ?",
                customerRowMapper,
                firstName
        );
    }
}
