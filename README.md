# What is this?
This is an example of how one can crash an HBase region server with a custom filter. It simply runs the region server out of memory.

# To build the JAR:
Simply run the following to build:
`mvn package`

# To deploy workflow:
One will deploy the filter by copying the built JAR in `target/CrashFilter-0.0.1-SNAPSHOT.jar` to their HBase region server `lib` directory. Then restart the region server.

# To crash your region server
One will need to run the filter to crash the region server; to do this, one can request the filter via:
`echo 'scan "hbase:meta", {FILTER=> com.bloomberg.hbase.CrashFilter.new()}' | hbase shell`

One will see the following upon running out of resources (crashing):
* From `hbase shell`:
```
scan "hbase:meta", {FILTER=> com.bloomberg.hbase.CrashFilter.new()}
ROW                   COLUMN+CELL

ERROR: Call id=0, waitTime=59996, operationTimeout=59995 expired.
```
* In the standard error log of the RegionServer hosting `hbase:meta`: `java.lang.OutOfMemoryError: Java heap space` (After that the regionserver will exit if configured ot exit on out of memory.)

# Thanks
Thanks to Lars George for his custom filter example at https://github.com/larsgeorge/hbase-book/blob/cbb4bd05e30fb7956e43d7327ca7086c0578e8e2/ch04/src/main/java/filters/CustomFilter.java
