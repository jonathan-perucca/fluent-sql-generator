package fluent.generator.sql.where.impl;

import fluent.generator.sql.where.composition.Element;
import fluent.generator.sql.where.Where;
import fluent.generator.sql.where.composition.impl.ElementImpl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class WhereImpl implements Where {

    private final String query;

    public WhereImpl(String query) {
        this.query = checkNotNull(query) + " where ";
    }

    @Override
    public Element element(String property) {
        return new ElementImpl(query, property);
    }
}
