Sql Generator - Sample of fluent API
====================================

> 

This simple sql generator is a start base for Fluent Interface pattern demonstration with a sql builder

> 

Usages
------

> 

Fluent interface pattern give ability to 

* flexibly chain method calls
* looks like a workflow chained method call
* split unitary elements defining what compose the final object creation
* define optional calls
* parameterize the generator itself (not included yet)

Try it ?
--------
> 

**Sample**
```java
  class Hello {
        public static void main() {
            SqlGenerator.sql() // static constructor for generator
                .select("user.*")
                .from("User user")
                    .join("UserSettings userSettings")
                .where()
                    .element("userSettings.monitor").isEqualTo("John")
                    .and()
                    .element("userSettings.enablePref").isNotNull()
                .build();
        }
  }
```
> 

**Output**
```sql
select user.* 
from User user 
    join UserSettings userSettings 
where 
    userSettings.monitor = 'John' 
    and 
    userSettings.enablePref is not null;
```

Contact Me
----------

**via [LinkedIn]**


Links
[LinkedIn]:http://fr.linkedin.com/pub/jonathan-perucca/44/b1a/28b/
