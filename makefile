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

compile: ./Matrix.java ./MatrixTest.java $(JUNIT_JAR)
	javac -cp $(JUNIT_JAR) MatrixTest.java Matrix.java

clean: 
	rm -f *~
	rm -f *.class

test: ./Matrix.class ./MatrixTest.class $(JUNIT_JAR)
	java -cp $(JUNIT_JAR) $(JUNIT_RUNNER) --scan-class-path
