package fluent.generator.sql.where.composition;

import fluent.generator.sql.where.composition.operator.IsEqualToOperation;
import fluent.generator.sql.where.composition.operator.IsNotNullOperation;

/**
 */
public interface Element {
    IsEqualToOperation isEqualTo(String comparedProperty);
    IsNotNullOperation isNotNull();
}
