package fluent.generator.sql.select.impl;

import fluent.generator.sql.from.From;
import fluent.generator.sql.impl.BuilderImpl;
import fluent.generator.sql.select.Select;
import fluent.generator.sql.from.impl.FromImpl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class SelectImpl implements Select {

    private final String query;

    public SelectImpl(String query) {
        this.query = "select " + checkNotNull(query);
    }

    @Override
    public From from(String table) {
        return new FromImpl(query, table);
    }

    @Override
    public String build() {
        return new BuilderImpl(query).build();
    }
}
