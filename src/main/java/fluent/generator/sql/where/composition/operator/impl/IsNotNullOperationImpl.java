package fluent.generator.sql.where.composition.operator.impl;

import fluent.generator.sql.impl.BuilderImpl;
import fluent.generator.sql.where.composition.AndComposition;
import fluent.generator.sql.where.composition.OrComposition;
import fluent.generator.sql.where.composition.impl.AndCompositionImpl;
import fluent.generator.sql.where.composition.impl.OrCompositionImpl;
import fluent.generator.sql.where.composition.operator.IsNotNullOperation;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class IsNotNullOperationImpl implements IsNotNullOperation {

    private final String query;

    public IsNotNullOperationImpl(String query) {
        this.query = checkNotNull(query) + " is not null ";
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
