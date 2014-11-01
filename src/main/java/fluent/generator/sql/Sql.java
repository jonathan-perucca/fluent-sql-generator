package fluent.generator.sql;

import fluent.generator.sql.select.Select;

/**
 */
public interface Sql {
    Select select(String selectors);
}
