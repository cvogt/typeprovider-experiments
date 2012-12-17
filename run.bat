SET JARCACHE=C:\Users\Chris\.ivy2\cache\
SET CP=%JARCACHE%org.slf4j\slf4j-api\jars\slf4j-api-1.6.4.jar;%JARCACHE%com.h2database\h2\jars\h2-1.3.166.jar;%JARCACHE%org.slf4j\slf4j-nop\jars\slf4j-nop-1.6.4.jar;D:\work\slick\target\scala-2.10.0-RC3\slick_2.10.0-RC3-1.1.0-SNAPSHOT.jar;.
SET SCALA=..\scala-2.10.0-RC1\bin\
cmd /c %SCALA%scalac -cp %CP% Typeprovider.scala
%SCALA%scala -cp %CP% Typeprovider
