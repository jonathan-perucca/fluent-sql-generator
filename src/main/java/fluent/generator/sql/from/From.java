package fluent.generator.sql.from;

import fluent.generator.sql.Builder;
import fluent.generator.sql.from.composition.Join;
import fluent.generator.sql.where.Where;

/**
 */
public interface From extends Builder {
    Join join(String table);
    Where where();
}
