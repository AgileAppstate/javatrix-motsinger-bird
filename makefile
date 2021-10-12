#
# makefile
#
# Input file for 'make' build tool ( /usr/bin/make )
# 
# @author Anthony Bird
# @version 1.0
#

JUNIT_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT_RUNNER = org.junit.platform.console.ConsoleLauncher

default:
	@echo "usage: make target"
	@echo "3 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile - builds project"
	@echo "____________________ test - runs JUnit tests"

compile: ./src/javatrix/Matrix.java ./src/MatrixTest.java ./src/Testtrix.java $(JUNIT_JAR)
	javac -cp $(JUNIT_JAR) ./src/MatrixTest.java ./src/javatrix/Matrix.java
	javac ./src/Testtrix.java ./src/javatrix/Matrix.java
	javac ./src/Driver.java ./src/javatrix/Matrix.java

clean: 
	rm -f *~
	rm -f *.class

test: ./src/javatrix/Matrix.class ./src/MatrixTest.class $(JUNIT_JAR)
	cd src; java -cp .:../$(JUNIT_JAR) $(JUNIT_RUNNER) --scan-class-path

testtrix: ./src/Testtrix.class
	cd src; java -cp . Testtrix

driver: ./src/Driver.class
	cd src; java -cp . Driver
