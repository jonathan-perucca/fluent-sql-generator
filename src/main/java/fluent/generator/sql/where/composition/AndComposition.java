package fluent.generator.sql.where.composition;

import fluent.generator.sql.where.Where;

/**
 */
public interface AndComposition extends Where {
    Element element(String property);
}
