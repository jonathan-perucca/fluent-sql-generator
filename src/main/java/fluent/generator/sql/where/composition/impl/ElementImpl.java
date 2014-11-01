package fluent.generator.sql.where.composition.impl;

import fluent.generator.sql.where.composition.Element;
import fluent.generator.sql.where.composition.operator.IsEqualToOperation;
import fluent.generator.sql.where.composition.operator.IsNotNullOperation;
import fluent.generator.sql.where.composition.operator.impl.IsEqualToOperationImpl;
import fluent.generator.sql.where.composition.operator.impl.IsNotNullOperationImpl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class ElementImpl implements Element {

    private final String query;

    public ElementImpl(String query, String property) {
        this.query = checkNotNull(query) + checkNotNull(property);
    }

    @Override
    public IsEqualToOperation isEqualTo(String comparedProperty) {
        return new IsEqualToOperationImpl(query, comparedProperty);
    }

    @Override
    public IsNotNullOperation isNotNull() {
        return new IsNotNullOperationImpl(query);
    }
}
