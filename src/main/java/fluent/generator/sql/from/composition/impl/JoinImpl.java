package fluent.generator.sql.from.composition.impl;

import com.google.common.base.Joiner;
import fluent.generator.sql.from.composition.Join;
import fluent.generator.sql.where.Where;
import fluent.generator.sql.impl.BuilderImpl;
import fluent.generator.sql.where.impl.WhereImpl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class JoinImpl implements Join {

    private final String query;

    public JoinImpl(String query, String table) {
        this.query = Joiner.on(" join ").join(checkNotNull(query), checkNotNull(table));
    }

    @Override
    public Join join(String table) {
        return new JoinImpl(query, table);
    }

    @Override
    public Where where() {
        return new WhereImpl(query);
    }

    @Override
    public String build() {
        return new BuilderImpl(query).build();
    }
}
