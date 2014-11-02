package fluent.generator.sql.from.composition;

import fluent.generator.sql.Builder;
import fluent.generator.sql.where.Where;

/**
 */
public interface On extends Builder{
    Join join(String table);
    Where where();
}
