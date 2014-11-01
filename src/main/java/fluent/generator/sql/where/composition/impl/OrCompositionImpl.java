package fluent.generator.sql.where.composition.impl;

import fluent.generator.sql.where.composition.Element;
import fluent.generator.sql.where.composition.OrComposition;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class OrCompositionImpl implements OrComposition {

    private final String query;

    public OrCompositionImpl(String query) {
        this.query = checkNotNull(query) + " or ";
    }

    @Override
    public Element element(String property) {
        return new ElementImpl(query, property);
    }
}
