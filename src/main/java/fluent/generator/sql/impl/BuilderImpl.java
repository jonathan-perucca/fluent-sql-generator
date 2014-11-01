package fluent.generator.sql.impl;

import fluent.generator.sql.Builder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 */
public class BuilderImpl implements Builder {

    private final String query;

    public BuilderImpl(String query) {
        this.query = checkNotNull(query).trim() + ";";
    }

    @Override
    public String build() {
        return query;
    }
}
