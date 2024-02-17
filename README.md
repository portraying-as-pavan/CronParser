# CronParser

<h2>Problem Statement</h2>
<p>Write a command line application or script which parses a cron string and expands each field
to show the times at which it will run.
The cron string will be passed to your application as a single argument.
~$ your-program "*/15 0 1,15 * 1-5 /usr/bin/find"
The output should be formatted as a table with the field name taking the first 14 columns and
the times as a space-separated list following it.
</p>

<h2>Dependencies</h2>
<p>
  Java - Programming Language </br>
  Maven - Used to build the application </br>
  Junit - Used for testing </br>
  Mockito - Used for mocking classes for testing </br>
</p>

<h2>How to Run</h2>
<p>
  Build the jar - Use `mvn clean install` to build the jar , jar will be created under target folder with name CronParser-1.0-SNAPSHOT.jar
  Execute the jar file with requierd Argument  - Example java -jar target/CronParser-1.0-SNAPSHOT.jar "1,6-10 0-23/4 1,6-9 1-6 1-3,6 /usr/find"

  voila!, you got it parsed :)

</p>
