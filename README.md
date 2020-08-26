### FAQ - how to execute tests

local execution as usual via any IDE or from command line
    all test

    mvn clean compile test site

specific class name

    mvn clean compile test site -Dtest=[className]
    e.g. mvn clean compile test site -Dtest=UserTests


comment / uncomment configuration section under maven-surefire-plugin 