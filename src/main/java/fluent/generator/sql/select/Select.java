package fluent.generator.sql.select;

import fluent.generator.sql.Builder;
import fluent.generator.sql.from.From;

public interface Select extends Builder {
    From from(String table);
}
