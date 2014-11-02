package fluent;

import fluent.generator.sql.Sql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class GeneratorSqlTest {

    private final String selectOne = "select 1;";
    private final String selectUsers = "select * from User;";
    private final String selectUsersUsingJoins = "select user.* from User user join UserSettings userSettings join UserConfig userConfig;";
    private final String selectUsersUsingJoinsOn = "select user.* from User user join UserConfig userConfig on userConfig.userConfigId = user.userConfigId join UserSettings userSettings on userSettings.userSettingsId = user.userSettingsId;";
    private final String selectUsersWhereMonitorEquals = "select user.* from User user join UserSettings userSettings where userSettings.monitor = 'John';";
    private final String selectUsersWhereMonitorEqualsAndEnableprefNotnull = "select user.* from User user join UserSettings userSettings where userSettings.monitor = 'John' and userSettings.enablePref is not null;";
    private final String selectUsersWhereFirstnameEqualsOrLastnameEquals = "select user.* from User user where user.firstname = 'John' or user.lastname = 'Smith';";

    @Autowired
    private Sql sql;

    @Test
	public void fluentApiDesignTestRuntimeOk() {
        sql.select("1")
           .build();

        sql.select("*")
           .from("User")
           .build();

        sql.select("user.*")
           .from("User user")
                .join("UserSettings userSettings")
                .join("UserConfig userConfig")
           .build();

        sql.select("user.*")
           .from("User user")
                .join("UserSettings userSettings")
           .where()
                .element("userSettings.monitor").isEqualTo("John")
           .build();

        sql.select("user.*")
           .from("User user")
                .join("UserSettings userSettings")
           .where()
                .element("userSettings.monitor").isEqualTo("John")
                    .and()
                .element("userSettings.enablePref").isNotNull()
           .build();
	}

    @Test
    public void selectOne() {
        String query = sql.select("1").build();

        assertThat(query, is(selectOne));
    }

    @Test
    public void selectUsers() {
        String query = sql.select("*")
                          .from("User")
                          .build();

        assertThat(query, is(selectUsers));
    }

    @Test
    public void selectUsersWhereFirstnameEqualsOrLastnameEquals() {
        String query = sql.select("user.*")
                          .from("User user")
                          .where()
                              .element("user.firstname").isEqualTo("John")
                              .or()
                              .element("user.lastname").isEqualTo("Smith")
                          .build();
        assertThat(query, is(selectUsersWhereFirstnameEqualsOrLastnameEquals));
    }

    @Test
    public void selectUsersUsingJoins() {
        String query = sql.select("user.*")
                          .from("User user")
                              .join("UserSettings userSettings")
                              .join("UserConfig userConfig")
                          .build();

        assertThat(query, is(selectUsersUsingJoins));
    }

    @Test
    public void selectUsersUsingJoinsOn() {
        String query = sql.select("user.*")
           .from("User user")
                .join("UserConfig userConfig").on("userConfig.userConfigId = user.userConfigId")
                .join("UserSettings userSettings").on("userSettings.userSettingsId = user.userSettingsId")
           .build();

        assertThat(query, is(selectUsersUsingJoinsOn));
    }

    @Test
    public void selectUsersWhereMonitorEquals() {
        String query = sql.select("user.*")
                          .from("User user")
                              .join("UserSettings userSettings")
                          .where()
                              .element("userSettings.monitor").isEqualTo("John")
                          .build();

        assertThat(query, is(selectUsersWhereMonitorEquals));
    }

    @Test
    public void selectUsersWhereMonitorEqualsAndEnableprefNotnull() {
        String query = sql.select("user.*")
                          .from("User user")
                              .join("UserSettings userSettings")
                          .where()
                              .element("userSettings.monitor").isEqualTo("John")
                                  .and()
                              .element("userSettings.enablePref").isNotNull()
                          .build();

        assertThat(query, is(selectUsersWhereMonitorEqualsAndEnableprefNotnull));
    }
}
