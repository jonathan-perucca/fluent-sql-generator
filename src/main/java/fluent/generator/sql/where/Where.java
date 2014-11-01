package fluent.generator.sql.where;

import fluent.generator.sql.where.composition.Element;

/**
 */
public interface Where {
    Element element(String property);
}
