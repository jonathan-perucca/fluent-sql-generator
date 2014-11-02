package fluent.generator.sql.from.composition.impl;

import com.google.common.base.Preconditions;
import fluent.generator.sql.from.composition.Join;
import fluent.generator.sql.from.composition.On;
import fluent.generator.sql.impl.BuilderImpl;
import fluent.generator.sql.where.Where;
import fluent.generator.sql.where.impl.WhereImpl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class OnImpl implements On{

    private final String query;

    public OnImpl(String query, String element) {
        this.query = checkNotNull(query) + " on " + checkNotNull(element);
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
