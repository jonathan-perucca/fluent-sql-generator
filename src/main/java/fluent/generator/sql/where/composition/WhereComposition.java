package fluent.generator.sql.where.composition;

import fluent.generator.sql.Builder;

/**
 */
public interface WhereComposition extends Builder {
    AndComposition and();
    OrComposition or();
}
