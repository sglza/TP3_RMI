# TP3_RMI

Colocar una copia del contenido de este directorio en:

CD:\...\TP3_RMI

Para compilar utilizar la siguiente linea:

	javac -d . tp3\*.java

Para levantar el servidor de nombres (el CLASSPATH debe incluir el path de las clases del servidor):

	rmiregistry

Para ejecutar el servidor:

	java -Djava.rmi.server.codebase=file:/TP3_RMI/ tp3.Server

Para ejecutar el cliente:

	java tp3.Client
