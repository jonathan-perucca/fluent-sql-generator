package fluent.generator.sql.where.composition.operator.impl;

import com.google.common.base.Joiner;
import fluent.generator.sql.impl.BuilderImpl;
import fluent.generator.sql.where.composition.AndComposition;
import fluent.generator.sql.where.composition.OrComposition;
import fluent.generator.sql.where.composition.impl.AndCompositionImpl;
import fluent.generator.sql.where.composition.impl.OrCompositionImpl;
import fluent.generator.sql.where.composition.operator.IsEqualToOperation;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class IsEqualToOperationImpl implements IsEqualToOperation {

    private final String query;

    public IsEqualToOperationImpl(String query, String comparedProperty) {
        this.query = Joiner.on(" = ").join(checkNotNull(query), checkNotNull("'" + comparedProperty + "'"));
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
