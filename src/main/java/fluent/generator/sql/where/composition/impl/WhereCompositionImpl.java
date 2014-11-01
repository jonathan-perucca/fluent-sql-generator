package fluent.generator.sql.where.composition.impl;

import fluent.generator.sql.impl.BuilderImpl;
import fluent.generator.sql.where.composition.AndComposition;
import fluent.generator.sql.where.composition.OrComposition;
import fluent.generator.sql.where.composition.WhereComposition;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class WhereCompositionImpl implements WhereComposition {

    private final String query;

    public WhereCompositionImpl(String query) {
        this.query = checkNotNull(query);
    }

    @Override
    public AndComposition and() {
        return new AndCompositionImpl(query);
    }

    @Override
    public OrComposition or() {
        return new OrCompositionImpl(query);
    }

    @Override
    public String build() {
        return new BuilderImpl(query).build();
    }
}
