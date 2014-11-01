package fluent.generator.sql.where.composition.impl;

import fluent.generator.sql.where.composition.Element;
import fluent.generator.sql.where.composition.AndComposition;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class AndCompositionImpl implements AndComposition {

    private final String query;

    public AndCompositionImpl(String query) {
        this.query = checkNotNull(query) + " and ";
    }

    @Override
    public Element element(String property) {
        return new ElementImpl(query, property);
    }
}
