JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Utils.java \
    Logs.java \
    DataReader.java \
    BarChart.java \
	DataAnalyzer.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	$(RM) Logs.txt
