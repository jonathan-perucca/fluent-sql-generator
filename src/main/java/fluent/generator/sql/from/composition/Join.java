package fluent.generator.sql.from.composition;

import fluent.generator.sql.from.From;

/**
 */
public interface Join extends From {
    On on(String element);
}
