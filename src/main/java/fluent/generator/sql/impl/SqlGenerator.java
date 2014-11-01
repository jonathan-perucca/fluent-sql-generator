package fluent.generator.sql.impl;

import fluent.generator.sql.select.Select;
import fluent.generator.sql.Sql;
import fluent.generator.sql.select.impl.SelectImpl;

/**
 */
public class SqlGenerator implements Sql {

    private SqlGenerator() {
    }

    public static Sql sql() {
        return new SqlGenerator();
    }

    @Override
    public Select select(String selectors) {
        return new SelectImpl(selectors);
    }
}
